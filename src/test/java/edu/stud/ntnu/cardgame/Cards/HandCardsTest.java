package edu.stud.ntnu.cardgame.Cards;

import edu.stud.ntnu.cardgame.CardEnums.Rank;
import edu.stud.ntnu.cardgame.CardEnums.Suit;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandCardsTest {

  @Test
  void dealHands() {
    DeckOfCards deck = new DeckOfCards();
    HandCards hand = new HandCards(deck);
    hand.dealHands(5);
    assertEquals(5, hand.getHand().size());
  }

  @Test
  void negativeDealHands() {
    DeckOfCards deck = new DeckOfCards();
    HandCards hand = new HandCards(deck);
    assertThrows(IllegalArgumentException.class, () -> hand.dealHands(-1));
  }

  @Test
  void handsSum() {
    DeckOfCards deck = new DeckOfCards();
    HandCards hand = new HandCards(deck);
    hand.getHand().add(new PlayingCard(Suit.HEARTS, Rank.KING));
    hand.getHand().add(new PlayingCard(Suit.HEARTS, Rank.QUEEN));
    int sum = hand.handsSum();
    assertEquals(25, sum);
  }
}