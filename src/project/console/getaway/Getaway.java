/**
 * Getaway card game class. 
 */
package project.console.getaway;

import project.console.getaway.entity.*;
import project.console.input.Keyboard;

/**
 * @author Aqib Chattha
 * @version 0.1, 2022-27-07
 * @since JDK17.0.4
 */
public class Getaway {
	/** Getaway game rounds after every round the table is cleared */
	private static int round;
	/** The player from whom the round starts in clockwise direction */
	private static int openingPlayer;
	/**
	 * Array of previous round cards to calculate the largest card and giving
	 * thulla's
	 */
	private static Card[] prevRoundCards;
	/** As long as it is true the game will not stop */
	private static boolean gameLoop;

	/*
	 * Load the game and take the input from the user through a menu.
	 */
	public static void loadGame() {
		int input = -1;
		do {
			displayGameMenu();
			input = Keyboard.inputNumber();

			switch (input) {

			case 1:
				startGame();
				break;

			case 2:
				displayGameRules();
				break;

			default:
				System.out.println("invalid input, please try again.");
				break;
			}
		} while (input != 0);
	}

	/**
	 * display the main menu on the console.
	 */
	private static void displayGameMenu() {
		System.out.println();
		System.out.println("\t\t------------[Getaway Game Menu]------------\r\n\n" + "1 - Start the game.\n"
				+ "2 - Help.\n" + "0 - Exit.");
	}

