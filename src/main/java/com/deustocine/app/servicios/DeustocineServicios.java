package com.deustocine.app.servicios;
//logica

import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.JDOUserException;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

import com.deustocine.app.dao.CineDAO;
import com.deustocine.app.dao.PeliculaDAO;
import com.deustocine.app.dao.SesionDAO;
import com.deustocine.app.dao.UsuarioDAO;
import com.deustocine.app.domain.Cine;
import com.deustocine.app.domain.Pelicula;
import com.deustocine.app.domain.Sesion;
import com.deustocine.app.domain.Usuario;


public class DeustocineServicios {
	CineDAO cDao;
	PeliculaDAO pDao;
	SesionDAO sDao;
	UsuarioDAO uDao;
	
	PersistenceManagerFactory pmf;

	public DeustocineServicios() {
		cDao= new CineDAO();
		pDao= new PeliculaDAO();
		sDao= new SesionDAO();
		uDao= new UsuarioDAO();
		pmf= JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	}
	
	
	public boolean logIn(String dni, String contrasena) {	
		try {
			Usuario u= uDao.getUsuario(dni);
			if (u!=null) {
				if (u.getContrasenya().contentEquals(contrasena)) {
					return true;
				}
			}
			return false;
		}catch(JDOUserException exception) {
			return false;
		}
		
	}
	public List<Usuario> getUsuarios(){
		return uDao.getUsuarios();
	}
	public List<Pelicula> getPeliculas(){
		return pDao.getPeliculas();
	}
	public List<Sesion> getSesiones(){
		return sDao.getSesiones();
	}
	public List<Cine> getCines(){
		return cDao.getCines();
	}
	
	public CineDAO getcDao() {
		return cDao;
	}

	public void setcDao(CineDAO cDao) {
		this.cDao = cDao;
	}
	public PeliculaDAO getpDao() {
		return pDao;
	}

	public void setpDao(PeliculaDAO pDao) {
		this.pDao = pDao;
	}
	
	public SesionDAO getsDao() {
		return sDao;
	}

	public void setsDao(SesionDAO sDao) {
		this.sDao = sDao;
	}
	
	public UsuarioDAO getuDao() {
		return uDao;
	}
	
	public boolean registro(Usuario u) {
		if (uDao.getUsuario(u.getDni())==null) {
			uDao.guardarUsuario(u);
			return true;
		}
		System.out.println("*No se ha realizado el registro*");
		return false;	
	}

	public void setuDao(UsuarioDAO uDao) {
		this.uDao = uDao;
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
