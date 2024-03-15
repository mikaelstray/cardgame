package edu.stud.ntnu.cardgame.Cards;

import edu.stud.ntnu.cardgame.CardEnums.Rank;
import edu.stud.ntnu.cardgame.CardEnums.Suit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayingCardTest {

  @Test
  void getAsString() {
    PlayingCard card = new PlayingCard(Suit.HEARTS, Rank.ACE);
    assertEquals("H1", card.getAsString());
  }

  @Test
  void getSuit() {
    PlayingCard card = new PlayingCard(Suit.HEARTS, Rank.ACE);
    assertEquals(Suit.HEARTS, card.getSuit());
  }

  @Test
  void getFace() {
    PlayingCard card = new PlayingCard(Suit.HEARTS, Rank.ACE);
    assertEquals(Rank.ACE, card.getFace());
  }
}