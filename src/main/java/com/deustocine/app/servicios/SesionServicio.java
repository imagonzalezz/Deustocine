package com.deustocine.app.servicios;

import java.util.List;

import com.deustocine.app.dao.SesionDAO;
import com.deustocine.app.domain.Sesion;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class SesionServicio {
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
}
