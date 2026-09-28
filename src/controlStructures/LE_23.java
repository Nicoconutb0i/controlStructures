package controlStructures;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LE_23 extends Application {

    @Override
    public void start(Stage stage) {
        Label lblInput = new Label("Enter a decimal number:");
        TextField txtDecimal = new TextField();

        Button btnConvert = new Button("Convert");
        Label lblResult = new Label();

        btnConvert.setOnAction(e -> {
            try {
                int decimal = Integer.parseInt(txtDecimal.getText().trim());

                if (decimal == 0) {
                    lblResult.setText("Hexadecimal number: 0");
                    return;
                }

                StringBuilder hexBuilder = new StringBuilder();
                int temp = Math.abs(decimal);

                while (temp > 0) {
                    int remainder = temp % 16;
                    char hexChar;

                    if (remainder >= 10) {
                        hexChar = (char) ('A' + (remainder - 10));
                    } else {
                        hexChar = (char) ('0' + remainder);
                    }

                    hexBuilder.insert(0, hexChar);
                    temp /= 16;
                }

                if (decimal < 0) {
                    hexBuilder.insert(0, "-");
                }

                lblResult.setText("Hexadecimal number: " + hexBuilder.toString());

            } catch (NumberFormatException ex) {
                lblResult.setText("Please enter a valid integer!");
            }
        });

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setAlignment(Pos.CENTER);

        grid.add(lblInput, 0, 0);
        grid.add(txtDecimal, 1, 0);
        grid.add(btnConvert, 1, 1);
        grid.add(lblResult, 0, 2, 2, 1);

        Scene scene = new Scene(grid, 350, 180);
        stage.setTitle("Dec to Hex Converter");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}