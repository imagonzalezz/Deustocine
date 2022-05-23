package com.deustocine.app.rendimiento;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.deustocine.app.domain.Entrada;
import com.deustocine.app.domain.Sesion;
import com.deustocine.app.domain.Usuario;
import com.deustocine.app.server.MainServer;
import com.deustocine.app.servicios.UsuarioServicio;




public class UsuarioServicioRendimientoTest {
	UsuarioServicio usu;
	private Usuario u;
	
	@Before
	public void setUp() {
		
		usu= new UsuarioServicio();
		u= new Usuario();
		u.setDni("71237123D");
		u.setContrasenya("Contrasenya");
	

	}
	
	@Test 
    @PerfTest(invocations = 1000, threads = 20)
    @Required(max = 3000, average = 1500)
	public void testLogIn() {	
		assertTrue(usu.logIn("71237123D", "Contrasenya"));
		assertFalse(usu.logIn(null, "a"));
		assertFalse(usu.logIn("a", "b"));
		assertFalse(usu.logIn("b", "b"));
	}
	
	

}
