package br.sasclient.entity;

import java.util.Date;

public class OcorrenciaEnty {
	private int codigo;
	private int grupo;
	private String titulo;
	private String nome;
	private Date registro;
	private String hora_registro;
	private String primeiro;
	private String segundo;
	private String atraso;
	private String descricao;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getGrupo() {
		return grupo;
	}

	public void setGrupo(int grupo) {
		this.grupo = grupo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getRegistro() {
		return registro;
	}

	public void setRegistro(Date registro) {
		this.registro = registro;
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

	public String getAtraso() {
		return atraso;
	}

	public void setAtraso(String atraso) {
		this.atraso = atraso;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getHora_registro() {
		return hora_registro;
	}

	public void setHora_registro(String hora_registro) {
		this.hora_registro = hora_registro;
	}
	
	
}
