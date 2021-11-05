package br.sasclient.swing.paginas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import br.sasclient.entity.Colaborador;
import br.sasclient.entity.Controler;
import br.sasclient.entity.Controles;
import br.sasclient.entity.Pessoa;
import br.sasclient.entity.Pessoas;
import br.sasclient.service.ServiceClient;
import br.sasclient.swing.msg.MensagensJD2;
import br.sasclient.util.DataUtil;
import br.sasclient.util.FucoesUtil;
import br.sasclient.util.LimiteTxt;

public class ControlerJD extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private Pessoas pessoas = new Pessoas();
	private JPanel painel_conteudo_vigilancia;
	private static int u;
	private JTextField txt_nome_controle;
	private JTextField txt_hora_controle;
	private JTextField txt_minuto_controle;
	private JButton btn_registrar_controle;
	private int somaFaltas = 0;
	private int somaHoras = 0;
	private int somaMinutos = 0;
	private int somaFaltasPg = 0;
	private int somaHorasPG = 0;
	private int somaMinutosPG = 0;
	private static int aux_controle;
	private Set<String> lNomes;
	private Controles controles;
	private Controles controles2;
	private static MensagensJD2 mensagensJD;
	private JFormattedTextField txt_data_controle;
	private JRadioButton rb_falta;
	private JRadioButton rb_atraso;
	private JRadioButton rb_outros;
	private JLabel lb_jan_post_div;
	private JLabel lb_fev_posto_div;
	private JLabel lb_mar_posto_div;
	private JLabel lb_abr_posto_div;
	private JLabel lb_mai_posto_div;
	private JLabel lb_jun_posto_div;
	private JLabel lb_jul_posto_div;
	private JLabel lb_ago_posto_div;
	private JLabel lb_set_posto_div;
	private JLabel lb_out_posto_div;
	private JLabel lb_nov_posto_div;
	private JLabel lb_dez_posto_div;
	private JLabel lb_total_posto_div;
	private JLabel lb_jan_horas_div;
	private JLabel lb_fev_horas_div;
	private JLabel lb_mar_horas_div;
	private JLabel lb_abr_horas_div;
	private JLabel lb_mai_horas_div;
	private JLabel lb_jun_horas_div;
	private JLabel lb_jul_horas_div;
	private JLabel lb_ago_horas_div;
	private JLabel lb_set_horas_div;
	private JLabel lb_out_horas_div;
	private JLabel lb_nov_horas_div;
	private JLabel lb_dez_horas_div;
	private JLabel lb_total_horas_div;
	private JLabel lb_jan_posto_pg;
	private JLabel lb_fev_posto_pg;
	private JLabel lb_mar_posto_pg;
	private JLabel lb_abr_posto_pg;
	private JLabel lb_mai_posto_pg;
	private JLabel lb_jun_posto_pg;
	private JLabel lb_jul_posto_pg;
	private JLabel lb_ago_posto_pg;
	private JLabel lb_set_posto_pg;
	private JLabel lb_out_posto_pg;
	private JLabel lb_nov_posto_pg;
	private JLabel lb_dez_posto_pg;
	private JLabel lb_total_posto_pg;
	private JLabel lb_jan_horas_pg;
	private JLabel lb_fev_horas_pg;
	private JLabel lb_mar_horas_pg;
	private JLabel lb_abr_horas_pg;
	private JLabel lb_mai_horas_pg;
	private JLabel lb_jun_horas_pg;
	private JLabel lb_jul_horas_pg;
	private JLabel lb_ago_horas_pg;
	private JLabel lb_set_horas_pg;
	private JLabel lb_out_horas_pg;
	private JLabel lb_nov_horas_pg;
	private JLabel lb_dez_horas_pg;
	private JLabel lb_total_horas_pg;
	private JLabel lbl_falta_repor_posto;
	private JLabel lbl_falta_repor_horas;
	private JLabel jl_titulo_controle_vigilanica_especializada;
	private static String titulo;
	private javax.swing.ButtonGroup bg_controle_vigilancia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		try {
			ControlerJD dialog = new ControlerJD(aux_controle, titulo, u);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ControlerJD(int aux_controle, String titulo, int u) {
		setModal(true);
		ControlerJD.aux_controle = aux_controle;
		ControlerJD.titulo = titulo;
		ControlerJD.u = u;
		setResizable(false);
		setBounds(100, 100, 1109, 646);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		Toolkit toolkit = getToolkit();
		Dimension d = toolkit.getScreenSize();
		setLocation(d.width / 2 - getWidth() / 2, d.height / 2 - getHeight() / 2);
		

		bg_controle_vigilancia = new javax.swing.ButtonGroup();

		painel_conteudo_vigilancia = new JPanel();
		painel_conteudo_vigilancia.setBounds(0, 0, 1103, 617);
		painel_conteudo_vigilancia.setBackground(new java.awt.Color(255, 255, 255));
		painel_conteudo_vigilancia.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		painel_conteudo_vigilancia.setPreferredSize(new java.awt.Dimension(1092, 651));
		contentPanel.add(painel_conteudo_vigilancia);
		painel_conteudo_vigilancia.setLayout(null);

		JPanel jPanel11 = new JPanel();
		jPanel11.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel11.setBackground(new Color(0, 103, 71));
		jPanel11.setBounds(0, 0, 1103, 23);
		painel_conteudo_vigilancia.add(jPanel11);

		jl_titulo_controle_vigilanica_especializada = new JLabel();
		jl_titulo_controle_vigilanica_especializada.setText(titulo);
		jl_titulo_controle_vigilanica_especializada.setForeground(Color.WHITE);
		jl_titulo_controle_vigilanica_especializada.setFont(new Font("Segoe UI", Font.BOLD, 10));
		GroupLayout gl_jPanel11 = new GroupLayout(jPanel11);
		gl_jPanel11
				.setHorizontalGroup(gl_jPanel11.createParallelGroup(Alignment.LEADING).addGap(0, 1027, Short.MAX_VALUE)
						.addGroup(gl_jPanel11.createSequentialGroup().addContainerGap()
								.addComponent(jl_titulo_controle_vigilanica_especializada)
								.addContainerGap(938, Short.MAX_VALUE)));
		gl_jPanel11.setVerticalGroup(
				gl_jPanel11.createParallelGroup(Alignment.LEADING).addGap(0, 23, Short.MAX_VALUE).addComponent(
						jl_titulo_controle_vigilanica_especializada, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE));
		jPanel11.setLayout(gl_jPanel11);

		JPanel jPanel12 = new JPanel();
		jPanel12.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel12.setBackground(Color.WHITE);
		jPanel12.setBounds(10, 34, 632, 155);
		painel_conteudo_vigilancia.add(jPanel12);

		JPanel jPanel13 = new JPanel();
		jPanel13.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel13.setBackground(new Color(0, 103, 71));

		JLabel jLabel20 = new JLabel();
		jLabel20.setText("COLABORADOR");
		jLabel20.setForeground(Color.WHITE);
		jLabel20.setFont(new Font("Segoe UI", Font.BOLD, 10));
		GroupLayout gl_jPanel13 = new GroupLayout(jPanel13);
		gl_jPanel13
				.setHorizontalGroup(gl_jPanel13.createParallelGroup(Alignment.TRAILING).addGap(0, 596, Short.MAX_VALUE)
						.addGroup(gl_jPanel13.createSequentialGroup().addContainerGap(262, Short.MAX_VALUE)
								.addComponent(jLabel20).addContainerGap(262, Short.MAX_VALUE)));
		gl_jPanel13.setVerticalGroup(gl_jPanel13.createParallelGroup(Alignment.LEADING).addGap(0, 14, Short.MAX_VALUE)
				.addComponent(jLabel20, Alignment.TRAILING));
		jPanel13.setLayout(gl_jPanel13);

		JPanel jPanel15 = new JPanel();
		jPanel15.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel15.setBackground(new Color(204, 204, 204));

		JLabel jLabel21 = new JLabel();
		jLabel21.setText("Nome");

		JLabel jLabel22 = new JLabel();
		jLabel22.setText("Data");

		txt_data_controle = new JFormattedTextField();
		try {
			txt_data_controle.setFormatterFactory(
					new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
		} catch (java.text.ParseException ex) {
			ex.printStackTrace();
		}
		txt_data_controle.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				txt_data_controleKeyPressed(evt);
			}
		});
		txt_nome_controle = new JTextField();
		txt_nome_controle.setDocument(new LimiteTxt(50));
		txt_nome_controle.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					txt_data_controle.requestFocus();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				txt_nome_controleKeyRealesse(e);
			}
		});
		GroupLayout gl_jPanel15 = new GroupLayout(jPanel15);
		gl_jPanel15.setHorizontalGroup(gl_jPanel15.createParallelGroup(Alignment.LEADING)
				.addGap(0, 358, Short.MAX_VALUE)
				.addGroup(gl_jPanel15.createSequentialGroup().addContainerGap()
						.addGroup(gl_jPanel15
								.createParallelGroup(Alignment.LEADING).addComponent(jLabel21).addComponent(jLabel22))
						.addGap(18)
						.addGroup(gl_jPanel15.createParallelGroup(Alignment.LEADING)
								.addComponent(txt_data_controle, GroupLayout.PREFERRED_SIZE, 91,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txt_nome_controle, 293, 293, 293))
						.addContainerGap()));
		gl_jPanel15
				.setVerticalGroup(gl_jPanel15.createParallelGroup(Alignment.LEADING).addGap(0, 81, Short.MAX_VALUE)
						.addGroup(gl_jPanel15.createSequentialGroup().addContainerGap()
								.addGroup(gl_jPanel15.createParallelGroup(Alignment.BASELINE).addComponent(jLabel21)
										.addComponent(txt_nome_controle, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_jPanel15.createParallelGroup(Alignment.BASELINE).addComponent(jLabel22)
										.addComponent(txt_data_controle, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addContainerGap(19, Short.MAX_VALUE)));
		jPanel15.setLayout(gl_jPanel15);

		JPanel jPanel14 = new JPanel();
		jPanel14.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel14.setBackground(new Color(204, 204, 204));

		JPanel jPanel22 = new JPanel();

		rb_falta = new JRadioButton();
		rb_falta.setText("Falta");
		rb_falta.setSelected(true);

		rb_atraso = new JRadioButton();
		rb_atraso.setText("Atraso");

		rb_outros = new JRadioButton();
		rb_outros.setText("Outros");
		
		bg_controle_vigilancia.add(rb_falta);
		rb_falta.setSelected(true);
		rb_falta.setText("Falta");
		rb_falta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				selectTipoControle();
			}
		});

		bg_controle_vigilancia.add(rb_atraso);
		rb_atraso.setText("Atraso");
		rb_atraso.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				selectTipoControle();
			}
		});

		bg_controle_vigilancia.add(rb_outros);
		rb_outros.setText("Outros");
		rb_outros.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				selectTipoControle();
			}
		});
		GroupLayout gl_jPanel22 = new GroupLayout(jPanel22);
		gl_jPanel22
				.setHorizontalGroup(gl_jPanel22.createParallelGroup(Alignment.LEADING).addGap(0, 192, Short.MAX_VALUE)
						.addGroup(gl_jPanel22.createSequentialGroup().addContainerGap().addComponent(rb_falta)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(rb_atraso)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(rb_outros).addGap(156)));
		gl_jPanel22
				.setVerticalGroup(
						gl_jPanel22.createParallelGroup(Alignment.TRAILING).addGap(0, 37, Short.MAX_VALUE)
								.addGroup(gl_jPanel22.createSequentialGroup()
										.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(gl_jPanel22.createParallelGroup(Alignment.BASELINE)
												.addComponent(rb_falta).addComponent(rb_outros).addComponent(rb_atraso))
										.addContainerGap()));
		jPanel22.setLayout(gl_jPanel22);

		JLabel jLabel23 = new JLabel();
		jLabel23.setText("Horas");

		txt_hora_controle = new JTextField();
		txt_hora_controle.setEnabled(false);

		JLabel jLabel24 = new JLabel();
		jLabel24.setText("Minutos");

		txt_minuto_controle = new JTextField();
		txt_minuto_controle.setEnabled(false);
		GroupLayout gl_jPanel14 = new GroupLayout(jPanel14);
		gl_jPanel14.setHorizontalGroup(gl_jPanel14.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				gl_jPanel14.createSequentialGroup().addContainerGap().addGroup(gl_jPanel14
						.createParallelGroup(Alignment.TRAILING)
						.addComponent(jPanel22, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
						.addGroup(gl_jPanel14.createSequentialGroup().addComponent(jLabel23)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(txt_hora_controle, GroupLayout.PREFERRED_SIZE, 50,
										GroupLayout.PREFERRED_SIZE)
								.addGap(16).addComponent(jLabel24).addGap(10)
								.addComponent(txt_minuto_controle, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)))
						.addContainerGap()));
		gl_jPanel14.setVerticalGroup(gl_jPanel14.createParallelGroup(Alignment.LEADING).addGroup(gl_jPanel14
				.createSequentialGroup().addGap(7)
				.addComponent(jPanel22, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_jPanel14.createParallelGroup(Alignment.BASELINE).addComponent(jLabel23)
						.addComponent(jLabel24)
						.addComponent(txt_minuto_controle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(txt_hora_controle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		jPanel14.setLayout(gl_jPanel14);

		btn_registrar_controle = new JButton();
		btn_registrar_controle.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				registrarControle(aux_controle);
				txt_nome_controle.requestFocus();
			}
		});
		btn_registrar_controle.setText("Registrar");
		btn_registrar_controle.setForeground(Color.WHITE);
		btn_registrar_controle.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btn_registrar_controle.setBackground(new Color(40, 88, 127));
		GroupLayout gl_jPanel12 = new GroupLayout(jPanel12);
		gl_jPanel12.setHorizontalGroup(gl_jPanel12.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPanel12.createSequentialGroup().addContainerGap()
						.addComponent(jPanel15, GroupLayout.PREFERRED_SIZE, 374, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(jPanel14, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE).addContainerGap())
				.addComponent(jPanel13, GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
				.addGroup(gl_jPanel12.createSequentialGroup().addGap(234)
						.addComponent(btn_registrar_controle, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
						.addGap(213)));
		gl_jPanel12.setVerticalGroup(gl_jPanel12.createParallelGroup(Alignment.LEADING).addGroup(gl_jPanel12
				.createSequentialGroup()
				.addComponent(
						jPanel13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_jPanel12.createParallelGroup(Alignment.LEADING, false)
						.addComponent(jPanel14, 0, 0, Short.MAX_VALUE)
						.addComponent(jPanel15, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
				.addPreferredGap(ComponentPlacement.UNRELATED, 16, Short.MAX_VALUE)
				.addComponent(btn_registrar_controle, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		jPanel12.setLayout(gl_jPanel12);

		JPanel jPanel23 = new JPanel();
		jPanel23.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel23.setBackground(Color.WHITE);
		jPanel23.setBounds(646, 34, 447, 155);
		painel_conteudo_vigilancia.add(jPanel23);
		jPanel23.setLayout(new GridLayout(1, 0));

		JPanel jPanel24 = new JPanel();
		jPanel24.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel23.add(jPanel24);
		jPanel24.setLayout(new GridLayout(2, 0));

		JPanel jPanel28 = new JPanel();
		jPanel28.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel24.add(jPanel28);

		JPanel jPanel118 = new JPanel();
		jPanel118.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel118.setForeground(Color.WHITE);
		jPanel118.setBackground(new Color(0, 103, 71));

		JLabel jLabel112 = new JLabel();
		jLabel112.setText("Falta Repor: Posto");
		jLabel112.setForeground(Color.WHITE);
		jLabel112.setFont(new Font("Segoe UI", Font.BOLD, 10));
		GroupLayout gl_jPanel118 = new GroupLayout(jPanel118);
		gl_jPanel118.setHorizontalGroup(gl_jPanel118.createParallelGroup(Alignment.LEADING)
				.addGap(0, 105, Short.MAX_VALUE).addGroup(gl_jPanel118.createSequentialGroup().addContainerGap()
						.addComponent(jLabel112).addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_jPanel118.setVerticalGroup(gl_jPanel118.createParallelGroup(Alignment.LEADING).addGap(0, 25, Short.MAX_VALUE)
				.addComponent(jLabel112, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE));
		jPanel118.setLayout(gl_jPanel118);

		lbl_falta_repor_posto = new JLabel();
		lbl_falta_repor_posto.setText("0");
		lbl_falta_repor_posto.setForeground(new Color(153, 0, 51));
		lbl_falta_repor_posto.setFont(new Font("Segoe UI", Font.BOLD, 18));
		GroupLayout gl_jPanel28 = new GroupLayout(jPanel28);
		gl_jPanel28
				.setHorizontalGroup(gl_jPanel28.createParallelGroup(Alignment.TRAILING).addGap(0, 202, Short.MAX_VALUE)
						.addGroup(gl_jPanel28.createSequentialGroup()
								.addComponent(jPanel118, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGap(0, 100, Short.MAX_VALUE))
						.addGroup(gl_jPanel28.createSequentialGroup().addContainerGap(77, Short.MAX_VALUE)
								.addComponent(lbl_falta_repor_posto, GroupLayout.PREFERRED_SIZE, 118,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));
		gl_jPanel28.setVerticalGroup(gl_jPanel28.createParallelGroup(Alignment.LEADING).addGap(0, 73, Short.MAX_VALUE)
				.addGroup(gl_jPanel28.createSequentialGroup()
						.addComponent(jPanel118, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lbl_falta_repor_posto, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)));
		jPanel28.setLayout(gl_jPanel28);

		JPanel jPanel26 = new JPanel();
		jPanel26.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel24.add(jPanel26);

		JPanel jPanel119 = new JPanel();
		jPanel119.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel119.setForeground(Color.WHITE);
		jPanel119.setBackground(new Color(0, 103, 71));

		JLabel jLabel113 = new JLabel();
		jLabel113.setText("Falta Repor: Horas");
		jLabel113.setForeground(Color.WHITE);
		jLabel113.setFont(new Font("Segoe UI", Font.BOLD, 10));
		GroupLayout gl_jPanel119 = new GroupLayout(jPanel119);
		gl_jPanel119.setHorizontalGroup(gl_jPanel119.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 106, Short.MAX_VALUE)
				.addGroup(gl_jPanel119.createSequentialGroup().addContainerGap()
						.addComponent(jLabel113, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));
		gl_jPanel119.setVerticalGroup(gl_jPanel119.createParallelGroup(Alignment.LEADING).addGap(0, 25, Short.MAX_VALUE)
				.addComponent(jLabel113, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE));
		jPanel119.setLayout(gl_jPanel119);

		lbl_falta_repor_horas = new JLabel();
		lbl_falta_repor_horas.setText("00:00");
		lbl_falta_repor_horas.setForeground(new Color(153, 0, 51));
		lbl_falta_repor_horas.setFont(new Font("Segoe UI", Font.BOLD, 18));
		GroupLayout gl_jPanel26 = new GroupLayout(jPanel26);
		gl_jPanel26
				.setHorizontalGroup(gl_jPanel26.createParallelGroup(Alignment.TRAILING).addGap(0, 202, Short.MAX_VALUE)
						.addGroup(gl_jPanel26.createSequentialGroup()
								.addComponent(jPanel119, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGap(0, 99, Short.MAX_VALUE))
						.addGroup(gl_jPanel26.createSequentialGroup().addContainerGap(73, Short.MAX_VALUE)
								.addComponent(lbl_falta_repor_horas, GroupLayout.PREFERRED_SIZE, 122,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));
		gl_jPanel26.setVerticalGroup(gl_jPanel26.createParallelGroup(Alignment.LEADING).addGap(0, 73, Short.MAX_VALUE)
				.addGroup(gl_jPanel26.createSequentialGroup()
						.addComponent(jPanel119, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lbl_falta_repor_horas, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)));
		jPanel26.setLayout(gl_jPanel26);

		JPanel jPanel25 = new JPanel();
		jPanel25.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel25.setBackground(new Color(0, 103, 71));
		jPanel23.add(jPanel25);
		GroupLayout gl_jPanel25 = new GroupLayout(jPanel25);
		gl_jPanel25.setHorizontalGroup(gl_jPanel25.createParallelGroup(Alignment.LEADING)
				.addGap(0, 202, Short.MAX_VALUE).addGap(0, 209, Short.MAX_VALUE));
		gl_jPanel25.setVerticalGroup(gl_jPanel25.createParallelGroup(Alignment.LEADING).addGap(0, 147, Short.MAX_VALUE)
				.addGap(0, 147, Short.MAX_VALUE));
		jPanel25.setLayout(gl_jPanel25);

		JPanel jPanel16 = new JPanel();
		jPanel16.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel16.setBounds(10, 192, 1085, 416);
		painel_conteudo_vigilancia.add(jPanel16);

		JPanel jPanel17 = new JPanel();
		jPanel17.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel17.setBackground(new Color(0, 103, 71));

		JLabel jLabel25 = new JLabel();
		jLabel25.setText("CONTROLE");
		jLabel25.setForeground(Color.WHITE);
		jLabel25.setFont(new Font("Segoe UI", Font.BOLD, 10));
		GroupLayout gl_jPanel17 = new GroupLayout(jPanel17);
		gl_jPanel17
				.setHorizontalGroup(gl_jPanel17.createParallelGroup(Alignment.TRAILING).addGap(0, 1007, Short.MAX_VALUE)
						.addGroup(gl_jPanel17.createSequentialGroup().addContainerGap(491, Short.MAX_VALUE)
								.addComponent(jLabel25).addContainerGap(492, Short.MAX_VALUE)));
		gl_jPanel17.setVerticalGroup(gl_jPanel17.createParallelGroup(Alignment.LEADING).addGap(0, 14, Short.MAX_VALUE)
				.addComponent(jLabel25, Alignment.TRAILING));
		jPanel17.setLayout(gl_jPanel17);

		JPanel jPanel19 = new JPanel();
		jPanel19.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel19.setBackground(Color.WHITE);

		JPanel jPanel21 = new JPanel();
		jPanel21.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel21.setBackground(new Color(0, 103, 71));

		JLabel jLabel27 = new JLabel();
		jLabel27.setText("Controle Por Mês - Pago");
		jLabel27.setForeground(Color.WHITE);
		jLabel27.setFont(new Font("Segoe UI", Font.BOLD, 10));
		GroupLayout gl_jPanel21 = new GroupLayout(jPanel21);
		gl_jPanel21.setHorizontalGroup(
				gl_jPanel21.createParallelGroup(Alignment.LEADING).addGap(0, 114, Short.MAX_VALUE).addGroup(
						gl_jPanel21.createSequentialGroup().addComponent(jLabel27).addGap(0, 0, Short.MAX_VALUE)));
		gl_jPanel21.setVerticalGroup(gl_jPanel21.createParallelGroup(Alignment.LEADING).addGap(0, 14, Short.MAX_VALUE)
				.addComponent(jLabel27));
		jPanel21.setLayout(gl_jPanel21);

		JPanel jp_jan_devendo1 = new JPanel();
		jp_jan_devendo1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jp_jan_devendo1.setOpaque(false);
		jp_jan_devendo1.setLayout(new GridLayout(3, 0));

		JPanel jPanel73 = new JPanel();
		jPanel73.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jp_jan_devendo1.add(jPanel73);
		jPanel73.setLayout(new GridLayout(1, 0));

		JPanel jPanel74 = new JPanel();
		jPanel74.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel73.add(jPanel74);

		JLabel jLabel70 = new JLabel();
		jLabel70.setText("Tipo");
		jLabel70.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabel70.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel74 = new GroupLayout(jPanel74);
		gl_jPanel74.setHorizontalGroup(gl_jPanel74.createParallelGroup(Alignment.LEADING).addGap(0, 70, Short.MAX_VALUE)
				.addGroup(gl_jPanel74.createSequentialGroup().addGap(18)
						.addComponent(jLabel70, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE).addContainerGap()));
		gl_jPanel74.setVerticalGroup(gl_jPanel74.createParallelGroup(Alignment.LEADING).addGap(0, 51, Short.MAX_VALUE)
				.addComponent(jLabel70, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE));
		jPanel74.setLayout(gl_jPanel74);

		JPanel jPanel75 = new JPanel();
		jPanel75.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel73.add(jPanel75);

		JLabel jLabel71 = new JLabel();
		jLabel71.setText("Janeiro");
		jLabel71.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabel71.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel75 = new GroupLayout(jPanel75);
		gl_jPanel75.setHorizontalGroup(gl_jPanel75.createParallelGroup(Alignment.LEADING).addGap(0, 70, Short.MAX_VALUE)
				.addGroup(gl_jPanel75.createSequentialGroup().addGap(18)
						.addComponent(jLabel71, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));
		gl_jPanel75.setVerticalGroup(gl_jPanel75.createParallelGroup(Alignment.LEADING).addGap(0, 51, Short.MAX_VALUE)
				.addComponent(jLabel71, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE));
		jPanel75.setLayout(gl_jPanel75);

		JPanel jPanel76 = new JPanel();
		jPanel76.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel73.add(jPanel76);

		JLabel jLabel72 = new JLabel();
		jLabel72.setText("Fevereiro");
		jLabel72.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabel72.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel76 = new GroupLayout(jPanel76);
		gl_jPanel76.setHorizontalGroup(gl_jPanel76.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 70, Short.MAX_VALUE).addGroup(gl_jPanel76.createSequentialGroup().addContainerGap()
						.addComponent(jLabel72, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)));
		gl_jPanel76.setVerticalGroup(gl_jPanel76.createParallelGroup(Alignment.LEADING).addGap(0, 51, Short.MAX_VALUE)
				.addComponent(jLabel72, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE));
		jPanel76.setLayout(gl_jPanel76);

		JPanel jPanel77 = new JPanel();
		jPanel77.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel73.add(jPanel77);

		JLabel jLabel73 = new JLabel();
		jLabel73.setText("Março");
		jLabel73.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabel73.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel77 = new GroupLayout(jPanel77);
		gl_jPanel77.setHorizontalGroup(gl_jPanel77.createParallelGroup(Alignment.LEADING).addGap(0, 70, Short.MAX_VALUE)
				.addGroup(gl_jPanel77.createSequentialGroup().addGap(18)
						.addComponent(jLabel73, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE).addContainerGap()));
		gl_jPanel77.setVerticalGroup(gl_jPanel77.createParallelGroup(Alignment.LEADING).addGap(0, 51, Short.MAX_VALUE)
				.addComponent(jLabel73, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE));
		jPanel77.setLayout(gl_jPanel77);

		JPanel jPanel78 = new JPanel();
		jPanel78.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel73.add(jPanel78);

		JLabel jLabel74 = new JLabel();
		jLabel74.setText("Abril");
		jLabel74.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabel74.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel78 = new GroupLayout(jPanel78);
		gl_jPanel78.setHorizontalGroup(gl_jPanel78.createParallelGroup(Alignment.LEADING).addGap(0, 70, Short.MAX_VALUE)
				.addGroup(gl_jPanel78.createSequentialGroup().addGap(18)
						.addComponent(jLabel74, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE).addContainerGap()));
		gl_jPanel78.setVerticalGroup(gl_jPanel78.createParallelGroup(Alignment.LEADING).addGap(0, 51, Short.MAX_VALUE)
				.addComponent(jLabel74, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE));
		jPanel78.setLayout(gl_jPanel78);

		JPanel jPanel79 = new JPanel();
		jPanel79.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel73.add(jPanel79);

		JLabel jLabel75 = new JLabel();
		jLabel75.setText("Maio");
		jLabel75.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabel75.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel79 = new GroupLayout(jPanel79);
		gl_jPanel79.setHorizontalGroup(gl_jPanel79.createParallelGroup(Alignment.LEADING).addGap(0, 70, Short.MAX_VALUE)
				.addGroup(gl_jPanel79.createSequentialGroup().addGap(18)
						.addComponent(jLabel75, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE).addContainerGap()));
		gl_jPanel79.setVerticalGroup(gl_jPanel79.createParallelGroup(Alignment.LEADING).addGap(0, 51, Short.MAX_VALUE)
				.addComponent(jLabel75, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE));
		jPanel79.setLayout(gl_jPanel79);

		JPanel jPanel80 = new JPanel();
		jPanel80.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel73.add(jPanel80);

		JLabel jLabel76 = new JLabel();
		jLabel76.setText("Junho");
		jLabel76.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabel76.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel80 = new GroupLayout(jPanel80);
		gl_jPanel80.setHorizontalGroup(gl_jPanel80.createParallelGroup(Alignment.LEADING).addGap(0, 70, Short.MAX_VALUE)
				.addGroup(gl_jPanel80.createSequentialGroup().addGap(18)
						.addComponent(jLabel76, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE).addContainerGap()));
		gl_jPanel80.setVerticalGroup(gl_jPanel80.createParallelGroup(Alignment.LEADING).addGap(0, 51, Short.MAX_VALUE)
				.addComponent(jLabel76, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE));
		jPanel80.setLayout(gl_jPanel80);

		JPanel jPanel81 = new JPanel();
		jPanel81.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel73.add(jPanel81);

		JLabel jLabel77 = new JLabel();
		jLabel77.setText("Julho");
		jLabel77.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabel77.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel81 = new GroupLayout(jPanel81);
		gl_jPanel81.setHorizontalGroup(gl_jPanel81.createParallelGroup(Alignment.LEADING).addGap(0, 70, Short.MAX_VALUE)
				.addGroup(gl_jPanel81.createSequentialGroup().addGap(18)
						.addComponent(jLabel77, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE).addContainerGap()));
		gl_jPanel81.setVerticalGroup(gl_jPanel81.createParallelGroup(Alignment.LEADING).addGap(0, 51, Short.MAX_VALUE)
				.addComponent(jLabel77, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE));
		jPanel81.setLayout(gl_jPanel81);

		JPanel jPanel82 = new JPanel();
		jPanel82.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel73.add(jPanel82);

		JLabel jLabel78 = new JLabel();
		jLabel78.setText("Agosto");
		jLabel78.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabel78.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel82 = new GroupLayout(jPanel82);
		gl_jPanel82.setHorizontalGroup(gl_jPanel82.createParallelGroup(Alignment.LEADING).addGap(0, 70, Short.MAX_VALUE)
				.addGroup(gl_jPanel82.createSequentialGroup().addContainerGap().addComponent(jLabel78,
						GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)));
		gl_jPanel82.setVerticalGroup(gl_jPanel82.createParallelGroup(Alignment.LEADING).addGap(0, 51, Short.MAX_VALUE)
				.addComponent(jLabel78, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE));
		jPanel82.setLayout(gl_jPanel82);

		JPanel jPanel83 = new JPanel();
		jPanel83.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel73.add(jPanel83);

		JLabel jLabel79 = new JLabel();
		jLabel79.setText("Setembro");
		jLabel79.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabel79.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel83 = new GroupLayout(jPanel83);
		gl_jPanel83.setHorizontalGroup(gl_jPanel83.createParallelGroup(Alignment.TRAILING).addComponent(jLabel79,
				GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE));
		gl_jPanel83.setVerticalGroup(gl_jPanel83.createParallelGroup(Alignment.LEADING).addComponent(jLabel79,
				GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE));
		jPanel83.setLayout(gl_jPanel83);

		JPanel jPanel84 = new JPanel();
		jPanel84.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel73.add(jPanel84);

		JLabel jLabel80 = new JLabel();
		jLabel80.setText("Outubro");
		jLabel80.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabel80.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel84 = new GroupLayout(jPanel84);
		gl_jPanel84.setHorizontalGroup(gl_jPanel84.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 70, Short.MAX_VALUE).addGroup(gl_jPanel84.createSequentialGroup().addContainerGap()
						.addComponent(jLabel80, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)));
		gl_jPanel84.setVerticalGroup(gl_jPanel84.createParallelGroup(Alignment.LEADING).addGap(0, 51, Short.MAX_VALUE)
				.addComponent(jLabel80, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE));
		jPanel84.setLayout(gl_jPanel84);

		JPanel jPanel85 = new JPanel();
		jPanel85.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel73.add(jPanel85);

		JLabel jLabel81 = new JLabel();
		jLabel81.setText("Novembro");
		jLabel81.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabel81.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel85 = new GroupLayout(jPanel85);
		gl_jPanel85.setHorizontalGroup(gl_jPanel85.createParallelGroup(Alignment.LEADING).addGap(0, 70, Short.MAX_VALUE)
				.addComponent(jLabel81, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE));
		gl_jPanel85.setVerticalGroup(gl_jPanel85.createParallelGroup(Alignment.LEADING).addGap(0, 51, Short.MAX_VALUE)
				.addComponent(jLabel81, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE));
		jPanel85.setLayout(gl_jPanel85);

		JPanel jPanel86 = new JPanel();
		jPanel86.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel73.add(jPanel86);

		JLabel jLabel82 = new JLabel();
		jLabel82.setText("Dezembro");
		jLabel82.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabel82.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel86 = new GroupLayout(jPanel86);
		gl_jPanel86.setHorizontalGroup(gl_jPanel86.createParallelGroup(Alignment.LEADING).addGap(0, 70, Short.MAX_VALUE)
				.addComponent(jLabel82, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE));
		gl_jPanel86.setVerticalGroup(gl_jPanel86.createParallelGroup(Alignment.LEADING).addGap(0, 51, Short.MAX_VALUE)
				.addComponent(jLabel82, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE));
		jPanel86.setLayout(gl_jPanel86);

		JPanel jPanel87 = new JPanel();
		jPanel87.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel73.add(jPanel87);

		JLabel jLabel83 = new JLabel();
		jLabel83.setText("Total");
		jLabel83.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabel83.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel87 = new GroupLayout(jPanel87);
		gl_jPanel87.setHorizontalGroup(gl_jPanel87.createParallelGroup(Alignment.LEADING).addGap(0, 70, Short.MAX_VALUE)
				.addGroup(gl_jPanel87.createSequentialGroup().addGap(18)
						.addComponent(jLabel83, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE).addContainerGap()));
		gl_jPanel87.setVerticalGroup(gl_jPanel87.createParallelGroup(Alignment.LEADING).addGap(0, 51, Short.MAX_VALUE)
				.addComponent(jLabel83, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE));
		jPanel87.setLayout(gl_jPanel87);

		JPanel jPanel88 = new JPanel();
		jPanel88.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jp_jan_devendo1.add(jPanel88);
		jPanel88.setLayout(new GridLayout(1, 0));

		JPanel jPanel89 = new JPanel();
		jPanel89.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel89.setBackground(Color.WHITE);
		jPanel88.add(jPanel89);

		JLabel jLabel84 = new JLabel();
		jLabel84.setText("Posto");
		jLabel84.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabel84.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel89 = new GroupLayout(jPanel89);
		gl_jPanel89
				.setHorizontalGroup(gl_jPanel89.createParallelGroup(Alignment.TRAILING).addGap(0, 70, Short.MAX_VALUE)
						.addGroup(gl_jPanel89.createSequentialGroup().addContainerGap(17, Short.MAX_VALUE)
								.addComponent(jLabel84, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));
		gl_jPanel89.setVerticalGroup(gl_jPanel89.createParallelGroup(Alignment.LEADING).addGap(0, 51, Short.MAX_VALUE)
				.addComponent(jLabel84, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE));
		jPanel89.setLayout(gl_jPanel89);

		JPanel jPanel90 = new JPanel();
		jPanel90.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel90.setBackground(Color.WHITE);
		jPanel88.add(jPanel90);

		lb_jan_posto_pg = new JLabel();
		lb_jan_posto_pg.setText("0");
		lb_jan_posto_pg.setHorizontalTextPosition(SwingConstants.CENTER);
		lb_jan_posto_pg.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel90 = new GroupLayout(jPanel90);
		gl_jPanel90
				.setHorizontalGroup(gl_jPanel90.createParallelGroup(Alignment.TRAILING).addGap(0, 70, Short.MAX_VALUE)
						.addGroup(gl_jPanel90.createSequentialGroup()
								.addComponent(lb_jan_posto_pg, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
								.addContainerGap()));
		gl_jPanel90.setVerticalGroup(gl_jPanel90.createParallelGroup(Alignment.LEADING).addGap(0, 51, Short.MAX_VALUE)
				.addComponent(lb_jan_posto_pg, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE));
		jPanel90.setLayout(gl_jPanel90);

		JPanel jPanel91 = new JPanel();
		jPanel91.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel91.setBackground(Color.WHITE);
		jPanel88.add(jPanel91);

		lb_fev_posto_pg = new JLabel();
		lb_fev_posto_pg.setText("0");
		lb_fev_posto_pg.setHorizontalTextPosition(SwingConstants.CENTER);
		lb_fev_posto_pg.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel91 = new GroupLayout(jPanel91);
		gl_jPanel91
				.setHorizontalGroup(gl_jPanel91.createParallelGroup(Alignment.TRAILING).addGap(0, 70, Short.MAX_VALUE)
						.addGroup(gl_jPanel91.createSequentialGroup()
								.addComponent(lb_fev_posto_pg, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
								.addContainerGap()));
		gl_jPanel91.setVerticalGroup(gl_jPanel91.createParallelGroup(Alignment.LEADING).addGap(0, 51, Short.MAX_VALUE)
				.addComponent(lb_fev_posto_pg, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE));
		jPanel91.setLayout(gl_jPanel91);

		JPanel jPanel92 = new JPanel();
		jPanel92.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel92.setBackground(Color.WHITE);
		jPanel88.add(jPanel92);

		lb_mar_posto_pg = new JLabel();
		lb_mar_posto_pg.setText("0");
		lb_mar_posto_pg.setHorizontalTextPosition(SwingConstants.CENTER);
		lb_mar_posto_pg.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel92 = new GroupLayout(jPanel92);
		gl_jPanel92
				.setHorizontalGroup(gl_jPanel92.createParallelGroup(Alignment.TRAILING).addGap(0, 70, Short.MAX_VALUE)
						.addGroup(gl_jPanel92.createSequentialGroup()
								.addComponent(lb_mar_posto_pg, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
								.addContainerGap()));
		gl_jPanel92.setVerticalGroup(gl_jPanel92.createParallelGroup(Alignment.LEADING).addGap(0, 51, Short.MAX_VALUE)
				.addComponent(lb_mar_posto_pg, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE));
		jPanel92.setLayout(gl_jPanel92);

		JPanel jPanel93 = new JPanel();
		jPanel93.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel93.setBackground(Color.WHITE);
		jPanel88.add(jPanel93);

		lb_abr_posto_pg = new JLabel();
		lb_abr_posto_pg.setText("0");
		lb_abr_posto_pg.setHorizontalTextPosition(SwingConstants.CENTER);
		lb_abr_posto_pg.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel93 = new GroupLayout(jPanel93);
		gl_jPanel93
				.setHorizontalGroup(gl_jPanel93.createParallelGroup(Alignment.TRAILING).addGap(0, 70, Short.MAX_VALUE)
						.addGroup(gl_jPanel93.createSequentialGroup()
								.addComponent(lb_abr_posto_pg, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
								.addContainerGap()));
		gl_jPanel93.setVerticalGroup(gl_jPanel93.createParallelGroup(Alignment.LEADING).addGap(0, 51, Short.MAX_VALUE)
				.addComponent(lb_abr_posto_pg, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE));
		jPanel93.setLayout(gl_jPanel93);

		JPanel jPanel94 = new JPanel();
		jPanel94.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel94.setBackground(Color.WHITE);
		jPanel88.add(jPanel94);

		lb_mai_posto_pg = new JLabel();
		lb_mai_posto_pg.setText("0");
		lb_mai_posto_pg.setHorizontalTextPosition(SwingConstants.CENTER);
		lb_mai_posto_pg.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel94 = new GroupLayout(jPanel94);
		gl_jPanel94
				.setHorizontalGroup(gl_jPanel94.createParallelGroup(Alignment.TRAILING).addGap(0, 70, Short.MAX_VALUE)
						.addGroup(gl_jPanel94.createSequentialGroup()
								.addComponent(lb_mai_posto_pg, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
								.addContainerGap()));
		gl_jPanel94.setVerticalGroup(gl_jPanel94.createParallelGroup(Alignment.LEADING).addGap(0, 51, Short.MAX_VALUE)
				.addComponent(lb_mai_posto_pg, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE));
		jPanel94.setLayout(gl_jPanel94);

		JPanel jPanel95 = new JPanel();
		jPanel95.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel95.setBackground(Color.WHITE);
		jPanel88.add(jPanel95);

		lb_jun_posto_pg = new JLabel();
		lb_jun_posto_pg.setText("0");
		lb_jun_posto_pg.setHorizontalTextPosition(SwingConstants.CENTER);
		lb_jun_posto_pg.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel95 = new GroupLayout(jPanel95);
		gl_jPanel95
				.setHorizontalGroup(gl_jPanel95.createParallelGroup(Alignment.TRAILING).addGap(0, 70, Short.MAX_VALUE)
						.addGroup(gl_jPanel95.createSequentialGroup()
								.addComponent(lb_jun_posto_pg, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
								.addContainerGap()));
		gl_jPanel95.setVerticalGroup(gl_jPanel95.createParallelGroup(Alignment.LEADING).addGap(0, 51, Short.MAX_VALUE)
				.addComponent(lb_jun_posto_pg, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE));
		jPanel95.setLayout(gl_jPanel95);

		JPanel jPanel96 = new JPanel();
		jPanel96.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel96.setBackground(Color.WHITE);
		jPanel88.add(jPanel96);

		lb_jul_posto_pg = new JLabel();
		lb_jul_posto_pg.setText("0");
		lb_jul_posto_pg.setHorizontalTextPosition(SwingConstants.CENTER);
		lb_jul_posto_pg.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel96 = new GroupLayout(jPanel96);
		gl_jPanel96
				.setHorizontalGroup(gl_jPanel96.createParallelGroup(Alignment.TRAILING).addGap(0, 70, Short.MAX_VALUE)
						.addGroup(gl_jPanel96.createSequentialGroup()
								.addComponent(lb_jul_posto_pg, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
								.addContainerGap()));
		gl_jPanel96.setVerticalGroup(gl_jPanel96.createParallelGroup(Alignment.LEADING).addGap(0, 51, Short.MAX_VALUE)
				.addComponent(lb_jul_posto_pg, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE));
		jPanel96.setLayout(gl_jPanel96);

		JPanel jPanel97 = new JPanel();
		jPanel97.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel97.setBackground(Color.WHITE);
		jPanel88.add(jPanel97);

		lb_ago_posto_pg = new JLabel();
		lb_ago_posto_pg.setText("0");
		lb_ago_posto_pg.setHorizontalTextPosition(SwingConstants.CENTER);
		lb_ago_posto_pg.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel97 = new GroupLayout(jPanel97);
		gl_jPanel97.setHorizontalGroup(gl_jPanel97.createParallelGroup(Alignment.LEADING).addGap(0, 70, Short.MAX_VALUE)
				.addGroup(gl_jPanel97.createSequentialGroup().addGap(0)
						.addComponent(lb_ago_posto_pg, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
						.addContainerGap()));
		gl_jPanel97.setVerticalGroup(gl_jPanel97.createParallelGroup(Alignment.LEADING).addGap(0, 51, Short.MAX_VALUE)
				.addComponent(lb_ago_posto_pg, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE));
		jPanel97.setLayout(gl_jPanel97);

		JPanel jPanel98 = new JPanel();
		jPanel98.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel98.setBackground(Color.WHITE);
		jPanel88.add(jPanel98);

		lb_set_posto_pg = new JLabel();
		lb_set_posto_pg.setText("0");
		lb_set_posto_pg.setHorizontalTextPosition(SwingConstants.CENTER);
		lb_set_posto_pg.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel98 = new GroupLayout(jPanel98);
		gl_jPanel98
				.setHorizontalGroup(gl_jPanel98.createParallelGroup(Alignment.TRAILING).addGap(0, 70, Short.MAX_VALUE)
						.addGroup(gl_jPanel98.createSequentialGroup()
								.addComponent(lb_set_posto_pg, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
								.addContainerGap()));
		gl_jPanel98.setVerticalGroup(gl_jPanel98.createParallelGroup(Alignment.LEADING).addGap(0, 51, Short.MAX_VALUE)
				.addComponent(lb_set_posto_pg, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE));
		jPanel98.setLayout(gl_jPanel98);

		JPanel jPanel99 = new JPanel();
		jPanel99.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel99.setBackground(Color.WHITE);
		jPanel88.add(jPanel99);

		lb_out_posto_pg = new JLabel();
		lb_out_posto_pg.setText("0");
		lb_out_posto_pg.setHorizontalTextPosition(SwingConstants.CENTER);
		lb_out_posto_pg.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel99 = new GroupLayout(jPanel99);
		gl_jPanel99
				.setHorizontalGroup(gl_jPanel99.createParallelGroup(Alignment.TRAILING).addGap(0, 70, Short.MAX_VALUE)
						.addGroup(gl_jPanel99.createSequentialGroup()
								.addComponent(lb_out_posto_pg, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
								.addContainerGap()));
		gl_jPanel99.setVerticalGroup(gl_jPanel99.createParallelGroup(Alignment.LEADING).addGap(0, 51, Short.MAX_VALUE)
				.addComponent(lb_out_posto_pg, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE));
		jPanel99.setLayout(gl_jPanel99);

		JPanel jPanel100 = new JPanel();
		jPanel100.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel100.setBackground(Color.WHITE);
		jPanel88.add(jPanel100);

		lb_nov_posto_pg = new JLabel();
		lb_nov_posto_pg.setText("0");
		lb_nov_posto_pg.setHorizontalTextPosition(SwingConstants.CENTER);
		lb_nov_posto_pg.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel100 = new GroupLayout(jPanel100);
		gl_jPanel100
				.setHorizontalGroup(gl_jPanel100.createParallelGroup(Alignment.TRAILING).addGap(0, 70, Short.MAX_VALUE)
						.addGroup(gl_jPanel100.createSequentialGroup()
								.addComponent(lb_nov_posto_pg, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
								.addContainerGap()));
		gl_jPanel100.setVerticalGroup(gl_jPanel100.createParallelGroup(Alignment.LEADING).addGap(0, 51, Short.MAX_VALUE)
				.addComponent(lb_nov_posto_pg, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE));
		jPanel100.setLayout(gl_jPanel100);

		JPanel jPanel101 = new JPanel();
		jPanel101.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel101.setBackground(Color.WHITE);
		jPanel88.add(jPanel101);

		lb_dez_posto_pg = new JLabel();
		lb_dez_posto_pg.setText("0");
		lb_dez_posto_pg.setHorizontalTextPosition(SwingConstants.CENTER);
		lb_dez_posto_pg.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel101 = new GroupLayout(jPanel101);
		gl_jPanel101
				.setHorizontalGroup(gl_jPanel101.createParallelGroup(Alignment.TRAILING).addGap(0, 70, Short.MAX_VALUE)
						.addGroup(gl_jPanel101.createSequentialGroup()
								.addComponent(lb_dez_posto_pg, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
								.addContainerGap()));
		gl_jPanel101.setVerticalGroup(gl_jPanel101.createParallelGroup(Alignment.LEADING).addGap(0, 51, Short.MAX_VALUE)
				.addComponent(lb_dez_posto_pg, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE));
		jPanel101.setLayout(gl_jPanel101);

		JPanel jPanel102 = new JPanel();
		jPanel102.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel102.setBackground(Color.WHITE);
		jPanel88.add(jPanel102);

		lb_total_posto_pg = new JLabel();
		lb_total_posto_pg.setText("0");
		lb_total_posto_pg.setHorizontalTextPosition(SwingConstants.CENTER);
		lb_total_posto_pg.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel102 = new GroupLayout(jPanel102);
		gl_jPanel102
				.setHorizontalGroup(gl_jPanel102.createParallelGroup(Alignment.TRAILING).addGap(0, 70, Short.MAX_VALUE)
						.addGroup(gl_jPanel102.createSequentialGroup()
								.addComponent(lb_total_posto_pg, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
								.addContainerGap()));
		gl_jPanel102.setVerticalGroup(gl_jPanel102.createParallelGroup(Alignment.LEADING).addGap(0, 51, Short.MAX_VALUE)
				.addComponent(lb_total_posto_pg, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE));
		jPanel102.setLayout(gl_jPanel102);

		JPanel jPanel103 = new JPanel();
		jPanel103.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jp_jan_devendo1.add(jPanel103);
		jPanel103.setLayout(new GridLayout(1, 0));

		JPanel jPanel104 = new JPanel();
		jPanel104.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel104.setBackground(Color.WHITE);
		jPanel103.add(jPanel104);

		JLabel jLabel98 = new JLabel();
		jLabel98.setText("Horas");
		jLabel98.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabel98.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel104 = new GroupLayout(jPanel104);
		gl_jPanel104.setHorizontalGroup(gl_jPanel104.createParallelGroup(Alignment.LEADING)
				.addGap(0, 70, Short.MAX_VALUE).addGroup(gl_jPanel104.createSequentialGroup().addGap(18)
						.addComponent(jLabel98, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE).addContainerGap()));
		gl_jPanel104.setVerticalGroup(gl_jPanel104.createParallelGroup(Alignment.LEADING).addGap(0, 51, Short.MAX_VALUE)
				.addComponent(jLabel98, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE));
		jPanel104.setLayout(gl_jPanel104);

		JPanel jPanel105 = new JPanel();
		jPanel105.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel105.setBackground(Color.WHITE);
		jPanel103.add(jPanel105);

		lb_jan_horas_pg = new JLabel();
		lb_jan_horas_pg.setText("00:00");
		lb_jan_horas_pg.setHorizontalTextPosition(SwingConstants.CENTER);
		lb_jan_horas_pg.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel105 = new GroupLayout(jPanel105);
		gl_jPanel105
				.setHorizontalGroup(gl_jPanel105.createParallelGroup(Alignment.TRAILING).addGap(0, 70, Short.MAX_VALUE)
						.addGroup(gl_jPanel105.createSequentialGroup()
								.addComponent(lb_jan_horas_pg, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
								.addContainerGap()));
		gl_jPanel105.setVerticalGroup(gl_jPanel105.createParallelGroup(Alignment.LEADING).addGap(0, 51, Short.MAX_VALUE)
				.addComponent(lb_jan_horas_pg, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE));
		jPanel105.setLayout(gl_jPanel105);

		JPanel jPanel106 = new JPanel();
		jPanel106.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel106.setBackground(Color.WHITE);
		jPanel103.add(jPanel106);

		lb_fev_horas_pg = new JLabel();
		lb_fev_horas_pg.setText("00:00");
		lb_fev_horas_pg.setHorizontalTextPosition(SwingConstants.CENTER);
		lb_fev_horas_pg.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel106 = new GroupLayout(jPanel106);
		gl_jPanel106
				.setHorizontalGroup(gl_jPanel106.createParallelGroup(Alignment.TRAILING).addGap(0, 70, Short.MAX_VALUE)
						.addGroup(gl_jPanel106.createSequentialGroup()
								.addComponent(lb_fev_horas_pg, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
								.addContainerGap()));
		gl_jPanel106.setVerticalGroup(gl_jPanel106.createParallelGroup(Alignment.LEADING).addGap(0, 51, Short.MAX_VALUE)
				.addComponent(lb_fev_horas_pg, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE));
		jPanel106.setLayout(gl_jPanel106);

		JPanel jPanel107 = new JPanel();
		jPanel107.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel107.setBackground(Color.WHITE);
		jPanel103.add(jPanel107);

		lb_mar_horas_pg = new JLabel();
		lb_mar_horas_pg.setText("00:00");
		lb_mar_horas_pg.setHorizontalTextPosition(SwingConstants.CENTER);
		lb_mar_horas_pg.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel107 = new GroupLayout(jPanel107);
		gl_jPanel107
				.setHorizontalGroup(gl_jPanel107.createParallelGroup(Alignment.TRAILING).addGap(0, 70, Short.MAX_VALUE)
						.addGroup(gl_jPanel107.createSequentialGroup()
								.addComponent(lb_mar_horas_pg, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
								.addContainerGap()));
		gl_jPanel107.setVerticalGroup(gl_jPanel107.createParallelGroup(Alignment.LEADING).addGap(0, 51, Short.MAX_VALUE)
				.addComponent(lb_mar_horas_pg, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE));
		jPanel107.setLayout(gl_jPanel107);

		JPanel jPanel108 = new JPanel();
		jPanel108.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel108.setBackground(Color.WHITE);
		jPanel103.add(jPanel108);

		lb_abr_horas_pg = new JLabel();
		lb_abr_horas_pg.setText("00:00");
		lb_abr_horas_pg.setHorizontalTextPosition(SwingConstants.CENTER);
		lb_abr_horas_pg.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel108 = new GroupLayout(jPanel108);
		gl_jPanel108
				.setHorizontalGroup(gl_jPanel108.createParallelGroup(Alignment.TRAILING).addGap(0, 70, Short.MAX_VALUE)
						.addGroup(gl_jPanel108.createSequentialGroup()
								.addComponent(lb_abr_horas_pg, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
								.addContainerGap()));
		gl_jPanel108.setVerticalGroup(gl_jPanel108.createParallelGroup(Alignment.LEADING).addGap(0, 51, Short.MAX_VALUE)
				.addComponent(lb_abr_horas_pg, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE));
		jPanel108.setLayout(gl_jPanel108);

		JPanel jPanel109 = new JPanel();
		jPanel109.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel109.setBackground(Color.WHITE);
		jPanel103.add(jPanel109);

		lb_mai_horas_pg = new JLabel();
		lb_mai_horas_pg.setText("00:00");
		lb_mai_horas_pg.setHorizontalTextPosition(SwingConstants.CENTER);
		lb_mai_horas_pg.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel109 = new GroupLayout(jPanel109);
		gl_jPanel109
				.setHorizontalGroup(gl_jPanel109.createParallelGroup(Alignment.TRAILING).addGap(0, 70, Short.MAX_VALUE)
						.addGroup(gl_jPanel109.createSequentialGroup()
								.addComponent(lb_mai_horas_pg, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
								.addContainerGap()));
		gl_jPanel109.setVerticalGroup(gl_jPanel109.createParallelGroup(Alignment.LEADING).addGap(0, 51, Short.MAX_VALUE)
				.addComponent(lb_mai_horas_pg, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE));
		jPanel109.setLayout(gl_jPanel109);

		JPanel jPanel110 = new JPanel();
		jPanel110.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel110.setBackground(Color.WHITE);
		jPanel103.add(jPanel110);

		lb_jun_horas_pg = new JLabel();
		lb_jun_horas_pg.setText("00:00");
		lb_jun_horas_pg.setHorizontalTextPosition(SwingConstants.CENTER);
		lb_jun_horas_pg.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel110 = new GroupLayout(jPanel110);
		gl_jPanel110
				.setHorizontalGroup(gl_jPanel110.createParallelGroup(Alignment.TRAILING).addGap(0, 70, Short.MAX_VALUE)
						.addGroup(gl_jPanel110.createSequentialGroup()
								.addComponent(lb_jun_horas_pg, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
								.addContainerGap()));
		gl_jPanel110.setVerticalGroup(gl_jPanel110.createParallelGroup(Alignment.LEADING).addGap(0, 51, Short.MAX_VALUE)
				.addComponent(lb_jun_horas_pg, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE));
		jPanel110.setLayout(gl_jPanel110);

		JPanel jPanel111 = new JPanel();
		jPanel111.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel111.setBackground(Color.WHITE);
		jPanel103.add(jPanel111);

		lb_jul_horas_pg = new JLabel();
		lb_jul_horas_pg.setText("00:00");
		lb_jul_horas_pg.setHorizontalTextPosition(SwingConstants.CENTER);
		lb_jul_horas_pg.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel111 = new GroupLayout(jPanel111);
		gl_jPanel111
				.setHorizontalGroup(gl_jPanel111.createParallelGroup(Alignment.TRAILING).addGap(0, 70, Short.MAX_VALUE)
						.addGroup(gl_jPanel111.createSequentialGroup()
								.addComponent(lb_jul_horas_pg, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
								.addContainerGap()));
		gl_jPanel111.setVerticalGroup(gl_jPanel111.createParallelGroup(Alignment.LEADING).addGap(0, 51, Short.MAX_VALUE)
				.addComponent(lb_jul_horas_pg, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE));
		jPanel111.setLayout(gl_jPanel111);

		JPanel jPanel112 = new JPanel();
		jPanel112.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel112.setBackground(Color.WHITE);
		jPanel103.add(jPanel112);

		lb_ago_horas_pg = new JLabel();
		lb_ago_horas_pg.setText("00:00");
		lb_ago_horas_pg.setHorizontalTextPosition(SwingConstants.CENTER);
		lb_ago_horas_pg.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel112 = new GroupLayout(jPanel112);
		gl_jPanel112
				.setHorizontalGroup(gl_jPanel112.createParallelGroup(Alignment.TRAILING).addGap(0, 70, Short.MAX_VALUE)
						.addGroup(gl_jPanel112.createSequentialGroup()
								.addComponent(lb_ago_horas_pg, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
								.addContainerGap()));
		gl_jPanel112.setVerticalGroup(gl_jPanel112.createParallelGroup(Alignment.LEADING).addGap(0, 51, Short.MAX_VALUE)
				.addComponent(lb_ago_horas_pg, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE));
		jPanel112.setLayout(gl_jPanel112);

		JPanel jPanel113 = new JPanel();
		jPanel113.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel113.setBackground(Color.WHITE);
		jPanel103.add(jPanel113);

		lb_set_horas_pg = new JLabel();
		lb_set_horas_pg.setText("00:00");
		lb_set_horas_pg.setHorizontalTextPosition(SwingConstants.CENTER);
		lb_set_horas_pg.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel113 = new GroupLayout(jPanel113);
		gl_jPanel113
				.setHorizontalGroup(gl_jPanel113.createParallelGroup(Alignment.TRAILING).addGap(0, 70, Short.MAX_VALUE)
						.addGroup(gl_jPanel113.createSequentialGroup()
								.addComponent(lb_set_horas_pg, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
								.addContainerGap()));
		gl_jPanel113.setVerticalGroup(gl_jPanel113.createParallelGroup(Alignment.LEADING).addGap(0, 51, Short.MAX_VALUE)
				.addComponent(lb_set_horas_pg, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE));
		jPanel113.setLayout(gl_jPanel113);

		JPanel jPanel114 = new JPanel();
		jPanel114.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel114.setBackground(Color.WHITE);
		jPanel103.add(jPanel114);

		lb_out_horas_pg = new JLabel();
		lb_out_horas_pg.setText("00:00");
		lb_out_horas_pg.setHorizontalTextPosition(SwingConstants.CENTER);
		lb_out_horas_pg.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel114 = new GroupLayout(jPanel114);
		gl_jPanel114
				.setHorizontalGroup(gl_jPanel114.createParallelGroup(Alignment.TRAILING).addGap(0, 70, Short.MAX_VALUE)
						.addGroup(gl_jPanel114.createSequentialGroup()
								.addComponent(lb_out_horas_pg, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
								.addContainerGap()));
		gl_jPanel114.setVerticalGroup(gl_jPanel114.createParallelGroup(Alignment.LEADING).addGap(0, 51, Short.MAX_VALUE)
				.addComponent(lb_out_horas_pg, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE));
		jPanel114.setLayout(gl_jPanel114);

		JPanel jPanel115 = new JPanel();
		jPanel115.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel115.setBackground(Color.WHITE);
		jPanel103.add(jPanel115);

		lb_nov_horas_pg = new JLabel();
		lb_nov_horas_pg.setText("00:00");
		lb_nov_horas_pg.setHorizontalTextPosition(SwingConstants.CENTER);
		lb_nov_horas_pg.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel115 = new GroupLayout(jPanel115);
		gl_jPanel115
				.setHorizontalGroup(gl_jPanel115.createParallelGroup(Alignment.TRAILING).addGap(0, 70, Short.MAX_VALUE)
						.addGroup(gl_jPanel115.createSequentialGroup()
								.addComponent(lb_nov_horas_pg, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
								.addContainerGap()));
		gl_jPanel115.setVerticalGroup(gl_jPanel115.createParallelGroup(Alignment.LEADING).addGap(0, 51, Short.MAX_VALUE)
				.addComponent(lb_nov_horas_pg, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE));
		jPanel115.setLayout(gl_jPanel115);

		JPanel jPanel116 = new JPanel();
		jPanel116.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel116.setBackground(Color.WHITE);
		jPanel103.add(jPanel116);

		lb_dez_horas_pg = new JLabel();
		lb_dez_horas_pg.setText("00:00");
		lb_dez_horas_pg.setHorizontalTextPosition(SwingConstants.CENTER);
		lb_dez_horas_pg.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel116 = new GroupLayout(jPanel116);
		gl_jPanel116
				.setHorizontalGroup(gl_jPanel116.createParallelGroup(Alignment.TRAILING).addGap(0, 70, Short.MAX_VALUE)
						.addGroup(gl_jPanel116.createSequentialGroup()
								.addComponent(lb_dez_horas_pg, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
								.addContainerGap()));
		gl_jPanel116.setVerticalGroup(gl_jPanel116.createParallelGroup(Alignment.LEADING).addGap(0, 51, Short.MAX_VALUE)
				.addComponent(lb_dez_horas_pg, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE));
		jPanel116.setLayout(gl_jPanel116);

		JPanel jPanel117 = new JPanel();
		jPanel117.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel117.setBackground(Color.WHITE);
		jPanel103.add(jPanel117);

		lb_total_horas_pg = new JLabel();
		lb_total_horas_pg.setText("00:00");
		lb_total_horas_pg.setHorizontalTextPosition(SwingConstants.CENTER);
		lb_total_horas_pg.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel117 = new GroupLayout(jPanel117);
		gl_jPanel117
				.setHorizontalGroup(gl_jPanel117.createParallelGroup(Alignment.TRAILING).addGap(0, 70, Short.MAX_VALUE)
						.addGroup(gl_jPanel117.createSequentialGroup()
								.addComponent(lb_total_horas_pg, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
								.addContainerGap()));
		gl_jPanel117.setVerticalGroup(gl_jPanel117.createParallelGroup(Alignment.LEADING).addGap(0, 51, Short.MAX_VALUE)
				.addComponent(lb_total_horas_pg, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE));
		jPanel117.setLayout(gl_jPanel117);
		GroupLayout gl_jPanel19 = new GroupLayout(jPanel19);
		gl_jPanel19
				.setHorizontalGroup(gl_jPanel19.createParallelGroup(Alignment.LEADING).addGap(0, 1007, Short.MAX_VALUE)
						.addGroup(gl_jPanel19.createSequentialGroup()
								.addComponent(jPanel21, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGap(0, 922, Short.MAX_VALUE))
						.addGroup(gl_jPanel19.createSequentialGroup().addContainerGap()
								.addComponent(jp_jan_devendo1, GroupLayout.PREFERRED_SIZE, 1016, Short.MAX_VALUE)
								.addContainerGap()));
		gl_jPanel19.setVerticalGroup(gl_jPanel19.createParallelGroup(Alignment.LEADING).addGap(0, 185, Short.MAX_VALUE)
				.addGroup(gl_jPanel19.createSequentialGroup()
						.addComponent(jPanel21, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(0, 171, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_jPanel19.createSequentialGroup().addContainerGap(21, Short.MAX_VALUE)
						.addComponent(jp_jan_devendo1, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		jPanel19.setLayout(gl_jPanel19);

		JPanel jPanel18 = new JPanel();
		jPanel18.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel18.setBackground(Color.WHITE);

		JPanel jPanel20 = new JPanel();
		jPanel20.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel20.setBackground(new Color(0, 103, 71));

		JLabel jLabel26 = new JLabel();
		jLabel26.setText("Controle Por Mês");
		jLabel26.setForeground(Color.WHITE);
		jLabel26.setFont(new Font("Segoe UI", Font.BOLD, 8));
		GroupLayout gl_jPanel20 = new GroupLayout(jPanel20);
		gl_jPanel20.setHorizontalGroup(gl_jPanel20.createParallelGroup(Alignment.LEADING).addGap(0, 65, Short.MAX_VALUE)
				.addComponent(jLabel26));
		gl_jPanel20.setVerticalGroup(gl_jPanel20.createParallelGroup(Alignment.LEADING).addGap(0, 11, Short.MAX_VALUE)
				.addComponent(jLabel26));
		jPanel20.setLayout(gl_jPanel20);

		JPanel jp_jan_devendo = new JPanel();
		jp_jan_devendo.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jp_jan_devendo.setOpaque(false);
		jp_jan_devendo.setLayout(new GridLayout(3, 0));

		JPanel jPanel27 = new JPanel();
		jPanel27.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jp_jan_devendo.add(jPanel27);
		jPanel27.setLayout(new GridLayout(1, 0));

		JPanel jPanel31 = new JPanel();
		jPanel31.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel27.add(jPanel31);

		JLabel jLabel41 = new JLabel();
		jLabel41.setText("Tipo");
		jLabel41.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabel41.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel31 = new GroupLayout(jPanel31);
		gl_jPanel31.setHorizontalGroup(gl_jPanel31.createParallelGroup(Alignment.LEADING).addGap(0, 70, Short.MAX_VALUE)
				.addGroup(gl_jPanel31.createSequentialGroup().addGap(18)
						.addComponent(jLabel41, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE).addContainerGap()));
		gl_jPanel31.setVerticalGroup(gl_jPanel31.createParallelGroup(Alignment.LEADING).addGap(0, 45, Short.MAX_VALUE)
				.addComponent(jLabel41, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE));
		jPanel31.setLayout(gl_jPanel31);

		JPanel jPanel32 = new JPanel();
		jPanel32.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel27.add(jPanel32);

		JLabel jLabel40 = new JLabel();
		jLabel40.setText("Janeiro");
		jLabel40.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabel40.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel32 = new GroupLayout(jPanel32);
		gl_jPanel32.setHorizontalGroup(gl_jPanel32.createParallelGroup(Alignment.LEADING).addGap(0, 70, Short.MAX_VALUE)
				.addGroup(gl_jPanel32.createSequentialGroup().addGap(18)
						.addComponent(jLabel40, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));
		gl_jPanel32.setVerticalGroup(gl_jPanel32.createParallelGroup(Alignment.LEADING).addGap(0, 45, Short.MAX_VALUE)
				.addComponent(jLabel40, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE));
		jPanel32.setLayout(gl_jPanel32);

		JPanel jPanel33 = new JPanel();
		jPanel33.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel27.add(jPanel33);

		JLabel jLabel39 = new JLabel();
		jLabel39.setText("Fevereiro");
		jLabel39.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabel39.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel33 = new GroupLayout(jPanel33);
		gl_jPanel33.setHorizontalGroup(gl_jPanel33.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 70, Short.MAX_VALUE).addGroup(gl_jPanel33.createSequentialGroup().addContainerGap()
						.addComponent(jLabel39, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)));
		gl_jPanel33.setVerticalGroup(gl_jPanel33.createParallelGroup(Alignment.LEADING).addGap(0, 45, Short.MAX_VALUE)
				.addComponent(jLabel39, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE));
		jPanel33.setLayout(gl_jPanel33);

		JPanel jPanel34 = new JPanel();
		jPanel34.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel27.add(jPanel34);

		JLabel jLabel38 = new JLabel();
		jLabel38.setText("Março");
		jLabel38.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabel38.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel34 = new GroupLayout(jPanel34);
		gl_jPanel34.setHorizontalGroup(gl_jPanel34.createParallelGroup(Alignment.LEADING).addGap(0, 70, Short.MAX_VALUE)
				.addGroup(gl_jPanel34.createSequentialGroup().addGap(18)
						.addComponent(jLabel38, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE).addContainerGap()));
		gl_jPanel34.setVerticalGroup(gl_jPanel34.createParallelGroup(Alignment.LEADING).addGap(0, 45, Short.MAX_VALUE)
				.addComponent(jLabel38, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE));
		jPanel34.setLayout(gl_jPanel34);

		JPanel jPanel35 = new JPanel();
		jPanel35.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel27.add(jPanel35);

		JLabel jLabel37 = new JLabel();
		jLabel37.setText("Abril");
		jLabel37.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabel37.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel35 = new GroupLayout(jPanel35);
		gl_jPanel35.setHorizontalGroup(gl_jPanel35.createParallelGroup(Alignment.LEADING).addGap(0, 70, Short.MAX_VALUE)
				.addGroup(gl_jPanel35.createSequentialGroup().addGap(18)
						.addComponent(jLabel37, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE).addContainerGap()));
		gl_jPanel35.setVerticalGroup(gl_jPanel35.createParallelGroup(Alignment.LEADING).addGap(0, 45, Short.MAX_VALUE)
				.addComponent(jLabel37, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE));
		jPanel35.setLayout(gl_jPanel35);

		JPanel jPanel36 = new JPanel();
		jPanel36.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel27.add(jPanel36);

		JLabel jLabel36 = new JLabel();
		jLabel36.setText("Maio");
		jLabel36.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabel36.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel36 = new GroupLayout(jPanel36);
		gl_jPanel36.setHorizontalGroup(gl_jPanel36.createParallelGroup(Alignment.LEADING).addGap(0, 70, Short.MAX_VALUE)
				.addGroup(gl_jPanel36.createSequentialGroup().addGap(18)
						.addComponent(jLabel36, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE).addContainerGap()));
		gl_jPanel36.setVerticalGroup(gl_jPanel36.createParallelGroup(Alignment.LEADING).addGap(0, 45, Short.MAX_VALUE)
				.addComponent(jLabel36, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE));
		jPanel36.setLayout(gl_jPanel36);

		JPanel jPanel37 = new JPanel();
		jPanel37.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel27.add(jPanel37);

		JLabel jLabel35 = new JLabel();
		jLabel35.setText("Junho");
		jLabel35.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabel35.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel37 = new GroupLayout(jPanel37);
		gl_jPanel37.setHorizontalGroup(gl_jPanel37.createParallelGroup(Alignment.LEADING).addGap(0, 70, Short.MAX_VALUE)
				.addGroup(gl_jPanel37.createSequentialGroup().addGap(18)
						.addComponent(jLabel35, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE).addContainerGap()));
		gl_jPanel37.setVerticalGroup(gl_jPanel37.createParallelGroup(Alignment.LEADING).addGap(0, 45, Short.MAX_VALUE)
				.addComponent(jLabel35, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE));
		jPanel37.setLayout(gl_jPanel37);

		JPanel jPanel38 = new JPanel();
		jPanel38.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel27.add(jPanel38);

		JLabel jLabel34 = new JLabel();
		jLabel34.setText("Julho");
		jLabel34.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabel34.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel38 = new GroupLayout(jPanel38);
		gl_jPanel38.setHorizontalGroup(gl_jPanel38.createParallelGroup(Alignment.LEADING).addGap(0, 70, Short.MAX_VALUE)
				.addGroup(gl_jPanel38.createSequentialGroup().addGap(18)
						.addComponent(jLabel34, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE).addContainerGap()));
		gl_jPanel38.setVerticalGroup(gl_jPanel38.createParallelGroup(Alignment.LEADING).addGap(0, 45, Short.MAX_VALUE)
				.addComponent(jLabel34, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE));
		jPanel38.setLayout(gl_jPanel38);

		JPanel jPanel39 = new JPanel();
		jPanel39.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel27.add(jPanel39);

		JLabel jLabel33 = new JLabel();
		jLabel33.setText("Agosto");
		jLabel33.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabel33.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel39 = new GroupLayout(jPanel39);
		gl_jPanel39.setHorizontalGroup(gl_jPanel39.createParallelGroup(Alignment.LEADING).addGap(0, 70, Short.MAX_VALUE)
				.addGroup(gl_jPanel39.createSequentialGroup().addContainerGap().addComponent(jLabel33,
						GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)));
		gl_jPanel39.setVerticalGroup(gl_jPanel39.createParallelGroup(Alignment.LEADING).addGap(0, 45, Short.MAX_VALUE)
				.addComponent(jLabel33, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE));
		jPanel39.setLayout(gl_jPanel39);

		JPanel jPanel40 = new JPanel();
		jPanel40.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel27.add(jPanel40);

		JLabel jLabel32 = new JLabel();
		jLabel32.setText("Setembro");
		jLabel32.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabel32.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel40 = new GroupLayout(jPanel40);
		gl_jPanel40.setHorizontalGroup(gl_jPanel40.createParallelGroup(Alignment.TRAILING).addComponent(jLabel32,
				GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE));
		gl_jPanel40.setVerticalGroup(gl_jPanel40.createParallelGroup(Alignment.LEADING).addComponent(jLabel32,
				GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE));
		jPanel40.setLayout(gl_jPanel40);

		JPanel jPanel41 = new JPanel();
		jPanel41.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel27.add(jPanel41);

		JLabel jLabel31 = new JLabel();
		jLabel31.setText("Outubro");
		jLabel31.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabel31.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel41 = new GroupLayout(jPanel41);
		gl_jPanel41.setHorizontalGroup(gl_jPanel41.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 70, Short.MAX_VALUE).addGroup(gl_jPanel41.createSequentialGroup().addContainerGap()
						.addComponent(jLabel31, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)));
		gl_jPanel41.setVerticalGroup(gl_jPanel41.createParallelGroup(Alignment.LEADING).addGap(0, 45, Short.MAX_VALUE)
				.addComponent(jLabel31, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE));
		jPanel41.setLayout(gl_jPanel41);

		JPanel jPanel42 = new JPanel();
		jPanel42.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel27.add(jPanel42);

		JLabel jLabel30 = new JLabel();
		jLabel30.setText("Novembro");
		jLabel30.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabel30.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel42 = new GroupLayout(jPanel42);
		gl_jPanel42.setHorizontalGroup(gl_jPanel42.createParallelGroup(Alignment.LEADING).addGap(0, 70, Short.MAX_VALUE)
				.addComponent(jLabel30, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE));
		gl_jPanel42.setVerticalGroup(gl_jPanel42.createParallelGroup(Alignment.LEADING).addGap(0, 45, Short.MAX_VALUE)
				.addComponent(jLabel30, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE));
		jPanel42.setLayout(gl_jPanel42);

		JPanel jPanel43 = new JPanel();
		jPanel43.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel27.add(jPanel43);

		JLabel jLabel29 = new JLabel();
		jLabel29.setText("Dezembro");
		jLabel29.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabel29.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel43 = new GroupLayout(jPanel43);
		gl_jPanel43.setHorizontalGroup(gl_jPanel43.createParallelGroup(Alignment.LEADING).addGap(0, 70, Short.MAX_VALUE)
				.addComponent(jLabel29, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE));
		gl_jPanel43.setVerticalGroup(gl_jPanel43.createParallelGroup(Alignment.LEADING).addGap(0, 45, Short.MAX_VALUE)
				.addComponent(jLabel29, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE));
		jPanel43.setLayout(gl_jPanel43);

		JPanel jPanel44 = new JPanel();
		jPanel44.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel27.add(jPanel44);

		JLabel jLabel28 = new JLabel();
		jLabel28.setText("Total");
		jLabel28.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabel28.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel44 = new GroupLayout(jPanel44);
		gl_jPanel44.setHorizontalGroup(gl_jPanel44.createParallelGroup(Alignment.LEADING).addGap(0, 70, Short.MAX_VALUE)
				.addGroup(gl_jPanel44.createSequentialGroup().addGap(18)
						.addComponent(jLabel28, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE).addContainerGap()));
		gl_jPanel44.setVerticalGroup(gl_jPanel44.createParallelGroup(Alignment.LEADING).addGap(0, 45, Short.MAX_VALUE)
				.addComponent(jLabel28, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE));
		jPanel44.setLayout(gl_jPanel44);

		JPanel jPanel29 = new JPanel();
		jPanel29.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jp_jan_devendo.add(jPanel29);
		jPanel29.setLayout(new GridLayout(1, 0));

		JPanel jPanel45 = new JPanel();
		jPanel45.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel45.setBackground(Color.WHITE);
		jPanel29.add(jPanel45);

		JLabel jLabel42 = new JLabel();
		jLabel42.setText("Posto");
		jLabel42.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabel42.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel45 = new GroupLayout(jPanel45);
		gl_jPanel45.setHorizontalGroup(gl_jPanel45.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 70, Short.MAX_VALUE).addGroup(gl_jPanel45.createSequentialGroup().addContainerGap()
						.addComponent(jLabel42, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE).addContainerGap()));
		gl_jPanel45.setVerticalGroup(gl_jPanel45.createParallelGroup(Alignment.LEADING).addGap(0, 45, Short.MAX_VALUE)
				.addComponent(jLabel42, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE));
		jPanel45.setLayout(gl_jPanel45);

		JPanel jPanel46 = new JPanel();
		jPanel46.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel46.setBackground(Color.WHITE);
		jPanel29.add(jPanel46);

		lb_jan_post_div = new JLabel();
		lb_jan_post_div.setText("0");
		lb_jan_post_div.setHorizontalTextPosition(SwingConstants.CENTER);
		lb_jan_post_div.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel46 = new GroupLayout(jPanel46);
		gl_jPanel46
				.setHorizontalGroup(gl_jPanel46.createParallelGroup(Alignment.TRAILING).addGap(0, 70, Short.MAX_VALUE)
						.addGroup(gl_jPanel46.createSequentialGroup()
								.addComponent(lb_jan_post_div, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
								.addContainerGap()));
		gl_jPanel46.setVerticalGroup(gl_jPanel46.createParallelGroup(Alignment.LEADING).addGap(0, 45, Short.MAX_VALUE)
				.addComponent(lb_jan_post_div, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE));
		jPanel46.setLayout(gl_jPanel46);

		JPanel jPanel47 = new JPanel();
		jPanel47.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel47.setBackground(Color.WHITE);
		jPanel29.add(jPanel47);

		lb_fev_posto_div = new JLabel();
		lb_fev_posto_div.setText("0");
		lb_fev_posto_div.setHorizontalTextPosition(SwingConstants.CENTER);
		lb_fev_posto_div.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel47 = new GroupLayout(jPanel47);
		gl_jPanel47
				.setHorizontalGroup(gl_jPanel47.createParallelGroup(Alignment.TRAILING).addGap(0, 70, Short.MAX_VALUE)
						.addGroup(gl_jPanel47.createSequentialGroup()
								.addComponent(lb_fev_posto_div, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
								.addContainerGap()));
		gl_jPanel47.setVerticalGroup(gl_jPanel47.createParallelGroup(Alignment.LEADING).addGap(0, 45, Short.MAX_VALUE)
				.addComponent(lb_fev_posto_div, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE));
		jPanel47.setLayout(gl_jPanel47);

		JPanel jPanel48 = new JPanel();
		jPanel48.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel48.setBackground(Color.WHITE);
		jPanel29.add(jPanel48);

		lb_mar_posto_div = new JLabel();
		lb_mar_posto_div.setText("0");
		lb_mar_posto_div.setHorizontalTextPosition(SwingConstants.CENTER);
		lb_mar_posto_div.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel48 = new GroupLayout(jPanel48);
		gl_jPanel48
				.setHorizontalGroup(gl_jPanel48.createParallelGroup(Alignment.TRAILING).addGap(0, 70, Short.MAX_VALUE)
						.addGroup(gl_jPanel48.createSequentialGroup()
								.addComponent(lb_mar_posto_div, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
								.addContainerGap()));
		gl_jPanel48.setVerticalGroup(gl_jPanel48.createParallelGroup(Alignment.LEADING).addGap(0, 45, Short.MAX_VALUE)
				.addComponent(lb_mar_posto_div, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE));
		jPanel48.setLayout(gl_jPanel48);

		JPanel jPanel49 = new JPanel();
		jPanel49.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel49.setBackground(Color.WHITE);
		jPanel29.add(jPanel49);

		lb_abr_posto_div = new JLabel();
		lb_abr_posto_div.setText("0");
		lb_abr_posto_div.setHorizontalTextPosition(SwingConstants.CENTER);
		lb_abr_posto_div.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel49 = new GroupLayout(jPanel49);
		gl_jPanel49
				.setHorizontalGroup(gl_jPanel49.createParallelGroup(Alignment.TRAILING).addGap(0, 70, Short.MAX_VALUE)
						.addGroup(gl_jPanel49.createSequentialGroup()
								.addComponent(lb_abr_posto_div, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
								.addContainerGap()));
		gl_jPanel49.setVerticalGroup(gl_jPanel49.createParallelGroup(Alignment.LEADING).addGap(0, 45, Short.MAX_VALUE)
				.addComponent(lb_abr_posto_div, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE));
		jPanel49.setLayout(gl_jPanel49);

		JPanel jPanel50 = new JPanel();
		jPanel50.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel50.setBackground(Color.WHITE);
		jPanel29.add(jPanel50);

		lb_mai_posto_div = new JLabel();
		lb_mai_posto_div.setText("0");
		lb_mai_posto_div.setHorizontalTextPosition(SwingConstants.CENTER);
		lb_mai_posto_div.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel50 = new GroupLayout(jPanel50);
		gl_jPanel50
				.setHorizontalGroup(gl_jPanel50.createParallelGroup(Alignment.TRAILING).addGap(0, 70, Short.MAX_VALUE)
						.addGroup(gl_jPanel50.createSequentialGroup()
								.addComponent(lb_mai_posto_div, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
								.addContainerGap()));
		gl_jPanel50.setVerticalGroup(gl_jPanel50.createParallelGroup(Alignment.LEADING).addGap(0, 45, Short.MAX_VALUE)
				.addComponent(lb_mai_posto_div, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE));
		jPanel50.setLayout(gl_jPanel50);

		JPanel jPanel51 = new JPanel();
		jPanel51.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel51.setBackground(Color.WHITE);
		jPanel29.add(jPanel51);

		lb_jun_posto_div = new JLabel();
		lb_jun_posto_div.setText("0");
		lb_jun_posto_div.setHorizontalTextPosition(SwingConstants.CENTER);
		lb_jun_posto_div.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel51 = new GroupLayout(jPanel51);
		gl_jPanel51
				.setHorizontalGroup(gl_jPanel51.createParallelGroup(Alignment.TRAILING).addGap(0, 70, Short.MAX_VALUE)
						.addGroup(gl_jPanel51.createSequentialGroup()
								.addComponent(lb_jun_posto_div, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
								.addContainerGap()));
		gl_jPanel51.setVerticalGroup(gl_jPanel51.createParallelGroup(Alignment.LEADING).addGap(0, 45, Short.MAX_VALUE)
				.addComponent(lb_jun_posto_div, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE));
		jPanel51.setLayout(gl_jPanel51);

		JPanel jPanel52 = new JPanel();
		jPanel52.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel52.setBackground(Color.WHITE);
		jPanel29.add(jPanel52);

		lb_jul_posto_div = new JLabel();
		lb_jul_posto_div.setText("0");
		lb_jul_posto_div.setHorizontalTextPosition(SwingConstants.CENTER);
		lb_jul_posto_div.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel52 = new GroupLayout(jPanel52);
		gl_jPanel52
				.setHorizontalGroup(gl_jPanel52.createParallelGroup(Alignment.TRAILING).addGap(0, 70, Short.MAX_VALUE)
						.addGroup(gl_jPanel52.createSequentialGroup()
								.addComponent(lb_jul_posto_div, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
								.addContainerGap()));
		gl_jPanel52.setVerticalGroup(gl_jPanel52.createParallelGroup(Alignment.LEADING).addGap(0, 45, Short.MAX_VALUE)
				.addComponent(lb_jul_posto_div, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE));
		jPanel52.setLayout(gl_jPanel52);

		JPanel jPanel53 = new JPanel();
		jPanel53.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel53.setBackground(Color.WHITE);
		jPanel29.add(jPanel53);

		lb_ago_posto_div = new JLabel();
		lb_ago_posto_div.setText("0");
		lb_ago_posto_div.setHorizontalTextPosition(SwingConstants.CENTER);
		lb_ago_posto_div.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel53 = new GroupLayout(jPanel53);
		gl_jPanel53.setHorizontalGroup(gl_jPanel53.createParallelGroup(Alignment.LEADING).addGap(0, 70, Short.MAX_VALUE)
				.addGroup(gl_jPanel53.createSequentialGroup().addGap(0)
						.addComponent(lb_ago_posto_div, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
						.addContainerGap()));
		gl_jPanel53.setVerticalGroup(gl_jPanel53.createParallelGroup(Alignment.LEADING).addGap(0, 45, Short.MAX_VALUE)
				.addComponent(lb_ago_posto_div, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE));
		jPanel53.setLayout(gl_jPanel53);

		JPanel jPanel54 = new JPanel();
		jPanel54.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel54.setBackground(Color.WHITE);
		jPanel29.add(jPanel54);

		lb_set_posto_div = new JLabel();
		lb_set_posto_div.setText("0");
		lb_set_posto_div.setHorizontalTextPosition(SwingConstants.CENTER);
		lb_set_posto_div.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel54 = new GroupLayout(jPanel54);
		gl_jPanel54
				.setHorizontalGroup(gl_jPanel54.createParallelGroup(Alignment.TRAILING).addGap(0, 70, Short.MAX_VALUE)
						.addGroup(gl_jPanel54.createSequentialGroup()
								.addComponent(lb_set_posto_div, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
								.addContainerGap()));
		gl_jPanel54.setVerticalGroup(gl_jPanel54.createParallelGroup(Alignment.LEADING).addGap(0, 45, Short.MAX_VALUE)
				.addComponent(lb_set_posto_div, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE));
		jPanel54.setLayout(gl_jPanel54);

		JPanel jPanel55 = new JPanel();
		jPanel55.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel55.setBackground(Color.WHITE);
		jPanel29.add(jPanel55);

		lb_out_posto_div = new JLabel();
		lb_out_posto_div.setText("0");
		lb_out_posto_div.setHorizontalTextPosition(SwingConstants.CENTER);
		lb_out_posto_div.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel55 = new GroupLayout(jPanel55);
		gl_jPanel55
				.setHorizontalGroup(gl_jPanel55.createParallelGroup(Alignment.TRAILING).addGap(0, 70, Short.MAX_VALUE)
						.addGroup(gl_jPanel55.createSequentialGroup()
								.addComponent(lb_out_posto_div, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
								.addContainerGap()));
		gl_jPanel55.setVerticalGroup(gl_jPanel55.createParallelGroup(Alignment.LEADING).addGap(0, 45, Short.MAX_VALUE)
				.addComponent(lb_out_posto_div, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE));
		jPanel55.setLayout(gl_jPanel55);

		JPanel jPanel56 = new JPanel();
		jPanel56.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel56.setBackground(Color.WHITE);
		jPanel29.add(jPanel56);

		lb_nov_posto_div = new JLabel();
		lb_nov_posto_div.setText("0");
		lb_nov_posto_div.setHorizontalTextPosition(SwingConstants.CENTER);
		lb_nov_posto_div.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel56 = new GroupLayout(jPanel56);
		gl_jPanel56
				.setHorizontalGroup(gl_jPanel56.createParallelGroup(Alignment.TRAILING).addGap(0, 70, Short.MAX_VALUE)
						.addGroup(gl_jPanel56.createSequentialGroup()
								.addComponent(lb_nov_posto_div, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
								.addContainerGap()));
		gl_jPanel56.setVerticalGroup(gl_jPanel56.createParallelGroup(Alignment.LEADING).addGap(0, 45, Short.MAX_VALUE)
				.addComponent(lb_nov_posto_div, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE));
		jPanel56.setLayout(gl_jPanel56);

		JPanel jPanel57 = new JPanel();
		jPanel57.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel57.setBackground(Color.WHITE);
		jPanel29.add(jPanel57);

		lb_dez_posto_div = new JLabel();
		lb_dez_posto_div.setText("0");
		lb_dez_posto_div.setHorizontalTextPosition(SwingConstants.CENTER);
		lb_dez_posto_div.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel57 = new GroupLayout(jPanel57);
		gl_jPanel57
				.setHorizontalGroup(gl_jPanel57.createParallelGroup(Alignment.TRAILING).addGap(0, 70, Short.MAX_VALUE)
						.addGroup(gl_jPanel57.createSequentialGroup()
								.addComponent(lb_dez_posto_div, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
								.addContainerGap()));
		gl_jPanel57.setVerticalGroup(gl_jPanel57.createParallelGroup(Alignment.LEADING).addGap(0, 45, Short.MAX_VALUE)
				.addComponent(lb_dez_posto_div, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE));
		jPanel57.setLayout(gl_jPanel57);

		JPanel jPanel58 = new JPanel();
		jPanel58.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel58.setBackground(Color.WHITE);
		jPanel29.add(jPanel58);

		lb_total_posto_div = new JLabel();
		lb_total_posto_div.setText("0");
		lb_total_posto_div.setHorizontalTextPosition(SwingConstants.CENTER);
		lb_total_posto_div.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel58 = new GroupLayout(jPanel58);
		gl_jPanel58
				.setHorizontalGroup(gl_jPanel58.createParallelGroup(Alignment.TRAILING).addGap(0, 70, Short.MAX_VALUE)
						.addGroup(gl_jPanel58.createSequentialGroup()
								.addComponent(lb_total_posto_div, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
								.addContainerGap()));
		gl_jPanel58.setVerticalGroup(gl_jPanel58.createParallelGroup(Alignment.LEADING).addGap(0, 45, Short.MAX_VALUE)
				.addComponent(lb_total_posto_div, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE));
		jPanel58.setLayout(gl_jPanel58);

		JPanel jPanel30 = new JPanel();
		jPanel30.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jp_jan_devendo.add(jPanel30);
		jPanel30.setLayout(new GridLayout(1, 0));

		JPanel jPanel59 = new JPanel();
		jPanel59.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel59.setBackground(Color.WHITE);
		jPanel30.add(jPanel59);

		JLabel jLabel43 = new JLabel();
		jLabel43.setText("Horas");
		jLabel43.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabel43.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel59 = new GroupLayout(jPanel59);
		gl_jPanel59.setHorizontalGroup(gl_jPanel59.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 70, Short.MAX_VALUE).addGroup(gl_jPanel59.createSequentialGroup().addContainerGap()
						.addComponent(jLabel43, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE).addContainerGap()));
		gl_jPanel59.setVerticalGroup(gl_jPanel59.createParallelGroup(Alignment.LEADING).addGap(0, 45, Short.MAX_VALUE)
				.addComponent(jLabel43, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE));
		jPanel59.setLayout(gl_jPanel59);

		JPanel jPanel60 = new JPanel();
		jPanel60.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel60.setBackground(Color.WHITE);
		jPanel30.add(jPanel60);

		lb_jan_horas_div = new JLabel();
		lb_jan_horas_div.setText("00:00");
		lb_jan_horas_div.setHorizontalTextPosition(SwingConstants.CENTER);
		lb_jan_horas_div.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel60 = new GroupLayout(jPanel60);
		gl_jPanel60
				.setHorizontalGroup(gl_jPanel60.createParallelGroup(Alignment.TRAILING).addGap(0, 70, Short.MAX_VALUE)
						.addGroup(gl_jPanel60.createSequentialGroup()
								.addComponent(lb_jan_horas_div, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
								.addContainerGap()));
		gl_jPanel60.setVerticalGroup(gl_jPanel60.createParallelGroup(Alignment.LEADING).addGap(0, 45, Short.MAX_VALUE)
				.addComponent(lb_jan_horas_div, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE));
		jPanel60.setLayout(gl_jPanel60);

		JPanel jPanel61 = new JPanel();
		jPanel61.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel61.setBackground(Color.WHITE);
		jPanel30.add(jPanel61);

		lb_fev_horas_div = new JLabel();
		lb_fev_horas_div.setText("00:00");
		lb_fev_horas_div.setHorizontalTextPosition(SwingConstants.CENTER);
		lb_fev_horas_div.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel61 = new GroupLayout(jPanel61);
		gl_jPanel61
				.setHorizontalGroup(gl_jPanel61.createParallelGroup(Alignment.TRAILING).addGap(0, 70, Short.MAX_VALUE)
						.addGroup(gl_jPanel61.createSequentialGroup()
								.addComponent(lb_fev_horas_div, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
								.addContainerGap()));
		gl_jPanel61.setVerticalGroup(gl_jPanel61.createParallelGroup(Alignment.LEADING).addGap(0, 45, Short.MAX_VALUE)
				.addComponent(lb_fev_horas_div, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE));
		jPanel61.setLayout(gl_jPanel61);

		JPanel jPanel62 = new JPanel();
		jPanel62.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel62.setBackground(Color.WHITE);
		jPanel30.add(jPanel62);

		lb_mar_horas_div = new JLabel();
		lb_mar_horas_div.setText("00:00");
		lb_mar_horas_div.setHorizontalTextPosition(SwingConstants.CENTER);
		lb_mar_horas_div.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel62 = new GroupLayout(jPanel62);
		gl_jPanel62
				.setHorizontalGroup(gl_jPanel62.createParallelGroup(Alignment.TRAILING).addGap(0, 70, Short.MAX_VALUE)
						.addGroup(gl_jPanel62.createSequentialGroup()
								.addComponent(lb_mar_horas_div, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
								.addContainerGap()));
		gl_jPanel62.setVerticalGroup(gl_jPanel62.createParallelGroup(Alignment.LEADING).addGap(0, 45, Short.MAX_VALUE)
				.addComponent(lb_mar_horas_div, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE));
		jPanel62.setLayout(gl_jPanel62);

		JPanel jPanel63 = new JPanel();
		jPanel63.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel63.setBackground(Color.WHITE);
		jPanel30.add(jPanel63);

		lb_abr_horas_div = new JLabel();
		lb_abr_horas_div.setText("00:00");
		lb_abr_horas_div.setHorizontalTextPosition(SwingConstants.CENTER);
		lb_abr_horas_div.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel63 = new GroupLayout(jPanel63);
		gl_jPanel63
				.setHorizontalGroup(gl_jPanel63.createParallelGroup(Alignment.TRAILING).addGap(0, 70, Short.MAX_VALUE)
						.addGroup(gl_jPanel63.createSequentialGroup()
								.addComponent(lb_abr_horas_div, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
								.addContainerGap()));
		gl_jPanel63.setVerticalGroup(gl_jPanel63.createParallelGroup(Alignment.LEADING).addGap(0, 45, Short.MAX_VALUE)
				.addComponent(lb_abr_horas_div, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE));
		jPanel63.setLayout(gl_jPanel63);

		JPanel jPanel64 = new JPanel();
		jPanel64.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel64.setBackground(Color.WHITE);
		jPanel30.add(jPanel64);

		lb_mai_horas_div = new JLabel();
		lb_mai_horas_div.setText("00:00");
		lb_mai_horas_div.setHorizontalTextPosition(SwingConstants.CENTER);
		lb_mai_horas_div.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel64 = new GroupLayout(jPanel64);
		gl_jPanel64
				.setHorizontalGroup(gl_jPanel64.createParallelGroup(Alignment.TRAILING).addGap(0, 70, Short.MAX_VALUE)
						.addGroup(gl_jPanel64.createSequentialGroup()
								.addComponent(lb_mai_horas_div, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
								.addContainerGap()));
		gl_jPanel64.setVerticalGroup(gl_jPanel64.createParallelGroup(Alignment.LEADING).addGap(0, 45, Short.MAX_VALUE)
				.addComponent(lb_mai_horas_div, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE));
		jPanel64.setLayout(gl_jPanel64);

		JPanel jPanel65 = new JPanel();
		jPanel65.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel65.setBackground(Color.WHITE);
		jPanel30.add(jPanel65);

		lb_jun_horas_div = new JLabel();
		lb_jun_horas_div.setText("00:00");
		lb_jun_horas_div.setHorizontalTextPosition(SwingConstants.CENTER);
		lb_jun_horas_div.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel65 = new GroupLayout(jPanel65);
		gl_jPanel65
				.setHorizontalGroup(gl_jPanel65.createParallelGroup(Alignment.TRAILING).addGap(0, 70, Short.MAX_VALUE)
						.addGroup(gl_jPanel65.createSequentialGroup()
								.addComponent(lb_jun_horas_div, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
								.addContainerGap()));
		gl_jPanel65.setVerticalGroup(gl_jPanel65.createParallelGroup(Alignment.LEADING).addGap(0, 45, Short.MAX_VALUE)
				.addComponent(lb_jun_horas_div, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE));
		jPanel65.setLayout(gl_jPanel65);

		JPanel jPanel66 = new JPanel();
		jPanel66.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel66.setBackground(Color.WHITE);
		jPanel30.add(jPanel66);

		lb_jul_horas_div = new JLabel();
		lb_jul_horas_div.setText("00:00");
		lb_jul_horas_div.setHorizontalTextPosition(SwingConstants.CENTER);
		lb_jul_horas_div.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel66 = new GroupLayout(jPanel66);
		gl_jPanel66
				.setHorizontalGroup(gl_jPanel66.createParallelGroup(Alignment.TRAILING).addGap(0, 70, Short.MAX_VALUE)
						.addGroup(gl_jPanel66.createSequentialGroup()
								.addComponent(lb_jul_horas_div, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
								.addContainerGap()));
		gl_jPanel66.setVerticalGroup(gl_jPanel66.createParallelGroup(Alignment.LEADING).addGap(0, 45, Short.MAX_VALUE)
				.addComponent(lb_jul_horas_div, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE));
		jPanel66.setLayout(gl_jPanel66);

		JPanel jPanel67 = new JPanel();
		jPanel67.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel67.setBackground(Color.WHITE);
		jPanel30.add(jPanel67);

		lb_ago_horas_div = new JLabel();
		lb_ago_horas_div.setText("00:00");
		lb_ago_horas_div.setHorizontalTextPosition(SwingConstants.CENTER);
		lb_ago_horas_div.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel67 = new GroupLayout(jPanel67);
		gl_jPanel67
				.setHorizontalGroup(gl_jPanel67.createParallelGroup(Alignment.TRAILING).addGap(0, 70, Short.MAX_VALUE)
						.addGroup(gl_jPanel67.createSequentialGroup()
								.addComponent(lb_ago_horas_div, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
								.addContainerGap()));
		gl_jPanel67.setVerticalGroup(gl_jPanel67.createParallelGroup(Alignment.LEADING).addGap(0, 45, Short.MAX_VALUE)
				.addComponent(lb_ago_horas_div, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE));
		jPanel67.setLayout(gl_jPanel67);

		JPanel jPanel68 = new JPanel();
		jPanel68.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel68.setBackground(Color.WHITE);
		jPanel30.add(jPanel68);

		lb_set_horas_div = new JLabel();
		lb_set_horas_div.setText("00:00");
		lb_set_horas_div.setHorizontalTextPosition(SwingConstants.CENTER);
		lb_set_horas_div.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel68 = new GroupLayout(jPanel68);
		gl_jPanel68
				.setHorizontalGroup(gl_jPanel68.createParallelGroup(Alignment.TRAILING).addGap(0, 70, Short.MAX_VALUE)
						.addGroup(gl_jPanel68.createSequentialGroup()
								.addComponent(lb_set_horas_div, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
								.addContainerGap()));
		gl_jPanel68.setVerticalGroup(gl_jPanel68.createParallelGroup(Alignment.LEADING).addGap(0, 45, Short.MAX_VALUE)
				.addComponent(lb_set_horas_div, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE));
		jPanel68.setLayout(gl_jPanel68);

		JPanel jPanel69 = new JPanel();
		jPanel69.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel69.setBackground(Color.WHITE);
		jPanel30.add(jPanel69);

		lb_out_horas_div = new JLabel();
		lb_out_horas_div.setText("00:00");
		lb_out_horas_div.setHorizontalTextPosition(SwingConstants.CENTER);
		lb_out_horas_div.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel69 = new GroupLayout(jPanel69);
		gl_jPanel69
				.setHorizontalGroup(gl_jPanel69.createParallelGroup(Alignment.TRAILING).addGap(0, 70, Short.MAX_VALUE)
						.addGroup(gl_jPanel69.createSequentialGroup()
								.addComponent(lb_out_horas_div, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
								.addContainerGap()));
		gl_jPanel69.setVerticalGroup(gl_jPanel69.createParallelGroup(Alignment.LEADING).addGap(0, 45, Short.MAX_VALUE)
				.addComponent(lb_out_horas_div, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE));
		jPanel69.setLayout(gl_jPanel69);

		JPanel jPanel70 = new JPanel();
		jPanel70.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel70.setBackground(Color.WHITE);
		jPanel30.add(jPanel70);

		lb_nov_horas_div = new JLabel();
		lb_nov_horas_div.setText("00:00");
		lb_nov_horas_div.setHorizontalTextPosition(SwingConstants.CENTER);
		lb_nov_horas_div.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel70 = new GroupLayout(jPanel70);
		gl_jPanel70
				.setHorizontalGroup(gl_jPanel70.createParallelGroup(Alignment.TRAILING).addGap(0, 70, Short.MAX_VALUE)
						.addGroup(gl_jPanel70.createSequentialGroup()
								.addComponent(lb_nov_horas_div, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
								.addContainerGap()));
		gl_jPanel70.setVerticalGroup(gl_jPanel70.createParallelGroup(Alignment.LEADING).addGap(0, 45, Short.MAX_VALUE)
				.addComponent(lb_nov_horas_div, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE));
		jPanel70.setLayout(gl_jPanel70);

		JPanel jPanel71 = new JPanel();
		jPanel71.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel71.setBackground(Color.WHITE);
		jPanel30.add(jPanel71);

		lb_dez_horas_div = new JLabel();
		lb_dez_horas_div.setText("00:00");
		lb_dez_horas_div.setHorizontalTextPosition(SwingConstants.CENTER);
		lb_dez_horas_div.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel71 = new GroupLayout(jPanel71);
		gl_jPanel71
				.setHorizontalGroup(gl_jPanel71.createParallelGroup(Alignment.TRAILING).addGap(0, 70, Short.MAX_VALUE)
						.addGroup(gl_jPanel71.createSequentialGroup()
								.addComponent(lb_dez_horas_div, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
								.addContainerGap()));
		gl_jPanel71.setVerticalGroup(gl_jPanel71.createParallelGroup(Alignment.LEADING).addGap(0, 45, Short.MAX_VALUE)
				.addComponent(lb_dez_horas_div, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE));
		jPanel71.setLayout(gl_jPanel71);

		JPanel jPanel72 = new JPanel();
		jPanel72.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel72.setBackground(Color.WHITE);
		jPanel30.add(jPanel72);

		lb_total_horas_div = new JLabel();
		lb_total_horas_div.setText("00:00");
		lb_total_horas_div.setHorizontalTextPosition(SwingConstants.CENTER);
		lb_total_horas_div.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanel72 = new GroupLayout(jPanel72);
		gl_jPanel72
				.setHorizontalGroup(gl_jPanel72.createParallelGroup(Alignment.TRAILING).addGap(0, 70, Short.MAX_VALUE)
						.addGroup(gl_jPanel72.createSequentialGroup()
								.addComponent(lb_total_horas_div, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
								.addContainerGap()));
		gl_jPanel72.setVerticalGroup(gl_jPanel72.createParallelGroup(Alignment.LEADING).addGap(0, 45, Short.MAX_VALUE)
				.addComponent(lb_total_horas_div, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE));
		jPanel72.setLayout(gl_jPanel72);
		GroupLayout gl_jPanel18 = new GroupLayout(jPanel18);
		gl_jPanel18
				.setHorizontalGroup(gl_jPanel18.createParallelGroup(Alignment.LEADING).addGap(0, 1007, Short.MAX_VALUE)
						.addGroup(gl_jPanel18.createSequentialGroup()
								.addComponent(jPanel20, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGap(0, 967, Short.MAX_VALUE))
						.addGroup(gl_jPanel18.createSequentialGroup().addContainerGap()
								.addComponent(jp_jan_devendo, GroupLayout.DEFAULT_SIZE, 1016, Short.MAX_VALUE)
								.addContainerGap()));
		gl_jPanel18.setVerticalGroup(gl_jPanel18.createParallelGroup(Alignment.LEADING).addGap(0, 165, Short.MAX_VALUE)
				.addGroup(gl_jPanel18.createSequentialGroup()
						.addComponent(jPanel20, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(jp_jan_devendo, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		jPanel18.setLayout(gl_jPanel18);
		GroupLayout gl_jPanel16 = new GroupLayout(jPanel16);
		gl_jPanel16
				.setHorizontalGroup(gl_jPanel16.createParallelGroup(Alignment.LEADING).addGap(0, 1007, Short.MAX_VALUE)
						.addComponent(jPanel17, GroupLayout.DEFAULT_SIZE, 1040, Short.MAX_VALUE)
						.addComponent(jPanel19, GroupLayout.DEFAULT_SIZE, 1040, Short.MAX_VALUE)
						.addComponent(jPanel18, GroupLayout.DEFAULT_SIZE, 1040, Short.MAX_VALUE));
		gl_jPanel16
				.setVerticalGroup(
						gl_jPanel16.createParallelGroup(Alignment.LEADING).addGap(0, 392, Short.MAX_VALUE)
								.addGroup(
										gl_jPanel16.createSequentialGroup()
												.addComponent(jPanel17, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(jPanel18, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(jPanel19, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		jPanel16.setLayout(gl_jPanel16);
		

		carregarPessoas();
		carregarPlanilha(u);
		carregarPlanilha2(u);
	}

	private void carregarPessoas() {
		lNomes = new TreeSet<String>();
		if (pessoas.size() != 0) {
			System.out.println(pessoas.size());
			pessoas = new ServiceClient().ConsultarTodasPessoas();
			for (Pessoa pessoa1 : pessoas) {
				lNomes.add(pessoa1.getNome());
			}
		} else {
			pessoas = new ServiceClient().ConsultarTodasPessoas();
			for (Pessoa pessoa1 : pessoas) {
				lNomes.add(pessoa1.getNome());
			}
		}
	}

	private void txt_data_controleKeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txt_data_controleKeyPressed
		if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
			txt_hora_controle.requestFocus();
		}
	}

	private void txt_nome_controleKeyRealesse(java.awt.event.KeyEvent evt) {

		if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getKeyCode() == KeyEvent.VK_DELETE) {

		} else {

			String to_check = txt_nome_controle.getText();
			int to_check_length = to_check.length();
			for (String data : lNomes) {
				String check_from_data = "";
				for (int i = 0; i < to_check_length; i++) {
					if (to_check_length <= data.length()) {
						check_from_data = check_from_data + data.charAt(i);
					}
				}
				if (check_from_data.equals(to_check)) {
					txt_nome_controle.setText(data);
					txt_nome_controle.setSelectionStart(to_check_length);
					txt_nome_controle.setSelectionEnd(data.length());
					break;
				}
			}
		}
	}

	protected void registrarControle(int i) {
		Colaborador colaborador = new Colaborador();
		colaborador.setNome(txt_nome_controle.getText().toString());
		colaborador.setData(new DataUtil().convertData(txt_data_controle.getText().toString()));
		colaborador.setTerceirizada(u);

		if (rb_atraso.isSelected()) {
			colaborador.setTipo(2);
			colaborador.setHoras(Integer.parseInt(txt_hora_controle.getText().toString()));
			colaborador.setMinutos(Integer.parseInt(txt_minuto_controle.getText().toString()));
		} else if (rb_outros.isSelected()) {
			colaborador.setTipo(3);
			colaborador.setHoras(Integer.parseInt(txt_hora_controle.getText().toString()));
			colaborador.setMinutos(Integer.parseInt(txt_minuto_controle.getText().toString()));
		} else {
			colaborador.setTipo(1);
		}
		if (i == 1) {
			mensagensJD = new MensagensJD2(new ServiceClient().CadastrarControleFaltasAtrasosViglante(colaborador),
					"Controle");
			carregarPlanilha(1);
			carregarPlanilha2(1);
			limparControle();
			mensagensJD.setVisible(true);
		} else {
			mensagensJD = new MensagensJD2(new ServiceClient().CadastrarControleFaltasAtrasosViglante(colaborador),
					"Controle");
			carregarPlanilha(2);
			carregarPlanilha2(2);
			limparControle();
			mensagensJD.setVisible(true);
		}

	}

	private void limparControle() {
		txt_nome_controle.setText("");
		txt_data_controle.setText("");
		selectTipoControle();

	}

	/**
	 * Seleciona ou impede que caixas de textos sejam preenchidas
	 */
	protected void selectTipoControle() {
		if (rb_atraso.isSelected()) {
			txt_hora_controle.setEnabled(true);
			txt_minuto_controle.setEnabled(true);
			limparTextTheSelectionControl();
		} else if (rb_falta.isSelected()) {
			txt_hora_controle.setEnabled(false);
			txt_minuto_controle.setEnabled(false);
			limparTextTheSelectionControl();
		} else if (rb_outros.isSelected()) {
			txt_hora_controle.setEnabled(true);
			txt_minuto_controle.setEnabled(true);
			limparTextTheSelectionControl();
		}
	}

	private void limparTextTheSelectionControl() {
		txt_hora_controle.setText("");
		txt_minuto_controle.setText("");
	}

	private void carregarPlanilha2(int j) {
		/**
		 * Limpa as celulas cempre que for modificado o alvo do menu
		 */
		lb_jan_posto_pg.setText("0");
		lb_jan_horas_pg.setText("00:00");
		lb_fev_posto_pg.setText("0");
		lb_fev_horas_pg.setText("00:00");
		lb_mar_posto_pg.setText("0");
		lb_mar_horas_pg.setText("00:00");
		lb_abr_posto_pg.setText("0");
		lb_abr_horas_pg.setText("00:00");
		lb_mai_posto_pg.setText("0");
		lb_mai_horas_pg.setText("00:00");
		lb_jun_posto_pg.setText("0");
		lb_jun_horas_pg.setText("00:00");
		lb_jul_posto_pg.setText("0");
		lb_jul_horas_pg.setText("00:00");
		lb_ago_posto_pg.setText("0");
		lb_ago_horas_pg.setText("00:00");
		lb_set_posto_pg.setText("0");
		lb_set_horas_pg.setText("00:00");
		lb_out_posto_pg.setText("0");
		lb_out_horas_pg.setText("00:00");
		lb_nov_posto_pg.setText("0");
		lb_nov_horas_pg.setText("00:00");
		lb_dez_posto_pg.setText("0");
		lb_dez_horas_pg.setText("00:00");
		somaFaltasPg = 0;
		somaHorasPG = 0;

		controles2 = new ServiceClient().getPlanilha2(j);

		for (Controler planilha : controles2) {
			/**
			 * Soma vindo do banco
			 */
			somaFaltasPg += planilha.getQtd_faltas();
			Controler cont_aux = new FucoesUtil().setControle(planilha);
			somaHorasPG += cont_aux.getHoras();
			somaMinutosPG += cont_aux.getMinutos();

			switch (planilha.getMes()) {
			case 1:
				lb_jan_posto_pg.setText(String.valueOf(planilha.getQtd_faltas()));
				lb_jan_horas_pg.setText(String.valueOf(planilha.getHoras() + ":" + planilha.getMinutos()));
				break;
			case 2:
				lb_fev_posto_pg.setText(String.valueOf(planilha.getQtd_faltas()));
				lb_fev_horas_pg.setText(String.valueOf(planilha.getHoras() + ":" + planilha.getMinutos()));
				break;
			case 3:
				lb_mar_posto_pg.setText(String.valueOf(planilha.getQtd_faltas()));
				lb_mar_horas_pg.setText(String.valueOf(planilha.getHoras() + ":" + planilha.getMinutos()));
				break;
			case 4:
				lb_abr_posto_pg.setText(String.valueOf(planilha.getQtd_faltas()));
				lb_abr_horas_pg.setText(String.valueOf(planilha.getHoras() + ":" + planilha.getMinutos()));
				break;
			case 5:
				lb_mai_posto_pg.setText(String.valueOf(planilha.getQtd_faltas()));
				lb_mai_horas_pg.setText(String.valueOf(planilha.getHoras() + ":" + planilha.getMinutos()));
				break;
			case 6:
				lb_jun_posto_pg.setText(String.valueOf(planilha.getQtd_faltas()));
				lb_jun_horas_pg.setText(String.valueOf(planilha.getHoras() + ":" + planilha.getMinutos()));
				break;
			case 7:
				lb_jul_posto_pg.setText(String.valueOf(planilha.getQtd_faltas()));
				lb_jul_horas_pg.setText(String.valueOf(planilha.getHoras() + ":" + planilha.getMinutos()));
				break;
			case 8:
				lb_ago_posto_pg.setText(String.valueOf(planilha.getQtd_faltas()));
				lb_ago_horas_pg.setText(String.valueOf(planilha.getHoras() + ":" + planilha.getMinutos()));
				break;
			case 9:
				lb_set_posto_pg.setText(String.valueOf(planilha.getQtd_faltas()));
				lb_set_horas_pg.setText(String.valueOf(planilha.getHoras() + ":" + planilha.getMinutos()));
				break;
			case 10:
				lb_out_posto_pg.setText(String.valueOf(planilha.getQtd_faltas()));
				lb_out_horas_pg.setText(String.valueOf(planilha.getHoras() + ":" + planilha.getMinutos()));
				break;
			case 11:
				lb_nov_posto_pg.setText(String.valueOf(planilha.getQtd_faltas()));
				lb_nov_horas_pg.setText(String.valueOf(planilha.getHoras() + ":" + planilha.getMinutos()));
				break;
			case 12:
				lb_dez_posto_pg.setText(String.valueOf(planilha.getQtd_faltas()));
				lb_dez_horas_pg.setText(String.valueOf(planilha.getHoras() + ":" + planilha.getMinutos()));
				break;
			default:
				break;
			}
		}

		lbl_falta_repor_posto.setText(String.valueOf(somaFaltas - somaFaltasPg));
		int aux = somaMinutos - somaMinutosPG;
		lbl_falta_repor_horas.setText(String.valueOf((somaHoras - somaHorasPG) + ":" + aux));
		
		
		lb_total_horas_pg.setText(String.valueOf(somaHorasPG + ":" + somaMinutosPG));
		lb_total_posto_pg.setText(String.valueOf(somaFaltasPg));

		pessoas = new ServiceClient().ConsultarTodasPessoas();
		for (Pessoa pessoa1 : pessoas) {
			lNomes.add(pessoa1.getNome());
		}

	}

	private void carregarPlanilha(int i) {
		/**
		 * Limpa as celulas cempre que for modificado o alvo do menu
		 */
		lb_jan_post_div.setText("0");
		lb_jan_horas_div.setText("00:00");
		lb_fev_posto_div.setText("0");
		lb_fev_horas_div.setText("00:00");
		lb_mar_posto_div.setText("0");
		lb_mar_horas_div.setText("00:00");
		lb_abr_posto_div.setText("0");
		lb_abr_horas_div.setText("00:00");
		lb_mai_posto_div.setText("0");
		lb_mai_horas_div.setText("00:00");
		lb_jun_posto_div.setText("0");
		lb_jun_horas_div.setText("00:00");
		lb_jul_posto_div.setText("0");
		lb_jul_horas_div.setText("00:00");
		lb_ago_posto_div.setText("0");
		lb_ago_horas_div.setText("00:00");
		lb_set_posto_div.setText("0");
		lb_set_horas_div.setText("00:00");
		lb_out_posto_div.setText("0");
		lb_out_horas_div.setText("00:00");
		lb_nov_posto_div.setText("0");
		lb_nov_horas_div.setText("00:00");
		lb_dez_posto_div.setText("0");
		lb_dez_horas_div.setText("00:00");
		somaFaltas = 0;
		somaHoras = 0;
		somaMinutos = 0;
		controles = new ServiceClient().getPlanilha(i);

		for (Controler planilha : controles) {

			/**
			 * Soma vindo do banco
			 */
			somaFaltas += planilha.getQtd_faltas();
			Controler cont_aux = new FucoesUtil().setControle(planilha);
			somaHoras += cont_aux.getHoras();

			/**
			 * Soma após contagem dos minutos
			 */
			cont_aux = new FucoesUtil().setMinutos(somaMinutos + cont_aux.getMinutos());
			somaMinutos = cont_aux.getMinutos();
			somaHoras += cont_aux.getHoras();

			switch (planilha.getMes()) {
			case 1:
				lb_jan_post_div.setText(String.valueOf(planilha.getQtd_faltas()));
				lb_jan_horas_div.setText(String.valueOf(planilha.getHoras() + ":" + planilha.getMinutos()));
				break;
			case 2:
				lb_fev_posto_div.setText(String.valueOf(planilha.getQtd_faltas()));
				lb_fev_horas_div.setText(String.valueOf(planilha.getHoras() + ":" + planilha.getMinutos()));
				break;
			case 3:
				lb_mar_posto_div.setText(String.valueOf(planilha.getQtd_faltas()));
				lb_mar_horas_div.setText(String.valueOf(planilha.getHoras() + ":" + planilha.getMinutos()));
				break;
			case 4:
				lb_abr_posto_div.setText(String.valueOf(planilha.getQtd_faltas()));
				lb_abr_horas_div.setText(String.valueOf(planilha.getHoras() + ":" + planilha.getMinutos()));
				break;
			case 5:
				lb_mai_posto_div.setText(String.valueOf(planilha.getQtd_faltas()));
				lb_mai_horas_div.setText(String.valueOf(planilha.getHoras() + ":" + planilha.getMinutos()));
				break;
			case 6:
				lb_jun_posto_div.setText(String.valueOf(planilha.getQtd_faltas()));
				lb_jun_horas_div.setText(String.valueOf(planilha.getHoras() + ":" + planilha.getMinutos()));
				break;
			case 7:
				lb_jul_posto_div.setText(String.valueOf(planilha.getQtd_faltas()));
				lb_jul_horas_div.setText(String.valueOf(planilha.getHoras() + ":" + planilha.getMinutos()));
				break;
			case 8:
				lb_ago_posto_div.setText(String.valueOf(planilha.getQtd_faltas()));
				lb_ago_horas_div.setText(String.valueOf(planilha.getHoras() + ":" + planilha.getMinutos()));
				break;
			case 9:
				lb_set_posto_div.setText(String.valueOf(planilha.getQtd_faltas()));
				lb_set_horas_div.setText(String.valueOf(planilha.getHoras() + ":" + planilha.getMinutos()));
				break;
			case 10:
				lb_out_posto_div.setText(String.valueOf(planilha.getQtd_faltas()));
				lb_out_horas_div.setText(String.valueOf(planilha.getHoras() + ":" + planilha.getMinutos()));
				break;
			case 11:
				lb_nov_posto_div.setText(String.valueOf(planilha.getQtd_faltas()));
				lb_nov_horas_div.setText(String.valueOf(planilha.getHoras() + ":" + planilha.getMinutos()));
				break;
			case 12:
				lb_dez_posto_div.setText(String.valueOf(planilha.getQtd_faltas()));
				lb_dez_horas_div.setText(String.valueOf(planilha.getHoras() + ":" + planilha.getMinutos()));
				break;
			default:
				break;
			}
		}

		lb_total_posto_div.setText(String.valueOf(somaFaltas));
		lb_total_horas_div.setText(String.valueOf(somaHoras + ":" + somaMinutos));
		
		pessoas = new ServiceClient().ConsultarTodasPessoas();
		for (Pessoa pessoa1 : pessoas) {
			lNomes.add(pessoa1.getNome());
		}
	}
}
