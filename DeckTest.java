package warGame;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DeckTest {

	@Test
	void test() {
		Deck d = new Deck();
		System.out.print("unshuffled ");
		System.out.println(d.toString());
		
		d.shuffle();
		
		System.out.print("\nshuffled ");
		System.out.println(d.toString());
	}
	
	@Test
	void testCase1() {
		Deck d = new Deck();
		
		assertEquals("2H", d.deal().toString(), "testCase1 deal H2");
		assertEquals("3H", d.deal().toString(), "testCase1 deal H3");
		assertEquals("4H", d.deal().toString(), "testCase1 deal H4");
		assertEquals("5H", d.deal().toString(), "testCase1 deal H5");
		assertEquals(48, d.size(), "testCase1 size()");
	}

}
