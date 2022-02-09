package games.blackjack.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum PlayerNumber {

	DEALER (0),
	ONE (1),
	TWO (2),
	THREE(3); 
	
	private final int number;
	private PlayerNumber(int numbr) {
		this.number = numbr;
	}
	
	private static final Map<PlayerNumber, Integer> numbersOfPlayers = new HashMap<>();

	private int getNumber() {
		return number;
	}
	
	static {
		for(PlayerNumber playerNumber: PlayerNumber.values()) {
			numbersOfPlayers.put(playerNumber, playerNumber.getNumber());
		}
	}
	
	public int getNumberByPlayer(PlayerNumber enumNumber) {
		return numbersOfPlayers.get(enumNumber);
	}
	
}
