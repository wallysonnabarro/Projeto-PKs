package br.sasclient.model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import br.sasclient.entity.Tela;

public class JtableModelNomesPrefixos extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Tela> listaNomePrefixos;
	private String[] colunas = { "CÓDIGO", "NOME", "PREFIXO" };

	public JtableModelNomesPrefixos(ArrayList<Tela> lista) {
		this.listaNomePrefixos = lista;
	}

	public void addNomesPrefixos(Tela nomePrefixo) {
		this.listaNomePrefixos.add(nomePrefixo);
		fireTableDataChanged();
	}

	public void removerNomesPrefixos(int rowIndex) {
		this.listaNomePrefixos.remove(rowIndex);
		fireTableDataChanged();
	}

	public Tela getNomesPrefixos(int rowIndex) {
		return this.listaNomePrefixos.get(rowIndex);
	}

	@Override
	public int getColumnCount() {
		return this.colunas.length;
	}

	@Override
	public int getRowCount() {
		return this.listaNomePrefixos.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return this.listaNomePrefixos.get(rowIndex).getCodigo_colaborador();
		case 1:
			return this.listaNomePrefixos.get(rowIndex).getColaborador();
		case 2:
			return this.listaNomePrefixos.get(rowIndex).getPrefixo();
		default:
			return this.listaNomePrefixos.get(rowIndex);
		}
	}

	@Override
	public String getColumnName(int column) {
		return this.colunas[column];
	}

}
