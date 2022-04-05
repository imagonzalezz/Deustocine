package com.deustocine.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.deustocine.app.conexion.Conexion;
import com.deustocine.app.domain.Usuario;
import com.mysql.cj.xdevapi.PreparableStatement;

public class UsuarioDAO {
	private Connection connection;
	private PreparedStatement statement;
	private boolean estadoOperacion;

	public boolean guardar(Usuario usuario) throws SQLException {
		String sql = null;// sentencia que va a persistir nuestro producto en la tabla
		estadoOperacion=false; //conexion no realizada
		
//		connection= obtenerConexion();
		sql="INSERT INT Usuarios (id, nombre, cantidad, precio, fecha_crear,fecha_actualizar) VALUES(?,?,?,?,?,?)";
		
		
		
		
		return true;

	}

	// editar registro
	public boolean editar(Usuario usuario) {

		return true;
	}

	public boolean eliminar(Usuario usuario) {

		return true;
	}
	
	//obtener lista de usuarios de la BD
	public List<Usuario> obtenerUsuarios () {

		return null;
	}
	
	
	public Usuario obtenerUsuario() {
		
		return null;
		
	}
//	public Connection obtenerConexion()throws SQLException{
//
//		return Conexion.getConnection();
//	}
}
