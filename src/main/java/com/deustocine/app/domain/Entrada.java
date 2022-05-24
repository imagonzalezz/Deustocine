package com.deustocine.app.domain;

import javax.jdo.annotations.ForeignKey;
import javax.jdo.annotations.PersistenceAware;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

/**
 * Clase entrada
 * @author Iker
 *
 */
@PersistenceCapable
public class Entrada {
	
	@PrimaryKey
	private int cod; 
	@ForeignKey
	private Usuario usuario;
	@ForeignKey
	private Sesion sesion;
	
	/**
	 * Constructor por defecto
	 */
	public Entrada() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor con parametros
	 * @param usuario Usuario que posee la entrada
	 * @param sesion Sesion que corresponde a la entrada
	 */
	public Entrada(Usuario usuario, Sesion sesion) {
		super();
		this.usuario = usuario;
		this.sesion = sesion;
	}

	/**
	 * Devuelve el usuario que posee la entrada
	 * @return Usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * Establece el usuario que posee la entrada
	 * @param usuario Usuario a establecer
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * Devuelve la sesion que corresponde a la entrada
	 * @return Sesion
	 */
	public Sesion getSesion() {
		return sesion;
	}

	/**
	 * Devuelve el codigo identificativo de la entrada
	 * @return Codigo identificativo
	 */
	public int getCod() {
		return cod;
	}

	/**
	 * Establece el codigo identificativo de la entrada
	 * @param cod Codigo a establecer
	 */
	public void setCod(int cod) {
		this.cod = cod;
	}

	/**
	 * Establece la sesion que corresponde a la entrada
	 * @param sesion Sesion a establecer
	 */
	public void setSesion(Sesion sesion) {
		this.sesion = sesion;
	}

	/**
	 * Imprime los datos de la entrada
	 */
	@Override
	public String toString() {
		return "Entrada [usuario=" + usuario + ", sesion=" + sesion + "]";
	}
	
	

}
