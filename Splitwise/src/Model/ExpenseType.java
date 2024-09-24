package Model;

import java.util.*;

public enum ExpenseType {
	EQUAL("EQUAL"),
	EXACT("EXACT"),
	PERCENT("PERCENT");
	
	private final String expense;
	
	ExpenseType(String s){
		expense = s;
	}
	
	public String toString() {
		return this.expense;
	}
	
	private static final HashMap<String, ExpenseType> map = new HashMap<>(values().length,1);
	
}