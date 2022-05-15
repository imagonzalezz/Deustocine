package com.deustocine.app.servicios;

import java.util.List;

import com.deustocine.app.dao.PeliculaDAO;
import com.deustocine.app.domain.Pelicula;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("peliculas")
public class PeliculaServicio {
	
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

}
