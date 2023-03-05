/*package database;

import java.util.ArrayList;
import java.util.List;

import model.Task;
import model.User;

public class TaskDao {
	private List<Task> tasks = new ArrayList<>();
	//UserDao userDao= new UserDao();
	public TaskDao()
	{
		tasks.add(new Task("Task for assignment","Complete the Core java assignment","a@a.com"));
		tasks.add(new Task("Task for assignment","Complete the Core java assignment","b@b.com"));
		tasks.add(new Task("Task for assignment","Complete the Core java assignment","c@c.com"));
	}
	
	public List<Task> gettAllTask(){
		return tasks;
	}
	
	public boolean insertTask(Task task, User user){
				tasks.add(task);
				return true;
		
	}
	public boolean updateTask(Task task){
		for(Task t:tasks){
					if(t.getTaskId()==task.getTaskId()){
						t.setTaskTitle(task.getTaskTitle());
						t.setTaskText(task.getTaskText());
						t.setTaskCompleted(task.isTaskCompleted());
						return true;
					}
				}
				
		
		return false;
		
	}
	
	public boolean deleteTask(Task task){
		for(Task t:tasks){
					if(t.getTaskId()==task.getTaskId()){
						
						return tasks.remove(task);
					}
				}
				
			
		return false;
		
	}
	public Task getTask(String userEmail, int taskId){
		for(Task task:tasks){
					if(task.getTaskId()==taskId){
						if(task.getAssignedTo().equals(userEmail)){
							return task;
						}else{
							System.out.println("This task is not available for this user");
						}
						
					}
				}
				
		return null;
		
	}
	
	public List<Task> getTaskByUser(String userEmail){
		List<Task> usertask= new ArrayList<>();
		for(Task task:tasks){
			if(task.getAssignedTo().equals(userEmail)){
				usertask.add(task);
			}
		}
		return usertask;
	}

	public List<Task> getCompletedTaskByUser(User user) {
		// TODO Auto-generated method stub
		List<Task> usertask= new ArrayList<>();
		for(Task task:tasks){
			if(task.getAssignedTo().equals(user.getEmail()) && task.isTaskCompleted()){
				usertask.add(task);
			}
		}
		return usertask;
	}
	public List<Task> getIncompletedTaskByUser(User user) {
		// TODO Auto-generated method stub
		List<Task> usertask= new ArrayList<>();
		for(Task task:tasks){
			if(task.getAssignedTo().equals(user.getEmail()) && task.isTaskCompleted()==false){
				usertask.add(task);
			}
		}
		return usertask;
	}

	

}*/
