package warGame;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.Test;

class WarTest {

	@Test
	void testCase1() {
		Queue<Card> testQ = new LinkedList<Card>();
		
		String testValues[] = {"3H3", "2H2", "5H5", "5C5", "6H6", "6D6", "7H7", "8H8", "9H9", "QH12", "AH14", "AD14", "JH11", "KH13", "2D2", "3D3", "4D4", "5D5", "8D8", "7D7", "3C3", "2C2"};
		String testValues2[] = {"2H2", "3H3", "4H4", "5H5", "6H6", "7H7", "8H8", "8C8", "9H9", "JH11"};

		for(String crd : testValues) {
			testQ.offer(new Card(crd.substring(0, 1), crd.charAt(1), Integer.parseInt(crd.substring(2))));
		}//for
		
		//Upcoming test setup
		Deck d = new Deck(testQ);
		
		System.out.println(d.toString());
		
		War w = new War("p1", "p2");
		System.out.println("War constructor creates full deck by default:\n" + w.getDeck().toString());
		w.setDeck(d);//for testing
		
		//Test that names are set correctly
		assertEquals("p1", w.getP1Name(), "test: getP1Name()");
		assertEquals("p2", w.getP2Name(), "test: getP2Name()");
		
		
		//Test that cards are dealt correctly
		w.start();
		assertEquals(11, w.getP1Cards().size(), "test: player1Cards size() dealt");
		assertEquals(11, w.getP2Cards().size(), "test: player2Cards size() dealt");
		assertEquals(0, w.getDeck().size(), "test: empty Deck");
		
		//Test that the player with the highest card wins the round
		assertEquals(War.rndResult.W, w.play(), "test: w.play() W");
		assertEquals("p1", w.getRndWinner(), "test: getRndWinner()");
		assertEquals(12, w.getP1Cards().size(), "test: player1Cards size() rnd1");
		assertEquals(10, w.getP2Cards().size(), "test: player2Cards size() rnd1");
		
		//Test that play returns a tie and kitty is filled with the 8 cards
		assertEquals(War.rndResult.T, w.play(), "test: w.play() T");
		assertEquals(8, w.getKitty().size(), "test: getKitty() size, tie");
		assertEquals(8, w.getP1Cards().size(), "test: player1Cards size() first tie");
		assertEquals(6, w.getP2Cards().size(), "test: player2Cards size() first tie");
		
		//Test that if a second consecutive tie occurs the kitty accumulates the additional cards
		assertEquals(War.rndResult.T, w.play(), "test: w.play() T second tie");
		assertEquals(16, w.getKitty().size(), "test: getKitty() size, second tie");
		assertEquals(4, w.getP1Cards().size(), "test: player1Cards size() second tie");
		assertEquals(2, w.getP2Cards().size(), "test: player2Cards size() second tie");
		
		//Test that the round winner gets the full kitty 
		assertEquals(War.rndResult.W, w.play(), "test: w.play() W win kitty");
		assertTrue(w.getKitty().isEmpty(), "test: getKitty() size, after tie break");
		assertEquals("p1", w.getRndWinner(), "test: getRndWinner() after ties");
		assertEquals(21, w.getP1Cards().size(), "test: player1Cards size() win tie");
		assertEquals(1, w.getP2Cards().size(), "test: player2Cards size() lost tie");
		
		//Test that the game ends with the correct winner
		assertEquals(War.rndResult.E, w.play(), "test: w.play() E");
		assertEquals("p1", w.getWinner(), "test: getWinner()");
		assertEquals(22, w.getP1Cards().size(), "test: player1Cards size() at end game");
		assertTrue(w.getP2Cards().isEmpty(), "test: player2Cards size() at end game");
		
		//Setup for next tests
		testQ = new LinkedList<Card>();
		for(String crd : testValues2) {
			testQ.offer(new Card(crd.substring(0, 1), crd.charAt(1), Integer.parseInt(crd.substring(2))));
		}//for
		d = new Deck(testQ);
		
		System.out.println(d.toString());
		
		w = new War();
		w.setDeck(d);
		w.start();
		w.play();
		w.play();
		w.play();
		
		//Test that the game ends if a player runs out of cards during a tie war
		assertEquals(War.rndResult.E, w.play(), "test: w.play() E game end during tie war");
		assertEquals("Player 2", w.getWinner(), "test: getWinner() p1 out of cards during tie war");
	}//test

}//WarTest
