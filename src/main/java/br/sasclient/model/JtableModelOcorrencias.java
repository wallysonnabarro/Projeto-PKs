package br.sasclient.model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import br.sasclient.entity.Ocorrencia;

public class JtableModelOcorrencias extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Ocorrencia> listaOcorrencias;
	private String[] colunas = { "ID","NOMES", "GRUPO", "STATUS" };

	public JtableModelOcorrencias(ArrayList<Ocorrencia> lista) {
		this.listaOcorrencias = lista;
	}

	public void addOcorrencias(Ocorrencia ocorrencia) {
		this.listaOcorrencias.add(ocorrencia);
		fireTableDataChanged();
	}

	public void removerOcorrencias(int rowIndex) {
		this.listaOcorrencias.remove(rowIndex);
		fireTableDataChanged();
	}

	public Ocorrencia getOcorrencias(int rowIndex) {
		return this.listaOcorrencias.get(rowIndex);
	}

	@Override
	public int getColumnCount() {
		return this.colunas.length;
	}

	@Override
	public int getRowCount() {
		return this.listaOcorrencias.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return this.listaOcorrencias.get(rowIndex).getId();
		case 1:
			return this.listaOcorrencias.get(rowIndex).getNome();
		case 2:
			return this.listaOcorrencias.get(rowIndex).getGrupo();
		case 3:
			if(this.listaOcorrencias.get(rowIndex).getInativo() == 0) {
				return "Ativo";
			} else {
				return "Inativo";
			}
		default:
			return this.listaOcorrencias.get(rowIndex);
		}
	}

	@Override
	public String getColumnName(int column) {
		return this.colunas[column];
	}

}
