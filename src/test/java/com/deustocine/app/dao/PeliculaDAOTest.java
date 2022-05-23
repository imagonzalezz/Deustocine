//package com.deustocine.app.dao;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//import javax.jdo.Extent;
//import javax.jdo.FetchPlan;
//import javax.jdo.JDOUserException;
//import javax.jdo.PersistenceManager;
//import javax.jdo.PersistenceManagerFactory;
//import javax.jdo.Transaction;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.runners.MockitoJUnitRunner;
//
//import com.deustocine.app.dao.PeliculaDAO;
//import com.deustocine.app.dao.SesionDAO;
//import com.deustocine.app.domain.Pelicula;
//import com.deustocine.app.domain.Sesion;
//
//
//@RunWith(MockitoJUnitRunner.class)
//public class PeliculaDAOTest {
//
//	@Mock
//	PersistenceManagerFactory pmf;
//	@Mock
//	PersistenceManager pm;
//	@Mock
//	Transaction ts;
//	
//	PeliculaDAO pDao;
//	Pelicula p;
//	
//	@Before
//	public void setup() {
//		pDao = new PeliculaDAO();
//		pDao.setPmf(pmf);
//		p = new Pelicula();
//		p.setCod(1);
//	}
//
//	@Test
//	public void testPmf() {
//		pDao.setPmf(pmf);
//		assertEquals(pmf, pDao.getPmf());
//	}
//
//	@Test
//	public void testGuardarPelicula() {
//		when(pmf.getPersistenceManager()).thenReturn(pm);
//		when(pm.currentTransaction()).thenReturn(ts);
//		when(pm.makePersistent(p)).thenThrow(JDOUserException.class);
//		when(ts.isActive()).thenReturn(true);
//		pDao.guardarPelicula(p);
//		when(ts.isActive()).thenReturn(false);
//		pDao.guardarPelicula(p);
//		assertTrue(true);
//		
//		
//		
//	}
//	
//	@Test
//	public void testGetPeliculas() {
//		ExtentPruebas peliculas= new ExtentPruebas();
//		peliculas.addProducto(p);
//		when(pmf.getPersistenceManager()).thenReturn(pm);
//		when(pm.currentTransaction()).thenReturn(ts);
//		when(ts.isActive()).thenReturn(true);
//		when(pm.getExtent(Pelicula.class,true)).thenReturn(peliculas);
//		List<Pelicula>peliculaList=pDao.getPeliculas();
//		when(pm.getExtent(Pelicula.class,true)).thenThrow(JDOUserException.class);
//		pDao.getPeliculas();
//		assertEquals(peliculaList.size(), 1);
//		
//	}
//	
//	
//	
//	
//
//	class ExtentPruebas implements Extent<Pelicula> {
//		ArrayList<Pelicula>lista= new ArrayList<>();
//		
//		public void addProducto(Pelicula cat) {
//			lista.add(cat);
//		}
//		
//		@Override
//		public Iterator<Pelicula> iterator() {
//			return lista.iterator();
//		}
//
//		@Override
//		public boolean hasSubclasses() {
//			// TODO Auto-generated method stub
//			return false;
//		}
//
//		@Override
//		public Class getCandidateClass() {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
//		@Override
//		public PersistenceManager getPersistenceManager() {
//			// TODO Auto-generated method stub
//			return pm;
//		}
//
//		@Override
//		public void closeAll() {
//			// TODO Auto-generated method stub
//			
//		}
//
//		@Override
//		public void close(Iterator it) {
//			// TODO Auto-generated method stub
//			
//		}
//
//		@Override
//		public void close() throws Exception {
//			// TODO Auto-generated method stub
//			
//		}
//
//		@Override
//		public FetchPlan getFetchPlan() {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
//	}
//	
//	
//	
//	
//}
