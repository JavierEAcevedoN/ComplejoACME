package Vista.Manager.Tab;

import Vista.utils.Alerts.AlertaTab;
import Vista.utils.createLabeledField;
import com.acme.complejoacme.Manager.ManagerController;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class IncidentesTab implements TabBuilder{
    @Override
    public Tab Crear(ManagerController controller) {
        Tab incidentesTab = new Tab();
        incidentesTab.setText("Incidentes");

        // Crear el FlowPane y su contenido
        FlowPane flowPane = new FlowPane();
        flowPane.setAlignment(Pos.CENTER);

        // Crear el VBox principal con las dimensiones y espaciado
        VBox mainVBox = new VBox();
        mainVBox.setPrefHeight(540.0);
        mainVBox.setPrefWidth(450.0);
        mainVBox.setSpacing(20.0);
        mainVBox.setAlignment(Pos.CENTER);

        // Crear el primer HBox con VBox dentro
        HBox firstHBox = new HBox();
        firstHBox.setAlignment(Pos.CENTER);
        firstHBox.setPrefHeight(100.0);
        firstHBox.setPrefWidth(200.0);
        firstHBox.setSpacing(20.0);

        // Crear el primer VBox con un ChoiceBox
        VBox vbox1 = createLabeledField.create("Seleccionar Incidente", new ChoiceBox<>(), "incidentes_Tipo");
        ChoiceBox<?> incidentesTipoChoiceBox = (ChoiceBox<?>) vbox1.getChildren().get(1);
        controller.incidentes_Tipo = incidentesTipoChoiceBox;
        vbox1.setPrefHeight(100.0);
        vbox1.setPrefWidth(201.0);

        incidentesTipoChoiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            controller.incidentes_Tipo.setValue(newValue);
        });

        VBox vbox2 = createLabeledField.create("Identificador del personal Implicado", new TextField(), "incidentes_Id");
        TextField incidentesIdTextField = (TextField) vbox2.getChildren().get(1);
        controller.incidentes_Id = incidentesIdTextField;
        vbox2.setPrefHeight(100.0);
        vbox2.setPrefWidth(176.0);

        incidentesIdTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            controller.incidentes_Id.setText(newValue);
        });


        // Agregar los VBox a la primera HBox
        firstHBox.getChildren().addAll(vbox1, vbox2);

        // Crear el segundo HBox con un TextArea dentro
        HBox secondHBox = new HBox();
        secondHBox.setAlignment(Pos.CENTER);
        secondHBox.setPrefHeight(175.0);
        secondHBox.setPrefWidth(450.0);

        VBox vbox3 = new VBox();
        vbox3.setSpacing(8.0);
        vbox3.setAlignment(Pos.CENTER_LEFT);
        vbox3.setPrefHeight(144.0);
        vbox3.setPrefWidth(450.0);

        Label descripcionLabel = new Label("Descripcion del suceso");
        descripcionLabel.setWrapText(true);

        TextArea textArea = new TextArea();
        textArea.setId("incidentes_Desc");
        controller.incidentes_Desc = textArea;
        textArea.setPrefHeight(101.0);
        textArea.setPrefWidth(450.0);

        textArea.textProperty().addListener((observable, oldValue, newValue) -> {
            controller.incidentes_Desc.setText(newValue);
        });

        vbox3.getChildren().addAll(descripcionLabel, textArea);

        secondHBox.getChildren().add(vbox3);

        controller.setInputsIncidentesTab(controller.getInputsIncidentesTab());
        controller.setInputsConsultarIncidentes(controller.getInputsConsultarIncidentes());

        // Crear el tercer HBox con los botones
        HBox thirdHBox = new HBox();
        thirdHBox.setAlignment(Pos.CENTER);
        thirdHBox.setSpacing(30.0);

        Button buttonConsulta = new Button("Consultar Historial");
        buttonConsulta.setId("incidentes_buttonConsulta");
        buttonConsulta.setOnAction(e -> controller.procedimiento(controller.consultarIncidentes_Inputs,() -> {AlertaTab.Test();}));
        controller.incidentes_buttonConsulta = buttonConsulta;
        buttonConsulta.setDefaultButton(true);
        buttonConsulta.setMnemonicParsing(false);
        buttonConsulta.setCursor(javafx.scene.Cursor.HAND);

        Button buttonRegistrar = new Button("Registrar Incidente");
        buttonRegistrar.setId("incidentes_buttonRegistrar");
        buttonRegistrar.setOnAction(e -> controller.procedimiento(controller.incidentes_Inputs,() -> {
            AlertaTab.Test();}));
        controller.incidentes_buttonRegistrar = buttonRegistrar;
        buttonRegistrar.setMnemonicParsing(false);
        buttonRegistrar.setCursor(javafx.scene.Cursor.HAND);

        thirdHBox.getChildren().addAll(buttonConsulta, buttonRegistrar);

        mainVBox.getChildren().addAll(firstHBox, secondHBox, thirdHBox);

        flowPane.getChildren().add(mainVBox);

        incidentesTab.setContent(flowPane);

        return incidentesTab;
    }
}