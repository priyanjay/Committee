package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import exceptions.DatabaseNotFoundException;
import exceptions.DriverNotFoundException;

public class Connect {
	public static Connection con=null;
	public static Connection connect() throws DriverNotFoundException, DatabaseNotFoundException{
		String url="jdbc:mysql://localhost:3306/committee?autoReconnect=true";
		String username="root";
		String password="root";
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			con=DriverManager.getConnection(url,username,password);
			return con;
		} catch (ClassNotFoundException e) {
			throw new DriverNotFoundException("\n\t\tDatabase Driver Not Found !!!!!",e);
		} catch (SQLException e) {
			throw new DatabaseNotFoundException("\n\t\t\t\tCan't Connect to Server !!!!!!",e);
		}
	}

	public static void disconnect() throws SQLException{
		try{
			con=null;
			con.close();
		}
		catch(SQLException e){
			System.out.println("Connection Can't be Closed !!!");
		}
	}	
}
