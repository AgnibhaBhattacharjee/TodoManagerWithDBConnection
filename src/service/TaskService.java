package service;

import java.util.List;
import java.util.Optional;

import database.TaskDBConnection;

import model.Task;
import model.User;

public class TaskService {
	//private TaskDao taskDao;
	private TaskDBConnection taskDao;
	public TaskService(TaskDBConnection taskDao){
		this.taskDao= taskDao;
	}
	
	public void createTask(Task task, User user){
		if(this.taskDao.insertTask(task,user)){
			System.out.println(task.getTaskTitle()+" Created for user "+user.getUserName()+" and associated with eamil "+ task.getAssignedTo());
		}else{
			throw new RuntimeException("Task can not be created as associated user is not available");
		}
	}
	public void updateTask(Task task, User user){
		if(this.taskDao.updateTask(task)){
			System.out.println(task.getTaskTitle()+" is updated for user "+ user.getUserName());
		}else{
			throw new RuntimeException("Task is not Updated");
		}
	}
	public void deleteTask(Task task, User user){
		if(this.taskDao.deleteTask(task)){
			System.out.println(task.getTaskTitle()+" is Deleted for user "+ user.getUserName());
		}else{
			throw new RuntimeException("Task is not Deleted");
		}
	}
	public void getTaskById(String userEmail, int taskId){
		Task task=this.taskDao.getTask(userEmail,taskId);
		if(task==null){
			throw new RuntimeException("Task not found for this particular User");
		}else{
			System.out.println("The task you want to view-\n");
			System.out.println(task.toString());
		}
	}
	public Task returnTaskById(String userEmail, int taskId){
		Task task=this.taskDao.getTask(userEmail,taskId);
		if(task==null){
			throw new RuntimeException("Task not found for this particular User");
		}else{
			return task;
		}
	}
	public void getTaskByUser(String userEmail){
		List<Task> tasks=this.taskDao.getTaskByUser(userEmail);
		if(tasks.isEmpty()){
			System.out.println("No task available for this user");
		}else{
			System.out.println("List of all the task you have-\n");
			for(Task t:tasks){
				System.out.println(t.toString());
			}
		}
	}

	public void getCompletedTask(User user) {
		// TODO Auto-generated method stub
		List<Task> tasks=this.taskDao.getCompletedTaskByUser(user);
		if(tasks.isEmpty()){
			System.out.println("No Completed tasks for this User");
		}else{
			System.out.println("List of all the completed task you have-\n");
			for(Task t:tasks){
				System.out.println(t.toString());
			}
		}
	}
	public void getIncompletedTask(User user) {
		// TODO Auto-generated method stub
		List<Task> tasks=this.taskDao.getIncompletedTaskByUser(user);
		if(tasks.isEmpty()){
			System.out.println("No Incomplete tasks for this User");
		}else{
			System.out.println("List of all the incomplete task you have-\n");
			for(Task t:tasks){
				System.out.println(t.toString());
			}
		}
	}

}
