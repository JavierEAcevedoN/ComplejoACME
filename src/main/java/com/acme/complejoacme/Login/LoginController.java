package com.acme.complejoacme.Login;

import Modelo.DataBaseConection;
import Vista.Manager.ManagerInvoker;
import com.acme.complejoacme.MainApplication;
import javafx.scene.control.TextField;

public class LoginController extends AbstractLoginController{

    @Override
    public boolean validarInputs() {
        boolean Ok = true;
        inputs = new TextField[]{user, pass};
        for (TextField input : inputs) {
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

    @Override
    public void nextWindow() {
        MainApplication.startScene(ManagerInvoker.getManager("DataBaseConection.getCurrentRole()"));
    }
}