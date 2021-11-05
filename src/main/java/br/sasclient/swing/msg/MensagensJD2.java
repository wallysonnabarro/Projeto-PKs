package br.sasclient.swing.msg;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class MensagensJD2 extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private static String msg;
	private static String titulo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
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
	            java.util.logging.Logger.getLogger(MensagensJD2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            java.util.logging.Logger.getLogger(MensagensJD2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            java.util.logging.Logger.getLogger(MensagensJD2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	            java.util.logging.Logger.getLogger(MensagensJD2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }
			
			MensagensJD2 dialog = new MensagensJD2(msg, titulo);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Create the dialog.
	 */
	public MensagensJD2(String msg, String titulo) {

		MensagensJD2.msg = msg;
		MensagensJD2.titulo = titulo;
		
		int largura = 0;
		
		if(MensagensJD2.msg.length()<10) {
			largura = MensagensJD2.msg.length() * 52 / 2;
		} else {
			largura = MensagensJD2.msg.length() * 54 / 4;
		}
				
		setModalityType(ModalityType.APPLICATION_MODAL);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setUndecorated(true);
		setResizable(false);
		setBounds(100, 100, largura, 132);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.GRAY, Color.LIGHT_GRAY));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.GRAY, Color.LIGHT_GRAY));
		panel_1.setLayout(null);
		panel_1.setForeground(new Color(0, 103, 71));
		panel_1.setBackground(new Color(0, 103, 71));
		panel_1.setBounds(0, 0, largura, 36);
		contentPanel.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel(MensagensJD2.titulo);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 11, 203, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lbl_icon_mensagen = new JLabel("");
		lbl_icon_mensagen.setBounds(10, 35, 38, 97);
		lbl_icon_mensagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/sasclient/imagens/info_30px.png")));
		contentPanel.add(lbl_icon_mensagen);
		
		JLabel lblNewLabel = new JLabel(MensagensJD2.msg);
		lblNewLabel.setForeground(new Color(0, 103, 71));
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel.setBounds(60, 35, largura, 97);
		contentPanel.add(lblNewLabel);
        Toolkit toolkit = getToolkit();
        Dimension d = toolkit.getScreenSize();
        setLocation(d.width/2 - getWidth()/2, d.height/2 - getHeight()/2);
		teporizador();
	}

	private void teporizador() {
		new Thread() {
			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				try {
					sleep(2000);
					MensagensJD2.this.hide();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}.start();
	}
}
