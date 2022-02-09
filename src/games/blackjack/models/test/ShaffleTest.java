package games.blackjack.models.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import games.blackjack.models.Card;
import games.blackjack.models.Deck;

class ShaffleTest {

	static Deck deck;
	static Card[] cards;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		deck = Deck.getInstance();
		System.out.println("Number of cards at the beginning: " + deck.getDeckSet().size());
	
		cards = deck.getDeckSet().toArray(new Card[0]);
		System.out.println("Card at the top of the array is: " + cards[0]);
	}

	@Ignore
	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	void deckShaffleTest() {
		deck.shaffle();
		cards = deck.getDeckSet().toArray(new Card[0]);
		System.out.println("Card at the top of the array is: " + cards[0]);
		
		deck.shaffle();
		cards = deck.getDeckSet().toArray(new Card[0]);
		System.out.println("Card at the top of the array is: " + cards[0]);
	}

}
