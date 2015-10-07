package _05_threads;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadDemoFull extends Application {

    final ExecutorService threadPool = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        final Label resultLabel = new Label();
        final Button button = new Button("Click me!");
        button.setOnAction((event) -> {
            threadPool.submit(new Task<String>() {

                private String currentTime;

                @Override
                protected String call() {
                    currentTime = getCurrentTime();
                    return currentTime;
                }

                @Override
                protected void succeeded() {
                    resultLabel.setText(currentTime);
                }
            });
        });

        final Scene scene = new Scene(new VBox(button, resultLabel));
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        threadPool.shutdown();
        threadPool.awaitTermination(3, TimeUnit.SECONDS);
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