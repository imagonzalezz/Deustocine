package com.deustocine.app.domain;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

/**
 * Clase usuario
 * @author Iker
 *
 */
@PersistenceCapable
public class Usuario {
	
	@PrimaryKey
	private String dni; /**< DNI del usuario */
	
	private String nombre; /**< Nombre del usuario */
	private String contrasenya; /**< Contraseña del usuario */
	private double puntos = 0; /**< Puntos del usuario */
	
	/**
	 * Constructor por defecto
	 */
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructor con parametros
	 * @param nombre Nombre del usuario
	 * @param contrasenya Contraseña del usuario
	 */
	public Usuario(String nombre, String contrasenya) {
		super();
		this.nombre = nombre;
		this.contrasenya = contrasenya;
	}

	/**
	 * Devuelve el nombre del usuario
	 * @return Nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre del usuario
	 * @param nombre Nombre a establecer
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Devuelve la contraseña del usuario
	 * @return Contraseña
	 */
	public String getContrasenya() {
		return contrasenya;
	}

	/**
	 * Establece la contraseña del usuario
	 * @param contrasenya Contraseña a establecer
	 */
	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}

	/**
	 * Devuelve los puntos del usuario
	 * @return Puntos
	 */
	public double getPuntos() {
		return puntos;
	}

	/**
	 * Establecer los puntos del usuario
	 * @param puntos Puntos a establecer
	 */
	public void setPuntos(double puntos) {
		this.puntos = puntos;
	}
	
	/**
	 * Imprime los datos del usuario
	 */
	@Override
	public String toString() {
		return "Usuario [usuario=" + nombre + ", contrasenya=" + contrasenya + ", puntos=" + puntos + "]";
	}

	/**
	 * Devuelve el dni del usuario
	 * @return dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * Establece el dni del usuario
	 * @param dni dni a establecer
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	

}
