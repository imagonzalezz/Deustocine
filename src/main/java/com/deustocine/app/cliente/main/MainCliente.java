package com.deustocine.app.cliente.main;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import com.deustocine.app.cliente.ventanas.VentanaInicioSesion;

public class MainCliente {
	
	public static void main(String[] args) {
		Client c= ClientBuilder.newClient();
		WebTarget wt =c.target(String.format("http://%s:%s/rest", "localhost","8080"));
		System.out.println(wt.toString());
		VentanaInicioSesion is = new VentanaInicioSesion(c, wt);
	}

}