	/**
	 * display the game rules on the console.
	 */
	private static void displayGameRules() {
		System.out.println("====[Players and Cards]====\n"
				+ "Getaway is played  with a standard  52-card pack without  jokers. In each  suit the\n"
				+ "cards rank from high to low A K Q J 10 9 8 7 6 5 4 3 2.\n" + "\n"
				+ "At least 3 players  are needed for the game  to be interesting, and  up to around 8\n"
				+ "people can play. Deal and play are clockwise.\n" + "\n" + "----[Deal]----\n"
				+ "Any player may deal. The cards are shuffled and dealt out as equally as possible to\n"
				+ "the players - some  players may have  one more card than  others. The players  each\n"
				+ "pick up their cards and look at them, without showing them to any other player.\n" + "\n"
				+ "To even out any advantage  or disadvantage of starting with  more or fewer cards, I\n"
				+ "recommend that the players take turns to deal.\n" + "\n" + "=======[Play]=======\n" + "\n"
				+ "----[First trick]----\n"
				+ "The player who holds the Ace  of Spades begins by playing  it face up on the table,\n"
				+ "and each of the other players must also  play a card face up. For convenience, this\n"
				+ "may  be done  in  clockwise  order, but  in  this first  trick  it is not  strictly\n"
				+ "necessary for players to wait for their turn before playing. Those players who have\n"
				+ "a spade must play a  spade of their choice;  those who have no spades  may play any\n"
				+ "card they wish. When everyone has played one card, these cards are gathered and set\n"
				+ "aside face down, beginning  a waste pile. The player  who had the Ace of Spades now\n"
				+ "begins the second trick  by playing any one  of his her remaining  cards face up on\n"
				+ "the table.\n" + "\n" + "----[Second and subsequent tricks]----\n"
				+ "Each trick is begun by the  player of the highest card in the suit  that was led to\n"
				+ "the previous trick: this  player is said to \"have the power\". The player  leads any\n"
				+ "card, placing it face up on the  table. Then the other players, in clockwise order,\n"
				+ "must if possible  play a card of the  same suit as the  card that was  led. If they\n"
				+ "have several cards  of the suit they have a  free choice which  of them to  play. A\n"
				+ "player who has no card of the suit led  may play any card. This card of a different\n"
				+ "suit, sometimes  known as a 'tochoo' or  a 'thulla', and it ends  the play  to that\n"
				+ "trick. Subsequent players, to the left of the one who played the tochoo, do not get\n"
				+ "to play a card.\n" + "\n"
				+ "If everyone plays a card of the same suit as the card led by the first player, then\n"
				+ "when all have played one card, these  cards are gathered and added face down to the\n"
				+ "waste pile.\n"
				+ "If someone was unable to  follow suit and played a  tochoo, then whoever played the\n"
				+ "highest card of the  suit that was led  picks up all the cards  played to the trick\n"
				+ "and adds them to their hand.\n"
				+ "In either case, the player who played the highest card of the suit that was led now\n"
				+ "\"has the power\" and begins the next trick by leading any card from hand.\n" + "\n"
				+ "Example of the beginning of a game between North, East, South and West.\n" + "\n"
				+ "First trick: West  has the Ace of  Spades and plays  it, North plays  spadeJ, East,\n"
				+ "having no spades, plays  heartA , South plays spade10. These  four cards are placed\n"
				+ "face down on  the waste pile and since  West played the highest  spade it is West's\n"
				+ "turn to start the next  trick. Note that the cards  from the first trick are always\n"
				+ "thrown on the waste, even if someone is unable to follow suit.\n"
				+ "Second trick: West  plays heart5, North  heart9, East  heartQ, South  heartJ. These\n"
				+ "four cards are thrown on the waste, and  East, who played the highest heart, starts\n"
				+ "the next trick.\n"
				+ "Third trick: East plays heart3, South heart7, West heartK, North heart8. These four\n"
				+ "cards are thrown away and West plays next.\n"
				+ "Fourth trick: West plays heart2, North  plays heart6, East, who has no more hearts,\n"
				+ "plays clubK. This  tochoo ends the  trick - South does not  get a turn to play. The\n"
				+ "first card  was a heart, and  the highest heart  was played by  North, so the three\n"
				+ "cards of this trick are added  to North's hand and North  plays next. North now has\n"
				+ "12 cards, East 9, South 10 and West 9.\n"
				+ "Fifth trick: North  plays diamondQ, East  diamondJ, South  diamondA, West diamondK,\n"
				+ "these cards are thrown away and South plays next.\n"
				+ "Sixth trick: South  plays diamond5,  West, having no more  diamonds, plays  spadeK.\n"
				+ "North and East do not get a  turn. Since no other  player played a card of the suit\n"
				+ "that  South led,  South's  diamond5 remains the  highest card of  that suit  in the\n"
				+ "trick, and South must pick up the two cards and lead again. South now has 10 cards,\n"
				+ " West 7, North 11 and East 8.\n" + "\n" + "----[Notes:]----\n" + "\n"
				+ "In the first trick, everyone plays one  card, even if some player has no spades and\n"
				+ "therefore throws a card of  another suit, and this first  trick is always thrown on\n"
				+ "the waste pile.\n"
				+ "In the second and subsequent tricks, play must stop if there is a tochoo. If anyone\n"
				+ "else makes the mistake of playing to the  trick after the tochoo, then as a penalty\n"
				+ "they have to pick up all the cards in  the trick and lead next. The same penalty is\n"
				+ "applied for other mistakes, such as playing out of turn or wrongly playing a tochoo\n"
				+ "when in fact holding a card of the suit that was led (played first).\n" + "\n"
				+ "----[Getting away]----\n"
				+ "As the  game  continues,  since not  everyone  plays to  every  trick  and  players\n"
				+ "sometimes have  to pick up cards, the  players will run  out of cards at  different\n"
				+ "times. Players  who run  out of cards  have \"got away\": they  take no more  part in\n"
				+ "the play and  are therefore  safe from losing. However,  it is not  possible to get\n"
				+ "away  if you \"have the  power\". If  your last card  is the  highest in  a trick  in\n"
				+ "which everyone is  able to follow  suit, then it is  your turn to lead  to the next\n"
				+ "trick but you have  no card. In this case you  must draw a card at  random from the\n"
				+ "(shuffled) face down waste  pile, before the cards  from the trick just  played are\n"
				+ "thrown onto the pile. You must lead the card that you drew to continue the game. If\n"
				+ "you are lucky, and a higher card of that suit is played to the trick, then you will\n"
				+ "be out of the game and safe. If no one plays higher in that suit then you will have\n"
				+ "to lead again, either from the cards you pick up if there is a tochoo, or otherwise\n"
				+ "by drawing from the waste pile again.\n" + "\n" + "----[Taking cards]----\n"
				+ "Before any trick, any  player is allowed  to take all the cards  from the player to\n"
				+ "their immediate left - or if that player has no cards, the next player in clockwise\n"
				+ "order who still  has cards - and add these  cards to  their hand. The  player whose\n"
				+ "cards were taken has got away and cannot lose.\n" + "\n"
				+ "At first sight it may seem surprising that  anyone would wish to do this given that\n"
				+ "the aim is to get rid of cards. In fact  it is often the best move if the player to\n"
				+ "your left does  not have the  suits that you  have, or has some  low cards that you\n" + "need.\n"
				+ "\n" + "----[End of Play]----\n"
				+ "As players run out of cards  they get away and drop  out of the game, and  the last\n"
				+ "player left holding cards is  the loser. There is no formal  scoring system, but if\n"
				+ "playing a series of games, players may  like to keep track of how often each player\n"
				+ "has lost.\n");
	}

