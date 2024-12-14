package com.acme.complejoacme;

import Modelo.DataBaseConection;
import Modelo.DAO.CAVehiculo.CAVehiculoO;
import Modelo.DAO.CAVehiculo.CCAVehiculo;
import Modelo.DAO.Empresas.CMEmpresas;
import Modelo.DAO.Personal.CMGPersonal;
import Modelo.DAO.Personal.PersonalO;
import Modelo.DAO.Vehiculo.CMGVehiculo;
import Modelo.DAO.Vehiculo.VehiculoO;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.Timestamp;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        System.out.println("Ejecutando programa...");
        AnchorPane loader = DataBaseConection.ejecutarConexion();
        Scene scene = new Scene(loader);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setResizable(false);
        stage.setTitle("ComplejoACME");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();

        // Prueva
        CMGPersonal cmgPersonal = CMGPersonal.getInstance();
        PersonalO personal = new PersonalO(263132, "JAVIER", "TAYRONA1", "3012151197", true, null, 3);
        cmgPersonal.mostrar();
        cmgPersonal.guardar(personal);

        CMGVehiculo cmgVehiculo = CMGVehiculo.getInstance();
        VehiculoO vehiculo = new VehiculoO("FDETRE543421EQ", personal.getId());
        cmgVehiculo.mostrar();
        cmgVehiculo.guardar(vehiculo);

        CCAVehiculo ccaVehiculo = CCAVehiculo.getInstance();
        CAVehiculoO caVehiculo = new CAVehiculoO(231, Timestamp.valueOf("2024-11-10 07:55:00"), Timestamp.valueOf("2024-11-10 17:55:00"), vehiculo.getPlaca());
        ccaVehiculo.mostrar();
        ccaVehiculo.guardar(caVehiculo);

        CMEmpresas cmEmpresas = CMEmpresas.getInstance();
        cmEmpresas.mostrar();
    }
}