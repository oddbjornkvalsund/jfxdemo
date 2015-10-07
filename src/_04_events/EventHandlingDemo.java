package _04_events;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class EventHandlingDemo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        final Circle node = new Circle(100);
//        final Button node = new Button("Click me!");
        node.addEventFilter(MouseEvent.MOUSE_CLICKED, event -> System.out.println("*** Node event filtering, mouse clicked..."));
        node.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> System.out.println("*** Node event handling, mouse clicked..."));

        final Parent parent = new VBox(node);
        parent.addEventFilter(MouseEvent.MOUSE_CLICKED, event -> System.out.println("** Parent event filtering, mouse clicked..."));
        parent.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> System.out.println("** Parent event handling, mouse clicked..."));

        final Scene scene = new Scene(parent);
        scene.addEventFilter(MouseEvent.MOUSE_CLICKED, event -> System.out.println("* Scene event filtering, mouse clicked..."));
        scene.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> System.out.println("* Scene event handling, mouse clicked..."));

        stage.setScene(scene);
        stage.show();
    }
}
