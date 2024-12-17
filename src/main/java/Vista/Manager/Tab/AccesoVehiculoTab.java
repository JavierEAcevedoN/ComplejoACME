package Vista.Manager.Tab;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.acme.complejoacme.Manager.ManagerController;

import Modelo.DAO.CAVehiculo.CAVehiculoO;
import Modelo.DAO.CAVehiculo.CCAVehiculo;
import Vista.utils.createLabeledField;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

public class AccesoVehiculoTab implements TabBuilder{
    private CCAVehiculo ccaVehiculo = CCAVehiculo.getInstance();
    private CAVehiculoO caVehiculoO;
    private Timestamp fechaEntrada, fechaSalida;
    private String sPlaca;

    @Override
    public Tab Crear(ManagerController controller) {
        
        Tab accesoVehiculoTab = new Tab("Acceso Vehicular");
        accesoVehiculoTab.setId("accesoVehiculo");

        
        FlowPane flowPane = new FlowPane();
        flowPane.setAlignment(Pos.CENTER);
        flowPane.setColumnHalignment(HPos.CENTER);

        
        VBox mainVBox = new VBox();
        mainVBox.setAlignment(Pos.CENTER);
        mainVBox.setPrefSize(230, 540);
        mainVBox.setSpacing(20);

        
        VBox placaField = createLabeledField.create("Placa", new TextField(), "accesoVehiculo_Placa");

        TextField placaTextField = (TextField) placaField.getChildren().get(1);

        controller.accesoVehiculo_Placa = placaTextField;

        placaTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            controller.accesoVehiculo_Placa.setText(newValue);
        });

        controller.setInputsAccesoVehiculoTab(controller.getInputsAccesoVehiculoTab());

        
        Button permitirAccesoButton = new Button("Permitir acceso");
        permitirAccesoButton.setId("accesoVehiculo_button");
        permitirAccesoButton.setOnAction(e -> controller.procedimiento(controller.accesoVehicular_Inputs,() -> {
            sPlaca = placaTextField.getText();
            fechaEntrada = Timestamp.valueOf(LocalDateTime.now());
            fechaSalida = null;

            caVehiculoO = new CAVehiculoO(0, fechaEntrada, fechaSalida, sPlaca);
            ccaVehiculo.guardar(caVehiculoO);
        }));
        controller.accesoVehiculo_button = permitirAccesoButton;
        permitirAccesoButton.setDefaultButton(true);
        permitirAccesoButton.setMnemonicParsing(false);
        permitirAccesoButton.setCursor(Cursor.HAND);

        
        mainVBox.getChildren().addAll(placaField, permitirAccesoButton);

        
        flowPane.getChildren().add(mainVBox);

        
        accesoVehiculoTab.setContent(flowPane);

        return accesoVehiculoTab;
    }
}