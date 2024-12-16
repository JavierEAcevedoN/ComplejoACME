package Vista.Manager.Tab;

import Vista.utils.createLabeledField;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.acme.complejoacme.Manager.ManagerController;

import Modelo.DAO.CAPersonal.CAPersonalO;
import Modelo.DAO.CAPersonal.CCAPersonal;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

public class SalidaPersonalTab implements TabBuilder{
    private CCAPersonal ccaPersonal = CCAPersonal.getInstance();
    private CAPersonalO caPersonalO;
    private Timestamp fechaEntrada, fechaSalida;
    private long idPersonal;

    @Override
    public Tab Crear(ManagerController controller) {
        Tab salidaPersonalTab = new Tab("Salida Personal");
        salidaPersonalTab.setId("salidaPersonal");

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
        VBox identificadorField = createLabeledField.create("Identificador del personal", new TextField(), "salidaPersonal_Id");
        TextField identificadorTextField = (TextField) identificadorField.getChildren().get(1);
        controller.salidaPersonal_Id = identificadorTextField;

        identificadorTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            controller.salidaPersonal_Id.setText(newValue);
        });

        controller.setInputsSalidaPersonalTab(controller.getInputsSalidaPersonalTab());

        // Crear el botón "Registrar Salida"
        Button registrarSalidaButton = new Button("Registrar Salida");
        registrarSalidaButton.setId("salidaPersonal_button");
        registrarSalidaButton.setOnAction(e -> controller.procedimiento(controller.salidaPersonal_Inputs,() -> {
            idPersonal = Long.parseLong(identificadorTextField.getText());
            fechaEntrada = null;
            fechaSalida = Timestamp.valueOf(LocalDateTime.now());
            
            caPersonalO = new CAPersonalO(0, fechaEntrada, fechaSalida, idPersonal);
            ccaPersonal.actualizar(caPersonalO);
        }));
        controller.salidaPersonal_button = registrarSalidaButton;
        registrarSalidaButton.setDefaultButton(true);
        registrarSalidaButton.setMnemonicParsing(false);
        registrarSalidaButton.setCursor(Cursor.HAND);

        // Agregar los elementos al VBox principal
        mainVBox.getChildren().addAll(identificadorField, registrarSalidaButton);

        // Agregar el VBox principal al FlowPane
        flowPane.getChildren().add(mainVBox);

        // Configurar el contenido del Tab
        salidaPersonalTab.setContent(flowPane);

        return salidaPersonalTab;
    }
}