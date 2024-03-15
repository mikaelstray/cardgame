package edu.stud.ntnu.cardgame.gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class JavaFXapp extends Application {

  private final TextArea cardDisplayArea = new TextArea();
  private final Button dealHandButton = new Button("Deal hand");
  private final Button checkHandButton = new Button("Check hand");
  @Override
  public void start(Stage primaryStage) {
    // Main layout pane
    BorderPane borderPane = new BorderPane();

    // TextArea for displaying cards
    borderPane.setCenter(cardDisplayArea);


    // Buttons for dealing and checking hand

    HBox buttonBox = new HBox(10, dealHandButton, checkHandButton);
    buttonBox.setAlignment(Pos.CENTER);
    buttonBox.setPadding(new Insets(10));
    borderPane.setBottom(buttonBox);

    // Information display at the bottom
    HBox infoDisplayBox = new HBox(10);
    infoDisplayBox.setAlignment(Pos.CENTER);
    infoDisplayBox.setPadding(new Insets(10));

    Label sumLabel = new Label("Sum of the faces:");
    TextField sumField = new TextField("25"); // Example value
    sumField.setEditable(false);

    Label heartsLabel = new Label("Cards of hearts:");
    TextField heartsField = new TextField("H12 H9 H1"); // Example value
    heartsField.setEditable(false);

    Label flushLabel = new Label("Flush:");
    TextField flushField = new TextField("Yes/No"); // Example value
    flushField.setEditable(false);

    Label queenSpadesLabel = new Label("Queen of spades:");
    TextField queenSpadesField = new TextField("Yes/No"); // Example value
    queenSpadesField.setEditable(true);

    infoDisplayBox.getChildren().addAll(sumLabel, sumField, heartsLabel, heartsField, flushLabel, flushField, queenSpadesLabel, queenSpadesField);
    borderPane.setTop(infoDisplayBox);

    // Create and set the scene
    Scene scene = new Scene(borderPane, 600, 400);
    primaryStage.setTitle("Card Game");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public void updateCardDisplay(String hand) {
    cardDisplayArea.setText(hand);
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
