package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;

import java.util.ArrayList;
import java.util.List;
import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;

public class Turismos {

	//Declaro una lista porque esta clase tiene relacion a muchos (*) con turismo
	private List<Turismo> turismos;
	
	public Turismos () {
		// En el CONSTRUCTOR creo la lista vacia.
		turismos= new ArrayList<Turismo>();
	}
	
	public List<Turismo> get(){
		
		// Un GET que Devuelve el arrayList pq dice que devuelve "Turismo [*]"
		return turismos;
	}
	
	public int getCantidad() {
		
		//Devuelve tamaño arrayList
		return turismos.size();
		
	}
	
	
	public void Insertar(Turismo turismo) throws OperationNotSupportedException {
		
		// Si el turismo es null
		if (turismo!=null) {
			
			// Si el turismo ya aparece en la lista ponemos validacion para que no entre
			if (!turismos.contains(turismo)) {
				
				// Añadimos el turismo a la lista porque no lo esta.
				turismos.add(turismo);
				
			} throw new OperationNotSupportedException("ERROR: Ya existe un turismo con esa matrícula.");
		}
		
	throw new NullPointerException("ERROR: No se puede insertar un turismo nulo.");
}	
	
	public Turismo buscar (Turismo turismo) {
		
		//creo una nueva variable objeto para luego igualarlo
		Turismo turismoBusqueda = null;
		
		if (turismo != null) {
			
			//Calcular la posicion del turismo
			int posicion = turismos.indexOf(turismo);
			
			if (posicion >= 0) {
				//Asignar a turismoBusqueda el elemento del arraylist que se encuentra
				//en la posicion 
				turismoBusqueda = turismos.get(posicion);
			}
		}
		else {
			throw new NullPointerException("ERROR: No se puede buscar un turismo nulo.");}
		
		return turismoBusqueda;}
	
	public void borrar (Turismo turismo) throws OperationNotSupportedException {
		
		if (turismo!=null) {
			
			//Si el turismo esta en la lista
			if (turismos.contains(turismo)) {
				//Borra el turismo
				turismos.remove(turismo);
			}
			else {
				throw new OperationNotSupportedException("ERROR: No existe ningún turismo con esa matrícula.");
			}
			
			
		} else {throw new NullPointerException("ERROR: No se puede borrar un turismo nulo.");}}
	
}
