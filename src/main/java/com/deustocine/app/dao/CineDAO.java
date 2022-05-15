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
	
	
	
	public List<Cine> getCines() {
		PersistenceManager pm = pmf.getPersistenceManager();
		/*
		 * By default only 1 level is retrieved from the db so if we wish to fetch more
		 * than one level, we must indicate it
		 */

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
	
	
	
}
