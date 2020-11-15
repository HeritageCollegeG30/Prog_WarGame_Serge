package warGame;

public class Intro {
	private String title;
	private String[] rules;
	
	public Intro() {
		title = "Welcome to the game of war";
		rules = new String[6];
		rules[0] = "The object of the game is to force the other player to run out of cards.";
		rules[1] = "All the cards are dealt at the beginning of the game.";
		rules[2] = "Each play both players lay the top card of their pile face up.";
		rules[3] = "The player with the highest rank card, puts both cards on the \nbottom of his pile.";
		rules[4] = "If both cards have the same rank, each player plays three cards face down \nand plays another round.";
		rules[5] = "The winner of the tie-breaking round gets all the played cards (the cards in the tie, "
				+ "\nthe six face down and the two in the tie-breaking play.)";
	}//Intro()
	
	public String getTitle() {
		return title;
	}//getTitle()
	
	public String[]	getRules() {
		return rules;
	}//getRules()
}//class Intro
