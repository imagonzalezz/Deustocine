package com.deustocine.app.client.controller;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.datastore.JDOConnection;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.junit.After;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.deustocine.app.categories.IntegrationTest;
import com.deustocine.app.cliente.controller.CinesController;
import com.deustocine.app.cliente.controller.InicioSesionController;
import com.deustocine.app.cliente.controller.RegistroController;
import com.deustocine.app.cliente.controller.SesionesController;
import com.deustocine.app.cliente.controller.PeliculasController;
import com.deustocine.app.domain.Pelicula;
import com.deustocine.app.domain.Sesion;
import com.deustocine.app.domain.Usuario;
import com.deustocine.app.domain.Cine;
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
		assertTrue(inicioSesionController.logIn("49201745Y", "con", null, null));
		
		PeliculasController peliculasController = new PeliculasController(wt);
		List<Pelicula> peliculas = peliculasController.getPeliculas();
		
		SesionesController sesionesController = new SesionesController(wt);
		List<Sesion> sesiones = sesionesController.getSesiones();
		
		CinesController cinesController = new CinesController(wt);
		List<Cine> cine = cinesController.getCines();
	}
	
	@After
	public void borrarObjetos() {
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
    	PersistenceManager pm = pmf.getPersistenceManager();
    	Usuario u = pm.getObjectById(Usuario.class,"49201745Y");
    	
    	JDOConnection jCon = pm.getDataStoreConnection();
    	Object con = jCon.getNativeConnection();
    	if (con instanceof Connection) {
    		try {
				((Connection) con).setSchema("deustocinedb");
				((Connection) con).setAutoCommit(true);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}try {
			Statement s = ((Connection) con).createStatement();
			s.executeUpdate("DELETE FROM `deustocinedb`.`usuario` WHERE (`DNI` = '49201745Y');");
			s.close();
			((Connection) con).close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}


