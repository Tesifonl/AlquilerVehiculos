package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import javax.naming.OperationNotSupportedException;

public class Alquiler {

	static DateTimeFormatter FORMATO_FECHA=DateTimeFormatter.ofPattern("yyyy-MM-dd");
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
			
			cliente = new Cliente(alquiler.getCliente());
			turismo = new Turismo(alquiler.getTurismo());
			setFechaAlquiler(alquiler.getFechaAlquiler());
			setFechaDevolucion(alquiler.getFechaDevolucion());
		}
		else {
			throw new NullPointerException("ERROR: No es posible copiar un alquiler nulo.");
		}
	}


	public LocalDate getFechaAlquiler() {
		return fechaAlquiler;
	}



	public void setFechaAlquiler(LocalDate fechaAlquiler) {
		if (fechaAlquiler != null) {
			
			//Fecha posterior a hoy
			if (fechaAlquiler.isAfter(LocalDate.now())) {
				throw new IllegalArgumentException("ERROR: La fecha de alquiler no puede ser futura.");
			}
			else {
				this.fechaAlquiler = fechaAlquiler;
			}
		}
		else {
			throw new NullPointerException("ERROR: La fecha de alquiler no puede ser nula.");
		}
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
		if (cliente != null) {
			this.cliente = cliente;
		}
		else {
			throw new NullPointerException("ERROR: El cliente no puede ser nulo.");
		}
		
	}



	public Turismo getTurismo() {
		return turismo;
	}



	public void setTurismo(Turismo turismo) {
		if (turismo != null) {
			this.turismo = turismo;
		}
		else {
			throw new NullPointerException("ERROR: El turismo no puede ser nulo.");
		}
	}
	
	
	public void devolver(LocalDate fechaDevolucion) throws OperationNotSupportedException {
		
		if (fechaDevolucion == null) { throw new NullPointerException("ERROR: La fecha de devolución no puede ser nula.");}
		if (fechaDevolucion.isAfter(LocalDate.now())) { throw new IllegalArgumentException("ERROR: La fecha de devolución no puede ser futura.");}
		if (fechaDevolucion.isBefore(fechaAlquiler)) { throw new IllegalArgumentException("ERROR: La fecha de devolución debe ser posterior a la fecha de alquiler.");}
		if (fechaDevolucion.isEqual(fechaAlquiler)) { throw new IllegalArgumentException("ERROR: La fecha de devolución debe ser posterior a la fecha de alquiler.");}
		if (fechaDevolucion.equals("")) { throw new IllegalArgumentException("ERROR: El teléfono no tiene un formato válido.");}
		if (this.fechaDevolucion != null) {throw new OperationNotSupportedException("ERROR: La devolución ya estaba registrada.");}
		//else if (FORMATO_FECHA.parse(fechaDevolucion.getYear() + "-" + fechaDevolucion.getMonthValue() + "-" + fechaDevolucion.getDayOfMonth()) != null) { throw new IllegalArgumentException("ERROR: El teléfono no tiene un formato válido.");}
		else {this.fechaDevolucion = fechaDevolucion;};
	}
	
	public int getPrecio() {
		
		int precio = 0;
		
		if (fechaDevolucion != null) {
			//return (PRECIODIA + (turismo.getCilindrada() / 10)) * (int) (Duration.between(fechaAlquiler, fechaDevolucion.plusDays(1)).toDays());
			precio = (PRECIODIA + (turismo.getCilindrada() / 10)) * (fechaAlquiler.until(fechaDevolucion).getDays());
		}
		
		return precio;
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

		if (fechaDevolucion == null) {
			return String.format("%s <---> %s, %s - %s (%d€)", cliente, turismo,
					fechaAlquiler.format(Alquiler.FORMATO_FECHA), "Aún no devuelto", 0);
		}
		else {
			return String.format("%s <---> %s, %s - %s (%d€)", cliente, turismo,
					fechaAlquiler.format(Alquiler.FORMATO_FECHA), fechaDevolucion.format(Alquiler.FORMATO_FECHA), getPrecio());
		}
	}
}
