package project.console.getaway.entity.test;

import junit.framework.TestCase;
import project.console.getaway.entity.Card;

/**
 * Card Test class.
 * This class Tests the Card class.
 * 
 * @author Aqib Chattha
 * @version 0.1, 2022-27-07
 * @since JDK17.0.4
 */
public class CardTest extends TestCase {
	// An instance of the card used in all test methods
		private Card spadeA, diamond10, heartQ, clubK, spade5, diamondA, heartA, clubA, joker;

		/**
		 * Pre-processing of execution of each test method
		 */
		protected void setUp() throws Exception {
			// Create some test card instances.
			spadeA = new Card(1, 1); // Spade A
			diamond10 = new Card(2, 10); // Diamond10
			heartQ = new Card(3, 12); // HeartQ
			clubK = new Card(4, 13); // Club K

			// Make something else.
			spade5 = new Card(1, 5); // Spade 5
			diamondA = new Card(2, 1); // Diamond A
			heartA = new Card(3, 1); // HeartA
			clubA = new Card(4, 1); // Club A
			joker = new Card(0, 0); // Joker
		}

		/**
		 * Post-processing of execution of each test method
		 */
		protected void tearDown() throws Exception {
			// No post-processing
		}

		/**
		 * Test method for {@link se.t2115005.card.entity.Card#getSuit()}.
		 */
		public void testGetSuit() {
			assertEquals(1, spadeA.getSuit()); // The design of spadeA should be spade (= 0).
			assertEquals(2, diamond10.getSuit()); // The design of diamond10 should be diamond (= 1).
			assertEquals(3, heartQ.getSuit()); // The heartQ design should be heart (= 2).
			assertEquals(4, clubK.getSuit()); // The design of clubK should be club (= 3).

			assertEquals(0, joker.getSuit()); // Joker has a -1 pattern.

			// If you write like ↓, you can check the design of all the cards, but be
			// careful
			// If you don't think about the logic, you will introduce bugs in the test code.
			for (int suit = 1; suit <= 4; suit++) {// About each pattern
				for (int number = 1; number <= 13; number++) {// About each number
					Card c = new Card(suit, number); // Make a card and test getSuit ().
					assertEquals("Check pattern:", suit, c.getSuit());
				}
			}
		}

		/**
		 * Test method for {@link se.t2115005.card.entity.Card#show()}.
		 */
		public void testShow() {
			System.out.println ("○ Expected behavior:");
			System.out.println ("Diamond 10"); // Code that simulates diamond10.show ()
			System.out.println ("● Actual behavior:");
			diamond10.show (); // Actual behavior
		}
		
		/**
		 * Test method for {@link se.t2115005.card.entity.Card#getNumber()}.
		 */
		public void testGetNumber() {
			// Test getNumber ()
			assertEquals(1, spadeA.getNumber()); // The number of spadeA should be 1.
			assertEquals(10, diamond10.getNumber()); // The number in diamond10 should be 1.
			assertEquals(12, heartQ.getNumber()); // The heartQ number should be 12.
			assertEquals(13, clubK.getNumber()); // The number of clubK should be 13.

			assertEquals(0, joker.getNumber()); // The number of jokers is 0.

			// All tests. In general, not all cases can be tested as shown below.
			for (int suit = 0; suit <= 3; suit++) {// About each pattern
				for (int number = 1; number <= 13; number++) {// About each number
					Card c = new Card(suit, number); // Make a card and test getSuit ().
					assertEquals("check numbers:", number, c.getNumber());
				}
			}
		}

		/**
		 * Test method for {@link se.t2115005.card.entity.Card#toIndex()}.
		 */
		public void testToIndex() {
			// Check the integer index representation for each instance.
			assertEquals(0, spadeA.toIndex());
			assertEquals(22, diamond10.toIndex());
			assertEquals(37, heartQ.toIndex());
			assertEquals(51, clubK.toIndex());
			assertEquals(4, spade5.toIndex());
			assertEquals(13, diamondA.toIndex());
			assertEquals(26, heartA.toIndex());
			assertEquals(39, clubA.toIndex());
			assertEquals(-1, joker.toIndex());
		}

		/**
		 * Test method for {@link se.t2115005.card.entity.Card#toString()}.
		 */
		public void testToString() {
			// Check the string representation for each instance.
			assertEquals("Spade A", spadeA.toString());
			assertEquals("Diamond 10", diamond10.toString());
			assertEquals("Heart Q", heartQ.toString());
			assertEquals("Club K", clubK.toString());
			assertEquals("Spade 5", spade5.toString());
			assertEquals("Diamond A", diamondA.toString());
			assertEquals("Heart A", heartA.toString());
			assertEquals("Club A", clubA.toString());
			assertEquals("joker", joker.toString());
		}

		/**
		 * Test method for {@link se.t2115005.card.entity.Card#getIndex(int, int)}.
		 */
		public void testGetIndex() {
			// Check some index representations.

			assertEquals(0, Card.getIndex(1, 1)); // Index of spade A
			assertEquals(22, Card.getIndex(2, 10)); // Index of diamond 10
			assertEquals(37, Card.getIndex(3, 12)); // Heart Q index
			assertEquals(51, Card.getIndex(4, 13)); // Club K index
			assertEquals(-1, Card.getIndex(0, 0)); // Joker index
		}

		/**
		 * Test method for {@link se.t2115005.card.entity.Card#getString(int, int)}.
		 */
		public void testGetString() {
			assertEquals("Spade A", Card.getString(1, 1)); // Index of Spade A
			assertEquals("Diamond 10", Card.getString(2, 10)); // Index of Diamond 10
			assertEquals("Heart Q", Card.getString(3, 12)); // Index of Heart Q
			assertEquals("Club K", Card.getString(4, 13)); // Club K index
			assertEquals("joker", Card.getString(0, 0)); // Joker index
		}
}
