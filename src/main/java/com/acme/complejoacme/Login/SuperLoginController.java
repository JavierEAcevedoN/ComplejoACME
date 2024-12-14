package com.acme.complejoacme.Login;

import Modelo.DataBaseConection;
import Vista.Login.Login;
import com.acme.complejoacme.MainApplication;
import com.acme.complejoacme.MainController;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

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
    public boolean dbconection() {
        String ruta = "jdbc:mysql://" + dbadress.getText() + ":" + dbport.getText() + "/";
        return DataBaseConection.actualizarConexion(ruta, user.getText(), pass.getText());
    }

    @Override
    public void nextWindow() {
        Login login = Login.create(MainController.Login);
        AnchorPane root = login.withLeftPane().withRightPane().build();
        MainApplication.startScene(root);
    }
}