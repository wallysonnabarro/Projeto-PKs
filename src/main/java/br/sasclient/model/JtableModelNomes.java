package br.sasclient.model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import br.sasclient.entity.Pessoa;

public class JtableModelNomes extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Pessoa> listaPessoas;
	private String[] colunas = { "CÓDIGO", "NOMES" };

	public JtableModelNomes(ArrayList<Pessoa> lista) {
		this.listaPessoas = lista;
	}

	public void addPessoa(Pessoa pessoa) {
		this.listaPessoas.add(pessoa);
		fireTableDataChanged();
	}

	public void removerPessoa(int rowIndex) {
		this.listaPessoas.remove(rowIndex);
		fireTableDataChanged();
	}

	public Pessoa getPessoa(int rowIndex) {
		return this.listaPessoas.get(rowIndex);
	}

	@Override
	public int getColumnCount() {
		return this.colunas.length;
	}

	@Override
	public int getRowCount() {
		return this.listaPessoas.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return this.listaPessoas.get(rowIndex).getCodigo();
		case 1:
			return this.listaPessoas.get(rowIndex).getNome();
		default:
			return this.listaPessoas.get(rowIndex);
		}
	}

	@Override
	public String getColumnName(int column) {
		return this.colunas[column];
	}

}
