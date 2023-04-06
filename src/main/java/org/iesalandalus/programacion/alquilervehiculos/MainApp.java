package org.iesalandalus.programacion.alquilervehiculos;

import org.iesalandalus.programacion.alquilervehiculos.controlador.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.modelo.Modelo;
import org.iesalandalus.programacion.alquilervehiculos.vista.Vista;

public class MainApp {
	
	public static void main(String[] args) {

		//Crear objeto Vista para comenzar con la aplicación
		Vista vista = new Vista();
		//La clase Vista tiene un atributo controlador que utilizamos en todos
		//los métodos de la clase Vista para ejecutar los métodos de la clase Controlador
		//y a su vez los metodos de la clase Modelo
		//Creo un objeto Controlador 
		Controlador controlador = new Controlador(new Modelo(), vista);
		//Asignamos a la vista el controlador
		vista.setControlador(controlador);
		//Llamamos al método comenzar para iniciar la aplicacion
		vista.comenzar();
		//Cuando el usuario telea la opción de salir y comenzar ya finaliza
		//Llamamos al método terminar
		vista.terminar();
		
	}

}
