package com.deustocine.app.server;

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

@Path("/deustocine")

public class DeustocineServer {
	
	DeustocineServicios ds = new DeustocineServicios();
	@GET
	@Path("/getUsuario/{x}")
	public Response getUsuario(@PathParam("x") String x) {
		System.out.println(x);
		Usuario usuario=ds.getUsuario(x);
		return Response.ok(usuario).build();
	}
	
	
	
	
	@POST
	@Path("/login")
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
private List<Cine> lCines = cDao.getCines();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSesiones() {
		return Response.ok(lCines).build();
	}
	
	@GET
	@Path("/{cod}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSesion(@PathParam("cod") int cod) {
		Cine c = new Cine();
		c.setCod(cod);
		if(lCines.contains(c)) {
			for (Cine cine : lCines) {
				if(cine.getCod() == cod)
					return Response.ok(cine).build();
			}
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}
	
private PeliculaDAO pDao = new PeliculaDAO();
	
	private List<Pelicula> lista = pDao.getPeliculas();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPeliculas() {
		return Response.ok(lista).build();
	}
	
	@GET
	@Path("/{cod}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPelicula(@PathParam("cod") int cod) {
		Pelicula p = new Pelicula();
		p.setCod(cod);
		if(lista.contains(p)) {
			for (Pelicula pelicula : lista) {
				if(pelicula.getCod() == cod)
					return Response.ok(pelicula).build();
			}
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}
	
	@DELETE
	@Path("/{cod}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response borrarPelicula(@PathParam("cod") int cod) {
		Pelicula p = new Pelicula();
		p.setCod(cod);
		if(lista.contains(p)) {
			lista.remove(p);
			return Response.ok().build();
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response guardarPelicula(Pelicula p) {
		lista.add(p);
		return Response.status(Response.Status.CREATED).entity(p).build();
	}
private SesionDAO sDao = new SesionDAO();
	
	private List<Sesion> lSesiones = sDao.getSesiones();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSesiones() {
		return Response.ok(lSesiones).build();
	}
	
	@GET
	@Path("/{cod}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSesion(@PathParam("cod") int cod) {
		Sesion s = new Sesion();
		s.setCod(cod);
		if(lSesiones.contains(s)) {
			for (Sesion sesion : lSesiones) {
				if(sesion.getCod() == cod)
					return Response.ok(sesion).build();
			}
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}
	
	private UsuarioDAO uDao = new UsuarioDAO();

private List<Usuario> lUsuarios = uDao.getUsuarios();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsuarios() {
		return Response.ok(lUsuarios).build();
	}
	
	public Usuario getUsuario(String dni) {
		return uDao.getUsuario(dni);
	}
	
	@DELETE
	@Path("/{cod}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response borrarUsuario(@PathParam("dni") String dni) {
		Usuario u = new Usuario();
		u.setDni(dni);
		if(lUsuarios.contains(u)) {
			lUsuarios.remove(u);
			return Response.ok().build();
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response guardarUsuario(Usuario u) {
		lUsuarios.add(u);
		return Response.status(Response.Status.CREATED).entity(u).build();
	}
	
	
	

}


