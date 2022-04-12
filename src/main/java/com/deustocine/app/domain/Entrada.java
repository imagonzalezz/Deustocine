package com.deustocine.app.domain;

import javax.jdo.annotations.ForeignKey;
import javax.jdo.annotations.PersistenceAware;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Entrada {
	
	@PrimaryKey
	private int cod;
	@ForeignKey
	private Usuario usuario;
	@ForeignKey
	private Sesion sesion;
	
	public Entrada() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Entrada(Usuario usuario, Sesion sesion) {
		super();
		this.usuario = usuario;
		this.sesion = sesion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Sesion getSesion() {
		return sesion;
	}

	public void setAsiento(Sesion sesion) {
		this.sesion = sesion;
	}

	@Override
	public String toString() {
		return "Entrada [usuario=" + usuario + ", sesion=" + sesion + "]";
	}
	
	

}
