package Vista.Manager.Tab;

import Vista.utils.createLabeledField;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PermisoTab implements TabBuilder{

    @Override
    public Tab Crear() {
        Tab permisoTab = new Tab();
        permisoTab.setText("Permiso Visitante");

        // Crear el FlowPane
        FlowPane flowPane = new FlowPane();
        flowPane.setVgap(10);

        // Crear VBox principal
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);

        // Crear el primer HBox con el campo de Identificador
        HBox hbox1 = new HBox(10);
        hbox1.setAlignment(Pos.CENTER);
        hbox1.getChildren().add(createLabeledField.create("Identificador", new TextField()));

        // Crear el segundo HBox con las fechas de inicio y fin
        HBox hbox2 = new HBox(25);
        hbox2.setAlignment(Pos.CENTER);
        hbox2.getChildren().addAll(createLabeledField.create("Fecha de inicio", new DatePicker()),
                createLabeledField.create("Fecha de fin", new DatePicker()));

        // Crear el botón Guardar
        HBox hbox3 = new HBox();
        hbox3.setAlignment(Pos.CENTER);
        Button guardarButton = new Button("Guardar");
        guardarButton.setDefaultButton(true);
        guardarButton.setCursor(Cursor.HAND);
        hbox3.getChildren().add(guardarButton);

        // Agregar todos los HBox al VBox principal
        vbox.getChildren().addAll(hbox1, hbox2, hbox3);
        flowPane.getChildren().add(vbox);

        // Agregar el FlowPane a la pestaña
        permisoTab.setContent(flowPane);

        return permisoTab;
    }
}
