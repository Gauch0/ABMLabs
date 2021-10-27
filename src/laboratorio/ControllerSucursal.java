package laboratorio;

import java.util.ArrayList;
import collections.*;

public class ControllerSucursal {

	private Documento_Sucursales documentoSucursales;

	public ControllerSucursal() {
		documentoSucursales = new Documento_Sucursales();
	}
	
	public void crearSucursal(int numero, String direccion,String tecnico) {
		Sucursal sucursal_Nueva	= new Sucursal();
		sucursal_Nueva.setNumero(numero);
		sucursal_Nueva.setDireccion(direccion);
		sucursal_Nueva.setTecnico(tecnico);
		documentoSucursales.agregarSucursal(sucursal_Nueva);
	}
	
	public Sucursal leerSucursal(int index) {
		return documentoSucursales.leerSucursal(index);
	}
	
	public void modificarSucursal(int numero,String direccion,String tecnico,int index) {
		documentoSucursales.modificarSucursal(numero, direccion, tecnico, index);
	}
	
	public void eliminarSucursal(int index) {
		documentoSucursales.eliminarSucursal(index);
	}
	
}
