package com.deustocine.app.cliente.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import com.deustocine.app.domain.Pelicula;
import com.deustocine.app.domain.Sesion;

public class PeliculaController {
	
	private WebTarget webTarget;
	private Pelicula pelicula;
	private Sesion s;
	
	public PeliculaController(WebTarget webTarget) {
		this.webTarget = webTarget;
	}
	
	
	public ArrayList<Sesion> getSesionesPelicula(Pelicula p) {
		WebTarget webTarget = this.webTarget.path("peliculas/{cod}/sesiones");
		ArrayList<Sesion> lSesiones = webTarget.request(MediaType.APPLICATION_JSON).get( new GenericType<ArrayList<Sesion>>() {
	     } );
		return lSesiones;
	}
	
	
	public void crearPanelSesion(Sesion s,Pelicula p, JPanel pCentro) {
		this.s = s;
		this.pelicula = p;
		
		JPanel pContenedor = new JPanel();
		pContenedor.setLayout(new BoxLayout(pContenedor, BoxLayout.Y_AXIS));
		JPanel pPelicula = new JPanel();
		pPelicula.add(new JLabel(p.getTitulo()));
		pPelicula.add(new JLabel(p.getDirector()));
		pPelicula.add(new JLabel(p.getFechaSalida()));
		pPelicula.add(new JLabel(p.getGenero()));
		
		
		JPanel pContenedor2 = new JPanel();
		pContenedor2.setLayout(new BoxLayout(pContenedor2, BoxLayout.Y_AXIS));
		JPanel pSesion = new JPanel();
		pSesion.add(new JLabel(s.getCine().toString()));
		pSesion.add(new JLabel(s.getFechaHora()));
		pSesion.add(new JLabel(String.valueOf(s.getCod())));
		pSesion.add(new JLabel(String.valueOf(s.getPrecio())));
		pSesion.add(new JLabel(String.valueOf(s.getPuntosObtiene())));
		pSesion.add(new JLabel(String.valueOf(s.getValorPuntos())));
		
		pContenedor2.add(pSesion);
		pContenedor.add(pPelicula);
		pCentro.revalidate();
		pCentro.repaint();
	}

}
