// Criação da classe ConnectionManager que é responsável por criar a conexão com o banco de dados Oracle.
// Ela é um Singleton, ou seja, só pode existir uma instância dela em todo o sistema.

package br.com.fintech.singleton;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {

	private static ConnectionManager connectionManager;

	private ConnectionManager() {
	}

	public static ConnectionManager getInstance() {
		if (connectionManager == null) {
			connectionManager = new ConnectionManager();
		}
		return connectionManager;
	}

	public Connection getConnection() {
		Connection connection = null;
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			connection = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "RM553184",
					"160999");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

}