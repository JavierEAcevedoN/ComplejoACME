package com.acme.complejoacme;

import Modelo.DataBaseConection;
import Modelo.DAO.CAVehiculo.CAVehiculoO;
import Modelo.DAO.CAVehiculo.CCAVehiculo;
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
        CMGVehiculo cmgVehiculo = CMGVehiculo.getInstance();
        VehiculoO a = new VehiculoO("EASDSAD423424", 23);
        cmgVehiculo.mostrar();
        cmgVehiculo.guardar(a);

        CCAVehiculo ccaVehiculo = CCAVehiculo.getInstance();
        CAVehiculoO b = new CAVehiculoO(12, Timestamp.valueOf("2024-11-01 07:10:00.0"), Timestamp.valueOf("2024-11-01 17:10:00.0"),"EASDSAD423424");
        ccaVehiculo.mostrar();
        ccaVehiculo.guardar(b);
    }
}