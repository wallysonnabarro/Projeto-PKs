package br.com.sasclient.avaliacoes;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Diretorio extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField caminho;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Diretorio frame = new Diretorio();
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
	public Diretorio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("diretorio");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				diretorio();
			}
		});
		btnNewButton.setBounds(83, 117, 89, 23);
		panel.add(btnNewButton);
		
		caminho = new JTextField();
		caminho.setBounds(86, 38, 284, 20);
		panel.add(caminho);
		caminho.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Caminho");
		lblNewLabel.setBounds(10, 41, 46, 14);
		panel.add(lblNewLabel);
	}
	
	private void diretorio() {
		JFileChooser arquivo = new JFileChooser();
		arquivo.setFileSelectionMode(JFileChooser.FILES_ONLY);
		
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
			        "JPG, PNG e GIF Images", "jpg", "gif", "png");  //Cria um filtro
		arquivo.setFileFilter(filter);
		arquivo.showOpenDialog(this);
		
		File f = arquivo.getSelectedFile();
		if(f != null) {
			caminho.setText(f.getPath());
		}
	}
}
