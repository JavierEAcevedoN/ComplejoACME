package Vista.Manager.Tab;

import Vista.utils.createLabeledField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import com.acme.complejoacme.Manager.ManagerController;

import Modelo.DataBaseConection;
import Modelo.DAO.Empresas.CMEmpresas;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

public class CrearUsuarioTab implements TabBuilder{
    private CMEmpresas empresas = CMEmpresas.getInstance();
    private String sRol, sEmpresa, sUsuario, sPassword;
    private static Connection conexionBD;

    @Override
    public Tab Crear(ManagerController controller) {
        Tab crearUsuarioTab;
        if (DataBaseConection.getCurrentRole().contains("SUPERUSUARIO")) {
            crearUsuarioTab = new Tab("Crear Supervisor");
        } else {
            crearUsuarioTab = new Tab("Crear Usuario");
        }
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


        ChoiceBox<String> empresaChoiceBox = new ChoiceBox<>();
        List<String> listEmpresas = empresas.getLista().stream().map(i -> i.getNombre()).collect(Collectors.toList());
        empresaChoiceBox.getItems().setAll(listEmpresas);
        empresaChoiceBox.setValue(listEmpresas.get(0));
        VBox empresaSection = createLabeledField.create("Empresa", empresaChoiceBox, "crearUsuario_Empresa");

        controller.crearUsuario_Empresa = empresaChoiceBox;
        controller.crearUsuario_Empresa.setPrefWidth(200);

        empresaChoiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            controller.crearUsuario_Empresa.setValue(newValue);
        });

        ChoiceBox<String> rolChoiceBox = new ChoiceBox<>();
        rolChoiceBox.getItems().setAll("GUARDA","FUNCIONARIO");
        rolChoiceBox.setValue("FUNCIONARIO");
        VBox rolSection = createLabeledField.create("Rol del usuario", rolChoiceBox, "crearUsuario_Rol");

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
            if (DataBaseConection.getCurrentRole().contains("SUPERUSUARIO")) {
                sEmpresa = listEmpresas.get(0);
                sRol = "SUPERVISOR";
            } else {
                sEmpresa = empresaChoiceBox.getValue();
                sRol = rolChoiceBox.getValue();
            }
            sUsuario = text.getText();
            sPassword = passField.getText();
            conexionBD = DataBaseConection.getConexionDB();
                try {
                    PreparedStatement pst = conexionBD.prepareStatement("call creausuario(?,?,?,?)");
                    pst.setString(1, sUsuario);
                    pst.setString( 2, DataBaseConection.getCurrentHost());
                    pst.setString( 3, sPassword);
                    pst.setString( 4, sRol);
                    pst.execute();
                } catch (SQLException i) {
                    System.err.println("Error al crear el usuario: " + i.getMessage());
                }
        }));
        controller.crearUsuario_button = guardarButton;
        guardarButton.setDefaultButton(true);
        guardarButton.setMnemonicParsing(false);
        guardarButton.setCursor(Cursor.HAND);

        if (DataBaseConection.getCurrentRole().contains("SUPERUSUARIO")) {
            form.getChildren().addAll(usuarioSection, contrasenaSection, guardarButton);
        } else {
            form.getChildren().addAll(empresaSection, rolSection, usuarioSection, contrasenaSection, guardarButton);
        }
        content.getChildren().add(form);
        crearUsuarioTab.setContent(content);

        return crearUsuarioTab;
    }
}