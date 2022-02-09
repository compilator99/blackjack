package games.blackjack.models.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import games.blackjack.models.Player;
import games.blackjack.models.PlayerNumber;
import games.blackjack.models.Card;
import games.blackjack.models.Deck;

class PlayerTest {
	
	Deck deck;
	Player player;
	
	@Before
	public void createPlayers() {
		//deck = Deck.getInstance();
		
		//PlayerNumber one = PlayerNumber.ONE;
		//player = new Player(one);
	}
	

	@Ignore
	@Test
	void testScore() {
		fail("Not yet implemented");
	}
	
	@Test 
	void testPlayer() {
		
		deck = Deck.getInstance();
		PlayerNumber one = PlayerNumber.ONE;
		player = new Player(one);
		
		
		deck.shaffle();
			System.out.println("Number of cards at the beginning: " + deck.getDeckSet().size());
		
		Card[] cards = deck.getDeckSet().toArray(new Card[0]);
		System.out.println("Number of cards at the beginning array: " + cards.length);
		System.out.println("Card at the top of the array is: " + cards[0]);
		player.deal(cards[0]);
		System.out.println("Number of cards in the deck after 1st deal: " + deck.getDeckSet().size());
		
		cards = deck.getDeckSet().toArray(new Card[0]);
		System.out.println("Card at the top of the array is: " + cards[0]);
		player.deal(cards[0]);
		System.out.println("Number of cards in the deck after 2nd deal: " + deck.getDeckSet().size());
		
		int scr = player.score();
		
		System.out.println("The final score is: " + scr);
	}

}
