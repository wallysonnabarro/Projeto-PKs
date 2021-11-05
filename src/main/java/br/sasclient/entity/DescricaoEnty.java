package br.sasclient.entity;

public class DescricaoEnty {

	private int codigo;
	private int codigo_ocorrencia_ativa;
	private String descricao;
	private String data;
	private String hora;

	public int getCodigo_ocorrencia_ativa() {
		return codigo_ocorrencia_ativa;
	}

	public void setCodigo_ocorrencia_ativa(int codigo_ocorrencia_ativa) {
		this.codigo_ocorrencia_ativa = codigo_ocorrencia_ativa;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

}
