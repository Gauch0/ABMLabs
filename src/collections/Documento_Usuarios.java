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



public class Documento_Usuarios {

		private ArrayList<Usuario> listaUsuarios;
		
		public Documento_Usuarios() {
			listaUsuarios= leer();
		}
		
		public void agregarUsuario(Usuario usuario) {					//DIFERENTE A LO QUE HIZO EL PROF 
			listaUsuarios.add(usuario);
			this.grabar();
		}
		
		
	
		public void grabar() {
			File archivo = new File("./usuarios.txt");
			FileWriter fileWriter; 
			BufferedWriter bwEscritor; 
			String texto;
			Gson g = new Gson();
			texto = g.toJson(listaUsuarios);
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
		
	    private ArrayList<Usuario> leer() {
	    	ArrayList<Usuario> usuarios= new ArrayList<Usuario>();
	        String cadena;
	        File archivo = new File("./usuarios.txt");
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
	    	        	usuarios.add(g.fromJson(js, Usuario.class));
	    	        
	    	        b.close();
	    	        
	    	        //for(Object o : aux)
	    	        //	scores.add((Score) o);
	    	        return usuarios;
	    		} catch (IOException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		}
	        }
			return usuarios;
			
	    }

		public ArrayList<Usuario> getUsuariosList() {
			return listaUsuarios;
		}
		
		public Usuario getUsuario(int index) {
			return listaUsuarios.get(index);
		}
		
		public void modificarUsuario(String nombre,String id,String domicilio, String email,String fechaNac,int dni,int index) {
			Usuario aux = new Usuario();
			aux.setDni(dni);
			aux.setDomicilio(domicilio);
			aux.setEmail(email);
			aux.setFechaNac(fechaNac);
			aux.setIdUsuario(id);
			aux.setNombre(nombre);
			listaUsuarios.set(index,aux );
			this.grabar();
		}
		
		public void eliminarUsuario(int index) {
			int i;
			for(i = index +1 ; i<listaUsuarios.size();i++) {
				listaUsuarios.set(i-1, listaUsuarios.get(i));
			}

			listaUsuarios.remove(i-1);
			this.grabar();
		}
}
