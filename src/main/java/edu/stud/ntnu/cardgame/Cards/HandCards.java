package edu.stud.ntnu.cardgame.Cards;

import edu.stud.ntnu.cardgame.CardEnums.Rank;
import edu.stud.ntnu.cardgame.CardEnums.Suit;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class represents a hand of playing cards. It contains a list of cards and a deck of cards to
 * deal from.
 */
public class HandCards {

  /**
   * The list of cards in the hand.
   */
  private List<PlayingCard> hand;

  /**
   * The deck of cards to deal from.
   */
  private DeckOfCards deck;

  /**
   * Constructs a new hand of cards, containing an empty list of cards.
   *
   * @param deck The deck of cards to deal from.
   */
  public HandCards(DeckOfCards deck) {
    this.hand = new ArrayList<>();
    this.deck = deck;
  }

  /**
   * Returns the list of cards in the hand.
   *
   * @return The list of cards in the hand.
   */
  public List<PlayingCard> getHand() {
    return hand;
  }

  /**
   * Deals a number of cards from the deck. The cards are removed from the deck.
   *
   * @param n The number of cards to deal.
   * @throws IllegalArgumentException if n is less than 1 or greater than the number of cards in the
   *                                  deck.
   */
  public void dealHands(int n) {
    if (n < 1 || n > deck.cardStock()) {
      throw new IllegalArgumentException("Invalid number of cards to deal");
    }
    hand.clear();
    hand = deck.dealRandomCard(n);
  }

  /**
   * Returns the sum of the face values of the cards in the hand.
   *
   * @return The sum of the face values of the cards in the hand.
   */
  public int handsSum() {
    return hand.stream()
            .mapToInt(i -> i.getFace().getValue())
            .sum();
  }

  /**
   * Returns the cards in the hand that are hearts.
   *
   * @return The cards in the hand that are hearts.
   */
  public String getHearts() {
    String hearts = hand.stream()
            .filter(c -> c.getSuit().equals(Suit.HEARTS))
            .map(PlayingCard::getAsString)
            .collect(Collectors.joining(", "));
    return hearts.isEmpty() ? "No hearts" : hearts;
  }

  /**
   * Returns whether the hand contains the queen of spades.
   *
   * @return true if the hand contains the queen of spades, false otherwise.
   */
  public boolean S12exists() {
    return hand.stream()
            .anyMatch(c -> c.getFace().equals(Rank.QUEEN) && c.getSuit().equals(Suit.SPADES));
  }

  /**
   * Returns whether the hand contains a flush (5 or more cards of the same suit).
   *
   * @return true if the hand contains a flush, false otherwise.
   */
  public boolean isFlush() {
    return hand.stream()
            .collect(Collectors.groupingBy(PlayingCard::getSuit, Collectors.counting()))
            .values().stream()
            .anyMatch(count -> count >= 5);
  }

  /**
   * Returns the cards in the hand as a string.
   *
   * @return The cards in the hand as a string.
   */
  public String handAsString() {
    return hand.stream()
            .map(PlayingCard::getAsString)
            .collect(Collectors.joining("\n"));
  }
}
