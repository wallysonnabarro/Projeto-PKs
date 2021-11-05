package br.sasclient.swing.submenus;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import br.com.bo.OcorrenciaBO;
import br.sasclient.entity.Ocorrencia;
import br.sasclient.entity.Ocorrencias;
import br.sasclient.model.JtableModelOcorrencias;
import br.sasclient.service.ServiceClient;
import br.sasclient.swing.msg.MensagensJD2;
import br.sasclient.util.LimiteNumeros;
import br.sasclient.util.LimiteTxt;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFormattedTextField;

public class CriarOcorrencias extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txt_id;
	private JTextField txt_nome;
	private JTextField txt_grupo;
	private Ocorrencias ocorrencias;
	private JtableModelOcorrencias modelOcorrencias;
	private JTable table;
	private JLabel lbl_texto_cor;
	private JPanel jp_cor;
	private Color COLOR = Color.lightGray;
	private Color COLOR_TEXTO = Color.lightGray;
	private String Cor_Background = "";
	private String Cor_Texto = "";
	private JRadioButton rb_inativo;
	private int StatusRegistro = 0;
	private Ocorrencia ocorrenciaAtualizacao = new Ocorrencia();
	private JFormattedTextField txt_segundo;
	private JFormattedTextField txt_primeiro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CriarOcorrencias dialog = new CriarOcorrencias();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CriarOcorrencias() {
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 606, 539);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		Toolkit toolkit = getToolkit();
		Dimension d = toolkit.getScreenSize();
		setLocation(d.width / 2 - getWidth() / 2, d.height / 2 - getHeight() / 2);

		JPanel panel = new JPanel();
		panel.setBackground(new java.awt.Color(0, 103, 71));
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(0, 0, 599, 36);
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Criar Ocorrência");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(10, 0, 148, 36);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(10, 47, 46, 14);
		contentPanel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Nome");
		lblNewLabel_2.setBounds(10, 89, 46, 36);
		contentPanel.add(lblNewLabel_2);

		txt_id = new JTextField();
		txt_id.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				txt_idKeyPressed(e);
			}
		});
		txt_id.setDocument(new LimiteNumeros(5));
		txt_id.setBounds(61, 44, 86, 28);
		contentPanel.add(txt_id);
		txt_id.setColumns(10);

		txt_nome = new JTextField();
		txt_nome.setDocument(new LimiteTxt(45));
		txt_nome.setBounds(61, 92, 311, 28);
		contentPanel.add(txt_nome);
		txt_nome.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Grupo");
		lblNewLabel_3.setBounds(172, 47, 46, 14);
		contentPanel.add(lblNewLabel_3);

		txt_grupo = new JTextField();
		txt_grupo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					txt_nome.requestFocus();
				}
			}
		});
		txt_grupo.setDocument(new LimiteNumeros(2));
		txt_grupo.setBounds(223, 44, 46, 28);
		contentPanel.add(txt_grupo);
		txt_grupo.setColumns(10);

		JButton btn_cor_fundo = new JButton("Cor Fundo");
		btn_cor_fundo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getColor(1);
			}
		});
		btn_cor_fundo.setBounds(397, 43, 94, 23);
		contentPanel.add(btn_cor_fundo);

		jp_cor = new JPanel();
		jp_cor.setBackground(Color.WHITE);
		jp_cor.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jp_cor.setBounds(397, 77, 193, 36);
		contentPanel.add(jp_cor);
		jp_cor.setLayout(null);

		lbl_texto_cor = new JLabel("Cor");
		lbl_texto_cor.setForeground(Color.BLACK);
		lbl_texto_cor.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lbl_texto_cor.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_texto_cor.setBounds(0, 0, 193, 36);
		jp_cor.add(lbl_texto_cor);

		JButton btn_cor_texto = new JButton("Cor Text");
		btn_cor_texto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getColor(2);
			}
		});
		btn_cor_texto.setBounds(501, 43, 89, 23);
		contentPanel.add(btn_cor_texto);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 195, 580, 294);
		contentPanel.add(panel_2);
		panel_2.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 580, 294);
		panel_2.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StatusRegistro = table.getSelectedRow();
				ocorrenciaAtualizacao = ocorrencias.get(StatusRegistro);
				txt_id.setText(String.valueOf(ocorrenciaAtualizacao.getId()));
				txt_grupo.setText(String.valueOf(ocorrenciaAtualizacao.getGrupo()));
				txt_nome.setText(ocorrenciaAtualizacao.getNome());
				txt_primeiro.setText(ocorrenciaAtualizacao.getPrimeiro());
				txt_segundo.setText(ocorrenciaAtualizacao.getSegundo());
				carregaCores(ocorrenciaAtualizacao);
			}
		});
		scrollPane.setViewportView(table);

		ocorrencias = new ServiceClient().ConsultarTodasOcorrencias();
		modelOcorrencias = new JtableModelOcorrencias(ocorrencias);
		table.setModel(modelOcorrencias);

		carregaNumeroId();

		JButton btn_registrar = new JButton("Registrar");
		btn_registrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				registrar();
			}
		});
		btn_registrar.setBounds(455, 136, 135, 23);
		contentPanel.add(btn_registrar);

		rb_inativo = new JRadioButton("Inativo");
		rb_inativo.setBounds(298, 43, 74, 23);
		contentPanel.add(rb_inativo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(10, 124, 362, 60);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Temporizador");
		lblNewLabel_4.setBounds(10, 0, 80, 14);
		panel_1.add(lblNewLabel_4);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_3.setBackground(new Color(240, 230, 140));
		panel_3.setBounds(116, 11, 70, 14);
		panel_1.add(panel_3);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_3_1.setBackground(new Color(255, 0, 0));
		panel_3_1.setBounds(237, 11, 70, 14);
		panel_1.add(panel_3_1);
		
		JLabel lblNewLabel_5 = new JLabel("1º");
		lblNewLabel_5.setBounds(94, 35, 17, 14);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("2º");
		lblNewLabel_5_1.setBounds(210, 35, 17, 14);
		panel_1.add(lblNewLabel_5_1);
		
		txt_primeiro = new JFormattedTextField();
		try {
			txt_primeiro.setFormatterFactory(
					new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##:##")));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txt_primeiro.setBounds(116, 28, 70, 28);
		panel_1.add(txt_primeiro);
		
		txt_segundo = new JFormattedTextField();
		try {
			txt_segundo.setFormatterFactory(
					new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##:##")));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txt_segundo.setBounds(237, 28, 70, 28);
		panel_1.add(txt_segundo);
	}

	protected void registrar() {
 		if(StatusRegistro != 0) {
 			ocorrenciaAtualizacao.setNome(txt_nome.getText().toString());
 			ocorrenciaAtualizacao.setCor_fundo(Cor_Background);
 			ocorrenciaAtualizacao.setCor_texto(Cor_Texto);
 			ocorrenciaAtualizacao.setPrimeiro(txt_primeiro.getText().toString());
 			ocorrenciaAtualizacao.setSegundo(txt_segundo.getText().toString());
 			ocorrenciaAtualizacao.setGrupo(Integer.parseInt(txt_grupo.getText().toString()));
 		
 			if(rb_inativo.isSelected()) {
 				ocorrenciaAtualizacao.setInativo(1);
 			} else {
 				ocorrenciaAtualizacao.setInativo(0);
 			}
			MensagensJD2 msg = new MensagensJD2(new ServiceClient().AlterarOcorrencia(ocorrenciaAtualizacao), "Alterar de Ocorrência");
			modelOcorrencias.removerOcorrencias(StatusRegistro);
			modelOcorrencias.addOcorrencias(ocorrenciaAtualizacao);
			StatusRegistro = 0;
			msg.setVisible(true);
 		} else {
 			Ocorrencia ocorrencia = new Ocorrencia();
 			ocorrencia.setNome(txt_nome.getText().toString());
 			ocorrencia.setCor_fundo(Cor_Background);
 			ocorrencia.setCor_texto(Cor_Texto);
 			ocorrencia.setPrimeiro(txt_primeiro.getText().toString());
 			ocorrencia.setSegundo(txt_segundo.getText().toString());
 			ocorrencia.setGrupo(Integer.parseInt(txt_grupo.getText().toString()));
 		
 			if(rb_inativo.isSelected()) {
 				ocorrencia.setInativo(1);
 			} else {
 				ocorrencia.setInativo(0);
 			}
 			
 	 		String ret = new OcorrenciaBO().validarRegistrar(ocorrencia);
 			if (ret == "") {
 				MensagensJD2 msg = new MensagensJD2(new ServiceClient().CadastrarOcorrencia(ocorrencia), "Cadastro de Ocorrência");
 				modelOcorrencias.addOcorrencias(ocorrencia);
 				msg.setVisible(true);
 			} else {
 				MensagensJD2 msg = new MensagensJD2(ret, "Preencha");
 				msg.setVisible(true);
 			}
 		}
	}

	protected void txt_idKeyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			Ocorrencia ocorrencia = new ServiceClient()
					.consultarIdOcorrencia(Integer.parseInt(txt_id.getText().toString()));
			if (ocorrencia.getId() != 0) {
				txt_grupo.setText(String.valueOf(ocorrencia.getGrupo()));
				txt_nome.setText(ocorrencia.getNome());
				if (ocorrencia.getInativo() == 1) {
					rb_inativo.setSelected(true);
				}
				StatusRegistro = 1;
				carregaCores(ocorrencia);
			} else {
				carregaNumeroId();
				txt_grupo.setText("");
				txt_nome.setText("");
				jp_cor.setBackground(Color.WHITE);
				lbl_texto_cor.setForeground(Color.BLACK);
				txt_grupo.requestFocus();
			}
		}
	}

	protected void getColor(int i) {
		if (i == 1) {// background
			COLOR = JColorChooser.showDialog(CriarOcorrencias.this, "Selecione uma cor", COLOR);

			if (COLOR == null) {
				COLOR = Color.lightGray;
			} else {
				String txt_ = String.valueOf(COLOR.toString());
				jp_cor.setBackground(COLOR);

				corSplit(txt_, i);

				repaint();
			}
		} else {
			COLOR_TEXTO = JColorChooser.showDialog(CriarOcorrencias.this, "Selecione uma cor", COLOR_TEXTO);

			if (COLOR_TEXTO == null) {
				COLOR_TEXTO = Color.lightGray;
			} else {
				String txt_ = String.valueOf(COLOR_TEXTO.toString());
				lbl_texto_cor.setForeground(COLOR_TEXTO);

				corSplit(txt_, i);

				repaint();
			}
		}
	}

	private void corSplit(String t, int j) {
		String cor[] = new String[3];
		String corN[][] = new String[3][2];
		String corF[] = new String[2];
		cor = t.split(",");

		for (int i = 0; i < cor.length; i++) {
			corN[i] = cor[i].split("=");
		}

		corF = corN[2][1].split("]");

		if (j == 1) {
			Cor_Background = String.valueOf(corN[0][1] + "," + corN[1][1] + "," + corF[0]);
		} else {
			Cor_Texto = String.valueOf(corN[0][1] + "," + corN[1][1] + "," + corF[0]);
		}

	}

	private void carregaNumeroId() {
		if (ocorrencias.size() != 0) {
			int i = ocorrencias.size() + 1;
			txt_id.setText(String.valueOf(i));
		} else {
			txt_id.setText("0");
		}
	}

	private void carregaCores(Ocorrencia ocorrencia) {
		String[] fundo = new String[3];
		String[] texto = new String[3];

		fundo = ocorrencia.getCor_fundo().split(",");
		texto = ocorrencia.getCor_texto().split(",");

		COLOR = new Color(Integer.parseInt(fundo[0]), Integer.parseInt(fundo[1]), Integer.parseInt(fundo[2]));
		COLOR_TEXTO = new Color(Integer.parseInt(texto[0]), Integer.parseInt(texto[1]), Integer.parseInt(texto[2]));

		Cor_Background = ocorrencia.getCor_fundo();
		Cor_Texto = ocorrencia.getCor_texto();
		
		jp_cor.setBackground(COLOR);
		lbl_texto_cor.setForeground(COLOR_TEXTO);
	}
}
