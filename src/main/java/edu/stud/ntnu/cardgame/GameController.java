package edu.stud.ntnu.cardgame;

import edu.stud.ntnu.cardgame.Cards.HandCards;
import edu.stud.ntnu.cardgame.Cards.PlayingCard;
import edu.stud.ntnu.cardgame.gui.JavaFXapp;
import javafx.scene.control.Button;

import java.util.List;

public class GameController {

  private HandCards hand;
  private final JavaFXapp view;

  public GameController(HandCards hand, JavaFXapp view) {
    this.hand = hand;
    this.view = view;
    attachEventHandelers();
  }

  private void attachEventHandelers() {
    Button dealButton = view.getDealHandButton();
    if (dealButton != null) {
      dealButton.setOnAction(e -> handleDeal());
    }
  }

  private void handleDeal() {
    hand.dealHands(5);
    view.updateCardDisplay(hand.handAsString());
  }

}
