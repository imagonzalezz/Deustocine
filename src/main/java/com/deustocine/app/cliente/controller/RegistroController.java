package com.deustocine.app.cliente.controller;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.deustocine.app.domain.Usuario;
import com.deustocine.app.util.CineException;
/**
 * @author Lander
 * Clase que implementa la logica de la ventana registro
 * Permite registrarse a usuarios
 * 
 */
public class RegistroController {

	private WebTarget webTarget;

	public RegistroController(WebTarget webTarget) {
		this.webTarget = webTarget;
	}
//Metodo utilizado para registrarse
	public void registrar(Usuario u) throws CineException {
		WebTarget webTarget = this.webTarget.path("/deustocine/registro");
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(u, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			throw new CineException("" + response.getStatus());

		}

	}
}
