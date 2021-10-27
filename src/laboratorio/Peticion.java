package laboratorio;

public class Peticion {
	
	private String nombre;
	private String obraSocial;
	private String fechaCarga;
	private String practicasAsociadas;
	private String fechaEntrega;
	private String sucursal;
	
	
	public String getSucursal() {
		return sucursal;
	}
	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getObraSocial() {
		return obraSocial;
	}
	public void setObraSocial(String obraSocial) {
		this.obraSocial = obraSocial;
	}
	public String getFechaCarga() {
		return fechaCarga;
	}
	public void setFechaCarga(String fechaCarga) {
		this.fechaCarga = fechaCarga;
	}
	public String getPracticasAsociadas() {
		return practicasAsociadas;
	}
	public void setPracticasAsociadas(String practicasAsociadas) {
		this.practicasAsociadas = practicasAsociadas;
	}
	public String getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(String fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

}
