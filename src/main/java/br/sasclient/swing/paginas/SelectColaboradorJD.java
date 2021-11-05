package br.sasclient.swing.paginas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import br.sasclient.entity.Pessoa;
import br.sasclient.entity.Pessoas;
import br.sasclient.entity.Prefixo;
import br.sasclient.entity.Prefixos;
import br.sasclient.entity.Tela;
import br.sasclient.entity.Telas;
import br.sasclient.model.JtableModelNomes;
import br.sasclient.model.JtableModelNomesPrefixos;
import br.sasclient.model.JtableModelPrefixos;
import br.sasclient.service.ServiceClient;
import br.sasclient.util.LimiteTxt;

public class SelectColaboradorJD extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txt_nome;
	private JTextField txt_prefixos;
	private JTable tb_nomes_prefixos;
	private JTable tb_nomes;
	private Set<String> lNomes;
	private Set<String> lPrefixos;
	private Pessoas pessoas = new Pessoas();
	private Prefixos prefixo = new Prefixos();
	private JButton btn_registrar;
	private ArrayList<Prefixo> listaPrefixos;
	private JTable tb_prefixos;
	private Telas telas = new Telas();
	private Telas telas_transf;
	private Tela tela;
	// private ListaNomesPrefixos listaNomesPrefixosTrasnsf;
	private JtableModelNomesPrefixos jtableModelNomesPrefixos;
	private JtableModelPrefixos prefixos;
	private JtableModelNomes nomes;
	private static List<Tela> lista;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SelectColaboradorJD dialog = new SelectColaboradorJD(lista);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * 
	 * @param b
	 * @param monitorar
	 */
	public SelectColaboradorJD(List<Tela> l) {
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 922, 554);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		Toolkit toolkit = getToolkit();
		Dimension d = toolkit.getScreenSize();
		setLocation(d.width / 2 - getWidth() / 2, d.height / 2 - getHeight() / 2);
		SelectColaboradorJD.lista = l;

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 11, 892, 86);
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblNewLabel.setBounds(23, 11, 56, 14);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Prefixo");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(23, 48, 56, 14);
		panel.add(lblNewLabel_1);

		txt_nome = new JTextField();
		txt_nome.setDocument(new LimiteTxt(100));
		txt_nome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					txt_prefixos.requestFocus();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				txt_nome_controleKeyRealesse(e);
			}
		});
		txt_nome.setBounds(85, 9, 308, 26);
		panel.add(txt_nome);
		txt_nome.setColumns(10);

		txt_prefixos = new JTextField();
		txt_prefixos.setDocument(new LimiteTxt(50));
		txt_prefixos.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btn_registrar.requestFocus();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				txt_prefixos_controleKeyRealesse(e);
			}
		});
		txt_prefixos.setColumns(10);
		txt_prefixos.setBounds(85, 46, 308, 29);
		panel.add(txt_prefixos);

		btn_registrar = new JButton();
		btn_registrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				caixaTexto();
			}
		});
		btn_registrar.setText("Inserir");
		btn_registrar.setForeground(Color.WHITE);
		btn_registrar.setBackground(new Color(40, 88, 127));
		btn_registrar.setBounds(406, 8, 124, 28);
		panel.add(btn_registrar);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 100, 0));
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(539, 0, 353, 86);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JButton btn_registrar_1 = new JButton();
		btn_registrar_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				caixaTexto();
			}
		});
		btn_registrar_1.setText("Encaminhar Lista");
		btn_registrar_1.setForeground(Color.WHITE);
		btn_registrar_1.setBackground(new Color(40, 88, 127));
		btn_registrar_1.setBounds(10, 47, 163, 28);
		panel_1.add(btn_registrar_1);

		JScrollPane jSP_Nomes = new JScrollPane();
		jSP_Nomes.setBounds(10, 100, 417, 208);
		contentPanel.add(jSP_Nomes);

		carregarPrefixos();

		/**
		 * GET: Lista de nomes
		 */
		nomes = new JtableModelNomes(carregarPessoas());
		tb_nomes = new JTable();
		tb_nomes.setModel(nomes);
		jSP_Nomes.setViewportView(tb_nomes);

		/**
		 * GET: Lista de prefixos
		 */
		listaPrefixos = new ServiceClient().ConsultarTodosPrefixos();
		prefixos = new JtableModelPrefixos(listaPrefixos);
		JScrollPane jSP_prefixo = new JScrollPane();
		jSP_prefixo.setBounds(10, 311, 417, 208);
		tb_prefixos = new JTable();
		tb_prefixos.setModel(prefixos);
		contentPanel.add(jSP_prefixo);

		jSP_prefixo.setViewportView(tb_prefixos);

		JScrollPane jSP_nomes_prefixos = new JScrollPane();
		tb_nomes_prefixos = new JTable();
		jtableModelNomesPrefixos = new JtableModelNomesPrefixos(telas);
		tb_nomes_prefixos.setModel(jtableModelNomesPrefixos);
		jSP_nomes_prefixos.setBounds(469, 100, 433, 419);
		contentPanel.add(jSP_nomes_prefixos);
		jSP_nomes_prefixos.setViewportView(tb_nomes_prefixos);

		JLabel lbl_inserir = new JLabel("");
		lbl_inserir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				inserir();
			}
		});
		lbl_inserir.setIcon(new ImageIcon(
				SelectColaboradorJD.class.getResource("/br/sasclient/imagens/double_right_26px_laranja.png")));
		lbl_inserir.setBounds(437, 265, 33, 26);
		contentPanel.add(lbl_inserir);

		JLabel lbl_retirar = new JLabel("");
		lbl_retirar.setIcon(
				new ImageIcon(SelectColaboradorJD.class.getResource("/br/sasclient/imagens/double_left_26px.png")));
		lbl_retirar.setBounds(437, 318, 33, 26);
		lbl_retirar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int linhaSelectNomePrefixos = tb_nomes_prefixos.getSelectedRow();
				if (linhaSelectNomePrefixos > -1) {
					Pessoa pessoa = new Pessoa();
					pessoa.setCodigo(telas.get(linhaSelectNomePrefixos).getCodigo());
					pessoa.setNome(telas.get(linhaSelectNomePrefixos).getColaborador());
					nomes.addPessoa(pessoa);
					jtableModelNomesPrefixos.removerNomesPrefixos(linhaSelectNomePrefixos);
				}
			}
		});
		contentPanel.add(lbl_retirar);
	}

	protected void caixaTexto() {
		dispose();
	}

	protected void inserir() {
		if (telas_transf == null) {
			telas_transf = new Telas();
		}
		int linhaSelectNome = tb_nomes.getSelectedRow();
		int linhaSelectPrefixos = tb_prefixos.getSelectedRow();
		if (linhaSelectNome > -1 && linhaSelectPrefixos > -1) {
			tela = new Tela();
			tela.setCodigo_colaborador(pessoas.get(linhaSelectNome).getCodigo());
			tela.setColaborador(pessoas.get(linhaSelectNome).getNome());
			tela.setFoto(pessoas.get(linhaSelectNome).getFoto());
			tela.setPrefixo(listaPrefixos.get(linhaSelectPrefixos).getPrefixo());
			jtableModelNomesPrefixos.addNomesPrefixos(tela);
			telas_transf.add(tela);
			nomes.removerPessoa(linhaSelectNome);
		}
	}

	private ArrayList<Pessoa> carregarPessoas() {
		lNomes = new TreeSet<String>();
		pessoas = new ServiceClient().ConsultarTodasPessoas();
		for (int i = 0; i < pessoas.size(); i++) {
			Pessoa pessoa1 = pessoas.get(i);
			int p = 0;
			para: for (Tela compara : lista) {
				if (compara.getColaborador().equals(pessoa1.getNome())) {
					p = 1;
					break para;
				}
			}
			if (p == 0) {
				lNomes.add(pessoa1.getNome());
			} else {
				pessoas.remove(i);
			}
		}

		return pessoas;
	}

	private void carregarPrefixos() {
		lPrefixos = new TreeSet<String>();
		if (prefixo.size() != 0) {
			prefixo = new ServiceClient().ConsultarTodosPrefixos();
			for (Prefixo f : prefixo) {
				lPrefixos.add(f.getPrefixo());
			}
		} else {
			prefixo = new ServiceClient().ConsultarTodosPrefixos();
			for (Prefixo f : prefixo) {
				lPrefixos.add(f.getPrefixo());
			}
		}
	}

	private void txt_nome_controleKeyRealesse(java.awt.event.KeyEvent evt) {

		if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getKeyCode() == KeyEvent.VK_DELETE) {

		} else {

			String to_check = txt_nome.getText();
			int to_check_length = to_check.length();
			for (String data : lNomes) {
				String check_from_data = "";
				for (int i = 0; i < to_check_length; i++) {
					if (to_check_length <= data.length()) {
						check_from_data = check_from_data + data.charAt(i);
					}
				}
				if (check_from_data.equals(to_check)) {
					txt_nome.setText(data);
					txt_nome.setSelectionStart(to_check_length);
					txt_nome.setSelectionEnd(data.length());
					break;
				}
			}
		}
	}

	private void txt_prefixos_controleKeyRealesse(java.awt.event.KeyEvent evt) {

		if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getKeyCode() == KeyEvent.VK_DELETE) {

		} else {

			String to_check = txt_prefixos.getText();
			int to_check_length = to_check.length();
			for (String data : lPrefixos) {
				String check_from_data = "";
				for (int i = 0; i < to_check_length; i++) {
					if (to_check_length <= data.length()) {
						check_from_data = check_from_data + data.charAt(i);
					}
				}
				if (check_from_data.equals(to_check)) {
					txt_prefixos.setText(data);
					txt_prefixos.setSelectionStart(to_check_length);
					txt_prefixos.setSelectionEnd(data.length());
					break;
				}
			}
		}
	}

	public List<Tela> getTela() {
		if (telas_transf == null) {
			telas_transf = new Telas();
		}
		for (int i = 0; i < telas_transf.size(); i++) {
			jtableModelNomesPrefixos.removerNomesPrefixos(0);
		}
		return telas_transf;
	}
}
