package _05_threads;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TimelineDemo extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        final Button button = new Button("I am a button");

        new Timeline(new KeyFrame(Duration.seconds(3), (e) -> button.setText("...with new text!"))).play();

        stage.setScene(new Scene(button));
        stage.show();
    }
}
