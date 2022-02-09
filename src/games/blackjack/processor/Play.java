package games.blackjack.processor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import games.blackjack.models.Card;
import games.blackjack.models.Deck;
import games.blackjack.models.Player;
import games.blackjack.models.PlayerNumber;

public class Play {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Deck deck = Deck.getInstance();
		
		PlayerNumber one = PlayerNumber.ONE;
		PlayerNumber two = PlayerNumber.TWO;
		PlayerNumber three = PlayerNumber.THREE; 
		PlayerNumber deal = PlayerNumber.DEALER;
		
		Player play1 = new Player(one);
		Player play2 = new Player(two);
		Player play3 = new Player(three);
		Player dealer = new Player(deal);
		
		deck.shaffle();
			System.out.println("Number of cards at the beginning: " + deck.getDeckSet().size());
		
			Card[] cards = deck.getDeckSet().toArray(new Card[0]);
			System.out.println("Card at the top of the array is: " + cards[0]);
			
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String ask = reader.readLine();
		System.out.println(ask);
		
		if(ask.contains("deal")) {
			//first round
			dealForPlayer(deck, play1);
			dealForPlayer(deck, play2);
			dealForPlayer(deck, play3);
			dealForPlayer(deck, dealer);
			
			//second round 
			dealForPlayer(deck, play1);
			dealForPlayer(deck, play2);
			dealForPlayer(deck, play3);
			dealForPlayer(deck, dealer);
			
			//Finishing player One
			System.out.println("<Player One>, Hit or Stand?");
			ask = reader.readLine();
			if(ask.equalsIgnoreCase("stand")) {
				System.out.println("<Player One>, is standing with the score is: "+ play1.score());
			}
			else if (ask.equalsIgnoreCase("Hit")) {
				
				while (play1.score() < 21 && ask.equalsIgnoreCase("Hit")) {
					dealForPlayer(deck, play1);
					System.out.println("<Player One>, your score is: "+ play1.score() + ". Hit or Stand?");
					//Here we can implement strategy for <Player One> depending on his current score
					ask = reader.readLine();
				}
				if(play1.score() <= 21) {
					System.out.println("<Player One>, is standing with the score is: "+ play1.score());
				} else {
					System.out.println("<Player One>, you are busted with the score: "+ play1.score());
				}
			}
			
			//Finishing player two
			System.out.println("<Player Two>, Hit or Stand?");
			ask = reader.readLine();
			if(ask.equalsIgnoreCase("stand")) {
				System.out.println("<Player Two>, is standing with the score is: "+ play2.score());
			}
			else if (ask.equalsIgnoreCase("Hit")) {
				
				while (play2.score() < 21 && ask.equalsIgnoreCase("Hit")) {
					dealForPlayer(deck, play2);
					System.out.println("<Player Two>, your score is: "+ play2.score() + ". Hit or Stand?");
					//Here we can implement strategy for <Player Two> depending on his current score
					ask = reader.readLine();
				}
				
				if(play2.score() <= 21) {
					System.out.println("<Player Two>, is standing with the score is: "+ play2.score());
				} else {
					System.out.println("<Player Two>, you are busted with the score: "+ play2.score());
				}
			}
			
			//Finishing player three
			System.out.println("<Player Three>, Hit or Stand?");
			ask = reader.readLine();
			if(ask.equalsIgnoreCase("stand")) {
				System.out.println("<Player Three>, is standing with the score is: "+ play3.score());
			}
			else if (ask.equalsIgnoreCase("Hit")) {
				
				while (play3.score() < 21 && ask.equalsIgnoreCase("Hit")) {
					dealForPlayer(deck, play3);
					System.out.println("<Player Three>, your score is: "+ play3.score() + ". Hit or Stand?");
					//Here we can implement strategy for <Player Three> depending on his current score
					ask = reader.readLine();
				}
				
				if(play3.score() <= 21) {
					System.out.println("<Player Three>, is standing with the score is: "+ play3.score());
				} else {
					System.out.println("<Player Three>, you are busted with the score: "+ play3.score());
				}
			}
			
			//Finishing dealer
			//Here we can implement different strategies for dealer depending of initial Score
			System.out.println("Dealer is going to Hit");
			dealForPlayer(deck, dealer);
			//Hear also we can implement some strategy depending on dealers' current scores.
			System.out.println("Dealer is going to Stand");
			
			//determining the winners
			if(play1 == determinWinner(play1, dealer)) {
				System.out.println("<Player One>, you won");
			}
			else if(dealer == determinWinner(play1, dealer)) {
				System.out.println("<Player One>, dealer  won");
			}
			
			if(play2 == determinWinner(play2, dealer)) {
				System.out.println("<Player Two>, you won");
			}
			else if(dealer == determinWinner(play2, dealer)) {
				System.out.println("<Player Two>, dealer  won");
			}
			
			if(play3 == determinWinner(play3, dealer)) {
				System.out.println("<Player Three>, you won");
			}
			else if(dealer == determinWinner(play3, dealer)) {
				System.out.println("<Player Three>, dealer  won");
			}
			
			
			
		}
		 
	}
	
	public static Player determinWinner(Player one, Player two) {
		int a = one.score();
		int b = two.score();
		
		//One of strategies is that, if both players are busted we don't show that dealer busted
		if(a > 21) {
			//System.out.println("Player busted");
			return two; 
		}
		else  {
			
			if( b > 21) {
				//System.out.println("Player won");
				return one;
			}
			//Another strategies is that, if both players scored 21 only dealer wins
			else if (b == 21) {
				//System.out.println("Dealer won");
				return two;
			}
			//Another strategies is that, if both players scores draw only dealer wins
			else if (b >= a) {
				//System.out.println("Dealer won");
				return two;
			}
			else {
				//System.out.println("Player won");
				return one;				
			}
		}
	}
	
	public static void dealForPlayer(Deck deck, Player player) {
		Card[] cards = deck.getDeckSet().toArray(new Card[0]);
		System.out.println("Number of cards at the beginning array: " + cards.length);
		System.out.println("Card at the top of the array is: " + cards[0]);
		player.deal(cards[0]);
	}

}
