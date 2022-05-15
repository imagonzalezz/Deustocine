package com.deustocine.app.dao;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.deustocine.app.domain.Pelicula;
import com.deustocine.app.domain.Sesion;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;


public class SesionDAO {
	
	private PersistenceManagerFactory pmf;
	
	
	public SesionDAO() {
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		
	}
	
	public void guardarSesion(Sesion s) {
		this.guardarObjeto(s);

	}
	
	
	private void guardarObjeto(Object o) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction ts = pm.currentTransaction();
		
		try {
			ts.begin();
			System.out.println("Guardando una Sesion"+o);
			pm.makePersistent(o);
			ts.commit();
			
		}catch(Exception ex){
			System.out.println("Error guardando una sesion"+ex.getMessage());
		}finally {
			if(ts != null &&  ts.isActive()) {
				ts.rollback();
			}
			pm.close();
		}
		
	}
	public void setPmf(PersistenceManagerFactory pmf) {
		this.pmf = pmf;
	}
	
	public List<Sesion> getSesiones(){
		PersistenceManager pm = pmf.getPersistenceManager();
		/*
		 * By default only 1 level is retrieved from the db so if we wish to fetch more
		 * than one level, we must indicate it
		 */

		Transaction ts = pm.currentTransaction();
		List<Sesion> sesiones = new ArrayList<>();

		try {
			System.out.println("   * Retrieving an Extent for Products.");

			ts.begin();
			Extent<Sesion> extent = pm.getExtent(Sesion.class, true);

			for (Sesion p : extent) {
				System.out.println(p.getPelicula());
				sesiones.add(p);
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

		return sesiones;
		
	}

}