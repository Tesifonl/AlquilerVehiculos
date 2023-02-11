package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

public class Cliente {
	
	private static String ER_NOMBRE="[A-Za-z._]{10}";
	private static String ER_DNI="[0-9]{8})([a-zA-Z])";
	private static String ER_TELEFONO="[0-9]{9}";
	private String nombre;
	private String dni;
	private String telefono;
	
	public Cliente (String nombre, String dni, String telefono) {
		
		setNombre(nombre);
		setDni(dni);
		setTelefono(telefono);
	}

	
	public Cliente (Cliente cliente) {
		
		setNombre(cliente.getNombre());
		setDni(cliente.getDni());
		setTelefono(cliente.getTelefono());
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		if (nombre == null) { throw new NullPointerException("ERROR: El nombre de un cliente no puede ser nulo.");}
		if (nombre.trim().equals("")) { throw new IllegalArgumentException("ERROR: El nombre del cliente no tiene un formato válido.");}
		else if (!nombre.trim().matches(ER_NOMBRE)) { throw new IllegalArgumentException("ERROR: El dni del cliente no tiene un formato válido.");}
		else { String[] formatoNombre=nombre.split(" ");
				this.nombre="";
				for (int i=0;i<formatoNombre.length;i++) {
				formatoNombre[i]=formatoNombre[i].substring(0, 1).toUpperCase()+formatoNombre[i].substring(1).toLowerCase();
				this.nombre=this.nombre+formatoNombre[i];
				// Otra manera seria this.nombre+=formatoNombre[i];
						
				}
			
			this.nombre = nombre;}
		
		String formatoNombre=nombre.substring(0, 1).toUpperCase()+nombre.substring(1).toLowerCase();
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		
		if (dni == null) { throw new NullPointerException("ERROR: El dni de un cliente no puede ser nulo.");}
		if (dni.trim().equals("")) { throw new IllegalArgumentException("ERROR: El dni del cliente no tiene un formato válido.");}
		else if (!dni.trim().matches(ER_DNI)) { throw new IllegalArgumentException("ERROR: El dni del cliente no tiene un formato válido.");}
		else if (!comprobarLetraDni(dni)) {throw new IllegalArgumentException("ERROR: La letra del Dni es incorrecta.");}
		else {this.dni = dni;};

	}


	public boolean comprobarLetraDni(String dni){
		int resto=0;
		char letra = 0;
		String letrasDni="TRWAGMYFPDXBNJZSQVHLCKE";
		String numerado=dni.substring(0, 8);
		int numeracion= Integer.parseInt(numerado);
		resto=numeracion % 23;
		letra=letrasDni.charAt(resto);

		if (letra==dni.charAt(8)) { return true;}
		else {return false;}}
	

	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	
}
