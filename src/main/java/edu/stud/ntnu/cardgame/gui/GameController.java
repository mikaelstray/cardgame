package edu.stud.ntnu.cardgame.gui;

import edu.stud.ntnu.cardgame.Cards.HandCards;
import edu.stud.ntnu.cardgame.gui.JavaFXapp;
import javafx.scene.control.Button;


public class GameController {

  private HandCards hand;
  private final JavaFXapp view;

  public GameController(HandCards hand, JavaFXapp view) {
    this.hand = hand;
    this.view = view;
    attachEventHandlers();
  }

  private void attachEventHandlers() {
    Button dealButton = view.getDealHandButton();
    if (dealButton != null) {
      dealButton.setOnAction(e -> {
        handleDeal();
        view.setBoxText(1, Integer.toString(hand.handsSum()));
        view.setBoxText(3, hand.getHearts());
        view.setBoxText(5, this.hasS12());
        view.setBoxText(7, this.isFlush());
      });
    }
  }
  private void handleDeal() {
    hand.dealHands(view.getNrOfCards());
    view.updateCardDisplay(hand.handAsString());
  }

  private String hasS12() {
    return hand.S12exists() ? "Yes" : "No";
  }

  private String isFlush() {
    return hand.isFlush() ? "Yes" : "No";
  }

}
