package edu.stud.ntnu.cardgame.Cards;

import edu.stud.ntnu.cardgame.CardEnums.Rank;
import edu.stud.ntnu.cardgame.CardEnums.Suit;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HandCards {
  private List<PlayingCard> hand;
  private DeckOfCards deck;

  public HandCards(DeckOfCards deck) {
    this.hand = new ArrayList<>();
    this.deck = deck;
  }

  public List<PlayingCard> getHand() {
    return hand;
  }

  public void dealHands(int n) {
    hand.clear();
    hand = deck.dealRandomCard(n);
  }

  public int handsSum() {
    return hand.stream()
            .mapToInt(i -> i.getFace().getValue())
            .sum();
  }

  public String getHearts() {
    String hearts = hand.stream()
            .filter(c -> c.getSuit().equals(Suit.HEARTS))
            .map(PlayingCard::getAsString)
            .collect(Collectors.joining(", "));
    return hearts.isEmpty() ? "No hearts" : hearts;
  }

  public boolean S12exists() {
    return hand.stream()
            .anyMatch(c -> c.getFace().equals(Rank.QUEEN) && c.getSuit().equals(Suit.SPADES));
  }

  public boolean isFlush() {
    return hand.stream()
            .collect(Collectors.groupingBy(PlayingCard::getSuit, Collectors.counting()))
            .values().stream()
            .anyMatch(count -> count >= 5);
  }

  public String handAsString() {
    return hand.stream()
            .map(PlayingCard::getAsString)
            .collect(Collectors.joining("\n"));
  }
}
