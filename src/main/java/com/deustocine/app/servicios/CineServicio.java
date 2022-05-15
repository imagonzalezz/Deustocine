package com.deustocine.app.servicios;

import java.util.List;

import com.deustocine.app.dao.CineDAO;
import com.deustocine.app.domain.Cine;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
