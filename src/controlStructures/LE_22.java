package controlStructures;

import java.util.Random;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LE_22 extends Application {

    @Override
    public void start(Stage stage) {
        Label lblHeads = new Label("Heads: 0");
        Label lblTails = new Label("Tails: 0");
        Label lblTotal = new Label("Total Flips: 0");
        Button btnSimulate = new Button("Simulate 2 Million Flips");

        btnSimulate.setOnAction(e -> {
            int headsCount = 0;
            int tailsCount = 0;
            Random random = new Random();

            for (int i = 0; i < 2_000_000; i++) {
                if (random.nextBoolean()) {
                    headsCount++;
                } else {
                    tailsCount++;
                }
            }

            lblHeads.setText("Heads: " + headsCount);
            lblTails.setText("Tails: " + tailsCount);
            lblTotal.setText("Total Flips: 2,000,000");
        });

        VBox root = new VBox(12);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(btnSimulate, lblHeads, lblTails, lblTotal);

        Scene scene = new Scene(root, 300, 200);
        stage.setTitle("Heads or Tails Simulation");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}