package Vista.Manager.Tab;

import java.util.List;
import java.util.stream.Collectors;

import com.acme.complejoacme.Manager.ManagerController;

import Modelo.DataBaseConection;
import Modelo.DAO.Personal.CMGPersonal;
import Modelo.DAO.Personal.PersonalO;
import Modelo.DAO.Rol.CMRol;
import Vista.utils.createLabeledField;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;

public class RegistrarPersonalTab implements TabBuilder {
    private CMGPersonal personal = CMGPersonal.getInstance();
    private CMRol rol = CMRol.getInstance();
    private String pIdentificacion, pNombre, pDireccion, pContacto, pUsuario, pRol;
    private PersonalO personalO;

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
        VBox direccionField = createLabeledField.create("Dirección de residencia", new TextField(),
                "crearPersonal_Dir");
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
        ChoiceBox<String> rolChoiceBox = new ChoiceBox<>();
        if (!DataBaseConection.getCurrentRole().contains("SUPERUSUARIO")) {
            List<String> listRoles = rol.getLista().stream().map(i -> i.getRol()).distinct().collect(Collectors.toList());
            rolChoiceBox.getItems().setAll(listRoles);
            rolChoiceBox.setValue(listRoles.get(0));
            VBox rolField = createLabeledField.create("Tipo de personal", rolChoiceBox, "crearPersonal_Rol");
            controller.crearPersonal_Rol = rolChoiceBox;

            rolChoiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                controller.crearPersonal_Rol.getSelectionModel().select(newValue);
            });
            rolChoiceBox.setPrefWidth(150);
            GridPane.setHalignment(rolField, HPos.CENTER);
            gridPane.add(rolField, 1, 2);
        }
        

        // Crear Usuario (si no es SUPERVISOR)
        TextField usuarioTextField = new TextField();
        if (DataBaseConection.getCurrentRole().equals("SUPERVISOR") || DataBaseConection.getCurrentRole().contains("SUPERUSUARIO")) {
            VBox usuarioField = createLabeledField.create("Usuario de acceso", usuarioTextField,
                    "crearPersonal_Usuario");
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
        guardarButton.setOnAction(e -> controller.procedimiento(controller.registrarPersonal_Inputs, () -> {
            if (DataBaseConection.getCurrentRole().contains("SUPERUSUARIO")) {
                pRol = "3";
            } else {
                pRol = rol.getLista().stream().filter(i -> i.getRol().equals(rolChoiceBox.getValue())).map(i -> i.getId())
                    .collect(Collectors.toList()).get(0).toString();
            }
            if (DataBaseConection.getCurrentRole().equals("SUPERVISOR")) {
                pUsuario = usuarioTextField.getText();
            } else {
                pUsuario = null;
            }    
            pIdentificacion = identificacionTextField.getText();
            pNombre = nombreTextField.getText();
            pDireccion = direccionTextField.getText();
            pContacto = contactoTextField.getText();
            personalO = new PersonalO(Integer.parseInt(pIdentificacion), pNombre, pDireccion, pContacto, true, pUsuario,
                    Integer.parseInt(pRol));
            personal.guardar(personalO);
        }));
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