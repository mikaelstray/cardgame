package edu.stud.ntnu.cardgame.CardEnums;

public enum Suit {
  SPADES('S'), HEARTS('H'), DIAMONDS('D'), CLUBS('C');
  private final char symbol;
  private Suit(char symbol) {
    this.symbol = symbol;
  }
  public char getSuit() {
    return symbol;
  }
}