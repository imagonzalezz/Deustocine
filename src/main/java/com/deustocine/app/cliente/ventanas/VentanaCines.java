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

import com.deustocine.app.cliente.controller.CinesController;
import com.deustocine.app.domain.Cine;

/** 
 * @author Lander
 * Ventana donde se mostraran los cines que hay en la BD.
 * Se mostrará un cine en un panel nuevoo por cada cine que exista en la BD.
 */

public class VentanaCines extends JFrame{
	
	private Client cliente;
	private WebTarget webTarget;
	private List<Cine> cines; //lista de cines que existen en la BD
	
	private CinesController controller; //controller que implementa la lógica de la ventana
	private static VentanaCines v;
	private JPanel pNorte;
	private JPanel pCentro;
	
	public VentanaCines(Client cliente, WebTarget webTarget) {
		controller = new CinesController(webTarget);
		this.webTarget = webTarget;
		v = this;
		pCentro = new JPanel();
		pCentro.setLayout(new BoxLayout(pCentro,BoxLayout.Y_AXIS));
		//por cada cine se crea un panel nuevo con el nuevo cine
		cines = controller.getCines();
		for (Cine c : cines) {
			controller.crearPanelCine(c,pCentro);
		}
		
		JScrollPane scroll = new JScrollPane(pCentro);
		
		v.getContentPane().add(scroll,BorderLayout.CENTER);
		
		this.pack();
		v.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
}