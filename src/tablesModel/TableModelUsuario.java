package tablesModel;

import java.sql.Date;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import collections.*;
import laboratorio.*;

public class TableModelUsuario extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<Usuario> lista;
	
	protected String[] columnNames = new String[] { "Id","Nombre","DNI","Fecha de Nacimiento","Email","Domicilio"}; 
	protected Class[] columnClasses = new Class[] { String.class, String.class, int.class, String.class , String.class , String.class }; 

	public String getColumnName(int col) { return columnNames[col]; } 
	public Class getColumnClass(int col) { return columnClasses[col]; } 
	
	public TableModelUsuario(Documento_Usuarios doc_Usuarios)
	{
		lista = doc_Usuarios.getUsuariosList();
	}
	
	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return lista.size();
	}
	
    public boolean isCellEditable(int row, int column)
    {
    	return false;
    }
    
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex) 
		{ 
			case 0: return lista.get(rowIndex).getIdUsuario();
			case 1: return lista.get(rowIndex).getNombre();
			case 2: return lista.get(rowIndex).getDni();
			case 3: return lista.get(rowIndex).getFechaNac(); 
			case 4: return lista.get(rowIndex).getEmail();
			case 5: return lista.get(rowIndex).getDomicilio();
			default: return null; 
		}
	}

	
	public void agregar(Usuario usuario)
	{
		lista.add(usuario);
		fireTableDataChanged();
	}
	
	public void refresh() {
		fireTableDataChanged();
	}
	
	public void eliminar(int fila)
	{
		lista.remove(fila);
		fireTableDataChanged();
	}
	
	public void eliminar(Usuario usuario)
	{
		eliminar(lista.indexOf(usuario));
	}	

}
