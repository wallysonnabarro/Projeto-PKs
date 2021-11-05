package br.com.sasclient.avaliacoes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import br.sasclient.entity.Tela;
import br.sasclient.entity.Telas;
import br.sasclient.service.ServiceClient;
import br.sasclient.swing.TelaJD;
import br.sasclient.swing.paginas.SelectColaboradorJD;
import javax.swing.JLayeredPane;
import javax.swing.ImageIcon;

public class TesteFlowLayout extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private TelaJD jd;
	private SelectColaboradorJD colaboradorJD;
	private List<Tela> lista;
	private List<Tela> lista_transf;
	private JPanel VIEW;
	private final JPanel panel_3 = new JPanel();
	private final JPanel panel_4 = new JPanel();
	private final JLabel lblNewLabel = new JLabel("Adicionar Colaborador");
	private final JPanel panel = new JPanel();
	private final JLayeredPane layeredPane = new JLayeredPane();
	private final JPanel VIEW1 = new JPanel();
	private final JPanel VIEW2 = new JPanel();
	private final JPanel VIEW3 = new JPanel();
	private final JPanel VIEW4 = new JPanel();
	private final JPanel panel_1 = new JPanel();
	private int aux = 1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TesteFlowLayout dialog = new TesteFlowLayout();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TesteFlowLayout() {
		setBounds(100, 100, 1300, 730);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		Toolkit toolkit = getToolkit();
		Dimension d = toolkit.getScreenSize();
		setLocation(d.width / 2 - getWidth() / 2, d.height / 2 - getHeight() / 2);

		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_3.setLayout(null);
		panel_3.setBounds(10, 630, 516, 50);

		contentPanel.add(panel_3);
		panel_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(0, 103, 71));
		panel_4.setBounds(10, 11, 178, 28);

		panel_3.add(panel_4);
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				colaboradorJD.setVisible(true);
				new Thread() {
					public void run() {
						while (colaboradorJD.isVisible()) {
						}
						if (!colaboradorJD.isVisible()) {
							lista_transf = new Telas();
							lista_transf = colaboradorJD.getTela();

							validarLista(lista_transf);

						}
					}

					private void validarLista(List<Tela> l) {
						if (lista.size() != 0) {
							for (int i = 0; i < lista.size(); i++) {
								try {
									//jd.fecharTela(lista.get(i).getCodigo_colaborador());
								} catch (Throwable e) {
									e.printStackTrace();
								}
							}
							lista = l;
							carregarTela();
						} else {
							lista = l;
							carregarTela();
						}
					}
				}.start();
			}
		});
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblNewLabel.setBounds(0, 0, 178, 28);

		panel_4.add(lblNewLabel);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 11, 681, 614);

		contentPanel.add(panel);
		panel.setLayout(null);
		layeredPane.setBounds(10, 11, 661, 592);

		panel.add(layeredPane);
		layeredPane.setLayout(null);

		VIEW = new JPanel();
		VIEW.setBounds(0, 0, 661, 592);
		layeredPane.add(VIEW);
		VIEW.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));

		VIEW.setLayout(new FlowLayout(FlowLayout.LEFT, 1, 1));
		VIEW1.setBounds(0, 0, 661, 592);

		layeredPane.add(VIEW1);
		VIEW1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		VIEW2.setBounds(0, 0, 661, 592);

		layeredPane.add(VIEW2);
		VIEW2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		VIEW3.setBounds(0, 0, 661, 592);

		layeredPane.add(VIEW3);
		VIEW3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		VIEW4.setBounds(0, 0, 661, 592);

		layeredPane.add(VIEW4);
		VIEW4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel_1.setBackground(new Color(0, 103, 71));
		panel_1.setBounds(536, 630, 155, 50);

		contentPanel.add(panel_1);
		panel_1.setLayout(null);

		JLabel jLabel3 = new JLabel();
		jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel3.setBounds(38, 11, 77, 20);
		panel_1.add(jLabel3);
		jLabel3.setText("TROCAR DE TELA");
		jLabel3.setForeground(Color.WHITE);
		jLabel3.setFont(new Font("Segoe UI", Font.PLAIN, 9));

		JLabel lbl_seta_esquerda = new JLabel();
		lbl_seta_esquerda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (aux == 5) {
					VIEW.setVisible(false);
					VIEW1.setVisible(false);
					VIEW2.setVisible(false);
					VIEW3.setVisible(true);
					VIEW4.setVisible(false);
					aux = 4;
				} else if (aux == 4) {
					VIEW.setVisible(false);
					VIEW1.setVisible(false);
					VIEW2.setVisible(true);
					VIEW3.setVisible(false);
					VIEW4.setVisible(false);
					aux = 3;

				} else if (aux == 3) {
					VIEW.setVisible(false);
					VIEW1.setVisible(true);
					VIEW2.setVisible(false);
					VIEW3.setVisible(false);
					VIEW4.setVisible(false);
					aux = 2;

				} else if (aux == 2) {
					VIEW.setVisible(true);
					VIEW1.setVisible(false);
					VIEW2.setVisible(false);
					VIEW3.setVisible(false);
					VIEW4.setVisible(false);
					aux = 1;

				}
			}
		});
		lbl_seta_esquerda.setIcon(
				new ImageIcon(TesteFlowLayout.class.getResource("/br/sasclient/imagens/seta_esquerda_26px.png")));
		lbl_seta_esquerda.setBounds(10, 11, 26, 26);
		panel_1.add(lbl_seta_esquerda);

		JLabel lbl_seta_direita = new JLabel();
		lbl_seta_direita.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (aux == 1) {
					if (lista.size() >= 15) {
						VIEW.setVisible(false);
						VIEW1.setVisible(true);
						VIEW2.setVisible(false);
						VIEW3.setVisible(false);
						VIEW4.setVisible(false);
						aux = 2;
					}
				} else if (aux == 2) {
					if (lista.size() >= 30) {
						VIEW.setVisible(false);
						VIEW1.setVisible(false);
						VIEW2.setVisible(true);
						VIEW3.setVisible(false);
						VIEW4.setVisible(false);
						aux = 3;
					}
				} else if (aux == 3) {
					if (lista.size() >= 45) {
						VIEW.setVisible(false);
						VIEW1.setVisible(false);
						VIEW2.setVisible(false);
						VIEW3.setVisible(true);
						VIEW4.setVisible(false);
						aux = 4;
					}
				} else if (aux == 4) {
					if (lista.size() >= 60) {
						VIEW.setVisible(false);
						VIEW1.setVisible(false);
						VIEW2.setVisible(false);
						VIEW3.setVisible(true);
						VIEW4.setVisible(false);
						aux = 5;
					}
				}
			}
		});
		lbl_seta_direita.setIcon(
				new ImageIcon(TesteFlowLayout.class.getResource("/br/sasclient/imagens/seta_direita_26px.png")));
		lbl_seta_direita.setBounds(119, 11, 26, 26);
		panel_1.add(lbl_seta_direita);

		init();
	}

	/**
	 * Inicializa buscando do banco d34, 298, 73co106boradores já cadastrados na
	 * tela
	 */
	private void init() {
		VIEW.setVisible(true);
		VIEW1.setVisible(false);
		VIEW2.setVisible(false);
		VIEW3.setVisible(false);
		VIEW4.setVisible(false);

		if (lista != null) {
			VIEW.setVisible(true);
		} else {
			//colaboradorJD = new SelectColaboradorJD();
			lista = new ServiceClient().ConsultarPrefixosTela();

			for (Tela tela : lista) {
				//jd = new TelaJD(tela);
				VIEW.add(jd);
			}
		}
	}

	private void carregarTela() {
		for (int i = 0; i < lista.size(); i++) {
			Tela tela = lista.get(i);
			//jd = new TelaJD(tela);

			if (i < 15) {
				VIEW.add(jd);
			} else {
				VIEW1.add(jd);
			}
		}
	}
}
