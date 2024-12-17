package Vista.Manager.Tab;

import Vista.utils.createLabeledField;
import com.acme.complejoacme.Manager.ManagerController;

import Modelo.DAO.Vehiculo.CMGVehiculo;
import Modelo.DAO.Vehiculo.VehiculoO;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

public class RegistrarVehiculoTab implements TabBuilder{
    private CMGVehiculo cmgVehiculo = CMGVehiculo.getInstance();
    private VehiculoO vehiculoO;
    private long idDueño;
    private String placa;

    @Override
    public Tab Crear(ManagerController controller) {
        
        Tab registrarVehiculoTab = new Tab("Registrar Vehiculo");
        registrarVehiculoTab.setId("crearVehiculo");

        
        FlowPane flowPane = new FlowPane();
        flowPane.setAlignment(Pos.CENTER);
        flowPane.setColumnHalignment(HPos.CENTER);

        
        VBox mainVBox = new VBox();
        mainVBox.setAlignment(Pos.CENTER_RIGHT);
        mainVBox.setPrefSize(280, 541);
        mainVBox.setSpacing(40);

        VBox usuarioField = createLabeledField.create("Personal Responsable", new TextField(), "crearVehiculo_Id");
        TextField usuarioTextField = (TextField) usuarioField.getChildren().get(1);
        controller.crearVehiculo_Id = usuarioTextField;

        usuarioTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            controller.crearVehiculo_Id.setText(newValue);
        });

        VBox placaField = createLabeledField.create("Placa del Vehículo", new TextField(), "crearVehiculo_Placa");
        TextField placaTextField = (TextField) placaField.getChildren().get(1);
        controller.crearVehiculo_Placa = placaTextField;

        placaTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            controller.crearVehiculo_Placa.setText(newValue);
        });

        controller.setInputsRegistrarVehiculoTab(controller.getInputsRegistrarVehiculoTab());

        
        Button guardarButton = new Button("Guardar");
        guardarButton.setId("crearVehiculo_button");
        guardarButton.setOnAction(e -> controller.procedimiento(controller.registrarVehiculo_Inputs,() -> {
            placa = placaTextField.getText();
            idDueño = Long.parseLong(usuarioTextField.getText());

            vehiculoO = new VehiculoO(placa, idDueño);
            cmgVehiculo.guardar(vehiculoO);
        }));
        controller.crearVehiculo_button = guardarButton;
        guardarButton.setDefaultButton(true);
        guardarButton.setMnemonicParsing(false);
        guardarButton.setCursor(Cursor.HAND);

        
        mainVBox.getChildren().addAll(usuarioField, placaField, guardarButton);

        
        flowPane.getChildren().add(mainVBox);

        
        registrarVehiculoTab.setContent(flowPane);

        return registrarVehiculoTab;
    }
}