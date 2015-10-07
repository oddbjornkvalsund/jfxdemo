package _05_threads;

import com.sun.javafx.tk.Toolkit;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.time.LocalTime;
import java.util.concurrent.atomic.AtomicInteger;

public class PulseDemo extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        final Label label = new Label();
        final Thread labelUpdaterThread = new Thread(() -> {
            while (true) {
                Platform.runLater(() -> label.setText(LocalTime.now().toString()));
                sleep(1);
            }
        });
        labelUpdaterThread.setDaemon(true);
        labelUpdaterThread.start();


        final AtomicInteger pulseCount = new AtomicInteger(0);
        Toolkit.getToolkit().addSceneTkPulseListener(pulseCount::incrementAndGet);

        final Thread pulseCounterThread = new Thread(() -> {
            final long start = System.currentTimeMillis();
            while (true) {
                final long now = System.currentTimeMillis();
                final double numSeconds = (now - start) / 1000.0;
                System.out.println("Average number of pulses per second: " + pulseCount.get() / numSeconds);
                sleep(1000);
            }
        });
        pulseCounterThread.setDaemon(true);
        pulseCounterThread.start();

        final Scene scene = new Scene(label);
        stage.setScene(scene);
        stage.show();
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
