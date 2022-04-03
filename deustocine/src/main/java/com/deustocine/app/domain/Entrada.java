package com.deustocine.app.domain;

public class Entrada {
	
	private Usuario usuario;
	private Asiento asiento;
	
	public Entrada() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Entrada(Usuario usuario, Asiento asiento) {
		super();
		this.usuario = usuario;
		this.asiento = asiento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Asiento getAsiento() {
		return asiento;
	}

	public void setAsiento(Asiento asiento) {
		this.asiento = asiento;
	}

	@Override
	public String toString() {
		return "Entrada [usuario=" + usuario + ", asiento=" + asiento + "]";
	}
	
	

}
