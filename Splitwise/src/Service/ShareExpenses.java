package Service;

import java.util.*;
import Model.*;

public class ShareExpenses {
	public List<User> users;
	
	public ShareExpenses(List<User> users) {
		this.users = users;
	}
	
	public void splitEqualExpenses(String userName, double totalAmount, List<User> owedUsers) {
		Optional<User> user = getName(userName);
		
	}
}
