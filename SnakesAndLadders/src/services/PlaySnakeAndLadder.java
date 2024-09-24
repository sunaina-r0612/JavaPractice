package services;
import java.util.*;
import model.*;

public class PlaySnakeAndLadder {
	HashMap<String, PairPosition> playerHistory;
	HashMap<String, Integer> playerLatestPosition;
	Entities entities;
	Dice dice;
	
	public PlaySnakeAndLadder(int N) {
		playerHistory = new HashMap<>();
		playerLatestPosition = new HashMap();
		entities = Entities.getInstance();
		dice = new Dice(N);
	}
	
	public String PlayGame(){
		initializePlayersStartValue();
		int i = -1;
		do {
			i++; // i th player playing
			if(i>=entities.getPlayer().size()) {
				i=0;
			}
			
			StringBuilder str = new StringBuilder();
			String name = entities.getPlayer().get(i);
			str.append(name);
			
			int number = dice.getNumberOfDice();
			int end = playerLatestPosition.get(name) + number;
			
			String s = "";
			if(checkForDiceNumberGreaterThan100(end)) {
				str.append(" rolled a ").append(number);
				str.append(" and moved from ").append(playerLatestPosition.get(name));
				if(entities.getSnake().get(end)!=null) {
					//captures snake
					s = " after snake dinner";
					playerLatestPosition.put(name, entities.getSnake().get(end));
				}else {
					if(entities.getLadder().get(end)!=null) {
						//captures ladder
						s = " after ladder ride";
						playerLatestPosition.put(name, entities.getLadder().get(end));
					}
				}
				
				str.append(" to ").append(playerLatestPosition.get(name));
				str.append(s);
			}
		}while(!isPlayerWon(entities.getPlayer().get(i)));
		
		return entities.getPlayer().get(i);
	}
	
	private boolean isPlayerWon(String player) {
		return playerLatestPosition.get(player) == 100;
	}
	
	private boolean checkForDiceNumberGreaterThan100(int end) {
		return end<=100;
	}
	
	private void initializePlayersStartValue() {
		for(int i = 0; i<entities.getPlayer().size(); i++) {
			playerLatestPosition.put(entities.getPlayer().get(i), 0);
		}
	}
}
