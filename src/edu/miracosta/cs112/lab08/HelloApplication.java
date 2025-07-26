package edu.miracosta.cs112.lab08;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;

import java.io.IOException;
import java.util.Random;

/**
 * EChALE STEM Loteria game.
 * Displays a GUI with the title, image of the cards, a message label, and a draw card button.
 * When the button is clicked, it shows a random Loteria card and also updates the message.
 */

public class HelloApplication extends Application {

    //CONSTANTS

    //array of LoteriaCards to use for game:
    private static final LoteriaCard[] LOTERIA_CARDS = {
            new LoteriaCard("Las matematicas", "1.png", 1),
            new LoteriaCard("Las ciencias", "2.png", 2),
            new LoteriaCard("La Tecnología", "8.png", 8),
            new LoteriaCard("La ingeniería", "9.png", 9),
    };

    /**
     * This sets up the window and everything.
     * @param stage The main window where everything shows up.
     * @throws IOException If something goes wrong while loading the images
     */
    @Override
    public void start(Stage stage) throws IOException {
        //removed FXML code, fill this in with components, scene, stage, etc.
        Label titleLabel = new Label("EChALE STEM Loteria");
        ImageView cardImageView = new ImageView();
        cardImageView.setFitWidth(200);
        cardImageView.setPreserveRatio(true);
        Label messageLabel = new Label("Press 'Draw Card' to start");
        Button drawCardButton = new Button("Draw Card");

        // Layout
        VBox layout = new VBox(15);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(titleLabel, cardImageView, messageLabel, drawCardButton);

        // Scene and Stage setup
        Scene scene = new Scene(layout, 350, 500);
        stage.setScene(scene);
        stage.setTitle("EChALE STEM Loteria");
        stage.show();

        // Shows the first card
        cardImageView.setImage(LOTERIA_CARDS[0].getImage());
        messageLabel.setText("Card: " + LOTERIA_CARDS[0].getCardName());

        // Random for card picking
        Random random = new Random();

        // Event handler, when the button is clicked, it picks a random card
        drawCardButton.setOnAction(new javafx.event.EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event)
            {
                int index = random.nextInt(LOTERIA_CARDS.length);
                LoteriaCard card = LOTERIA_CARDS[index];
                cardImageView.setImage(card.getImage());
                messageLabel.setText("Card: " + card.getCardName());
            }
        });
    }

    /**
     * Starts the game
     */
    public static void main(String[] args)
    {
        launch();
    }
}