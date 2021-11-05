package br.sasclient.util;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;

public class WebcamJD extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel webcam = new JPanel();

	/**
	 * Webcam
	 */
	private Dimension ds = new Dimension(180, 205);
	private Dimension cs = WebcamResolution.VGA.getSize();
	private Webcam wCam;
	private WebcamPanel wCamPanel;
	private String foto;
	private File file;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			WebcamJD dialog = new WebcamJD();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public WebcamJD() {
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 211, 300);
		getContentPane().setLayout(new BorderLayout());
		webcam.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(webcam, BorderLayout.CENTER);
		webcam.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btn_capturar = new JButton("OK");
				btn_capturar.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						capturaFoto();
					}
				});
				btn_capturar.setActionCommand("OK");
				buttonPane.add(btn_capturar);
				getRootPane().setDefaultButton(btn_capturar);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		newWebcamOpen();
	}

	protected void capturaFoto() {
		file = new File(String.format("capture-%d.jpg", System.currentTimeMillis()));
		BufferedImage image = wCam.getImage();
		try {
			ImageIO.write(image, "JPG", file);
		} catch (IOException e) {
			e.printStackTrace();
		}

		foto = new Java8Base64Image().encoder(file);

		file.delete();
		
		wCamPanel.stop();
		wCam.close();

		dispose();
	}

	private void newWebcamOpen() {
		wCam = Webcam.getDefault();
		wCamPanel = new WebcamPanel(wCam, ds, false);
		if (!wCam.isOpen()) {
			wCam.setViewSize(cs);
		}
		wCamPanel.setFillArea(true);
		wCamPanel.setVisible(false);
		webcam.add(wCamPanel);

		Thread t = new Thread() {

			@Override
			public void run() {
				wCamPanel.setVisible(true);
				wCamPanel.setMirrored(true);
				wCamPanel.start();
				super.run();
			}
		};
		t.setDaemon(true);
		t.start();
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}	

}
