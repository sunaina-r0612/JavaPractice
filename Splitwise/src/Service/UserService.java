package Service;

import Model.*;
import java.util.*;

public class UserService {
	List<User> users;
	
	public UserService(List<User> users) {
		this.users = users;
	}
	
	public Optional<User> getUser(String userNmae){
		return users.stream().filter(u->u.getUserName().equals(userName)).findFirst();
	}
}
