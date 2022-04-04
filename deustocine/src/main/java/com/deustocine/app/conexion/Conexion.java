package com.deustocine.app.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	// Conectamos con la base de datos

	public Connection conectar() {
		Connection connection = null;

		
		try {
			Class.forName("com.mysql.jdbc.Driver");

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/deustocinedb","root", "deusto");
			if(	connection!=null) {
				System.out.println("se ha conectado correctamente a la BD");	
			}


		} catch (ClassNotFoundException ex) {
			System.out.println("Error al registrar el driver de MySQL: " + ex);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("sin conexion");	
		}
		return connection;}

	


}