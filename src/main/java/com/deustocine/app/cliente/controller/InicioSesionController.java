package com.deustocine.app.cliente.controller;

import javax.swing.JLabel;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.deustocine.app.cliente.ventanas.InicioSesion;
import com.deustocine.app.domain.Usuario;

public class InicioSesionController {

	private WebTarget webTarget;
	private Client cliente;

	public InicioSesionController(Client cliente, WebTarget webTarget) {
		super();
		this.cliente = cliente;
		this.webTarget = webTarget;
	}

	public boolean logIn(String dni, String password, JLabel lError, InicioSesion vl) {
		try {
			WebTarget webTarget = this.webTarget.path("/reventa/logIn");
			Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
			Usuario u = new Usuario();
			u.setDni(dni);
			u.setContrasenya(password);
			System.out.println(webTarget.getUri());
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
			lError.setText("Algo ha fallado al realizar el LogIn");
			System.out.println("* Error " + e.getMessage() + "*");
			vl.pack();
			vl.setLocationRelativeTo(null);
			return false;
		}
	}

	public Usuario getUsuario(String email) {
		WebTarget webTarget = this.webTarget.path("collector/getUsuario/" + email);
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		if (response.getStatus() == Status.OK.getStatusCode()) {
			Usuario u = response.readEntity(Usuario.class);
			return u;
		}
		return null;
	}

}
