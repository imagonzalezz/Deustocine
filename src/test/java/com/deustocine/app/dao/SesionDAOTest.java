package com.deustocine.app.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.FetchPlan;
import javax.jdo.JDOUserException;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.deustocine.app.dao.SesionDAO;
import com.deustocine.app.domain.Pelicula;
import com.deustocine.app.domain.Sesion;

@RunWith(MockitoJUnitRunner.class)
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
	

	@Test
	public void testGetSesiones() {
		ExtentPruebas sesiones= new ExtentPruebas();
		sesiones.addProducto(s);
		when(pmf.getPersistenceManager()).thenReturn(pm);
		when(pm.currentTransaction()).thenReturn(ts);
		when(ts.isActive()).thenReturn(true);
		when(pm.getExtent(Sesion.class,true)).thenReturn(sesiones);
		List<Sesion>productoList=sdao.getSesiones();
		when(pm.getExtent(Sesion.class,true)).thenThrow(JDOUserException.class);
		sdao.getSesiones();
		assertEquals(productoList.size(), 1);
		
	}
	

	class ExtentPruebas implements Extent<Sesion> {
		ArrayList<Sesion>lista= new ArrayList<>();
		
		public void addProducto(Sesion cat) {
			lista.add(cat);
		}
		
		@Override
		public Iterator<Sesion> iterator() {
			return lista.iterator();
		}

		@Override
		public boolean hasSubclasses() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Class getCandidateClass() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public PersistenceManager getPersistenceManager() {
			// TODO Auto-generated method stub
			return pm;
		}

		@Override
		public void closeAll() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void close(Iterator it) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void close() throws Exception {
			// TODO Auto-generated method stub
			
		}

		@Override
		public FetchPlan getFetchPlan() {
			// TODO Auto-generated method stub
			return null;
		}

	}

}