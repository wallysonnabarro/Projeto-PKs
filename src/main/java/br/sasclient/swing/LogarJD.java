package br.sasclient.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.bo.UsuarioBO;
import br.sasclient.entity.Usuario;
import br.sasclient.service.ServiceClient;
import br.sasclient.swing.msg.MensagensJD2;
import br.sasclient.util.ArquivoUtil;
import br.sasclient.util.CriptoUtil;
import br.sasclient.util.LimiteTxt;

public class LogarJD extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField jt_usuario;
	private JPasswordField jp_senha;
	private JButton btn_acessar;
	private MensagensJD2 jd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		 /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LogarJD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogarJD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogarJD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogarJD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
		try {
			LogarJD dialog = new LogarJD();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public LogarJD() {
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 383, 249);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

        Toolkit toolkit = getToolkit();
        Dimension d = toolkit.getScreenSize();
        setLocation(d.width/2 - getWidth()/2, d.height/2 - getHeight()/2);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(52, 52, 52));
		panel.setBounds(0, 0, 375, 218);
		contentPanel.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 11, 355, 196);
		panel.add(panel_1);
		
		JLabel jLabel2 = new JLabel();
		jLabel2.setText("Usuário");
		jLabel2.setFont(new Font("Segoe UI", Font.BOLD, 10));
		jLabel2.setBounds(64, 46, 47, 14);
		panel_1.add(jLabel2);
		
		jt_usuario = new JTextField();
		jt_usuario.setDocument(new LimiteTxt(10));
		jt_usuario.setBounds(121, 43, 166, 27);
		panel_1.add(jt_usuario);
		
		JLabel jLabel3 = new JLabel();
		jLabel3.setText("Senha");
		jLabel3.setFont(new Font("Segoe UI", Font.BOLD, 10));
		jLabel3.setBounds(64, 84, 47, 14);
		panel_1.add(jLabel3);
		
		jp_senha = new JPasswordField();
		jp_senha.setBounds(121, 81, 166, 27);
		panel_1.add(jp_senha);
		

        jt_usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jt_usuarioKeyPressed(evt);
            }
        });

        jp_senha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jp_senhaKeyPressed(evt);
            }
        });
		
		
		btn_acessar = new JButton();
        btn_acessar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_acessarMouseClicked(evt);
            }
        });
        btn_acessar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_acessarKeyPressed(evt);
            }
        });

		btn_acessar.setText("Acessar");
		btn_acessar.setBackground(new Color(192, 220, 243));
		btn_acessar.setBounds(78, 112, 209, 23);
		panel_1.add(btn_acessar);
		
		JLabel jLabel5 = new JLabel();
		jLabel5.setText("Esqueceu a senha:");
		jLabel5.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		jLabel5.setBounds(115, 142, 95, 15);
		panel_1.add(jLabel5);
		
		JLabel jl_redefinir_senha = new JLabel();
		jl_redefinir_senha.setText("Aqui");
		jl_redefinir_senha.setForeground(new Color(153, 0, 51));
		jl_redefinir_senha.setFont(new Font("Segoe UI", Font.BOLD, 12));
		jl_redefinir_senha.setBounds(216, 141, 25, 16);
        jl_redefinir_senha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jl_redefinir_senhaMouseClicked(evt);
            }
        });
		panel_1.add(jl_redefinir_senha);
	}
	

    private void jt_usuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt_usuarioKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            jp_senha.requestFocus();
        }
    }//GEN-LAST:event_jt_usuarioKeyPressed

    private void jp_senhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jp_senhaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            btn_acessar.requestFocus();
        }
    }//GEN-LAST:event_jp_senhaKeyPressed
    
    private void btn_acessarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_acessarKeyPressed
        logar();
    }//GEN-LAST:event_btn_acessarKeyPressed

    private void btn_acessarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_acessarMouseClicked
        logar();
    }//GEN-LAST:event_btn_acessarMouseClicked

    private void jl_redefinir_senhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_redefinir_senhaMouseClicked
        
    }//GEN-LAST:event_jl_redefinir_senhaMouseClicked

	private void logar(){
		/* jd = new MensagensJD2("Acessando banco de dados....", "Login"); */
		Usuario usuario = new Usuario();
        usuario.setUsuario(jt_usuario.getText().toString());
        usuario.setSenha(new CriptoUtil().criptoStringHexMd5(new String(jp_senha.getPassword())));
        
        UsuarioBO bo = new UsuarioBO();
        if(bo.validarLogar(usuario)) {
        	usuario = new ServiceClient().IsLogar(usuario);
			/* jd.setVisible(true); */
        	if (usuario.getToken() != null) {
        		jd = new MensagensJD2("Sucesso!", "Login");
        		new ArquivoUtil().gravar(usuario);//Grava o usuario e o token
        		jd.setVisible(true);
        		temporizador();
			} else {
        		jd = new MensagensJD2("Não encontrado!", "Login");
        		jd.setVisible(true);
			}
        } else {
    		jd = new MensagensJD2("Preencha todos os campos!", "Login");
    		jd.setVisible(true);
        }
    }
    

	private void temporizador() {
		new Thread() {
			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				try {
					sleep(300);
					LogarJD.this.hide();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}.start();
	}
}
