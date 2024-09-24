package model;

import java.util.*;

public class Entities {
	static HashMap<Integer, Integer> snakes;
	static HashMap<Integer, Integer> ladders;
	static HashMap<Integer, String> players;
	
	static Entities instance = null;
	
	public Entities(){
		snakes = new HashMap<>();
		ladders = new HashMap<>();
		players = new HashMap<>();
	}
	
	public void setSnake(int start, int end) {
		snakes.put(start, end);
	}

	public HashMap<Integer, Integer> getSnake() {
		return snakes;
	}
	
	public void setLadder(int start, int end) {
		ladders.put(start, end);
	}
	
	public HashMap<Integer, Integer> getLadder() {
		return ladders;
	}
	
	public void setPlayer(int position, String name) {
		players.put(position, name);
	}
	
	public HashMap<Integer, String> getPlayer() {
		return players;
	}
	
	//singleton instance
	public static Entities getInstance() {
		if(instance == null) {
			instance = new Entities();
		}
		
		return instance;
	}
}
