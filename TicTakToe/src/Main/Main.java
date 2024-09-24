package Main;

import java.util.*;
import Model.*;
import Mode.*;
import Exceptions.*;
import Service.*;
import Validations.*;

public class Main {
	public static void main(String[] args) {
		Board board = new Board(3);
		
		Player p1 = new Player(1, "p1", "O");
		Player p2 = new Player(2, "p2", "X");
		
		List<Player> players = Arrays.asList(p1,p2);
		HashMap<Integer, Boolean> playerCheck = new HashMap<>();
		playerCheck.put(p1.getId(), true);
		playerCheck.put(p2.getId(), true);
		
		GameValidation gameValidator = new GameValidation(board, playerCheck);
		TicTacToeService ticTacToeService = new TicTacToeService(board, players, gameValidator, new ConsolePrint());
		
		while(true) {
			System.out.println("Choose Input 1: play 2: Exit");
			Scanner sc = new Scanner(System.in);
			int option = sc.nextInt();
			
			switch(option){
				case 1:
					System.out.println("Please enter your ID");
					Player player = players.get(sc.nextInt());
					System.out.println("Enter your move x and y");
					ticTacToeService.input(sc.nextInt(), sc.nextInt(), player);
					break;
				case 2:
					System.exit(0);
					break;
				default:
					System.out.println("Choose 1");
					break;
			}
		}
	}
}
