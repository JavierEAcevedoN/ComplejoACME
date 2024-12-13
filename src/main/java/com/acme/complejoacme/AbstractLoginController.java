package com.acme.complejoacme;

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

    public abstract boolean validarInputs();

    public abstract void Conect();
}