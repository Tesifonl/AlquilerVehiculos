package org.iesalandalus.programacion.alquilervehiculos.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Alquileres;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Clientes;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Turismos;

public class Modelo {
	
	//Atributos
	private Clientes clientes;
	private Alquileres alquileres;
	private Turismos turismos;
	
	//Constructor
	public Modelo() {
		comenzar();
	}
	
	public void comenzar() {
		//Crear instancia de los 3 objetos
		clientes = new Clientes();
		alquileres = new Alquileres();
		turismos = new Turismos();
	}
	
	public void terminar() {
		System.out.println("El modelo ha finalizado");
	}
	
	/*4.Crea los diferentes métodos insertar, teniendo en cuenta que ahora ya si insertaremos 
	nuevas instancias utilizando los constructores copia y que en el caso de los alquileres, 
	primero debe buscar el cliente y el turismo y utilizar dichas instancias encontradas.*/
	
	public void insertar(Cliente cliente) throws OperationNotSupportedException {
		
		if (cliente != null) {
			//Inserta el cliente en la lista de clientes
			clientes.insertar(cliente);
		}
	}
	
	public void insertar(Alquiler alquiler) throws OperationNotSupportedException {
		
		if (alquiler != null) {
			
			//Buscamos el cliente del alquiler en la clase clientes
			//Si devuelve un objeto que no es null => cliente existe
			if (clientes.buscar(alquiler.getCliente()) != null) {
				
				//Buscamos el vehiculo
				if (turismos.buscar(alquiler.getTurismo()) != null) {
					
					//Insertar el alquiler
					alquileres.insertar(alquiler);
				}
				else {
					throw new OperationNotSupportedException("ERROR: No existe el turismo del alquiler.");
				}
			}
			else {
				throw new OperationNotSupportedException("ERROR: No existe el cliente del alquiler.");
			}	
		}
		else {
			throw new NullPointerException("ERROR: No se puede realizar un alquiler nulo.");
		}
		
	}
	
	public void insertar(Turismo turismo) throws OperationNotSupportedException {
		
		if (turismo != null) {
			turismos.insertar(turismo);
		}
	}
	
	
	/*5.Crea los diferentes métodos buscar, que devolverá una nueva instancia del elemento 
	encontrado si éste existe.*/
	public Cliente buscar(Cliente cliente) {
		return clientes.buscar(cliente);
	}
	
	public Turismo buscar(Turismo turismo) {
		return turismos.buscar(turismo);
	}
	
	public Alquiler buscar(Alquiler alquiler) {
		return alquileres.buscar(alquiler);
	}
	
	public void modificar(Cliente cliente, String nombre, String telefono) throws OperationNotSupportedException {
		
		if (cliente != null) {
			clientes.modificar(cliente, nombre, telefono);
		}
	}
	
	public void devolver(Alquiler alquiler, LocalDate fechaDevolucion ) throws OperationNotSupportedException {
		
		//Buscamos el alquiler a devovler, si existe (no es null)
		if (alquileres.buscar(alquiler) != null) {
			alquiler.devolver(fechaDevolucion);
		}
		else {
			throw new OperationNotSupportedException("ERROR: No existe el alquiler a devolver.");
		}
	}
	
	public void borrar(Cliente cliente) throws OperationNotSupportedException {
		
		//Recogemos los alquileres de ese cliente con el metodo get de la clase alquileres
		List<Alquiler> listaABorrar = alquileres.get(cliente);

		//Borramos cada elemento de esa lista
		for (Alquiler alq : listaABorrar) {
			alquileres.borrar(alq);
		}
		
		//Borramos cliente
		clientes.borrar(cliente);
	}
	
	public void borrar(Alquiler alquiler) throws OperationNotSupportedException  {
		alquileres.borrar(alquiler);
	}
	
	public void borrar(Turismo turismo) throws OperationNotSupportedException {
		//Recogemos los alquileres de ese turismo con el metodo get de la clase alquileres
		List<Alquiler> listaABorrar = alquileres.get(turismo);

		//Borramos cada elemento de esa lista
		for (Alquiler alq : listaABorrar) {
			alquileres.borrar(alq);
		}
		
		//Borramos turismo
		turismos.borrar(turismo);
	}
	
	public List<Cliente> getClientes() {
		//Creo una lista de copia para añadir los elementos
		List<Cliente> clientesCopia = new ArrayList<Cliente>();
			
		//Para cada elemento de la lista de turismos
		for (Cliente cli: clientes.get()) {
			
			//Añado el elemento a la lista de copia pero creando un nuevo
			//objeto con el constructor de copia
			clientesCopia.add(new Cliente(cli));
		}
		
		return clientesCopia;
	}
	
	public List<Turismo> getTurismos() {
		//Creo una lista de copia para añadir los elementos
		List<Turismo> turismosCopia = new ArrayList<Turismo>();
			
		//Para cada elemento de la lista de turismos
		for (Turismo alq: turismos.get()) {
			
			//Añado el elemento a la lista de copia pero creando un nuevo
			//objeto con el constructor de copia
			turismosCopia.add(new Turismo(alq));
		}
		
		return turismosCopia;
	}
	
	public List<Alquiler> getAlquileres() {
		
		//Creo una lista de copia para añadir los elementos
		List<Alquiler> alquileresCopia = new ArrayList<Alquiler>();
		
		//Para cada elemento de la lista de alquileres
		for (Alquiler alq: alquileres.get()) {
			
			//Añado el elemento a la lista de copia pero creando un nuevo
			//objeto con el constructor de copia
			alquileresCopia.add(new Alquiler(alq));
		}
		
		return alquileresCopia;

	}
	
	public List<Alquiler> getAlquileres(Cliente cliente) {
		
		//Creo una lista de copia para añadir los elementos
		List<Alquiler> alquileresCopia = new ArrayList<Alquiler>();
		
		//Creo una lista de alquileres del cliente del parametro
		List<Alquiler> alquileresCliente = alquileres.get(cliente);
		
		//Para cada elemento de la lista de alquileres de ese cliente
		//for (Alquiler alq: alquileres.get(cliente)) {
		for (Alquiler alq: alquileresCliente) {
			
			//Añado el elemento a la lista de copia pero creando un nuevo
			//objeto con el constructor de copia
			alquileresCopia.add(new Alquiler(alq));
		}
			
		return alquileresCopia;
	}
	
	public List<Alquiler> getAlquileres(Turismo turismo) {
		//Creo una lista de copia para añadir los elementos
		List<Alquiler> alquileresCopia = new ArrayList<Alquiler>();
		
		//Creo una lista de alquileres del turismo del parametro
		List<Alquiler> alquileresTurismo = alquileres.get(turismo);
		
		//Para cada elemento de la lista de alquileres de ese turismo
		//for (Alquiler alq: alquileres.get(turismo)) {
		for (Alquiler alq: alquileresTurismo) {
			
			//Añado el elemento a la lista de copia pero creando un nuevo
			//objeto con el constructor de copia
			alquileresCopia.add(new Alquiler(alq));
		}
			
		return alquileresCopia;
	}
}
