package br.sasclient.swing.msg;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class JPanelConfirmarOcorrencia extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private int confirmacao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JPanelConfirmarOcorrencia dialog = new JPanelConfirmarOcorrencia();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JPanelConfirmarOcorrencia() {
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 358, 192);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		Toolkit toolkit = getToolkit();
		Dimension d = toolkit.getScreenSize();
		setLocation(d.width / 2 - getWidth() / 2, d.height / 2 - getHeight() / 2);
		
		JPanel contentPanel_1 = new JPanel();
		contentPanel_1.setLayout(null);
		contentPanel_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel_1.setBackground(new Color(42, 153, 208));
		contentPanel_1.setBounds(0, 0, 355, 134);
		contentPanel.add(contentPanel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(JPanelConfirmarOcorrencia.class.getResource("/br/sasclient/imagens/background5.jpg")));
		lblNewLabel.setBounds(0, 0, 355, 48);
		contentPanel_1.add(lblNewLabel);
		{
			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(JPanelConfirmarOcorrencia.class.getResource("/javax/swing/plaf/metal/icons/Warn.gif")));
			lblNewLabel_1.setBounds(31, 48, 46, 86);
			contentPanel_1.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("OK - Para finalizar ocorrência");
			lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 13));
			lblNewLabel_2.setBounds(87, 61, 258, 14);
			contentPanel_1.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Cancelar - Cancela e retornar");
			lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 13));
			lblNewLabel_2.setBounds(87, 109, 258, 14);
			contentPanel_1.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Descrição - Adicionar comentários");
			lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 13));
			lblNewLabel_2.setBounds(87, 86, 258, 14);
			contentPanel_1.add(lblNewLabel_2);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(42, 153, 208));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addMouseListener(new MouseAdapter() {
					@SuppressWarnings("deprecation")
					@Override
					public void mouseClicked(MouseEvent e) {
						confirmacao = 1;
						JPanelConfirmarOcorrencia.this.hide();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addMouseListener(new MouseAdapter() {
					@SuppressWarnings("deprecation")
					@Override
					public void mouseClicked(MouseEvent e) {
						confirmacao = 0;
						JPanelConfirmarOcorrencia.this.hide();
					}
				});
				{
					JButton btn_descricao = new JButton("Descrição");
					btn_descricao.addMouseListener(new MouseAdapter() {
						@SuppressWarnings("deprecation")
						@Override
						public void mouseClicked(MouseEvent e) {
							confirmacao = 2;
							JPanelConfirmarOcorrencia.this.hide();
						}
					});
					btn_descricao.setActionCommand("OK");
					buttonPane.add(btn_descricao);
				}
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public int getConfirmação() {
		return confirmacao;
	}
}
