package com.deustocine.app.dao;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import javax.jdo.JDOUserException;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.deustocine.app.dao.PeliculaDAO;
import com.deustocine.app.dao.SesionDAO;
import com.deustocine.app.domain.Pelicula;
import com.deustocine.app.domain.Sesion;

@RunWith(MockitoJUnitRunner.class)
public class PeliculaDAOTest {

	@Mock
	PersistenceManagerFactory pmf;
	@Mock
	PersistenceManager pm;
	@Mock
	Transaction ts;
	
	PeliculaDAO pDao;
	Pelicula p;
	
	@Before
	public void setup() {
		pDao = new PeliculaDAO();
		pDao.setPmf(pmf);
		p = new Pelicula();
		p.setCod(1);
	}
	
	@Test
	public void testGuardarPelicula() {
		Pelicula p2 = new Pelicula();
		when(pmf.getPersistenceManager()).thenReturn(pm);
		when(pm.currentTransaction()).thenReturn(ts);
		when(pm.makePersistent(p2)).thenThrow(JDOUserException.class);
		when(ts.isActive()).thenReturn(true);
		pDao.guardarPelicula(p2);
		when(ts.isActive()).thenReturn(false);
		pDao.guardarPelicula(p);
		assertTrue(true);
	}
}
