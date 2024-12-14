package com.acme.complejoacme.Login;

import Modelo.DataBaseConection;
import Vista.utils.Alerts.AlertaLogin;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public abstract class AbstractLoginController {
    public TextField dbadress;

    public TextField dbport;

    public TextField user;

    public PasswordField pass;

    public Button cancel;

    public Button conect;

    protected TextField[] inputs;

    public void close() {
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }

    public void Conect() {
        boolean Ok = validarInputs();

        if (Ok) {
            Ok = dbconection();

            Stage stage = (Stage) user.getScene().getWindow();

            if (Ok) {
                AlertaLogin.Info();
                stage.close();
            } else {
                AlertaLogin.Error();
            }
        } else {
            AlertaLogin.Ad();
        }
    };

    public abstract boolean validarInputs();

    public abstract boolean dbconection();
}