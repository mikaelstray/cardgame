package edu.stud.ntnu.cardgame.CardEnums;

/**
 * Enum for the different ranks of a playing card.
 */

public enum Suit {
  SPADES('S'), HEARTS('H'), DIAMONDS('D'), CLUBS('C');
  private final char symbol;
  private Suit(char symbol) {
    this.symbol = symbol;
  }
  public char getSymbol() {
    return symbol;
  }
}