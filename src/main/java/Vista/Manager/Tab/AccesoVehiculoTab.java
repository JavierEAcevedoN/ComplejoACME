package Vista.Manager.Tab;

import Vista.utils.Alerts.AlertaTab;
import Vista.utils.createLabeledField;
import com.acme.complejoacme.Manager.ManagerController;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

public class AccesoVehiculoTab implements TabBuilder{
    @Override
    public Tab Crear(ManagerController controller) {
        // Crear el Tab
        Tab accesoVehiculoTab = new Tab("Acceso Vehicular");
        accesoVehiculoTab.setId("accesoVehiculo");

        // Crear el FlowPane principal
        FlowPane flowPane = new FlowPane();
        flowPane.setAlignment(Pos.CENTER);
        flowPane.setColumnHalignment(HPos.CENTER);

        // Crear el VBox principal
        VBox mainVBox = new VBox();
        mainVBox.setAlignment(Pos.CENTER);
        mainVBox.setPrefSize(230, 540);
        mainVBox.setSpacing(20);

        // Crear los campos etiquetados
        VBox placaField = createLabeledField.create("Placa", new TextField(), "accesoVehiculo_Placa");

        TextField placaTextField = (TextField) placaField.getChildren().get(1);

        controller.accesoVehiculo_Placa = placaTextField;

        placaTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            controller.accesoVehiculo_Placa.setText(newValue);
        });

        controller.setInputsAccesoVehiculoTab(controller.getInputsAccesoVehiculoTab());

        // Crear el botón "Permitir acceso"
        Button permitirAccesoButton = new Button("Permitir acceso");
        permitirAccesoButton.setId("accesoVehiculo_button");
        permitirAccesoButton.setOnAction(e -> controller.procedimiento(controller.accesoVehicular_Inputs,() -> {
            AlertaTab.Test();}));
        controller.accesoVehiculo_button = permitirAccesoButton;
        permitirAccesoButton.setDefaultButton(true);
        permitirAccesoButton.setMnemonicParsing(false);
        permitirAccesoButton.setCursor(Cursor.HAND);

        // Agregar los elementos al VBox principal
        mainVBox.getChildren().addAll(placaField, permitirAccesoButton);

        // Agregar el VBox principal al FlowPane
        flowPane.getChildren().add(mainVBox);

        // Configurar el contenido del Tab
        accesoVehiculoTab.setContent(flowPane);

        return accesoVehiculoTab;
    }
}