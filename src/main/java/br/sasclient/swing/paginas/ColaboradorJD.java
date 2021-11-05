package br.sasclient.swing.paginas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import br.com.bo.PessoaBO;
import br.sasclient.entity.Pessoa;
import br.sasclient.service.ServiceClient;
import br.sasclient.swing.msg.MensagensJD2;
import br.sasclient.util.EscolhaFoto;
import br.sasclient.util.Java8Base64Image;
import br.sasclient.util.LimiteTxt;

public class ColaboradorJD extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JPanel jPanel5;
	private JPanel painel_conteudo_colaborador;
	private JPanel jPanel6;
	private JTextField txt_nome;
	private JTextField txt_funcao;
	private JButton btn_registrar;
	private JFormattedTextField txt_dt_inicio;
	private JFormattedTextField txt_cpf;
	private JFormattedTextField txt_telefone;
	private Pessoa pessoa = new Pessoa();
	private static int aux_controle;
	private static MensagensJD2 mensagensJD;
	private JFormattedTextField txt_dt_encerramento;
	private JLabel lbl_foto;
	private JButton btn_capturar_foto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ColaboradorJD dialog = new ColaboradorJD();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ColaboradorJD() {
		setModal(true);
		setResizable(false);
		initComponents();
	}

	private void initComponents() {
		setBounds(100, 100, 870, 446);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		Toolkit toolkit = getToolkit();
		Dimension d = toolkit.getScreenSize();
		setLocation(d.width / 2 - getWidth() / 2, d.height / 2 - getHeight() / 2);

		jPanel5 = new JPanel();
		jPanel5.setBounds(0, 0, 864, 32);
		jPanel5.setBackground(new java.awt.Color(0, 103, 71));
		jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		contentPanel.add(jPanel5);
		jPanel5.setLayout(null);

		JLabel jLabel2 = new JLabel("New label");
		jLabel2.setBounds(10, 0, 241, 32);
		jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
		jLabel2.setForeground(new java.awt.Color(255, 255, 255));
		jLabel2.setText("CADASTRO DE COLABORADOR");
		jPanel5.add(jLabel2);

		painel_conteudo_colaborador = new JPanel();
		painel_conteudo_colaborador.setBackground(Color.WHITE);
		painel_conteudo_colaborador.setBounds(0, 32, 864, 385);
		painel_conteudo_colaborador.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		contentPanel.add(painel_conteudo_colaborador);
		painel_conteudo_colaborador.setLayout(null);

		jPanel6 = new JPanel();
		jPanel6.setBackground(Color.WHITE);
		jPanel6.setBounds(10, 11, 587, 169);
		jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		painel_conteudo_colaborador.add(jPanel6);
		jPanel6.setLayout(null);

		JLabel jLabel13 = new JLabel();
		jLabel13.setText("CPF");
		jLabel13.setBounds(76, 45, 73, 14);
		jPanel6.add(jLabel13);

		txt_cpf = new JFormattedTextField();
		txt_cpf.setBounds(159, 42, 171, 31);
		try {
			txt_cpf.setFormatterFactory(
					new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
		} catch (java.text.ParseException ex) {
			ex.printStackTrace();
		}
		txt_cpf.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				txt_cpfKeyPressed(evt);
			}
		});
		jPanel6.add(txt_cpf);

		JLabel jLabel14 = new JLabel();
		jLabel14.setText("Nome");
		jLabel14.setBounds(76, 98, 73, 14);
		jPanel6.add(jLabel14);

		txt_nome = new JTextField();
		txt_nome.setDocument(new LimiteTxt(100));
		txt_nome.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txt_nome.setBounds(159, 89, 352, 31);
		txt_nome.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				txt_nomeKeyPressed(evt);
			}
		});
		jPanel6.add(txt_nome);

		txt_telefone = new JFormattedTextField();
		txt_telefone.setBounds(159, 131, 104, 27);
		try {
			txt_telefone.setFormatterFactory(
					new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
		} catch (java.text.ParseException ex) {
			ex.printStackTrace();
		}

		txt_telefone.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				txt_telefoneKeyPressed(evt);
			}
		});
		jPanel6.add(txt_telefone);

		JLabel jLabel15 = new JLabel();
		jLabel15.setText("Telefone");
		jLabel15.setBounds(76, 141, 73, 14);
		jPanel6.add(jLabel15);

		JPanel jPanel7 = new JPanel();
		jPanel7.setBounds(0, 0, 587, 31);
		jPanel7.setBackground(new java.awt.Color(0, 103, 71));
		jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		jPanel6.add(jPanel7);
		jPanel7.setLayout(null);

		JLabel jLabel3 = new JLabel("New label");
		jLabel3.setBounds(262, 0, 102, 31);
		jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
		jLabel3.setForeground(new java.awt.Color(255, 255, 255));
		jLabel3.setText("Dados Gerais");
		jPanel7.add(jLabel3);

		JPanel jPanel8 = new JPanel();
		jPanel8.setBackground(Color.WHITE);
		jPanel8.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel8.setBounds(10, 191, 587, 149);
		painel_conteudo_colaborador.add(jPanel8);

		JPanel jPanel9 = new JPanel();
		jPanel9.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel9.setBackground(new Color(0, 103, 71));

		JLabel jLabel16 = new JLabel();
		jLabel16.setText("Complemento");
		jLabel16.setForeground(Color.WHITE);
		jLabel16.setFont(new Font("Segoe UI", Font.BOLD, 10));
		GroupLayout gl_jPanel9 = new GroupLayout(jPanel9);
		gl_jPanel9.setHorizontalGroup(gl_jPanel9.createParallelGroup(Alignment.LEADING).addGap(0, 988, Short.MAX_VALUE)
				.addGroup(gl_jPanel9.createSequentialGroup().addContainerGap(485, Short.MAX_VALUE)
						.addComponent(jLabel16).addContainerGap(486, Short.MAX_VALUE)));
		gl_jPanel9.setVerticalGroup(gl_jPanel9.createParallelGroup(Alignment.LEADING).addGap(0, 24, Short.MAX_VALUE)
				.addComponent(jLabel16, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE));
		jPanel9.setLayout(gl_jPanel9);

		JPanel jPanel10 = new JPanel();
		jPanel10.setBackground(new Color(204, 204, 204));
		GroupLayout gl_jPanel10 = new GroupLayout(jPanel10);
		gl_jPanel10.setHorizontalGroup(gl_jPanel10.createParallelGroup(Alignment.LEADING)
				.addGap(0, 968, Short.MAX_VALUE).addGap(0, 1020, Short.MAX_VALUE));
		gl_jPanel10.setVerticalGroup(gl_jPanel10.createParallelGroup(Alignment.LEADING).addGap(0, 0, Short.MAX_VALUE)
				.addGap(0, 0, Short.MAX_VALUE));
		jPanel10.setLayout(gl_jPanel10);

		JLabel jLabel19 = new JLabel();
		jLabel19.setText("Encerramento");
		jLabel19.setFont(new Font("Segoe UI", Font.BOLD, 10));

		JLabel jLabel17 = new JLabel();
		jLabel17.setFont(new Font("Segoe UI", Font.BOLD, 10));
		jLabel17.setText("Função");

		JLabel jLabel18 = new JLabel();
		jLabel18.setText("Data Início");
		jLabel18.setFont(new Font("Segoe UI", Font.BOLD, 10));

		txt_funcao = new JTextField();
		txt_funcao.setDocument(new LimiteTxt(50));
		txt_funcao.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txt_funcao.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				txt_funcaoKeyPressed(evt);
			}
		});

		txt_dt_encerramento = new JFormattedTextField();

		txt_dt_inicio = new JFormattedTextField();
		try {
			txt_dt_inicio.setFormatterFactory(
					new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
		} catch (java.text.ParseException ex) {
			ex.printStackTrace();
		}

		txt_dt_inicio.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				txt_dt_inicioKeyPressed(evt);
			}
		});

		try {
			txt_dt_encerramento.setFormatterFactory(
					new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
		} catch (java.text.ParseException ex) {
			ex.printStackTrace();
		}
		GroupLayout gl_jPanel8 = new GroupLayout(jPanel8);
		gl_jPanel8.setHorizontalGroup(gl_jPanel8.createParallelGroup(Alignment.LEADING)
				.addComponent(jPanel9, GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
				.addGroup(gl_jPanel8.createSequentialGroup().addContainerGap()
						.addComponent(jPanel10, GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE).addContainerGap())
				.addGroup(gl_jPanel8.createSequentialGroup().addGap(73)
						.addGroup(gl_jPanel8.createParallelGroup(Alignment.LEADING).addComponent(jLabel18)
								.addGroup(gl_jPanel8.createSequentialGroup().addComponent(jLabel19).addGap(18))
								.addComponent(jLabel17))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_jPanel8.createParallelGroup(Alignment.LEADING)
								.addComponent(txt_funcao, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_jPanel8.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(txt_dt_inicio, Alignment.LEADING)
										.addComponent(txt_dt_encerramento, Alignment.LEADING,
												GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)))
						.addGap(101)));
		gl_jPanel8.setVerticalGroup(gl_jPanel8.createParallelGroup(Alignment.LEADING).addGroup(gl_jPanel8
				.createSequentialGroup()
				.addComponent(jPanel9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(jPanel10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE)
				.addGroup(gl_jPanel8.createParallelGroup(Alignment.BASELINE)
						.addComponent(txt_funcao, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel17))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_jPanel8.createParallelGroup(Alignment.BASELINE)
						.addComponent(txt_dt_inicio, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel18))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_jPanel8.createParallelGroup(Alignment.BASELINE)
						.addComponent(txt_dt_encerramento, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel19))
				.addGap(20)));
		jPanel8.setLayout(gl_jPanel8);

		btn_registrar = new JButton();
		btn_registrar.setToolTipText("");
		btn_registrar.setText("Registrar");
		btn_registrar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btn_registrar.setBackground(new Color(192, 220, 243));
		btn_registrar.setBounds(10, 349, 587, 25);
		btn_registrar.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btn_registrarMouseClicked(evt);
			}
		});
		btn_registrar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btn_registrarActionPerformed(evt);
			}
		});
		btn_registrar.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				btn_registrarKeyPressed(evt);
			}
		});
		painel_conteudo_colaborador.add(btn_registrar);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(607, 11, 240, 350);
		painel_conteudo_colaborador.add(panel);
		panel.setLayout(null);

		JPanel jp_container_cam = new JPanel();
		jp_container_cam.setBackground(Color.LIGHT_GRAY);
		jp_container_cam.setBounds(10, 11, 220, 282);

		panel.add(jp_container_cam);
		jp_container_cam.setLayout(null);

		lbl_foto = new JLabel("");
		lbl_foto.setIcon(new ImageIcon(ColaboradorJD.class.getResource("/br/sasclient/imagens/cam_120px.png")));
		lbl_foto.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_foto.setBounds(0, 0, 220, 282);
		jp_container_cam.add(lbl_foto);

		btn_capturar_foto = new JButton();
		btn_capturar_foto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(!"".equals(txt_nome.getText().toString())) {
					EscolhaFoto escolhaFoto = new EscolhaFoto();
					escolhaFoto.setVisible(true);
					new Thread() {
						public void run() {
							while (escolhaFoto.isVisible()) {
							}
							String foto = escolhaFoto.getFoto();
							pessoa.setFoto(foto);
							lbl_foto.setIcon(new ImageIcon(
									new Java8Base64Image().decoder120Imagen(foto, txt_nome.getText().toString())));
						};
					}.start();
				} else {
					MensagensJD2 jd = new MensagensJD2("Preencha o campo nome!", "Campo nome");
					jd.setVisible(true);
				}
			}
		});
		btn_capturar_foto.setToolTipText("");
		btn_capturar_foto.setText("Foto");
		btn_capturar_foto.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btn_capturar_foto.setBackground(new Color(192, 220, 243));
		btn_capturar_foto.setBounds(10, 314, 220, 25);
		btn_capturar_foto.setEnabled(false);
		panel.add(btn_capturar_foto);
	}

	private void txt_dt_inicioKeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txt_dt_inicioKeyPressed
		if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
			btn_registrar.requestFocus();
		}
	}

	private void txt_funcaoKeyPressed(java.awt.event.KeyEvent evt) {
		if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
			txt_dt_inicio.requestFocus();
		}
	}

	private void txt_cpfKeyPressed(java.awt.event.KeyEvent evt) {

		if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
			if (!"   .   .   -  ".equals(txt_cpf.getText().toString())) {

				pessoa.setCpf(txt_cpf.getText().toString());
				pessoa.setCodigo(0);
				pessoa = new ServiceClient().consultarPessoa(pessoa);

				if (pessoa.getCodigo() != 0) {
					txt_nome.setText(pessoa.getNome());
					txt_telefone.setText(pessoa.getTelefone());
					txt_funcao.setText(pessoa.getFuncao());
					txt_dt_inicio.setText(pessoa.getData_inicio());
					if (pessoa.getData_fim() != null) {
						txt_dt_encerramento.setText(pessoa.getData_fim());
					}
					lbl_foto.setIcon(new ImageIcon(new Java8Base64Image().decoder(pessoa.getFoto(), pessoa.getNome())));
					btn_capturar_foto.setEnabled(true);
					aux_controle = 1;
				} else {
					limparColaboradorCPF();
				}
				txt_nome.requestFocus();
			} else {
				mensagensJD = new MensagensJD2("CPF inválido!", "Colaborador");
				mensagensJD.setVisible(true);
			}

		}

	}

	private void txt_nomeKeyPressed(java.awt.event.KeyEvent evt) {
		if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
			txt_telefone.requestFocus();
		}
	}

	private void txt_telefoneKeyPressed(java.awt.event.KeyEvent evt) {
		if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
			txt_funcao.requestFocus();
		}
	}

	/**
	 * ESTA FUN��O ESTA VINCULADA AO PAINEL DE CADASTRO DE COLABORADOR
	 * 
	 * @param evt
	 */
	private void btn_registrarKeyPressed(java.awt.event.KeyEvent evt) {
		cad_colaborador();
	}

	private void btn_registrarMouseClicked(java.awt.event.MouseEvent evt) {
		cad_colaborador();
	}

	private void btn_registrarActionPerformed(java.awt.event.ActionEvent evt) {

	}

	private void cad_colaborador() {
		if (aux_controle != 1) {
			pessoa.setCpf(txt_cpf.getText().toString());
			pessoa.setNome(txt_nome.getText().toString());
			pessoa.setTelefone(txt_telefone.getText().toString());
			pessoa.setFuncao(txt_funcao.getText().toString());
			pessoa.setData_inicio(txt_dt_inicio.getText().toString());
		}

		PessoaBO bo = new PessoaBO();

		// Caso seja colocado a data de encerramento
		if (aux_controle == 1) {
			alterarColaborador(pessoa);
			limparColaborador();
		} else if (bo.validar(pessoa)) {
			mensagensJD = new MensagensJD2(new ServiceClient().CadastrarColaborador(pessoa), "Colaborador");
			mensagensJD.setVisible(true);
			limparColaborador();
		} else {
			mensagensJD = new MensagensJD2("Preencha todos os campos", "Colaborador");
			mensagensJD.setVisible(true);
		}

		txt_cpf.requestFocus();
	}

	private void limparColaborador() {
		pessoa = new Pessoa();
		txt_cpf.setText("");
		txt_nome.setText("");
		txt_telefone.setText("");
		txt_funcao.setText("");
		txt_dt_inicio.setText("");
		txt_dt_encerramento.setText("");
		lbl_foto.setIcon(new ImageIcon(ColaboradorJD.class.getResource("/br/sasclient/imagens/cam_120px.png")));
		aux_controle = 0;
	}

	private void limparColaboradorCPF() {
		pessoa = new Pessoa();
		txt_nome.setText("");
		txt_telefone.setText("");
		txt_funcao.setText("");
		txt_dt_inicio.setText("");
		txt_dt_encerramento.setText("");
		lbl_foto.setIcon(new ImageIcon(ColaboradorJD.class.getResource("/br/sasclient/imagens/cam_120px.png")));
		btn_capturar_foto.setEnabled(true);
		aux_controle = 0;
	}

	private void alterarColaborador(Pessoa pessoa) {
		if (!"  -  -    ".equals(txt_dt_encerramento.getText().toString())) {
			pessoa.setData_fim(txt_dt_encerramento.getText().toString());
		}
		mensagensJD = new MensagensJD2(new ServiceClient().AlterarPessoa(pessoa), "Atualizar Colaborador");
		mensagensJD.setVisible(true);
	}
}
