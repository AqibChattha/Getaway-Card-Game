/**
 * package containing the entities of the getaway game application.
 */
package project.console.getaway.entity;

/**
 * [Object class] Card class. An object class that represents "cards". It has
 * the attributes suit and number. It also has many methods to manipulate the
 * cards as in real game.
 * 
 * @author Aqib Chattha
 * @version 0.1, 2022-27-07
 * @since JDK17.0.4
 */
public class Card {
	/**
	 * Card suit can be in range 0-4. The suits are namely 1=Spade, 2=Diamond,
	 * 3=Heart and 4=Club. The special card "The joker" has no suit and 0=joker.
	 */
	private int suit;
	/**
	 * Card number can be from 1-13 of every suit or 0 for joker card.
	 * 2-10=numbered, 11=jack, 12=queen, 13=king and 1=ace.
	 */
	private int number;

	/**
	 * Create an instance of a Card by specifying the card suit, and number. If the
	 * card suit and number are wrong then the joker card will be made by default.
	 * 
	 * @param suit   can be in range 0-4. The suits are namely 1=Spade, 2=Diamond,
	 *               3=Heart and 4=Club. The special card "The joker" has no suit
	 *               and 0=joker.
	 * @param number can be from 1-13 of every suit or 0 for joker card. 2-10 are
	 *               the numbered cards, 11 is the jack (J), 12 is the queen (Q), 13
	 *               is the king (K) and 1 represents the Ace card (A). The card
	 *               priority is from left being lowest to the right being the
	 *               highest (2,3,4,5,6,7,8,9,10,J,Q,K,A). The "Ace of Spades" has
	 *               the highest value in whole deck and even the game starts with
	 *               it being the first card thrown. Also the joker card has no use
	 *               in this game.
	 */
	public Card(int suit, int number) {
		if (suit >= 0 && suit <= 4 && number >= 0 && number <= 13) {
			this.suit = suit;
			this.number = number;
		} else {
			this.suit = 0;
			this.number = 0;
		}
	}

	/**
	 * get the suit of the card
	 * 
	 * @return the suit of the card
	 */
	public int getSuit() {
		return suit;
	}

	/**
	 * get the card number
	 * 
	 * @return the number of the card
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * convert the card into a index place in the deck from 0-51 with -1 being the
	 * joker
	 * 
	 * @return the index of the card in the deck
	 */
	public int toIndex() {
		return getIndex(this.suit, this.number);
	}

	/**
	 * get the String representation of the card
	 * 
	 * @return the string representing the card
	 */
	public String toString() {
		return getString(this.suit, this.number);
	}

	/**
	 * Show the String representation of the card onto the console.
	 */
	public void show() {
		System.out.println(this.toString());
	}

	/**
	 * [Static method] get the index of the card in deck by given suit and number.
	 * 
	 * @param suit   of the card
	 * @param number of the card
	 * 
	 * @return the index of the card in the deck from 0-51 with -1 being the joker.
	 */
	public static int getIndex(int suit, int number) {
		if (suit == 1) {
			return (number - 1);
		} else if (suit == 2) {
			return (12 + number);
		} else if (suit == 3) {
			return (25 + number);
		} else if (suit == 4) {
			return (38 + number);
		}
		return -1;
	}

	/**
	 * [Static method] get the String representation of the card with given suit and
	 * number.
	 * 
	 * @param suit   of the card
	 * @param number of the card
	 * @return the string representing the card
	 */
	public static String getString(int suit, int number) {
		String outputString = "";
		if (suit == 1) {
			outputString = "Spade ";
		} else if (suit == 2) {
			outputString = "Diamond ";
		} else if (suit == 3) {
			outputString = "Heart ";
		} else if (suit == 4) {
			outputString = "Club ";
		} else {
			return "joker";
		}
		if (number == 1) {
			outputString += "A";
		} else if (number == 11) {
			outputString += "J";
		} else if (number == 12) {
			outputString += "Q";
		} else if (number == 13) {
			outputString += "K";
		} else {
			outputString += number;
		}
		return outputString;
	}
}
