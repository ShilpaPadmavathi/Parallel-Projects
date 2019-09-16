package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class WalletDB {
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Shilpa", "shilpa123");
		return conn;
	}
}