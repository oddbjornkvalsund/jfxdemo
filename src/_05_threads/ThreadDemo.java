package _05_threads;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalTime;

public class ThreadDemo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        final Label resultLabel = new Label();
        final Button button = new Button("Click me!");
        button.setOnAction((event) -> {
            final String result = getCurrentTime();
            resultLabel.setText(result);
        });

        final Scene scene = new Scene(new VBox(button, resultLabel));
        stage.setScene(scene);
        stage.show();
    }

    // Simulate slow/heavy method call
    private String getCurrentTime() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "The time is now: " + LocalTime.now();
    }
}