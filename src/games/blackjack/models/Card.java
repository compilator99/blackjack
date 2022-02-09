package games.blackjack.models;

import java.util.*;
import java.lang.System.*;



public enum Card {

	TWO_HEART(2,"Heart","No-face"),
	TWO_SPADE(2,"Spade","No-face"),
	TWO_DIAMOND(2,"Diamond","No-face"),
	TWO_CLUB(2,"Club","No-face"),
	
	THREE_HEART(3,"Heart","No-face"),
	THREE_SPADE(3,"Spade","No-face"),
	THREE_DIAMOND(3,"Diamond","No-face"),
	THREE_CLUB(3,"Club","No-face"),
	
	FOUR_HEART(4,"Heart","No-face"),
	FOUR_SPADE(4,"Spade","No-face"),
	FOUR_DIAMOND(4,"Diamond","No-face"),
	FOUR_CLUB(4,"Club","No-face"),	
	
	FIVE_HEART(5,"Heart","No-face"),
	FIVE_SPADE(5,"Spade","No-face"),
	FIVE_DIAMOND(5,"Diamond","No-face"),
	FIVE_CLUB(5,"Club","No-face"),

	SIX_HEART(6,"Heart","No-face"),
	SIX_SPADE(6,"Spade","No-face"),
	SIX_DIAMOND(6,"Diamond","No-face"),
	SIX_CLUB(6,"Club","No-face"),	
	
	SEVEN_HEART(7,"Heart","No-face"),
	SEVEN_SPADE(7,"Spade","No-face"),
	SEVEN_DIAMOND(7,"Diamond","No-face"),
	SEVEN_CLUB(7,"Club","No-face"),
	
	EIGHT_HEART(8,"Heart","No-face"),
	EIGHT_SPADE(8,"Spade","No-face"),
	EIGHT_DIAMOND(8,"Diamond","No-face"),
	EIGHT_CLUB(8,"Club","No-face"),	
	
	NINE_HEART(9,"Heart","No-face"),
	NINE_SPADE(9,"Spade","No-face"),
	NINE_DIAMOND(9,"Diamond","No-face"),
	NINE_CLUB(9,"Club","No-face"),	
	
	TEN_HEART(10,"Heart","No-face"),
	TEN_SPADE(10,"Spade","No-face"),
	TEN_DIAMOND(10,"Diamond","No-face"),
	TEN_CLUB(10,"Club","No-face"),	
	
	JACK_HEART(10,"Heart","jack"),
	JACK_SPADE(10,"Spade","jack"),
	JACK_DIAMOND(10,"Diamond","jack"),
	JACK_CLUB(10,"Club","jack"),
	
	QUEEN_HEART(10,"Heart","queen"),
	QUEEN_SPADE(10,"Spade","queen"),
	QUEEN_DIAMOND(10,"Diamond","queen"),
	QUEEN_CLUB(10,"Club","queen"),
	
	KING_HEART(10,"Heart","king"),
	KING_SPADE(10,"Spade","kind"),
	KING_DIAMOND(10,"Diamond","king"),
	KING_CLUB(10,"Club","king"),
	
	ACE_HEART(11,"Heart","ace"),
	ACE_SPADE(11,"Spade","ace"),
	ACE_DIAMOND(11,"Diamond","ace"),
	ACE_CLUB(11,"Club","ace");
	
	private final int value;
	private final String symbol;
	private final String picture;
	
	private Card(int value, String symbol, String picture) {
		this.value = value;
		this.symbol = symbol;
		this.picture = picture;
	}
	
	private int getValue() {
		return this.value;
	}
	private String getSymbol() {
		return this.symbol;
	}
	private String getPicture() {
		return this.picture;
	}
	
	private static final Map<Card, Integer> valuesOfCards = new HashMap<>();
	
	static {
		
		for(Card card : values()) {
			valuesOfCards.put(card, card.getValue());
		}
	}
	
	public static int getValueOfCard(Card card) {
		return valuesOfCards.get(card);
	}
	
}
