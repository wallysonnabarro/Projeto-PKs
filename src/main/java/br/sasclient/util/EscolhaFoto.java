package br.sasclient.util;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class EscolhaFoto extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private String foto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			EscolhaFoto dialog = new EscolhaFoto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public EscolhaFoto() {
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btn_foto = new JButton("Foto");
				btn_foto.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						WebcamJD jd = new WebcamJD();
						jd.setVisible(true);
						new Thread() {
							@SuppressWarnings("deprecation")
							public void run() {
								while (jd.isVisible()) {
								}
								setFoto(jd.getFoto());
								EscolhaFoto.this.hide();
							};
						}.start();
					}
				});
				btn_foto.setActionCommand("OK");
				buttonPane.add(btn_foto);
			}
			{
				JButton btn_arquivo = new JButton("Arquivo");
				btn_arquivo.addMouseListener(new MouseAdapter() {
					@SuppressWarnings("deprecation")
					@Override
					public void mouseClicked(MouseEvent e) {
						JFileChooser file = new JFileChooser();
						FileNameExtensionFilter filter = new FileNameExtensionFilter(
						        "JPG & GIF Images", "jpg", "gif", "png");
				        //file.setFileSelectionMode(JFileChooser.FILES_ONLY);
				        file.setDialogTitle("Salvar");
				        file.setFileFilter(filter);
				        int resultado = file.showSaveDialog(null);
				        if (resultado == JFileChooser.APPROVE_OPTION) {
							setFoto(new Java8Base64Image().encoder(file.getSelectedFile()));
				        }					

						EscolhaFoto.this.hide();
					}
				});
				btn_arquivo.setActionCommand("OK");
				buttonPane.add(btn_arquivo);
				getRootPane().setDefaultButton(btn_arquivo);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addMouseListener(new MouseAdapter() {
					@SuppressWarnings("deprecation")
					@Override
					public void mouseClicked(MouseEvent arg0) {
						EscolhaFoto.this.hide();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}	
}
