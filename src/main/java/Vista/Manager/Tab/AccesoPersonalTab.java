package Vista.Manager.Tab;

import Vista.utils.createLabeledField;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

public class AccesoPersonalTab implements TabBuilder{
    @Override
    public Tab Crear() {
        Tab accesoPersonalTab = new Tab();
        accesoPersonalTab.setText("Acceso Personal");

        FlowPane flowPane = new FlowPane();
        flowPane.setAlignment(Pos.CENTER);

        VBox vbox = new VBox(20);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(createLabeledField.create("Identificador del personal", new TextField()));

        Button permitirAccesoButton = new Button("Permitir acceso");
        permitirAccesoButton.setDefaultButton(true);
        permitirAccesoButton.setCursor(Cursor.HAND);

        vbox.getChildren().add(permitirAccesoButton);
        flowPane.getChildren().add(vbox);
        accesoPersonalTab.setContent(flowPane);

        return accesoPersonalTab;
    }
}
