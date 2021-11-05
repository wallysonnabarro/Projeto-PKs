package br.sasclient.util;

import java.util.List;

import br.sasclient.entity.Controler;

public class FucoesUtil {

	public Controler setControle(Controler controler) {
		if (controler.getMinutos() >= 60) {
			while (controler.getMinutos() >= 60) {
				controler.setHoras(controler.getHoras() + 1);
				controler.setMinutos(controler.getMinutos() - 60);
			}
		}
		return controler;
	}
	public Controler setMinutos(int minutos) {
		int horas = 0;
		int m = 0;
		if (minutos >= 60) {
			while (minutos >= 60) {
				horas = horas + 1;
				m = m + 1;
			}
		} else {
			m = minutos;
		}
		Controler controler = new Controler();
		controler.setHoras(horas);
		controler.setMinutos(m);
		return controler;
	}

	public Controler setIntinerario1(Controler controler, int tipo, int horas, int min) {
		int c_horas = controler.getHoras();
		int c_minutos = controler.getMinutos() ;
		int c_faltas = controler.getQtd_faltas();
		
		if (tipo == 1) {
			controler.setQtd_faltas(c_faltas + tipo);
		} else {
			controler.setHoras(horas + c_horas);
			controler.setMinutos(min + c_minutos);
			controler = new FucoesUtil().setControle(controler);
		}
		return controler;
	}
	public Controler setReposicoes(Controler controler, int tipo) {
		int c_horas = controler.getHoras();
		int c_faltas = controler.getQtd_faltas();
		
		if (tipo == 1) {
			controler.setQtd_faltas(c_faltas + tipo);
		} else {
			tipo = 12;
			controler.setHoras(tipo + c_horas);
			controler = new FucoesUtil().setControle(controler);
		}
		return controler;
	}

	public Controler setIntinerario2(Controler controler, int tipo, int horas, int min) {
		if (tipo == 1) {
			controler.setQtd_faltas(1);
			controler.setHoras(0);
			controler.setMinutos(0);
		} else {
			controler.setHoras(horas);
			controler.setMinutos(min);
			controler = new FucoesUtil().setControle(controler);
			controler.setQtd_faltas(0);
		}
		return controler;
	}
	
	public Controler setReposicoes2(Controler controler, int tipo) {
		if (tipo == 1) {
			controler.setQtd_faltas(1);
			controler.setHoras(0);
			controler.setMinutos(0);
		} else {
			tipo = 12;
			controler.setHoras(tipo);
			controler.setMinutos(0);
			controler = new FucoesUtil().setControle(controler);
			controler.setQtd_faltas(0);
		}
		return controler;
	}
	
	public Controler getControler(List<Controler> l, int j) {
		Controler controler = new Controler();
		for(int i = 0; i < l.size(); i++) {
			if(l.get(i).getMes() == j) {
				controler = l.get(i);
				controler.setCodigo(i);
			}
		}		
		return controler;
		
	}

}
