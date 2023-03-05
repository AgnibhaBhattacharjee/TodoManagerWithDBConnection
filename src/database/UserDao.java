/*package database;

import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserDao {
	private List<User> users= new ArrayList<>();

	public UserDao() {
		super();
		// TODO Auto-generated constructor stub
		users.add(new User("a","a@a.com","a"));
		users.add(new User("b","b@b.com","b"));
		users.add(new User("c","c@c.com","c"));
		users.add(new User("d","d@d.com","d"));
		
	}
	public List<User> getAllUsers(){
		return users;
	}
	public boolean createUser(User user){
		for(User u:users){
			if(u.getEmail().equals(user.getEmail())){
				throw new RuntimeException("The user email id is not unique");
			}
		}
		users.add(user);
		return true;
	}
	
	public boolean logIn(String userName, String password){
		for(User user:users){
			if(user.getUserName().equals(userName)){
				if(user.getPassword().equals(password)){
					return true;
				}
			}
		}
		return false;
	}
	
	public User getUser(String userName, String password){
		for(User user:users){
			if(user.getUserName().equals(userName)){
				if(user.getPassword().equals(password)){
					return user;
				}
			}
		}
		return null;
	}
	

}*/
