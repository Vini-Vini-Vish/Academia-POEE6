package com.academia.view.aluno;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import com.academia.model.models.Aluno;

public class TableaAlunoModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 8605435518955809393L;
	
	private final String colunas[] = {"Codigo", "Nome","Genero","Idade", "Endereço", "Numero", "Bairro", "Cidade", "Telefone", "Codigo-Postal", "Periodo"};

	private static final int CODIGO = 0;
	private static final int NOME = 1;
	private static final int GENERO = 2;
	private static final int IDADE = 3;
	private static final int ENDERECO = 4;
	private static final int NUMERO = 5;
	private static final int BAIRRO = 6;
	private static final int CIDADE = 7;
	private static final int TELEFONE = 8;
	private static final int CODIGOPOSTAL = 9;
	private static final int PERIODO = 10;
	
	//-----------------------------------------------------------------//
	
	private List<Aluno> listaAluno;
	
	public List<Aluno> getListaAluno() {
		return listaAluno;
	}

	public void setListaAluno(List<Aluno> ListaAluno) {
		this.listaAluno = ListaAluno;
	}
	
	//-----------------------------------------------------------------//	
	
	public Aluno getAluno(int rowIndex) {
		return getListaAluno().get(rowIndex);
	}
	
	//-----------------------------------------------------------------//	
	
	public void saveAluno(Aluno aluno) {
		getListaAluno().add(aluno);
		fireTableRowsInserted(getRowCount()-1, getColumnCount()-1);
	}
	
	//-----------------------------------------------------------------//	
	
	public void updateAluno(Aluno aluno, int rowIndex) {
		getListaAluno().set(rowIndex, aluno);
		fireTableRowsInserted(rowIndex, rowIndex);
	}	
	
	//-----------------------------------------------------------------//	
	
	public void removeAluno(int rowIndex) {
		getListaAluno().remove(rowIndex);
		fireTableRowsInserted(rowIndex, rowIndex);
	}	
	
	//-----------------------------------------------------------------//	
	
	public void removeAll() {
		getListaAluno().clear();
		fireTableDataChanged();
	}	
		
	//-----------------------------------------------------------------//
	
	@Override
	public int getRowCount() {
		return getListaAluno().size();
	}

	//-----------------------------------------------------------------//
	
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
		
		Aluno aluno = getListaAluno().get(rowIndex);
		
		switch(columnIndex) {
		case CODIGO:
			return  aluno.getIdAluno();
		case NOME:
			return aluno.getName();
		case GENERO:
			return aluno.getGender();
		case IDADE:
			return aluno.getAge();
		case ENDERECO:
			return aluno.getAdress();
		case NUMERO:
			return aluno.getNumber();
		case BAIRRO:
			return aluno.getNeighborhood();
		case CIDADE:
			return aluno.getCity();
		case TELEFONE:
			return aluno.getTelephone();
		case CODIGOPOSTAL:
			return aluno.getPostal_code();
		case PERIODO:
			return aluno.getPeriod();
		default:
			return aluno;
		}
		
	}
	
	//-----------------------------------------------------------------//	
	
	public Class<?> getColumnClass(int columnIndex){
		
		switch(columnIndex) {
		case CODIGO:
			return  Integer.class;
		case NOME:
			return String.class;
		case GENERO:
			return String.class;
		case IDADE:
			return Integer.class;
		case ENDERECO:
			return String.class;
		case NUMERO:
			return Integer.class;
		case BAIRRO:
			return String.class;
		case CIDADE:
			return String.class;
		case TELEFONE:
			return Integer.class;
		case CODIGOPOSTAL:
			return Integer.class;
		case PERIODO:
			return String.class;
		default:
			return null;	
		}		
	}	

}
