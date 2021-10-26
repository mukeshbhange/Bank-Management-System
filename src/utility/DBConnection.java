package utility;
import java.sql.*;

public class DBConnection {
	
	public Connection getConnection(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		String dbURL = "jdbc:mysql://localhost:3306/bank_management_system";
		String username = "root";
		String password = "root";

		Connection conn;
		try {
			conn = DriverManager.getConnection(dbURL, username, password);
			if(conn != null) {
				return conn;
			}else {
				System.out.println("Connection Failed");
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}
}
