package _02_fxml;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private Button mainButton;

    @FXML
    private SubController subController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Initializing MainController...");

        mainButton.setOnAction((event -> System.out.println("Button clicked in main controller!")));
    }
}