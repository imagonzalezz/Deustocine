package com.deustocine.app.dao;


import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.PersistenceManager;
import javax.jdo.Transaction;
import com.deustocine.app.domain.Usuario;


public class UsuarioDAO {
	private PersistenceManagerFactory pmf;
	
	
	public UsuarioDAO() {
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	}
	
	public void guardarUsuario(Usuario u) {
		this.guardarObjeto(u);
	}
	
	private void guardarObjeto(Object o) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction ts = pm.currentTransaction();

		try {
			ts.begin();
			System.out.println("   * Storing an object: " + o);
			pm.makePersistent(o);
			ts.commit();
		} catch (Exception ex) {
			System.out.println("   $ Error storing an object: " + ex.getMessage());
		} finally {
			if (ts != null && ts.isActive()) {
				ts.rollback();
			}

			pm.close();
		}
	}
	
	public List<Usuario> getUsuarios() {
		PersistenceManager pm = pmf.getPersistenceManager();

		Transaction ts = pm.currentTransaction();
		List<Usuario> usuarios = new ArrayList<>();

		try {
			System.out.println("   * Retrieving an Extent for Products.");

			ts.begin();
			Extent<Usuario> extent = pm.getExtent(Usuario.class, true);

			for (Usuario u : extent) {
				usuarios.add(u);
			}

			ts.commit();
		} catch (Exception ex) {
			System.out.println("   $ Error retrieving an extent: " + ex.getMessage());
		} finally {
			if (ts != null && ts.isActive()) {
				ts.rollback();
			}

			pm.close();
		}

		return usuarios;
	}
	
	public void setPmf(PersistenceManagerFactory pmf) {
		this.pmf = pmf;
	}
	
	public PersistenceManagerFactory getPmf() {
		return this.pmf;
	}
	
	public Usuario getUsuario(String dni) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Usuario usuario = null;

		try {
			usuario=pm.getObjectById(Usuario.class, dni);
			pm.makeTransient(usuario);

		} catch (Exception ex) {
			System.out.println("   $ Error no existe ese usuario: " + ex.getMessage());
			return null;
		} finally {
			pm.close();
		}

		return usuario;
	}


}
	