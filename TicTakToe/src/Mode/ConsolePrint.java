package Mode;

import Model.*;

public class ConsolePrint implements Print{
	@Override
	public void printBoard(Board board) {
		for(String[] str: board.getBoard()) {
			for(int i = 0; i<board.getBoard().length; i++) {
				System.out.print(str[i] + " ");
			}
			System.out.println();
		}
	}
}
