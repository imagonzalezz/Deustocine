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

import com.deustocine.app.cliente.controller.CinesController;
import com.deustocine.app.domain.Cine;

public class VentanaCines extends JFrame{
	
	private Client cliente;
	private WebTarget webTarget;
	private List<Cine> cines;
	
	private CinesController controller;
	private static VentanaCines v;
	private JPanel pNorte;
	private JPanel pCentro;
	
	public VentanaCines(CinesController cc, Client cliente, WebTarget webTarget) {
		this.controller = cc;
		this.webTarget = webTarget;
		v = this;
		pCentro = new JPanel();
		pCentro.setLayout(new BoxLayout(pCentro,BoxLayout.Y_AXIS));
		
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