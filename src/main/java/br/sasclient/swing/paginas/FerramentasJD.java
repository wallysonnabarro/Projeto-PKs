package br.sasclient.swing.paginas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import br.sasclient.swing.UsuarioJD;
import br.sasclient.swing.submenus.CriarOcorrencias;
import br.sasclient.swing.submenus.Prefixos;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.SwingConstants;

public class FerramentasJD extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lbl_cadastro_usuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FerramentasJD dialog = new FerramentasJD();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FerramentasJD() {
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 388, 517);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

        Toolkit toolkit = getToolkit();
        Dimension d = toolkit.getScreenSize();
        setLocation(d.width/2 - getWidth()/2, d.height/2 - getHeight()/2);
        
		{
			JPanel jPanel135 = new JPanel();
			jPanel135.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			jPanel135.setBackground(new Color(0, 103, 71));
			jPanel135.setBounds(0, 0, 382, 33);
			contentPanel.add(jPanel135);
			JLabel jLabel12 = new JLabel();
			jLabel12.setText("Ferramenta");
			jLabel12.setForeground(Color.WHITE);
			jLabel12.setFont(new Font("Segoe UI", Font.BOLD, 11));
			GroupLayout gl_jPanel135 = new GroupLayout(jPanel135);
			gl_jPanel135.setHorizontalGroup(
				gl_jPanel135.createParallelGroup(Alignment.LEADING)
					.addGap(0, 651, Short.MAX_VALUE)
					.addGroup(gl_jPanel135.createSequentialGroup()
						.addContainerGap()
						.addComponent(jLabel12, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(170, Short.MAX_VALUE))
			);
			gl_jPanel135.setVerticalGroup(
				gl_jPanel135.createParallelGroup(Alignment.LEADING)
					.addGap(0, 33, Short.MAX_VALUE)
					.addComponent(jLabel12, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
			);
			jPanel135.setLayout(gl_jPanel135);
		}
		{
			JPanel jPanel136 = new JPanel();
			jPanel136.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			jPanel136.setBackground(new Color(0, 103, 71));
			jPanel136.setBounds(34, 66, 162, 46);
			contentPanel.add(jPanel136);
			lbl_cadastro_usuario = new JLabel();
			lbl_cadastro_usuario.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_cadastro_usuario.addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseMoved(MouseEvent arg0) {
					lbl_cadastro_usuario.setForeground(new Color(220, 81, 29));
				}
			});
			lbl_cadastro_usuario.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseExited(MouseEvent e) {
					lbl_cadastro_usuario.setForeground(new Color(255, 255, 255));
				}
				@Override
				public void mousePressed(MouseEvent e) {
					UsuarioJD usuarioJD = new UsuarioJD();
					usuarioJD.setVisible(true);
				}
			});
			lbl_cadastro_usuario.setText("Usuários");
			lbl_cadastro_usuario.setForeground(Color.WHITE);
			lbl_cadastro_usuario.setFont(new Font("Segoe UI", Font.BOLD, 14));
			GroupLayout gl_jPanel136 = new GroupLayout(jPanel136);
			gl_jPanel136.setHorizontalGroup(
				gl_jPanel136.createParallelGroup(Alignment.LEADING)
					.addGroup(Alignment.TRAILING, gl_jPanel136.createSequentialGroup()
						.addComponent(lbl_cadastro_usuario, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			);
			gl_jPanel136.setVerticalGroup(
				gl_jPanel136.createParallelGroup(Alignment.LEADING)
					.addComponent(lbl_cadastro_usuario, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
			);
			jPanel136.setLayout(gl_jPanel136);
		}
		
		JPanel jPanel136 = new JPanel();
		jPanel136.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel136.setBackground(new Color(0, 103, 71));
		jPanel136.setBounds(34, 142, 162, 46);
		contentPanel.add(jPanel136);
		
		JLabel lbl_cadastro_ocorrecias = new JLabel();
		lbl_cadastro_ocorrecias.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lbl_cadastro_ocorrecias.setForeground(new Color(220, 81, 29));
			}
		});
		lbl_cadastro_ocorrecias.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CriarOcorrencias criarOcorrencias = new CriarOcorrencias();
				criarOcorrencias.setVisible(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbl_cadastro_ocorrecias.setForeground(new Color(255, 255, 255));
			}
		});
		lbl_cadastro_ocorrecias.setText("Ocorrências");
		lbl_cadastro_ocorrecias.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_cadastro_ocorrecias.setForeground(Color.WHITE);
		lbl_cadastro_ocorrecias.setFont(new Font("Segoe UI", Font.BOLD, 14));
		GroupLayout gl_jPanel136 = new GroupLayout(jPanel136);
		gl_jPanel136.setHorizontalGroup(
			gl_jPanel136.createParallelGroup(Alignment.LEADING)
				.addGap(0, 162, Short.MAX_VALUE)
				.addGroup(Alignment.TRAILING, gl_jPanel136.createSequentialGroup()
					.addComponent(lbl_cadastro_ocorrecias, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_jPanel136.setVerticalGroup(
			gl_jPanel136.createParallelGroup(Alignment.LEADING)
				.addGap(0, 46, Short.MAX_VALUE)
				.addComponent(lbl_cadastro_ocorrecias, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
		);
		jPanel136.setLayout(gl_jPanel136);
		
		JPanel jPanel136_1 = new JPanel();
		jPanel136_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel136_1.setBackground(new Color(0, 103, 71));
		jPanel136_1.setBounds(34, 218, 162, 46);
		contentPanel.add(jPanel136_1);
		
		JLabel lbl_cadastro_prefixos = new JLabel();
		lbl_cadastro_prefixos.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lbl_cadastro_prefixos.setForeground(new Color(220, 81, 29));
			}
		});
		lbl_cadastro_prefixos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Prefixos prefixos = new Prefixos();
				prefixos.setVisible(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbl_cadastro_prefixos.setForeground(new Color(255, 255, 255));
			}
		});
		lbl_cadastro_prefixos.setText("Prefixos");
		lbl_cadastro_prefixos.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_cadastro_prefixos.setForeground(Color.WHITE);
		lbl_cadastro_prefixos.setFont(new Font("Segoe UI", Font.BOLD, 14));
		GroupLayout gl_jPanel136_1 = new GroupLayout(jPanel136_1);
		gl_jPanel136_1.setHorizontalGroup(
			gl_jPanel136_1.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 162, Short.MAX_VALUE)
				.addGroup(gl_jPanel136_1.createSequentialGroup()
					.addComponent(lbl_cadastro_prefixos, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_jPanel136_1.setVerticalGroup(
			gl_jPanel136_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 46, Short.MAX_VALUE)
				.addComponent(lbl_cadastro_prefixos, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
		);
		jPanel136_1.setLayout(gl_jPanel136_1);
	}

}
