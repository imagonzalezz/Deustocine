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

import com.deustocine.app.dao.UsuarioDAO;
import com.deustocine.app.domain.Usuario;

public class UsuarioDAOTest {
	@Mock
	PersistenceManagerFactory pmf;
	@Mock
	PersistenceManager pm;
	@Mock
	Transaction ts;
	
	UsuarioDAO dao;
	Usuario u;
	
	@Before
	public void setup() {
		dao= new UsuarioDAO();
		dao.setPmf(pmf);
		u= new Usuario();
		u.setDni("1A");
	}
	
	
		
		@Test
		public void testGuardarUsuario() {
			when(pmf.getPersistenceManager()).thenReturn(pm);
			when(pm.currentTransaction()).thenReturn(ts);
			Usuario c1= new Usuario();
			when(pm.makePersistent(c1)).thenThrow(JDOUserException.class);
			when(ts.isActive()).thenReturn(true);
			dao.guardarUsuario(u);
			when(ts.isActive()).thenReturn(false);
			dao.guardarUsuario(c1);
			assertTrue(true);
		}


		@Test
		public void testGetUsuarios() {
			ExtentPruebasUsuario usuarios= new ExtentPruebasUsuario();
			usuarios.addUsuario(u);
			when(pmf.getPersistenceManager()).thenReturn(pm);
			when(pm.currentTransaction()).thenReturn(ts);
			when(ts.isActive()).thenReturn(true);
			when(pm.getExtent(Usuario.class,true)).thenReturn(usuarios);
			List<Usuario>usuariosLista=dao.getUsuarios();
			when(pm.getExtent(Usuario.class,true)).thenThrow(JDOUserException.class);
			dao.getUsuarios();
			assertEquals(usuariosLista.size(), 1);
		}
		
		

		@Test
		public void testGetUsuario() {
			when(pmf.getPersistenceManager()).thenReturn(pm);
			when(pm.getObjectById(Usuario.class, "1a")).thenReturn(u);
			when(pm.getObjectById(Usuario.class, "2b")).thenThrow(JDOUserException.class);
			Usuario u1=dao.getUsuario("1a");
			assertEquals(u,u1);
			Usuario u2=dao.getUsuario("2b");
			assertEquals(null,u2);
		}
		
		
		
		@Test
		public void testPmf() {
			dao.setPmf(pmf);
			assertEquals(pmf, dao.getPmf());
		}
		
		
		
		class ExtentPruebasUsuario implements Extent<Usuario>{
			ArrayList<Usuario> lUsuarios = new ArrayList<>();
			
			public void addUsuario(Usuario u) {
				lUsuarios.add(u);
				
			}
			
			@Override
			public Iterator<Usuario> iterator() {
				return lUsuarios.iterator();
			}

			@Override
			public boolean hasSubclasses() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public Class<Usuario> getCandidateClass() {
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
			public void close(Iterator<Usuario> it) {
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

