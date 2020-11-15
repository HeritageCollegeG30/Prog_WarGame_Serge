package warGame;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CardTest {

	@Test
	void testCase1() {
		Card c = new Card("7", 'D', 7);
		
		assertEquals("7", c.getRank(), "testcase1: getRank()");
		assertEquals('D', c.getSuit(), "testcase1: getSuit()");
		assertEquals(7, c.getValue(), "testcase1: getValue()");
	}

}
