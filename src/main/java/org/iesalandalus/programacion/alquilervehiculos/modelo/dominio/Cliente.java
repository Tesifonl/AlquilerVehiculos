package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import java.util.Objects;

public class Cliente {
	
	private String ER_NOMBRE="[A-Z]{1}[a-z]+\\s{0,1}[A-Z]{0,1}[a-z]*";
	private String ER_DNI="[0-9]{8}[a-zA-Z]{1}";
	private String ER_TELEFONO="[0-9]{9}";
	private String nombre;
	private String dni;
	private String telefono;
	
	public Cliente (String nombre, String dni, String telefono) {
		
		setNombre(nombre);
		setDni(dni);
		setTelefono(telefono);
	}

	public Cliente() {
	}

	
	public Cliente (Cliente cliente) {
		
		if (cliente != null) {
			setNombre(cliente.getNombre());
			setDni(cliente.getDni());
			setTelefono(cliente.getTelefono());
		}
		else {
			throw new NullPointerException("ERROR: No es posible copiar un cliente nulo.");
		}
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		if (nombre == null) { throw new NullPointerException("ERROR: El nombre no puede ser nulo.");}
		if (nombre.equals("")) { throw new IllegalArgumentException("ERROR: El nombre no tiene un formato válido.");}
		else if (!nombre.trim().matches(ER_NOMBRE)) { throw new IllegalArgumentException("ERROR: El nombre no tiene un formato válido.");}
		else { String[] formatoNombre=nombre.split(" ");
				this.nombre="";
				for (int i=0;i<formatoNombre.length;i++) {
				formatoNombre[i]=formatoNombre[i].substring(0, 1).toUpperCase()+formatoNombre[i].substring(1).toLowerCase();
				
				//si no es la ultima palabra le añado espacio en blanco
				if (i < formatoNombre.length - 1) {
					this.nombre=this.nombre+formatoNombre[i] + " ";
				}
				else {
					this.nombre=this.nombre+formatoNombre[i];
				}
				// Otra manera seria this.nombre+=formatoNombre[i];
						
				}}
	
	
	}


	public String getDni() {
		return dni;
	}


	private void setDni(String dni) {
		
		if (dni == null) { throw new NullPointerException("ERROR: El DNI no puede ser nulo.");}
		if (dni.trim().equals("")) { throw new IllegalArgumentException("ERROR: El DNI no tiene un formato válido.");}
		else if (!dni.trim().matches(ER_DNI)) { throw new IllegalArgumentException("ERROR: El DNI no tiene un formato válido.");}
		else if (!comprobarLetraDni(dni)) {throw new IllegalArgumentException("ERROR: La letra del DNI no es correcta.");}
		else {this.dni = dni;};

	}


	private boolean comprobarLetraDni(String dni){
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
		if (telefono == null) { throw new NullPointerException("ERROR: El teléfono no puede ser nulo.");}
		if (telefono.trim().equals("")) { throw new IllegalArgumentException("ERROR: El teléfono no tiene un formato válido.");}
		else if (!telefono.trim().matches(ER_TELEFONO)) { throw new IllegalArgumentException("ERROR: El teléfono no tiene un formato válido.");}
		else {this.telefono = telefono;};
	}
	
	public static Cliente getClienteConDni(String dni) {
		Cliente clienteValido = null;
		
		if (dni != null) {
			//Creamos objeto vacío sin datos
			clienteValido=new Cliente();
			//Solo le asignamos el dni
			clienteValido.setDni(dni);
		}
		else {
			throw new NullPointerException("ERROR: El DNI no puede ser nulo.");
		}
		
		return clienteValido;
	}


	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(dni, other.dni);
	}


	@Override
	public String toString() {
		return nombre + " - " + dni + " ("+ telefono + ")";
	}
	
	
}
