package com.deustocine.app.dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.deustocine.app.domain.Pelicula;

public class PeliculaDAO {

	private PersistenceManagerFactory pmf;

	public PeliculaDAO() {
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	}
	
	public void guardarPelicula(Pelicula pelicula) {
		this.guardarObjeto(pelicula);
	}
	
	public void guardarObjeto(Object object) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			System.out.println("   *  an Pelicula: " + object);
			pm.makePersistent(object);
			tx.commit();
		} catch (Exception ex) {
			System.out.println("   $ Error storing an object: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
	}
	
	public void borrarProductos() {
		System.out.println("- Cleaning the DB...");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			
			// Getting ready for removing objects - Remove Relationships between User and other things
			Extent<Pelicula> extentU = pm.getExtent(Pelicula.class, true);
			
		
			// Updating the database so changes are considered before commit
			pm.flush();

			// Deleting All Products - Copies in Books will be deleted due to 'delete on cascade'
			Query<Pelicula> query2 = pm.newQuery(Pelicula.class);
			System.out.println(" * '" + query2.deletePersistentAll() + "' peliculas deleted from the DB.");

			tx.commit();
		} catch (Exception ex) {
			System.err.println(" $ Error cleaning the DB: " + ex.getMessage());
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
	
	public List<Pelicula> getPeliculas() {
		PersistenceManager pm = pmf.getPersistenceManager();
		/*
		 * By default only 1 level is retrieved from the db so if we wish to fetch more
		 * than one level, we must indicate it
		 */

		Transaction tx = pm.currentTransaction();
		List<Pelicula> peliculas = new ArrayList<>();

		try {
			System.out.println("   * Retrieving an Extent for Peliculas.");

			tx.begin();
			Extent<Pelicula> extent = pm.getExtent(Pelicula.class, true);

			for (Pelicula p : extent) {
				peliculas.add(p);
			}

			tx.commit();
		} catch (Exception ex) {
			System.out.println("   $ Error retrieving an extent: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return peliculas;
	}
	
	
	public void setPmf(PersistenceManagerFactory pmf) {
		this.pmf = pmf;
	}
	
	
}
