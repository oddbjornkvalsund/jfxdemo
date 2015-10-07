package _01_lifecycle;

import javafx.application.Application;
import javafx.stage.Stage;

public class MyApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() {
        System.out.println("init() on thread " + Thread.currentThread().getName());
    }

    @Override
    public void start(Stage stage) {
        System.out.println("start() on thread " + Thread.currentThread().getName());
        stage.show();
    }

    @Override
    public void stop() {
        System.out.println("stop() on thread " + Thread.currentThread().getName());
    }

}