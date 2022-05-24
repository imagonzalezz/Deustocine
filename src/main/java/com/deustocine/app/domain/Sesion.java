package com.deustocine.app.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;
import java.util.TreeMap;

import javax.jdo.annotations.ForeignKey;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * Clase sesion
 * @author Iker
 *
 */
@PersistenceCapable
public class Sesion {
	
	private String dateFormat = "dd/MM/YYYY HH:mm";
	private SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
	private int cod; /**< Codigo identificativo de la sesion */
	@ForeignKey
	private Cine cine; /**< Cine que corresponde a la sesion */
	@ForeignKey
	private Pelicula pelicula; /**< Pelicula que corresponde a la sesion */
	private String fechaHora; /**< Fecha y hora de la sesion */
	private double precio; /**< Precio de la sesion */
	private double puntosObtiene; /** Puntos que obtiene un usuario por adquirir una entrada de la sesion */
	private double valorPuntos; /** Valor en puntos de la sesion */
	
	/**
	 * Constructor por defecto
	 */
	public Sesion() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructor con parametros
	 * @param pelicula Pelicula que corresponde a la sesion
	 * @param fechaHora Fecha y hora de la sesion
	 * @param precio Precio de la sesion
	 * @param puntosObtiene Puntos que otorga al usuario por su compra
	 * @param valorPuntos Valor en puntos
	 */
	public Sesion(Pelicula pelicula, String fechaHora, double precio, double puntosObtiene,
			double valorPuntos) {
		super();
		this.pelicula = pelicula;
		this.fechaHora = fechaHora;
		this.precio = precio;
		this.puntosObtiene = puntosObtiene;
		this.valorPuntos = valorPuntos;
	}
	
	/**
	 * Devuelve el codigo identificativo de la sesion
	 * @return Codigo identificativo
	 */
	public int getCod() {
		return cod;
	}

	/**
	 * Establece el codigo identificativo de la sesion
	 * @param cod Codigo identificativo
	 */
	public void setCod(int cod) {
		this.cod = cod;
	}
	
	/**
	 * Devuelve el cine que corresponde a la sesion
	 * @return Cine
	 */
	public Cine getCine() {
		return cine;
	}

	/**
	 * Establece el cine que corresponde a la sesion
	 * @param cine Cine a establecer
	 */
	public void setCine(Cine cine) {
		this.cine = cine;
	}

	/**
	 * Devuelve la pelicula que corresponde a la sesion
	 * @return Pelicula
	 */
	public Pelicula getPelicula() {
		return pelicula;
	}

	/**
	 * Establece la pelicula que corresponde a la sesion
	 * @param pelicula Pelicula a establecer
	 */
	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	/**
	 * Devuelve la fecha y hora de la sesion
	 * @return Fecha y hora
	 */
	public String getFechaHora() {
		return fechaHora;
	}

	/**
	 * Establece la fecha y hora de la sesion
	 * @param string Fecha y hora
	 */
	public void setFechaHora(String string) {
		this.fechaHora = string;
	}

	/**
	 * Devuelve el precio de la sesion
	 * @return Precio
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * Establece el precio de la sesion
	 * @param precio Precio a establecer
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * Devuelve los puntos que otorga al usuario por su compra
	 * @return Puntos
	 */
	public double getPuntosObtiene() {
		return puntosObtiene;
	}

	/**
	 * Establece los puntos que otorga al usuario por su compra
	 * @param puntosObtiene Puntos a establecer
	 */
	public void setPuntosObtiene(double puntosObtiene) {
		this.puntosObtiene = puntosObtiene;
	}

	/**
	 * Devuelve el valor en puntos de la sesion
	 * @return Puntos
	 */
	public double getValorPuntos() {
		return valorPuntos;
	}
	
	/**
	 * Establece el valor en puntos de la sesion
	 * @param valorPuntos puntos
	 */
	public void setValorPuntos(double valorPuntos) {
		this.valorPuntos = valorPuntos;
	}

	/**
	 * Imprime los datos de la sesion
	 */
	@Override
	public String toString() {
		return "Sesion [cod=" + cod + ", pelicula=" + pelicula + ", fechaHora=" + fechaHora + ", precio=" + precio
				+ ", puntosObtiene=" + puntosObtiene + ", valorPuntos=" + valorPuntos + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cine, cod, dateFormat, fechaHora, pelicula, precio, puntosObtiene, sdf, valorPuntos);
	}

	/**
	 * Indica si dos sesiones son iguales
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sesion other = (Sesion) obj;
		return Objects.equals(cine, other.cine) && cod == other.cod && Objects.equals(dateFormat, other.dateFormat)
				&& Objects.equals(fechaHora, other.fechaHora) && Objects.equals(pelicula, other.pelicula)
				&& Double.doubleToLongBits(precio) == Double.doubleToLongBits(other.precio)
				&& Double.doubleToLongBits(puntosObtiene) == Double.doubleToLongBits(other.puntosObtiene)
				&& Objects.equals(sdf, other.sdf)
				&& Double.doubleToLongBits(valorPuntos) == Double.doubleToLongBits(other.valorPuntos);
	}
	
	
}
