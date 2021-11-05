package br.com.sasclient.avaliacoes;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TesteshowConfirmDialog extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TesteshowConfirmDialog frame = new TesteshowConfirmDialog();
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
	public TesteshowConfirmDialog() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn_ShowConfirmDialog = new JButton("ShowConfirmDialog");
		btn_ShowConfirmDialog.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GetShowConfirmDialog();
			}
		});
		btn_ShowConfirmDialog.setBounds(91, 127, 167, 23);
		contentPane.add(btn_ShowConfirmDialog);
	}
	
	private void GetShowConfirmDialog() {
		int opcao = JOptionPane.showConfirmDialog(null,
	            "Escolha \n SIM - para Foto do diretorio. \n NÃO - para Webcam.", "Sim ou não?", JOptionPane.YES_NO_OPTION);
		if(opcao == 0){
			System.out.println("diretorio");
		} else {
			System.out.println("Webcam");
		}
	}

}
