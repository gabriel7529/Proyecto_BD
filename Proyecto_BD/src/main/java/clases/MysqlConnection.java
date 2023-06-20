package clases;

import java.sql.DriverManager;

import java.sql.Connection;

import java.sql.SQLException;

public class MysqlConnection {
	
	public static Connection getConexion() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
			String url = "jdbc:mysql://localhost:3307/proyecto_bd";
			String usr = "root";
			String psw = "";
			con =  DriverManager.getConnection(url, usr, psw);
		} catch (ClassNotFoundException e) {
			System.out.println("Error >> driver no instalado " + e.getMessage());
		}catch (SQLException e) {
			System.out.println("Error >> de la conexión con la BD " + e.getMessage());
		}
		catch (Exception e) {
			System.out.println("Error >> general " + e.getMessage());
		}
		return con;
	}
	public static void closeConexion (Connection con) {
		try {
			con.close();
		}catch (SQLException e) {
			System.out.println("Problemas de la conexión");
		}
	}

}
