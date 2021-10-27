package laboratorio;

public class Usuario {

	private String idUsuario;
	private String nombre;
	private int dni;
	private String fechaNac;
	private String email;
	private String domicilio;
	
	public Usuario() {
		idUsuario = "";
		nombre = "";
		dni = 0;
		fechaNac = "";
		email = "";
		domicilio = "";
	}
	
	public String getIdUsuario() {
		return this.idUsuario;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public int getDni(){
		return this.dni;
	}

	public String getFechaNac(){
		return this.fechaNac;
	}
	
	public String getEmail(){
		return this.email;
	}

	public String getDomicilio(){
		return this.domicilio;
	}
	
	public void setIdUsuario(String id) {
		this.idUsuario = id;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setDni(int dni) {
		this.dni = dni;
	}
	
	public void setFechaNac(String fechaNac) {
		this.fechaNac= fechaNac;
	}
	
	public void setEmail(String email) {
		this.email= email;
	}
	
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	
}
