package com.deustocine.app.ventanas;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.deustocine.app.conexion.Conexion;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.WebTarget;

import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InicioSesion extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioSesion frame = new InicioSesion();
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
	public InicioSesion(Client cliente, WebTarget webTarget) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(181, 134, 165, 26);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setBounds(81, 137, 69, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Usuario");
		lblNewLabel_1.setBounds(81, 63, 69, 20);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(181, 60, 165, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		

		
		JButton btnNewButton = new JButton("Iniciar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Conexion mysql= new Conexion();
				
				mysql.conectar();
				
				
			}
		});
		btnNewButton.setBounds(138, 201, 115, 29);
		contentPane.add(btnNewButton);
	}

	public InicioSesion() {
		// TODO Auto-generated constructor stub
	}

}
