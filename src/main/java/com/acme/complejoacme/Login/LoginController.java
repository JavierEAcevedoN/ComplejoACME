package com.acme.complejoacme.Login;

import Modelo.DataBaseConection;
import javafx.scene.control.TextField;

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
    public boolean dbconection() {
        return DataBaseConection.conectar(DataBaseConection.getRuta(), user.getText(), pass.getText());
    }
}
