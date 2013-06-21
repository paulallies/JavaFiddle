package app1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionHandler {
	
    public static Connection getConnection() {
        Connection conn;
        try {
                String userName = "root";
                String password = "root";
                String url = "jdbc:mysql://localhost/dstv";
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                conn = (Connection) DriverManager.getConnection(url, userName, password);
        } catch (Exception e) {
                throw new DataAccessException(e);
        }
        return conn;
    }

	public static void closeConnection(Connection conn) {
	        if (conn != null) {
	                try {
	                        conn.close();
	                } catch (SQLException e) {
	                        throw new DataAccessException("Could not close connection", e);
	                }
	        }
	}
}
