package com.deustocine.app.domain;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Pelicula {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
	private int cod;
	
	private String titulo;
	private String director;
	private Date fechaSalida;
	private String genero;
	private String portada;
	
	public Pelicula() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pelicula(String titulo, String director, Date fechaSalida, String genero, String portada) {
		super();
		this.titulo = titulo;
		this.director = director;
		this.fechaSalida = fechaSalida;
		this.genero = genero;
		this.portada = portada;
	}
	
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public Date getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getPortada() {
		return portada;
	}
	public void setPortada(String portada) {
		this.portada = portada;
	}
	@Override
	public String toString() {
		return "Pelicula [titulo=" + titulo + ", director=" + director + ", fechaSalida=" + fechaSalida + ", genero="
				+ genero + ", portada=" + portada + "]";
	}

    
	
	

}
