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

public class AccesoPersonalTab implements TabBuilder{
    private CCAPersonal ccaPersonal = CCAPersonal.getInstance();
    private static CAPersonalO caPersonalO;
    private Timestamp fechaEntrada, fechaSalida;
    private long idPersonal;

    public static CAPersonalO getCaPersonalO() {
        return caPersonalO;
    }

    @Override
    public Tab Crear(ManagerController controller) {
        // Crear el Tab
        Tab accesoPersonalTab = new Tab("Acceso Personal");
        accesoPersonalTab.setId("accesoPersonal");

        // Crear el FlowPane principal
        FlowPane flowPane = new FlowPane();
        flowPane.setAlignment(Pos.CENTER);
        flowPane.setColumnHalignment(HPos.CENTER);

        // Crear el VBox principal
        VBox mainVBox = new VBox();
        mainVBox.setAlignment(Pos.CENTER);
        mainVBox.setPrefSize(230, 540);
        mainVBox.setSpacing(20);

        VBox identificadorField = createLabeledField.create("Identificador del personal", new TextField(), "accesoPersonal_Id");

        TextField identificadorTextField = (TextField) identificadorField.getChildren().get(1);

        controller.accesoPersonal_Id = identificadorTextField;

        identificadorTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            controller.accesoPersonal_Id.setText(newValue);
        });

        controller.setInputsAccesoPersonalTab(controller.getInputsAccesoPersonalTab());

        // Crear el botón "Permitir acceso"
        Button permitirAccesoButton = new Button("Permitir acceso");
        permitirAccesoButton.setId("accesoPersonal_button");
        permitirAccesoButton.setOnAction(e -> controller.procedimiento(controller.accesoPersonal_Inputs,() -> {
            idPersonal = Long.parseLong(identificadorTextField.getText());
            fechaEntrada = Timestamp.valueOf(LocalDateTime.now());
            fechaSalida = null;
            
            caPersonalO = new CAPersonalO(0, fechaEntrada, fechaSalida, idPersonal);
            ccaPersonal.guardar(caPersonalO);
        }));
        controller.accesoPersonal_button = permitirAccesoButton;

        permitirAccesoButton.setDefaultButton(true);
        permitirAccesoButton.setMnemonicParsing(false);
        permitirAccesoButton.setCursor(Cursor.HAND);

        // Agregar los elementos al VBox principal
        mainVBox.getChildren().addAll(identificadorField, permitirAccesoButton);

        // Agregar el VBox principal al FlowPane
        flowPane.getChildren().add(mainVBox);

        // Configurar el contenido del Tab
        accesoPersonalTab.setContent(flowPane);

        return accesoPersonalTab;
    }
}