package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Task;
import model.User;

public class TaskDBConnection {
	Connection conn = DBConnection.getConnection();
	/*public boolean insertTask2(Task task, User user){
		String sql="insert into task values (?,?,?,?,?)";
		//String sql="insert into task values (?,?,?,?)";
		PreparedStatement statement;
		try{
			statement= conn.prepareStatement(sql);
			statement.setLong(1, task.getTaskId());
			statement.setString(2, task.getTaskTitle());
			statement.setString(3, task.getTaskText());
			statement.setString(4, task.getAssignedTo());
			statement.setBoolean(5, task.isTaskCompleted());
			statement.execute();
		}catch(Exception e){
			e.printStackTrace();
		}
		return true;
	}*/
	public boolean insertTask(Task task, User user){
		
		String sql="insert into task (taskTitle, taskText, assignedTo, taskCompleted) values (?,?,?,?)";
		PreparedStatement statement;
		try{
			statement= conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			//statement.setLong(1, task.getTaskId());
			statement.setString(1, task.getTaskTitle());
			statement.setString(2, task.getTaskText());
			statement.setString(3, task.getAssignedTo());
			statement.setBoolean(4, task.isTaskCompleted());
			//System.out.println(statement);
			statement.execute();
			//ResultSet rs = statement.getGeneratedKeys();
			/*while (rs.next()) {
				System.out.println("Generated todo ID:"+rs.getInt(1));
			}*/
		}catch(Exception e){
			e.printStackTrace();
		}
		return true;
	}
	
	public boolean updateTask(Task task){
		String sql="update task set taskTitle =?, taskText=?, taskCompleted=? where assignedTo=? and taskId=?";
		PreparedStatement statement;
		try{
			statement= conn.prepareStatement(sql);
			statement.setString(1, task.getTaskTitle());
			statement.setString(2, task.getTaskText());
			statement.setBoolean(3, task.isTaskCompleted());
			statement.setString(4, task.getAssignedTo());
			statement.setLong(5, task.getTaskId());
			statement.execute();
		}catch(Exception e){
			e.printStackTrace();
		}
		return true;
	}
	
	public boolean deleteTask(Task task){
		String sql= "delete from task where assignedTo=? and taskId=?";
		PreparedStatement statement;
		try{
			statement= conn.prepareStatement(sql);
			statement.setString(1, task.getAssignedTo());
			statement.setLong(2, task.getTaskId());
			statement.execute();
		}catch(Exception e){
			e.printStackTrace();
		}
		return true;
	}
	public Task getTask(String userEmail, int taskId){
		String sql="Select * from task where assignedTo=? and taskId=?";
		PreparedStatement statement;
		Task task= null;
		try{
			statement= conn.prepareStatement(sql);
			statement.setString(1, userEmail);
			statement.setLong(2, taskId);
			ResultSet rs= statement.executeQuery();
			if(rs.next())
			{
				task= new Task();
				task.setTaskId(rs.getInt(1));
				task.setTaskTitle(rs.getString(2));
				task.setTaskText(rs.getString(3));
				task.setAssignedTo(rs.getString(4));
				task.setTaskCompleted(rs.getBoolean(5));
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return task;
	}
	public List<Task> getTaskByUser(String userEmail)
	{
		String sql = "Select taskId, taskTitle, taskText, assignedTo, taskCompleted from task where assignedTo=?";
		//String sql="Select * from task where assignedTo=?";
		PreparedStatement statement;
		List<Task> tasks = new ArrayList<>();
		try {
			statement= conn.prepareStatement(sql);
			statement.setString(1, userEmail);
			//System.out.println(statement);
			ResultSet rs = statement.executeQuery();
			//System.out.println("Executed");
			while(rs.next())
			{
				Task task= new Task();
				task.setTaskId(rs.getInt(1));
				task.setTaskTitle(rs.getString(2));
				task.setTaskText(rs.getString(3));
				task.setAssignedTo(rs.getString(4));
				task.setTaskCompleted(rs.getBoolean(5));
				tasks.add(task);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
		return tasks;
	}
	public List<Task> getCompletedTaskByUser(User user)
	{
		String sql = "Select taskId, taskTitle, taskText, assignedTo, taskCompleted from task where assignedTo=? and taskCompleted=?";
		//String sql="Select * from task where assignedTo=?";
		PreparedStatement statement;
		List<Task> tasks = new ArrayList<>();
		try {
			statement= conn.prepareStatement(sql);
			statement.setString(1, user.getEmail());
			statement.setBoolean(2, true);
			//System.out.println(statement);
			ResultSet rs = statement.executeQuery();
			//System.out.println("Executed");
			while(rs.next())
			{
				Task task= new Task();
				task.setTaskId(rs.getInt(1));
				task.setTaskTitle(rs.getString(2));
				task.setTaskText(rs.getString(3));
				task.setAssignedTo(rs.getString(4));
				task.setTaskCompleted(rs.getBoolean(5));
				tasks.add(task);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
		return tasks;
	}
	public List<Task> getIncompletedTaskByUser(User user)
	{
		String sql = "Select taskId, taskTitle, taskText, assignedTo, taskCompleted from task where assignedTo=? and taskCompleted=?";
		//String sql="Select * from task where assignedTo=?";
		PreparedStatement statement;
		List<Task> tasks = new ArrayList<>();
		try {
			statement= conn.prepareStatement(sql);
			statement.setString(1, user.getEmail());
			statement.setBoolean(2, false);
			//System.out.println(statement);
			ResultSet rs = statement.executeQuery();
			//System.out.println("Executed");
			while(rs.next())
			{
				Task task= new Task();
				task.setTaskId(rs.getInt(1));
				task.setTaskTitle(rs.getString(2));
				task.setTaskText(rs.getString(3));
				task.setAssignedTo(rs.getString(4));
				task.setTaskCompleted(rs.getBoolean(5));
				tasks.add(task);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
		return tasks;
	}

}
