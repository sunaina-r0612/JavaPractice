package Main;
import model.*;
import services.*;

import java.util.*;

public class main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Entities entities = Entities.getInstance();
		
		int noOfSnakes = sc.nextInt();
		while(noOfSnakes>0) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			entities.setSnake(start, end);
			noOfSnakes--;
		}
		
		int noOfLadders = sc.nextInt();
		while(noOfLadders>0) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			entities.setLadder(start, end);
			noOfLadders--;
		}
		
		int noOfPlayers = sc.nextInt();
		int i = 0;
		while(noOfPlayers>0) {
			int start = sc.nextInt();
			String name = sc.next();
			entities.setPlayer(i++, name);
			noOfPlayers--;
		}
		
		PlaySnakeAndLadder playSnakeAndLadder = new PlaySnakeAndLadder(6);
		System.out.println(playSnakeAndLadder.PlayGame() + "wins the game.");
	}
}
