package tablesModel;

import java.sql.Date;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import collections.*;
import laboratorio.Sucursal;

public class TableModelSucursal extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<Sucursal> lista;
	
	protected String[] columnNames = new String[] { "Numero","Direccion","Tecnico"}; 
	protected Class[] columnClasses = new Class[] { int.class, String.class, String.class }; 


	public String getColumnName(int col) { return columnNames[col]; } 
	public Class getColumnClass(int col) { return columnClasses[col]; } 
	
	public TableModelSucursal(Documento_Sucursales doc_Sucursales)
	{
		lista = doc_Sucursales.getSucursalesList();
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
			case 0: return lista.get(rowIndex).getNumero(); 
			case 1: return lista.get(rowIndex).getDireccion();
			case 2: return lista.get(rowIndex).getTecnico();
			default: return null; 
		}
	}
	
	public void agregar(Sucursal sucursal)
	{
		lista.add(sucursal);
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
	
	public void eliminar(Sucursal sucursal)
	{
		eliminar(lista.indexOf(sucursal));
	}	

}
