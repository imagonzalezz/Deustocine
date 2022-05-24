package com.deustocine.app.server;

import com.deustocine.app.domain.Cine;
import com.deustocine.app.domain.Entrada;
import com.deustocine.app.domain.Pelicula;
import com.deustocine.app.domain.Sesion;
import com.deustocine.app.domain.Usuario;
import com.deustocine.app.servicios.DeustocineServicios;

/**
 * @author Lander
 * main del servidor
 * 
 */
public class MainServer {
	public static void main(String[] args) {
		DeustocineServicios ds = new DeustocineServicios();
		
		Cine c1 = new Cine();
		c1.setCod(1);
		c1.setDireccion("Artea CC");
		c1.setNombre("Artea");
		c1.setTelefono(944636475);
		
		Cine c2 = new Cine();
		c2.setCod(2);
		c2.setDireccion("Gran Via 1");
		c2.setNombre("Yelmo Cines");
		c2.setTelefono(944636476);
		
		ds.getcDao().guardarCine(c1);
		ds.getcDao().guardarCine(c2);

		Pelicula p1 = new Pelicula();
		p1.setCod(1);
		p1.setTitulo("Iron Man");
		p1.setDirector("Jon Favreau");
		p1.setGenero("Ficcion");
		p1.setFechaSalida("30/04/2008 00:00");
		
		Pelicula p2 = new Pelicula();
		p2.setCod(2);
		p2.setTitulo("Interstellar");
		p2.setDirector("Christopher Nolan");
		p2.setGenero("Ficcion");
		p2.setFechaSalida("31/04/2008 00:00");
		
		ds.getpDao().guardarPelicula(p1);
		ds.getpDao().guardarPelicula(p2);

		Usuario u1 = new Usuario();
		u1.setDni("71237123D");
		u1.setContrasenya("Contrasenya");
		u1.setPuntos(54);
		u1.setNombre("Imanol");
		
		Usuario u2 = new Usuario();
		u2.setDni("71237123F");
		u2.setContrasenya("Contrasenya2");
		u2.setPuntos(54);
		u2.setNombre("Inigo");
		
		ds.getuDao().guardarUsuario(u1);
		ds.getuDao().guardarUsuario(u2);

		Sesion s1 = new Sesion();
		s1.setCod(1);
		s1.setFechaHora("23/05/2008 17:30");
		s1.setPrecio(10);
		s1.setPuntosObtiene(22);
		s1.setValorPuntos(189);
		s1.setPelicula(p1);
		s1.setCine(c1);
		
		Sesion s2 = new Sesion();
		s2.setCod(1);
		s2.setFechaHora("23/05/2008 17:30");
		s2.setPrecio(10);
		s2.setPuntosObtiene(22);
		s2.setValorPuntos(189);
		s2.setPelicula(p2);
		s2.setCine(c2);
		
		ds.getsDao().guardarSesion(s1);
		ds.getsDao().guardarSesion(s2);

		Entrada e1 = new Entrada();
		e1.setCod(1);
		e1.setUsuario(u1);
		e1.setSesion(s1);
		
		Entrada e2 = new Entrada();
		e2.setCod(1);
		e2.setUsuario(u2);
		e2.setSesion(s2);

	}
}
