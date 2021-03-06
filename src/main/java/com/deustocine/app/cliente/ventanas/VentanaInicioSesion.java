package com.deustocine.app.cliente.ventanas;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.deustocine.app.cliente.controller.InicioSesionController;
import com.deustocine.app.dao.UsuarioDAO;
import 	com.deustocine.app.domain.Usuario;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.jdo.JDOUserException;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



/**
 * @author Lander
 * Ventana para iniciar sesion los usuarios que ya esten registrados en la BD.
 */
public class VentanaInicioSesion extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField;
	private Client cliente;
	private WebTarget wt;
	private InicioSesionController isc;
	private VentanaInicioSesion is;
	private JButton login,cerrar,registrarse;
	private JPanel pSur,pCentro,pNorte;
	private JLabel lError;
	private JTextField usuario;
	private JPasswordField contraseina;
	private JButton btnCines;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	
	/**
	 * Panel en el que se pueden introducir los datos de los usuarios para poder ver las peliculas, cines...
	 * @param cliente
	 * @param webTarget
	 */
	public VentanaInicioSesion(Client cliente, WebTarget webTarget) {
		super();
		this.cliente=cliente;
		this.wt=webTarget;
		this.isc = new InicioSesionController(cliente, webTarget);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 400);
		is=this;
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout((LayoutManager) new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		login = new JButton("Login");
		registrarse = new JButton("Registrarse");
		
		pSur= new JPanel();
		pSur.setBackground(Color.WHITE);
		
		
		pNorte = new JPanel();
		pNorte.setBackground(Color.WHITE);
		
		
		pCentro = new JPanel();
		pCentro.setBackground(Color.WHITE);
		pCentro.setLayout(new BoxLayout(pCentro, BoxLayout.Y_AXIS));
		
		
		lError= new JLabel();
		
		JLabel lblInicie = new JLabel("Inicio de sesion");
		pNorte.add(lblInicie);
		
		JPanel pEmail= new JPanel();
		JLabel lblUsuario = new JLabel("DNI: ");
		usuario = new JTextField();
		pEmail.add(lblUsuario);
		pEmail.add(usuario);
		usuario.setColumns(10);
		
		pEmail.setBackground(Color.WHITE);
		pEmail.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		pCentro.add(pEmail);
		
	
		JPanel pContrasena= new JPanel();
		JLabel lblContraseina = new JLabel("Contrase??a: ");
		pContrasena.add(lblContraseina);
		pContrasena.setBackground(Color.WHITE);
		pContrasena.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		
		
		contraseina = new JPasswordField();
		contraseina.setColumns(10);
		pContrasena.add(contraseina);
		
		pCentro.add(pContrasena);
		pCentro.add(lError);
		lError.setForeground(Color.RED);
		pSur.add(login);
		pSur.add(registrarse);
		btnCines = new JButton("Mostrar Cines");
		pSur.add(btnCines);
		pCentro.setBackground(Color.WHITE);
		
		/**
		 * Al loggearse comprueba si el usuario y la contrase??a est??n en BD y comprueba a ver si coinciden el usuario y la contrase??a.
		 */
		registrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaCrearUsuario v= new VentanaCrearUsuario(is.cliente, is.wt);
				is.dispose();
			}
		});
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String dni=usuario.getText();
					String password=contraseina.getText();
					boolean valido=isc.logIn(dni, password, lError,is);
					if (valido) {
						VentanaPeliculas vp = new VentanaPeliculas(is.cliente, is.wt);
						VentanaInicioSesion.this.dispose();
						
					}
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnCines.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				is.dispose();
				VentanaCines vc = new VentanaCines(cliente, webTarget);
				
			}
		});
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		contentPane.add(pNorte, BorderLayout.NORTH);
		contentPane.add(pCentro, BorderLayout.CENTER);
		contentPane.add(pSur);
		
		setVisible(true);
		this.pack();
		setLocationRelativeTo(null);
		
	}


}
