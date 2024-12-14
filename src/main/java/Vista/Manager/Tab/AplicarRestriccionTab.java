package Vista.Manager.Tab;

import Vista.utils.createLabeledField;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AplicarRestriccionTab implements TabBuilder{
    @Override
    public Tab Crear() {
        Tab aplicarRestTab = new Tab();
        aplicarRestTab.setText("Aplicar Restricción");

        FlowPane flowPane = new FlowPane();
        flowPane.setAlignment(Pos.CENTER);

        VBox vbox = new VBox(20);
        vbox.setAlignment(Pos.CENTER);

        // Contenedor con ChoiceBox para seleccionar restricción y TextField para el personal
        vbox.getChildren().addAll(
                createLabeledField.create("Seleccionar Restricción", new ChoiceBox<>()),
                createLabeledField.create("Identificador del personal a Restringir", new TextField())
        );

        // Botones de consulta y aplicar restricción
        HBox hbox = new HBox(30);
        hbox.setAlignment(Pos.CENTER);
        Button consultaButton = new Button("Consultar Historial");
        consultaButton.setCursor(Cursor.HAND);
        Button aplicarButton = new Button("Aplicar Restricción");
        aplicarButton.setCursor(Cursor.HAND);
        hbox.getChildren().addAll(consultaButton, aplicarButton);

        vbox.getChildren().add(hbox);
        flowPane.getChildren().add(vbox);
        aplicarRestTab.setContent(flowPane);

        return aplicarRestTab;
    }
}
