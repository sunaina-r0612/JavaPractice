package model;

import java.util.*;

public class Dice {
	private int numberOfDice;
	private static int MIN = 1;
	
	Random random;
	
	public Dice(int numberOfDice) {
		random = new Random();
		this.numberOfDice = numberOfDice;
	}
	
	public int getNumberOfDice() {
		int bound = this.numberOfDice - MIN + 1;
		return random.nextInt(bound) +1;
	}
}
