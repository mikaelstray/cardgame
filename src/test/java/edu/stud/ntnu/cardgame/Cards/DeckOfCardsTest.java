package edu.stud.ntnu.cardgame.Cards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeckOfCardsTest {

  @Test
  void dealRandomCard() {

    DeckOfCards deck = new DeckOfCards();
    deck.dealRandomCard(5);
    assertEquals(47, deck.cardStock());
  }

  @Test
  void dealRandomCardException() {
    DeckOfCards deck = new DeckOfCards();
    assertThrows(IllegalArgumentException.class, () -> deck.dealRandomCard(53));
  }
}