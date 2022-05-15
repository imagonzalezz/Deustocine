package com.deustocine.app.servicios;

import java.util.List;

import com.deustocine.app.dao.SesionDAO;
import com.deustocine.app.domain.Sesion;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
