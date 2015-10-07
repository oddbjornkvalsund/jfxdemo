package _03_scenegraph;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.control.Button;
import javafx.scene.paint.*;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

public class SceneGraphWithShape3D extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        final Button helloBtn = new Button("Hello");

        final Sphere sphere = new Sphere(200);
        sphere.getTransforms().add(new Translate(200, 200));

        final PhongMaterial sphereMaterial = new PhongMaterial();
        sphereMaterial.setDiffuseColor(Color.DARKGREEN);
        sphereMaterial.setSpecularColor(Color.OLIVE);
        sphere.setMaterial(sphereMaterial);

        final Paint sceneBackground = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE, new Stop(0, Color.GRAY), new Stop(1, Color.BLACK));
        final Scene scene = new Scene(new Group(sphere, helloBtn), 800, 600, true, SceneAntialiasing.BALANCED);
        scene.setFill(sceneBackground);
        stage.setScene(scene);
        stage.show();
    }
}
