package Vista.utils;

import javafx.geometry.Pos;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class createLabeledField {
    public static VBox create(String labelText, Control inputControl) {
        VBox container = new VBox();
        container.setAlignment(Pos.CENTER);
        container.setSpacing(8.0);

        Label label = new Label(labelText);
        container.getChildren().addAll(label, inputControl);

        return container;
    }
}
