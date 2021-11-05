package br.sasclient.swing.paginas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import br.sasclient.entity.DescricaoEnty;
import br.sasclient.entity.Descricoes;
import br.sasclient.entity.OcorrenciaEnty;
import br.sasclient.model.JtableModelDescricao;
import br.sasclient.service.ServiceClient;
import br.sasclient.swing.submenus.Campo;
import br.sasclient.util.DataUtil;

public class Descricao extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private String descricao = "";
	private Descricoes descricoes;
	private JtableModelDescricao modelDescricao;
	private DescricaoEnty enty;
	private static OcorrenciaEnty oc;
	private Campo campo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Descricao dialog = new Descricao(oc);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Descricao(OcorrenciaEnty enty) {
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 638, 294);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		Descricao.oc = enty;

		/**
		 * Pega todas as descrições realizadas nesta ocorrência.
		 */
		descricoes = new ServiceClient().pegarDescricaoDaOcorrenciaID(oc);
		carregarTabelaBd();

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(0, 0, 632, 265);
		contentPanel.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new java.awt.Color(0, 103, 71));
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(0, 0, 632, 38);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Adicionar");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				campo = new Campo();
				campo.setVisible(true);
				new Thread() {
					public void run() {
						while (campo.isVisible()) {
						}
						carregarTabela();
					};
				}.start();
			}
		});
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 632, 38);
		panel_1.add(lblNewLabel);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 49, 612, 205);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 612, 205);
		panel_2.add(scrollPane);

		table = new JTable();
		table.setModel(modelDescricao);
		scrollPane.setViewportView(table);

		Toolkit toolkit = getToolkit();
		Dimension d = toolkit.getScreenSize();
		setLocation(d.width / 2 - getWidth() / 2, d.height / 2 - getHeight() / 2);
	}

	private void carregarTabela() {
		if (campo.getConfirmacao() == 1) {
			descricao = campo.descricao();
			enty = new DescricaoEnty();
			enty.setDescricao(descricao);
			enty.setData(new DataUtil().getDateStringInvertidoParaBancoSemHora(new DataUtil().pegarDataAtual()));
			enty.setHora(new DataUtil().getHoraStringParaBancoSemData(new DataUtil().pegarDataAtual()));

			modelDescricao.addDescricao(enty);
		}
	}

	private void carregarTabelaBd() {
		if (modelDescricao == null) {
			modelDescricao = new JtableModelDescricao(descricoes);
		}
	}

	public Descricoes getListaDescricoes() {
		if (descricoes == null) {
			descricoes = new Descricoes();
		}
		return descricoes;
	}

}
