package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import java.util.Objects;

public class Turismo {
	
	private static String[] ER_MARCA= {"Seat", "Land Rover", "KIA", "Rolls-Royce", "SsangYong"};
	private static String ER_MATRICULA="([0-9]{4})([BCDFGHJKLMNPRSTVWXYZ]{3})";
	private String marca;
	private String modelo;
	private int cilindrada;
	private String matricula;
	
	
	public Turismo (String marca, String modelo, int cilindrada, String matricula) {
		
		setMarca(marca);
		setModelo(modelo);
		setCilindrada(cilindrada);
		setMatricula(matricula);
		
	}
	
	public Turismo () {
	}
	
	
	public Turismo (Turismo turismo) {
		if (turismo != null) {
		setMarca(turismo.getMarca());
		setModelo(turismo.getModelo());
		setCilindrada(turismo.getCilindrada());
		setMatricula(turismo.getMatricula());
		}
		else {
			throw new NullPointerException("ERROR: No es posible copiar un turismo nulo.");
		}
	}


	public String getMarca() {
		return marca;
	}


	private void setMarca(String marca) {
		
		if (marca == null) { throw new NullPointerException("ERROR: La marca no puede ser nula.");}
		if (marca.trim().equals("")) { throw new IllegalArgumentException("ERROR: La marca no tiene un formato válido.");}
		else {
			boolean encontrado = false;
			for (int i = 0; i < ER_MARCA.length && !encontrado; i++) {
				if (ER_MARCA[i].equals(marca)) {
					this.marca = marca;
					encontrado = true;
				}
			}
			
			if (!encontrado) {
				throw new IllegalArgumentException("ERROR: La marca no tiene un formato válido.");}
		
		}
	}


	public String getModelo() {
		return modelo;
	}


	private void setModelo(String modelo) {
		if (modelo == null) { throw new NullPointerException("ERROR: El modelo no puede ser nulo.");}
		if (modelo.trim().equals("")) { throw new IllegalArgumentException("ERROR: El modelo no puede estar en blanco.");}
		else {this.modelo = modelo;};
	
	}


	public int getCilindrada() {
		return cilindrada;
	}


	private void setCilindrada(int cilindrada) {
		if (cilindrada<1 || cilindrada>5000) { throw new IllegalArgumentException("ERROR: La cilindrada no es correcta.");}
		else {this.cilindrada = cilindrada;}
	}


	public String getMatricula() {
		return matricula;
	}


	private void setMatricula(String matricula) {
		
		if (matricula == null) { throw new NullPointerException("ERROR: La matrícula no puede ser nula.");}
		if (matricula.trim().equals("")) { throw new IllegalArgumentException("ERROR: La matrícula no tiene un formato válido.");}
		else if (!matricula.trim().matches(ER_MATRICULA)) { throw new IllegalArgumentException("ERROR: La matrícula no tiene un formato válido.");}
		else {this.matricula = matricula;};
	
	}

	

	
	public static Turismo getTurismoConMatricula(String matricula) {
		
		Turismo turismoConMatricula = null;
		
		if (matricula != null) {
			turismoConMatricula =new Turismo();
			turismoConMatricula.setMatricula(matricula);
		}
		else {
			throw new NullPointerException("ERROR: La matrícula no puede ser nula.");
		}
		
		return turismoConMatricula;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(matricula);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Turismo other = (Turismo) obj;
		return Objects.equals(matricula, other.matricula);
	}


	@Override
	public String toString() {
		return String.format("%s %s (%sCV) - %s", marca, modelo, cilindrada, matricula, "disponible");
	}
}
