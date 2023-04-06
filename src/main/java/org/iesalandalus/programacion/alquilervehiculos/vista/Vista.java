package org.iesalandalus.programacion.alquilervehiculos.vista;

import java.time.LocalDate;
import java.util.List;

import org.iesalandalus.programacion.alquilervehiculos.controlador.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Vista {

	//Atributo controlador
	private Controlador controlador;
	
	public void setControlador(Controlador controlador) {
		
		//Asignamos el controlador si este no es null
		if (controlador != null) {
			this.controlador = controlador;
		}
	}
	
	public void comenzar() {

		//Creamos la variable opcion
		Opcion opcion;
		
		do {
			//Como los metodos de la clase Consola son static, no necesitamos crear el objeto
			//para llamar al método, sino que lo hacemos con el nombre de la clase Consola
			Consola.mostrarMenu();
			
			//Elijo la opción de tipo Enumerado 
			opcion = Consola.elegirOpcion();
			
			//Llanar al método ejecutar de la opcion correspondiente
			ejecutar(opcion);
		
		} while (!opcion.equals(Opcion.SALIR));
	}
	
	public void terminar() {
		System.out.println("Gracias por utilizar nuestra aplicación");
	}
	
	private void ejecutar(Opcion opcion) {
		
		try {
			//Dependiendo de la opcion realizamos llamadas a cada metodo
			switch (opcion) {
				case INSERTAR_CLIENTE: {
					insertarCliente();
					break;
				}
				case INSERTAR_TURISMO: {
					insertarTurismo();
					break;
				}
				case INSERTAR_ALQUILER: {
					insertarAlquiler();
					break;
				}
				case BUSCAR_CLIENTE: {
					buscarCliente();
					break;
				}
				case BUSCAR_TURISMO: {
					buscarTurismo();
					break;
				}
				case BUCAR_ALQUILER: {
					buscarAlquiler();
					break;
				}
				case MODIFICAR_CLIENTE: {
					modificarCliente();
					break;
				}
				case DEVOLVER_ALQUILER: {
					devolverAlquiler();
					break;
				}
				case BORRAR_CLIENTE: {
					borrarCliente();
					break;
				}
				case BORRAR_TURISMO: {
					borrarTurismo();
					break;
				}
				case BORRAR_ALQUILER: {
					borrarAlquiler();
					break;
				}
				case LISTAR_CILENTES: {
					listarClientes();
					break;
				}
				case LISTAR_TURISMOS: {
					listarTurismos();
					break;
				}
				case LISTAR_AQLUILERES: {
					listarAlquileres();
					break;
				}
				case LISTAR_ALQUILERES_CLIENTE: {
					listarAlquileresCliente();
					break;
				}
				case LISTAR_ALQUILERES_TURISMO: {
					listarAlquileresTurismo();
					break;
				}
			}
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	private void insertarCliente() {
		
		//Crear instancia del cliente con los datos introducidos
		Cliente cliente = Consola.leerCliente();
		
		//Llamamos al metodo insertar pasándole el cliente como parametro
		controlador.insertar(cliente);
		
	}
	
	private void insertarTurismo() {
		
		//Crear instancia del turismo con los datos introducidos
		Turismo turismo = Consola.leerTurismo();
		
		//Llamamos al metodo insertar pasándole el turismo como parametro
		controlador.insertar(turismo);
	}
	
	private void insertarAlquiler() {
		
		//Crear instancia del turismo con los datos introducidos
		Alquiler alquiler = Consola.leerAlquiler();
		
		//Llamamos al metodo insertar pasándole el turismo como parametro
		controlador.insertar(alquiler);
	}
	
	private void buscarCliente() {
		//Pedir al usuario el cliente a buscar
		Cliente clienteABuscar = Consola.leerCliente();
		
		//Buscar el cliente en la lista de clientes mediante el controlador
		Cliente clienteEncontrado = controlador.buscar(clienteABuscar);
		
		//Si al buscar encontramos el cliente
		if (clienteEncontrado != null) {
			//Muestro los datos del cliente
			System.out.println(clienteEncontrado.toString());
		}
		else {
			System.out.println("No existe un cliente con esos datos");
		}
	}
	
	private void buscarTurismo() {
		//Pedir al usuario el turismo a buscar
		Turismo turismoABuscar = Consola.leerTurismo();
		
		//Buscar el turismo en la lista de turismos mediante el controlador
		Turismo turismoEncontrado = controlador.buscar(turismoABuscar);
		
		//Si al buscar encontramos el turismo
		if (turismoEncontrado != null) {
			//Muestro los datos del turismo
			System.out.println(turismoEncontrado.toString());
		}
		else {
			System.out.println("No existe un turismo con esos datos");
		}
	}
	
	private void buscarAlquiler() {
		//Pedir al usuario el alquiler a buscar
		Alquiler alquilerABuscar = Consola.leerAlquiler();
		
		//Buscar el alquiler en la lista de alquileres mediante el controlador
		Alquiler alquilerEncontrado = controlador.buscar(alquilerABuscar);
		
		//Si al buscar encontramos el alquiler
		if (alquilerEncontrado != null) {
			//Muestro los datos del cliente
			System.out.println(alquilerEncontrado.toString());
		}
		else {
			System.out.println("No existe un alquiler con esos datos");
		}
	}
	
	private void modificarCliente() {
		//Pedir los datos del cliente a modificar
		Cliente clienteABuscar = Consola.leerCliente();
		
		//Buscar el cliente en la lista de clientes mediante el controlador
		Cliente clienteEncontrado = controlador.buscar(clienteABuscar);
		
		//Si al buscar encontramos el alquiler
		if (clienteEncontrado != null) {
			
			//Pido los datos nuevos para modificar el cliente
			String nombreNuevo = Consola.leerNombre();
			String telefonoNuevo = Consola.leerTelefono();
			
			//Modificamos los datos del cliente
			controlador.modificar(clienteEncontrado, nombreNuevo, telefonoNuevo);
			
		}
		else {
			System.out.println("No existe un cliente con esos datos");
		}
	}
	
	private void devolverAlquiler() {
		//Pedir al usuario el alquiler a devolver
		Alquiler alquilerABuscar = Consola.leerAlquiler();
		
		//Buscar el alquiler en la lista de alquileres mediante el controlador
		Alquiler alquilerEncontrado = controlador.buscar(alquilerABuscar);
		
		//Si al buscar encontramos el alquiler
		if (alquilerEncontrado != null) {
			
			//Devolvemos el alquiler
			controlador.devolver(alquilerEncontrado, LocalDate.now());
		}
		else {
			System.out.println("No existe un alquiler con esos datos");
		}
	}
	
	private void borrarCliente() {
		//Pedir al usuario el cliente a borrar
		Cliente clienteABorrar = Consola.leerCliente();
		
		//Buscar el cliente en la lista de clientes mediante el controlador
		Cliente clienteEncontrado = controlador.buscar(clienteABorrar);
		
		//Si al buscar encontramos el cliente
		if (clienteEncontrado != null) {
			//Borro el cliente
			controlador.borrar(clienteEncontrado);
		}
		else {
			System.out.println("No existe un cliente con esos datos");
		}
	}
	
	private void borrarTurismo() {
		//Pedir al usuario el turismo a borrar
		Turismo turismoABorrar = Consola.leerTurismo();
		
		//Buscar el turismo en la lista de turismos mediante el controlador
		Turismo turismoEncontrado = controlador.buscar(turismoABorrar);
		
		//Si al buscar encontramos el turismo
		if (turismoEncontrado != null) {
			//Borro el cliente
			controlador.borrar(turismoEncontrado);
		}
		else {
			System.out.println("No existe un turismo con esos datos");
		}
	}
	
	private void borrarAlquiler() {
		//Pedir al usuario el alquiler a borrar
		Alquiler alquilerABorrar = Consola.leerAlquiler();
		
		//Buscar el alquiler en la lista de alquileres mediante el controlador
		Alquiler alquilerEncontrado = controlador.buscar(alquilerABorrar);
		
		//Si al buscar encontramos el alquiler
		if (alquilerEncontrado != null) {
			//Borro el cliente
			controlador.borrar(alquilerEncontrado);
		}
		else {
			System.out.println("No existe un alquiler con esos datos");
		}
	}
	
	private void listarClientes() {
		//Creamos una lista de clientes a partir del resultado
		//que nos devuelve la función getClientes de la clase Controlador
		List<Cliente> listClientes = controlador.getClientes();
		
		//Recorremos la lista y mostramos los datos de cada cliente
		for (Cliente cli: listClientes) {
			System.out.println(cli.toString());
		}
	}
	
	private void listarTurismos() {
		//Creamos una lista de turismos a partir del resultado
		//que nos devuelve la función getTurismos de la clase Controlador
		List<Turismo> listTurismos = controlador.getTurismos();
		
		//Recorremos la lista y mostramos los datos de cada turismo
		for (Turismo turismo: listTurismos) {
			System.out.println(turismo.toString());
		}
	}
	
	private void listarAlquileres() {
		//Creamos una lista de alquileres a partir del resultado
		//que nos devuelve la función getAlquileres de la clase Controlador
		List<Alquiler> listaAlquiler = controlador.getAlquileres();
		
		//Recorremos la lista y mostramos los datos de cada turismo
		for (Alquiler alqui: listaAlquiler) {
			System.out.println(alqui.toString());
		}
	}
	
	private void listarAlquileresCliente() {
		//Pedir los datos del cliente a mostrar
		Cliente cliente = Consola.leerCliente();
		
		//Creamos una lista de alquileres a partir del resultado
		//que nos devuelve la función getAlquileres de la clase Controlador
		//para el cliente leído en el paso anterior
		List<Alquiler> listaAlquiler = controlador.getAlquileres(cliente);
		
		//Recorremos la lista y mostramos los datos de cada turismo
		for (Alquiler alqui: listaAlquiler) {
			System.out.println(alqui.toString());
		}
	}
	
	private void listarAlquileresTurismo() {
		//Pedir los datos del cliente a mostrar
		Turismo turismo = Consola.leerTurismo();
		
		//Creamos una lista de alquileres a partir del resultado
		//que nos devuelve la función getAlquileres de la clase Controlador
		//para el cliente leído en el paso anterior
		List<Alquiler> listaAlquiler = controlador.getAlquileres(turismo);
		
		//Recorremos la lista y mostramos los datos de cada turismo
		for (Alquiler alqui: listaAlquiler) {
			System.out.println(alqui.toString());
		}
	}
}

