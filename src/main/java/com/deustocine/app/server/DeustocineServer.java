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

@Path("/deustocine")

public class DeustocineServer {
	
	DeustocineServicios ds = new DeustocineServicios();
	
	
	@POST
	@Path("/login")
	public boolean login(String dni, String contrasena) {	
		try {
			Usuario u= ds.getUsuario(dni);
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
	
	@GET
	@Path("/peliculas")
	public Response getPeliculas() {
		return Response.ok(ds.getPeliculas()).build();
	}
	
	
	@GET
	@Path("peliculas/{cod}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPelicula(@PathParam("cod") int cod) {
		Pelicula p = new Pelicula();
		p.setCod(cod);
		if(ds.getPeliculas().contains(p)) {
			for (Pelicula pelicula : ds.getPeliculas()) {
				if(pelicula.getCod() == cod)
					return Response.ok(pelicula).build();
			}
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}
	
	@GET
	@Path("peliculas/{cod}/sesiones")
	public ArrayList<Sesion> getSesionesPelicula(@PathParam("cod") int cod) {
		ArrayList<Sesion> lSesionesPelicula = new ArrayList<>();
			for (Sesion sesion : ds.getSesiones()) {
				if(sesion.getPelicula().getCod() == cod) {
					lSesionesPelicula.add(sesion);
					}	
			}
			return lSesionesPelicula;
	}
	
	@GET
	@Path("/cines")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCines() {
		return Response.ok(ds.getCines()).build();
	}
	
	@DELETE
	@Path("cines/{cod}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response borrarPelicula(@PathParam("cod") int cod) {
		Pelicula p = new Pelicula();
		p.setCod(cod);
		if(ds.getPeliculas().contains(p)) {
			ds.getPeliculas().remove(p);
			return Response.ok().build();
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response guardarPelicula(Pelicula p) {
		ds.getPeliculas().add(p);
		return Response.status(Response.Status.CREATED).entity(p).build();
	}

	@GET
	@Path("/sesiones")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSesiones() {
		return Response.ok(ds.getSesiones()).build();
	}
	
	@GET
	@Path("sesiones/{cod}")
	@Produces(MediaType.APPLICATION_JSON)
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
	
	
	@GET
	@Path("/usuarios")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsuarios() {
		return Response.ok(ds.getUsuarios()).build();
	}
	
	
	@DELETE
	@Path("/{cod}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response borrarUsuario(@PathParam("dni") String dni) {
		Usuario u = new Usuario();
		u.setDni(dni);
		if(ds.getUsuarios().contains(u)) {
			ds.getUsuarios().remove(u);
			return Response.ok().build();
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response guardarUsuario(Usuario u) {
		ds.getUsuarios().add(u);
		return Response.status(Response.Status.CREATED).entity(u).build();
	}
	@GET
	@Path("/getUsuario/{x}")
	public Response getUsuario(@PathParam("x") String x) {
		System.out.println(x);
		Usuario usuario=ds.getUsuario(x);
		return Response.ok(usuario).build();
	}
	
	
	

}


