package br.sasclient.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import br.sasclient.entity.Ocorrencia;
import br.sasclient.entity.OcorrenciaEnty;
import br.sasclient.entity.Tela;
import br.sasclient.entity.Telas;
import br.sasclient.service.ServiceClient;
import br.sasclient.swing.msg.MensagensJD2;
import br.sasclient.swing.paginas.SelectColaboradorJD;
import br.sasclient.util.DataUtil;
import br.sasclient.util.InstanciaOcorrenciaAtiva;
import br.sasclient.util.InstanciaUtil;

public class Monitoramento extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
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
	private int aux2 = 1;
	private final JPanel panel_2 = new JPanel();
	private JPanel view_o;
	private JPanel view_o2;
	private JPanel view_o3;
	private JPanel view_o4;
	private List<OcorrenciaEnty> ListaEnty;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Monitoramento dialog = new Monitoramento();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Monitoramento() {
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
				colaboradorJD = new SelectColaboradorJD(lista);
				colaboradorJD.setVisible(true);
				Thread t = new Thread() {
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
							lista = l;
							carregarTela();
						} else {
							lista = l;
							carregarTela();
						}
					}
				};
				t.start();

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
		VIEW.setBackground(Color.WHITE);
		VIEW.setBounds(0, 0, 661, 592);
		layeredPane.add(VIEW);
		VIEW.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));

		VIEW.setLayout(new FlowLayout(FlowLayout.LEFT, 1, 1));
		VIEW1.setBackground(Color.WHITE);
		VIEW1.setBounds(0, 0, 661, 592);

		layeredPane.add(VIEW1);
		VIEW1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		VIEW2.setBackground(Color.WHITE);
		VIEW2.setBounds(0, 0, 661, 592);

		layeredPane.add(VIEW2);
		VIEW2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		VIEW3.setBackground(Color.WHITE);
		VIEW3.setBounds(0, 0, 661, 592);

		layeredPane.add(VIEW3);
		VIEW3.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		VIEW4.setBackground(Color.WHITE);
		VIEW4.setBounds(0, 0, 661, 592);

		layeredPane.add(VIEW4);
		VIEW4.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		panel_1.setBackground(new Color(0, 103, 71));
		panel_1.setBounds(536, 630, 155, 50);

		contentPanel.add(panel_1);
		panel_1.setLayout(null);

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
				new ImageIcon(Monitoramento.class.getResource("/br/sasclient/imagens/seta_esquerda_26px.png")));
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
		lbl_seta_direita
				.setIcon(new ImageIcon(Monitoramento.class.getResource("/br/sasclient/imagens/seta_direita_26px.png")));
		lbl_seta_direita.setBounds(119, 11, 26, 26);
		panel_1.add(lbl_seta_direita);

		JLabel lblColaboradores = new JLabel();
		lblColaboradores.setText("COLABORADORES");
		lblColaboradores.setHorizontalAlignment(SwingConstants.CENTER);
		lblColaboradores.setForeground(Color.WHITE);
		lblColaboradores.setFont(new Font("Segoe UI", Font.PLAIN, 9));
		lblColaboradores.setBounds(38, 0, 77, 50);
		panel_1.add(lblColaboradores);
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBounds(701, 11, 573, 614);

		contentPanel.add(panel_2);
		panel_2.setLayout(null);

		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBounds(10, 11, 553, 592);
		panel_2.add(layeredPane_1);
		layeredPane_1.setLayout(null);

		view_o = new JPanel();
		view_o.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		view_o.setBackground(Color.WHITE);
		view_o.setBounds(0, 0, 553, 592);
		layeredPane_1.add(view_o);
		view_o.setLayout(new FlowLayout(FlowLayout.LEFT, 1, 1));

		view_o2 = new JPanel();
		view_o2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		view_o2.setBackground(Color.WHITE);
		view_o2.setBounds(0, 0, 553, 592);
		layeredPane_1.add(view_o2);
		view_o2.setLayout(new FlowLayout(FlowLayout.LEFT, 1, 1));

		view_o3 = new JPanel();
		view_o3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		view_o3.setBackground(Color.WHITE);
		view_o3.setBounds(0, 0, 553, 592);
		layeredPane_1.add(view_o3);
		view_o3.setLayout(new FlowLayout(FlowLayout.LEFT, 1, 1));

		view_o4 = new JPanel();
		view_o4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		view_o4.setBackground(Color.WHITE);
		view_o4.setBounds(0, 0, 553, 592);
		layeredPane_1.add(view_o4);
		view_o4.setLayout(new FlowLayout(FlowLayout.LEFT, 1, 1));
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(0, 103, 71));
		panel_1_1.setBounds(1108, 630, 155, 50);
		contentPanel.add(panel_1_1);
		
		JLabel lbl_seta_esquerda_1 = new JLabel();
		lbl_seta_esquerda_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (aux2 == 4) {
					view_o.setVisible(false);
					view_o2.setVisible(false);
					view_o3.setVisible(true);
					view_o4.setVisible(false);
					aux2 = 3;
				} else if (aux2 == 3) {
					view_o.setVisible(false);
					view_o2.setVisible(true);
					view_o3.setVisible(false);
					view_o4.setVisible(false);
					aux2 = 2;
				} else if (aux2 == 2) {
					view_o.setVisible(true);
					view_o2.setVisible(false);
					view_o3.setVisible(false);
					view_o4.setVisible(false);
					aux2 = 1;
				}				
			}
		});
		lbl_seta_esquerda_1.setIcon(new ImageIcon(Monitoramento.class.getResource("/br/sasclient/imagens/seta_esquerda_26px.png")));
		lbl_seta_esquerda_1.setBounds(10, 11, 26, 26);
		panel_1_1.add(lbl_seta_esquerda_1);
		
		JLabel lbl_seta_direita_1 = new JLabel();
		lbl_seta_direita_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (aux2 == 1) {
					if (ListaEnty.size() >= 45) {
						view_o.setVisible(false);
						view_o2.setVisible(true);
						view_o3.setVisible(false);
						view_o4.setVisible(false);
						aux2 = 2;
					}
				} else if (aux2 == 2) {
					if (ListaEnty.size() >= 45) {
						view_o.setVisible(false);
						view_o2.setVisible(false);
						view_o3.setVisible(true);
						view_o4.setVisible(false);
						aux2 = 3;
					}
				} else if (aux2 == 3) {
					if (ListaEnty.size() >= 96) {
						view_o.setVisible(false);
						view_o2.setVisible(false);
						view_o3.setVisible(false);
						view_o4.setVisible(true);
						aux2 = 4;
					}
				} 
			}
		});
		lbl_seta_direita_1.setIcon(new ImageIcon(Monitoramento.class.getResource("/br/sasclient/imagens/seta_direita_26px.png")));
		lbl_seta_direita_1.setBounds(119, 11, 26, 26);
		panel_1_1.add(lbl_seta_direita_1);
		
		JLabel lblOcorrncias = new JLabel();
		lblOcorrncias.setText("OCORRÊNCIAS");
		lblOcorrncias.setHorizontalAlignment(SwingConstants.CENTER);
		lblOcorrncias.setForeground(Color.WHITE);
		lblOcorrncias.setFont(new Font("Segoe UI", Font.PLAIN, 9));
		lblOcorrncias.setBounds(38, 0, 77, 50);
		panel_1_1.add(lblOcorrncias);

		view_o.setVisible(true);
		view_o2.setVisible(false);
		view_o3.setVisible(false);
		view_o4.setVisible(false);

		init();
		carregarOcorrenciasBanco();
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
			lista = new ServiceClient().ConsultarPrefixosTela();

			carregarTela();
		}
	}

	private void carregarTela() {
		for (int i = 0; i < lista.size(); i++) {
			Tela tela = lista.get(i);
			if (i < 32) {
				VIEW.add(new InstanciaUtil().getClasse(i, tela, this));
			} else if (i >= 32 && i < 64) {
				VIEW1.add(new InstanciaUtil().getClasse(i, tela, this));
			} else if (i >= 64 && i < 96) {
				VIEW2.add(new InstanciaUtil().getClasse(i, tela, this));
			} else if (i >= 96 && i < 128) {
				VIEW3.add(new InstanciaUtil().getClasse(i, tela, this));
			} else if (i >= 128 && i < 161) {
				VIEW4.add(new InstanciaUtil().getClasse(i, tela, this));
			}
		}
		for (Tela t : lista) {
			new ServiceClient().CadastrarTela(t);
		}
	}

	public void getClickTela(int codigo_colaborador, int index) {
		for (int i = 0; i < lista.size(); i++) {
			Tela tela = lista.get(i);
			if (tela.getCodigo_colaborador() == codigo_colaborador) {
				lista.remove(i);
			}
		}
	}

	/**
	 * Aqui será carregada a ocorrência selecionada e colocado um contador para ela
	 * 
	 * @param ocorrencia
	 */
	public void setOcorrenciaSelected(Ocorrencia ocorrencia, Tela tela) {
		if (ocorrencia != null) {
			OcorrenciaEnty enty = new OcorrenciaEnty();
			enty.setTitulo(ocorrencia.getNome());
			enty.setNome(tela.getColaborador());
			enty.setPrimeiro(ocorrencia.getPrimeiro());
			enty.setSegundo(ocorrencia.getSegundo());
			enty.setHora_registro(new DataUtil().getHoraStringParaBancoSemData(new DataUtil().pegarDataAtual()));
			String resp = new ServiceClient().CadastrarOcorrenciaAtiva(enty);
			if (!"Erro ao cadastrar um registro ".equals(resp)) {
				enty.setCodigo(Integer.parseInt(resp));
				ListaEnty.add(enty);
				carregarOcorrenciaInserida();
			} else {
				MensagensJD2 jd2 = new MensagensJD2(resp, "Erro");
				jd2.setVisible(true);
			}
		}
	}

	private void carregarOcorrenciasBanco() {
		ListaEnty = new ServiceClient().ConsultarTodasOcorrenciasAtivas();
		for (int i = 0; i < ListaEnty.size(); i++) {
			OcorrenciaEnty enty = ListaEnty.get(i);
			if (i < 44) {
				view_o.add(new InstanciaOcorrenciaAtiva().getInstancia(enty, enty.getCodigo(), this, i));
			} else if(i >= 44 && i < 88){
				view_o2.add(new InstanciaOcorrenciaAtiva().getInstancia(enty, enty.getCodigo(), this, i));				
			} else if(i >= 88 && i < 132){
				view_o3.add(new InstanciaOcorrenciaAtiva().getInstancia(enty, enty.getCodigo(), this, i));				
			} else if(i >= 132 && i < 176){
				view_o4.add(new InstanciaOcorrenciaAtiva().getInstancia(enty, enty.getCodigo(), this, i));
			}
		}
	}

	private void carregarOcorrenciaInserida() {
		int s = ListaEnty.size() - 1;
		if (ListaEnty.size() < 44) {
			view_o.add(new InstanciaOcorrenciaAtiva().getInstancia(ListaEnty.get(s), ListaEnty.get(s).getCodigo(), this, s));
			revalidate();
			repaint();
		} else if(ListaEnty.size() >= 44 && ListaEnty.size() < 88){
			view_o2.add(new InstanciaOcorrenciaAtiva().getInstancia(ListaEnty.get(s), ListaEnty.get(s).getCodigo(), this, s));
			revalidate();
			repaint();
		} else if(ListaEnty.size() >= 88 && ListaEnty.size() < 132){
			view_o3.add(new InstanciaOcorrenciaAtiva().getInstancia(ListaEnty.get(s), ListaEnty.get(s).getCodigo(), this, s));
			revalidate();
			repaint();
		} else if(ListaEnty.size() >= 132 && ListaEnty.size() < 176){
			view_o4.add(new InstanciaOcorrenciaAtiva().getInstancia(ListaEnty.get(s), ListaEnty.get(s).getCodigo(), this, s));
			revalidate();
			repaint();
		}
	}
}
