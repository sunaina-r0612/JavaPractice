package Model;
import java.util.HashMap;

public enum Type {
	EXPENSE("EXPENSE"),
	SHOW("SHOW"),
	QUIT("QUIT");
	
	private final String name;
	
	Type(String s){
		this.name = s;
	}
	
	public String toString() {
		return this.name;
	}
	
	private static final HashMap<String, Type> map = new HashMap<>(values().length,1);
	
}
