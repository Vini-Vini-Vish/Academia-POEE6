package com.academia.view.dadosusuario.usuario;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.academia.model.models.user.Usuario;

public class TabelaUsuarioModel extends AbstractTableModel {

	private static final long serialVersionUID = -3249419325577092060L;

	private final String colunas[] = {"Código","Nome","E-mail"};
	
	private static final int CODIGO = 0;
	private static final int NOME = 1;
	private static final int EMAIL = 2;
	
	//-----------------------------------------------------------------//	
	
	private List<Usuario> listaUsuario;
			
	public List<Usuario> getListaUsuario() {
		return listaUsuario;
	}

	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}
	
	//-----------------------------------------------------------------//	
		
	public Usuario getUsuario(int rowIndex) {
		return getListaUsuario().get(rowIndex);
	}
	
	//-----------------------------------------------------------------//	
	
	public void saveUsuario(Usuario usuario) {
		getListaUsuario().add(usuario);
		fireTableRowsInserted(getRowCount()-1, getColumnCount()-1);
	}
	
	//-----------------------------------------------------------------//	
	
	public void updateUsuario(Usuario usuario, int rowIndex) {
		getListaUsuario().set(rowIndex, usuario);
		fireTableRowsInserted(rowIndex, rowIndex);
	}	
	
	//-----------------------------------------------------------------//	
	
	public void removeUsuario(int rowIndex) {
		getListaUsuario().remove(rowIndex);
		fireTableRowsInserted(rowIndex, rowIndex);
	}	
	
	//-----------------------------------------------------------------//	
	
	public void removeAll() {
		getListaUsuario().clear();
		fireTableDataChanged();
	}	
	
	//-----------------------------------------------------------------//	
	
	@Override
	public int getRowCount() {
		return getListaUsuario().size();
	}	

	@Override
	public int getColumnCount() {
		return getColunas().length;
	}	
	
	//-----------------------------------------------------------------//	
	
	public String getColumnName(int columnIndex) {
		return colunas[columnIndex];
	}
	
	//-----------------------------------------------------------------//	
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		Usuario usuario = getListaUsuario().get(rowIndex);
		
		switch(columnIndex) {
		case CODIGO:
			return  usuario.getId();
		case NOME:
			return usuario.getUsername();
		case EMAIL:
			return usuario.getEmail();
		default:
			return usuario;
		}
	}	
	
	//-----------------------------------------------------------------//	
	
	public Class<?> getColumnClass(int columnIndex){
		switch(columnIndex) {
		case CODIGO:
			return  Integer.class;
		case NOME:
			return String.class;
		case EMAIL:
			return String.class;
		default:
			return null;
		}		
	}	
	
	//-----------------------------------------------------------------//	

	public String[] getColunas() {
		return colunas;
	}

}
