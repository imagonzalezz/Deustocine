package com.deustocine.app.rendimiento;

import static org.junit.Assert.*;

import java.util.List;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.deustocine.app.domain.Cine;
import com.deustocine.app.domain.Pelicula;
import com.deustocine.app.domain.Sesion;
import com.deustocine.app.domain.Usuario;
import com.deustocine.app.servicios.DeustocineServicios;




/**
 * @author Lander
 * test de rendimiento de los servicios de Deustocine
 * 
 */
public class DeustocineServicioRendimientoTest {

	DeustocineServicios ds;
	private Usuario u; //Usuario
	private Pelicula p; //Pelicula
	private Sesion s; //Sesion de la pelicula
	private Cine c; //Cine
	
	@Rule public ContiPerfRule rule = new ContiPerfRule();
	
	@Before
	public void setUp() {
		ds= new DeustocineServicios();
		//Asignar datos al usuario
		u= new Usuario();
		u.setDni("71237123D");
		u.setContrasenya("Contrasensya");
		//Asignar datos a la pelicula
		p= new Pelicula();
		p.setCod(1);
		p.setTitulo("Iron Man");
		//Asignar datos a la sesion
		s= new Sesion();
		s.setCod(1);
		s.setPrecio(10);
	}
	//Comprobaciones en el test
	@Test 
    @PerfTest(invocations = 400, threads = 8)
    @Required(max = 2000, average = 200)
	public void testLogIn() {	
		assertTrue(ds.logIn("71237123D", "Contrasenya"));
		assertFalse(ds.logIn(null, "c1"));
		assertFalse(ds.logIn("c1", "c2"));
		assertFalse(ds.logIn("c2", "c3"));
	}
	@Test
	@PerfTest(invocations = 400, threads = 8)
    @Required(max = 2400, average = 200)
	public void testGetPeliculas() {
		List<Pelicula> pos = ds.getPeliculas();
		assertEquals(ds.getPeliculas().size(),4);
	}
	
	@Test
	@PerfTest(invocations = 400, threads = 8)
    @Required(max = 2400, average = 200)
	public void testGetSesiones() {
		List<Sesion> pos = ds.getSesiones();
		assertEquals(ds.getSesiones().size(),2);
	}
	@Test
	@PerfTest(invocations = 400, threads = 8)
    @Required(max = 2400, average = 200)
	public void testGetUsuarios() {
		List<Usuario> pos = ds.getUsuarios();
		assertEquals(ds.getUsuarios().size(),2);
	}
	
	@Test
	@PerfTest(invocations = 400, threads = 8)
    @Required(max = 2400, average = 200)
	public void testGetCines() {
		List<Cine> pos = ds.getCines();
		assertEquals(ds.getCines().size(),4);
	}
	

	
	
	
	
	
	
	
	
	
	
	
	

}
