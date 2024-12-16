package Vista.Manager.Tab;

import Vista.utils.Alerts.AlertaTab;
import Vista.utils.createLabeledField;
import com.acme.complejoacme.Manager.ManagerController;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class LevantarRestriccionTab implements TabBuilder{
    @Override
    public Tab Crear(ManagerController controller) {
        Tab levantarRestTab = new Tab();
        levantarRestTab.setText("Levantar Restriccion");

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

        // Crear el VBox con un TextField para el identificador
        VBox vbox1 = createLabeledField.create("Identificador del personal Restringido", new TextField(), "levantarRest_Id");
        TextField levantarRestIdTextField = (TextField) vbox1.getChildren().get(1);
        controller.levantarRest_Id = levantarRestIdTextField;

        levantarRestIdTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            controller.levantarRest_Id.setText(newValue);
        });
        vbox1.setPrefHeight(100.0);
        vbox1.setPrefWidth(188.0);

        firstHBox.getChildren().add(vbox1);

        // Crear el segundo HBox con VBox para la justificación
        HBox secondHBox = new HBox();
        secondHBox.setAlignment(Pos.CENTER);
        secondHBox.setPrefHeight(175.0);
        secondHBox.setPrefWidth(450.0);

        VBox vbox2 = new VBox();
        vbox2.setAlignment(Pos.CENTER_LEFT);
        vbox2.setPrefHeight(144.0);
        vbox2.setPrefWidth(450.0);
        vbox2.setSpacing(8.0);

        Label justificacionLabel = new Label("Justificacion del levantamiento");
        justificacionLabel.setWrapText(true);

        TextArea textArea = new TextArea();
        textArea.setId("levantarRest_Desc");
        controller.levantarRest_Desc = textArea;

        textArea.textProperty().addListener((observable, oldValue, newValue) -> {
            controller.levantarRest_Desc.setText(newValue);
        });

        textArea.setPrefHeight(101.0);
        textArea.setPrefWidth(450.0);

        vbox2.getChildren().addAll(justificacionLabel, textArea);

        secondHBox.getChildren().add(vbox2);

        controller.setInputsLevantarRestriccionTab(controller.getInputsLevantarRestriccionTab());

        // Crear el botón
        Button buttonLevantar = new Button("Levantar Restriccion");
        buttonLevantar.setId("levantarRest_button");
        buttonLevantar.setOnAction(e -> controller.procedimiento(controller.levantarRestriccion_Inputs,() -> {
            AlertaTab.Test();}));
        controller.levantarRest_button = buttonLevantar;
        buttonLevantar.setDefaultButton(true);
        buttonLevantar.setMnemonicParsing(false);
        buttonLevantar.setPrefWidth(104.0);
        buttonLevantar.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        buttonLevantar.setWrapText(true);
        buttonLevantar.setCursor(javafx.scene.Cursor.HAND);

        // Agregar los HBox y el botón al VBox principal
        mainVBox.getChildren().addAll(firstHBox, secondHBox, buttonLevantar);

        // Agregar el VBox al FlowPane
        flowPane.getChildren().add(mainVBox);

        // Establecer el contenido del Tab
        levantarRestTab.setContent(flowPane);

        return levantarRestTab;
    }
}