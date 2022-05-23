package com.deustocine.app.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.deustocine.app.domain.Pelicula;

public class PeliculaTest {

	private Pelicula p;
	
	@Before
	public void setUp() {
		p = new Pelicula();
	}
	
	@Test
	public void testCod() {
		p.setCod(1);
		assertEquals(p.getCod(),1);
	}
	
	
	@Test
	public void testTitulo() {
		p.setTitulo("Titulo");
		assertTrue(p.getTitulo().equals("Titulo"));
	}
	
	@Test
	public void testDirector() {
		p.setDirector("Director");
		assertTrue(p.getDirector().equals("Director"));
	}
	
	@Test
	public void testPortada() {
		p.setPortada("Portada");
		assertTrue(p.getPortada().equals("Portada"));
	}
	
	@Test
	public void testGenero() {
		p.setGenero("Genero");
		assertTrue(p.getGenero().equals("Genero"));
	}
	
}
