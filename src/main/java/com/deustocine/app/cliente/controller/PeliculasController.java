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

import com.deustocine.app.cliente.ventanas.VentanaPelicula;
import com.deustocine.app.cliente.ventanas.VentanaPeliculas;
import com.deustocine.app.domain.Pelicula;
/**
 * @author Lander
 * Clase que implementa la logica de la ventana peliculas
 * Permite mostrar las peliculas existentes
 * Por cada sesion que exista se creara un panel
 */
public class PeliculasController {

	private WebTarget webTarget;
	private List<Pelicula> peliculas;//lista de peliculas que hay
	private Pelicula pelicula;
	private VentanaPeliculas v;
	
	public PeliculasController(WebTarget webTarget) {
		this.webTarget = webTarget;
	}
	
	//Metodo que recibe las peliculas que hay y las agrupa en un ArrayList
	public List<Pelicula> getPeliculas() {
		WebTarget webTarget = this.webTarget.path("deustocine/peliculas");
		List<Pelicula> lPeliculas = webTarget.request(MediaType.APPLICATION_JSON).get( new GenericType<List<Pelicula>>() {
	     } );
		List<Pelicula> alPeliculas = new ArrayList<>();
		alPeliculas.addAll(lPeliculas);
		return alPeliculas;
	}

	//Metodo que crea un panel por cada pelicula que haya con sus diferentes caracteristicas
	public void crearPanelPelicula(VentanaPeliculas v,Pelicula p, JPanel pCentro) {
		this.pelicula = p;
		this.v = v;
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
				v.dispose();
				VentanaPelicula vp = new VentanaPelicula(p, webTarget);
			}
		});
		
		pContenedor.add(pPelicula);
		pCentro.add(pContenedor);
		pCentro.revalidate();
		pCentro.repaint();
		
	}
	
	
}
