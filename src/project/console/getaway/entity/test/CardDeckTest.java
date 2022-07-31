package project.console.getaway.entity.test;

import java.util.ArrayList;
import junit.framework.TestCase;
import project.console.getaway.entity.Card;
import project.console.getaway.entity.CardDeck;


/**
 * Card Deck Test class. This class Tests the CardDeck class.
 * 
 * @author Aqib Chattha
 * @version 0.1, 2022-27-07
 * @since JDK17.0.4
 */
public class CardDeckTest extends TestCase {

	// the deck of cards used to test the CardDeck class
	private CardDeck deck;

	protected void setUp() throws Exception {
		deck = new CardDeck(false);
		deck.addCard(new Card(0, 0)); // Add joker card to the deck
		deck.addCard(new Card(1, 1)); // Add Spade A card to the deck
		deck.addCard(new Card(2, 11)); // Add Diamond J card to the deck
		deck.addCard(new Card(3, 12)); // Add Heart Q card to the deck
		deck.addCard(new Card(4, 13)); // Add Club K card to the deck
	}

	protected void tearDown() throws Exception {
		// No post-processing
	}

	/**
	 * Test method for {@link se.t2115005.card.entity.CardDeck#createFullDeck()}.
	 */
	public void testCreateFullDeck() {
		assertEquals(5, deck.size()); // The initial size of the deck is 5
		deck.clear(); // clear the deck of all cards
		assertEquals(0, deck.size()); // Now the deck size is 0
		deck.createFullDeck(); // Create a full deck of cards
		assertEquals(53, deck.size()); // Now the size of the deck is 53. 52 cards and 1 joker.
	}

	/**
	 * Test method for {@link se.t2115005.card.entity.CardDeck#clear()}.
	 */
	public void testClear() {
		deck.clear();
		assertEquals(0, deck.size());
	}

	/**
	 * Test method for {@link se.t2115005.card.entity.CardDeck#shuffle()}.
	 */
	public void testShuffle() {
		System.out.println();
		System.out.println("○ TestCase shuffle()");
		System.out.println("○ Before shuffling the deck:");
		deck.showAllCards(); // Display the current order of the cards
		deck.shuffle(); // shuffle the cards
		System.out.println("● After shuffling the deck:");
		deck.showAllCards(); // Display the shuffled order of the cards
	}

	/**
	 * Test method for
	 * {@link se.t2115005.card.entity.CardDeck#addCard(se.t2115005.card.entity.Card)}.
	 */
	public void testAddCard() {
		System.out.println();
		System.out.println("○ TestCase addCard(Card card)");
		System.out.println("○ Expected Output:");
		System.out.println("1 - joker\r\n" + "2 - Spade A\r\n" + "3 - Diamond J\r\n" + "4 - Heart Q\r\n" + "5 - Club K"); // Display the current cards in the deck
		System.out.println("6 - Heart 3"); // the heart 3 card to be added
		deck.addCard(new Card(3, 3));
		System.out.println("● Actual Output:");
		deck.showAllCards(); // Display the current cards in the deck
	}

	/**
	 * Test method for
	 * {@link se.t2115005.card.entity.CardDeck#addCard(int, se.t2115005.card.entity.Card)}.
	 */
	public void testAddCardAtIndex() {
		System.out.println();
		System.out.println("○ TestCase addCard(int i, Card card)");
		System.out.println("○ Expected Output:");
		System.out.println("1 - joker\r\n" + "2 - Heart 3\r\n" + "3 - Spade A\r\n" + "4 - Diamond J\r\n" + "5 - Heart Q\r\n" + "6 - Club K"); // Display
																														// the
																														// expected
																														// output
		deck.addCard(2, new Card(3, 3));
		System.out.println("● Actual Output:");
		deck.showAllCards(); // Display the current cards in the deck
	}

