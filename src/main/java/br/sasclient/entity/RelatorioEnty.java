package br.sasclient.entity;

public class RelatorioEnty {

	private int codigo1;
	private int codigo2;
	private String nome;
	private String data_inicio;
	private String data_final;
	private String controle;

	public int getCodigo1() {
		return codigo1;
	}

	public void setCodigo1(int codigo1) {
		this.codigo1 = codigo1;
	}

	public int getCodigo2() {
		return codigo2;
	}

	public void setCodigo2(int codigo2) {
		this.codigo2 = codigo2;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getData_inicio() {
		return data_inicio;
	}

	public void setData_inicio(String data_inicio) {
		this.data_inicio = data_inicio;
	}

	public String getData_final() {
		return data_final;
	}

	public void setData_final(String data_final) {
		this.data_final = data_final;
	}

	public String getControle() {
		return controle;
	}

	public void setControle(String controle) {
		this.controle = controle;
	}

}