	/**
	 * start the game by taking the number of players starting the game loop.
	 */
	private static void startGame() {
		round = 1;
		CardDeck[] playerDecks = assignShuffledCardsToPlayers(getNumberOfPlayers());

		gameLoop = true;
		while (gameLoop) {
			playRound(playerDecks);			
			if (breakLoopAtEnd(playerDecks)) {
				announceBhabhi(playerDecks);
				break;
			}
		}		
	}

	/**
	 * Announce who is the loser (Bhabhi) of the game by displaying it on console.
	 * 
	 * @param playerDecks to check for the non empty deck
	 */
	private static void announceBhabhi(CardDeck[] playerDecks) {
		for (int i = 0; i < playerDecks.length; i++) {
			if (playerDecks[i].size() != 0) {
				System.out.println("\n\n");
				System.out.println(
						"---___Player " + (i + 1) + " has lost the game and became everyone's BHABHI!___---\n\n");
				break;
			}
		}
	}

	/**
	 * Check whether all the player expect the loser (Bhabhi) have gotten away. If
	 * true it will break the loop by making gameLoop = false.
	 * 
	 * @param playerDecks to check the number of empty decks
	 */
	private static boolean breakLoopAtEnd(CardDeck[] playerDecks) {
		int playerspassed = 0;
		for (int i = 0; i < playerDecks.length; i++) {
			if (playerDecks[i].size() == 0) {
				playerspassed++;
			}
		}
		if (playerspassed == playerDecks.length - 1) {
			gameLoop = false;
			return true;
		}
		return false;
	}

	/**
	 * Get the player who will open in the next round and continue clockwise.
	 * 
	 * @param playerDecks to search for the Ace of spades in all decks.
	 * @return An integer that is the index of the starting player.
	 */
	private static int getStartingPlayerIndex(CardDeck[] playerDecks) {
		int playerTracker = 0;
		if (round == 1) {
			prevRoundCards = new Card[playerDecks.length];
			for (CardDeck cardDeck : playerDecks) {
				if (cardDeck.searchCard(1, 1) != 0) {
					openingPlayer = playerTracker;
					return playerTracker;
				} else {
					playerTracker++;
				}
			}
		} else {
			playerTracker = openingPlayer;
			int suit = prevRoundCards[playerTracker].getSuit();
			int value = prevRoundCards[playerTracker].getNumber();
			for (int i = 0; i < prevRoundCards.length; i++) {
				if (prevRoundCards[playerTracker] != null) {
					if (prevRoundCards[playerTracker].getSuit() == suit) {
						if (value != 1 && prevRoundCards[playerTracker].getNumber() > value) {
							value = prevRoundCards[playerTracker].getNumber();
							openingPlayer = playerTracker;
						}
					} else if (round != 2) {
						for (Card card : prevRoundCards) {
							if (card != null) {
								playerDecks[openingPlayer].addCard(card);
							}
						}
					}
				}
				playerTracker = (playerTracker + 1) % playerDecks.length;
			}
			prevRoundCards = new Card[playerDecks.length];
		}
		return openingPlayer;

	}

