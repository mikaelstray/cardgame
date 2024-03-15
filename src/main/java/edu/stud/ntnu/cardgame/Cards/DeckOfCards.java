package edu.stud.ntnu.cardgame.Cards;

import edu.stud.ntnu.cardgame.CardEnums.Rank;
import edu.stud.ntnu.cardgame.CardEnums.Suit;

import java.util.*;

/**
 * <h1>Deck of cards</h1>
 * <p>
 * This class represents a deck of playing cards. It contains 52 cards, each with a unique suit and
 * rank. The deck can be shuffled and cards can be dealt from the deck.
 * </p>
 *
 * @author Mikael Stray Froeyshov
 * @version 1.0
 * @since 2024-15-03
 */

public class DeckOfCards {
  /**
   * The list of cards in the deck.
   */
  private final List<PlayingCard> cards;

  /**
   * Constructs a new deck of cards, containing 52 unique cards.
   */
  public DeckOfCards() {
    cards = new ArrayList<>(52);
    for (Suit suit : Suit.values()) {
      for (Rank rank : Rank.values()) {
        cards.add(new PlayingCard(suit, rank));
      }
    }
    shuffleDeck();
  }

  /**
   * Deals a number of cards from the deck. The cards are removed from the deck.
   *
   * @param n The number of cards to deal.
   * @return A list of n cards.
   * @throws IllegalArgumentException if n is less than 1 or greater than the number of cards in the
   *                                  deck.
   */
  public List<PlayingCard> dealRandomCard(int n) throws IllegalArgumentException{
    if (n < 1 || n > cardStock()) {
      throw new IllegalArgumentException("Invalid number of cards to deal");
    }
    Random rand = new Random();
    List<PlayingCard> hand = new ArrayList<>(n);
    for (int i = 0; i < n; i++) {
      hand.add(cards.remove(rand.nextInt(cards.size())));
    }
    return hand;
  }

  /**
   * Returns the number of cards in the deck.
   *
   * @return The number of cards in the deck.
   */
  public int cardStock() {
    return cards.size();
  }

  /**
   * Shuffles the deck of cards.
   */
  private void shuffleDeck() {
    Collections.shuffle(this.cards);
  }
}
