package ui;

import java.util.Scanner;

import database.TaskDBConnection;

import database.UserDBConnection;

import model.Task;
import model.User;
import service.TaskService;
import service.UserService;

public class TodoMenu {
	public static Scanner sc;
	public static void main(String[] args) {
		//UserDao userDao= new UserDao();
		UserDBConnection userDao= new UserDBConnection();
		UserService userService= new UserService(userDao);
		
		//TaskDao taskDao= new TaskDao();
		TaskDBConnection taskDao= new TaskDBConnection();
		TaskService taskService= new TaskService(taskDao);
		int ch,flag=1;
		String userName, password, email;
		sc= new Scanner(System.in);
		System.out.println("\n\n************************Welcome to Todo Manager**********************************\n\n");
		do{
			
			System.out.println("****************User Menu******************\n"
					+ "Enter your choice\n"
					+"1.Login\n"
					+ "2.Create User\n"
					+ "3.See all user\n"
					+ "0.Exit");
			ch= sc.nextInt();
			switch(ch){
			case 1:
				System.out.println("Enter your user name");
				userName= sc.next();
				System.out.println("Enter your password");
				password= sc.next();
				userService.userLogin(userName, password);
				User user= userService.getUser(userName, password);
				taskmenu(taskService,user);
				break;
			case 2:
				System.out.println("Create your user name");
				userName= sc.next();
				System.out.println("Create your password");
				password= sc.next();
				System.out.println("Enter your Email");
				email= sc.next();
				User u= new User(userName,email,password);
				userService.createUser(u);
				break;
			case 3:
				userService.getAllUsers();
				break;
			case 0:
				flag=0;
				break;
			default:
				System.out.println("Wrong choice");
				break;
			}
		}while(flag==1);
		
		
		
	}
	private static void taskmenu(TaskService taskService, User user) {
		// TODO Auto-generated method stub
		int ch,taskId, flag=1,id;
		String title,text,status;
		Task task;
		do{
			System.out.println("*******************Task Menu**********************"
					+ "\nEnter your choice\n"+
							"1.Get all your task"
							+ "\n"
							+ "2.Get Task By Id"
							+ "\n3.Create Task"
							+ "\n4.Delete Task"
							+ "\n5.Update Task"
							+"\n6.Completed Task"
							+"\n7.Incomplete Task"
							+"\n0.Exit");
			ch= sc.nextInt();
			switch(ch){
			case 1:
				taskService.getTaskByUser(user.getEmail());
				break;
			case 2:
				System.out.println("Enter the task Id");
				taskId= sc.nextInt();
				taskService.getTaskById(user.getEmail(),taskId);
				break;
			case 3:
				//System.out.println("Enter the task Id");
				//taskId= sc.nextInt();
				System.out.println("Enter the task Title");
				title= sc.next();
				System.out.println("Enter the task Text");
				text= sc.next();
				//task= new Task(taskId,title,text,user.getEmail());
				task= new Task(title,text,user.getEmail());
				taskService.createTask(task,user);
				break;
			case 4:
				System.out.println("Enter the task Id which you want to delete");
				taskId= sc.nextInt();
				task=taskService.returnTaskById(user.getEmail(),taskId);
				taskService.deleteTask(task, user);
				break;
			case 5:
				System.out.println("Enter the task Id which you want to update");
				taskId= sc.nextInt();
				int f=1;
				task=taskService.returnTaskById(user.getEmail(),taskId);
				do{
					System.out.println("What you want Update?\n"
							+ "1.Task title\n"
							+ "2.Task Text\n"
							+ "3.Task completion status"
							+"\n0.exit");
					int choice= sc.nextInt();
					switch(choice){
					case 1:
						System.out.println("Enter the updated task Title");
						title= sc.next();
						task.setTaskTitle(title);
						break;
					case 2:
						System.out.println("Enter the updated task Text");
						text= sc.next();
						task.setTaskText(text);
						break;
					case 3:
						System.out.println("Enter Y for completed and N for not completed");
						status= sc.next();
						//status.equalsIgnoreCase("y") ? task.setTaskCompleted(true): task.setTaskCompleted(false);
						if(status.equalsIgnoreCase("y")){
							task.setTaskCompleted(true);
						}else{
							task.setTaskCompleted(false);
						}
						break;
					case 0:
						f=0;
						break;
						default:
							System.out.println("Wrong choice");
							break;
					}
					
				}while(f==1);
				
						
				taskService.updateTask(task,user);
				break;
			case 6:
				taskService.getCompletedTask(user);
				break;
			case 7:
				taskService.getIncompletedTask(user);
				break;
			case 0:
				flag=0;
				break;
			default:
				System.out.println("Wrong choice");
			}
		}while(flag==1);
		
	}

}
