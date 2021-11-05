package br.sasclient.entity;

import java.util.Date;

public class Controler {

	private int codigo;
	private Integer mes;
	private Integer qtd_faltas;
	private String qtd_horas_minutos;
	private Date dt_anoVigente_inicio;
	private Date dt_anoVigente_fim;
	private Integer horas;
	private Integer minutos;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Integer getHoras() {
		return horas;
	}

	public void setHoras(Integer horas) {
		this.horas = horas;
	}

	public Integer getMinutos() {
		return minutos;
	}

	public void setMinutos(Integer minutos) {
		this.minutos = minutos;
	}

	public Date getDt_anoVigente_inicio() {
		return dt_anoVigente_inicio;
	}

	public void setDt_anoVigente_inicio(Date dt_anoVigente_inicio) {
		this.dt_anoVigente_inicio = dt_anoVigente_inicio;
	}

	public Date getDt_anoVigente_fim() {
		return dt_anoVigente_fim;
	}

	public void setDt_anoVigente_fim(Date dt_anoVigente_fim) {
		this.dt_anoVigente_fim = dt_anoVigente_fim;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public Integer getQtd_faltas() {
		return qtd_faltas;
	}

	public void setQtd_faltas(Integer qtd_faltas) {
		this.qtd_faltas = qtd_faltas;
	}

	public String getQtd_horas_minutos() {
		return qtd_horas_minutos;
	}

	public void setQtd_horas_minutos(String qtd_horas_minutos) {
		this.qtd_horas_minutos = qtd_horas_minutos;
	}

}
