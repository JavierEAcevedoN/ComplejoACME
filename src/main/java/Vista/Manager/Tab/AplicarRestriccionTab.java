package Vista.Manager.Tab;

import Vista.utils.Alerts.AlertaTab;
import Vista.utils.createLabeledField;
import com.acme.complejoacme.Manager.ManagerController;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AplicarRestriccionTab implements TabBuilder{
    @Override
    public Tab Crear(ManagerController controller) {
        Tab aplicarRestTab = new Tab();
        aplicarRestTab.setText("Aplicar Restriccion");

        // Crear el FlowPane y su contenido
        FlowPane flowPane = new FlowPane();
        flowPane.setAlignment(Pos.CENTER);

        // Crear el VBox principal con las dimensiones y espaciado
        VBox mainVBox = new VBox();
        mainVBox.setPrefHeight(540.0);
        mainVBox.setPrefWidth(257.0);
        mainVBox.setSpacing(20.0);
        mainVBox.setAlignment(Pos.CENTER);

        // Crear el primer VBox con un ChoiceBox
        VBox vbox1 = createLabeledField.create("Seleccionar Restriccion", new ChoiceBox<>(), "aplicarRest_Tipo");
        vbox1.setPrefHeight(100.0);
        vbox1.setPrefWidth(327.0);

        ChoiceBox<?> aplicarRestTipoChoiceBox = (ChoiceBox<?>) vbox1.getChildren().get(1);

        controller.aplicarRest_Tipo = aplicarRestTipoChoiceBox;

        aplicarRestTipoChoiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            controller.aplicarRest_Tipo.setValue(newValue);
        });

        VBox vbox2 = createLabeledField.create("Identificador del personal a Restringir", new TextField(), "aplicarRest_Id");
        vbox2.setPrefHeight(100.0);
        vbox2.setPrefWidth(176.0);

        TextField aplicarRestIdTextField = (TextField) vbox2.getChildren().get(1);

        controller.aplicarRest_Id = aplicarRestIdTextField;

        aplicarRestIdTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            controller.aplicarRest_Id.setText(newValue);
        });


        controller.setInputsAplicarRestriccionTab(controller.getInputsAplicarRestriccionTab());
        controller.setInputsConsultarRestricciones(controller.getInputsConsultarRestricciones());

        // Crear el HBox con los botones
        HBox hboxButtons = new HBox();
        hboxButtons.setAlignment(Pos.CENTER);
        hboxButtons.setSpacing(30.0);

        Button buttonConsulta = new Button("Consultar Historial");
        buttonConsulta.setId("aplicarRest_buttonConsulta");
        buttonConsulta.setOnAction(e -> controller.procedimiento(controller.consultarRestriccion_Inputs,() -> {AlertaTab.Test();}));
        controller.aplicarRest_buttonConsulta = buttonConsulta;
        buttonConsulta.setDefaultButton(true);
        buttonConsulta.setMnemonicParsing(false);
        buttonConsulta.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        buttonConsulta.setWrapText(true);
        buttonConsulta.setCursor(javafx.scene.Cursor.HAND);

        Button buttonRestringir = new Button("Aplicar Restriccion");
        buttonRestringir.setId("aplicarRest_buttonRestringir");
        buttonRestringir.setOnAction(e -> controller.procedimiento(controller.aplicarRestriccion_Inputs,() -> {
            AlertaTab.Test();}));
        controller.aplicarRest_buttonRestringir = buttonRestringir;
        buttonRestringir.setMnemonicParsing(false);
        buttonRestringir.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        buttonRestringir.setWrapText(true);
        buttonRestringir.setCursor(javafx.scene.Cursor.HAND);

        hboxButtons.getChildren().addAll(buttonConsulta, buttonRestringir);

        // Agregar los VBox y HBox al VBox principal
        mainVBox.getChildren().addAll(vbox1, vbox2, hboxButtons);

        // Agregar el VBox al FlowPane
        flowPane.getChildren().add(mainVBox);

        // Establecer el contenido del Tab
        aplicarRestTab.setContent(flowPane);

        return aplicarRestTab;
    }
}