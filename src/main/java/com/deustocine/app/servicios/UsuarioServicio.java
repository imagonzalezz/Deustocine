package com.deustocine.app.servicios;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.deustocine.app.dao.UsuarioDAO;
import com.deustocine.app.domain.Usuario;

public class UsuarioServicio {
private UsuarioDAO uDao = new UsuarioDAO();
	
	private List<Usuario> lUsuarios = uDao.getUsuarios();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsuarios() {
		return Response.ok(lUsuarios).build();
	}
	
	@GET
	@Path("/{cod}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsuario(@PathParam("dni") String dni) {
		Usuario u = new Usuario();
		u.setDni(dni);
		if(lUsuarios.contains(u)) {
			for (Usuario usuario : lUsuarios) {
				if(usuario.getDni() == dni)
					return Response.ok(usuario).build();
			}
		}
		return Response.status(Response.Status.NOT_FOUND).build();
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

	public UsuarioDAO getuDao() {
		return uDao;
	}

	public void setuDao(UsuarioDAO uDao) {
		this.uDao = uDao;
	}
	
	

}