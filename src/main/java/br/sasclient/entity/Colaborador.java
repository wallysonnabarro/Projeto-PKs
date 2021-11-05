package br.sasclient.entity;

public class Colaborador {

	private Integer codigo;
	private String nome;
	private String data;
	private int tipo;
	private int horas;
	private int minutos;
	private int terceirizada;

	public int getTerceirizada() {
		return terceirizada;
	}

	public void setTerceirizada(int terceirizada) {
		this.terceirizada = terceirizada;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public int getMinutos() {
		return minutos;
	}

	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}

}
