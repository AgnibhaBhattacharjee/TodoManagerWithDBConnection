package model;



public class Task {
	public static int count=0;
	private int taskId;
	private String taskTitle;
	private String taskText;
	private String assignedTo;
	private boolean taskCompleted;
	public Task() {
		super();
		//this.taskId= count++;
		// TODO Auto-generated constructor stub
	}
	public Task(String taskTitle, String taskText, String assignedTo) {
		super();
		//this.taskId= count++;
		this.taskTitle = taskTitle;
		this.taskText = taskText;
		this.assignedTo = assignedTo;
		this.taskCompleted=false;
	}
	
	public Task(int taskId, String taskTitle, String taskText, String assignedTo) {
		super();
		this.taskId = taskId;
		this.taskTitle = taskTitle;
		this.taskText = taskText;
		this.assignedTo = assignedTo;
		this.taskCompleted=false;
	}
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public String getTaskTitle() {
		return taskTitle;
	}
	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}
	public String getTaskText() {
		return taskText;
	}
	public void setTaskText(String taskText) {
		this.taskText = taskText;
	}
	public String getAssignedTo() {
		return assignedTo;
	}
	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}
	public boolean isTaskCompleted() {
		return taskCompleted;
	}
	public void setTaskCompleted(boolean taskCompleted) {
		this.taskCompleted = taskCompleted;
	}
	@Override
	public String toString() {
		return "Task=> Task id=" + taskId + ", Task title=" + taskTitle + ", Task text=" + taskText + ", Task is assigned to="
				+ assignedTo + ", Is task completed?=" + taskCompleted + "";
	}
	

}
