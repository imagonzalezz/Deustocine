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
		u.setContrasenya("Contrasenya");
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
    @PerfTest(invocations = 1000, threads = 20)
    @Required(max = 3000, average = 1500)
	public void testLogIn() {	
		//assertTrue(ds.logIn("71237123D", "Contrasenya")); //FIXME
		assertFalse(ds.logIn(null, "c1"));
		assertFalse(ds.logIn("c1", "c2"));
		assertFalse(ds.logIn("c2", "c3"));
	}

}
