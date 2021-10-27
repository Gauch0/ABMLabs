package laboratorio;

public class Sucursal {

	private int numero;
	private String direccion;
	private String tecnico;
	
	public Sucursal() {
		numero = 0;
		direccion = "";
		tecnico = "";
	}
	
	public void setNumero(int num) {
		this.numero = num;
	}
	
	public void setDireccion(String dir) {
		this.direccion = dir;
	}

	public void setTecnico(String tec) {
		this.tecnico = tec;
	}

	public int getNumero() {
		return this.numero;
	}
	
	public String getDireccion() {
		return this.direccion;
	}
	
	public String getTecnico() {
		return this.tecnico;
	}

}