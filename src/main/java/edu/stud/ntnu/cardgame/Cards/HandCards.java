package edu.stud.ntnu.cardgame.Cards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HandCards {
  private List<PlayingCard> hand;
  public HandCards(List<PlayingCard> hand) {
    this.hand = hand;
  }

  private boolean isFlush() {
    if (hand.size() < 5) {
      return false;
    } else {
      return hand.stream()
              .map(PlayingCard::getSuit)
              .distinct()
              .count() == 1;
    }
  }

  private ArrayList<Integer> sortedHandValues() {
    return hand.stream()
            .map(playingCard -> playingCard.getFace().getValue())
            .distinct()
            .sorted()
            .collect(Collectors
                    .toCollection(ArrayList::new));
  }
  private boolean isStraight() {
    ArrayList<Integer> sortedValues = sortedHandValues();

    if (sortedValues.contains(1)) {
      sortedValues.add(14);
    }

    int straightCounter = 1;
    for (int i = 0; i < sortedValues.size()-1; i++) {
      if (sortedValues.get(i+1) - sortedValues.get(i) == 1) {
        straightCounter++;
        if (straightCounter == 5) return true;
      } else {
        straightCounter = 1;
      }
    }
    return false;
  }

  private boolean isRoyal() {
    List<Integer> royalList = Arrays.asList(1,10,11,12,13);
    return sortedHandValues().containsAll(royalList);
  }
}
