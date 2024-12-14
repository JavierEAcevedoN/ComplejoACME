package Vista.Manager.Tab;

import Vista.utils.createLabeledField;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

public class RegistrarVehiculoTab implements TabBuilder{

    @Override
    public Tab Crear() {
        Tab registrarVehiculoTab = new Tab("Registrar Vehiculo");

        FlowPane vehiculoContent = new FlowPane();
        vehiculoContent.setAlignment(Pos.CENTER);

        VBox vehiculoForm = new VBox();
        vehiculoForm.setAlignment(Pos.CENTER_RIGHT);
        vehiculoForm.setSpacing(40.0);
        vehiculoForm.setPrefSize(280.0, 541.0);

        vehiculoForm.getChildren().addAll(
                createLabeledField.create("Usuario Responsable", new TextField()),
                createLabeledField.create("Placa del Vehiculo", new TextField()),
                new Button("Guardar") {{
                    setDefaultButton(true);
                    setCursor(Cursor.HAND);
                }}
        );

        vehiculoContent.getChildren().add(vehiculoForm);
        registrarVehiculoTab.setContent(vehiculoContent);

        return registrarVehiculoTab;
    }
}
