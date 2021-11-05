package br.sasclient.swing.msg;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.sasclient.entity.Ocorrencia;
import br.sasclient.service.ServiceClient;
import br.sasclient.swing.TelaJD;
import br.sasclient.swing.paginas.Ocorrencias;
import java.awt.Font;

public class JPanelConfirmar extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private static int codigo_colaborador;
	private int i = 0;
	private static TelaJD jd;
	private Ocorrencia ocorrencia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JPanelConfirmar dialog = new JPanelConfirmar(codigo_colaborador, jd);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JPanelConfirmar(int codigo_colaborador, TelaJD jd) {
		setUndecorated(true);
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 355, 167);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(42, 153, 208));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setCodigo_colaborador(codigo_colaborador);
		
		JPanelConfirmar.jd = jd;

		Toolkit toolkit = getToolkit();
		Dimension d = toolkit.getScreenSize();
		setLocation(d.width / 2 - getWidth() / 2, d.height / 2 - getHeight() / 2);

		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel
					.setIcon(new ImageIcon(JPanelConfirmar.class.getResource("/br/sasclient/imagens/background5.jpg")));
			lblNewLabel.setBounds(0, 0, 355, 48);
			contentPanel.add(lblNewLabel);
		}
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(JPanelConfirmar.class.getResource("/javax/swing/plaf/metal/icons/Warn.gif")));
		lblNewLabel_1.setBounds(24, 47, 38, 87);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("OK - Para finalizar");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setBounds(105, 59, 240, 14);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Ocorrência - Para registrar ocorrências");
		lblNewLabel_2_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel_2_1.setForeground(Color.BLACK);
		lblNewLabel_2_1.setBounds(105, 85, 240, 14);
		contentPanel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Sair - Cancelar");
		lblNewLabel_2_1_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel_2_1_1.setForeground(Color.BLACK);
		lblNewLabel_2_1_1.setBounds(105, 110, 240, 14);
		contentPanel.add(lblNewLabel_2_1_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(42, 153, 208));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton Ok = new JButton("OK");
				Ok.addMouseListener(new MouseAdapter() {
					@SuppressWarnings("deprecation")
					@Override
					public void mouseClicked(MouseEvent e) {
						i = 1;
						new ServiceClient().ExcluirTelaPorCodigo(getCodigo_colaborador());
						JPanelConfirmar.this.hide();
					}
				});
				Ok.setActionCommand("Cancel");
				buttonPane.add(Ok);
			}
			{
				JButton Ocorrencia = new JButton("Ocorrência");
				Ocorrencia.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						Ocorrencias ocorrencias = new Ocorrencias(JPanelConfirmar.this);
						ocorrencias.setVisible(true);
						new Thread() {
							@SuppressWarnings("deprecation")
							public void run() {
								while (ocorrencias.isVisible()) {
								}
								jd.setOcorrencia(ocorrencia);
								JPanelConfirmar.this.hide();
							};
						}.start();
					}
				});
				Ocorrencia.setActionCommand("OK");
				buttonPane.add(Ocorrencia);
				getRootPane().setDefaultButton(Ocorrencia);
			}
			{
				JButton sair = new JButton("Sair");
				sair.addMouseListener(new MouseAdapter() {
					@SuppressWarnings("deprecation")
					@Override
					public void mouseClicked(MouseEvent e) {
						JPanelConfirmar.this.hide();
					}
				});
				sair.setActionCommand("Cancel");
				buttonPane.add(sair);
			}
		}
	}

	public static int getCodigo_colaborador() {
		return codigo_colaborador;
	}

	public static void setCodigo_colaborador(int codigo_colaborador) {
		JPanelConfirmar.codigo_colaborador = codigo_colaborador;
	}

	public int confirmacao() {
		return i;
	}
	
	public void setOcorrencia(Ocorrencia ocorrencia) {
		this.ocorrencia = ocorrencia;
	}
}
