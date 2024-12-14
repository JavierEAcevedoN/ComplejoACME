package Vista.Manager.Tab;

import Vista.utils.createLabeledField;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class IncidentesTab implements TabBuilder{
    @Override
    public Tab Crear() {
        Tab incidentesTab = new Tab();
        incidentesTab.setText("Incidentes");

        FlowPane flowPane = new FlowPane();
        flowPane.setAlignment(Pos.CENTER);

        VBox vbox = new VBox(20);
        vbox.setAlignment(Pos.CENTER);

        // Contenedor con HBox para seleccionar tipo de incidente y personal implicado
        HBox hbox1 = new HBox(20);
        hbox1.setAlignment(Pos.CENTER);
        hbox1.getChildren().addAll(createLabeledField.create("Seleccionar Incidente", new ChoiceBox<>()),
                createLabeledField.create("Identificador del personal Implicado", new TextField()));

        // Contenedor con HBox para la descripción del suceso
        HBox hbox2 = new HBox();
        hbox2.setAlignment(Pos.CENTER);
        hbox2.getChildren().add(createLabeledField.create("Descripción del suceso", new TextArea()));

        // Contenedor con botones para consultar y registrar incidente
        HBox hbox3 = new HBox(30);
        hbox3.setAlignment(Pos.CENTER);
        Button consultaButton = new Button("Consultar Historial");
        consultaButton.setCursor(Cursor.HAND);
        Button registrarButton = new Button("Registrar Incidente");
        registrarButton.setCursor(Cursor.HAND);
        hbox3.getChildren().addAll(consultaButton, registrarButton);

        vbox.getChildren().addAll(hbox1, hbox2, hbox3);
        flowPane.getChildren().add(vbox);
        incidentesTab.setContent(flowPane);

        return incidentesTab;
    }
}
