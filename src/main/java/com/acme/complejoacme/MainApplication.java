package com.acme.complejoacme;

import Modelo.DataBaseConection;
import Modelo.DAO.CAPersonal.CAPersonalO;
import Modelo.DAO.CAPersonal.CCAPersonal;
import Modelo.DAO.CAVehiculo.CAVehiculoO;
import Modelo.DAO.CAVehiculo.CCAVehiculo;
import Modelo.DAO.EmpPersonal.CMGEPersonal;
import Modelo.DAO.EmpPersonal.EmpPersonalO;
import Modelo.DAO.Empresas.CMEmpresas;
import Modelo.DAO.IPersonal.CMGIPersonal;
import Modelo.DAO.IPersonal.IPersonalO;
import Modelo.DAO.LCEstado.CMGLCEstado;
import Modelo.DAO.LCEstado.LCEstadoO;
import Modelo.DAO.LogRegistros.CMLogRegistros;
import Modelo.DAO.PVisitantes.CMGPVisitantes;
import Modelo.DAO.PVisitantes.PVisitantesO;
import Modelo.DAO.Personal.CMGPersonal;
import Modelo.DAO.Personal.PersonalO;
import Modelo.DAO.RPersonal.CMGRPersonal;
import Modelo.DAO.RPersonal.RPersonalO;
import Modelo.DAO.Vehiculo.CMGVehiculo;
import Modelo.DAO.Vehiculo.VehiculoO;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.Date;
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
        PersonalO personal = new PersonalO(263132, "JAVIER", "TAYRONA1", "3012151197", true, "superusuario1", 3);
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

        CMGEPersonal cmgePersonal = CMGEPersonal.getInstance();
        EmpPersonalO empPersonalO = new EmpPersonalO(3123, 1, personal.getId());
        cmgePersonal.mostrar();
        cmgePersonal.guardar(empPersonalO);

        CCAPersonal ccaPersonal = CCAPersonal.getInstance();
        CAPersonalO caPersonalO = new CAPersonalO(312, Timestamp.valueOf("2024-11-10 07:55:00"), Timestamp.valueOf("2024-11-10 17:55:00"), personal.getId());
        ccaPersonal.mostrar();
        ccaPersonal.guardar(caPersonalO);

        CMLogRegistros cmLogRegistros = CMLogRegistros.getInstance();
        cmLogRegistros.mostrar();

        CMGPVisitantes cmgpVisitantes = CMGPVisitantes.getInstance();
        PVisitantesO pVisitantesO = new PVisitantesO(Date.valueOf("2024-11-10"), Date.valueOf("2024-11-22"), personal.getUsuarioSistema(), personal.getId());
        cmgpVisitantes.mostrar();
        cmgpVisitantes.guardar(pVisitantesO);

        CMGRPersonal cmgrPersonal = CMGRPersonal.getInstance();
        RPersonalO rPersonalO = new RPersonalO(32, Date.valueOf("2024-11-01"), personal.getUsuarioSistema(), 1, personal.getId());
        cmgrPersonal.mostrar();
        cmgrPersonal.guardar(rPersonalO);

        CMGLCEstado cmglcEstado = CMGLCEstado.getInstance();
        LCEstadoO lcEstadoO = new LCEstadoO(32, Timestamp.valueOf("2024-05-10 12:55:00"), false, "Hola como estas", personal.getUsuarioSistema(), personal.getId());
        cmglcEstado.mostrar();
        cmglcEstado.guardar(lcEstadoO);

        CMGIPersonal cmgiPersonal = CMGIPersonal.getInstance();
        IPersonalO iPersonalO = new IPersonalO(21, Timestamp.valueOf("2024-05-09 12:55:00"), "Error en la vida", personal.getUsuarioSistema(), 2, personal.getId());
        cmgiPersonal.mostrar();
        cmgiPersonal.guardar(iPersonalO);
    }
}