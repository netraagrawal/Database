package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionToDb {
	
	private Connection con = null;

	public Connection getCon() {
		return con;
	}

	public ConnectionToDb() {
		
		
	}
	
	
	
	public void closeConnection(Connection con2) {
		try{
			con2.close();
		}catch (SQLException e) {
			// TODO: handle exception
			System.err.println("Cannot close connection " + e.getMessage());
		}
		
	}

	
	public Connection openConnection() throws SQLException {
		
		DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
		
		String host = "localhost"; 
        String port = "1521"; 
        String dbName = "oracledb"; 
        String userName = "scott"; 
        String password = "tiger"; 
        
        String dbURL = "jdbc:oracle:thin:@" + host + ":" + port + ":" + dbName;
        return DriverManager.getConnection(dbURL, userName, password);
	}

}
