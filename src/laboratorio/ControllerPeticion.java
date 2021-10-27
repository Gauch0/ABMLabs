package laboratorio;

import java.util.ArrayList;

import collections.Documento_Peticiones;

public class ControllerPeticion {
	
	private Documento_Peticiones doc_Peticiones;
	
	public ControllerPeticion() {
		doc_Peticiones = new Documento_Peticiones();
	}
	
	public void crearPeticion(String nombrePaciente, String obraSocial, String fechaCarga, String practicasAsociadas, String fechaEntrega,String sucursal)	{
		Peticion peticion = new Peticion();
		peticion.setNombre(nombrePaciente);
		peticion.setObraSocial(obraSocial);
		peticion.setFechaCarga(fechaCarga);
		peticion.setPracticasAsociadas(practicasAsociadas);
		peticion.setFechaEntrega(fechaEntrega);
		peticion.setSucursal(sucursal);
		doc_Peticiones.agregarPeticion(peticion);
	}
	
	public Peticion leerPeticion(int index) {
		return doc_Peticiones.leerPeticion(index);
	}
	
	public void eliminarPeticion(int index) {
		doc_Peticiones.eliminarPeticion(index);
	}
	
	public void modificarPeticion(String nombrePaciente, String obraSocial, String fechaCarga, String practicasAsociadas, String fechaEntrega,int index) {
		doc_Peticiones.modificarPeticion(nombrePaciente, obraSocial, fechaCarga, practicasAsociadas, fechaEntrega,index);
	}
	
	public void cambiarSucursal(String sucursalOrigen,String sucursalDestino) {
		doc_Peticiones.cambiarSucursal(sucursalOrigen,sucursalDestino);
	}
}
