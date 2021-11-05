package br.sasclient.swing.miniocorrencia;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import br.sasclient.entity.Ocorrencia;
import br.sasclient.swing.paginas.Ocorrencias;

public class MiniOcorrencia extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int index;
	private Ocorrencia ocorrencia;
	private Color COLOR = Color.lightGray;
	private Color COLOR_TEXTO = Color.lightGray;
	private JLabel lbl_texto;
	private JPanel panel_1;
	private Ocorrencias ocorrencias;

	/**
	 * Create the panel.
	 */
	public MiniOcorrencia(Ocorrencia ocorrencia, int index, Ocorrencias ocorrencias) {
		setBackground(Color.LIGHT_GRAY);
		this.index = index;
		this.ocorrencia = ocorrencia;
		this.ocorrencias = ocorrencias;
		iniciar();
	}

	private void iniciar() {

		setLayout(null);
		setPreferredSize(new Dimension(120, 43));
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 120, 47);
		add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(0, 0, 120, 47);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		lbl_texto = new JLabel(ocorrencia.getNome());
		lbl_texto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				escolha();
			}
		});
		lbl_texto.setFont(new Font("Segoe UI", Font.BOLD, 10));
		lbl_texto.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_texto.setBounds(0, 0, 120, 47);
		panel_1.add(lbl_texto);
		carregaCores(ocorrencia);
	}
	
	protected void escolha() {
		ocorrencias.getClickMiniOcorrencia(index);
	}

	private void carregaCores(Ocorrencia ocorrencia) {
		String[] fundo = new String[3];
		String[] texto = new String[3];

		fundo = ocorrencia.getCor_fundo().split(",");
		texto = ocorrencia.getCor_texto().split(",");

		COLOR = new Color(Integer.parseInt(fundo[0]), Integer.parseInt(fundo[1]), Integer.parseInt(fundo[2]));
		COLOR_TEXTO = new Color(Integer.parseInt(texto[0]), Integer.parseInt(texto[1]), Integer.parseInt(texto[2]));
		
		panel_1.setBackground(COLOR);
		lbl_texto.setForeground(COLOR_TEXTO);
	}
}
