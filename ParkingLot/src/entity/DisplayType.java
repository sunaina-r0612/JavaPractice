package entity;
import java.util.*;

public enum DisplayType{
		FREE_COUNT("free_count"),
		FREE_SLOTS("free_slot"),
		OCCUPIED_SLOTS("occupied_slots");
	
		private final String display;
		
		DisplayType(String s) {
			display = s;
		}
		
		public String toString() {
			return this.display;
		}
		
		public static final HashMap<String, DisplayType> map = new HashMap<>(values().length, 1);
		
		static {
			for(DisplayType c: values()) map.put(c.display, c);
		}
		
		public static DisplayType of(String name) {
			return map.get(name);
		}
	
}