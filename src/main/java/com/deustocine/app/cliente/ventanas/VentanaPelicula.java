package com.deustocine.app.cliente.ventanas;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

import com.deustocine.app.cliente.controller.PeliculaController;
import com.deustocine.app.domain.Pelicula;
import com.deustocine.app.domain.Sesion;

public class VentanaPelicula extends JFrame {
	
	private Client cliente;
	private WebTarget webTarget;
	private Pelicula p;
	private VentanaPelicula vp;
	private JPanel pCentro;
	private PeliculaController pc;
	private ArrayList<Sesion> sesiones;
	
	
	public VentanaPelicula(PeliculaController pc,Pelicula p, Client cliente, WebTarget webTarget) {
		this.pc = pc;
		this.p = p;
		this.webTarget = webTarget;
		vp = this;
		pCentro = new JPanel();
		pCentro.setLayout(new BoxLayout(pCentro,BoxLayout.Y_AXIS));
		
		sesiones = pc.getSesionesPelicula(p);
		for(Sesion s: sesiones) {
			pc.crearPanelSesion(s, p, pCentro);
		}
		JScrollPane scroll = new JScrollPane(pCentro);
		
		vp.getContentPane().add(scroll,BorderLayout.CENTER);
		
		this.pack();
		vp.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
