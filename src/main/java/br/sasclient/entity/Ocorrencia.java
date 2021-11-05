package br.sasclient.entity;

public class Ocorrencia {

	private int id;
	private int inativo;
	private int grupo;
	private String nome;
	private String cor_fundo;
	private String cor_texto;
	private String primeiro;
	private String segundo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getInativo() {
		return inativo;
	}

	public void setInativo(int inativo) {
		this.inativo = inativo;
	}

	public int getGrupo() {
		return grupo;
	}

	public void setGrupo(int grupo) {
		this.grupo = grupo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCor_fundo() {
		return cor_fundo;
	}

	public void setCor_fundo(String cor_fundo) {
		this.cor_fundo = cor_fundo;
	}

	public String getCor_texto() {
		return cor_texto;
	}

	public void setCor_texto(String cor_texto) {
		this.cor_texto = cor_texto;
	}

	public String getPrimeiro() {
		return primeiro;
	}

	public void setPrimeiro(String primeiro) {
		this.primeiro = primeiro;
	}

	public String getSegundo() {
		return segundo;
	}

	public void setSegundo(String segundo) {
		this.segundo = segundo;
	}

}
