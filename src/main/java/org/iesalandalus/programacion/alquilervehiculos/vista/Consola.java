package org.iesalandalus.programacion.alquilervehiculos.vista;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.iesalandalus.programacion.clientesempresa.modelo.dominio.Cliente;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {
	
	DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private String PATRON_FECHA=[09];

	
	private Consola () {}
	

	public void mostrarCabecera (String mensaje) {
		
			System.out.println(mensaje);
			
			
			String guion="";
			
			for (int i=0; i==mensaje.length();i++) {
			
				guion.concat("-");
			
				}
				
			System.out.println(guion);

	}
	
	public void mostrarMenu() {
		     System.out.println(" Debe elegir entre las siguientes opciones:  "
				+ "SALIR"
				+ "INSERTAR_CLIENTE"
				+ "INSERTAR TURISMO"
				+ "INSERTAR ALQUILER"
				+ "BUSCAR_CLIENTE"
				+ "BUSCAR_TURISMO"
				+ "BUSCAR_ALQUILER"
				+ "MODIFICAR_CLIENTE"
				+ "DEVOLVER_ALQUILER"
				+ "BORRAR_CLIENTE"
				+ "BORRAR_TURISMO"
				+ "BORRAR_ALQUILER"
				+ "LISTAR_CLIENTES"
				+ "LISTAR_TURISMOS"
				+ "LISTAR_ALQUILERES"
				+ "LISTAR_ALQUILERES_CLIENTE"
				+ "LISTAR_ALQUILERES_TURISMO");
				
	}
	
	public void leerCadena(String mensaje) {
		
			System.out.println(" Introduzca un mensaje: ");
			mensaje=Entrada.cadena();
	}
	
	public void leerEntero(int entero) {
		
			System.out.println(" Introduzca un numero: ");	
			entero=Entrada.entero();
	}
	
	public void leerFecha(LocalDate fecha) {
		
	
			String fechaIntroducida="";
			
			do {System.out.println("Introduce una fecha en el formato correcto ");
			fechaIntroducida= Entrada.cadena();
			DateTimeFormatter FORMATOFECHA = DateTimeFormatter.ofPattern(fechaIntroducida);
			}while (!fechaIntroducida.matches(PATRON_FECHA));
			

			
	}

}