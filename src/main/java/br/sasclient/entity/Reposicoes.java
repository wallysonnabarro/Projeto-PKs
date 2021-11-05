package br.sasclient.entity;

import java.io.Serializable;

public class Reposicoes implements Serializable{

	private static final long serialVersionUID = 1L;
	private int codigo;
	private String nome;
	private String local;
	private String data;
	private int tipo;
	private int departamento;
	private int esp;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getDepartamento() {
		return departamento;
	}

	public void setDepartamento(int departamento) {
		this.departamento = departamento;
	}

	public int getEsp() {
		return esp;
	}

	public void setEsp(int esp) {
		this.esp = esp;
	}

}
