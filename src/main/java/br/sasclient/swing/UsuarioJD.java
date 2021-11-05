package br.sasclient.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.bo.UsuarioBO;
import br.sasclient.entity.Usuario;
import br.sasclient.model.JtableModelUsuario;
import br.sasclient.service.ServiceClient;
import br.sasclient.util.CriptoUtil;
import br.sasclient.util.LimiteTxt;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JScrollPane;

public class UsuarioJD extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txt_nome;
	private JTextField txt_usuario;
	private JPasswordField txt_senha;
	private javax.swing.JTable jt_usuarios;
	private JtableModelUsuario jtableModelUsuario;
	private ArrayList<Usuario> listaUsuarios;
	private JCheckBox cb_registrar;
	private JCheckBox cb_relatorios;
	private JCheckBox cb_cadastrar_usuarios;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(UsuarioJD.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(UsuarioJD.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(UsuarioJD.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(UsuarioJD.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		}
		// </editor-fold>
		try {
			UsuarioJD dialog = new UsuarioJD();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public UsuarioJD() {
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 519, 399);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{

			int[] l = setLocationJPainel();
			setLocation(l[0], l[1]);
			
			/**
			 * Lista de todos os usuários do banco de dados
			 */
			listaUsuarios = new ServiceClient().ConsultarTodasUsuarios();
			this.jtableModelUsuario = new JtableModelUsuario(listaUsuarios);

			jt_usuarios = new javax.swing.JTable();

			JPanel jPanel1 = new JPanel();
			jPanel1.setBackground(new Color(255, 255, 255, 255));
			jPanel1.setBounds(0, 0, 515, 373);
			jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
			contentPanel.add(jPanel1);
			jPanel1.setLayout(null);

			JPanel panel_1 = new JPanel();
			panel_1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
			panel_1.setBackground(new java.awt.Color(0, 103, 71));
			panel_1.setBounds(0, 0, 515, 40);
			jPanel1.add(panel_1);
			panel_1.setLayout(null);

			JLabel jLabel1 = new JLabel();
			jLabel1.setBounds(10, 0, 154, 40);

			jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
			jLabel1.setForeground(new java.awt.Color(255, 255, 255));
			jLabel1.setText("Cadastro de Usuários");

			panel_1.add(jLabel1);

			JPanel jPanel3 = new JPanel();
			jPanel3.setBounds(10, 49, 495, 162);
			jPanel3.setBackground(new java.awt.Color(255, 255, 255));
			jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
			jPanel1.add(jPanel3);
			jPanel3.setLayout(null);

			JPanel jPanel4 = new JPanel();
			jPanel4.setBounds(0, 0, 495, 38);
			jPanel4.setBackground(new java.awt.Color(109, 153, 48));
			jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
			jPanel3.add(jPanel4);
			jPanel4.setLayout(null);

			JLabel jLabel2 = new JLabel();
			jLabel2.setBounds(222, 0, 46, 38);
			jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
			jLabel2.setForeground(new java.awt.Color(255, 255, 255));
			jLabel2.setText("Dados");
			jPanel4.add(jLabel2);

			JPanel jPanel5 = new JPanel();
			jPanel5.setBounds(10, 39, 283, 114);
			jPanel5.setBackground(new java.awt.Color(255, 255, 255));
			jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
			jPanel3.add(jPanel5);
			jPanel5.setLayout(null);

			JLabel jLabel3 = new JLabel();
			jLabel3.setText("Nome");
			jLabel3.setBounds(12, 19, 53, 14);
			jPanel5.add(jLabel3);

			txt_nome = new JTextField();
			txt_nome.setBounds(75, 11, 198, 30);
			jPanel5.add(txt_nome);

			JLabel jLabel4 = new JLabel();
			jLabel4.setText("Usuário");
			jLabel4.setBounds(12, 50, 53, 14);
			jPanel5.add(jLabel4);

			txt_usuario = new JTextField();
			txt_usuario.setBounds(75, 42, 114, 30);
			jPanel5.add(txt_usuario);

			JLabel jLabel5 = new JLabel();
			jLabel5.setText("Senha");
			jLabel5.setBounds(12, 81, 53, 14);
			jPanel5.add(jLabel5);

			txt_senha = new JPasswordField();
			txt_senha.setBounds(75, 73, 198, 30);
			jPanel5.add(txt_senha);

			txt_nome.setDocument(new LimiteTxt(100));
			txt_nome.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyPressed(java.awt.event.KeyEvent evt) {
					txt_nomeKeyPressed(evt);
				}
			});

			txt_usuario.setDocument(new LimiteTxt(10));

			JPanel jPanel6 = new JPanel();
			jPanel6.setBounds(303, 39, 182, 114);
			jPanel6.setBackground(new java.awt.Color(255, 255, 255));
			jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
			jPanel3.add(jPanel6);
			jPanel6.setLayout(null);

			JPanel jPanel7 = new JPanel();
			jPanel7.setBounds(0, 0, 182, 23);
			jPanel7.setBackground(new java.awt.Color(109, 153, 48));
			jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
			jPanel6.add(jPanel7);
			jPanel7.setLayout(null);

			JLabel jLabel6 = new JLabel();
			jLabel6.setBounds(69, 0, 46, 25);
			jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
			jLabel6.setForeground(new java.awt.Color(255, 255, 255));
			jLabel6.setText("Acesso");
			jPanel7.add(jLabel6);

			cb_registrar = new JCheckBox();
			cb_registrar.setText("Registrar");
			cb_registrar.setBounds(10, 30, 148, 23);
			jPanel6.add(cb_registrar);

			cb_relatorios = new JCheckBox();
			cb_relatorios.setText("Relatórios");
			cb_relatorios.setBounds(10, 56, 148, 23);
			cb_relatorios.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					cbRelatoriosAddActionLinestener();
				}
			});
			jPanel6.add(cb_relatorios);

			cb_cadastrar_usuarios = new JCheckBox();
			cb_cadastrar_usuarios.setText("Cadastrar Usuários");
			cb_cadastrar_usuarios.setBounds(10, 84, 148, 23);
			cb_cadastrar_usuarios.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					cbCadastrar_usuariosAddActionLinestener();
				}
			});
			jPanel6.add(cb_cadastrar_usuarios);

			JButton btn_excluir = new JButton();
			btn_excluir.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					removerUsuario();
				}
			});
			btn_excluir.setText("EXCLUIR");
			btn_excluir.setForeground(new Color(51, 51, 51));
			btn_excluir.setFont(new Font("Segoe UI", Font.BOLD, 12));
			btn_excluir.setBackground(new Color(192, 220, 243));
			btn_excluir.setBounds(92, 217, 171, 25);
			jPanel1.add(btn_excluir);

			JButton jButton1 = new JButton();
			jButton1.setText("SALVAR");
			jButton1.setForeground(new Color(51, 51, 51));
			jButton1.setFont(new Font("Segoe UI", Font.BOLD, 12));
			jButton1.setBackground(new Color(192, 220, 243));
			jButton1.setBounds(281, 217, 171, 25);
			jPanel1.add(jButton1);

			jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent evt) {
					jButton1MouseClicked(evt);
				}
			});

			JScrollPane jScrollPane1 = new JScrollPane();
			jScrollPane1.setBounds(10, 252, 495, 110);

			jt_usuarios.setModel(jtableModelUsuario);

			jScrollPane1.setViewportView(jt_usuarios);

			jPanel1.add(jScrollPane1);
			txt_usuario.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyPressed(java.awt.event.KeyEvent evt) {
					txt_usuarioKeyPressed(evt);
				}
			});

		}
	}
	

	protected void cbCadastrar_usuariosAddActionLinestener() {
		if(!cb_registrar.isSelected() && !cb_relatorios.isSelected()) {
			cb_registrar.setSelected(true);
			cb_relatorios.setSelected(true);
		}		
	}

	protected void cbRelatoriosAddActionLinestener() {
		if(!cb_registrar.isSelected()) {
			cb_registrar.setSelected(true);
		}
	}

	private void txt_nomeKeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txt_nomeKeyPressed
		if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
			txt_usuario.requestFocus();
		}
	}

	private void txt_usuarioKeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txt_usuarioKeyPressed
		if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
			txt_senha.requestFocus();
		}
	}

	protected void removerUsuario() {
		int linhaSelecionada = this.jt_usuarios.getSelectedRow();
		int index = listaUsuarios.get(linhaSelecionada).getCodigo();
		this.jtableModelUsuario.removerUsuario(linhaSelecionada);// remove da tabela
		JOptionPane.showMessageDialog(null, new ServiceClient().ExcluirUsuarioPorCodigo(index));// remove do banco
	}

	private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jButton1MouseClicked
		String tokRepresentacao = "";

		if (!cb_cadastrar_usuarios.isSelected() && !cb_relatorios.isSelected()) {
			tokRepresentacao = "1";
		} else if (!cb_cadastrar_usuarios.isSelected()) {
			tokRepresentacao = "2";
		} else {
			tokRepresentacao = "3";
		}

		Usuario usuario = new Usuario();
		usuario.setCodigo(0);
		usuario.setNome(txt_nome.getText().toString());
		usuario.setUsuario(txt_usuario.getText().toString());
		usuario.setSenha(new CriptoUtil().criptoStringHexMd5(new String(txt_senha.getPassword())));
		usuario.setToken(new CriptoUtil().criptoStringHexMd5(tokRepresentacao));

		UsuarioBO bo = new UsuarioBO();

		if (bo.valida(usuario)) {
			JOptionPane.showMessageDialog(null, new ServiceClient().CadastrarPessoa(usuario));
			this.jtableModelUsuario.addUsuario(usuario);
			limpartextos();
		} else {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
		}

		// retorna para o campo de texto nome
		txt_nome.requestFocus();

	}

	private void limpartextos() {
		txt_nome.setText("");
		txt_senha.setText("");
		txt_usuario.setText("");
		cb_cadastrar_usuarios.setSelected(false);
		cb_registrar.setSelected(false);
		cb_relatorios.setSelected(false);
	}
	
	private int[] setLocationJPainel() {
		int local[] = new int[2];

		Toolkit toolkit = getToolkit();
		Dimension d = toolkit.getScreenSize();

		local[0] = d.width / 2 - getWidth() / 2;
		local[1] = d.height / 2 - getHeight() / 2;

		return local;
	}
}
