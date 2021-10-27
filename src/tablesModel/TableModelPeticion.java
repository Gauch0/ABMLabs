package tablesModel;

import java.sql.Date;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import collections.*;
import laboratorio.Peticion;
import laboratorio.Sucursal;

public class TableModelPeticion extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<Peticion> lista;
	
	protected String[] columnNames = new String[] { "Paciente","Obra Social","Carga","Practicas","Entrega"}; 
	protected Class[] columnClasses = new Class[] { String.class, String.class, String.class, String.class, String.class }; 


	public String getColumnName(int col) { return columnNames[col]; } 
	public Class getColumnClass(int col) { return columnClasses[col]; } 
	
	public TableModelPeticion(Documento_Peticiones doc_Peticiones)
	{
		lista = doc_Peticiones.getSucursalesList();
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
			case 0: return lista.get(rowIndex).getNombre();
			case 1: return lista.get(rowIndex).getObraSocial();
			case 2: return lista.get(rowIndex).getFechaCarga();
			case 3: return lista.get(rowIndex).getPracticasAsociadas();
			case 4: return lista.get(rowIndex).getFechaEntrega();
			default: return null; 
		}
	}
	
	public void agregar(Peticion peticion)
	{
		lista.add(peticion);
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
	
	public void eliminar(Peticion peticion)
	{
		eliminar(lista.indexOf(peticion));
	}	

}
