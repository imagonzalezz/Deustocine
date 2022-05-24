package com.deustocine.app.cliente.ventanas;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

import com.deustocine.app.cliente.controller.PeliculasController;
import com.deustocine.app.domain.Pelicula;

/**
 * @author Lander
 * Ventana en la que se muestra toda la lista de peliculas que hay en la BD.
 * Se creará un panel por cada pelicula que exista.
 */
public class VentanaPeliculas extends JFrame{
	
	private Client cliente;
	private WebTarget webTarget;
	private List<Pelicula> peliculas;
	
	private PeliculasController controller;
	private static VentanaPeliculas v;
	private JPanel pNorte;
	private JPanel pCentro;
	
	public VentanaPeliculas(Client cliente, WebTarget webTarget) {
		this.webTarget = webTarget;
		this.controller = new PeliculasController(webTarget);
		v = this;
		pCentro = new JPanel();
		pCentro.setLayout(new BoxLayout(pCentro,BoxLayout.Y_AXIS));
		
		//por cada pelicula que haya se crea un panel
		peliculas = controller.getPeliculas();
		for (Pelicula p : peliculas) {
			controller.crearPanelPelicula(p,pCentro);
		}
		
		JScrollPane scroll = new JScrollPane(pCentro);
		
		v.getContentPane().add(scroll,BorderLayout.CENTER);
		
		this.pack();
		v.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
}