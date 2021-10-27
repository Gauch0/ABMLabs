package laboratorio;

import collections.Documento_Usuarios;

public class ControllerUsuario {
	
	Documento_Usuarios doc_Usuarios;

	public ControllerUsuario() {
		doc_Usuarios = new Documento_Usuarios();
	}
	
	public void crearUsuario(String id,int dni,String nombre,String email,String domicilio,String fechaNac) {
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(id);
		usuario.setDni(dni);
		usuario.setNombre(nombre);
		usuario.setEmail(email);
		usuario.setDomicilio(domicilio);
		usuario.setFechaNac(fechaNac);
		
		doc_Usuarios.agregarUsuario(usuario);
	}
	
	public Usuario getUsuario(int index) {
		return doc_Usuarios.getUsuario(index);
	}
	
	public void modificarUsuario(String nombre,String id,String domicilio, String email,String fechaNac,int dni,int index) {
		doc_Usuarios.modificarUsuario(nombre,id,domicilio, email,fechaNac,dni,index);
	}
	
	public void eliminarUsuario(int index) {
		doc_Usuarios.eliminarUsuario(index);
	}
}
