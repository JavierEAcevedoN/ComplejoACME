package Vista.Manager.Tab;

import Vista.utils.Alerts.AlertaTab;
import Vista.utils.createLabeledField;
import com.acme.complejoacme.Manager.ManagerController;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

public class CrearUsuarioTab implements TabBuilder{
    @Override
    public Tab Crear(ManagerController controller) {
        Tab crearUsuarioTab = new Tab("Crear Usuario");
        crearUsuarioTab.setId("crearUsuario");

        FlowPane content = new FlowPane();
        content.setAlignment(Pos.CENTER);
        content.setColumnHalignment(HPos.CENTER);
        content.setPrefSize(200, 200);
        content.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        VBox form = new VBox();
        form.setAlignment(Pos.CENTER_RIGHT);
        form.setSpacing(40.0);
        form.setPrefSize(280.0, 541.0);


        VBox empresaSection = createLabeledField.create("Empresa", new ChoiceBox<>(), "crearUsuario_Empresa");
        ChoiceBox<?> empresaChoiceBox = (ChoiceBox<?>) empresaSection.getChildren().get(1);

        controller.crearUsuario_Empresa = empresaChoiceBox;
        controller.crearUsuario_Empresa.setPrefWidth(200);

        empresaChoiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            controller.crearUsuario_Empresa.setValue(newValue);
        });

        VBox rolSection = createLabeledField.create("Rol del usuario", new ChoiceBox<>(), "crearUsuario_Rol");
        ChoiceBox<?> rolChoiceBox = (ChoiceBox<?>) rolSection.getChildren().get(1);

        controller.crearUsuario_Rol = rolChoiceBox;
        controller.crearUsuario_Rol.setPrefWidth(200);

        rolChoiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            controller.crearUsuario_Rol.setValue(newValue);
        });


        VBox usuarioSection = createLabeledField.create("Usuario", new TextField(), "crearUsuario_Usuario");

        TextField text = (TextField) usuarioSection.getChildren().get(1);
        controller.crearUsuario_Usuario = text;
        text.textProperty().addListener((observable, oldValue, newValue) -> {

            controller.crearUsuario_Usuario.setText(newValue);
        });


        VBox contrasenaSection = createLabeledField.create("Contraseña", new PasswordField(), "crearUsuario_Pass");
        PasswordField passField = (PasswordField) contrasenaSection.getChildren().get(1);

        controller.crearUsuario_Pass = passField;

        passField.textProperty().addListener((observable, oldValue, newValue) -> {

            controller.crearUsuario_Pass.setText(newValue);
        });

        controller.setInputsCrearUsuarioTab(controller.getInputsCrearUsuarioTab());


        // Guardar Button
        Button guardarButton = new Button("Guardar");
        guardarButton.setId("crearUsuario_button");
        guardarButton.setOnAction(e -> controller.procedimiento(controller.crearUsuario_Inputs,() -> {
            AlertaTab.Test();}));
        controller.crearUsuario_button = guardarButton;
        guardarButton.setDefaultButton(true);
        guardarButton.setMnemonicParsing(false);
        guardarButton.setCursor(Cursor.HAND);

        form.getChildren().addAll(empresaSection, rolSection, usuarioSection, contrasenaSection, guardarButton);
        content.getChildren().add(form);
        crearUsuarioTab.setContent(content);

        return crearUsuarioTab;
    }
}