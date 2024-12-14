package com.acme.complejoacme.Login;

import Modelo.DataBaseConection;
import javafx.scene.control.TextField;

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
}
