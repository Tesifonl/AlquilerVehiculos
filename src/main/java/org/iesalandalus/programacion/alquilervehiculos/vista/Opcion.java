package org.iesalandalus.programacion.alquilervehiculos.vista;

public enum Opcion {
	
	SALIR("SALIR"),
	INSERTAR_CLIENTE("INSERTAR_CLIENTE"),
	INSERTAR_TURISMO("INSERTAR_TURISMO"),
	INSERTAR_ALQUILER("INSERTAR_ALQUILER"),
	BUSCAR_CLIENTE("BUSCAR_CLIENTE"),
	BUSCAR_TURISMO("BUSCAR_TURISMO"),
	BUCAR_ALQUILER("BUSCAR_ALQUILER"),
	MODIFICAR_CLIENTE("MODIFICAR_CLIENTE"),
	DEVOLVER_ALQUILER("DEVOLVER_ALQUILER"),
	BORRAR_CLIENTE("BORRAR_CLIENTE"),
	BORRAR_TURISMO("BORRAR_TURISMO"),
	BORRAR_ALQUILER("BORRAR_ALQUILER"),
	LISTAR_CILENTES("LISTAR_CLIENTES"),
	LISTAR_TURISMOS("LISTAR_TURISMOS"),
	LISTAR_AQLUILERES("LISTAR_ALQUILERES"),
	LISTAR_ALQUILERES_CLIENTE("LISTAR_AQLUILERES_CLIENTE"),
	LISTAR_ALQUILERES_TURISMO("LISTAR_ALQUILERES_TURISMO");
	
	//Atributo
	private String texto;
	
	//Constructor privado
	private Opcion(String texto) {
		this.texto = texto;
	}

	private boolean esOrdinalValido(int ordinal) {
		
		//Si el numero ordinal está entre los indices validos del enumerado
		if (ordinal >= 0 && ordinal <= 16) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public Opcion get(int ordinal) {
		
		//Creamos un array de objetos Opcion donde guardamos
		//los valores del enumerado mediante la funcion values
		//que viene definida en Java y devuelve un array con los
		//objetos que se incluyen en el enumerado en el orden en el que
		//se hayan definido
		Opcion[] valores = Opcion.values();

		if (esOrdinalValido(ordinal)) {
			return valores[ordinal];
		}
		else {
			throw new IllegalArgumentException("Ordinal incorrecto");
		}
	}
	
	@Override
	public String toString() {
		//Con el objeto this (objeto Opcion que llama al método toString)
		//recuperamos su numero de ordinal + ". " + el texto del objeto Opcion
		String texto = this.ordinal() + "." + this.texto;
		return texto;
	}
}
