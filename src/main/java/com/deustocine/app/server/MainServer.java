package com.deustocine.app.server;

import com.deustocine.app.domain.Cine;
import com.deustocine.app.domain.Entrada;
import com.deustocine.app.domain.Pelicula;
import com.deustocine.app.domain.Sesion;
import com.deustocine.app.domain.Usuario;

public class MainServer {
	public MainServer() {
		Cine c1 = new Cine();
		c1.setCod(1);
		c1.setDireccion("Artea CC");
		c1.setNombre("Artea");
		c1.setTelefono(944636475);

		Pelicula p1 = new Pelicula();
		p1.setCod(1);
		p1.setTitulo("Iron Man");
		p1.setDirector("Jon Favreau");
		p1.setGenero("Ficcion");
		p1.setPortada(null);
//		p1.setFechaSalida("30/04/2008 00:00");

		Usuario u1 = new Usuario();
		u1.setDni("71237123D");
		u1.setContrasenya("Contrasenya");
		u1.setPuntos(54);
		u1.setUsuario("David Millan");

		Sesion s1 = new Sesion();
		s1.setCod(1);
//		s1.setFechaHora("23/05/2008 17:30);
		s1.setPrecio(10);
		s1.setPuntosObtiene(22);
		s1.setValorPuntos(189);
		s1.setPelicula(p1);
		s1.setCine(c1);

		Entrada e1 = new Entrada();
		e1.setCod(1);
		e1.setUsuario(u1);
		e1.setSesion(s1);

	}
}
