package dto;

public class PacienteDTO {

	private String Nombre;
	private String DNI;
	private String Domicilio;
	private String Mail;
	private String Sexo;
	private String Edad;
	private String Id;
	
	
	
	public PacienteDTO(String iD, String nombre, String dNI, String domicilio, String mail, String sexo, String edad) {
		this.Id = iD;
		this.Nombre = nombre;
		this.DNI = dNI;
		this.Domicilio = domicilio;
		this.Mail = mail;
		this.Sexo = sexo;
		this.Edad = edad;
		
	}




	public PacienteDTO() {
		super();
		// TODO Auto-generated constructor stub
	}




	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	private int ID;
	
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public String getDomicilio() {
		return Domicilio;
	}
	public void setDomicilio(String domicilio) {
		Domicilio = domicilio;
	}
	public String getMail() {
		return Mail;
	}
	public void setMail(String mail) {
		Mail = mail;
	}
	public String getSexo() {
		return Sexo;
	}
	public void setSexo(String sexo) {
		Sexo = sexo;
	}
	public String getEdad() {
		return Edad;
	}
	public void setEdad(String edad) {
		Edad = edad;
	}
	
	
}


