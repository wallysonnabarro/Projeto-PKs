package br.sasclient.swing.submenus;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import br.sasclient.entity.Prefixo;
import br.sasclient.model.JtableModelPrefixos;
import br.sasclient.service.ServiceClient;
import br.sasclient.swing.msg.MensagensJD2;
import br.sasclient.util.LimiteTxt;
import java.awt.Font;

public class Prefixos extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private ArrayList<Prefixo> listaPrefixos;
	private JtableModelPrefixos prefixos;
	private JButton btnRegistrar;
	private JFormattedTextField txtPrefixo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Prefixos dialog = new Prefixos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Prefixos() {
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 377, 390);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		Toolkit toolkit = getToolkit();
		Dimension d = toolkit.getScreenSize();
		setLocation(d.width / 2 - getWidth() / 2, d.height / 2 - getHeight() / 2);

		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			panel.setBounds(0, 0, 371, 361);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBackground(Color.WHITE);
				panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
				panel_1.setBounds(10, 11, 351, 115);
				panel.add(panel_1);
				panel_1.setLayout(null);
				{
					JPanel panel_2 = new JPanel();
					panel_2.setBackground(new Color(0, 103, 71));
					panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
					panel_2.setBounds(0, 0, 351, 31);
					panel_1.add(panel_2);
					panel_2.setLayout(null);

					JLabel lblNewLabel = new JLabel("Dados");
					lblNewLabel.setForeground(Color.WHITE);
					lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 11));
					lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
					lblNewLabel.setBounds(0, 0, 351, 31);
					panel_2.add(lblNewLabel);
				}
				{
					JLabel lblNewLabel_1 = new JLabel("Prefixo");
					lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 11));
					lblNewLabel_1.setBounds(44, 39, 46, 31);
					panel_1.add(lblNewLabel_1);
				}

				btnRegistrar = new JButton("Registrar");
				btnRegistrar.setBackground(new Color(204, 255, 255));
				btnRegistrar.setFont(new Font("Segoe UI", Font.PLAIN, 11));
				btnRegistrar.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent e) {
						registrar();
					}
				});
				btnRegistrar.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						registrar();
					}
				});
				btnRegistrar.setBounds(186, 81, 89, 23);
				panel_1.add(btnRegistrar);

				txtPrefixo = new JFormattedTextField();
				txtPrefixo.setFont(new Font("Segoe UI", Font.PLAIN, 11));
				txtPrefixo.setBounds(116, 39, 159, 31);
				txtPrefixo.setDocument(new LimiteTxt(10));

				txtPrefixo.addKeyListener(new KeyAdapter() {

					@Override
					public void keyPressed(KeyEvent e) {
						if (e.getKeyCode() == KeyEvent.VK_ENTER) {
							btnRegistrar.requestFocus();
						}
					}
				});
				panel_1.add(txtPrefixo);
			}

			JPanel panel_1 = new JPanel();
			panel_1.setBounds(10, 133, 351, 209);
			panel.add(panel_1);
			panel_1.setLayout(null);

			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setViewportBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			scrollPane.setBounds(0, 0, 351, 209);
			panel_1.add(scrollPane);

			/**
			 * GET: Lista de prefixos
			 */
			listaPrefixos = new ServiceClient().ConsultarTodosPrefixos();
			prefixos = new JtableModelPrefixos(listaPrefixos);
			table = new JTable();
			table.setModel(prefixos);
			scrollPane.setViewportView(table);
		}
	}

	private void registrar() {
		if (!"".equals(txtPrefixo.getText().toString())) {
			Prefixo prefixo = new Prefixo();
			prefixo.setPrefixo(txtPrefixo.getText().toString());

			String msg = new ServiceClient().CadastrarPrefixo(prefixo);

			MensagensJD2 jd2 = new MensagensJD2(msg, "Prefixo");
			jd2.setVisible(true);

			if ("Registro cadastrado com sucesso!".equals(msg)) {
				int i = listaPrefixos.size() - 1;
				prefixo.setCodigo((listaPrefixos.get(i).getCodigo() + 1));
				prefixos.addPrefixo(prefixo);
				repaint();
				revalidate();
			}
		} else {
			MensagensJD2 jd2 = new MensagensJD2("Preencha o campo prefixo.", "Prefixo");
			jd2.setVisible(true);
		}
	}
}
