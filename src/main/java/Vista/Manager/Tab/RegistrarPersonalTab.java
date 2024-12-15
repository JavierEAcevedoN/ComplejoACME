package Vista.Manager.Tab;

import Modelo.DataBaseConection;
import Vista.utils.Alerts.AlertaTab;
import Vista.utils.createLabeledField;
import com.acme.complejoacme.Manager.ManagerController;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;

public class RegistrarPersonalTab implements TabBuilder{

    @Override
    public Tab Crear(ManagerController controller) {
        Tab registrarPersonalTab = new Tab("Registrar Personal");
        registrarPersonalTab.setId("crearPersonal");

        // Crear el FlowPane principal
        FlowPane flowPane = new FlowPane();
        flowPane.setAlignment(Pos.CENTER);
        flowPane.setColumnHalignment(HPos.CENTER);
        flowPane.setHgap(20.0);
        flowPane.setPrefWrapLength(10.0);

        // Crear el GridPane
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPrefSize(491, 541);

        // Configurar columnas
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setHgrow(Priority.SOMETIMES);
        col1.setMinWidth(10);
        col1.setPrefWidth(100);

        ColumnConstraints col2 = new ColumnConstraints();
        col2.setHgrow(Priority.SOMETIMES);
        col2.setMinWidth(10);
        col2.setPrefWidth(100);

        gridPane.getColumnConstraints().addAll(col1, col2);

        // Configurar filas
        for (int i = 0; i < 4; i++) {
            RowConstraints row = new RowConstraints();
            row.setVgrow(Priority.SOMETIMES);
            row.setMinHeight(10);
            row.setPrefHeight(30);
            gridPane.getRowConstraints().add(row);
        }

        // Crear los campos etiquetados
        // Crear Identificación
        VBox identificacionField = createLabeledField.create("Identificación", new TextField(), "crearPersonal_Id");
        TextField identificacionTextField = (TextField) identificacionField.getChildren().get(1);
        controller.crearPersonal_Id = identificacionTextField;

        identificacionTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            controller.crearPersonal_Id.setText(newValue);
        });
        GridPane.setHalignment(identificacionField, HPos.CENTER);
        gridPane.add(identificacionField, 0, 0);

// Crear Nombre
        VBox nombreField = createLabeledField.create("Nombre de la persona", new TextField(), "crearPersonal_Nombre");
        TextField nombreTextField = (TextField) nombreField.getChildren().get(1);
        controller.crearPersonal_Nombre = nombreTextField;

        nombreTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            controller.crearPersonal_Nombre.setText(newValue);
        });
        GridPane.setHalignment(nombreField, HPos.CENTER);
        gridPane.add(nombreField, 1, 0);

// Crear Dirección
        VBox direccionField = createLabeledField.create("Dirección de residencia", new TextField(), "crearPersonal_Dir");
        TextField direccionTextField = (TextField) direccionField.getChildren().get(1);
        controller.crearPersonal_Dir = direccionTextField;

        direccionTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            controller.crearPersonal_Dir.setText(newValue);
        });
        GridPane.setHalignment(direccionField, HPos.CENTER);
        gridPane.add(direccionField, 0, 1);

// Crear Contacto
        VBox contactoField = createLabeledField.create("Contacto Telefónico", new TextField(), "crearPersonal_Cont");
        TextField contactoTextField = (TextField) contactoField.getChildren().get(1);
        controller.crearPersonal_Cont = contactoTextField;

        contactoTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            controller.crearPersonal_Cont.setText(newValue);
        });
        GridPane.setHalignment(contactoField, HPos.CENTER);
        gridPane.add(contactoField, 1, 1);

// Crear Rol
        VBox rolField = createLabeledField.create("Tipo de personal", new ChoiceBox<>(), "crearPersonal_Rol");
        ChoiceBox<?> rolChoiceBox = (ChoiceBox<?>) rolField.getChildren().get(1);
        controller.crearPersonal_Rol = rolChoiceBox;

        rolChoiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            controller.crearPersonal_Rol.getSelectionModel().select(newValue);
        });
        rolChoiceBox.setPrefWidth(150);
        GridPane.setHalignment(rolField, HPos.CENTER);
        gridPane.add(rolField, 1, 2);

// Crear Usuario (si no es SUPERVISOR)
        if (!DataBaseConection.getCurrentRole().equals("SUPERVISOR")) {
            VBox usuarioField = createLabeledField.create("Usuario de acceso", new TextField(), "crearPersonal_Usuario");
            TextField usuarioTextField = (TextField) usuarioField.getChildren().get(1);
            controller.crearPersonal_Usuario = usuarioTextField;

            usuarioTextField.setPromptText("Usuario del sistema existente");
            usuarioTextField.textProperty().addListener((observable, oldValue, newValue) -> {
                controller.crearPersonal_Usuario.setText(newValue);
            });
            GridPane.setHalignment(usuarioField, HPos.CENTER);
            gridPane.add(usuarioField, 0, 2);
        }

        controller.setInputsRegistrarPersonalTab(controller.getInputsRegistrarPersonalTab());

        // Crear el botón "Guardar"
        Button guardarButton = new Button("Guardar");
        guardarButton.setId("crearPersonal_button");
        guardarButton.setOnAction(e -> controller.procedimiento(controller.registrarPersonal_Inputs,() -> {
            AlertaTab.Test();}));
        controller.crearPersonal_button = guardarButton;
        guardarButton.setDefaultButton(true);
        guardarButton.setMnemonicParsing(false);
        guardarButton.setCursor(Cursor.HAND);
        GridPane.setHalignment(guardarButton, HPos.CENTER);
        gridPane.add(guardarButton, 1, 3);

        // Agregar el GridPane al FlowPane
        flowPane.getChildren().add(gridPane);

        // Configurar el contenido del Tab
        registrarPersonalTab.setContent(flowPane);

        return registrarPersonalTab;
    }
}