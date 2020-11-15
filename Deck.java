package warGame;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Deck {
	private Queue<Card> cardsQueue;
	private final String RANKS[] = {"2", "3", "4", "5" , "6", "7" , "8", "9", "10", "J", "Q", "K", "A"};
	private final char SUITS[] = {'H', 'D'};//, 'S', 'C'};
	
	public Deck() {
		cardsQueue = new LinkedList<Card>();
		int value = 2;
		
		for(char suit : SUITS) {
			for(String rank : RANKS) {
				cardsQueue.offer(new Card(rank, suit, value++));
			}
			value = 2;
		}
	}//Deck()
	
	public Deck(Queue<Card> inCardQ) {
		cardsQueue = inCardQ;
	}//Deck(Queue)
	
	public void shuffle() {
		ArrayList<Card> tempCards = new ArrayList<Card>();
		int index;
		
		while(!cardsQueue.isEmpty()) {
			tempCards.add(cardsQueue.poll());
		}
		
		//Replace cards in cardsQueue in the random order
		index = 0;
		while(!tempCards.isEmpty()) {
			index = (int)Math.round(Math.random() * (tempCards.size()-1));
			cardsQueue.offer(tempCards.remove(index));
		}
	}//shuffle()
	
	public Queue<Card> shuffle(Queue<Card> cardQ) {
		ArrayList<Card> tempCards = new ArrayList<Card>();
		int index;
		
		while(!cardQ.isEmpty()) {
			tempCards.add(cardQ.poll());
		}
		
		//Replace cards in cardsQueue in the random order
		index = 0;
		while(!tempCards.isEmpty()) {
			index = (int)Math.round(Math.random() * (tempCards.size()-1));
			cardQ.offer(tempCards.remove(index));
		}
		return cardQ;
	}//shuffle()
	
	public Card deal() {
		return cardsQueue.poll();
	}//deal() 
	
	public int size() {
		return cardsQueue.size();
	}//size()
	
	public String toString() {
		String cards = "Card deck:\n";
		int count = 0;
		
		for(Card card : cardsQueue) {
			cards += "[" + card.toString() + "(" + card.getValue() + ")] ";
			if(count++ == 12) {
				cards += "\n";
				count = 0;
			}
		}//for
		return cards;
	}//toString()
}//class Deck
