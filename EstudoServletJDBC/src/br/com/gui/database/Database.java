package br.com.gui.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	
	private Connection connection;

	public Connection conectaBd() {

		String driverName = "com.mysql.cj.jdbc.Driver";
		String jdbc = "jdbc:mysql://";
		String ip = "localhost:3306/";
		String databaseName = "TREINAMENTO?useTimezone=true&serverTimezone=UTC";
		String url = jdbc + ip + databaseName;
		String usuario = "admin";
		String senha = "tecsis";

		try {
			Class.forName(driverName);
			connection = DriverManager.getConnection(url, usuario, senha);
			return connection;
		} catch (ClassNotFoundException ex) {
			System.out.println("Driver não encontrado: " + ex);
			return null;
		} catch (SQLException sqlex) {
			System.out.println("Não foi possível conectar no banco: " + sqlex);
			return null;
		}

	}

	public void desconectaBd(Connection connection) {
		try {
			connection.close();
		} catch (SQLException sqlex) {
			System.out.println("Não foi possível encerrar a conexão no banco: " + sqlex);
		}
	}

}
