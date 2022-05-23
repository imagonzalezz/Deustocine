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

public class CinesController {

	private WebTarget webTarget;
	private List<Cine> cines;
	private Cine cine;
	
	public CinesController(WebTarget webTarget) {
		this.webTarget = webTarget;
	}
	
	
	public List<Cine> getCines() {
		WebTarget webTarget = this.webTarget.path("deustocine/cines");
		List<Cine> lCines = webTarget.request(MediaType.APPLICATION_JSON).get( new GenericType<List<Cine>>() {
	     } );
		List<Cine> alCines = new ArrayList<>();
		alCines.addAll(lCines);
		return alCines;
	}


	public void crearPanelPelicula(Cine c, JPanel pCentro) {
		this.cine = c;
		JPanel pContenedor = new JPanel();
		pContenedor.setLayout(new BoxLayout(pContenedor, BoxLayout.Y_AXIS));
		JPanel pCine = new JPanel();
		pCine.add(new JLabel(c.getNombre()));
		pCine.add(new JLabel(c.getDireccion()));
		pCine.add(new JLabel (String.valueOf(c.getTelefono())));
		
		pContenedor.add(pCine);
		pCentro.revalidate();
		pCentro.repaint();
		
	}
	
	
}
