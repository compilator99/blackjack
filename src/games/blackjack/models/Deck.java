package games.blackjack.models;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Deck {
	private final Card[] allCards = new Card[52];
	private static List<Card> deckSet = new ArrayList<>();
	private static Deck deck = new Deck();
	
	private Deck() {
		int n = 0;
		for(Card card: Card.values()) {
			allCards[n] = card;
			n += 1;
			
			deckSet.add(card);
		}
	}
	
	public static Deck getInstance() {
		if (deck == null) {
			deck = new Deck();
		}
		return deck;
	}
	
	public void shaffle() {
		deckSet = new ArrayList<>();
		List<Integer> indexes = new ArrayList<>();
		for(int i=0; i < 52; i++) {
			indexes.add(i);
		}
		Random rand = new Random(); 
		
		while(indexes.size() > 0) {
			int indexOfindexes = rand.nextInt(indexes.size());
			int index = indexes.get(indexOfindexes);
			deckSet.add(allCards[index]);
			indexes.remove(indexOfindexes);
		}
	}
	
	public List<Card> getDeckSet() {
		return deckSet;
	}
}
