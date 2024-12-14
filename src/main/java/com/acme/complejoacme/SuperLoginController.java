package com.acme.complejoacme;

import Modelo.DataBaseConection;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SuperLoginController extends AbstractLoginController {

    @Override
    public boolean validarInputs() {
        boolean Ok = true;
        inputs = new TextField[]{dbadress,dbport,user, pass};
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
            String ruta = "jdbc:mysql://" + dbadress.getText() + ":" + dbport.getText() + "/";
            Ok = DataBaseConection.actualizarConexion(ruta, user.getText(), pass.getText());

            Stage stage = (Stage) user.getScene().getWindow();

            if (Ok) {
                alert.setAlertType(Alert.AlertType.INFORMATION);
                alert.setTitle("Enhorabuena");
                alert.setHeaderText("Conexión exítosa");
                alert.setContentText("Será redirigído a la ventana del superusuario.");
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