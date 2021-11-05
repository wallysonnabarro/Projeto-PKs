package br.sasclient.swing.paginas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import br.sasclient.swing.submenus.RelatorioBoletinsJD;
import br.sasclient.swing.submenus.RelatorioJD;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class RelatoriosJD extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lbl_relatorio_operacionais;
	private JLabel lbl_relatorio_boletins;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RelatoriosJD dialog = new RelatoriosJD();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RelatoriosJD() {
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 304, 234);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		Toolkit toolkit = getToolkit();
		Dimension d = toolkit.getScreenSize();
		setLocation(d.width / 2 - getWidth() / 2, d.height / 2 - getHeight() / 2);

		{
			JPanel jPanel126 = new JPanel();
			jPanel126.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			jPanel126.setBackground(new Color(0, 103, 71));
			jPanel126.setBounds(0, 0, 298, 25);
			contentPanel.add(jPanel126);
			JLabel jLabel11 = new JLabel();
			jLabel11.setText("Gerar Relatório");
			jLabel11.setForeground(Color.WHITE);
			jLabel11.setFont(new Font("Segoe UI", Font.BOLD, 10));
			GroupLayout gl_jPanel126 = new GroupLayout(jPanel126);
			gl_jPanel126.setHorizontalGroup(gl_jPanel126.createParallelGroup(Alignment.LEADING)
					.addGap(0, 868, Short.MAX_VALUE).addGroup(gl_jPanel126.createSequentialGroup().addContainerGap()
							.addComponent(jLabel11).addContainerGap(979, Short.MAX_VALUE)));
			gl_jPanel126
					.setVerticalGroup(gl_jPanel126.createParallelGroup(Alignment.LEADING).addGap(0, 25, Short.MAX_VALUE)
							.addComponent(jLabel11, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE));
			jPanel126.setLayout(gl_jPanel126);
		}
		{
			JPanel jPanel127 = new JPanel();
			jPanel127.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			jPanel127.setBackground(new Color(0, 103, 71));
			jPanel127.setBounds(42, 49, 209, 51);
			contentPanel.add(jPanel127);
			lbl_relatorio_operacionais = new JLabel();
			lbl_relatorio_operacionais.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_relatorio_operacionais.setText("RELATÓRIOS OPERACIONAIS");
			lbl_relatorio_operacionais.setForeground(Color.WHITE);

			lbl_relatorio_operacionais.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
				public void mouseMoved(java.awt.event.MouseEvent evt) {
					lbl_relatorio_faltasMouseMoved(evt);
				}
			});
			lbl_relatorio_operacionais.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseExited(java.awt.event.MouseEvent evt) {
					lbl_relatorio_faltasMouseExited(evt);
				}

				public void mousePressed(java.awt.event.MouseEvent evt) {
					lbl_relatorio_faltasMousePressed(evt);
				}
			});

			GroupLayout gl_jPanel127 = new GroupLayout(jPanel127);
			gl_jPanel127.setHorizontalGroup(
				gl_jPanel127.createParallelGroup(Alignment.LEADING)
					.addComponent(lbl_relatorio_operacionais, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
			);
			gl_jPanel127.setVerticalGroup(
				gl_jPanel127.createParallelGroup(Alignment.LEADING)
					.addComponent(lbl_relatorio_operacionais, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
			);
			jPanel127.setLayout(gl_jPanel127);
		}
		{
			JPanel jPanel128 = new JPanel();
			jPanel128.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			jPanel128.setBackground(new Color(0, 103, 71));
			jPanel128.setBounds(42, 118, 209, 51);
			contentPanel.add(jPanel128);
			lbl_relatorio_boletins = new JLabel();
			lbl_relatorio_boletins.addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseMoved(MouseEvent e) {
					lbl_relatorio_boletins.setForeground(new Color(220, 81, 29));
				}
			});
			lbl_relatorio_boletins.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_relatorio_boletins.addMouseListener(new MouseAdapter() {
				
				@Override
				public void mouseExited(MouseEvent e) {
					lbl_relatorio_boletins.setForeground(new Color(255, 255, 255));
				}
				@Override
				public void mousePressed(MouseEvent e) {
					RelatorioBoletinsJD jd = new RelatorioBoletinsJD();
					jd.setVisible(true);
				}
			});
			lbl_relatorio_boletins.setText("RELATÓRIO DE BOLETINS");
			lbl_relatorio_boletins.setForeground(Color.WHITE);
			GroupLayout gl_jPanel128 = new GroupLayout(jPanel128);
			gl_jPanel128.setHorizontalGroup(
				gl_jPanel128.createParallelGroup(Alignment.LEADING)
					.addComponent(lbl_relatorio_boletins, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
			);
			gl_jPanel128.setVerticalGroup(
				gl_jPanel128.createParallelGroup(Alignment.LEADING)
					.addComponent(lbl_relatorio_boletins, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
			);
			jPanel128.setLayout(gl_jPanel128);
		}
	}

	private void lbl_relatorio_faltasMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lbl_relatorio_faltasMouseExited
		lbl_relatorio_operacionais.setForeground(new Color(255, 255, 255));
	}

	private void lbl_relatorio_faltasMouseMoved(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lbl_relatorio_faltasMouseMoved
		lbl_relatorio_operacionais.setForeground(new Color(220, 81, 29));
	}

	private void lbl_relatorio_faltasMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lbl_relatorio_faltasMousePressed
		RelatorioJD jd = new RelatorioJD(1);
		jd.setVisible(true);
	}
}
