package it.fresca.blackjackcounter;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class CardCounterController {

    private int cardCount = 0;

    @FXML
    private GridPane cardGrid;

    @FXML
    private Button resetButton;

    @FXML
    public void initialize() {
        // Genera la griglia delle carte
        createCardGrid();
    }

    private void createCardGrid() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        // Aggiunge le carte alla griglia
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < ranks.length; j++) {
                Button cardButton = new Button(ranks[j] + " of " + suits[i]);
                cardButton.setOnAction(e -> {
                    cardCount++;
                    System.out.println("Card clicked: " + cardButton.getText());
                    updateCardCount();
                });
                cardGrid.add(cardButton, j, i);
            }
        }
    }

    @FXML
    public void resetCardCount() {
        cardCount = 0;
        System.out.println("Card count reset");
        updateCardCount();
    }

    private void updateCardCount() {
        // Mostra il numero totale delle carte selezionate
        System.out.println("Total count: " + cardCount);
    }
}
