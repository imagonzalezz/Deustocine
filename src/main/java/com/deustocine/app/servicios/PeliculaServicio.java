package com.deustocine.app.servicios;

import java.util.List;

import com.deustocine.app.dao.PeliculaDAO;
import com.deustocine.app.domain.Pelicula;

import jakarta.ws.rs.GET;
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

}
