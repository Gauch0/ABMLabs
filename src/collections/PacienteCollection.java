package collections;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dto.PacienteDTO;



public class PacienteCollection {
	
	private ArrayList<PacienteDTO> datos;
	
	public PacienteCollection()
	{
		datos = leer();
		
	}
	public ArrayList<PacienteDTO> getPacientesList()
	{
		return datos;
	}
	public PacienteDTO getPaciente(int index)
	{
		return datos.get(index);
	}
	
	public void addDemoData()
	{
		for (int i=0; i<100; i++)
			datos.add(new PacienteDTO("ID: "+Integer.valueOf(i),
									"Nombre: " + String.valueOf(i),
									"DNI: " + String.valueOf(i),
									"Domicilio: " + String.valueOf(i),
									"Email: "+ String.valueOf(i),
									"Sexo: "+ String.valueOf(i),
									"Edad: "+ String.valueOf(i)));
	}
	
	
	public void grabar() {
		
		File archivo = new File("./pacientes.txt");
		FileWriter fileWriter; 
		BufferedWriter bwEscritor; 
		String texto;
		Gson g = new Gson();
		texto = g.toJson(datos);

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
	
    private ArrayList<PacienteDTO> leer() {
    	ArrayList<PacienteDTO> paciente = new ArrayList<PacienteDTO>();
        String cadena;
        File archivo = new File("./pacientes.txt");
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
    	        	paciente.add(g.fromJson(js, PacienteDTO.class));
    	        
    	        b.close();
    	        
    	        //for(Object o : aux)
    	        //	scores.add((Score) o);
    	        return paciente;
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        }
		return paciente;
		
    }
	
}

