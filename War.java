package warGame;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class War {
	private Deck deck;
	private Queue<Card> player1Cards;
	private Queue<Card> player2Cards;
	private Deque<Card> kittyStack;
	private String player1;
	private String player2;
	private String rndWinner;
	private boolean tie;
	public static enum rndResult {W, T, E};
	
	public War() {
		deck = null;
		player1Cards = new LinkedList<Card>();
		player2Cards = new LinkedList<Card>();
		kittyStack = new ArrayDeque<Card>();
		player1 = "Player 1";
		player2 = "Player 2";
		rndWinner = null;
		tie = false;
		
	}//war()
	
	public War(String p1Name, String p2Name) {
		deck = new Deck();
		player1Cards = new LinkedList<Card>();
		player2Cards = new LinkedList<Card>();
		kittyStack = new ArrayDeque<Card>();
		player1 = (p1Name.length() > 0)? p1Name : "Player 1";
		player2 = (p2Name.length() > 0)? p2Name : "Player 2";
		rndWinner = null;
		tie = false;
	}//war()
	
	public void setDeck(Deck inDeck) {
		deck = inDeck;
	}//setDeck(Deck inDeck)
	
	public Deck getDeck() {
		return deck;
	}//getDeck()
	
	public Queue<Card> getP1Cards() {
		return player1Cards;
	}//getP1Cards()
	
	public Queue<Card> getP2Cards()	{
		return player2Cards;
	}//getP2Cards()
	
	public Deque<Card> getKitty() {
		return kittyStack;
	}//getKitty()
	
	public void setP1Name(String p1Name) {
		player1 = p1Name;
	}//setP1Name()
	
	public void setP2Name(String p2Name) {
		player2 = p2Name;
	}//setP2Name()
	
	public String getP1Name() {
		return player1;
	}//getP1Name()
	
	public String getP2Name() {
		return player2;
	}//getP1Name()
	
	public String getRndWinner() {
		return rndWinner;
	}//getRndWinner()
	
	public String getWinner() {
		if(player1Cards.isEmpty()) {
			return player2;
		}else {
			return player1;
		}
	}//getWinner()
	
	public void start() {
		while(deck.size() > 0) {
			if(deck.size() % 2 == 0) {
				player1Cards.offer(deck.deal());
			}else {
				player2Cards.offer(deck.deal());
			}
		}//while
	}//start()
	
	public rndResult play()	{
		Card p1Card = player1Cards.poll();
		Card p2Card = player2Cards.poll(); 
		
		if(p1Card.getValue() == p2Card.getValue()) {
			tie = true;
			fillKitty(p1Card, p2Card);
			return (isEnd())? rndResult.E : rndResult.T;
		}else {
			setRndWinner(p1Card, p2Card);
			return (isEnd())? rndResult.E : rndResult.W;
		}
	}//play()
	
	private void setRndWinner(Card p1Card, Card p2Card) {
		if(p1Card.getValue() > p2Card.getValue()) {
			addCardsTo(player1Cards, p1Card, p2Card);
			rndWinner = player1;
		}else {
			addCardsTo(player2Cards, p1Card, p2Card);
			rndWinner = player2;
		}//else	
	}//setRndWinner()
	
	private void fillKitty(Card c1, Card c2) {
		kittyStack.push(c1);
		kittyStack.push(c2);
		
		for(int i = 0; i < 3 && !isEnd(); i++) {
			kittyStack.push(player1Cards.poll());
			kittyStack.push(player2Cards.poll());
		}//for
	}//playWar()
	
	private boolean isEnd() {
		return player1Cards.isEmpty() || player2Cards.isEmpty();
	}//isEnd()
	
	private void addCardsTo(Queue<Card> cardQ, Card c1, Card c2) {
		cardQ.offer(c1);
		cardQ.offer(c2);
		if(tie) {
			addKittyTo(cardQ);
		}
	}//addCardsTo()
	
	private void addKittyTo(Queue<Card> cardQ) {
		while(!kittyStack.isEmpty()) {
			cardQ.offer(kittyStack.pop());
		}//while
		tie = false;
	}//addKittyTo()
}//class War
