package com.acme.complejoacme;

import Modelo.DataBaseConection;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController extends AbstractLoginController{

    @Override
    public boolean validarInputs() {
        boolean Ok = true;
        inputs = new TextField[]{user, pass};
        for (TextField input : inputs) {
            System.out.println(input.getText());
            if (input.getText().isEmpty()) {
                Ok = false;
            }
        }
        return Ok;
    }

    @Override
    public void Conect() {
        boolean Ok = validarInputs();

        Alert alert = new Alert(Alert.AlertType.NONE);

        if (Ok) {
            Ok = DataBaseConection.conectar(DataBaseConection.getRuta(), user.getText(), pass.getText());
            Stage stage = (Stage) user.getScene().getWindow();

            if (Ok) {
                alert.setAlertType(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Enhorabuena");
                alert.setHeaderText("Conexión exítosa");
                alert.setContentText("Será redirigído al inicio de sesión.");
                alert.showAndWait();
                stage.close();
            } else {
                alert.setAlertType(Alert.AlertType.ERROR);
                alert.setTitle("Fallo");
                alert.setHeaderText("Conexión fallída");
                alert.setContentText("Intente nuevamente.");
                alert.showAndWait();
            }
        } else {
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setTitle("Advertencia");
            alert.setHeaderText("Campos incompletos");
            alert.setContentText("Ningún campo puede estar vacío.");
            alert.showAndWait();
        }
    }
}
