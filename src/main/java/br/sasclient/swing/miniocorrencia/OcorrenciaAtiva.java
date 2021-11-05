package br.sasclient.swing.miniocorrencia;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Time;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import br.com.bo.DescricaoBO;
import br.sasclient.entity.Descricoes;
import br.sasclient.entity.OcorrenciaEnty;
import br.sasclient.service.ServiceClient;
import br.sasclient.swing.Monitoramento;
import br.sasclient.swing.msg.JPanelConfirmarOcorrencia;
import br.sasclient.swing.paginas.Descricao;
import br.sasclient.util.DataUtil;

public class OcorrenciaAtiva extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OcorrenciaEnty enty;
	private int index;
	private JPanel panel;
	private JLabel lbl_ocorrencia;
	private JLabel lbl_tempo;
	private String atraso;
	private Descricoes descricoes;

	/**
	 * Create the panel.
	 */
	public OcorrenciaAtiva(OcorrenciaEnty enty, int index, Monitoramento m) {
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setLayout(null);

		setPreferredSize(new Dimension(135, 51));

		this.enty = enty;
		this.index = index;

		panel = new JPanel();
		panel.setBackground(new Color(224, 255, 255));
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(0, 0, 135, 50);
		add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 255, 204));
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(0, 28, 135, 22);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lbl_nome = new JLabel(getSplit());
		lbl_nome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				finalizarOcorrencia();
			}
		});
		lbl_nome.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_nome.setBounds(0, 0, 135, 22);
		panel_1.add(lbl_nome);

		lbl_ocorrencia = new JLabel(this.enty.getTitulo());
		lbl_ocorrencia.setBackground(new Color(224, 255, 255));
		lbl_ocorrencia.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_ocorrencia.setForeground(new Color(65, 67, 72));
		lbl_ocorrencia.setBounds(0, 0, 131, 14);
		panel.add(lbl_ocorrencia);

		lbl_tempo = new JLabel("");
		lbl_tempo.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		lbl_tempo.setBounds(99, 11, 36, 14);
		panel.add(lbl_tempo);

		atualizarTempoBanco();
	}

	protected void finalizarOcorrencia() {
		JPanelConfirmarOcorrencia confirmarOcorrencia = new JPanelConfirmarOcorrencia();
		confirmarOcorrencia.setVisible(true);

		new Thread() {
			@SuppressWarnings("deprecation")
			public void run() {
				while (confirmarOcorrencia.isVisible()) {
				}

				if (confirmarOcorrencia.getConfirmação() == 1) {
					if (atraso == null) {
						atraso = "";
					}

					enty.setAtraso(atraso);
					new ServiceClient().FinalizarOcorrenciaAtiva(enty);
					OcorrenciaAtiva.this.hide();

				} else if (confirmarOcorrencia.getConfirmação() == 2) {
					Descricao descricao = new Descricao(enty);
					descricao.setVisible(true);

					while (descricao.isVisible()) {
					}

					descricoes = descricao.getListaDescricoes();

					new DescricaoBO().envioEmThreadDescricoes(descricoes, index);					
				}
			};
		}.start();
	}

	private String getSplit() {
		String[] s = new String[this.enty.getNome().length()];
		s = this.enty.getNome().split(" ");
		return s[0];
	}

	private void atualizarTempoBanco() {
		final Time tempo = new DataUtil().getTimeString(this.enty.getPrimeiro());

		new Thread() {
			public void run() {
				try {
					PARAR: for (int i = 0; i < tempo.getTime(); i++) {
						sleep(2000);
						String s = new ServiceClient().ConsultarOcorrenciaTempo(1, index);
						if ("00:00:00".equals(s)) {
							panel.setBackground(new Color(255, 215, 100));
							lbl_ocorrencia.setForeground(new Color(65, 67, 72));
							break PARAR;
						}
					}

					Time tempo2 = new DataUtil().getTimeString(getTempoSplit(enty.getSegundo(), enty.getPrimeiro()));
					PARAR: for (int i = 0; i < tempo2.getTime(); i++) {
						sleep(2000);
						String s = new ServiceClient().ConsultarOcorrenciaTempo(2, index);
						if ("00:00:00".equals(s)) {
							panel.setBackground(new Color(170, 18, 7));
							lbl_ocorrencia.setForeground(new Color(255, 255, 255));
							break PARAR;
						}
					}

					String atrasoBd = new ServiceClient().ConsultarOcorrenciaTempoAtraso(index);

					int t = 0;
					while (OcorrenciaAtiva.this.isVisible()) {
						sleep(2000);
						atraso = getTempoSplitAtraso(new DataUtil().getString(new Time(System.currentTimeMillis())),
								atrasoBd);
						lbl_tempo.setText(atraso);
						if (t % 2 == 0) {
							panel.setBackground(new Color(255, 215, 100));
							lbl_ocorrencia.setForeground(new Color(65, 67, 72));
						} else {
							panel.setBackground(new Color(170, 18, 7));
							lbl_ocorrencia.setForeground(new Color(255, 255, 255));
						}
						t++;
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			};
		}.start();
	}

	private static String getTempoSplit(String t1, String t2) {
		String[] c = new String[t1.length()];
		String[] c2 = new String[t2.length()];
		c = t1.split(":");
		c2 = t2.split(":");

		int hora = 0;
		int minutos = 0;
		int segundos = 0;

		if (Integer.parseInt(c[0]) > 0) {
			hora = Integer.parseInt(c[0]) - Integer.parseInt(c2[0]);
		}
		if (Integer.parseInt(c[1]) > 0) {
			minutos = Integer.parseInt(c[1]) - Integer.parseInt(c2[1]);
		}
		if (Integer.parseInt(c[2]) > 0) {
			segundos = Integer.parseInt(c[2]) - Integer.parseInt(c2[2]);
		}

		return String.valueOf(hora) + ":" + String.valueOf(minutos) + ":" + String.valueOf(segundos);
	}

	/**
	 * 
	 * @param t1 = Tempo do sistema
	 * @param t2 = Tempo do banco de dados
	 * @return uma String com o valor do tempo de atraso
	 */
	private static String getTempoSplitAtraso(String t1, String t2) {

		int CONSTANTE = 59;

		String[] c = new String[t1.length()];
		String[] c2 = new String[t2.length()];
		c = t1.split(":");
		c2 = t2.split(":");

		int h = 0;
		int m = 0;

		if (Integer.parseInt(c[0]) >= Integer.parseInt(c2[0])) {
			if (Integer.parseInt(c[0]) - Integer.parseInt(c2[0]) == 1) {
				h = 0;
			} else {
				h = Integer.parseInt(c[0]) - Integer.parseInt(c2[0]) - 1;
			}
		}

		m = (CONSTANTE - Integer.parseInt(c2[1])) + Integer.parseInt(c[1]);

		if (m > 59) {
			m -= CONSTANTE;
			h++;
		}

		String hora = String.valueOf(h);
		String minutos = String.valueOf(m);

		if (hora.length() == 1) {
			hora = "0" + hora;
		}

		if (minutos.length() == 1) {
			minutos = "0" + minutos;
		}

		return hora + ":" + minutos;
	}
}
