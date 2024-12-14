package Vista.Manager.Tab;

import Vista.utils.createLabeledField;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

public class SalidaVehiculoTab implements TabBuilder{

    @Override
    public Tab Crear() {
        Tab salidaVehiculoTab = new Tab();
        salidaVehiculoTab.setText("Salida Vehicular");

        FlowPane flowPane = new FlowPane();
        flowPane.setAlignment(Pos.CENTER);

        VBox vbox = new VBox(20);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(createLabeledField.create("Placa", new TextField()));

        Button registrarSalidaButton = new Button("Registrar Salida");
        registrarSalidaButton.setDefaultButton(true);
        registrarSalidaButton.setCursor(Cursor.HAND);

        vbox.getChildren().add(registrarSalidaButton);
        flowPane.getChildren().add(vbox);
        salidaVehiculoTab.setContent(flowPane);

        return salidaVehiculoTab;
    }
}
