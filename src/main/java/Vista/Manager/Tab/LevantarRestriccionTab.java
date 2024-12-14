package Vista.Manager.Tab;

import Vista.utils.createLabeledField;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class LevantarRestriccionTab implements TabBuilder{
    @Override
    public Tab Crear() {
        Tab levantarRestTab = new Tab();
        levantarRestTab.setText("Levantar Restricción");

        FlowPane flowPane = new FlowPane();
        flowPane.setAlignment(Pos.CENTER);

        VBox vbox = new VBox(20);
        vbox.setAlignment(Pos.CENTER);

        // Contenedor con TextField para el personal restringido y TextArea para la justificación
        HBox hbox1 = new HBox(20);
        hbox1.setAlignment(Pos.CENTER);
        hbox1.getChildren().addAll(createLabeledField.create("Identificador del personal Restringido", new TextField()));

        HBox hbox2 = new HBox();
        hbox2.setAlignment(Pos.CENTER);
        hbox2.getChildren().add(createLabeledField.create("Justificación del levantamiento", new TextArea()));

        // Botón para levantar la restricción
        Button levantarButton = new Button("Levantar Restricción");
        levantarButton.setCursor(Cursor.HAND);

        vbox.getChildren().addAll(hbox1, hbox2, levantarButton);
        flowPane.getChildren().add(vbox);
        levantarRestTab.setContent(flowPane);

        return levantarRestTab;
    }
}
