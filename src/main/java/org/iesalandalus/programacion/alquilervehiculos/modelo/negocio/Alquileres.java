package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;

public class Alquileres {

	//Declaro una lista para ir añadiendo los alquileres, pq esta clase tiene relacion a muchos con alquileres (*)
	private List<Alquiler> alquileres;
	
	public Alquileres() {
		//En el constructor CREO la lista vacia para ir añadiendo los alquileres posteriormente
		alquileres = new ArrayList<Alquiler>();
	}
	
	public List<Alquiler> get() {
		
		//Devolver lista completa de alquileres
		// Un GET que Devuelve el arrayList porque dice que devuelve "Alquiler [*]"
		return alquileres;
	}
	
	public List<Alquiler> get(Cliente cliente){
		
		// Un GET que Devuelve el arrayList porque dice que devuelve "Alquiler [*]"
		// Pero DECLARO Y CREO una NUEVA  lista para ir añadiendo los alquileres del cliente.
		// Es una nueva lista por cliente
		List<Alquiler> nuevaLista = new ArrayList<Alquiler>();
		
		//Buscar el cliente dentro de los objetos Alquiler
		//de la lista de alquileres usando for each
		// Estos for no necesitan ir de una posicion a otra, buscan en toda la lista.
		// Creo un nuevo obejto alq que será el que tengo que ir buscando equals al introducidor por parametro
		for (Alquiler alq: alquileres) {
			
			//Si el cliente del objeto alq es igual al cliente del parametro
			if (alq.getCliente().equals(cliente)) {
				
				//Añado este alquiler a la lista para devovlerlo al final
				nuevaLista.add(alq);
			}
		}
		
		return nuevaLista;
	}
	
	public List<Alquiler> get(Turismo turismo){
		
		
		// Un GET que Devuelve el arrayList porque dice que devuelve "Alquiler [*]"
		// Pero DECLARO y CREO una lista para ir añadiendo los alquileres del turismo
		// Es una nueva lista por turismo.
		List<Alquiler> nuevaLista = new ArrayList<Alquiler>();
		
		//Buscar el turismo dentro de los objetos Alquiler
		//de la lista de alquileres usando for each
		// Estos for no necesitan ir de una posicion a otra, buscan en toda la lista.
		// Creo un nuevo obejto alq que será el que tengo que ir buscando equals al introducidor por parametro
		for (Alquiler alq: alquileres) {
			
			//Si el turismo del objeto alq es igual al turismo del parametro
			if (alq.getTurismo().equals(turismo)) {
				
				//Añado este alquiler a la lista para devovlerlo al final
				nuevaLista.add(alq);
			}
		}
		
		return nuevaLista;
	}
	
	public int getCantidad() {
		//Devolver el tamaño de alquileres
		return alquileres.size();
	}
	
	private void comprobarAlquiler(Cliente cliente, Turismo turismo, LocalDate fechaAlquiler) throws OperationNotSupportedException {
		
		for (Alquiler alq: alquileres) {
			
			//Si el cliente del objeto alq es igual al cliente del parametro
			//y la fecha de devolución es null
			if (alq.getCliente().equals(cliente) && alq.getFechaDevolucion() == null) {
				throw new OperationNotSupportedException("ERROR: El cliente tiene otro alquiler sin devolver.");
			}
			
			//Si el cliente del objeto alq es igual al cliente del parametro
			//y la fecha de devolución es posterior (isAfter) a la fecha de alquiler
			if (alq.getCliente().equals(cliente) && alq.getFechaDevolucion().isAfter(fechaAlquiler)) {
				throw new OperationNotSupportedException("ERROR: El cliente tiene un alquiler posterior.");
			}
					

			//si el turismo del objeto alq es igual al turismo del parametro 
			//y la fecha de devolución es null
			if (alq.getTurismo().equals(turismo) && alq.getFechaDevolucion() == null) {
				throw new OperationNotSupportedException("ERROR: El turismo está actualmente alquilado.");
			}
				
			//si el turismo del objeto alq es igual al turismo del parametro 
			//y la fecha de devolución es posterior (isAfter) a la fecha de alquiler
			if (alq.getTurismo().equals(turismo) && alq.getFechaDevolucion().isAfter(fechaAlquiler)) {
				throw new OperationNotSupportedException("ERROR: El turismo tiene un alquiler posterior.");
			}		
		}
		
	}
	
	public void insertar(Alquiler alquiler) throws OperationNotSupportedException {
		
		if (alquiler != null) {
			//Llamamos al metodo comprobar con los datos del aquiler que queremos insertar
			comprobarAlquiler(alquiler.getCliente(), alquiler.getTurismo(), alquiler.getFechaAlquiler());
			
			//Si pasa el metodo anterior añado el alquiler a la lista de alquileres
			alquileres.add(alquiler);	
		}
		else {
			throw new NullPointerException("ERROR: No se puede insertar un alquiler nulo.");
		}
	}
	
	public void devolver(Alquiler alquiler, LocalDate fechaDevolucion) {
		
	}
	
	
	public void borrar(Alquiler alquiler) {
		
	}
	
	public Alquiler buscar(Alquiler alquiler) {
		return null;
	}
	
}
