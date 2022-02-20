package com.MVCAct3.T22Act3.model.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnection {
	
	static String bd = "Laboratorio";
	static String login = "remote";
	static String password = "Remote.2103";
	static String url = "jdbc:mysql://192.168.0.15:3306/" + bd + "?useTimezone=true&serverTimezone=UTC";

	Connection conn = null;

	// Constructor de DbConnection
	public MysqlConnection() {
		try {
			// obtenemos el driver de mysql
			Class.forName("com.mysql.cj.jdbc.Driver");
			// obtenemos la conexion
			conn = DriverManager.getConnection(url, login, password);

			if (conn != null) {
				System.out.print("Conexión a base de datos " + bd + "_SUCCESS at ");				
			}
		} catch (SQLException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// Permite retornar la conexion
	public Connection getConnection() {
		return conn;
	}

	public void desconectar() {
		conn = null;
	}
}
