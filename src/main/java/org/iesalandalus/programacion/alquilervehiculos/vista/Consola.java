package org.iesalandalus.programacion.alquilervehiculos.vista;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {
	
	private static DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private static String PATRON_FECHA="([0-3]{1}[0-9]{1})([/])([0-1]{1}[0-9]{1})([/])([0-9]{4})";

	
	private Consola () {}
	

	public static void mostrarCabecera (String mensaje) {
		
			System.out.println(mensaje);
			
			
			String guion="";
			
			for (int i=0; i==mensaje.length();i++) {
			
				guion.concat("-");
			
				}
				
			System.out.println(guion);

	}
	
	public static void mostrarMenu() {
		//Crear un array de objetos de tipo Opcion
		//al ser un enumerado se utiliza la funcion values()
		Opcion[] opciones = Opcion.values();
		System.out.println(" Debe elegir entre las siguientes opciones:  ");
		
		//Recorremos la lista de opciones 
		for (int i = 0; i < opciones.length; i++) {
			
			//Mostramos cada opcion con el toString()
			//Mostrará el numero de ordinal y el texto de la opcion
			System.out.println(opciones[i].toString());
		}	
	}
	
	private static String leerCadena(String mensaje) {
		String cadena = "";
		
		//Muestra mensaje introducido por parametro
		System.out.println(mensaje);
		//Lee la cadena por teclado
		cadena = Entrada.cadena();
		
		return cadena;
	}
	
	private static int leerEntero(String mensaje) {
		int entero;
		
		System.out.println(mensaje);	
		entero = Entrada.entero();
		
		return entero;
	}
	
	private static LocalDate leerFecha(String mensaje) {
		
		LocalDate fecha = null;
		String fechaIntroducida="";
		boolean correcto = true;
			
		do {
			
			System.out.println(mensaje);
			fechaIntroducida= Entrada.cadena();
			
			//Comprobamos que la fecha coincide con el patrón de fecha
			if (fechaIntroducida.matches(PATRON_FECHA)) {
				
				//Si es correcta la fecha según el patrón
				try {	
					
					//Intento convertir la fecha en una fecha valida
					fecha = LocalDate.parse(fechaIntroducida, FORMATO_FECHA);
					
					//Si llega a esta linea de codigo es porque la ha podido convertir a fecha
					correcto = true;
				}
				catch (Exception e) {
					//Si se produce una Excepción es porque la fecha no es valida (32/03/2023)
					System.out.println("La fecha no es válida");
					correcto = false;
				}
			}
			//Si no sigue el patrón mostramos mensaje
			else {
				System.out.println("La fecha no coincide con el patrón");
				correcto = false;
			}

		}while (!correcto);
		
		return fecha;
	}
	
	
	public static Opcion elegirOpcion() {
		
		int opcion; 
		
		//Bucle que repite la introducción de la opción
		//mientras que no sea valida
		do {
			opcion = leerEntero("Introduce una opcion");
		
		} while (opcion < 0 && opcion > Opcion.values().length - 1);
		
		//Una vez el bucle finaliza => la opción es correcta
		return Opcion.values()[opcion];
	}
	
	public static Cliente leerCliente() {
		
		//Pedir datos del cliente
		String nombre = leerNombre();
		String dni = leerCadena("Introduce DNI cliente: ");
		String telefono = leerTelefono();
		
		//Creamos objeto cliente
		Cliente cliente = new Cliente (nombre, dni, telefono);
		return cliente;
		
		//return new Cliente (nombre, dni, telefono);
	}
	
	public static Cliente leerClienteDni() {
		String dni = leerCadena("Introduce DNI cliente: ");
		return Cliente.getClienteConDni(dni);
	}
	
	public static String leerNombre() {
		String nombre = leerCadena("Introduce nombre cliente: ");
		return nombre;
	}
	
	public static String leerTelefono() {
		String telefono = leerCadena("Introduce telefono cliente: ");
		return telefono;
	}
	
	public static Turismo leerTurismo() {
		String marca = leerCadena("Introduce marca: ");
		String modelo = leerCadena("Introduce modelo: ");
		int cilindrada = leerEntero("Introduce cilindrada");
		String matricula = leerCadena("Introduce matrícula");
		
		Turismo turismo = new Turismo(marca, modelo, cilindrada, matricula);
		return turismo;
	}
	
	public static Turismo TurismoMatricula() {
		String matricula = leerCadena("Introduce matrícula");
		return Turismo.getTurismoConMatricula(matricula);
	}
	
	public static Alquiler leerAlquiler() {
		
		Cliente cliente = leerCliente();
		Turismo turismo = leerTurismo();
		LocalDate fechaAlquiler = LocalDate.now();
		
		Alquiler alquiler = new Alquiler (cliente, turismo, fechaAlquiler);
		return alquiler;
	}
	
	public static LocalDate leerFechaDevolucion() {
		LocalDate fechaDevolucion = leerFecha("Introduce fecha devolución:");
		return fechaDevolucion;
	}
}