package br.sasclient.swing.submenus;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import br.sasclient.entity.Relatorio;
import br.sasclient.service.ServiceClient;
import br.sasclient.swing.msg.MensagensJD2;
import br.sasclient.util.ArquivoUtil;
import br.sasclient.util.DataUtil;
import br.sasclient.util.LimiteTxt;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RelatorioBoletinsJD extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private ButtonGroup groupo = new ButtonGroup();
	private JRadioButton rb_data;
	private JRadioButton rb_nome;
	private JRadioButton rb_terceirizada;
	private JTextField txt_nome;
	private JPanel pn1;
	private JPanel pn2;
	private JPanel pn3;
	private JPanel pn4;
	private String[] departamento = { "Banco de Horas", "GEOP", "MKT" };
	private String[] tipo = { "Falta", "Atraso" };
	private String[] terceirizada = { "Vigilância", "Especializada" };
	private JComboBox<Object> cb_departamento;
	private JComboBox<Object> cb_tipo;
	private JComboBox<Object> cb_terceirizada;
	private JComboBox<Object> cb_boletas;
	private JFormattedTextField txt_data1;
	private JFormattedTextField txt_data2;
	private JButton btn_gerar;
	private JRadioButton rb_boletas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RelatorioBoletinsJD dialog = new RelatorioBoletinsJD();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RelatorioBoletinsJD() {
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 414, 441);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		Toolkit toolkit = getToolkit();
		Dimension d = toolkit.getScreenSize();
		setLocation(d.width / 2 - getWidth() / 2, d.height / 2 - getHeight() / 2);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 408, 412);
		contentPanel.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 0, 387, 103);
		panel_1.setBackground(SystemColor.menu);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new java.awt.Color(0, 103, 71));
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBounds(0, 0, 387, 37);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel = new JLabel("Escolha o tipo do relatório");
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 11, 387, 14);
		panel_2.add(lblNewLabel);

		rb_data = new JRadioButton("Data");
		rb_data.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				select();
			}
		});
		rb_data.setSelected(true);
		rb_data.setBounds(18, 60, 62, 23);
		groupo.add(rb_data);
		panel_1.add(rb_data);

		rb_nome = new JRadioButton("Nome");
		rb_nome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				select();
			}
		});
		rb_nome.setBounds(103, 60, 67, 23);
		groupo.add(rb_nome);
		panel_1.add(rb_nome);

		rb_terceirizada = new JRadioButton("Terceirizada");
		rb_terceirizada.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				select();
			}
		});
		rb_terceirizada.setBounds(172, 60, 114, 23);
		groupo.add(rb_terceirizada);
		panel_1.add(rb_terceirizada);

		rb_boletas = new JRadioButton("Boletas");
		rb_boletas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				select();
			}
		});
		rb_boletas.setBounds(288, 60, 76, 23);
		groupo.add(rb_boletas);
		panel_1.add(rb_boletas);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 106, 387, 295);
		panel_3.setBackground(UIManager.getColor("CheckBox.interiorBackground"));
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.add(panel_3);
		panel_3.setLayout(null);

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		layeredPane.setBounds(10, 11, 367, 273);
		panel_3.add(layeredPane);
		layeredPane.setLayout(null);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(SystemColor.window);
		panel_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_4.setBounds(0, 0, 367, 273);
		layeredPane.add(panel_4);
		panel_4.setLayout(null);

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_6.setBounds(10, 143, 347, 64);
		panel_4.add(panel_6);
		panel_6.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Data Início");
		lblNewLabel_1.setBounds(10, 11, 70, 42);
		panel_6.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Data Fim");
		lblNewLabel_1_1.setBounds(172, 11, 70, 42);
		panel_6.add(lblNewLabel_1_1);

		txt_data1 = new JFormattedTextField();
		txt_data1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					txt_data2.requestFocus();
				}
			}
		});
		txt_data1.setBounds(81, 20, 81, 25);
		try {
			txt_data1.setFormatterFactory(
					new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		panel_6.add(txt_data1);

		txt_data2 = new JFormattedTextField();
		txt_data2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btn_gerar.requestFocus();
				}
			}
		});
		txt_data2.setBounds(232, 20, 81, 25);
		try {
			txt_data2.setFormatterFactory(
					new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		panel_6.add(txt_data2);

		btn_gerar = new JButton("Gerar Relatório");
		btn_gerar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					gerar_relatorio();
				}
			}
		});
		btn_gerar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gerar_relatorio();
			}
		});
		btn_gerar.setBackground(new Color(176, 224, 230));
		btn_gerar.setBounds(114, 239, 131, 23);
		panel_4.add(btn_gerar);

		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		layeredPane_1.setBounds(10, 11, 347, 121);
		panel_4.add(layeredPane_1);

		pn1 = new JPanel();
		pn1.setBackground(SystemColor.inactiveCaptionBorder);
		pn1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pn1.setBounds(0, 0, 347, 121);
		layeredPane_1.add(pn1);
		pn1.setLayout(null);

		JPanel panel_5_1 = new JPanel();
		panel_5_1.setBounds(10, 45, 326, 20);
		pn1.add(panel_5_1);
		panel_5_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.LIGHT_GRAY, Color.LIGHT_GRAY));

		JPanel panel_5_1_1 = new JPanel();
		panel_5_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.LIGHT_GRAY, Color.LIGHT_GRAY));
		panel_5_1_1.setBounds(10, 11, 326, 20);
		pn1.add(panel_5_1_1);

		JPanel panel_5_1_2 = new JPanel();
		panel_5_1_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.LIGHT_GRAY, Color.LIGHT_GRAY));
		panel_5_1_2.setBounds(10, 76, 326, 20);
		pn1.add(panel_5_1_2);

		pn2 = new JPanel();
		pn2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pn2.setBounds(0, 0, 347, 121);
		layeredPane_1.add(pn2);
		pn2.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Nome");
		lblNewLabel_2.setBounds(10, 82, 40, 14);
		pn2.add(lblNewLabel_2);

		txt_nome = new JTextField();
		txt_nome.setBounds(60, 79, 277, 25);
		txt_nome.setDocument(new LimiteTxt(100));
		pn2.add(txt_nome);
		txt_nome.setColumns(10);

		JPanel panel_5_1_1_1 = new JPanel();
		panel_5_1_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.LIGHT_GRAY, Color.LIGHT_GRAY));
		panel_5_1_1_1.setBounds(10, 11, 326, 20);
		pn2.add(panel_5_1_1_1);

		JPanel panel_5_1_1_2 = new JPanel();
		panel_5_1_1_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.LIGHT_GRAY, Color.LIGHT_GRAY));
		panel_5_1_1_2.setBounds(10, 42, 326, 20);
		pn2.add(panel_5_1_1_2);

		pn3 = new JPanel();
		pn3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pn3.setBounds(0, 0, 347, 121);
		layeredPane_1.add(pn3);
		pn3.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("Departamento");
		lblNewLabel_3.setBounds(10, 53, 86, 14);
		pn3.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Tipo");
		lblNewLabel_4.setBounds(10, 93, 46, 14);
		pn3.add(lblNewLabel_4);

		cb_departamento = new JComboBox<Object>(departamento);
		cb_departamento.setBounds(117, 50, 220, 20);
		pn3.add(cb_departamento);

		cb_tipo = new JComboBox<Object>(tipo);
		cb_tipo.setBounds(117, 90, 220, 20);
		pn3.add(cb_tipo);

		JLabel lblNewLabel_5 = new JLabel("Terceirizada");
		lblNewLabel_5.setBounds(10, 11, 86, 14);
		pn3.add(lblNewLabel_5);

		cb_terceirizada = new JComboBox<Object>(terceirizada);
		cb_terceirizada.setBounds(117, 8, 220, 20);
		pn3.add(cb_terceirizada);

		pn4 = new JPanel();
		pn4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pn4.setBounds(0, 0, 347, 121);
		layeredPane_1.add(pn4);
		pn4.setLayout(null);

		JPanel panel_5_1_1_3 = new JPanel();
		panel_5_1_1_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.LIGHT_GRAY, Color.LIGHT_GRAY));
		panel_5_1_1_3.setBounds(10, 11, 326, 20);
		pn4.add(panel_5_1_1_3);

		JPanel panel_5_1_1_4 = new JPanel();
		panel_5_1_1_4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.LIGHT_GRAY, Color.LIGHT_GRAY));
		panel_5_1_1_4.setBounds(10, 41, 326, 20);
		pn4.add(panel_5_1_1_4);

		JPanel panel_5_1_1_4_1 = new JPanel();
		panel_5_1_1_4_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.LIGHT_GRAY, Color.LIGHT_GRAY));
		panel_5_1_1_4_1.setBounds(10, 72, 326, 20);
		pn4.add(panel_5_1_1_4_1);

		JLabel lblNewLabel_6 = new JLabel("Boletas");
		lblNewLabel_6.setBounds(10, 96, 46, 25);
		pn4.add(lblNewLabel_6);

		cb_boletas = new JComboBox<Object>(terceirizada);
		cb_boletas.setBounds(66, 98, 270, 20);
		pn4.add(cb_boletas);

		init();
	}

	protected void gerar_relatorio() {
		Relatorio relatorio = new Relatorio();
		relatorio.setInicio(new DataUtil().convertData(txt_data1.getText().toString()));
		relatorio.setFim(new DataUtil().convertData(txt_data2.getText().toString()));
		File file;
		if (rb_data.isSelected()) {
			if (validar(relatorio)) {
				file = new ArquivoUtil().gravarPdf(new ServiceClient().GerarRelatorioBoletins(relatorio));
				abrirPDF(file);
			} else {
				mensagem();
			}
			limpar1();
		} else if (rb_nome.isSelected()) {
			relatorio.setNome(txt_nome.getText().toString());
			if (validar2(relatorio)) {
				file = new ArquivoUtil().gravarPdf(new ServiceClient().GerarRelatorioBoletins(relatorio));
				abrirPDF(file);
			} else {
				mensagem();
			}
			limpar1();
		} else if (rb_terceirizada.isSelected()) {
			relatorio.setDepartamento(cb_departamento.getSelectedIndex() + 1);
			relatorio.setTipo(cb_tipo.getSelectedIndex() + 1);
			relatorio.setTerceirizada(cb_terceirizada.getSelectedIndex() + 1);
			if (validar(relatorio)) {
				file = new ArquivoUtil().gravarPdf(new ServiceClient().GerarRelatorioBoletins(relatorio));
				abrirPDF(file);
			} else {
				mensagem();
			}
			limpar1();
		} else if (rb_boletas.isSelected()) {
			relatorio.setBoleta(cb_boletas.getSelectedIndex() + 1);
			if (validar(relatorio)) {
				file = new ArquivoUtil().gravarPdf(new ServiceClient().GerarRelatorioBoletins(relatorio));
				abrirPDF(file);
			} else {
				mensagem();
			}
			limpar1();
		}
	}

	private boolean validar2(Relatorio relatorio) {
		boolean ret = true;
		if ("  -  -    ".equals(relatorio.getInicio())) {
			ret = false;
		}
		if ("  -  -    ".equals(relatorio.getFim())) {
			ret = false;
		}
		if ("".equals(relatorio.getNome())) {
			ret = false;
		}
		return ret;
	}

	private boolean validar(Relatorio relatorio) {
		boolean ret = true;
		if ("    -  -  ".equals(relatorio.getInicio())) {
			ret = false;
		}
		if ("    -  -  ".equals(relatorio.getFim())) {
			ret = false;
		}
		return ret;
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

	private void limpar1() {
		cb_terceirizada.setSelectedIndex(0);
		cb_departamento.setSelectedIndex(0);
		cb_tipo.setSelectedIndex(0);
		txt_nome.setText("");
		limparData();
	}

	private void limparData() {
		txt_data1.setText("");
		txt_data2.setText("");
	}

	private void init() {
		pn1.setVisible(true);
		pn2.setVisible(false);
		pn3.setVisible(false);
	}

	protected void select() {
		if (rb_data.isSelected()) {
			pn1.setVisible(true);
			pn2.setVisible(false);
			pn3.setVisible(false);
			pn4.setVisible(false);
		} else if (rb_nome.isSelected()) {
			pn1.setVisible(false);
			pn2.setVisible(true);
			pn3.setVisible(false);
			pn4.setVisible(false);
		} else if (rb_terceirizada.isSelected()) {
			pn1.setVisible(false);
			pn2.setVisible(false);
			pn3.setVisible(true);
			pn4.setVisible(false);
		} else if (rb_boletas.isSelected()) {
			pn1.setVisible(false);
			pn2.setVisible(false);
			pn3.setVisible(false);
			pn4.setVisible(true);
		}
	}
}
