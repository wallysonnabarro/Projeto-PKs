package br.sasclient.model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import br.sasclient.entity.DescricaoEnty;

public class JtableModelDescricao extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<DescricaoEnty> listaDescricao;
	private String[] colunas = { "Descrição", "Data" };

	public JtableModelDescricao(ArrayList<DescricaoEnty> lista) {
		this.listaDescricao = lista;
	}

	public void addDescricao(DescricaoEnty descricao) {
		this.listaDescricao.add(descricao);
		fireTableDataChanged();
	}

	public void removerDescricao(int rowIndex) {
		this.listaDescricao.remove(rowIndex);
		fireTableDataChanged();
	}

	public DescricaoEnty getDescricao(int rowIndex) {
		return this.listaDescricao.get(rowIndex);
	}

	@Override
	public int getColumnCount() {
		return this.colunas.length;
	}

	@Override
	public int getRowCount() {
		return this.listaDescricao.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return this.listaDescricao.get(rowIndex).getDescricao();
		case 1:
			return this.listaDescricao.get(rowIndex).getData() + " " + this.listaDescricao.get(rowIndex).getHora();
		default:
			return this.listaDescricao.get(rowIndex);
		}
	}

	@Override
	public String getColumnName(int column) {
		return this.colunas[column];
	}

}
