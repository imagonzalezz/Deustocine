package com.deustocine.app.domain;

import java.util.ArrayList;
import java.util.Objects;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Cine {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
	//commit
	
	private int cod;
	private String nombre;
	private String direccion;
	private int telefono;
	
	public Cine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cine(int cod, String nombre, String direccion, int telefono) {
		super();
		this.cod = cod;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
	}
	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Cine [nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cod);
	}

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
