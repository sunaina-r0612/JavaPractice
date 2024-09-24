package Model;

public class Player {
	private int id;
	private String name;
	private String symbol;
	private boolean isWin = false;
	
	public Player(int is, String name, String symbol) {
		this.id = id;
		this.name = name;
		this.symbol = symbol;
	}
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getSymbol(){
		return symbol;
	}
	
	public void setSymbol(String symbol){
		this.symbol = symbol;
	}
	
	public boolean isWin() {
		return isWin;
	}
}
