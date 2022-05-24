package com.deustocine.app.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * Clase pelicula
 * @author Iker
 *
 */
@PersistenceCapable
public class Pelicula {
	
	private String dateFormat = "dd/MM/YYYY";
	private SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
	private int cod; /**< Codigo identificativo de la pelicula */
	
	private String titulo; /**< Titulo de la pelicula */
	private String director; /**< Director de la pelicula */
	private String fechaSalida; /**< Fecha de salida de la pelicula */
	private String genero; /**< Genero de la pelicula */
	private String portada; /**< Ruta de la portada de la pelicula */
	
	/**
	 * Constructor por defecto
	 */
	public Pelicula() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructor con parametros
	 * @param titulo Titulo de la pelicula
	 * @param director Director de la pelicula
	 * @param fechaSalida Fecha de salida de la pelicula
	 * @param genero Genero de la pelicula
	 * @param portada Ruta de la portada de la pelicula
	 */
	public Pelicula(String titulo, String director, String fechaSalida, String genero, String portada) {
		super();
		this.titulo = titulo;
		this.director = director;
		this.fechaSalida = fechaSalida;
		this.genero = genero;
		this.portada = portada;
	}
	
	/**
	 * Devuelve el codigo identificativo de la pelicula
	 * @return
	 */
	public int getCod() {
		return cod;
	}
	
	/**
	 * Establece el codigo identificativo de la pelicula
	 * @param cod Codigo a establecer
	 */
	public void setCod(int cod) {
		this.cod = cod;
	}
	
	/**
	 * Devuelve el titulo de la pelicula
	 * @return Titulo de la pelicula
	 */
	public String getTitulo() {
		return titulo;
	}
	
	/**
	 * Establece el titulo de la pelicula
	 * @param titulo
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	/**
	 * Devuelve el director de la pelicula
	 * @return Director de la pelicula
	 */
	public String getDirector() {
		return director;
	}
	
	/**
	 * Establece el director de la pelicula
	 * @param director Director a establecer
	 */
	public void setDirector(String director) {
		this.director = director;
	}
	
	/**
	 * Devuelve la fecha de salida de la pelicula
	 * @return Fecha de salida de la pelicula
	 */
	public String getFechaSalida() {
		return fechaSalida;
	}
	
	/**
	 * Establece la fecha de salida de la pelicula
	 * @param string Fecha de salida de la pelicula
	 */
	public void setFechaSalida(String string) {
		this.fechaSalida = string;
	}
	
	/**
	 * Devuelve el genero de la pelicula
	 * @return Genero de la pelicula
	 */
	public String getGenero() {
		return genero;
	}
	
	/**
	 * Establece el genero de la pelicula
	 * @param genero Genero a establecer
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	/**
	 * Devuelve la ruta de la portada de la pelicula
	 * @return Ruta de la portada de la pelicula
	 */
	public String getPortada() {
		return portada;
	}
	
	/**^
	 * Establece la ruta de la portada de la pelicula
	 * @param portada Ruta de la portada de la pelicula
	 */
	public void setPortada(String portada) {
		this.portada = portada;
	}
	
	/**
	 * Imprime los datos de la pelicula
	 */
	@Override
	public String toString() {
		return "Pelicula [titulo=" + titulo + ", director=" + director + ", fechaSalida=" + fechaSalida + ", genero="
				+ genero + ", portada=" + portada + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(cod);
	}
	
	/**
	 * Indica si dos peliculas son iguales
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pelicula other = (Pelicula) obj;
		return cod == other.cod;
	}
	

}
