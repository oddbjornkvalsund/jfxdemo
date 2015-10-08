package _06_properties;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PropertyListenerDemo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        final Slider inntektSlider = new Slider(0, 1000000, 450000);

        final Label inntektLabel = new Label("Inntekt:");
        final TextField inntektTextField = new TextField();
        inntektTextField.setEditable(false);

        final Label skattLabel = new Label("Skatt:");
        final TextField skattTextField = new TextField();
        skattTextField.setEditable(false);

        inntektSlider.valueProperty().addListener((property, oldValue, newValue) -> {
            inntektTextField.setText(String.valueOf(newValue.doubleValue()));
            skattTextField.setText(String.valueOf(newValue.doubleValue() * 0.28));
        });

        final Scene scene = new Scene(new VBox(inntektSlider, new HBox(inntektLabel, inntektTextField), new HBox(skattLabel, skattTextField)));
        stage.setTitle("Skattekalkulator");
        stage.setScene(scene);
        stage.show();
    }
}