package com.deustocine.app.domain;

import java.util.ArrayList;

public class Sala {
	
	private int numero;
	private int numFilas;
	private int numColumnas;
	
	public Sala() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Sala(int numero, int numFilas, int numColumnas) {
		super();
		this.numero = numero;
		this.numFilas = numFilas;
		this.numColumnas = numColumnas;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getNumFilas() {
		return numFilas;
	}

	public void setNumFilas(int numFilas) {
		this.numFilas = numFilas;
	}

	public int getNumColumnas() {
		return numColumnas;
	}

	public void setNumColumnas(int numColumnas) {
		this.numColumnas = numColumnas;
	}

	@Override
	public String toString() {
		return "Sala [numero=" + numero + ", numFilas=" + numFilas + ", numColumnas=" + numColumnas + "]";
	}
	
}
