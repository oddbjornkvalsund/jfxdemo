package _02_fxml;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class SubController implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Initializing SubController...");
    }

    public void buttonClicked() {
        System.out.println("Button clicked in sub controller!");
    }
}