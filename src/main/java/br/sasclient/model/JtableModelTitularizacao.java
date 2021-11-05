package br.sasclient.model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import br.sasclient.entity.Titularizacao;

public class JtableModelTitularizacao extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Titularizacao> titularizacao;
	private String[] colunas = { "CÓDIGO", "Titulos" };

	public JtableModelTitularizacao(ArrayList<Titularizacao> lista) {
		this.titularizacao = lista;
	}

	public void addTitularizacao(Titularizacao titularizacao) {
		this.titularizacao.add(titularizacao);
		fireTableDataChanged();
	}

	public void removerTitularizacao(int rowIndex) {
		this.titularizacao.remove(rowIndex);
		fireTableDataChanged();
	}

	public Titularizacao getTitularizacao(int rowIndex) {
		return this.titularizacao.get(rowIndex);
	}

	@Override
	public int getColumnCount() {
		return this.colunas.length;
	}

	@Override
	public int getRowCount() {
		return this.titularizacao.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return this.titularizacao.get(rowIndex).getCodigo();
		case 1:
			return this.titularizacao.get(rowIndex).getTitulo();
		default:
			return this.titularizacao.get(rowIndex);
		}
	}

	@Override
	public String getColumnName(int column) {
		return this.colunas[column];
	}

}
