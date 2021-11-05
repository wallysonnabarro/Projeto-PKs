package br.sasclient.entity;

public class Relatorio {
	private String nome;
	private String inicio;
	private String fim;
	private int departamento;
	private int tipo;
	private int terceirizada;
	private int boleta;
	private Titularizacoes titularizacoes;

	public int getBoleta() {
		return boleta;
	}

	public void setBoleta(int boleta) {
		this.boleta = boleta;
	}

	public int getTerceirizada() {
		return terceirizada;
	}

	public void setTerceirizada(int terceirizada) {
		this.terceirizada = terceirizada;
	}

	public int getDepartamento() {
		return departamento;
	}

	public void setDepartamento(int departamento) {
		this.departamento = departamento;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getInicio() {
		return inicio;
	}

	public void setInicio(String inicio) {
		this.inicio = inicio;
	}

	public String getFim() {
		return fim;
	}

	public void setFim(String fim) {
		this.fim = fim;
	}

	public Titularizacoes getTitularizacoes() {
		return titularizacoes;
	}

	public void setTitularizacoes(Titularizacoes titularizacoes) {
		this.titularizacoes = titularizacoes;
	}

}
