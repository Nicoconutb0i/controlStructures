package controlStructures;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LE_21 extends Application {

    @Override
    public void start(Stage stage) {
        TextField txtYear = new TextField();
        TextField txtMonth = new TextField();
        TextField txtDay = new TextField();
        Button btnCalculate = new Button("Calculate");
        Label lblResult = new Label();

        btnCalculate.setOnAction(e -> {
            int year = Integer.parseInt(txtYear.getText().trim());
            int month = Integer.parseInt(txtMonth.getText().trim());
            int day = Integer.parseInt(txtDay.getText().trim());

            if (month == 1) { month = 13; year--; }
            else if (month == 2) { month = 14; year--; }

            int h = (day + (26 * (month + 1) / 10) + (year % 100) + ((year % 100) / 4) + ((year / 100) / 4) + (5 * (year / 100))) % 7;
            String[] days = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
            lblResult.setText("Day of the week is " + days[h]);
        });

        VBox root = new VBox(8,
            new Label("Year:"), txtYear,
            new Label("Month:"), txtMonth,
            new Label("Day:"), txtDay,
            btnCalculate, lblResult
        );
        root.setPadding(new Insets(15));

        stage.setScene(new Scene(root, 220, 260));
        stage.setTitle("LE2.1");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}