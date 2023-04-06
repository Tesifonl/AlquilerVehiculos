package org.iesalandalus.programacion.alquilervehiculos.controlador;

import java.time.LocalDate;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.Modelo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.vista.Vista;

public class Controlador {

	//Atributos
	private Modelo modelo;
	private Vista vista;
	
	//Constructor
	public Controlador(Modelo modelo, Vista vista) {
		this.modelo = modelo;
		this.vista = vista;
	}
	
	//Métodos
	public void comenzar() {
		modelo.comenzar();
		vista.comenzar();
	}
	
	public void terminar() {
		modelo.terminar();
		vista.terminar();
	}
	
	public void insertar(Cliente cliente) {
		try {
			//Llamamos a insertar de la clase Modelo
			modelo.insertar(cliente);
		}
		catch (OperationNotSupportedException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void insertar(Turismo turismo) {
		try {
			//Llamamos a insertar de la clase Modelo
			modelo.insertar(turismo);
		}
		catch (OperationNotSupportedException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void insertar(Alquiler alquiler) {
		try {
			//Llamamos a insertar de la clase Modelo
			modelo.insertar(alquiler);
		}
		catch (OperationNotSupportedException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public Cliente buscar(Cliente cliente) {
		return modelo.buscar(cliente);
	}
	
	public Turismo buscar(Turismo turismo) {
		return modelo.buscar(turismo);
	}
	
	public Alquiler buscar(Alquiler alquiler) {
		return modelo.buscar(alquiler);
	}
	
	public void modificar(Cliente cliente, String nombre, String telefono) {
		try {
			modelo.modificar(cliente, nombre, telefono);
		}
		catch (OperationNotSupportedException ex) {
			System.out.print(ex.getMessage());
		}
	}
	
	public void devolver(Alquiler alquiler, LocalDate fechaDevolucion) {
		try {
			modelo.devolver(alquiler, fechaDevolucion);
		}
		catch (OperationNotSupportedException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void borrar(Cliente cliente) {
		try {
			modelo.borrar(cliente);
		}
		catch (OperationNotSupportedException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void borrar(Turismo turismo) {
		try {
			modelo.borrar(turismo);
		}
		catch (OperationNotSupportedException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void borrar(Alquiler alquiler) {
		try {
			modelo.borrar(alquiler);
		}
		catch (OperationNotSupportedException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public List<Cliente> getClientes() {
		return modelo.getClientes();
	}
	
	public List<Turismo> getTurismos() {
		return modelo.getTurismos();
	}
	
	public List<Alquiler> getAlquileres() {
		return modelo.getAlquileres();
	}
	
	public List<Alquiler> getAlquileres(Cliente cliente) {
		return modelo.getAlquileres(cliente);
	}
	
	public List<Alquiler> getAlquileres(Turismo turismo) {
		return modelo.getAlquileres(turismo);
	}
}
