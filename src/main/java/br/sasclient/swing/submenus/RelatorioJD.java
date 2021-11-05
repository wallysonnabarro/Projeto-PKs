package br.sasclient.swing.submenus;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import br.com.bo.RelatorioBO;
import br.sasclient.entity.Pessoa;
import br.sasclient.entity.Pessoas;
import br.sasclient.entity.Relatorio;
import br.sasclient.entity.Titularizacoes;
import br.sasclient.model.JtableModelTitularizacao;
import br.sasclient.service.ServiceClient;
import br.sasclient.swing.msg.MensagensJD2;
import br.sasclient.util.ArquivoUtil;
import br.sasclient.util.DataUtil;
import br.sasclient.util.LimiteTxt;

public class RelatorioJD extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8279665843209079094L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	javax.swing.ButtonGroup bg_relatorio = new javax.swing.ButtonGroup();
	private JRadioButton rb_data;
	private JRadioButton rb_nome;
	private JPanel pn_data;
	private JPanel pn_nome;
	private JTextField txt_nome;
	private Titularizacoes transferencia = new Titularizacoes();
	private JtableModelTitularizacao tabelaTransferencia;
	private JFormattedTextField txt_data_inicio;
	private JFormattedTextField txt_data_fim;
	private JFormattedTextField txt_data_nome_ini;
	private JFormattedTextField txt_nome_data_fim;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private static int tipo;
	private Set<String> lNomes;
	private Pessoas pessoas = new Pessoas();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RelatorioJD dialog = new RelatorioJD(tipo);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RelatorioJD(int tipo) {
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 728, 338);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		RelatorioJD.tipo = tipo;

		Toolkit toolkit = getToolkit();
		Dimension d = toolkit.getScreenSize();
		setLocation(d.width / 2 - getWidth() / 2, d.height / 2 - getHeight() / 2);

		carregarPrefixos();
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 722, 309);
		contentPanel.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new java.awt.Color(0, 103, 71));
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(28, 23, 325, 45);
		panel.add(panel_1);
		panel_1.setLayout(null);

		btnNewButton = new JButton("ESCOLHER OPÇÕES PARA O RELATÓRIO");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (btnNewButton.isEnabled() == false) {
				} else {
					new Thread() {
						public void run() {
							SelectItensRelatorio select = new SelectItensRelatorio();
							select.setVisible(true);
							while (select.isVisible()) {
							}
							transferencia = select.geteLista();
							tabelaTransferencia = new JtableModelTitularizacao(transferencia);
							table.setModel(tabelaTransferencia);
						};
					}.start();
				}
			}
		});
		btnNewButton.setBackground(new Color(176, 224, 230));
		btnNewButton.setBounds(363, 23, 325, 23);
		panel.add(btnNewButton);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBounds(28, 70, 325, 55);
		panel.add(panel_2);
		panel_2.setLayout(null);

		rb_data = new JRadioButton("Por Data");
		rb_data.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				limpar2();
			}
		});
		rb_data.setSelected(true);
		rb_data.setHorizontalAlignment(SwingConstants.CENTER);
		rb_data.setBounds(6, 7, 152, 41);
		panel_2.add(rb_data);
		bg_relatorio.add(rb_data);

		rb_nome = new JRadioButton("Por Nome e Data");
		rb_nome.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				limpar1();
			}
		});
		rb_nome.setHorizontalAlignment(SwingConstants.CENTER);
		rb_nome.setBounds(160, 7, 126, 41);
		panel_2.add(rb_nome);
		bg_relatorio.add(rb_nome);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_3.setBounds(28, 127, 325, 161);
		panel.add(panel_3);
		panel_3.setLayout(null);

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		layeredPane.setBounds(10, 11, 305, 107);
		panel_3.add(layeredPane);
		layeredPane.setLayout(null);

		pn_data = new JPanel();
		pn_data.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pn_data.setBounds(0, 0, 305, 107);
		layeredPane.add(pn_data);
		pn_data.setLayout(null);

		JLabel lblNewLabel = new JLabel("Início");
		lblNewLabel.setBounds(10, 42, 39, 28);
		pn_data.add(lblNewLabel);

		txt_data_inicio = new JFormattedTextField();
		txt_data_inicio.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					txt_data_fim.requestFocus();
				}
			}
		});
		txt_data_inicio.setBounds(54, 42, 77, 28);
		try {
			txt_data_inicio.setFormatterFactory(
					new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
		} catch (java.text.ParseException ex) {
			ex.printStackTrace();
		}
		pn_data.add(txt_data_inicio);

		JLabel lblFim = new JLabel("Fim");
		lblFim.setBounds(174, 42, 39, 28);
		pn_data.add(lblFim);

		txt_data_fim = new JFormattedTextField();
		txt_data_fim.setBounds(218, 42, 77, 28);
		try {
			txt_data_fim.setFormatterFactory(
					new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
		} catch (java.text.ParseException ex) {
			ex.printStackTrace();
		}
		pn_data.add(txt_data_fim);

		pn_nome = new JPanel();
		pn_nome.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pn_nome.setBounds(0, 0, 305, 107);
		layeredPane.add(pn_nome);
		pn_nome.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setBounds(10, 24, 39, 14);
		pn_nome.add(lblNewLabel_1);

		txt_nome = new JTextField();
		txt_nome.setDocument(new LimiteTxt(100));
		txt_nome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					txt_data_nome_ini.requestFocus();
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {
				txt_prefixos_controleKeyRealesse(e);
			}
		});
		txt_nome.setBounds(48, 21, 247, 26);
		pn_nome.add(txt_nome);
		txt_nome.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Início");
		lblNewLabel_2.setBounds(10, 68, 39, 28);
		pn_nome.add(lblNewLabel_2);

		txt_data_nome_ini = new JFormattedTextField();
		txt_data_nome_ini.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					txt_nome_data_fim.requestFocus();
				}
			}
		});
		txt_data_nome_ini.setBounds(54, 68, 77, 28);
		try {
			txt_data_nome_ini.setFormatterFactory(
					new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
		} catch (java.text.ParseException ex) {
			ex.printStackTrace();
		}
		pn_nome.add(txt_data_nome_ini);

		JLabel lblFim_1 = new JLabel("Fim");
		lblFim_1.setBounds(174, 68, 39, 28);
		pn_nome.add(lblFim_1);

		txt_nome_data_fim = new JFormattedTextField();
		txt_nome_data_fim.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

			}
		});
		txt_nome_data_fim.setBounds(218, 68, 77, 28);
		try {
			txt_nome_data_fim.setFormatterFactory(
					new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
		} catch (java.text.ParseException ex) {
			ex.printStackTrace();
		}
		pn_nome.add(txt_nome_data_fim);
		pn_nome.setVisible(false);

		JButton btnNewButton_1 = new JButton("Gerar Relatório");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				gerar();
			}
		});
		btnNewButton_1.setBackground(new Color(176, 224, 230));
		btnNewButton_1.setBounds(10, 127, 305, 23);
		panel_3.add(btnNewButton_1);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(363, 57, 325, 229);
		panel.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
	}

	protected void limpar1() {
		pn_data.setVisible(false);
		pn_nome.setVisible(true);
		txt_data_inicio.setText("");
		txt_data_fim.setText("");
		scrollPane.setEnabled(false);
		btnNewButton.setEnabled(false);
		transferencia = new Titularizacoes();

		tabelaTransferencia = new JtableModelTitularizacao(transferencia);
		table.setModel(tabelaTransferencia);
	}

	protected void limpar2() {
		pn_data.setVisible(true);
		pn_nome.setVisible(false);
		txt_data_nome_ini.setText("");
		txt_nome_data_fim.setText("");
		txt_nome.setText("");
		scrollPane.setEnabled(true);
		btnNewButton.setEnabled(true);
		transferencia = new Titularizacoes();

		tabelaTransferencia = new JtableModelTitularizacao(transferencia);
		table.setModel(tabelaTransferencia);
	}

	protected void gerar() {
		Relatorio relatorio = new Relatorio();
		File file;
		if (transferencia.size() != 0) {
			if (rb_data.isSelected() == true) {
				relatorio.setTitularizacoes(transferencia);
				relatorio.setInicio(new DataUtil().convertData(txt_data_inicio.getText().toString()));
				relatorio.setFim(new DataUtil().convertData(txt_data_fim.getText().toString()));
				if (new RelatorioBO().validarCampos(relatorio)) {
					file = new ArquivoUtil().gravarPdf(new ServiceClient().GerarRelatorioPorData(relatorio));
					abrirPDF(file);
				} else {
					mensagem();
				}
			} else {
				mensagem();
			}
		} else if (rb_data.isSelected() == true) {
			transferencia = new Titularizacoes();
			relatorio.setTitularizacoes(transferencia);
			relatorio.setInicio(new DataUtil().convertData(txt_data_inicio.getText().toString()));
			relatorio.setFim(new DataUtil().convertData(txt_data_fim.getText().toString()));
			if (new RelatorioBO().validarCampos(relatorio)) {
				file = new ArquivoUtil().gravarPdf(new ServiceClient().GerarRelatorioPorData(relatorio));
				abrirPDF(file);
			} else {
				mensagem();
			}
		} else {
			relatorio.setTitularizacoes(transferencia);
			relatorio.setNome(txt_nome.getText().toString());
			relatorio.setInicio(new DataUtil().convertData(txt_data_nome_ini.getText().toString()));
			relatorio.setFim(new DataUtil().convertData(txt_nome_data_fim.getText().toString()));
			if (new RelatorioBO().validarCampos2(relatorio)) {
				file = new ArquivoUtil().gravarPdf(new ServiceClient().GerarRelatorioPorData(relatorio));
				abrirPDF(file);
			} else {
				mensagem();
			}
		}
	}

	private void mensagem() {
		MensagensJD2 jd = new MensagensJD2("Dados inválidos!", "Erro");
		jd.setVisible(true);
	}

	private static void abrirPDF(File file) {
		try {
			Desktop.getDesktop().open(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void txt_prefixos_controleKeyRealesse(java.awt.event.KeyEvent evt) {

		if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getKeyCode() == KeyEvent.VK_DELETE) {

		} else {

			String to_check = txt_nome.getText();
			int to_check_length = to_check.length();
			for (String data : lNomes) {
				String check_from_data = "";
				for (int i = 0; i < to_check_length; i++) {
					if (to_check_length <= data.length()) {
						check_from_data = check_from_data + data.charAt(i);
					}
				}
				if (check_from_data.equals(to_check)) {
					txt_nome.setText(data);
					txt_nome.setSelectionStart(to_check_length);
					txt_nome.setSelectionEnd(data.length());
					break;
				}
			}
		}
	}

	private void carregarPrefixos() {
		lNomes = new TreeSet<String>();
		if (pessoas.size() != 0) {
			pessoas = new ServiceClient().ConsultarPessoasOcorrencias();
			for (Pessoa f : pessoas) {
				lNomes.add(f.getNome());
			}
		} else {
			pessoas = new ServiceClient().ConsultarPessoasOcorrencias();
			for (Pessoa f : pessoas) {
				lNomes.add(f.getNome());
			}
		}
	}
}
