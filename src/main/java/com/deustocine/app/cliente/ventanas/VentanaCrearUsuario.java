package com.deustocine.app.cliente.ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

import com.deustocine.app.cliente.controller.RegistroController;
import com.deustocine.app.domain.Usuario;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

/**
 * @author Lander
 * Ventana que permite crear nuevo usuarios con su nombre, dni, correo y contraseña.
 *
 */
public class VentanaCrearUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField nombre;
	private JTextField dni;
	private JPasswordField passwordField;
	private RegistroController rc;
	DefaultTableModel modelo;
	private JLabel lblNewLabel_1;
	private JTextField txtDni;
	private VentanaCrearUsuario vcu;
	private WebTarget webTarget;	
	private Client client;


	/**
	 * Create the frame.
	 */

	
	/**
	 * TextFields y passwordField para introducir los datos del usuario para registrarse.
	 */
	
	
		//creacion y propiedades de la ventana

	public VentanaCrearUsuario(Client cliente, WebTarget wt) {
		super();
		vcu = this;
		this.client=cliente;
		this.webTarget=wt;
		this.rc= new RegistroController(webTarget);
		
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		nombre = new JTextField();
		nombre.setBounds(143, 62, 96, 20);
		contentPane.add(nombre);
		nombre.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(143, 158, 96, 20);
		contentPane.add(passwordField);

		JLabel lblNewLabel = new JLabel("Nombre: ");
		lblNewLabel.setBounds(27, 65, 49, 14);
		contentPane.add(lblNewLabel);

	

		JLabel lblContrasea = new JLabel("Contrasenya: ");
		lblContrasea.setBounds(27, 161, 62, 14);
		contentPane.add(lblContrasea);

		lblNewLabel_1 = new JLabel("DNI: ");
		lblNewLabel_1.setBounds(27, 11, 49, 14);
		contentPane.add(lblNewLabel_1);

		txtDni = new JTextField();
		txtDni.setBounds(143, 8, 96, 20);
		contentPane.add(txtDni);
		txtDni.setColumns(10);
		
		/**
		 * Boton para crear el usuario una vez introducidos los datos.
		 */
		
		JButton btnNewButton = new JButton("Crear usuario");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario u = new Usuario();
				u.setDni(txtDni.getText());
				u.setContrasenya(passwordField.getText());
				u.setNombre(nombre.getText());

				try {
					rc.registrar(u);
					System.out.println("registro correcto");
				} catch (Exception e2) {
					System.out.println("error en el registro");
				}

			}

		});
		btnNewButton.setBounds(273, 209, 118, 23);
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				vcu.dispose();
				VentanaInicioSesion vi = new VentanaInicioSesion(cliente, wt);
				
			}
		});
		btnSalir.setBounds(433, 209, 118, 23);
		contentPane.add(btnNewButton);
		contentPane.add(btnSalir);

		setVisible(true);
		this.pack();
		setLocationRelativeTo(null);
		
	}
}
