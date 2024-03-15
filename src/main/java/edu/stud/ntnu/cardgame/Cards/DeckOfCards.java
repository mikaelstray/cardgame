package edu.stud.ntnu.cardgame.Cards;

import edu.stud.ntnu.cardgame.CardEnums.Rank;
import edu.stud.ntnu.cardgame.CardEnums.Suit;

import java.util.*;



public class DeckOfCards {
  private final List<PlayingCard> cards;

  public DeckOfCards() {
    cards = new ArrayList<>(52);
    for (Suit suit : Suit.values()) {
      for (Rank rank : Rank.values()) {
        cards.add(new PlayingCard(suit, rank));
      }
    }
    shuffleDeck();
  }

  public List<PlayingCard> dealRandomCard(int n) throws IllegalArgumentException{
    if (n < 1 || n > cardStock()) {
      throw new IllegalArgumentException("...");
    }
    Random rand = new Random();
    List<PlayingCard> hand = new ArrayList<>(n);
    for (int i = 0; i < n; i++) {
      hand.add(cards.remove(rand.nextInt(cards.size())));
    }
    return hand;
  }

  private int cardStock() {
    return cards.size();
  }
  private void shuffleDeck() {
    Collections.shuffle(this.cards);
  }
}
