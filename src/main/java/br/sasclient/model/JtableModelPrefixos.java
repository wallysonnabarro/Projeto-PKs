package br.sasclient.model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import br.sasclient.entity.Prefixo;

public class JtableModelPrefixos extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Prefixo> listaPrefixo;
	private String CODIGO = "CÓDIGO";
	private String PREFIXO = "PREFIXO";
	private String[] colunas = { CODIGO,  PREFIXO};

	public JtableModelPrefixos(ArrayList<Prefixo> lista) {
		this.listaPrefixo = lista;
	}

	public void addPrefixo(Prefixo prefixo) {
		this.listaPrefixo.add(prefixo);
		fireTableDataChanged();
	}

	public void removerPrefixo(int rowIndex) {
		this.listaPrefixo.remove(rowIndex);
		fireTableDataChanged();
	}

	public Prefixo getPrefixo(int rowIndex) {
		return this.listaPrefixo.get(rowIndex);
	}

	@Override
	public int getColumnCount() {
		return this.colunas.length;
	}

	@Override
	public int getRowCount() {
		return this.listaPrefixo.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return this.listaPrefixo.get(rowIndex).getCodigo();
		case 1:
			return this.listaPrefixo.get(rowIndex).getPrefixo();
		default:
			return this.listaPrefixo.get(rowIndex);
		}
	}

	@Override
	public String getColumnName(int column) {
		return this.colunas[column];
	}

}
