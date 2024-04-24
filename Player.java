package Tictactoe;



public class Player {
    private String type;
    private String name;
    
    public Player(String type, String name) {
    	this.type = type;
    	this.name = name;
    }
    
    public Player(String type) {
    	this.type = type;
    	this.name = "Computer";
    }
    
    public String getName() {
    	return name;
    }
    
    public String getType() {
    	return type;
    }
}