package br.com.sasclient.avaliacoes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TesteColorChooser extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private Color color = Color.lightGray;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TesteColorChooser dialog = new TesteColorChooser();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TesteColorChooser() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton btn_cor = new JButton("Mudar Cor");
		btn_cor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				color = JColorChooser.showDialog( TesteColorChooser.this,
		                     "Selecione uma cor", color );
				
				 if ( color == null )
	                  color = Color.lightGray;
				 
				 contentPanel.setBackground(color);
				 repaint();
			}
		});
		btn_cor.setBounds(93, 61, 218, 136);
		contentPanel.add(btn_cor);
	}
}
