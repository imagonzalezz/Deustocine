package com.deustocine.app.cliente.ventanas;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import com.deustocine.app.cliente.controller.SesionesController;
import com.deustocine.app.domain.Cine;
import com.deustocine.app.domain.Pelicula;
import com.deustocine.app.domain.Sesion;

/**
 * @author Lander
 * Ventana de cada pelicula donde por cada una de ellas habrá diferentes sesiones
 */
public class VentanaSesiones extends JFrame {
	
	private Client cliente;
	private WebTarget webTarget;
	private Pelicula p;
	private VentanaSesiones vp;
	private JPanel pCentro;
	private SesionesController pc;
	private List<Sesion> sesiones;
	
	
	public VentanaSesiones(WebTarget webTarget) {
		this.webTarget = webTarget;
		this.pc = new SesionesController(webTarget);
		vp = this;
		pCentro = new JPanel();
		pCentro.setLayout(new BoxLayout(pCentro,BoxLayout.Y_AXIS));
		
		//Se creará un panel por cada sesion que haya para cada pelicula
		sesiones = pc.getSesiones();
		for (Sesion c : sesiones) {
			pc.crearPanelSesion(c,pCentro);
		}
		JScrollPane scroll = new JScrollPane(pCentro);
		
		vp.getContentPane().add(scroll,BorderLayout.CENTER);
		
		this.pack();
		vp.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public static void main(String[] args) {
		Client c= ClientBuilder.newClient();
		WebTarget wt =c.target(String.format("http://%s:%s/rest", "localhost","8080"));
		VentanaSesiones vs = new VentanaSesiones(wt);
				
	}
	

}
