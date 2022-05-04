package com.deustocine.app.ventanas;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.mockito.Mock;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.WebTarget;

public class InicioSesionTest {
	@Mock
	Client cliente;
	@Mock
	WebTarget webTarget;

	
	//Client cliente, WebTarget webTarget
	@Test
	public void test(){
		try {
			InicioSesion is = new InicioSesion(cliente, webTarget);
		}catch(Exception e) {
			assertTrue(false);
		}
	}
}
