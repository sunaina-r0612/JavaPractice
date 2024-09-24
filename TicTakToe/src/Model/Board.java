package Model;

public class Board {
	String[][] board;
	
	public Board(int n) {
		board = new String[n][n];
		for(String[] sts: board) {
			for(int j = 0; j<n; j++){
				sts[j] = "_";
			}
		}
	}
	
	public void setPosition(int x, int y, String symbol) {
		board[x][y] = symbol;
	}
	
	public String getPosition(int x, int y) {
		return board[x][y];
	}
	
	public String[][] getBoard() {
		return board;
	}
}
