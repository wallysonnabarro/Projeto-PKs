package br.sasclient.model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import br.sasclient.entity.Usuario;

public class JtableModelUsuario extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Usuario> listaUsuario;
	private String[] colunas = { "Nome", "Usuário" };

	public JtableModelUsuario(ArrayList<Usuario> lista) {
		this.listaUsuario = lista;
	}

	public void addUsuario(Usuario usuario) {
		this.listaUsuario.add(usuario);
		fireTableDataChanged();
	}

	public void removerUsuario(int rowIndex) {
		this.listaUsuario.remove(rowIndex);
		fireTableDataChanged();
	}

	public Usuario getUsuario(int rowIndex) {
		return this.listaUsuario.get(rowIndex);
	}

	@Override
	public int getColumnCount() {
		return this.colunas.length;
	}

	@Override
	public int getRowCount() {
		return this.listaUsuario.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return this.listaUsuario.get(rowIndex).getNome();
		case 1:
			return this.listaUsuario.get(rowIndex).getUsuario();
		default:
			return this.listaUsuario.get(rowIndex);
		}
	}

	@Override
	public String getColumnName(int column) {
		return this.colunas[column];
	}

}
