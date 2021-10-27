package tablesModel;

import java.sql.Date;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import collections.*;
import laboratorio.ResultadoPeticion;
import laboratorio.Sucursal;

public class TableModelResultadoPeticiones extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<ResultadoPeticion> lista;
	
	protected String[] columnNames = new String[] { "Nombre","Apellido","Obra social","Fecha de nacimiento","Diagnostico"}; 
	protected Class[] columnClasses = new Class[] { String.class, String.class, String.class, String.class, String.class }; 


	public String getColumnName(int col) { return columnNames[col]; } 
	public Class getColumnClass(int col) { return columnClasses[col]; } 
	
	public TableModelResultadoPeticiones(Documento_ResultadoPeticiones doc_ResultadoPeticiones)
	{
		lista = doc_ResultadoPeticiones.getResultadoPeticionesList();
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
			case 1: return lista.get(rowIndex).getApellido();
			case 2: return lista.get(rowIndex).getObraSocial();
			case 3: return lista.get(rowIndex).getFechaNac();
			case 4: return lista.get(rowIndex).getDiagnostico();
			default: return null; 
		}
	}
	
	public void agregar(ResultadoPeticion resultadoPeticion)
	{
		lista.add(resultadoPeticion);
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
	
	public void eliminar(ResultadoPeticion resultadoPeticion)
	{
		eliminar(lista.indexOf(resultadoPeticion));
	}	

}
