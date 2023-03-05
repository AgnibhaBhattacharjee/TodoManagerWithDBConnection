package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static Connection getConnection(){
		Connection con= null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
			//con= DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCTest","root","root");
			System.out.println("Connection created");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return con;
	}

}
