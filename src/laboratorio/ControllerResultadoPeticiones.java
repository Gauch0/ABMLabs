package laboratorio;

import java.util.ArrayList;

import collections.Documento_ResultadoPeticiones;

public class ControllerResultadoPeticiones {
	
	Documento_ResultadoPeticiones doc_ResultadoPeticiones;
	
	public ControllerResultadoPeticiones() {
		doc_ResultadoPeticiones = new Documento_ResultadoPeticiones();
	}
	
	public void crearResultadoPeticiones(ResultadoPeticion nuevoResultadoPeticion) {
		doc_ResultadoPeticiones.crearResultadoPeticion(nuevoResultadoPeticion);
	}
	
	public void eliminarResultadoPeticion(int index) {
		doc_ResultadoPeticiones.eliminarResultadoPeticion(index);
	}
}
