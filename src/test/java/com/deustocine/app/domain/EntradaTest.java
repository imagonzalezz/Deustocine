package com.deustocine.app.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.deustocine.app.domain.Entrada;
import com.deustocine.app.domain.Usuario;
import com.deustocine.app.domain.Sesion;

public class EntradaTest {

	private Entrada e, e2;
	private Usuario u;
	private Sesion s;
	
	@Before
	public void setUp() {
		e = new Entrada();
		e2 = new Entrada();
		u = new Usuario();
		s = new Sesion();
	}
	
	@Test
	public void testCod() {
		e.setCod(1);
		assertEquals(e.getCod(),1);
		
		e2.setCod(2);
		assertEquals(e2.getCod(),2);
	}
	
	
	@Test
	public void testUsuario() {
		u.setNombre("Lander");
		assertTrue(u.getNombre().equals("Lander"));
		
		ArrayList<Usuario>usuarios= new ArrayList<>();
		usuarios.add(u);
		assertEquals(usuarios.size(),1);
	}
	
	@Test
	public void testSesion() {
		ArrayList<Sesion>sesiones= new ArrayList<>();
		sesiones.add(s);
		assertEquals(sesiones.size(),1);
	}
	

	
	
	
}
