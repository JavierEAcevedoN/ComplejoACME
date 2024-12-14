package Vista.utils;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class DraggableWindow {

    private static double xOffset = 0;
    private static double yOffset = 0;

    public static void init(Pane draggableArea) {

        draggableArea.sceneProperty().addListener((obs, oldScene, newScene) -> {
            if (newScene != null) {
                newScene.windowProperty().addListener((obsWindow, oldWindow, newWindow) -> {
                    if (newWindow instanceof Stage stage) {

                        draggableArea.setOnMousePressed(event -> {
                            xOffset = event.getSceneX();
                            yOffset = event.getSceneY();
                        });

                        draggableArea.setOnMouseDragged(event -> {
                            stage.setX(event.getScreenX() - xOffset);
                            stage.setY(event.getScreenY() - yOffset);
                        });
                    }
                });
            }
        });
    }
}
