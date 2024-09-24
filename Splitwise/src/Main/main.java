package Main;

import java.util.*;
import Model.*;
import Service.*;

public class main {
	public static void main(String[] args) {
		User user1 = new User(1, "u1", "u1@gmail.com", "9890098900");
		User user2 = new User(2, "u2", "u2@gmail.com", "9890098900");
		User user3 = new User(3, "u3", "u3@gmail.com", "9890098900");
		User user4 = new User(4, "u4", "u4@gmail.com", "9890098900");
		
		List<User> users = new ArrayList<>(Arrays.asList(user1,user2,user3,user4));
		
		ShareExpenses shareExpenses = new ShareExpenses(users);
		UserService userService = new UserService(users);
		
		while(true) {
			Scanner sc = new Scanner(System.in);
			Type type = new Type(sc.next());
			
			switch(type) {
				case Expense:
					String user = sc.next();
					int amountSpend = sc.nextInt();
					double totalMembers = sc.nextDouble();
					List<User> owedUsers = new ArrayList<User>();
					
					for(int i = 0; i<totalMembers; i++) {
						owedUsers.add(userService.getUser(sc.next()));
					}
					
					ExpenseType expense = ExpenseType.of(sc.next());
					switch(expense) {
						case EQUAL:
							shareExpenses.splitEqualExpenses(
									user, amountSpend, owedUsers
							);
							break;
						case EXACT:
							HashMap<User, Double> owedAmountMap = new HashMap<>();
							double sum = 0;
							for(int i = 0; i<totalMembers; i++) {
								double amount = sc.nextDouble();
								sum+=amount;
								owedAmountMap.put(owedUsers.get(i),amount);
							}
							
							if(sum!= amountSpend) {
								System.out.println("Sum not match to actual split amount");
								break;
							}
							
							shareExpenses.splitExactExpenses(
									user, amountSpend, owedUsers, owedAmountMap
							);
							
							break;
						case PERCENT:
							HashMap<User, Double> owedAmountMap = new HashMap<>();
							double per = 0;
							for(int i = 0; i<totalMembers; i++) {
								double amount = sc.nextDouble();
								per+=amount;
								owedPercentageMap.put(owedUsers.get(i),amount);
							}
							
							if(per!=100) {
								System.out.println("Sum not match to 100");
								break;
							}
							
							shareExpenses.splitPercentageExpenses(
									user, amountSpend, owedUsers, owedPercentageMap
							);
							break;
							
					case SHOW:
						String userName = sc.nextLine();
						shareExpenses.showExpense(userName);
						break;
					
					case QUIT: 
						System.out.println("Quiting...");
						return;
						
					default:
						System.out.println("No Expected Augment Found");
						return;
					}		
					
			}
		}
	}
}
