package edu.stud.ntnu.cardgame.gui;

import edu.stud.ntnu.cardgame.Cards.DeckOfCards;
import edu.stud.ntnu.cardgame.Cards.HandCards;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class JavaFXapp extends Application {

  private GameController gameController;
  private final HBox infoDisplayBox = new HBox(10);
  private final TextArea cardDisplayArea = new TextArea();
  private final Button dealHandButton = new Button("Deal hand");
  private final Button checkHandButton = new Button("Check hand");
  private final TextField textField = new TextField();
  @Override
  public void start(Stage primaryStage) {
    // Main layout pane
    BorderPane borderPane = new BorderPane();

    // TextArea for displaying cards
    borderPane.setCenter(cardDisplayArea);

    textField.setPromptText("How many cards?");
    // Buttons for dealing and checking hand
    HBox buttonBox = new HBox(20, textField, dealHandButton, checkHandButton);
    buttonBox.setAlignment(Pos.CENTER);
    buttonBox.setPadding(new Insets(10));
    borderPane.setBottom(buttonBox);

    // Information display at the bottom
    infoDisplayBox.setAlignment(Pos.CENTER);
    infoDisplayBox.setPadding(new Insets(10));

    Label sumLabel = new Label("Sum:");
    TextField sumField = new TextField(); // Example value
    sumField.setEditable(false);

    Label heartsLabel = new Label("H:");
    TextField heartsField = new TextField(); // Example value
    heartsField.setEditable(false);

    Label flushLabel = new Label("S12?");
    TextField flushField = new TextField(); // Example value
    flushField.setEditable(false);

    Label queenSpadesLabel = new Label("Flush?");
    TextField queenSpadesField = new TextField(); // Example value
    queenSpadesField.setEditable(true);

    infoDisplayBox.getChildren().addAll(sumLabel, sumField, heartsLabel, heartsField, flushLabel, flushField, queenSpadesLabel, queenSpadesField);
    borderPane.setTop(infoDisplayBox);
    for (Node n : infoDisplayBox.getChildren()) {
      if (n instanceof TextField) {
        ((TextField) n).setPrefWidth(100);
        ((TextField) n).setPrefHeight(20);
      }
    }

    // Create and set the scene
    Scene scene = new Scene(borderPane, 600, 400);
    primaryStage.setTitle("Card Game");
    primaryStage.setScene(scene);
    primaryStage.show();

    DeckOfCards deck = new DeckOfCards();
    HandCards hand = new HandCards(deck);
    GameController gameController1 = new GameController(hand,this);

  }

  public void updateCardDisplay(String hand) {
    cardDisplayArea.setText(hand);
  }

  public void setBoxText(int index, String sum) {
    ((TextField) infoDisplayBox.getChildren().get(index)).setText(sum);
  }
  public Integer getNrOfCards() {
    return Integer.parseInt(textField.getText());
  }

  public Button getDealHandButton() {
    return dealHandButton;
  }

  public Button getCheckHandButton() {
    return checkHandButton;
  }

  public static void main(String[] args) {
    launch(args);
  }
}
