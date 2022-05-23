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
//import com.deustocine.app.domain.Usuario;
//
//@RunWith(MockitoJUnitRunner.class)
//
//
//public class UsuarioDAOTest {
//	@Mock
//	PersistenceManagerFactory pmf;
//	@Mock
//	PersistenceManager pm;
//	@Mock
//	Transaction ts;
//	
//	UsuarioDAO usudao;
//	Usuario usu;
//	
//	@Before
//	public void setup() {
//		usudao= new UsuarioDAO();
//		usudao.setPmf(pmf);
//		usu = new Usuario();
//		usu.setDni("16104098H");
//	}
//	
//	
//		
//		@Test
//		public void testGuardarUsuario() {
//			when(pmf.getPersistenceManager()).thenReturn(pm);
//			when(pm.currentTransaction()).thenReturn(ts);
//			Usuario usu1= new Usuario();
//			when(pm.makePersistent(usu1)).thenThrow(JDOUserException.class);
//			when(ts.isActive()).thenReturn(true);
//			usudao.guardarUsuario(usu);
//			when(ts.isActive()).thenReturn(false);
//			usudao.guardarUsuario(usu1);
//			assertTrue(true);
//		}
//
//
//		@Test
//		public void testGetUsuario() {
//			ExtentPruebasUsuario usuarios  = new ExtentPruebasUsuario();
//			usuarios.addProducto(usu);
//			when(pmf.getPersistenceManager()).thenReturn(pm);
//			when(pm.currentTransaction()).thenReturn(ts);
//			when(ts.isActive()).thenReturn(true);
//			when(pm.getExtent(Usuario.class,true)).thenReturn(usuarios);
//			List<Usuario>usuariosLista=usudao.getUsuarios();
//			when(pm.getExtent(Usuario.class,true)).thenThrow(JDOUserException.class);
//			usudao.getUsuarios();
//			assertEquals(usuariosLista.size(), 1);
//		}
//		
//
//		
//		
//		
//
//
//		@Test
//		public void testPmf() {
//			usudao.setPmf(pmf);
//			assertEquals(pmf, usudao.getPmf());
//		}
//		
//		
//		
//		class ExtentPruebasUsuario implements Extent<Usuario>{
//			ArrayList<Usuario> lUsuarios = new ArrayList<>();
//			
//			public void addProducto(Usuario usu) {
//				lUsuarios.add(usu);
//				
//			}
//			
//			@Override
//			public Iterator<Usuario> iterator() {
//				return lUsuarios.iterator();
//			}
//
//			@Override
//			public boolean hasSubclasses() {
//				// TODO Auto-generated method stub
//				return false;
//			}
//
//			@Override
//			public Class<Usuario> getCandidateClass() {
//				// TODO Auto-generated method stub
//				return null;
//			}
//
//			@Override
//			public PersistenceManager getPersistenceManager() {
//				return pm;
//			}
//
//			@Override
//			public void closeAll() {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void close(Iterator<Usuario> it) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void close() throws Exception {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public FetchPlan getFetchPlan() {
//				// TODO Auto-generated method stub
//				return null;
//			}
//			
//		}
//	
//	
//}
//