	/**
	 * Display the cards of the user on the console and get a card from it.
	 * 
	 * @param suit        to follow on the parent suit.
	 * @param playerDecks to search and remove the cards.
	 * @return The card that is remove from the players decks.
	 */
	private static Card displayAndGetTheCardFromUser(int suit, CardDeck playerDecks) {
		int cardNumber = 0;

		if (round == 1 && playerDecks.searchCard(1, 1) != 0) {
			cardNumber = playerDecks.searchCard(1, 1);

		} else if (suit != -1 && playerDecks.checkSuitCards(suit) == true) {
			playerDecks.showAllCardsOfSuit(suit);
			System.out.println("Enter the card number you want to play: ");
			cardNumber = Keyboard.inputNumber();

			while (playerDecks.verifyCardSuit(cardNumber, suit) == false && cardNumber != -1) {
				System.out.println("Invalid card number. Please enter again: ");
				cardNumber = Keyboard.inputNumber();
			}

		} else {
			playerDecks.showAllCards();
			if (suit == -1 || round == 1) {
				System.out.println("Enter the card number you want to play: ");
			} else {
				System.out.println("Enter the card number you want to play as thulla: ");
			}
			cardNumber = Keyboard.inputNumber();

			while ((cardNumber > playerDecks.size() || cardNumber <= 0) && cardNumber != -1) {
				System.out.println("Invalid card number. Please enter again: ");
				cardNumber = Keyboard.inputNumber();
			}
		}
		if (cardNumber == -1) {
			System.out.println("\nThe Game is terminated.\n");
			gameLoop = false;
			return null;
		} else {
			return playerDecks.takeCard(cardNumber);
		}
	}

	/**
	 * Play a round from the starting player to end in clockwise direction until it
	 * encounters a thulla or end.
	 * 
	 * @param playerDecks the deck of each player cards.
	 */
	private static void playRound(CardDeck[] playerDecks) {
		int playerTracker = getStartingPlayerIndex(playerDecks);
		System.out.println("\n---------  ROUND " + round + "  ---------\n");
		System.out.println("---Player " + (playerTracker + 1) + " is starting this round---");
		prevRoundCards[playerTracker] = displayAndGetTheCardFromUser(-1, playerDecks[playerTracker]);
		if (!gameLoop) {
			return;
		}
		System.out.println(
				"Player " + (playerTracker + 1) + " has played the card " + prevRoundCards[playerTracker].toString());
		int parentSuit = prevRoundCards[playerTracker].getSuit();

		playerTracker = (playerTracker + 1) % playerDecks.length;

		for (int i = 1; i < playerDecks.length; i++) {

			if (playerDecks[playerTracker].size() == 0) {
				playerTracker = (playerTracker + 1) % playerDecks.length;
			} else {
				System.out.println("\n---Player " + (playerTracker + 1) + " turn---");
				prevRoundCards[playerTracker] = displayAndGetTheCardFromUser(parentSuit, playerDecks[playerTracker]);
				if (!gameLoop) {
					return;
				}

				System.out.println("Player " + (playerTracker + 1) + " has played the card "
						+ prevRoundCards[playerTracker].toString());

				if (prevRoundCards[playerTracker].getSuit() != parentSuit && round != 1) {
					break;
				}
				playerTracker = (playerTracker + 1) % playerDecks.length;
			}
		}
		round++;
	}

	/**
	 * Get the number of humen players.
	 * 
	 * @return the number of humen players.
	 */
	private static int getNumberOfPlayers() {
		System.out.println();
		System.out.println("Enter the total number of players in the game.");
		int input = Keyboard.inputNumber();
		while (input < 2 || input > 8) {
			System.out.println("Invalid input. The number of players must be in the range 2-8.");
			input = Keyboard.inputNumber();
		}
		return input;
	}

	/**
	 * Shuffle a new deck of cards and assign it equally to the player by dividing
	 * it in parts.
	 * 
	 * @param playerCount how many deck to create.
	 * @return An array of every player deck of cards.
	 */
	private static CardDeck[] assignShuffledCardsToPlayers(int playerCount) {
		CardDeck[] playerDecks = new CardDeck[playerCount];
		CardDeck cards = new CardDeck(true); // create a full deck of cards to distribute
		cards.takeCard(53); // removing the joker card
		cards.shuffle(); // shuffle the deck to maintain fairness
		int counter = playerCount;
		for (int i = 0; i < playerCount; i++) {
			int playerDeckSize = cards.size() / counter;
			playerDecks[i] = new CardDeck(false); // create a empty deck of cards
			for (int j = 0; j < playerDeckSize; j++) {
				playerDecks[i].addCard(cards.takeCard());
			}
			counter--;
		}
		return playerDecks;
	}

}