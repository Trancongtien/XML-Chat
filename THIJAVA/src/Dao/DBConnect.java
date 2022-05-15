package Dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	public static Connection getConnection1() {
		Connection connection = null;
		try {
			String connectionUrl = "jdbc:sqlserver://TRANCONGTIEN\\SQLEXPRESS:1433;"
					+ "databaseName=MidTermDB;user=sa;password=123";
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(connectionUrl);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	  public static Connection getConnection() {
	        Connection cons = null;
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            cons = DriverManager.getConnection(
	                    "jdbc:mysql://localhost:3306/MidTermDB?characterEncoding=UTF-8", "root", "trancongtien");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return cons;
	    }
}
