package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserDBConnection {
	
	Connection conn = DBConnection.getConnection();
	
	public List<User> getAllUsers() throws Exception
	{
		String sql = "select * from user";
	
		List<User> users = new ArrayList<>();
		try {
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next())
			{
				User u1 = new User();
				u1.setUserName(rs.getString(1));
				u1.setEmail(rs.getString(2));
				u1.setPassword(rs.getString(3));
				users.add(u1);
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		return users;
	}
	
	public boolean logIn(String userName, String password){
		String sql="Select pass from user where username=?";
		PreparedStatement statement;
		try{
			statement= conn.prepareStatement(sql);
			statement.setString(1, userName);
			//System.out.println(statement);
			ResultSet rs= statement.executeQuery();
			//System.out.println(rs.getString(1));
			if(rs.next()){
				if(password.equals(rs.getString(1))){
					return true;
				}
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	public User getUser(String userName, String password){
		String sql="Select * from user where username=?";
		PreparedStatement statement;
		try{
			statement= conn.prepareStatement(sql);
			statement.setString(1, userName);
			ResultSet rs= statement.executeQuery();
			if(rs.next()){
				if(password.equals(rs.getString(3))){
					User user= new User(rs.getString(1),rs.getString(2),rs.getString(3));
					return user;
				}
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean createUser(User user){
		String sql="insert into user values (?,?,?)";
		PreparedStatement statement;
		try{
			statement= conn.prepareStatement(sql);
			statement.setString(1, user.getUserName());
			statement.setString(2, user.getEmail());
			statement.setString(3, user.getPassword());
			statement.execute();
		}catch(Exception e){
			e.printStackTrace();
		}
		return true;
	}
	

}
