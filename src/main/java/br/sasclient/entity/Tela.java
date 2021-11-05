
package br.sasclient.entity;

public class Tela {
	private int codigo;
	private int codigo_colaborador;
	private String prefixo;
	private String colaborador;
	private String foto;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo_colaborador() {
		return codigo_colaborador;
	}

	public void setCodigo_colaborador(int codigo_colaborador) {
		this.codigo_colaborador = codigo_colaborador;
	}

	public String getPrefixo() {
		return prefixo;
	}

	public void setPrefixo(String prefixo) {
		this.prefixo = prefixo;
	}

	public String getColaborador() {
		return colaborador;
	}

	public void setColaborador(String colaborador) {
		this.colaborador = colaborador;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

}
