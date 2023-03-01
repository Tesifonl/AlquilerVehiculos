package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;


import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;


public class Clientes {

	//Declaro una lista porque esta clase tiene relacion a muchos (*) con cliente
	private List<Cliente> clientes;
	
	public Clientes() {
		//En el CONSTRUCTOR CREO el array vacío
		clientes = new ArrayList<Cliente>();
	}
	
	public List<Cliente> get() {
		// Un GET que Devuelve el arrayList porque dice que devuelve "Cliente [*]"
		return clientes;
	}
	
	public int getCantidad() {
		//Devuelve tamaño arrayList
		return clientes.size();
	}
	
	public void insertar(Cliente cliente) throws OperationNotSupportedException {
		
		//si el cliente no es null
		if (cliente != null) {
			
			//Si el cliente no esta en la lista ponemos validacion para que no entre
			if (!clientes.contains(cliente)) {
				//Añade el cliente en la lista porque no lo esta.
				clientes.add(cliente);
			}
			else {
				throw new OperationNotSupportedException("ERROR: Ya existe un cliente con ese DNI.");
			}
		}
		else {
			throw new NullPointerException("ERROR: No se puede insertar un cliente nulo.");
		}
	}
	
	public Cliente buscar(Cliente cliente) {
		
		//creo una nueva variable objeto para luego igualarlo
		Cliente clienteBusqueda = null;
		
		if (cliente != null) {
			
			//Calcular la posicion del cliente
			int posicion = clientes.indexOf(cliente);
			
			if (posicion >= 0) {
				//Asignar a clienteBusqueda el elemento del arraylist que se encuentra
				//en la posicion 
				clienteBusqueda = clientes.get(posicion);
			}
		}
		else {
			throw new NullPointerException("ERROR: No se puede buscar un cliente nulo.");
		}
		
		return clienteBusqueda;
	}
	
	public void borrar(Cliente cliente) throws OperationNotSupportedException {
		
		if (cliente != null) {
			
			//Si el cliente esta en la lista
			if (clientes.contains(cliente)) {
				//Borra el cliente
				clientes.remove(cliente);
			}
			else {
				throw new OperationNotSupportedException("ERROR: No existe ningún cliente con ese DNI.");
			}
			
		}
		else {
			throw new NullPointerException("ERROR: No se puede borrar un cliente nulo.");
		}
	}
	
	public void modificar(Cliente cliente, String nombre, String telefono) throws OperationNotSupportedException {
		
		if (cliente != null) {
			
			if (clientes.contains(cliente)) {
				
				int posicion = clientes.indexOf(cliente);
				
				if (nombre != null && !nombre.equals("")) {
					//Accedo al cliente de la posicion y le hago el set
					clientes.get(posicion).setNombre(nombre);
				}
				
				if (telefono != null && !telefono.equals("")) {
					//Accedo al cliente de la posicion y le hago el set
					clientes.get(posicion).setTelefono(telefono);
				}
			}
			else {
				throw new OperationNotSupportedException("ERROR: No existe ningún cliente con ese DNI.");
			}
		}
		else {
			throw new NullPointerException("ERROR: No se puede modificar un cliente nulo.");
		}
	}
}
