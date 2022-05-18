package org.iesalixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.iesalixar.servidor.bd.PoolDB;
import org.iesalixar.servidor.model.Usuario;


public class DAOUsuarioImpl implements DAOUsuario {

	public DAOUsuarioImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Usuario getUsuario(String email) {
		
		Usuario usuario = null;
		Connection con = null;

		try {
			PoolDB pool = new PoolDB();
			String sql = "select * from usuarios where email=?";
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, email);
			

			ResultSet rs = statement.executeQuery();

			// Como el campo de búsqueda es la clave solo debería obtener un resultado
			// si no es así estaremos machacando cada vez el valor de customer y
			while (rs.next()) {

				usuario = new Usuario();
				usuario.setUsuario(rs.getString("usuario"));
				usuario.setPassword(rs.getString("password"));
				usuario.setEmail(rs.getString("email"));
				usuario.setRole(rs.getString("role"));
				usuario.setFirstName(rs.getString("firstName"));
				usuario.setLastName(rs.getString("lastName"));

			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return usuario;

	}

	@Override
	public boolean registerUsuario(Usuario usuario) {
		int resultado = 0;
		Connection con = null;
		try {
			PoolDB pool = new PoolDB();
			String sql = "insert into usuarios values(?,?,?,?,?,?)";
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, usuario.getUsuario());
			statement.setString(3, usuario.getPassword());
			statement.setString(2, usuario.getEmail());
			statement.setString(4, usuario.getRole());
			statement.setString(5, usuario.getFirstName());
			statement.setString(6, usuario.getLastName());

			resultado = statement.executeUpdate();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return (resultado == 0 ? false : true);
	}
	
	
	

}
