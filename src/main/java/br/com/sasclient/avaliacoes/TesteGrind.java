package br.com.sasclient.avaliacoes;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import br.sasclient.entity.Tela;
import br.sasclient.entity.Telas;
import br.sasclient.service.ServiceClient;
import br.sasclient.swing.TelaJD;
import br.sasclient.swing.paginas.SelectColaboradorJD;

public class TesteGrind extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	//private Pessoas pessoas;
	private JPanel jp_telas_nomes;
	private GridLayout meuGrid;
	private TelaJD jd;
	private SelectColaboradorJD colaboradorJD;
	private List<Tela> lista;
	private List<Tela> lista_transf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TesteGrind frame = new TesteGrind();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TesteGrind() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 630);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		//colaboradorJD = new SelectColaboradorJD();

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(0, 0, 1084, 591);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 103, 71));
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(0, 0, 1084, 34);
		panel.add(panel_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 45, 617, 474);
		panel.add(scrollPane);

		jp_telas_nomes = new JPanel();
		scrollPane.setViewportView(jp_telas_nomes);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBounds(671, 45, 403, 474);
		panel.add(panel_2);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 530, 548, 50);
		panel.add(panel_3);
		panel_3.setLayout(null);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 103, 71));
		panel_4.setBounds(10, 11, 178, 28);
		panel_3.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblNewLabel = new JLabel("Adicionar Colaborador");
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
						if(lista.size() != 0) {
							for(int i = 0; i < lista.size(); i++) {
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
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 178, 28);
		panel_4.add(lblNewLabel);

		init();
	}

	/*
	 * private void init() { pessoas = new Pessoas(); pessoas = new
	 * ServiceClient().ConsultarTodasPessoas(); int i = 0;
	 * 
	 * meuGrid = new GridLayout(4, pessoas.size(), 0, 0);
	 * jp_telas_nomes.setLayout(meuGrid); for(Pessoa pessoa: pessoas) { Tela tela =
	 * new Tela(); tela.setCodigo_colaborador(pessoa.getCodigo());
	 * tela.setColaborador(pessoa.getNome()); tela.setFoto(pessoa.getFoto());
	 * tela.setPrefixo("S"+i); i++; jd = new TelaJD(tela); jp_telas_nomes.add(jd); }
	 * }
	 */

	/**
	 * Inicializa buscando do banco de dados os colaboradores já cadastrados na tela
	 */
	private void init() {
		if (lista != null) {

		} else {
			lista = new ServiceClient().ConsultarPrefixosTela();
			meuGrid = new GridLayout(1, lista.size(), 0, 0);
			jp_telas_nomes.setLayout(meuGrid);
			for (Tela tela : lista) {
				//jd = new TelaJD(tela);
				//jp_telas_nomes.add(jd);
			}
		}
	}
	
	private void carregarTela() {
		if(lista.size() < 5) {
			meuGrid = new GridLayout(1, lista.size(), 0, 0);
		} else if(lista.size() >= 5 && lista.size() <= 10) {
			meuGrid = new GridLayout(2, lista.size(), 0, 0);
		} else if(lista.size() > 10 && lista.size() < 16){
			meuGrid = new GridLayout(3, lista.size(), 0, 0);
		} else {
			meuGrid = new GridLayout(4, lista.size(), 0, 0);
		}
		
		jp_telas_nomes.setLayout(meuGrid);
		for (Tela tela : lista) {
			//jd = new TelaJD(tela);
			//jp_telas_nomes.add(jd);
		}
	}
}
