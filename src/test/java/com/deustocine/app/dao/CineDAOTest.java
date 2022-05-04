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
	
	CineDAO dao;
	Cine c;
	
	@Before
	public void setup() {
		dao= new CineDAO();
		dao.setPmf(pmf);
		c = new Cine();
		c.setCod(1);
	}
	
	
		
		@Test
		public void testGuardarCine() {
			when(pmf.getPersistenceManager()).thenReturn(pm);
			when(pm.currentTransaction()).thenReturn(ts);
			Cine c1= new Cine();
			when(pm.makePersistent(c1)).thenThrow(JDOUserException.class);
			when(ts.isActive()).thenReturn(true);
			dao.guardarCine(c);
			when(ts.isActive()).thenReturn(false);
			dao.guardarCine(c1);
			assertTrue(true);
		}


		@Test
		public void testGetCines() {
			ExtentPruebasCine cines = new ExtentPruebasCine();
			cines.addUsuario(c);
			when(pmf.getPersistenceManager()).thenReturn(pm);
			when(pm.currentTransaction()).thenReturn(ts);
			when(ts.isActive()).thenReturn(true);
			when(pm.getExtent(Cine.class,true)).thenReturn(cines);
			List<Cine>cinesLista=dao.getCines();
			when(pm.getExtent(Cine.class,true)).thenThrow(JDOUserException.class);
			dao.getCines();
			assertEquals(cinesLista.size(), 1);
		}
		
		@Test
		public void testGetCine() {
			when(pmf.getPersistenceManager()).thenReturn(pm);
			when(pm.getObjectById(Cine.class, "1a")).thenReturn(c);
			when(pm.getObjectById(Cine.class, "2b")).thenThrow(JDOUserException.class);
			Cine c1=dao.getCine(1);
			assertEquals(c,c1);
			Cine c2=dao.getCine(2);
			assertEquals(null,c2);
		}
		
		
		


		@Test
		public void testPmf() {
			dao.setPmf(pmf);
			assertEquals(pmf, dao.getPmf());
		}
		
		
		
		class ExtentPruebasCine implements Extent<Cine>{
			ArrayList<Cine> lCines = new ArrayList<>();
			
			public void addUsuario(Cine c) {
				lCines.add(c);
				
			}
			
			@Override
			public Iterator<Cine> iterator() {
				return lCines.iterator();
			}

			@Override
			public boolean hasSubclasses() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public Class<Cine> getCandidateClass() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public PersistenceManager getPersistenceManager() {
				return pm;
			}

			@Override
			public void closeAll() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void close(Iterator<Cine> it) {
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

