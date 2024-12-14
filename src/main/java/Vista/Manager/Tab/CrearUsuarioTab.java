package Vista.Manager.Tab;

import Vista.utils.createLabeledField;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

public class CrearUsuarioTab implements TabBuilder{
    @Override
    public Tab Crear() {
        Tab crearUsuarioTab = new Tab("Crear Usuario");

        FlowPane content = new FlowPane();
        content.setAlignment(Pos.CENTER);

        VBox form = new VBox();
        form.setAlignment(Pos.CENTER_RIGHT);
        form.setSpacing(40.0);
        form.setPrefSize(280.0, 541.0);

        // Empresa Section
        VBox empresaSection = createLabeledField.create("Empresa", new ChoiceBox<>());

        // Rol Section
        VBox rolSection = createLabeledField.create("Rol del usuario", new ChoiceBox<>());

        // Usuario Section
        VBox usuarioSection = createLabeledField.create("Usuario", new TextField());

        // Contraseña Section
        VBox contrasenaSection = createLabeledField.create("Contraseña", new PasswordField());

        // Guardar Button
        Button guardarButton = new Button("Guardar");
        guardarButton.setDefaultButton(true);
        guardarButton.setCursor(Cursor.HAND);

        form.getChildren().addAll(empresaSection, rolSection, usuarioSection, contrasenaSection, guardarButton);
        content.getChildren().add(form);
        crearUsuarioTab.setContent(content);

        return crearUsuarioTab;
    }
}
