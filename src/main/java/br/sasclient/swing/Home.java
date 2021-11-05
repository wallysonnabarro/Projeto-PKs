package br.sasclient.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import br.sasclient.entity.Usuario;
import br.sasclient.swing.paginas.ColaboradorJD;
import br.sasclient.swing.paginas.ControlerJD;
import br.sasclient.swing.paginas.FerramentasJD;
import br.sasclient.swing.paginas.RelatoriosJD;
import br.sasclient.swing.paginas.ReposicoesJD;
import br.sasclient.util.ArquivoUtil;

public class Home extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int i = 1;
	private static String token = "";
	private JPanel painel_menu_principal;
	private JLabel jl_menu_abrir;
	private JLabel jl_menu_sair;
	private JLabel jl_logar;
	private JLabel jl_menu_colaborador;
	private JLabel jl_menu_monitor;
	private JLabel jl_menu_vigilancia;
	private JLabel jl_menu_especializada;
	private JLabel jl_reposicoes;
	private JLabel jl_menu_relatorio;
	private JLabel jl_menu_ferramentas;
	private JPanel jp_menu_01;
	private JPanel jp_d_01;
	private JPanel jp_menu_06_1;
	private JPanel jp_d_06_1;
	private JPanel jp_menu_02;
	private JPanel jp_d_02;
	private JPanel jp_menu_03;
	private JPanel jp_d_03;
	private JPanel jp_menu_04;
	private JPanel jp_d_04;
	private JPanel jp_menu_05;
	private JPanel jp_d_05;
	private JPanel jp_menu_06;
	private JPanel jp_d_06;

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
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1187, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Toolkit toolkit = getToolkit();
		Dimension d = toolkit.getScreenSize();
		setLocation(d.width / 2 - getWidth() / 2, d.height / 2 - getHeight() / 2);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 1171, 661);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel jPanel2 = new JPanel();
		jPanel2.setBackground(Color.WHITE);
		jPanel2.setBounds(0, 0, 1171, 57);
		panel.add(jPanel2);

		JLabel jLabel1 = new JLabel();
		jLabel1.setIcon(new ImageIcon(Home.class.getResource("/br/sasclient/imagens/logopks_70.png")));
		GroupLayout gl_jPanel2 = new GroupLayout(jPanel2);
		gl_jPanel2.setHorizontalGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				gl_jPanel2.createSequentialGroup()
						.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(920, Short.MAX_VALUE)));
		gl_jPanel2.setVerticalGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING).addComponent(jLabel1,
				Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE));
		jPanel2.setLayout(gl_jPanel2);

		JPanel jPanel4 = new JPanel();
		jPanel4.setBackground(new Color(35, 32, 32));
		jPanel4.setBounds(0, 57, 1171, 25);
		panel.add(jPanel4);

		jl_menu_abrir = new JLabel();
		jl_menu_abrir.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				jl_menu_abrir.setForeground(new Color(220, 81, 29));
				jl_menu_abrir.setIcon(new javax.swing.ImageIcon(
						getClass().getResource("/br/sasclient/imagens/abrir_15px_laranja.png")));
			}
		});
		jl_menu_abrir.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				openClossedMenu();
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				jl_menu_abrir.setForeground(new Color(255, 255, 255));
				jl_menu_abrir.setIcon(
						new javax.swing.ImageIcon(getClass().getResource("/br/sasclient/imagens/abrir_15px.png")));
			}
		});
		jl_menu_abrir.setIcon(new ImageIcon(Home.class.getResource("/br/sasclient/imagens/abrir_15px.png")));
		jl_menu_abrir.setText("Abrir Menu");
		jl_menu_abrir.setForeground(Color.WHITE);
		jl_menu_abrir.setFont(new Font("Segoe UI", Font.BOLD, 12));

		jl_menu_sair = new JLabel();
		jl_menu_sair.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				jl_menu_sair.setForeground(new Color(220, 81, 29));
				jl_menu_sair.setIcon(new javax.swing.ImageIcon(
						getClass().getResource("/br/sasclient/imagens/exit_25px_laranja.png")));
			}
		});

		jl_menu_sair.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				File file = new File("C:\\connect3\\arquivo.dat");
				file.delete();
				System.exit(0);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				jl_menu_sair.setForeground(new Color(255, 255, 255));
				jl_menu_sair.setIcon(
						new javax.swing.ImageIcon(getClass().getResource("/br/sasclient/imagens/exit_25px.png")));
			}
		});

		jl_menu_sair.setIcon(new ImageIcon(Home.class.getResource("/br/sasclient/imagens/exit_25px.png")));
		jl_menu_sair.setText("Sair");
		jl_menu_sair.setForeground(Color.WHITE);
		jl_menu_sair.setFont(new Font("Segoe UI", Font.BOLD, 10));
		GroupLayout gl_jPanel4 = new GroupLayout(jPanel4);
		gl_jPanel4.setHorizontalGroup(gl_jPanel4.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_jPanel4.createSequentialGroup().addGap(20).addComponent(jl_menu_abrir)
						.addPreferredGap(ComponentPlacement.RELATED, 985, Short.MAX_VALUE).addComponent(jl_menu_sair)
						.addGap(37)));
		gl_jPanel4.setVerticalGroup(gl_jPanel4.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_jPanel4.createParallelGroup(Alignment.BASELINE)
						.addComponent(jl_menu_abrir, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
						.addComponent(jl_menu_sair, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)));
		jPanel4.setLayout(gl_jPanel4);

		painel_menu_principal = new JPanel();
		painel_menu_principal.setBackground(new java.awt.Color(35, 32, 32));
		painel_menu_principal.setBounds(0, 82, 174, 579);
		panel.add(painel_menu_principal);
		painel_menu_principal.setLayout(null);

		JPanel jPanel3 = new JPanel();
		jPanel3.setBackground(new Color(0, 127, 177));
		jPanel3.setBounds(0, 11, 174, 33);
		painel_menu_principal.add(jPanel3);

		jl_logar = new JLabel();
		jl_logar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				jl_logar.setForeground(new Color(220, 81, 29));
				jl_logar.setIcon(new javax.swing.ImageIcon(
						getClass().getResource("/br/sasclient/imagens/user_25px_laranja.png")));
			}
		});
		jl_logar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				jl_logar.setForeground(new Color(255, 255, 255));
				jl_logar.setIcon(
						new javax.swing.ImageIcon(getClass().getResource("/br/sasclient/imagens/user_25px.png")));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				LogarJD loginJD = new LogarJD();
				loginJD.setLocationRelativeTo(null);
				loginJD.setVisible(true);
			}
		});
		jl_logar.setIcon(new ImageIcon(Home.class.getResource("/br/sasclient/imagens/user_25px.png")));
		jl_logar.setText("Login");
		jl_logar.setForeground(Color.WHITE);
		jl_logar.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel3 = new GroupLayout(jPanel3);
		gl_jPanel3.setHorizontalGroup(gl_jPanel3.createParallelGroup(Alignment.LEADING).addGap(0, 172, Short.MAX_VALUE)
				.addGroup(gl_jPanel3.createSequentialGroup().addContainerGap()
						.addComponent(jl_logar, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE).addContainerGap()));
		gl_jPanel3.setVerticalGroup(gl_jPanel3.createParallelGroup(Alignment.LEADING).addGap(0, 33, Short.MAX_VALUE)
				.addComponent(jl_logar, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE));
		jPanel3.setLayout(gl_jPanel3);

		jp_menu_01 = new JPanel();
		jp_menu_01.setBackground(new Color(52, 52, 52));
		jp_menu_01.setBounds(0, 55, 174, 32);
		painel_menu_principal.add(jp_menu_01);

		jp_d_01 = new JPanel();
		jp_d_01.setPreferredSize(new Dimension(3, 32));
		jp_d_01.setOpaque(false);
		GroupLayout gl_jp_d_01 = new GroupLayout(jp_d_01);
		gl_jp_d_01.setHorizontalGroup(gl_jp_d_01.createParallelGroup(Alignment.LEADING).addGap(0, 3, Short.MAX_VALUE)
				.addGap(0, 3, Short.MAX_VALUE));
		gl_jp_d_01.setVerticalGroup(gl_jp_d_01.createParallelGroup(Alignment.LEADING).addGap(0, 32, Short.MAX_VALUE)
				.addGap(0, 32, Short.MAX_VALUE));
		jp_d_01.setLayout(gl_jp_d_01);

		jl_menu_colaborador = new JLabel();
		jl_menu_colaborador.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				jl_menu_colaborador.setForeground(new Color(220, 81, 29));
				jl_menu_colaborador.setIcon(new javax.swing.ImageIcon(
						getClass().getResource("/br/sasclient/imagens/colaborador_25px_laranja.png")));
			}
		});
		jl_menu_colaborador.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				jl_menu_colaborador.setForeground(new Color(255, 255, 255));
				jl_menu_colaborador.setIcon(new javax.swing.ImageIcon(
						getClass().getResource("/br/sasclient/imagens/colaborador_25px.png")));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Usuario usuario = new ArquivoUtil().lerArquivo();
				if (usuario != null) {
					token = usuario.getToken();
				}
				pressedColaboradorMenu();
			}
		});
		jl_menu_colaborador
				.setIcon(new ImageIcon(Home.class.getResource("/br/sasclient/imagens/colaborador_25px.png")));
		jl_menu_colaborador.setText("Colaborador");
		jl_menu_colaborador.setForeground(Color.WHITE);
		jl_menu_colaborador.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jp_menu_01 = new GroupLayout(jp_menu_01);
		gl_jp_menu_01.setHorizontalGroup(gl_jp_menu_01.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jp_menu_01.createSequentialGroup()
						.addComponent(jp_d_01, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(jl_menu_colaborador, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)));
		gl_jp_menu_01.setVerticalGroup(gl_jp_menu_01.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jp_menu_01.createSequentialGroup()
						.addComponent(jp_d_01, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE))
				.addComponent(jl_menu_colaborador, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE));
		jp_menu_01.setLayout(gl_jp_menu_01);

		jp_menu_06_1 = new JPanel();
		jp_menu_06_1.setBackground(new Color(52, 52, 52));
		jp_menu_06_1.setBounds(0, 87, 174, 32);
		painel_menu_principal.add(jp_menu_06_1);

		jp_d_06_1 = new JPanel();
		jp_d_06_1.setPreferredSize(new Dimension(3, 32));
		jp_d_06_1.setOpaque(false);
		GroupLayout gl_jp_d_06_1 = new GroupLayout(jp_d_06_1);
		gl_jp_d_06_1.setHorizontalGroup(gl_jp_d_06_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 3, Short.MAX_VALUE).addGap(0, 3, Short.MAX_VALUE));
		gl_jp_d_06_1.setVerticalGroup(gl_jp_d_06_1.createParallelGroup(Alignment.LEADING).addGap(0, 32, Short.MAX_VALUE)
				.addGap(0, 32, Short.MAX_VALUE));
		jp_d_06_1.setLayout(gl_jp_d_06_1);

		jl_menu_monitor = new JLabel();
		jl_menu_monitor.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				jl_menu_monitor.setForeground(new Color(220, 81, 29));
				jl_menu_monitor.setIcon(new javax.swing.ImageIcon(
						getClass().getResource("/br/sasclient/imagens/computer_25px_laranja.png")));
			}
		});
		jl_menu_monitor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				jl_menu_monitor.setForeground(new Color(255, 255, 255));
				jl_menu_monitor.setIcon(
						new javax.swing.ImageIcon(getClass().getResource("/br/sasclient/imagens/computer_25px.png")));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Monitoramento monitorar = new Monitoramento();
				monitorar.setVisible(true);
			}
		});
		jl_menu_monitor.setIcon(new ImageIcon(Home.class.getResource("/br/sasclient/imagens/computer_25px.png")));
		jl_menu_monitor.setText("Monitor");
		jl_menu_monitor.setForeground(Color.WHITE);
		jl_menu_monitor.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jp_menu_06_1 = new GroupLayout(jp_menu_06_1);
		gl_jp_menu_06_1.setHorizontalGroup(gl_jp_menu_06_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jp_menu_06_1.createSequentialGroup()
						.addComponent(jp_d_06_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(jl_menu_monitor, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)));
		gl_jp_menu_06_1.setVerticalGroup(gl_jp_menu_06_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jp_menu_06_1.createSequentialGroup()
						.addComponent(jp_d_06_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE))
				.addComponent(jl_menu_monitor, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE));
		jp_menu_06_1.setLayout(gl_jp_menu_06_1);

		jp_menu_02 = new JPanel();
		jp_menu_02.setBackground(new Color(52, 52, 52));
		jp_menu_02.setBounds(0, 118, 174, 32);
		painel_menu_principal.add(jp_menu_02);

		jp_d_02 = new JPanel();
		jp_d_02.setPreferredSize(new Dimension(3, 32));
		jp_d_02.setOpaque(false);
		GroupLayout gl_jp_d_02 = new GroupLayout(jp_d_02);
		gl_jp_d_02.setHorizontalGroup(gl_jp_d_02.createParallelGroup(Alignment.LEADING).addGap(0, 3, Short.MAX_VALUE)
				.addGap(0, 3, Short.MAX_VALUE));
		gl_jp_d_02.setVerticalGroup(gl_jp_d_02.createParallelGroup(Alignment.LEADING).addGap(0, 32, Short.MAX_VALUE)
				.addGap(0, 32, Short.MAX_VALUE));
		jp_d_02.setLayout(gl_jp_d_02);

		jl_menu_vigilancia = new JLabel();
		jl_menu_vigilancia.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				jl_menu_vigilancia.setForeground(new Color(220, 81, 29));
				jl_menu_vigilancia.setIcon(new javax.swing.ImageIcon(
						getClass().getResource("/br/sasclient/imagens/vigilancia_25px_laranja.png")));
			}
		});
		jl_menu_vigilancia.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				jl_menu_vigilancia.setForeground(new Color(255, 255, 255));
				jl_menu_vigilancia.setIcon(
						new javax.swing.ImageIcon(getClass().getResource("/br/sasclient/imagens/vigilancia_25px.png")));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Usuario usuario = new ArquivoUtil().lerArquivo();
				if (usuario != null) {
					token = usuario.getToken();
				}
				pressedVigilanciaMenu();
			}
		});
		jl_menu_vigilancia.setIcon(new ImageIcon(Home.class.getResource("/br/sasclient/imagens/vigilancia_25px.png")));
		jl_menu_vigilancia.setText("Planilha Vigilância");
		jl_menu_vigilancia.setForeground(Color.WHITE);
		jl_menu_vigilancia.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jp_menu_02 = new GroupLayout(jp_menu_02);
		gl_jp_menu_02.setHorizontalGroup(gl_jp_menu_02.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jp_menu_02.createSequentialGroup()
						.addComponent(jp_d_02, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(jl_menu_vigilancia, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)));
		gl_jp_menu_02.setVerticalGroup(gl_jp_menu_02.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jp_menu_02.createSequentialGroup()
						.addComponent(jp_d_02, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE))
				.addComponent(jl_menu_vigilancia, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE));
		jp_menu_02.setLayout(gl_jp_menu_02);

		jp_menu_03 = new JPanel();
		jp_menu_03.setBackground(new Color(52, 52, 52));
		jp_menu_03.setBounds(0, 150, 174, 32);
		painel_menu_principal.add(jp_menu_03);

		jp_d_03 = new JPanel();
		jp_d_03.setPreferredSize(new Dimension(3, 32));
		jp_d_03.setOpaque(false);
		GroupLayout gl_jp_d_03 = new GroupLayout(jp_d_03);
		gl_jp_d_03.setHorizontalGroup(gl_jp_d_03.createParallelGroup(Alignment.LEADING).addGap(0, 3, Short.MAX_VALUE)
				.addGap(0, 3, Short.MAX_VALUE));
		gl_jp_d_03.setVerticalGroup(gl_jp_d_03.createParallelGroup(Alignment.LEADING).addGap(0, 32, Short.MAX_VALUE)
				.addGap(0, 32, Short.MAX_VALUE));
		jp_d_03.setLayout(gl_jp_d_03);

		jl_menu_especializada = new JLabel();
		jl_menu_especializada.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				jl_menu_especializada.setForeground(new Color(220, 81, 29));
				jl_menu_especializada.setIcon(new javax.swing.ImageIcon(
						getClass().getResource("/br/sasclient/imagens/profile_25px_laranja.png")));
			}
		});
		jl_menu_especializada.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				jl_menu_especializada.setForeground(new Color(255, 255, 255));
				jl_menu_especializada.setIcon(
						new javax.swing.ImageIcon(getClass().getResource("/br/sasclient/imagens/profile_25px.png")));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Usuario usuario = new ArquivoUtil().lerArquivo();
				if (usuario != null) {
					token = usuario.getToken();
				}
				pressedEspecializadaMenu();
			}
		});
		jl_menu_especializada.setIcon(new ImageIcon(Home.class.getResource("/br/sasclient/imagens/profile_25px.png")));
		jl_menu_especializada.setText("Planilha Especializada");
		jl_menu_especializada.setForeground(Color.WHITE);
		jl_menu_especializada.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jp_menu_03 = new GroupLayout(jp_menu_03);
		gl_jp_menu_03.setHorizontalGroup(gl_jp_menu_03.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jp_menu_03.createSequentialGroup()
						.addComponent(jp_d_03, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(jl_menu_especializada, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)));
		gl_jp_menu_03.setVerticalGroup(gl_jp_menu_03.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jp_menu_03.createSequentialGroup()
						.addComponent(jp_d_03, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE))
				.addComponent(jl_menu_especializada, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 32,
						Short.MAX_VALUE));
		jp_menu_03.setLayout(gl_jp_menu_03);

		jp_menu_04 = new JPanel();
		jp_menu_04.setBackground(new Color(52, 52, 52));
		jp_menu_04.setBounds(0, 182, 174, 32);
		painel_menu_principal.add(jp_menu_04);

		jp_d_04 = new JPanel();
		jp_d_04.setPreferredSize(new Dimension(3, 32));
		jp_d_04.setOpaque(false);
		GroupLayout gl_jp_d_04 = new GroupLayout(jp_d_04);
		gl_jp_d_04.setHorizontalGroup(gl_jp_d_04.createParallelGroup(Alignment.LEADING).addGap(0, 3, Short.MAX_VALUE)
				.addGap(0, 3, Short.MAX_VALUE));
		gl_jp_d_04.setVerticalGroup(gl_jp_d_04.createParallelGroup(Alignment.LEADING).addGap(0, 32, Short.MAX_VALUE)
				.addGap(0, 32, Short.MAX_VALUE));
		jp_d_04.setLayout(gl_jp_d_04);

		jl_reposicoes = new JLabel();
		jl_reposicoes.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				jl_reposicoes.setForeground(new Color(220, 81, 29));
				jl_reposicoes.setIcon(
						new javax.swing.ImageIcon(getClass().getResource("/br/sasclient/imagens/cv_25px_laranja.png")));
			}
		});
		jl_reposicoes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				jl_reposicoes.setForeground(new Color(255, 255, 255));
				jl_reposicoes.setIcon(
						new javax.swing.ImageIcon(getClass().getResource("/br/sasclient/imagens/cv_25px.png")));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Usuario usuario = new ArquivoUtil().lerArquivo();
				if (usuario != null) {
					token = usuario.getToken();
				}
				pressedResposicoesMenu();
			}
		});
		jl_reposicoes.setIcon(new ImageIcon(Home.class.getResource("/br/sasclient/imagens/cv_25px.png")));
		jl_reposicoes.setText("Planilha Reposições");
		jl_reposicoes.setForeground(Color.WHITE);
		jl_reposicoes.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jp_menu_04 = new GroupLayout(jp_menu_04);
		gl_jp_menu_04.setHorizontalGroup(gl_jp_menu_04.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jp_menu_04.createSequentialGroup()
						.addComponent(jp_d_04, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(jl_reposicoes, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)));
		gl_jp_menu_04.setVerticalGroup(gl_jp_menu_04.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jp_menu_04.createSequentialGroup()
						.addComponent(jp_d_04, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE))
				.addComponent(jl_reposicoes, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE));
		jp_menu_04.setLayout(gl_jp_menu_04);

		jp_menu_05 = new JPanel();
		jp_menu_05.setBackground(new Color(52, 52, 52));
		jp_menu_05.setBounds(0, 213, 174, 32);
		painel_menu_principal.add(jp_menu_05);

		jp_d_05 = new JPanel();
		jp_d_05.setPreferredSize(new Dimension(3, 32));
		jp_d_05.setOpaque(false);
		GroupLayout gl_jp_d_05 = new GroupLayout(jp_d_05);
		gl_jp_d_05.setHorizontalGroup(gl_jp_d_05.createParallelGroup(Alignment.LEADING).addGap(0, 3, Short.MAX_VALUE)
				.addGap(0, 3, Short.MAX_VALUE));
		gl_jp_d_05.setVerticalGroup(gl_jp_d_05.createParallelGroup(Alignment.LEADING).addGap(0, 32, Short.MAX_VALUE)
				.addGap(0, 32, Short.MAX_VALUE));
		jp_d_05.setLayout(gl_jp_d_05);

		jl_menu_relatorio = new JLabel();
		jl_menu_relatorio.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				jl_menu_relatorio.setForeground(new Color(220, 81, 29));
				jl_menu_relatorio.setIcon(new javax.swing.ImageIcon(
						getClass().getResource("/br/sasclient/imagens/relatorio_25px_laranja.png")));
			}
		});
		jl_menu_relatorio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				jl_menu_relatorio.setForeground(new Color(255, 255, 255));
				jl_menu_relatorio.setIcon(
						new javax.swing.ImageIcon(getClass().getResource("/br/sasclient/imagens/relatorio_25px.png")));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Usuario usuario = new ArquivoUtil().lerArquivo();
				if (usuario != null) {
					token = usuario.getToken();
				}
				pressedRelatoriosMenu();
			}
		});
		jl_menu_relatorio.setIcon(new ImageIcon(Home.class.getResource("/br/sasclient/imagens/relatorio_25px.png")));
		jl_menu_relatorio.setText("Gerar Relatórios");
		jl_menu_relatorio.setForeground(Color.WHITE);
		jl_menu_relatorio.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jp_menu_05 = new GroupLayout(jp_menu_05);
		gl_jp_menu_05.setHorizontalGroup(gl_jp_menu_05.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jp_menu_05.createSequentialGroup()
						.addComponent(jp_d_05, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(jl_menu_relatorio, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)));
		gl_jp_menu_05.setVerticalGroup(gl_jp_menu_05.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jp_menu_05.createSequentialGroup()
						.addComponent(jp_d_05, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE))
				.addComponent(jl_menu_relatorio, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE));
		jp_menu_05.setLayout(gl_jp_menu_05);

		jp_menu_06 = new JPanel();
		jp_menu_06.setBackground(new Color(52, 52, 52));
		jp_menu_06.setBounds(0, 244, 174, 32);
		painel_menu_principal.add(jp_menu_06);

		jp_d_06 = new JPanel();
		jp_d_06.setPreferredSize(new Dimension(3, 32));
		jp_d_06.setOpaque(false);
		GroupLayout gl_jp_d_06 = new GroupLayout(jp_d_06);
		gl_jp_d_06.setHorizontalGroup(gl_jp_d_06.createParallelGroup(Alignment.LEADING).addGap(0, 3, Short.MAX_VALUE)
				.addGap(0, 3, Short.MAX_VALUE));
		gl_jp_d_06.setVerticalGroup(gl_jp_d_06.createParallelGroup(Alignment.LEADING).addGap(0, 32, Short.MAX_VALUE)
				.addGap(0, 32, Short.MAX_VALUE));
		jp_d_06.setLayout(gl_jp_d_06);

		jl_menu_ferramentas = new JLabel();
		jl_menu_ferramentas.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				jl_menu_ferramentas.setForeground(new Color(220, 81, 29));
				jl_menu_ferramentas.setIcon(new javax.swing.ImageIcon(
						getClass().getResource("/br/sasclient/imagens/tools_25px_laranja.png")));
			}
		});
		jl_menu_ferramentas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				jl_menu_ferramentas.setForeground(new Color(255, 255, 255));
				jl_menu_ferramentas.setIcon(
						new javax.swing.ImageIcon(getClass().getResource("/br/sasclient/imagens/tools_25px.png")));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Usuario usuario = new ArquivoUtil().lerArquivo();
				if (usuario != null) {
					token = usuario.getToken();
				}
				pressedFerramentasMenu();
			}
		});
		jl_menu_ferramentas.setIcon(new ImageIcon(Home.class.getResource("/br/sasclient/imagens/tools_25px.png")));
		jl_menu_ferramentas.setText("Ferramentas");
		jl_menu_ferramentas.setForeground(Color.WHITE);
		jl_menu_ferramentas.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jp_menu_06 = new GroupLayout(jp_menu_06);
		gl_jp_menu_06.setHorizontalGroup(gl_jp_menu_06.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jp_menu_06.createSequentialGroup()
						.addComponent(jp_d_06, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(jl_menu_ferramentas, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)));
		gl_jp_menu_06.setVerticalGroup(gl_jp_menu_06.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jp_menu_06.createSequentialGroup()
						.addComponent(jp_d_06, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE))
				.addComponent(jl_menu_ferramentas, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE));
		jp_menu_06.setLayout(gl_jp_menu_06);

		JLabel jLabel4 = new JLabel();
		jLabel4.setIcon(new ImageIcon(Home.class.getResource("/br/sasclient/imagens/logopks_70.png")));
		jLabel4.setBounds(255, 194, 165, 39);
		panel.add(jLabel4);

		JLabel jLabel5 = new JLabel();
		jLabel5.setText(
				"“Promover, através do desenvolvimento de shopping centers e empreendimentos imobiliários, qualidade de vida,");
		jLabel5.setBounds(255, 239, 702, 14);
		panel.add(jLabel5);

		JLabel jLabel6 = new JLabel();
		jLabel6.setText("conveniência e geração de valor”.");
		jLabel6.setBounds(255, 259, 322, 14);
		panel.add(jLabel6);

	}

	protected void pressedFerramentasMenu() {
		if ("eccbc87e4b5ce2fe28308fd9f2a7baf3".equals(token)) {
			setColorPainelMenu(jp_menu_06, jp_d_06);
			resetColorPainelMenu(new JPanel[] { jp_menu_01, jp_menu_02, jp_menu_03, jp_menu_04, jp_menu_05 },
					new JPanel[] { jp_d_01, jp_d_02, jp_d_03, jp_d_04, jp_d_05 });
			FerramentasJD jd = new FerramentasJD();
			jd.setVisible(true);
		}
	}

	protected void pressedRelatoriosMenu() {
		if ("c81e728d9d4c2f636f067f89cc14862c".equals(token) || "eccbc87e4b5ce2fe28308fd9f2a7baf3".equals(token)) {
			setColorPainelMenu(jp_menu_05, jp_d_05);
			resetColorPainelMenu(new JPanel[] { jp_menu_01, jp_menu_02, jp_menu_03, jp_menu_04, jp_menu_06 },
					new JPanel[] { jp_d_01, jp_d_02, jp_d_03, jp_d_04, jp_d_06 });
			RelatoriosJD jd = new RelatoriosJD();
			jd.setVisible(true);
		}
	}

	protected void pressedResposicoesMenu() {
		if ("c4ca4238a0b923820dcc509a6f75849b".equals(token) || "c81e728d9d4c2f636f067f89cc14862c".equals(token)
				|| "eccbc87e4b5ce2fe28308fd9f2a7baf3".equals(token)) {
			setColorPainelMenu(jp_menu_04, jp_d_04);
			resetColorPainelMenu(new JPanel[] { jp_menu_01, jp_menu_02, jp_menu_03, jp_menu_05, jp_menu_06 },
					new JPanel[] { jp_d_01, jp_d_02, jp_d_03, jp_d_05, jp_d_06 });
			ReposicoesJD jd = new ReposicoesJD();
			jd.setVisible(true);
		}
	}

	protected void pressedEspecializadaMenu() {
		if ("c4ca4238a0b923820dcc509a6f75849b".equals(token) || "c81e728d9d4c2f636f067f89cc14862c".equals(token)
				|| "eccbc87e4b5ce2fe28308fd9f2a7baf3".equals(token)) {
			// seta 2 para especializada especializada = 2;

			setColorPainelMenu(jp_menu_03, jp_d_03);
			resetColorPainelMenu(new JPanel[] { jp_menu_01, jp_menu_02, jp_menu_04, jp_menu_05, jp_menu_06 },
					new JPanel[] { jp_d_01, jp_d_02, jp_d_04, jp_d_05, jp_d_06 });
			ControlerJD jd = new ControlerJD(2, "Controle Especializada", 2);
			jd.setVisible(true);
		}
	}

	protected void pressedVigilanciaMenu() {
		if ("c4ca4238a0b923820dcc509a6f75849b".equals(token) || "c81e728d9d4c2f636f067f89cc14862c".equals(token)
				|| "eccbc87e4b5ce2fe28308fd9f2a7baf3".equals(token)) {
			// Seta 1 para vigilante especializada = 1;

			setColorPainelMenu(jp_menu_02, jp_d_02);
			resetColorPainelMenu(new JPanel[] { jp_menu_01, jp_menu_03, jp_menu_04, jp_menu_05, jp_menu_06 },
					new JPanel[] { jp_d_01, jp_d_03, jp_d_04, jp_d_05, jp_d_06 });
			ControlerJD jd = new ControlerJD(1, "Controle Vigilância", 1);
			jd.setVisible(true);
		}
	}

	protected void pressedColaboradorMenu() {
		if ("c4ca4238a0b923820dcc509a6f75849b".equals(token) || "c81e728d9d4c2f636f067f89cc14862c".equals(token)
				|| "eccbc87e4b5ce2fe28308fd9f2a7baf3".equals(token)) {
			setColorPainelMenu(jp_menu_01, jp_d_01);
			resetColorPainelMenu(new JPanel[] { jp_menu_02, jp_menu_03, jp_menu_04, jp_menu_05, jp_menu_06 },
					new JPanel[] { jp_d_02, jp_d_03, jp_d_04, jp_d_05, jp_d_06 });
			ColaboradorJD jd = new ColaboradorJD();
			jd.setVisible(true);
		}

	}

	private void setColorPainelMenu(JPanel jPanel, JPanel indicador) {
		jPanel.setBackground(new Color(86, 84, 84));
		indicador.setOpaque(true);
	}

	private void resetColorPainelMenu(JPanel[] panel, JPanel[] indicadores) {
		for (JPanel panel1 : panel) {
			panel1.setBackground(new Color(52, 52, 52));
		}
		for (JPanel indicadore : indicadores) {
			indicadore.setOpaque(false);
		}
	}

	protected void openClossedMenu() {
		if (i % 2 == 0) {
			painel_menu_principal.setVisible(true);
			jl_menu_abrir.setText("Fechar Menu");
		} else {
			painel_menu_principal.setVisible(false);
			jl_menu_abrir.setText("Abrir Menu");
		}
		i++;
	}

}
