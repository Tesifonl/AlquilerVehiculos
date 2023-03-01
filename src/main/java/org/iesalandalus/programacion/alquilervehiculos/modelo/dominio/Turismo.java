package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import java.util.Objects;

public class Turismo {
	
	private static String ER_MARCA="[A-Za-z._]{4}";
	private static String ER_MATRICULA="([0-9]{4})([A-Z]{3})";
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
		
		setMarca(marca);
		setModelo(modelo);
		setCilindrada(cilindrada);
		setMatricula(matricula);
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
		else if (!marca.trim().matches(ER_MARCA)) { throw new IllegalArgumentException("ERROR: La marca no tiene un formato válido.");}
		else {this.marca = marca;};

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
		if (cilindrada<1 || cilindrada>5000) { throw new NullPointerException("ERROR: La cilindrada no es correcta.");}
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
		
		Turismo turismoConMatricula=new Turismo();
		
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
		return "Turismo [marca=" + marca + ", modelo=" + modelo + ", cilindrada=" + cilindrada + ", matricula="
				+ matricula + "]";
	}

	
	
}
