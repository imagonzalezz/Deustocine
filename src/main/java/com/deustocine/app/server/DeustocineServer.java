package com.deustocine.app.server;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.JDOUserException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.deustocine.app.dao.CineDAO;
import com.deustocine.app.dao.PeliculaDAO;
import com.deustocine.app.dao.SesionDAO;
import com.deustocine.app.dao.UsuarioDAO;
import com.deustocine.app.domain.Cine;
import com.deustocine.app.domain.Pelicula;
import com.deustocine.app.domain.Sesion;
import com.deustocine.app.domain.Usuario;
import com.deustocine.app.servicios.DeustocineServicios;

/**
 * Clase con los metodos del servidor
 * @author Iker
 *
 */
@Path("/deustocine")
@Produces(MediaType.APPLICATION_JSON)
public class DeustocineServer {
	
	DeustocineServicios ds ;
	
	
	public DeustocineServer() {
		ds = new DeustocineServicios();
	}
	
	/**
	 * Metodo para iniciar sesion
	 * @param usuario Usuario
	 * @return true si el login es correcto y false si no lo es
	 */
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean login(Usuario usuario) {	
		try {
			Usuario u= ds.getUsuario(usuario.getDni());
			if (u!=null) {
				if (usuario.getContrasenya().contentEquals(u.getContrasenya())) {
					return true;
				}
			}
			return false;
		}catch(JDOUserException exception) {
			return false;
		}
		
	}
	
	/**
	 * Metodo que devuelve las peliculas que hay en la base de datos
	 * @return Lista de peliculas
	 */
	@GET
	@Path("/peliculas")
	public List<Pelicula> getPeliculas() {
		return ds.getPeliculas();
	}
	
	/**
	 * Metodo que devuelve las sesiones correspondientes a una pelicula
	 * @param p Pelicula
	 * @return Lista de sesiones de la pelicula
	 */
	@GET
	@Path("peliculas/sesiones/")
	public List<Sesion> getSesionesPelicula(Pelicula p) {
		ArrayList<Sesion> lSesionesPelicula = new ArrayList<>();
			for (Sesion sesion : ds.getSesiones()) {
				if(sesion.getPelicula().getCod() == p.getCod()) {
					lSesionesPelicula.add(sesion);
					}	
			}
			return lSesionesPelicula;
	}
	
	/**
	 * Metodo que devuelve la lista de cines que hay en la bd
	 * @return Lista de cines
	 */
	@GET
	@Path("/cines")
	public List<Cine> getCines() {
		return ds.getCines();
	}
	
	/**
	 * Metodo para registrar un usuario
	 * @param u usuario
	 * @return Respuesta
	 */
	@POST
	@Path("/registro")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response registro(Usuario u) {
		boolean registro=ds.registro(u);
		System.out.println("*Realizando registro*");
		return Response.ok(registro).build();
	}
	
	/**
	 * Metodo que borra una pelicula
	 * @param cod
	 * @return
	 */
	@DELETE
	@Path("pelicula/{cod}")
	public Response borrarPelicula(@PathParam("cod") int cod) {
		Pelicula p = new Pelicula();
		p.setCod(cod);
		if(ds.getPeliculas().contains(p)) {
			ds.getPeliculas().remove(p);
			return Response.ok().build();
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}
	
	/**
	 * Metodo que guarda una pelicula
	 * @param p Pelicula
	 * @return Respuesta
	 */
	@POST
	@Path("/peliculas")
	public Response guardarPelicula(Pelicula p) {
		ds.getPeliculas().add(p);
		return Response.status(Response.Status.CREATED).entity(p).build();
	}

	/**
	 * Metodo que devuelve todas las sesiones que hay en la bd
	 * @return Lista de sesiones
	 */
	@GET
	@Path("/sesiones")
	public List <Sesion> getSesiones() {
		return ds.getSesiones();
	}
	
	/**
	 * Metodo que devuelve una sesion
	 * @param cod codigo de la sesion
	 * @return Respuesta
	 */
	@GET
	@Path("sesiones/{cod}")
	public Response getSesion(@PathParam("cod") int cod) {
		Sesion s = new Sesion();
		s.setCod(cod);
		if(ds.getSesiones().contains(s)) {
			for (Sesion sesion : ds.getSesiones()) {
				if(sesion.getCod() == cod)
					return Response.ok(sesion).build();
			}
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}
	
	
	/**
	 * Metodo que devuelve los usuarios que hay en la bd
	 * @return Lista de usuarios
	 */
	@GET
	@Path("/usuarios")
	public List<Usuario> getUsuarios() {
		return ds.getUsuarios();
	}
	
	/**
	 * Metodo que borra un usuario
	 * @param dni dni del usuario
	 * @return Respuesta
	 */
	@DELETE
	@Path("usuarios/{cod}")
	public Response borrarUsuario(@PathParam("dni") String dni) {
		Usuario u = new Usuario();
		u.setDni(dni);
		if(ds.getUsuarios().contains(u)) {
			ds.getUsuarios().remove(u);
			return Response.ok().build();
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}
	
	/**
	 * Metodo que guarda un usuario
	 * @param u Usuario
	 * @return Respuesta
	 */
	@POST
	@Path("usuarios")
	public Response guardarUsuario(Usuario u) {
		ds.getUsuarios().add(u);
		return Response.status(Response.Status.CREATED).entity(u).build();
	}
	
	/**
	 * Metodo que devuelve un usuario
	 * @param x codigo del usuario 
	 * @return Respuesta
	 */
	@GET
	@Path("/usuarios/{x}")
	public Response getUsuario(@PathParam("x") String x) {
		System.out.println(x);
		Usuario usuario=ds.getUsuario(x);
		return Response.ok(usuario).build();
	}
	
	
	

}


