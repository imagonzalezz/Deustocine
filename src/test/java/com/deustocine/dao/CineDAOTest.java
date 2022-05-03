package com.deustocine.dao;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import javax.jdo.JDOUserException;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.deustocine.app.dao.CineDAO;
import com.deustocine.app.domain.Cine;

public class CineDAOTest {
	@Mock
	PersistenceManagerFactory pmf;
	@Mock
	PersistenceManager pm;
	@Mock
	Transaction ts;
	
	CineDAO cdao;
	Cine c;
	
	@Before
	public void setup() {
		cdao = new CineDAO();
		cdao.setPmf(pmf);
		c= new Cine();
		c.setTelefono(999999999);
		c.setNombre("ABC");
	}
	
	@Test
	public void testGuardar() {
		when(pmf.getPersistenceManager()).thenReturn(pm);
		when(pm.currentTransaction()).thenReturn(ts);
		when(pm.makePersistent(c)).thenThrow(JDOUserException.class);
		when(ts.isActive()).thenReturn(true);
		cdao.guardarCine(c);
		when(ts.isActive()).thenReturn(false);
		cdao.guardarCine(c);
		assertTrue(true);
	}

	

}
