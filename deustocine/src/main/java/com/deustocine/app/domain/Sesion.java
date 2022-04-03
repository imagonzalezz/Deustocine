package com.deustocine.app.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.TreeMap;

public class Sesion {
	
	private Pelicula pelicula;
	private Sala sala;
	private Date fechaHora;
	private double precio;
	private double puntosObtiene;
	private double valorPuntos;
	public Sesion() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Sesion(Pelicula pelicula, Sala sala, Date fechaHora, double precio, double puntosObtiene,
			double valorPuntos) {
		super();
		this.pelicula = pelicula;
		this.sala = sala;
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

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
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
		return "Sesion [pelicula=" + pelicula + ", sala=" + sala + ", fechaHora=" + fechaHora + ", precio=" + precio
				+ ", puntosObtiene=" + puntosObtiene + ", valorPuntos=" + valorPuntos + "]";
	}
	
}
