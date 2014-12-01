package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
	public static void main(String[] args) {
		getConnection();
	}
	public static Connection getConnection() {
		Connection connection = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("class.forname");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/?user=root&password=venezia"); 

//					"jdbc:mysql://localhost:3306",
//					"root", "admin");
			System.out.println("connect");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

}
