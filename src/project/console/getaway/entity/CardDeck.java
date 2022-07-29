/**
 * package containing the entities of the getaway game application.
 */
package project.console.getaway.entity;

import java.util.ArrayList;
import java.util.Collections;

/**
 * CardDeck class. This class contains all the cards in a deck.
 * 
 * @author Aqib Chattha
 * @version 0.1, 2022-27-07
 * @since JDK17.0.4
 */
public class CardDeck {
	/** The deck of cards */
	private ArrayList<Card> list;

	/**
	 * Create an instance of a CardDeck.
	 * 
	 * @param bool value that is true to create a full deck otherwise false
	 */
	public CardDeck(boolean fullDeck) {
		if (fullDeck) {
			createFullDeck();
		} else {
			list = new ArrayList<Card>();
		}
	}

	/**
	 * Create a full deck of cards by adding all the cards to the list.
	 */
	private void createFullDeck() {
		list = new ArrayList<Card>();
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 13; j++) {
				Card card = new Card(i, j);
				list.add(card);
			}
		}
		list.add(new Card(0, 0));
	}

	/**
	 * empty the deck by clearing all the cards from the list.
	 */
	public void clear() {
		list.clear();
	}

	/**
	 * shuffle the cards by shuffling the list of cards
	 */
	public void shuffle() {
		Collections.shuffle(list);
	}

	/**
	 * add a card at the end of the list
	 * 
	 * @param card a card to be added
	 */
	public void addCard(Card card) {
		if (list.size() < 52) {
			list.add(card);
		}
	}

	/**
	 * add a card to the list at the given location
	 * 
	 * @param card a card to be added
	 * @param i    location to placed
	 */
	public void addCard(int i, Card card) {
		i--;
		if (list.size() < 52 && i >= 0 && i < list.size()) {
			list.add(i, card);
		}
	}

	/**
	 * take a card from the start of the list.
	 * 
	 * @return Card card at the start of the deck
	 */
	public Card takeCard() {
		if (list.size() > 0) {
			Card card = list.get(0);
			list.remove(0);
			return card;
		}
		return null;
	}

	/**
	 * take a card from the given location of the list.
	 * 
	 * @param i the location from where the card is to be picked
	 * @return Card removed card from the given locastion if exists
	 */
	public Card takeCard(int i) {
		i--;
		if (i >= 0 && i < list.size()) {
			Card card = list.remove(i);
			return card;
		}
		return null;
	}

	/**
	 * see a card at the given location of the list.
	 * 
	 * @param i the location of the card to be seen
	 * @return Card the card at the given location if found.
	 */
	public Card seeCard(int i) {
		i--;
		if (i >= 0 && i < list.size()) {
			return list.get(i);
		}
		return null;
	}

	/**
	 * search the given card in the deck of cards.
	 * 
	 * @param suit   the suit of the card
	 * @param number the number of the card
	 * @return int the location of the given card in deck. its 0 if the card is not
	 *         found.
	 */
	public int searchCard(int suit, int number) {
		int i = 1;
		for (Card card : list) {
			if (card.getSuit() == suit && card.getNumber() == number) {
				return i;
			}
			i++;
		}
		return 0;
	}

	/**
	 * check if the given card is of the given suit.
	 * 
	 * @param suit   the suit to be checked
	 * @param number the card index in the list to be checked
	 * @return boolean true if the card is of the given suit
	 */
	public boolean verifyCardSuit(int index, int suit) {
		index--;
		if (index >= 0 && index < list.size()) {
			if (list.get(index).getSuit() == suit) {
				return true;
			}
		}
		return false;
	}

	/**
	 * check if the cards of given suit are in the deck.
	 * 
	 * @param suit the suit to be checked
	 * @return boolean true if a card of the given suit is found
	 */
	public boolean checkSuitCards(int suit) {
		for (Card card : list) {
			if (card.getSuit() == suit) {
				return true;
			}
		}
		return false;
	}

	/**
	 * checks whether the deck is empty or not.
	 * 
	 * @return boolean true if the deck is empty otherwise false
	 */
	public boolean isEmpty() {
		if (list.size() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * gets the size of the deck.
	 * 
	 * @return int the size of the deck
	 */
	public int size() {
		return list.size();
	}

	/**
	 * prints all the cards in the deck onto the console.
	 */
	public void showAllCards() {
		int i = 1;
		for (Card card : list) {
			System.out.println(i + " - " + card.toString());
			i++;
		}
	}

	/**
	 * prints all the cards of given suit in the deck onto the console.
	 * 
	 * @param suit the suit of the cards to be printed
	 */
	public void showAllCardsOfSuit(int suit) {
		int i = 1;
		for (Card card : list) {
			if (card.getSuit() == suit) {
				System.out.println(i + " - " + card.toString());
			}
			i++;
		}
	}

	/**
	 * returns all the cards of the deck i.e. the whole deck.
	 * 
	 * @return ArrayList<Card> the whole deck of cards
	 */
	public ArrayList<Card> getAllCards() {
		return list;
	}

}
