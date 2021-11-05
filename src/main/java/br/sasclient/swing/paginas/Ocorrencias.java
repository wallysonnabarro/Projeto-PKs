package br.sasclient.swing.paginas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import br.sasclient.entity.Ocorrencia;
import br.sasclient.service.ServiceClient;
import br.sasclient.swing.miniocorrencia.InstanciaOcorrenciaUtil;
import br.sasclient.swing.msg.JPanelConfirmar;

public class Ocorrencias extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private final JPanel view1;
	private final JPanel view2;
	private final JPanel view3;
	private final JLayeredPane layeredPane = new JLayeredPane();
	private int seta = 0;
	private List<Ocorrencia> ocorrencias;
	private Ocorrencia ocorrencia;
	private static JPanelConfirmar confirmar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Ocorrencias dialog = new Ocorrencias(confirmar);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Ocorrencias(JPanelConfirmar confirmar) {
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 662, 517);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		Ocorrencias.confirmar = confirmar;

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 656, 425);
		contentPanel.add(panel);
		panel.setLayout(null);

		layeredPane.setBounds(10, 11, 637, 403);
		panel.add(layeredPane);
		layeredPane.setLayout(null);

		view1 = new JPanel();
		view1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		view1.setBackground(Color.LIGHT_GRAY);
		view1.setBounds(0, 0, 637, 403);
		layeredPane.add(view1);
		view1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		view2 = new JPanel();
		view2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		view2.setBackground(Color.LIGHT_GRAY);
		view2.setBounds(0, 0, 637, 403);
		layeredPane.add(view2);
		view2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		view3 = new JPanel();
		view3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		view3.setBackground(Color.LIGHT_GRAY);
		view3.setBounds(0, 0, 637, 403);
		layeredPane.add(view3);
		view3.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		JLabel lbl_direita = new JLabel("");
		lbl_direita.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (seta == 0 && ocorrencias.size() >= 40) {
					view1.setVisible(false);
					view2.setVisible(true);
					view3.setVisible(false);
					seta = 1;
				} else if (seta == 1 && ocorrencias.size() >= 80) {
					view1.setVisible(false);
					view2.setVisible(false);
					view3.setVisible(true);
					seta = 2;
				}
			}
		});
		lbl_direita.setIcon(
				new ImageIcon(Ocorrencias.class.getResource("/br/sasclient/imagens/seta_direita_26px_laranja.png")));
		lbl_direita.setBounds(606, 428, 40, 49);
		contentPanel.add(lbl_direita);

		JLabel lbl_esquerda = new JLabel("");
		lbl_esquerda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (seta == 2) {
					view1.setVisible(false);
					view2.setVisible(true);
					view3.setVisible(false);
					seta = 1;
				} else if (seta == 1) {
					view1.setVisible(true);
					view2.setVisible(false);
					view3.setVisible(false);
					seta = 0;
				}
			}
		});
		lbl_esquerda.setIcon(
				new ImageIcon(Ocorrencias.class.getResource("/br/sasclient/imagens/seta_esquerda_26px_laranja.png")));
		lbl_esquerda.setBounds(564, 428, 40, 49);
		contentPanel.add(lbl_esquerda);

		Toolkit toolkit = getToolkit();
		Dimension d = toolkit.getScreenSize();
		setLocation(d.width / 2 - getWidth() / 2, d.height / 2 - getHeight() / 2);

		getOcorrencias();
	}

	private void getOcorrencias() {
		ocorrencias = new ServiceClient().ConsultarTodasOcorrencias();
		view1.setVisible(true);
		view2.setVisible(false);
		view3.setVisible(false);

		for (int i = 0; i < ocorrencias.size(); i++) {
			ocorrencia = ocorrencias.get(i);
			if (i < 40) {
				view1.add(new InstanciaOcorrenciaUtil().getMiniOcorrencia(i, ocorrencia, this));
			} else if (i >= 40 && i < 80) {
				view2.add(new InstanciaOcorrenciaUtil().getMiniOcorrencia(i, ocorrencia, this));
			} else if (i >= 80 && i < 120) {
				view3.add(new InstanciaOcorrenciaUtil().getMiniOcorrencia(i, ocorrencia, this));
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public void getClickMiniOcorrencia(int index) {
		confirmar.setOcorrencia(ocorrencias.get(index));
		Ocorrencias.this.hide();
	}

}
