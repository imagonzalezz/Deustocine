package com.deustocine.app.client.controller;

import static org.junit.Assert.*;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.junit.After;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.deustocine.app.categories.IntegrationTest;
import com.deustocine.app.cliente.controller.InicioSesionController;
import com.deustocine.app.cliente.controller.RegistroController;
import com.deustocine.app.domain.Usuario;
import com.deustocine.app.util.CineException;

@Category(IntegrationTest.class)
public class ControllerIntegrationTest {
	
	private PersistenceManagerFactory pmf;

	@Test
	public void test() {
		String hostname = "localhost";
		String port = "8080";
		
		Client c = ClientBuilder.newClient();
		WebTarget wt = c.target(String.format("http://%s:%s/rest", hostname,port));
		
		RegistroController registroController = new RegistroController(wt);
		Usuario usuario = new Usuario();
		usuario.setDni("49201745Y");
		usuario.setContrasenya("con");
		try {
			registroController.registrar(usuario);
		} catch (CineException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		InicioSesionController inicioSesionController = new InicioSesionController(c, wt);
		assertTrue(inicioSesionController.logIn("71237123D", "Contrasenya", null, null));
	}
	
	@After
	public void borrarObjetos() {
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
    	PersistenceManager pm = pmf.getPersistenceManager();
    	//TODO
	}

}
