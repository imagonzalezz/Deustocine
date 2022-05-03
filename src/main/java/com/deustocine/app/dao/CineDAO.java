package com.deustocine.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.deustocine.app.conexion.Conexion;
import com.deustocine.app.domain.Cine;
import com.mysql.cj.xdevapi.PreparableStatement;

public class CineDAO {
	private Connection connection;
	private PreparedStatement statement;
	private boolean estadoOperacion;

	public boolean guardar(Cine cine) throws SQLException {
		String sql = null;// sentencia que va a persistir nuestro producto en la tabla
		estadoOperacion=false; //conexion no realizada
		
//		connection= obtenerConexion();
		sql="INSERT INT Cine (cod, nombre, direccion, telefono) VALUES(?,?,?,?)";
		
		
		
		
		return true;

	}

	// editar cine pasado por parametro
	public boolean editar(Cine cine) {

		return true;
	}
	// eliminar cine pasado por parametro
	public boolean eliminar(Cine cine) {

		return true;
	}
	
	//obtener lista de cines de la BD
	public List<Cine> obtenerCines () {

		return null;
	}
	
	//obtener cine de la BD
	public Cine obtenerCine() {
		
		return null;
		
	}
//	public Connection obtenerConexion()throws SQLException{
//
//		return Conexion.getConnection();
//	}
}
