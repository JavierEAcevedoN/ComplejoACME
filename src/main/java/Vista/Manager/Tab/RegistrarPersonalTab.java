package Vista.Manager.Tab;

import Vista.utils.createLabeledField;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class RegistrarPersonalTab implements TabBuilder{

    @Override
    public Tab Crear() {
        Tab registrarPersonalTab = new Tab("Registrar Personal");

        FlowPane personalContent = new FlowPane();
        personalContent.setAlignment(Pos.CENTER);
        personalContent.setHgap(20.0);

        GridPane personalForm = new GridPane();
        personalForm.setAlignment(Pos.CENTER);
        personalForm.setPrefSize(491.0, 541.0);
        personalForm.setHgap(20.0);
        personalForm.setVgap(20.0);

        // Column and Row Constraints
        for (int i = 0; i < 2; i++) {
            personalForm.getColumnConstraints().add(new ColumnConstraints(100.0, 100.0, Double.MAX_VALUE));
        }
        for (int i = 0; i < 4; i++) {
            personalForm.getRowConstraints().add(new RowConstraints(30.0, 30.0, Double.MAX_VALUE));
        }

        // Personal Form Fields
        personalForm.add(createLabeledField.create("Identificacion", new TextField()), 0, 0);
        personalForm.add(createLabeledField.create("Nombre de la persona", new TextField()), 1, 0);
        personalForm.add(createLabeledField.create("Dirección de residencia", new TextField()), 0, 1);
        personalForm.add(createLabeledField.create("Contacto Telefonico", new TextField()), 1, 1);
        personalForm.add(createLabeledField.create("Tipo de personal", new ChoiceBox<>()), 1, 2);
        personalForm.add(createLabeledField.create("Usuario de acceso", new TextField()), 0, 2);

        // Guardar Button
        Button guardarPersonalButton = new Button("Guardar");
        guardarPersonalButton.setDefaultButton(true);
        guardarPersonalButton.setCursor(Cursor.HAND);
        personalForm.add(guardarPersonalButton, 1, 3);

        personalContent.getChildren().add(personalForm);
        registrarPersonalTab.setContent(personalContent);

        return registrarPersonalTab;
    }
}