	/**
	 * Test method for {@link se.t2115005.card.entity.CardDeck#takeCard()}.
	 */
	public void testTakeCard() {
		Card card = deck.takeCard(); // take the card at 1st place in the deck
		assertEquals(4, deck.size()); // Now the card is taken so size of the deck reduces to 4
		assertEquals(0, card.getSuit()); // Check the suit of the card is -1
		assertEquals(0, card.getNumber()); // Check the number of the card is 0
	}

	/**
	 * Test method for {@link se.t2115005.card.entity.CardDeck#takeCard(int)}.
	 */
	public void testTakeCardAtIndex() {
		Card card = deck.takeCard(2); // take the card at 2nd place in the deck
		assertEquals(4, deck.size()); // Now the card is taken so size of the deck reduces to 4
		assertEquals(1, card.getSuit()); // Check the suit of the card is 0
		assertEquals(1, card.getNumber()); // Check the number of the card is 1
	}

	/**
	 * Test method for {@link se.t2115005.card.entity.CardDeck#seeCard(int)}.
	 */
	public void testSeeCard() {
		Card card = deck.seeCard(2); // get the card at 2nd place in the deck
		assertEquals(5, deck.size()); // Now the card is not taken so size of the deck remains 5
		assertEquals(1, card.getSuit()); // Check the suit of the card is 0
		assertEquals(1, card.getNumber()); // Check the number of the card is 1
	}

	/**
	 * Test method for
	 * {@link se.t2115005.card.entity.CardDeck#verifyCardSuit(int, int)}.
	 */
	public void testVerifyCardSuit() {
		assertEquals(true, deck.verifyCardSuit(2, 1)); // It is true because the 2nd card in the deck is of spade suit
	}

	/**
	 * Test method for
	 * {@link se.t2115005.card.entity.CardDeck#checkSuitCards(int)}.
	 */
	public void testCheckSuitCards() {
		assertEquals(true, deck.checkSuitCards(1)); // It is true because spade card is present in the deck
	}

	/**
	 * Test method for
	 * {@link se.t2115005.card.entity.CardDeck#searchCard(int, int)}.
	 */
	public void testSearchCard() {
		assertEquals(2, deck.searchCard(1, 1)); // The Spade A is the 2nd card of the deck
	}

	/**
	 * Test method for {@link se.t2115005.card.entity.CardDeck#isEmpty()}.
	 */
	public void testIsEmpty() {
		deck.clear(); // Empty the deck
		assertEquals(true, deck.isEmpty()); // The deck is empty
	}

	/**
	 * Test method for {@link se.t2115005.card.entity.CardDeck#size()}.
	 */
	public void testSize() {
		assertEquals(5, deck.size()); // The size of the deck
	}

	/**
	 * Test method for {@link se.t2115005.card.entity.CardDeck#showAllCards()}.
	 */
	public void testShowAllCards() {
		System.out.println();
		System.out.println("○ TestCase showAllCards()");
		System.out.println("○ Expected Output:");
		System.out.println("1 - joker\r\n" + "2 - Spade A\r\n" + "3 - Diamond J\r\n" + "4 - Heart Q\r\n" + "5 - Club K");
		System.out.println("● Actual Output:");
		deck.showAllCards(); // display all the cards on the console
	}

	/**
	 * Test method for {@link se.t2115005.card.entity.CardDeck#showAllCardsOfSuit()}.
	 */
	public void testShowAllCardsOfSuit() {
		System.out.println();
		System.out.println("○ TestCase showAllCardsOfSuit(int suit)");
		System.out.println("○ Expected Output:");
		System.out.println("2 - Spade A");
		System.out.println("● Actual Output:");
		deck.showAllCardsOfSuit(1); // display all the cards on the console
	}

	/**
	 * Test method for {@link se.t2115005.card.entity.CardDeck#getAllCards()}.
	 */
	public void testGetAllCards() {
		ArrayList<Card> cards = deck.getAllCards();
		assertEquals(cards, deck.getAllCards()); // the card array return is the same
		assertEquals(5, cards.size()); // has the same number of cards
	}

}
