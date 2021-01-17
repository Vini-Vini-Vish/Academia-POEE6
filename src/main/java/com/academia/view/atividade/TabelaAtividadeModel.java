package com.academia.view.atividade;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import com.academia.model.models.Atividade;

public class TabelaAtividadeModel extends AbstractTableModel {

	private static final long serialVersionUID = -1936332370194488570L;

	private final String colunas[] = {"Codigo", "Nome","Descricao"};

	private static final int CODIGO = 0;
	private static final int NOME = 1;
	private static final int DESCRICAO = 2;

	//-----------------------------------------------------------------//
	
	private List<Atividade> listaAtividade;
	
	public List<Atividade> getListaAtividade() {
		return listaAtividade;
	}

	public void setListaAtividade(List<Atividade> ListaAtividade) {
		this.listaAtividade = ListaAtividade;
	}
	
	//-----------------------------------------------------------------//	
	
	public Atividade getAtividade(int rowIndex) {
		return getListaAtividade().get(rowIndex);
	}
	
	//-----------------------------------------------------------------//	
	
	public void saveAtividade(Atividade atividade) {
		getListaAtividade().add(atividade);
		fireTableRowsInserted(getRowCount()-1, getColumnCount()-1);
	}	
	
	//-----------------------------------------------------------------//	
	
	public void updateAtividade(Atividade atividade, int rowIndex) {
		getListaAtividade().set(rowIndex, atividade);
		fireTableRowsInserted(rowIndex, rowIndex);
	}	
	
	//-----------------------------------------------------------------//	
	
	public void removeAtividade(int rowIndex) {
		getListaAtividade().remove(rowIndex);
		fireTableRowsInserted(rowIndex, rowIndex);
	}	
	
	//-----------------------------------------------------------------//	
	
	public void removeAll() {
		getListaAtividade().clear();
		fireTableDataChanged();
	}	
		
	//-----------------------------------------------------------------//	
	
	@Override
	public int getRowCount() {
		return getListaAtividade().size();
	}

	@Override
	public int getColumnCount() {
		return getColunas().length;
	}
	
	//-----------------------------------------------------------------//
	
	public String[] getColunas() {
		return colunas;
	}
	
	//-----------------------------------------------------------------//	
	
	public String getColumnName(int columnIndex) {
		return colunas[columnIndex];
	}			
	
	//-----------------------------------------------------------------//

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		Atividade atividade = getListaAtividade().get(rowIndex);
		
		switch(columnIndex) {
		case CODIGO:
			return atividade.getIdAtividade();
		case NOME:
			return atividade.getNome();
		case DESCRICAO:
			return atividade.getDescricao();
		default:
			return atividade;
		}
		
	}
	
	//-----------------------------------------------------------------//
	
	public Class<?> getColumnClass(int columnIndex){
		
		switch(columnIndex) {
		case CODIGO:
			return Integer.class;
		case NOME:
			return String.class;
		case DESCRICAO:
			return String.class;		
		default:
			return null;	
		}		
		
	}

}
