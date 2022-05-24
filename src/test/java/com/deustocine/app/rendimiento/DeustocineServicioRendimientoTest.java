package com.deustocine.app.rendimiento;

import static org.junit.Assert.*;

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


public class DeustocineServicioRendimientoTest {

	DeustocineServicios ds;
	private Usuario u;
	private Pelicula p;
	private Sesion s;
	private Cine c;      
	
	@Rule public ContiPerfRule rule = new ContiPerfRule();
	
	@Before
	public void setUp() {
		ds= new DeustocineServicios();
		
		u= new Usuario();
		u.setDni("71237123D");
		u.setContrasenya("Contrasenya");
		
		p= new Pelicula();
		p.setCod(1);
		p.setTitulo("Iron Man");
		
		s= new Sesion();
		s.setCod(1);
		s.setPrecio(10);
	}
	
	@Test 
    @PerfTest(invocations = 1000, threads = 20)
    @Required(max = 3000, average = 1500)
	public void testLogIn() {	
		assertTrue(ds.logIn("71237123D", "Contrasenya"));
		assertFalse(ds.logIn(null, "c1"));
		assertFalse(ds.logIn("c1", "c2"));
		assertFalse(ds.logIn("c2", "c3"));
	}

}
