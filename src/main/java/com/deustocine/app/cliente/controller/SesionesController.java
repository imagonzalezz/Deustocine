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

import com.deustocine.app.domain.Cine;
import com.deustocine.app.domain.Pelicula;
import com.deustocine.app.domain.Sesion;

/**
 * @author Lander
 * Clase que implementa la logica de la ventana pelicula
 * Permite mostrar la pelicula y las sesiones que tiene cada una de ellas
 * Por cada sesion que exista se creara un panel
 */
public class SesionesController {
	
	private WebTarget webTarget;
	private Pelicula pelicula;
	private Sesion s;
	
	public SesionesController(WebTarget webTarget) {
		this.webTarget = webTarget;
	}
	
	
	/*Recibe todos los cines que hay y los mete en la lista de cines */
	public List<Sesion> getSesiones() {
		WebTarget webTarget = this.webTarget.path("deustocine/sesiones");
		List<Sesion> lCines = webTarget.request(MediaType.APPLICATION_JSON).get( new GenericType<List<Sesion>>() {
	     } );
		List<Sesion> alCines = new ArrayList<>();
		alCines.addAll(lCines);
		return alCines;
	}

	/*Crea un panel por cada cine que hay*/
	public void crearPanelSesion(Sesion c, JPanel pCentro) {
		this.s = c;
		JPanel pContenedor = new JPanel();
		pContenedor.setLayout(new BoxLayout(pContenedor, BoxLayout.Y_AXIS));
		JPanel pCine = new JPanel();
		pCine.add(new JLabel(c.getFechaHora()));
		pCine.add(new JLabel(String.valueOf(c.getPrecio())));
		pCine.add(new JLabel(c.toString()));
		
		pContenedor.add(pCine);
		pCentro.add(pContenedor);
		pCentro.revalidate();
		pCentro.repaint();
	}

}
