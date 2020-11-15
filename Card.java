package warGame;

public class Card {
	private String rank;
	private char suit;
	private int value;
	
	public Card(String inRank, char inSuit, int inValue) {
		rank = inRank;
		suit = inSuit;
		value = inValue;
	}//Card()
	
	public String getRank() {
		return rank;
	}//getRank()
	
	public char getSuit() {
		return suit;
	}//getSuit()
	
	public int getValue() {
		return value;
	}// getValue()
	
	public String toString() {
		return rank + suit;
	}//toString()
}
