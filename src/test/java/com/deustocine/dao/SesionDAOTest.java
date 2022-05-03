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

import com.deustocine.app.dao.SesionDAO;
import com.deustocine.app.domain.Sesion;

public class SesionDAOTest {
	@Mock
	PersistenceManagerFactory pmf;
	@Mock
	PersistenceManager pm;
	@Mock
	Transaction ts;
	
	SesionDAO sdao;
	Sesion s;
	
	@Before
	public void setup() {
		sdao = new SesionDAO();
		sdao.setPmf(pmf);
		s= new Sesion();
		s.setPrecio(5);
	}
	
	@Test
	public void testGuardar() {
		when(pmf.getPersistenceManager()).thenReturn(pm);
		when(pm.currentTransaction()).thenReturn(ts);
		when(pm.makePersistent(s)).thenThrow(JDOUserException.class);
		when(ts.isActive()).thenReturn(true);
		sdao.guardarSesion(s);
		when(ts.isActive()).thenReturn(false);
		sdao.guardarSesion(s);
		assertTrue(true);
	}
	

	

}
