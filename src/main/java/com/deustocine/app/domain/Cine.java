package com.deustocine.app.domain;

//import java.util.ArrayList;
import java.util.Objects;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * Clase cine
 * @author Iker
 *
 */
@PersistenceCapable
public class Cine {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
	private int cod;
	private String nombre;
	private String direccion;
	private int telefono;
	
	/**
	 * Constructor por defecto
	 */
	public Cine() {
		super();
	}

	/**
	 * Constructor con parametros
	 * @param cod Codigo identificativo
	 * @param nombre Nombre
	 * @param direccion Direccion
	 * @param telefono Numero de telefono
	 */
	public Cine(int cod, String nombre, String direccion, int telefono) {
		super();
		this.cod = cod;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
	}
	
	/**
	 * Devuelve el codigo identificativo del cine
	 * @return Codigo
	 */
	public int getCod() {
		return cod;
	}

	/**
	 * Establece el codigo identificativo del cine
	 * @param cod Codigo a establecer
	 */
	public void setCod(int cod) {
		this.cod = cod;
	}

	/**
	 * Devuelve el nombre del cine
	 * @return Nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre del cine
	 * @param nombre Nombre a establecer
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Devuelve la direccion del cine
	 * @return Direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Establece la direccion del cine
	 * @param direccion Direccion a establecer
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * Devuelve el telefono de contacto del cine
	 * @return Telefono
	 */
	public int getTelefono() {
		return telefono;
	}

	/**
	 * Establece el numero de contacto del cine
	 * @param telefono Telefono a establecer
	 */
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	/**
	 * Imprime los datos del cine
	 */
	@Override
	public String toString() {
		return "Cine [nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cod);
	}

	/**
	 * Indica si dos cines son iguales
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cine other = (Cine) obj;
		return cod == other.cod;
	}
	
	
}
