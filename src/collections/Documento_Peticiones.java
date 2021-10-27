package collections;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import laboratorio.*;;



public class Documento_Peticiones {

		private ArrayList<Peticion> listaPeticiones;
		
		public Documento_Peticiones() {
			listaPeticiones = leer();
		}
		
		public void agregarPeticion(Peticion peticion) {
			listaPeticiones.add(peticion);
			this.grabar();
		}
		
		
	
		public void grabar() {
			File archivo = new File("./peticiones.txt");
			FileWriter fileWriter; 
			BufferedWriter bwEscritor; 
			String texto;
			Gson g = new Gson();
			texto = g.toJson(listaPeticiones);
			//grabo el String
			try{
				//Este bloque de codigo obligatoriamente debe ir dentro de un try.
				fileWriter = new FileWriter(archivo);
				fileWriter.write(texto);
				bwEscritor = new BufferedWriter(fileWriter);
				bwEscritor.close();		
			}catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null,ex.getMessage());
			}
		}
		
	    private ArrayList<Peticion> leer() {
	    	ArrayList<Peticion> peticiones= new ArrayList<Peticion>();
	        String cadena;
	        File archivo = new File("./peticiones.txt");
	        if (archivo.exists())
	        {
	            FileReader f;
	    		try {
	    			f = new FileReader(archivo);
	    	        BufferedReader b = new BufferedReader(f);
	    	        cadena = b.readLine();
	    	        System.out.println(cadena);
	    	        JsonParser parser = new JsonParser();
	    	        JsonArray gsonArr = parser.parse(cadena).getAsJsonArray();
	    	        Gson g = new Gson();
	    	        for(JsonElement js : gsonArr) //System.out.println(js.toString());
	    	        	peticiones.add(g.fromJson(js, Peticion.class));
	    	        
	    	        b.close();
	    	        
	    	        //for(Object o : aux)
	    	        //	scores.add((Score) o);
	    	        return peticiones;
	    		} catch (IOException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		}
	        }
			return peticiones;
			
	    }

		public ArrayList<Peticion> getSucursalesList() {
			return listaPeticiones;
		}
		
		public Peticion leerPeticion(int index) {
			return listaPeticiones.get(index);
		}
		
//		
		public void eliminarPeticion(int index) {
			int i;
			for(i = index + 1 ; i<listaPeticiones.size();i++) {

				listaPeticiones.set(i-1, listaPeticiones.get(i));

			}
			listaPeticiones.remove(i-1);
			this.grabar();
		}
		
		public void modificarPeticion(String nombrePaciente, String obraSocial, String fechaCarga, String practicasAsociadas, String fechaEntrega,int index) {
			Peticion aux = new Peticion();
			aux.setNombre(nombrePaciente);
			aux.setObraSocial(obraSocial);
			aux.setFechaCarga(fechaCarga);
			aux.setPracticasAsociadas(practicasAsociadas);
			aux.setFechaEntrega(fechaEntrega);
			
			listaPeticiones.set(index, aux);
			this.grabar();
		}
		
		public void cambiarSucursal(String sucursalOrigen,String sucursalDestino) {
			for(Peticion i:listaPeticiones) {
				if(i.getSucursal().equals(sucursalOrigen)) {
					i.setSucursal(sucursalDestino);
					this.grabar();
					System.out.println("GRABADO: " + i.getSucursal());
				}
			}
		}
}
