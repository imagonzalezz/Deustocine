//package com.deustocine.app.domain;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import com.deustocine.app.domain.Cine;
//import com.deustocine.app.domain.Pelicula;
//import com.deustocine.app.domain.Sesion;
//
//public class SesionTest {
//	
//	private Sesion s= new Sesion();
//	private Pelicula p;
//	private Cine c;
//
//	@Before
//	public void setUp() {
//		p = new Pelicula();
//		c = new Cine();
//		p.setDirector("Tarantino");
//		p.setGenero("Drama");
//		p.setTitulo("Interstellar");
//		p.setFechaSalida(null);
//		p.setPortada("0");
//		c.setDireccion("Gran Via");
//		c.setNombre("Mikeldi");
//		c.setTelefono(65463653);
//		
//	}
//	
//	@Test
//	public void testConstructor() {
//		Sesion s= new Sesion(p, "10/05/2022 12:00", 1, 2, 3);
//		boolean test=false;
//		if (s.getPrecio()==1 && s.getPuntosObtiene() == 2 && s.getValorPuntos()==3) {
//			test=true;
//		}
//		assertTrue(test);
//	}
//	
//	@Test
//	public void testFechaHora() {
//		s.setFechaHora(null);
//		assertEquals(s.getFechaHora(),null);
//	}
//	
//	@Test
//	public void testPelicula() {
//		s.setPelicula(p);
//		assertEquals(s.getPelicula().getTitulo(),"Interstellar");
//	}
//	
//	@Test
//	public void testPrecio() {
//		s.setPrecio(5);
//		assertTrue(s.getPrecio()== 5);
//	}
//	
//	@Test
//	public void testPuntosObtiene() {
//		s.setPuntosObtiene(4);
//		assertTrue(s.getPuntosObtiene()== 4);
//	}
//	
//	@Test
//	public void testValorPuntos() {
//		s.setValorPuntos(3);
//		assertTrue(s.getValorPuntos()== 3);
//	}
//	
//	
//	
//}
