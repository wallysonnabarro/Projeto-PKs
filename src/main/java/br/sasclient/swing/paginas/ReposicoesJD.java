package br.sasclient.swing.paginas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EtchedBorder;

import br.com.bo.ReposicoesBO;
import br.sasclient.entity.Pessoa;
import br.sasclient.entity.Pessoas;
import br.sasclient.entity.Reposicoes;
import br.sasclient.model.JtableModelReposicoes;
import br.sasclient.service.ServiceClient;
import br.sasclient.swing.msg.MensagensJD2;
import br.sasclient.util.LimiteTxt;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ReposicoesJD extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txt_nome_reposicao;
	private JTextField txt_local;
	private JTable jt_tabela_reposicoes;
	private JtableModelReposicoes jtableModelReposicoes;
	private ArrayList<Reposicoes> listaReposicoes;
	private JRadioButton rb_banco_horas;
	private JRadioButton rb_geop;
	private JRadioButton rb_mkt;
	private JRadioButton rb_falta_reposicao;
	private JRadioButton rb_atrasos_reposicao;
	private JRadioButton rb_vigilancia_reposicao;
	private JRadioButton rb_especializada_reposocao;
	private JFormattedTextField txt_data_reposicao;
	private JButton btn_registrar_reposicao;
	private javax.swing.ButtonGroup bg_reposicao_departamento;
	private javax.swing.ButtonGroup bg_reposicoes_falta_atraso;
	private javax.swing.ButtonGroup bg_tipo_posto;
	private Set<String> lNomes;
	private Pessoas pessoas = new Pessoas();
	private static MensagensJD2 mensagensJD;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ReposicoesJD dialog = new ReposicoesJD();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ReposicoesJD() {
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 984, 601);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		Toolkit toolkit = getToolkit();
		Dimension d = toolkit.getScreenSize();
		setLocation(d.width / 2 - getWidth() / 2, d.height / 2 - getHeight() / 2);

		JPanel jPanel120 = new JPanel();
		jPanel120.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel120.setBackground(new Color(0, 103, 71));
		jPanel120.setBounds(0, 0, 978, 28);
		contentPanel.add(jPanel120);

		JLabel jLabel8 = new JLabel();
		jLabel8.setText("Reposições de Faltas e Atrasos");
		jLabel8.setForeground(Color.WHITE);
		jLabel8.setFont(new Font("Segoe UI", Font.BOLD, 10));
		GroupLayout gl_jPanel120 = new GroupLayout(jPanel120);
		gl_jPanel120
				.setHorizontalGroup(gl_jPanel120.createParallelGroup(Alignment.LEADING).addGap(0, 976, Short.MAX_VALUE)
						.addGroup(gl_jPanel120.createSequentialGroup().addContainerGap()
								.addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(871, Short.MAX_VALUE)));
		gl_jPanel120.setVerticalGroup(gl_jPanel120.createParallelGroup(Alignment.LEADING).addGap(0, 28, Short.MAX_VALUE)
				.addComponent(jLabel8, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE));
		jPanel120.setLayout(gl_jPanel120);

		JPanel jPanel122 = new JPanel();
		jPanel122.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel122.setBounds(10, 33, 424, 133);
		contentPanel.add(jPanel122);

		JLabel jLabel9 = new JLabel();
		jLabel9.setText("Nome");

		JLabel jLabel10 = new JLabel();
		jLabel10.setText("Local");

		JLabel jLabel116 = new JLabel();
		jLabel116.setText("Data");

		txt_nome_reposicao = new JTextField();
		txt_nome_reposicao.setDocument(new LimiteTxt(100));
		txt_nome_reposicao.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				txt_nome_reposicaoKeyPressed(evt);
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				txt_nome_reposicaoKeyRelease(arg0);
			}
		});

		txt_local = new JTextField();
		txt_local.setDocument(new LimiteTxt(100));
		txt_local.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				txt_localKeyPressed(evt);
			}
		});

		txt_data_reposicao = new JFormattedTextField();
		try {
			txt_data_reposicao.setFormatterFactory(
					new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
		} catch (java.text.ParseException ex) {
			ex.printStackTrace();
		}
		txt_data_reposicao.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				txt_data_reposicaoKeyPressed(evt);
			}
		});
		GroupLayout gl_jPanel122 = new GroupLayout(jPanel122);
		gl_jPanel122.setHorizontalGroup(gl_jPanel122.createParallelGroup(Alignment.LEADING).addGroup(gl_jPanel122
				.createSequentialGroup().addGap(19)
				.addGroup(gl_jPanel122.createParallelGroup(Alignment.LEADING).addComponent(jLabel9)
						.addComponent(jLabel10).addComponent(jLabel116))
				.addGap(18)
				.addGroup(gl_jPanel122.createParallelGroup(Alignment.LEADING)
						.addComponent(txt_local, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
						.addComponent(txt_data_reposicao, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
						.addComponent(txt_nome_reposicao, GroupLayout.PREFERRED_SIZE, 344, GroupLayout.PREFERRED_SIZE))
				.addGap(16)));
		gl_jPanel122
				.setVerticalGroup(gl_jPanel122.createParallelGroup(Alignment.LEADING).addGap(0, 133, Short.MAX_VALUE)
						.addGroup(gl_jPanel122.createSequentialGroup().addContainerGap()
								.addGroup(gl_jPanel122.createParallelGroup(Alignment.BASELINE).addComponent(jLabel9)
										.addComponent(txt_nome_reposicao, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(gl_jPanel122.createParallelGroup(Alignment.BASELINE).addComponent(jLabel10)
										.addComponent(txt_local, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(gl_jPanel122.createParallelGroup(Alignment.BASELINE)
										.addComponent(txt_data_reposicao, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel116))
								.addContainerGap(22, Short.MAX_VALUE)));
		jPanel122.setLayout(gl_jPanel122);

		JPanel jPanel121 = new JPanel();
		jPanel121.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel121.setBounds(440, 33, 526, 133);
		contentPanel.add(jPanel121);

		JPanel jPanel124 = new JPanel();
		jPanel124.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel124.setBackground(Color.WHITE);

		bg_reposicao_departamento = new javax.swing.ButtonGroup();
		rb_banco_horas = new JRadioButton();
		rb_banco_horas.setText("Banco de Horas");
		rb_banco_horas.setSelected(true);
		bg_reposicao_departamento.add(rb_banco_horas);

		rb_geop = new JRadioButton();
		rb_geop.setText("GEOP");
		bg_reposicao_departamento.add(rb_geop);

		rb_mkt = new JRadioButton();
		rb_mkt.setText("MKT");
		bg_reposicao_departamento.add(rb_mkt);

		GroupLayout gl_jPanel124 = new GroupLayout(jPanel124);
		gl_jPanel124.setHorizontalGroup(gl_jPanel124.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 506, Short.MAX_VALUE)
				.addGroup(gl_jPanel124.createSequentialGroup().addGap(89).addComponent(rb_banco_horas).addGap(64)
						.addComponent(rb_geop).addPreferredGap(ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
						.addComponent(rb_mkt).addGap(59)));
		gl_jPanel124.setVerticalGroup(gl_jPanel124.createParallelGroup(Alignment.LEADING).addGap(0, 30, Short.MAX_VALUE)
				.addGroup(gl_jPanel124.createParallelGroup(Alignment.BASELINE)
						.addComponent(rb_geop, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(rb_banco_horas, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addComponent(rb_mkt, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)));
		jPanel124.setLayout(gl_jPanel124);

		JPanel jPanel123 = new JPanel();
		jPanel123.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel123.setBackground(Color.WHITE);

		bg_reposicoes_falta_atraso = new javax.swing.ButtonGroup();
		rb_falta_reposicao = new JRadioButton();
		rb_falta_reposicao.setText("Falta");
		rb_falta_reposicao.setSelected(true);
		bg_reposicoes_falta_atraso.add(rb_falta_reposicao);

		rb_atrasos_reposicao = new JRadioButton();
		rb_atrasos_reposicao.setText("Atrasos");
		bg_reposicoes_falta_atraso.add(rb_atrasos_reposicao);

		GroupLayout gl_jPanel123 = new GroupLayout(jPanel123);
		gl_jPanel123
				.setHorizontalGroup(gl_jPanel123.createParallelGroup(Alignment.LEADING).addGap(0, 506, Short.MAX_VALUE)
						.addGroup(gl_jPanel123.createSequentialGroup().addGap(159).addComponent(rb_falta_reposicao)
								.addGap(70).addComponent(rb_atrasos_reposicao).addContainerGap(165, Short.MAX_VALUE)));
		gl_jPanel123.setVerticalGroup(gl_jPanel123.createParallelGroup(Alignment.LEADING).addGap(0, 30, Short.MAX_VALUE)
				.addGroup(gl_jPanel123.createParallelGroup(Alignment.BASELINE)
						.addComponent(rb_atrasos_reposicao, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
						.addComponent(rb_falta_reposicao, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));
		jPanel123.setLayout(gl_jPanel123);

		JPanel jPanel125 = new JPanel();
		jPanel125.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel125.setBackground(Color.WHITE);

		bg_tipo_posto = new javax.swing.ButtonGroup();
		rb_vigilancia_reposicao = new JRadioButton();
		rb_vigilancia_reposicao.setText("Vigilância");
		rb_vigilancia_reposicao.setSelected(true);
		bg_tipo_posto.add(rb_vigilancia_reposicao);

		rb_especializada_reposocao = new JRadioButton();
		rb_especializada_reposocao.setText("Especializada");
		bg_tipo_posto.add(rb_especializada_reposocao);

		GroupLayout gl_jPanel125 = new GroupLayout(jPanel125);
		gl_jPanel125
				.setHorizontalGroup(gl_jPanel125.createParallelGroup(Alignment.LEADING).addGap(0, 506, Short.MAX_VALUE)
						.addGroup(gl_jPanel125.createSequentialGroup().addGap(160).addComponent(rb_vigilancia_reposicao)
								.addGap(49).addComponent(rb_especializada_reposocao)
								.addContainerGap(139, Short.MAX_VALUE)));
		gl_jPanel125.setVerticalGroup(gl_jPanel125.createParallelGroup(Alignment.LEADING).addGap(0, 33, Short.MAX_VALUE)
				.addGroup(gl_jPanel125.createParallelGroup(Alignment.BASELINE)
						.addComponent(rb_especializada_reposocao, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addComponent(rb_vigilancia_reposicao, GroupLayout.PREFERRED_SIZE, 33,
								GroupLayout.PREFERRED_SIZE)));
		jPanel125.setLayout(gl_jPanel125);
		GroupLayout gl_jPanel121 = new GroupLayout(jPanel121);
		gl_jPanel121
				.setHorizontalGroup(gl_jPanel121.createParallelGroup(Alignment.LEADING).addGap(0, 526, Short.MAX_VALUE)
						.addGroup(gl_jPanel121.createSequentialGroup().addContainerGap()
								.addGroup(gl_jPanel121.createParallelGroup(Alignment.LEADING)
										.addComponent(jPanel124, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(jPanel123, GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
										.addComponent(jPanel125, GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE))
								.addContainerGap()));
		gl_jPanel121
				.setVerticalGroup(
						gl_jPanel121.createParallelGroup(Alignment.LEADING).addGap(0, 133, Short.MAX_VALUE)
								.addGroup(
										gl_jPanel121.createSequentialGroup()
												.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(jPanel124, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(jPanel123, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(jPanel125, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addGap(32)));
		jPanel121.setLayout(gl_jPanel121);

		btn_registrar_reposicao = new JButton();
		btn_registrar_reposicao.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				registrarReposicoes();
				txt_nome_reposicao.requestFocus();
			}
		});
		btn_registrar_reposicao.setText("REGISTRAR");
		btn_registrar_reposicao.setForeground(Color.WHITE);
		btn_registrar_reposicao.setBackground(new Color(40, 88, 127));
		btn_registrar_reposicao.setBounds(268, 177, 383, 28);
		contentPanel.add(btn_registrar_reposicao);

		JScrollPane jScrollPane1 = new JScrollPane();
		jScrollPane1.setBounds(10, 218, 956, 343);
		contentPanel.add(jScrollPane1);
		/**
		 * GET: Lista de Reposicoes
		 */
		listaReposicoes = new ServiceClient().ConsultarTodasReposicoes();
		jtableModelReposicoes = new JtableModelReposicoes(listaReposicoes);
		jt_tabela_reposicoes = new JTable();
		jt_tabela_reposicoes.setModel(jtableModelReposicoes);
		jScrollPane1.setViewportView(jt_tabela_reposicoes);

		carregarPessoas();
	}

	private void txt_nome_reposicaoKeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txt_nome_reposicaoKeyPressed
		if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
			txt_local.requestFocus();
		}
	}

	private void txt_nome_reposicaoKeyRelease(KeyEvent arg0) {

		if (arg0.getKeyCode() == KeyEvent.VK_BACK_SPACE || arg0.getKeyCode() == KeyEvent.VK_DELETE) {

		} else {

			String to_check = txt_nome_reposicao.getText();
			int to_check_length = to_check.length();
			for (String data : lNomes) {
				String check_from_data = "";
				for (int i = 0; i < to_check_length; i++) {
					if (to_check_length <= data.length()) {
						check_from_data = check_from_data + data.charAt(i);
					}
				}
				if (check_from_data.equals(to_check)) {
					txt_nome_reposicao.setText(data);
					txt_nome_reposicao.setSelectionStart(to_check_length);
					txt_nome_reposicao.setSelectionEnd(data.length());
					break;
				}
			}
		}
	}

	private void carregarPessoas() {
		lNomes = new TreeSet<String>();
		if (pessoas.size() != 0) {
			System.out.println(pessoas.size());
			pessoas = new ServiceClient().ConsultarTodasPessoas();
			for (Pessoa pessoa1 : pessoas) {
				lNomes.add(pessoa1.getNome());
			}
		} else {
			pessoas = new ServiceClient().ConsultarTodasPessoas();
			for (Pessoa pessoa1 : pessoas) {
				lNomes.add(pessoa1.getNome());
			}
		}
	}

	private void txt_data_reposicaoKeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txt_data_reposicaoKeyPressed
		if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
			rb_banco_horas.requestFocus();
		}
	}

	private void txt_localKeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txt_localKeyPressed
		if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
			txt_data_reposicao.requestFocus();
		}
	}
	
	private void registrarReposicoes() {
		Reposicoes reposicoes = new Reposicoes();
		reposicoes.setNome(txt_nome_reposicao.getText().toString());
		reposicoes.setLocal(txt_local.getText().toString());
		if(!"  -  -    ".equals(txt_data_reposicao.getText().toString())) {
			reposicoes.setData(txt_data_reposicao.getText().toString());
		}
		if (rb_banco_horas.isSelected()) {
			reposicoes.setDepartamento(1);
		} else if (rb_geop.isSelected()) {
			reposicoes.setDepartamento(2);
		} else {
			reposicoes.setDepartamento(3);
		}
		
		if (rb_falta_reposicao.isSelected()) {
			reposicoes.setTipo(1);
		} else {
			reposicoes.setTipo(2);
		}
		
		if (rb_vigilancia_reposicao.isSelected()) {
			reposicoes.setEsp(1);
		} else {
			reposicoes.setEsp(2);
		}
		String texto = new ReposicoesBO().validador(reposicoes);
		if("".equals(texto)) {
			mensagensJD = new MensagensJD2("Registrando.....", "Registrar");
			mensagensJD.setVisible(true);
			
			mensagensJD = new MensagensJD2(new ServiceClient().CadastrarControleReposicoes(reposicoes), "Reposicões");
			mensagensJD.setVisible(true);
			this.jtableModelReposicoes.addReposicoes(reposicoes);
			limparCamposReposicoes();
			
		} else {
			mensagensJD = new MensagensJD2(texto, "Campos");
			mensagensJD.setVisible(true);
		}
	}
	
	private void limparCamposReposicoes() {
		txt_nome_reposicao.setText("");
		txt_local.setText("");
		txt_data_reposicao.setText("");
	}
}
