package com.deustocine.app.servicios;

import java.util.List;

import com.deustocine.app.dao.CineDAO;
import com.deustocine.app.domain.Cine;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class CineServicio {
private CineDAO cDao = new CineDAO();
	
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
}
