package edu.stud.ntnu.cardgame.gui;

import edu.stud.ntnu.cardgame.Cards.HandCards;
import javafx.scene.control.Button;

/**
 * Controller class for the card game application.
 */
public class GameController {

  private HandCards hand;
  private final JavaFXapp view;

  public GameController(HandCards hand, JavaFXapp view) {
    this.hand = hand;
    this.view = view;
    attachEventHandlers();
  }

  /**
   * Attaches event handlers to the buttons in the view.
   */
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

  /**
   * Deals a new hand of cards and updates the view.
   */
  private void handleDeal() {
    hand.dealHands(view.getNrOfCards());
    view.updateCardDisplay(hand.handAsString());
  }

  /**
   * Returns "Yes" if the hand contains the queen of spades, "No" otherwise.
   *
   * @return "Yes" if the hand contains the queen of spades, "No" otherwise.
   */
  private String hasS12() {
    return hand.S12exists() ? "Yes" : "No";
  }

  /**
   * Returns "Yes" if the hand contains a flush, "No" otherwise.
   *
   * @return "Yes" if the hand contains a flush, "No" otherwise.
   */
  private String isFlush() {
    return hand.isFlush() ? "Yes" : "No";
  }
}
