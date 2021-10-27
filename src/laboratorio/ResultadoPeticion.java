package laboratorio;

public class ResultadoPeticion {
	private String nombre;
	private String apellido;
	private String obraSocial;
	private String diagnostico;
	private boolean valorCritico;
	private String fechaNac;
	
	public ResultadoPeticion() {
		nombre =new String();
		apellido = new String();
		obraSocial = new String();
		diagnostico = new String();
		fechaNac = new String();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getObraSocial() {
		return obraSocial;
	}

	public void setObraSocial(String obraSocial) {
		this.obraSocial = obraSocial;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public boolean isValorCritico() {
		return valorCritico;
	}

	public void setValorCritico(boolean valorCritico) {
		this.valorCritico = valorCritico;
	}

	public String getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}
	
	
}
