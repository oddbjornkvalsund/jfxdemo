package _02_components;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.transform.Rotate;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import static java.lang.Double.MAX_VALUE;
import static javafx.scene.layout.Priority.ALWAYS;

public class TransformedComponentsDemo extends Application {
    @Override
    public void start(Stage stage) {
        final WebView webView = new WebView();
        final WebEngine webEngine = webView.getEngine();
        webView.setMaxHeight(MAX_VALUE);
        HBox.setHgrow(webView, ALWAYS);

        final StackPane webViewParent = new StackPane(webView);
        webViewParent.getTransforms().add(new Rotate(5.0));
        VBox.setVgrow(webViewParent, ALWAYS);

        final Button googleBtn = new Button("Google");
        googleBtn.setOnAction(e -> webEngine.load("http://www.google.com"));
        googleBtn.setMaxWidth(MAX_VALUE);
        HBox.setHgrow(googleBtn, ALWAYS);

        final Button hackerNewsBtn = new Button("Hacker News");
        hackerNewsBtn.setOnAction(e -> webEngine.load("https://news.ycombinator.com/"));
        hackerNewsBtn.setMaxWidth(MAX_VALUE);
        HBox.setHgrow(hackerNewsBtn, ALWAYS);

        final HBox buttonRow = new HBox(googleBtn, hackerNewsBtn);
        final VBox mainColumn = new VBox(buttonRow, webViewParent);

        stage.setTitle("My favourite browser");
        stage.setScene(new Scene(mainColumn));
        stage.show();
    }
}
