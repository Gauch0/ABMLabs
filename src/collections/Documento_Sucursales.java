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



public class Documento_Sucursales {

		private ArrayList<Sucursal> listaSucursales;
		
		public Documento_Sucursales() {
			listaSucursales = leer();
		}
		
		public void agregarSucursal(Sucursal sucursal) {					//DIFERENTE A LO QUE HIZO EL PROF 
			listaSucursales.add(sucursal);
			this.grabar();
		}
		
		
	
		public void grabar() {
			File archivo = new File("./sucursales.txt");
			FileWriter fileWriter; 
			BufferedWriter bwEscritor; 
			String texto;
			Gson g = new Gson();
			texto = g.toJson(listaSucursales);
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
		
	    private ArrayList<Sucursal> leer() {
	    	ArrayList<Sucursal> sucursales= new ArrayList<Sucursal>();
	        String cadena;
	        File archivo = new File("./sucursales.txt");
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
	    	        	sucursales.add(g.fromJson(js, Sucursal.class));
	    	        
	    	        b.close();
	    	        
	    	        //for(Object o : aux)
	    	        //	scores.add((Score) o);
	    	        return sucursales;
	    		} catch (IOException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		}
	        }
			return sucursales;
			
	    }

		public ArrayList<Sucursal> getSucursalesList() {
			return listaSucursales;
		}
		
		public Sucursal leerSucursal(int index) {
			return listaSucursales.get(index);
		}
		
		public void modificarSucursal(int numero,String direccion,String tecnico,int index) {
			Sucursal aux = new Sucursal();
			aux.setDireccion(direccion);
			aux.setNumero(numero);
			aux.setTecnico(tecnico);
			listaSucursales.set(index, aux);
			this.grabar();
		}
		
		public void eliminarSucursal(int index) {
//			int i;
//			for(i = index + 1 ; i<listaSucursales.size();i++) {
//
//				listaSucursales.set(i-1, listaSucursales.get(i));
//
//			}
//			listaSucursales.remove(i-1);
			listaSucursales.remove(index);
			this.grabar();
		}
		
}
