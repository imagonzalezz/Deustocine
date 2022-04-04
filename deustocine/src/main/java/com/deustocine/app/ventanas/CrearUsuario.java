package com.deustocine.app.ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.deustocine.app.conexion.Conexion;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class CrearUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField nom;
	private JTextField corr;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearUsuario frame = new CrearUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CrearUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		nom = new JTextField();
		nom.setBounds(143, 62, 96, 20);
		contentPane.add(nom);
		nom.setColumns(10);

		corr = new JTextField();
		corr.setColumns(10);
		corr.setBounds(143, 108, 96, 20);
		contentPane.add(corr);

		passwordField = new JPasswordField();
		passwordField.setBounds(143, 158, 96, 20);
		contentPane.add(passwordField);

		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(27, 65, 49, 14);
		contentPane.add(lblNewLabel);

		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setBounds(27, 111, 49, 14);
		contentPane.add(lblCorreo);

		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setBounds(27, 161, 62, 14);
		contentPane.add(lblContrasea);

		JButton btnNewButton = new JButton("Crear usuario");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conexion mysql= new Conexion();
				Connection cn= mysql.conectar();
				String sSQL="";
				String nombre, correo, contrasenya;
				nombre= nom.getText();
				correo= corr.getText();
				contrasenya= passwordField.getText();

				sSQL= "INSERT INTO usuarios(nombre,correo,contrasenya)"+
						"VALUES (?,?,?)";
				try {
					PreparedStatement pst= cn.prepareStatement(sSQL);
					
					pst.setString(1, nombre);
					pst.setString(2, correo);
					pst.setString(3, contrasenya);
					
					int n=pst.executeUpdate();
					
					if (n>0) {
						System.out.println("El registro se ha completado");
						//CargarTabla();
						
					}
					
				} catch (Exception e2) {
					
					System.out.println("Error al registrar" + e2);
				}

			}
		});
		btnNewButton.setBounds(273, 209, 118, 23);
		contentPane.add(btnNewButton);
	}
}
