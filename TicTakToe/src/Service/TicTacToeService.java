package Service;
import java.util.*;

import Exceptions.BoardExceptions;
import Model.*;
import Validations.*;
import Mode.*;

public class TicTacToeService {
	Board board;
	List<Player> players;
	GameValidation gameValidation;
	Print print;
	int gameCount = 0; // to check the game is draw or not
	
	public TicTacToeService(Board board,List<Player> players, GameValidation gameValidation, Print print) {
		this.board = board;
		this.players = players;
		this.gameValidation = gameValidation;
		this.print = print;
	}
	
	public void input(int x, int y, Player player) {
		if(!gameValidation.validateCoordinates(x,y)) {
			throw new BoardExceptions("Inputs are not valid");
		}
		
		if(!gameValidation.validationIsBoardPositionEmpty(x,y)) {
			throw new BoardExceptions("Board point are already filled");
		}
		
		String symbol = player.getSymbol();
		board.setPosition(x, y, symbol);
		print.printBoard(board);
		if(checkBoard(x,y,symbol)) {
			System.out.println("Player " + player.getName() + " wins");
			System.exit(0);
		}
		
		gameCount++;
		if(checkBoardFill()) {
			System.out.println("Draw Game");
			System.exit(0);
		}
	}
	
	public boolean checkBoard(int row, int col, String symbol) {
		boolean winrow = true, wincol = true, winleft = true, winright = true;
		for(int i = 0; i<board.getBoard().length; i++) {
			if(!board.getPosition(row, i).equals(symbol)) {
				winrow = false;
			}
			if(!board.getPosition(i, col).equals(symbol)) {
				wincol = false;
			}
			if(!board.getPosition(i, i).equals(symbol)) {
				winleft = false;
			}
			if(!board.getPosition(i, board.getBoard().length-1-i).equals(symbol)) {
				winright = false;
			}
		}
		
		return winrow || wincol || winleft || winright; 
	}
	
	private boolean checkBoardFill() {
		return gameCount == board.getBoard().length * board.getBoard()[0].length;
	}
}
