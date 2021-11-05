package br.sasclient.swing.submenus;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.sasclient.entity.Titularizacao;
import br.sasclient.entity.Titularizacoes;
import br.sasclient.model.JtableModelTitularizacao;
import br.sasclient.service.ServiceClient;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SelectItensRelatorio extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable tb_itens_bd;
	private JTable tb_lista;
	private Titularizacoes listaTitularizacao;
	private Titularizacoes transferencia;
	private JtableModelTitularizacao titularizacaoModem;
	private JtableModelTitularizacao tabelaTransferencia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SelectItensRelatorio dialog = new SelectItensRelatorio();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SelectItensRelatorio() {
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 708, 481);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		Toolkit toolkit = getToolkit();
		Dimension d = toolkit.getScreenSize();
		setLocation(d.width / 2 - getWidth() / 2, d.height / 2 - getHeight() / 2);
		
		{
			JPanel panel = new JPanel();
			panel.setBounds(0, 0, 1, 1);
			contentPanel.add(panel);
			panel.setLayout(null);
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 302, 397);
		contentPanel.add(scrollPane);
		
		listaTitularizacao = new ServiceClient().ConsultarTodosTitularizacao();
		titularizacaoModem = new JtableModelTitularizacao(listaTitularizacao);
		
		tb_itens_bd = new JTable();
		tb_itens_bd.setModel(titularizacaoModem);
		scrollPane.setViewportView(tb_itens_bd);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(390, 11, 302, 397);
		contentPanel.add(scrollPane_1);
		
		
		transferencia = new Titularizacoes();
		tabelaTransferencia = new JtableModelTitularizacao(transferencia);
		tb_lista = new JTable();
		tb_lista.setModel(tabelaTransferencia);
		scrollPane_1.setViewportView(tb_lista);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				select();				
			}
		});
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(SelectItensRelatorio.class.getResource("/br/sasclient/imagens/double_right_26px_laranja.png")));
		lblNewLabel.setBounds(313, 155, 75, 20);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(SelectItensRelatorio.class.getResource("/br/sasclient/imagens/double_left_26px.png")));
		lblNewLabel_1.setBounds(313, 239, 75, 20);
		contentPanel.add(lblNewLabel_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	protected void select() {
		if(transferencia == null) {
			transferencia = new Titularizacoes();
		}
		
		int index = tb_itens_bd.getSelectedRow();
		if(index > -1) {
			Titularizacao t = new Titularizacao();
			t.setCodigo(listaTitularizacao.get(index).getCodigo());
			t.setTitulo(listaTitularizacao.get(index).getTitulo());
			tabelaTransferencia.addTitularizacao(t);
			titularizacaoModem.removerTitularizacao(index);
		}
	}
	
	public Titularizacoes geteLista() {
		return transferencia;
	}
}
