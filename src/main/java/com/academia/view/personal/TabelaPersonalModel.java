package com.academia.view.personal;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import com.academia.model.models.Personal;

public class TabelaPersonalModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 1815530548014653912L;

	private final String colunas[] = {"Codigo", "Nome","Genero","Idade", "Endereço", "Numero", "Bairro", "Cidade", "Telefone", "Codigo-Postal", "Periodo", "Cref"};

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
	private static final int CREF = 11;
	
	//-----------------------------------------------------------------//	
	
	private List<Personal> listaPersonal;
	
	public List<Personal> getListaPersonal() {
		return listaPersonal;
	}

	public void setListaPersonal(List<Personal> ListaPersonal) {
		this.listaPersonal = ListaPersonal;
	}
	
	//-----------------------------------------------------------------//	
	
	public Personal getPersonal(int rowIndex) {
		return getListaPersonal().get(rowIndex);
	}

	//-----------------------------------------------------------------//	
	
	public void savePersonal(Personal personal) {
		getListaPersonal().add(personal);
		fireTableRowsInserted(getRowCount()-1, getColumnCount()-1);
	}
	
	//-----------------------------------------------------------------//	
	
	public void updatePersonal(Personal personal, int rowIndex) {
		getListaPersonal().set(rowIndex, personal);
		fireTableRowsInserted(rowIndex, rowIndex);
	}		
	
	//-----------------------------------------------------------------//	
	
	public void removePersonal(int rowIndex) {
		getListaPersonal().remove(rowIndex);
		fireTableRowsInserted(rowIndex, rowIndex);
	}	
	
	//-----------------------------------------------------------------//	
	
	public void removeAll() {
		getListaPersonal().clear();
		fireTableDataChanged();
	}	

	//-----------------------------------------------------------------//

	@Override
	public int getRowCount() {
		return getListaPersonal().size();
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
		
		Personal personal = getListaPersonal().get(rowIndex);

		switch(columnIndex) {
		case CODIGO:
			return  personal.getIdpersonal();
		case NOME:
			return personal.getName();
		case GENERO:
			return personal.getGender();
		case IDADE:
			return personal.getAge();
		case ENDERECO:
			return personal.getAdress();
		case NUMERO:
			return personal.getNumber();
		case BAIRRO:
			return personal.getNeighborhood();
		case CIDADE:
			return personal.getCity();
		case TELEFONE:
			return personal.getTelephone();
		case CODIGOPOSTAL:
			return personal.getCodeposte();
		case PERIODO:
			return personal.getPeriod();
		default:
			return personal;
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
		case CREF:
			return Integer.class;
		default:
			return null;	
		}	
		
	}

}
