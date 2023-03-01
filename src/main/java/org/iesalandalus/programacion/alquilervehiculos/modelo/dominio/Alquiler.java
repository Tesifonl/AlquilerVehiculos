package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Alquiler {

	static DateTimeFormatter FORMATO_FECHA=DateTimeFormatter.ofPattern("DD/MM/YYYY");
	private final int PRECIODIA=20;
	private LocalDate fechaAlquiler;
	private LocalDate fechaDevolucion;
	private Cliente cliente;
	private Turismo turismo;
	
	
	
	public Alquiler(Cliente cliente, Turismo turismo, LocalDate fechaAlquiler) {
		
		setCliente(cliente);
		setTurismo (turismo);
		setFechaAlquiler(fechaAlquiler);
		//setFechaDevolucion(fechaDevolucion);
	}

	
	public Alquiler(Alquiler alquiler) {
		
		if (alquiler != null) {
			setCliente(alquiler.getCliente());
			setTurismo (alquiler.getTurismo());
			setFechaAlquiler(alquiler.getFechaAlquiler());
			//setFechaDevolucion(fechaDevolucion);
		}
		else {
			throw new NullPointerException("ERROR: No es posible copiar un alquiler nulo.");
		}
	}


	public LocalDate getFechaAlquiler() {
		return fechaAlquiler;
	}



	public void setFechaAlquiler(LocalDate fechaAlquiler) {
		this.fechaAlquiler = fechaAlquiler;
	}



	public LocalDate getFechaDevolucion() {
		return fechaDevolucion;
	}



	public void setFechaDevolucion(LocalDate fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}



	public Cliente getCliente() {
		return cliente;
	}



	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}



	public Turismo getTurismo() {
		return turismo;
	}



	public void setTurismo(Turismo turismo) {
		this.turismo = turismo;
	}
	
	
	public void devolver(LocalDate fechaDevolucion) {
		
		if (fechaDevolucion == null) { throw new NullPointerException("ERROR: El teléfono no puede ser nulo.");}
		if (fechaDevolucion.equals("")) { throw new IllegalArgumentException("ERROR: El teléfono no tiene un formato válido.");}
		else if (fechaDevolucion.parse(FORMATO_FECHA.toString()) == null) { throw new IllegalArgumentException("ERROR: El teléfono no tiene un formato válido.");}
		else {this.fechaDevolucion = fechaDevolucion;};
	}
	
	public int getPrecio() {
		
		//return (PRECIODIA + (turismo.getCilindrada() / 10)) * (int) (Duration.between(fechaAlquiler, fechaDevolucion.plusDays(1)).toDays());
		return (PRECIODIA + (turismo.getCilindrada() / 10)) * (fechaDevolucion.until(fechaAlquiler).getDays());
	}


	@Override
	public int hashCode() {
		return Objects.hash(cliente, fechaAlquiler, turismo);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alquiler other = (Alquiler) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(fechaAlquiler, other.fechaAlquiler)
				&& Objects.equals(turismo, other.turismo);
	}


	@Override
	public String toString() {
		return "Alquiler [PRECIODIA=" + PRECIODIA + ", fechaAlquiler=" + fechaAlquiler + ", fechaDevolucion="
				+ fechaDevolucion + ", cliente=" + cliente + ", turismo=" + turismo + "]";
	}
	
	
}
