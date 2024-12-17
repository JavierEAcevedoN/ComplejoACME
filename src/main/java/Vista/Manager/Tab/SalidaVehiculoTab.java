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

public class SalidaVehiculoTab implements TabBuilder{
    private CCAVehiculo ccaVehiculo = CCAVehiculo.getInstance();
    private CAVehiculoO caVehiculoO;
    private Timestamp fechaEntrada, fechaSalida;
    private String sPlaca;

    @Override
    public Tab Crear(ManagerController controller) {
        
        Tab salidaVehiculoTab = new Tab("Salida Vehicular");
        salidaVehiculoTab.setId("salidaVehiculo");

        
        FlowPane flowPane = new FlowPane();
        flowPane.setAlignment(Pos.CENTER);
        flowPane.setColumnHalignment(HPos.CENTER);

        
        VBox mainVBox = new VBox();
        mainVBox.setAlignment(Pos.CENTER);
        mainVBox.setPrefSize(230, 540);
        mainVBox.setSpacing(20);

        VBox placaField = createLabeledField.create("Placa", new TextField(), "salidaVehiculo_Placa");
        TextField placaTextField = (TextField) placaField.getChildren().get(1);
        controller.salidaVehiculo_Placa = placaTextField;

        placaTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            controller.salidaVehiculo_Placa.setText(newValue);
        });

        controller.setInputsSalidaVehiculoTab(controller.getInputsSalidaVehiculoTab());

        
        Button registrarSalidaButton = new Button("Registrar Salida");
        registrarSalidaButton.setId("salidaVehiculo_button");
        registrarSalidaButton.setOnAction(e -> controller.procedimiento(controller.salidaVehicular_Inputs,() -> {
            sPlaca = placaTextField.getText();
            fechaEntrada = null;
            fechaSalida = Timestamp.valueOf(LocalDateTime.now());

            caVehiculoO = new CAVehiculoO(0, fechaEntrada, fechaSalida, sPlaca);
            ccaVehiculo.actualizar(caVehiculoO);
        }));
        controller.salidaVehiculo_button = registrarSalidaButton;
        registrarSalidaButton.setDefaultButton(true);
        registrarSalidaButton.setMnemonicParsing(false);
        registrarSalidaButton.setCursor(Cursor.HAND);

        
        mainVBox.getChildren().addAll(placaField, registrarSalidaButton);

        
        flowPane.getChildren().add(mainVBox);

        
        salidaVehiculoTab.setContent(flowPane);

        return salidaVehiculoTab;
    }
}