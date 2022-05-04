package com.deustocine.app.servicios;

import java.util.List;

import com.deustocine.app.dao.PeliculaDAO;
import com.deustocine.app.domain.Pelicula;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

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
