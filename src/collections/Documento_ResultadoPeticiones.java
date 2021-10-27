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



public class Documento_ResultadoPeticiones {

		private ArrayList<ResultadoPeticion> listaResultadoPeticiones;
		
		public Documento_ResultadoPeticiones() {
			listaResultadoPeticiones = leer();
		}
		
		public void crearResultadoPeticion(ResultadoPeticion resultadoPeticion) {					//DIFERENTE A LO QUE HIZO EL PROF 
			listaResultadoPeticiones.add(resultadoPeticion);
			this.grabar();
		}
		
		
	
		public void grabar() {
			File archivo = new File("./resultadoPeticiones.txt");
			FileWriter fileWriter; 
			BufferedWriter bwEscritor; 
			String texto;
			Gson g = new Gson();
			texto = g.toJson(listaResultadoPeticiones);
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
		
	    private ArrayList<ResultadoPeticion> leer() {
	    	ArrayList<ResultadoPeticion> resultadoPeticiones= new ArrayList<ResultadoPeticion>();
	        String cadena;
	        File archivo = new File("./resultadoPeticiones.txt");
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
	    	        	resultadoPeticiones.add(g.fromJson(js, ResultadoPeticion.class));
	    	        
	    	        b.close();
	    	        
	    	        //for(Object o : aux)
	    	        //	scores.add((Score) o);
	    	        return resultadoPeticiones;
	    		} catch (IOException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		}
	        }
			return resultadoPeticiones;
			
	    }

		public ArrayList<ResultadoPeticion> getResultadoPeticionesList() {
			return listaResultadoPeticiones;
		}
		
		public ResultadoPeticion leerResultadoPeticion(int index) {
			return listaResultadoPeticiones.get(index);
		}
		
		public void modificarResultadoPeticion(int numero,String direccion,String tecnico,int index) {
			ResultadoPeticion aux = new ResultadoPeticion();
			this.grabar();
		}
		
		public void eliminarResultadoPeticion(int index) {
//			int i;
//			for(i = index + 1 ; i<listaSucursales.size();i++) {
//
//				listaSucursales.set(i-1, listaSucursales.get(i));
//
//			}
//			listaSucursales.remove(i-1);
			listaResultadoPeticiones.remove(index);
			this.grabar();
		}
		
}
