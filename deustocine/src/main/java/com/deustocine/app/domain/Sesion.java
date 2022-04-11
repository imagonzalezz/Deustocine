package com.deustocine.app.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.TreeMap;

import javax.jdo.annotations.ForeignKey;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Sesion {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
	private int cod;
	@ForeignKey
	private Cine cine;
	@ForeignKey
	private Pelicula pelicula;
	private Date fechaHora;
	private double precio;
	private double puntosObtiene;
	private double valorPuntos;
	public Sesion() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Sesion(Pelicula pelicula, Date fechaHora, double precio, double puntosObtiene,
			double valorPuntos) {
		super();
		this.pelicula = pelicula;
		this.fechaHora = fechaHora;
		this.precio = precio;
		this.puntosObtiene = puntosObtiene;
		this.valorPuntos = valorPuntos;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public Date getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getPuntosObtiene() {
		return puntosObtiene;
	}

	public void setPuntosObtiene(double puntosObtiene) {
		this.puntosObtiene = puntosObtiene;
	}

	public double getValorPuntos() {
		return valorPuntos;
	}

	public void setValorPuntos(double valorPuntos) {
		this.valorPuntos = valorPuntos;
	}

	@Override
	public String toString() {
		return "Sesion [cod=" + cod + ", pelicula=" + pelicula + ", fechaHora=" + fechaHora + ", precio=" + precio
				+ ", puntosObtiene=" + puntosObtiene + ", valorPuntos=" + valorPuntos + "]";
	}
	
}
