package games.blackjack.models;

import java.util.ArrayList;
import java.util.List;

public class Player {
	
	private List<Card> dealtCards = new ArrayList<>();
	private PlayerNumber enumNumber;
	
	public Player(PlayerNumber enumNumb) {
		this.enumNumber = enumNumb;
	}
	
	public PlayerNumber getEnumNumber() {
		return this.enumNumber;
	}

	public void deal(Card card) {
		dealtCards.add(card);
		Deck.getInstance().getDeckSet().remove(card);
	}
	
	public int score() {
		int score = 0;
		for(Card card: dealtCards) {
			score = score + Card.getValueOfCard(card);
		}
		
		if(score > 21) {
			for (Card card: Card.values()) {
				if(dealtCards.contains(card) && Card.getValueOfCard(card) == 11) {
					score = score - 10;
				}
				
				if(score <= 21) {
					break;
				}
			}
		}
		return score;
	}
}
