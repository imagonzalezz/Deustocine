package com.deustocine.app.dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.deustocine.app.domain.Cine;
import com.deustocine.app.domain.Usuario;

public class CineDAO {

	private PersistenceManagerFactory pmf;

	public CineDAO() {
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	}
	
	public void guardarCine(Cine cine) {
		this.guardarObjeto(cine);
	}
	
	public void guardarObjeto(Object objeto) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			System.out.println("   * Guardando cine: " + objeto);
			pm.makePersistent(objeto);
			tx.commit();
		} catch (Exception ex) {
			System.out.println("   $ Error al guardar objeto: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
	}
	
	public void setPmf(PersistenceManagerFactory pmf) {
		this.pmf = pmf;
	}
	
	public PersistenceManagerFactory getPmf() {
		return this.pmf;
	}
	
	public void borrarProductos() {
		System.out.println("- Borrando BD...");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			
			// Getting ready for removing objects - Remove Relationships between User and other things
			Extent<Cine> extentU = pm.getExtent(Cine.class, true);
			
		
			// Updating the database so changes are considered before commit
			pm.flush();

			// Deleting All Products - Copies in Books will be deleted due to 'delete on cascade'
			Query<Cine> query2 = pm.newQuery(Cine.class);
			System.out.println(" * '" + query2.deletePersistentAll() + "' productos eliminados de la BD.");

			tx.commit();
		} catch (Exception ex) {
			System.err.println(" $ Error borrando la bd: " + ex.getMessage());
			ex.printStackTrace();
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}
	}
	
	public List<Cine> getCines() {
		PersistenceManager pm = pmf.getPersistenceManager();
		/*
		 * By default only 1 level is retrieved from the db so if we wish to fetch more
		 * than one level, we must indicate it
		 */
		pm.getFetchPlan().setMaxFetchDepth(3);

		Transaction tx = pm.currentTransaction();
		List<Cine> cines = new ArrayList<>();

		try {
			System.out.println("   * Recuperando productos.");

			tx.begin();
			Extent<Cine> extent = pm.getExtent(Cine.class, true);

			for (Cine c : extent) {
				cines.add(c);
			}

			tx.commit();
		} catch (Exception ex) {
			System.out.println("   $ Error recuperando productos: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return cines;
	}
	
	public void actualizarCine(Cine cine) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			pm.makePersistent(cine);
			tx.commit();
		} catch (Exception ex) {
			System.out.println("   $ Error actualizando el cine: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
	}
	public Cine getCine(int cod) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Cine cine = null;

		try {
			cine=pm.getObjectById(Cine.class, cod);
			pm.makeTransient(cine);

		} catch (Exception ex) {
			System.out.println("   $ Error no existe ese cine: " + ex.getMessage());
			return null;
		} finally {
			pm.close();
		}

		return cine;
	}
	
	
}
