package it.fresca.blackjackcounter;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.io.InputStream;

public class CardCounterController {

    private int cardCount = 0;

    @FXML
    private GridPane cardGrid;

    @FXML
    private Button resetButton;

    @FXML
    private Label cardCountLabel;

    @FXML
    public void initialize() {
        // Genera la griglia delle carte
        createCardGrid();
    }

    private void createCardGrid() {
        String[] suits = {"hearts", "diamonds", "clubs", "spades"};
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K"};
        int[] values = {-1, 1, 1, 1, 1, 1, 0, 0, 0, -1, -1, -1, -1};

        // Aggiunge le carte alla griglia
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < ranks.length; j++) {
                String cardName = ranks[j] + "_of_" + suits[i];
                Button cardButton = createCardButton(cardName);
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
        updateCardCountLabel();
        // Mostra il numero totale delle carte selezionate
        System.out.println("Total count: " + cardCount);
    }

    private void updateCardCountLabel() {
        cardCountLabel.setText("Card Count: " + cardCount);
    }

    private Button createCardButton(String cardName) {
        Button button = new Button();
        // Carica l'immagine dal percorso delle risorse
        InputStream cardImageStream = getClass().getResourceAsStream("/it/fresca/blackjackcounter/cards/" + cardName + ".png");
        if (cardImageStream != null) {
            Image cardImage = new Image(cardImageStream);
            ImageView imageView = new ImageView(cardImage);
            imageView.setFitWidth(80);  // imposta la larghezza dell'immagine
            imageView.setFitHeight(120); // imposta l'altezza dell'immagine
            imageView.setAccessibleText(cardName);
            button.setGraphic(imageView);  // imposta l'immagine sul bottone
            button.setOnAction(e -> {

                cardCount+= getCardValue(button.getGraphic().getAccessibleText());
                System.out.println("Card clicked: " + button.getGraphic().getAccessibleText());
                updateCardCount();
            });
        } else {
            System.out.println("Immagine non trovata per " + cardName);
        }
        return button;
    }

    private int getCardValue(String cardName) {

        String card = cardName.substring(0,1);
        switch (card) {
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
                System.out.println("getCardValue 1");
                return 1;
            case "7":
            case "8":
            case "9":
                System.out.println("getCardValue 0");
                return 0;
            case "T":
            case "J":
            case "Q":
            case "K":
            case "A":
                System.out.println("getCardValue -1");
                return -1;
            default:
                System.out.println("getCardValue errore");
                return 0;
        }
    }
}
