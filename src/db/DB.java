package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {

	private static Connection conn = null;

	// método para conectar ao banco de dados
	public static Connection getConnection() {
		if (conn == null) {
			try {
				Properties props = loadProperties();
				String url = props.getProperty("dburl");
				conn = DriverManager.getConnection(url, props);
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}

		}

		return conn;

	}

	// metodo paraa fechar a conexao
	public static void closeConnection() {
		if (conn != null) {

			try {

				conn.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());

			}

		}
	}

	// método para carregar as propriedades para conexão do banco de dados
	private static Properties loadProperties() {
		try (FileInputStream fs = new FileInputStream("db.properties")) {
			Properties props = new Properties();
			props.load(fs);
			return props;
		} catch (IOException e) {
			throw new DbException(e.getMessage());

		}
	}

}
