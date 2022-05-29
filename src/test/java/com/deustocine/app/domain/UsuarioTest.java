package com.deustocine.app.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.deustocine.app.domain.Usuario;

public class UsuarioTest {

	private Usuario u, u2;
	
	@Before
	public void setUp() {
		u = new Usuario();
		u2 = new Usuario();
	}
	
	@Test
	public void testDni() {
		u.setDni("12345678J");
		assertEquals(u.getDni(),"12345678J");
		
		u2.setDni("12345678A");
		assertEquals(u2.getDni(),"12345678A");
	}
	
	
	@Test
	public void testNombre() {
		u.setNombre("Lander");
		assertTrue(u.getNombre().equals("Lander"));
		
		u2.setNombre("Unai");
		assertTrue(u2.getNombre().equals("Unai"));
	}
	
	@Test
	public void testContrasenya() {
		u.setContrasenya("ABC");
		assertTrue(u.getContrasenya().equals("ABC"));
		
		u2.setContrasenya("CBA");
		assertTrue(u2.getContrasenya().equals("CBA"));
	}
	
	
	
	
}
