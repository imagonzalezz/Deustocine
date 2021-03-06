package com.deustocine.app.cliente.controller;

import javax.swing.JLabel;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.deustocine.app.cliente.ventanas.VentanaInicioSesion;
import com.deustocine.app.domain.Usuario;

/**
 * @author Lander
 * Clase que implementa la logica de la ventana de inicio sesion
 * Permite iniciar sesion con el dni y la contrasena
 * Por cada cine que exista se crea un panel con el correspondiente cine
 */
public class InicioSesionController {

	private WebTarget webTarget;
	private Client cliente;

	public InicioSesionController(Client cliente, WebTarget webTarget) {
		super();
		this.cliente = cliente;
		this.webTarget = webTarget;
	}
	
	//Metodo que recibe una respuesta acerca de si coincide el dni y la contrasena

	public boolean logIn(String dni, String password, JLabel lError, VentanaInicioSesion vl) {
		try {
			WebTarget webTarget = this.webTarget.path("/deustocine/login");
			Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
			Usuario u = new Usuario();
			u.setDni(dni);
			u.setContrasenya(password);
			System.out.println(webTarget.getUri());
			//
			Response response = invocationBuilder.post(Entity.entity(u, MediaType.APPLICATION_JSON));

			if (response.getStatus() != Status.OK.getStatusCode()) {
			}
			boolean logIn = response.readEntity(boolean.class);
			if (!logIn) {
				lError.setText("Dni o contrasena incorrectos");
				vl.setLocationRelativeTo(null);
				vl.pack();

			}
			return logIn;
		} catch (Exception e) {
			lError.setText("Error Login");
			System.out.println("* Error " + e.getMessage() + "*");
			vl.pack();
			vl.setLocationRelativeTo(null);
			return false;
		}
	}
	//Metodo que recibe el usuario a traves de su dni

	public Usuario getUsuario(String dni) {
		WebTarget webTarget = this.webTarget.path("getUsuario/" + dni);
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		if (response.getStatus() == Status.OK.getStatusCode()) {
			Usuario u = response.readEntity(Usuario.class);
			return u;
		}
		return null;
	}

}
