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

public class PeliculasController {

	private WebTarget webTarget;
	private List<Pelicula> peliculas;
	private Pelicula pelicula;
	
	public PeliculasController(WebTarget webTarget) {
		this.webTarget = webTarget;
	}
	
	
	public List<Pelicula> getPeliculas() {
		WebTarget webTarget = this.webTarget.path("deustocine/peliculas");
		List<Pelicula> lPeliculas = webTarget.request(MediaType.APPLICATION_JSON).get( new GenericType<List<Pelicula>>() {
	     } );
		List<Pelicula> alPeliculas = new ArrayList<>();
		alPeliculas.addAll(lPeliculas);
		return alPeliculas;
	}


	public void crearPanelPelicula(Pelicula p, JPanel pCentro) {
		this.pelicula = p;
		JPanel pContenedor = new JPanel();
		pContenedor.setLayout(new BoxLayout(pContenedor, BoxLayout.Y_AXIS));
		JPanel pPelicula = new JPanel();
		pPelicula.add(new JLabel(p.getTitulo()));
		pPelicula.add(new JLabel(p.getFechaSalida()));
		JButton btnIrASesiones = new JButton("Ver detalles");
		pPelicula.add(btnIrASesiones);
		btnIrASesiones.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO
			}
		});
		
		pContenedor.add(pPelicula);
		pCentro.revalidate();
		pCentro.repaint();
		
	}
	
	
}
