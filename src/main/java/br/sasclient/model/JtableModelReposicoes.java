package br.sasclient.model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import br.sasclient.entity.Reposicoes;

public class JtableModelReposicoes extends AbstractTableModel  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Reposicoes> listaReposicoes;
	private String[] colunas = { "Nome", "Local", "Data", "Departamento", "Tipo", "Terceirizado" };

	
	
	public JtableModelReposicoes(ArrayList<Reposicoes> listaReposicoes) {
		this.listaReposicoes = listaReposicoes;
	}

	public void addReposicoes(Reposicoes reposicoes) {
		this.listaReposicoes.add(reposicoes);
		fireTableDataChanged();
	}

	public void removerReposicoes(int rowIndex) {
		this.listaReposicoes.remove(rowIndex);
		fireTableDataChanged();
	}

	public Reposicoes getReposicoes(int rowIndex) {
		return this.listaReposicoes.get(rowIndex);
	}

	@Override
	public int getColumnCount() {
		return this.colunas.length;
	}

	@Override
	public int getRowCount() {
		return this.listaReposicoes.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		String aux = "";
		switch (columnIndex) {
		case 0:
			return this.listaReposicoes.get(rowIndex).getNome();
		case 1:
			return this.listaReposicoes.get(rowIndex).getLocal();
		case 2:
			return this.listaReposicoes.get(rowIndex).getData();
		case 3:
			if(this.listaReposicoes.get(rowIndex).getDepartamento() == 1) {
				aux = "Banco de Horas";
			} else if(this.listaReposicoes.get(rowIndex).getDepartamento() == 2) {
				aux = "GEOP";
			} else {
				aux = "MKT";
			}
			return aux;
		case 4:
			if(this.listaReposicoes.get(rowIndex).getTipo() == 1) {
				aux = "Falta";
			} else {
				aux = "Atraso";
			}
			return aux;
		case 5:
			if(this.listaReposicoes.get(rowIndex).getEsp() == 1) {
				aux = "Vigilância";
			} else {
				aux = "Especializada";
			}
			return aux;
		default:
			return this.listaReposicoes.get(rowIndex);
		}
	}

	@Override
	public String getColumnName(int column) {
		return this.colunas[column];
	}

}
