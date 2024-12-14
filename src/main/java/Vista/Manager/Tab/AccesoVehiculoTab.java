package Vista.Manager.Tab;

import Vista.utils.createLabeledField;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

public class AccesoVehiculoTab implements TabBuilder{
    @Override
    public Tab Crear() {
        Tab accesoVehiculoTab = new Tab();
        accesoVehiculoTab.setText("Acceso Vehicular");

        FlowPane flowPane = new FlowPane();
        flowPane.setAlignment(Pos.CENTER);

        VBox vbox = new VBox(20);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(createLabeledField.create("Placa", new TextField()));

        Button permitirAccesoButton = new Button("Permitir acceso");
        permitirAccesoButton.setDefaultButton(true);
        permitirAccesoButton.setCursor(Cursor.HAND);

        vbox.getChildren().add(permitirAccesoButton);
        flowPane.getChildren().add(vbox);
        accesoVehiculoTab.setContent(flowPane);

        return accesoVehiculoTab;
    }
}
