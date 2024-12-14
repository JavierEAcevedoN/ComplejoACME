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
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
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
//        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("creatorRole.fxml"));
//        Scene scene = new Scene(fxmlLoader.load());
        AnchorPane loader = DataBaseConection.ejecutarConexion();
        startScene(loader,stage);
    }

    public static void startScene(Parent element, Stage stage) {
        Scene scene = new Scene(element);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void startScene(Parent element) {
        Scene scene = element.getScene();
        Stage stage;

        if (scene == null) {
            stage = new Stage();
        } else {
            stage = (Stage) scene.getWindow();
        }

        stage.initStyle(StageStyle.UNDECORATED);
        stage.setResizable(false);
        stage.setScene(new Scene(element));
        stage.show();
    }


    public static void main(String[] args) {
        launch();

        // Prueva
        CMGPersonal cmgPersonal = CMGPersonal.getInstance();
        PersonalO personal = new PersonalO(263132, "JAVIER", "TAYRONA1", "3012151197", true, "superusuario1", 3);
        cmgPersonal.mostrarF(i -> i.getRol().equals("Guarda"));
        // cmgPersonal.guardar(personal);

        CMGVehiculo cmgVehiculo = CMGVehiculo.getInstance();
        VehiculoO vehiculo = new VehiculoO("FDETRE543421EQ", personal.getId());
        cmgVehiculo.mostrarF(i -> i.getPlaca().equals("YZA567"));
        // cmgVehiculo.guardar(vehiculo);

        CCAVehiculo ccaVehiculo = CCAVehiculo.getInstance();
        CAVehiculoO caVehiculo = new CAVehiculoO(231, Timestamp.valueOf("2024-11-10 07:55:00"), Timestamp.valueOf("2024-11-10 17:55:00"), vehiculo.getPlaca());
        ccaVehiculo.mostrarF(i -> i.getPlaca().getDueño().getDireccion().equals("Calle Sol 707"));
        // ccaVehiculo.guardar(caVehiculo);

        CMEmpresas cmEmpresas = CMEmpresas.getInstance();
        cmEmpresas.mostrarF(i -> i.getNombre().equals("ACME Security"));

        CMGEPersonal cmgePersonal = CMGEPersonal.getInstance();
        EmpPersonalO empPersonalO = new EmpPersonalO(3123, 1, personal.getId());
        cmgePersonal.mostrarF(i -> i.getPersonalM().getNombre().equals("Ana Lopez"));
        // cmgePersonal.guardar(empPersonalO);

        CCAPersonal ccaPersonal = CCAPersonal.getInstance();
        CAPersonalO caPersonalO = new CAPersonalO(312, Timestamp.valueOf("2024-11-10 07:55:00"), Timestamp.valueOf("2024-11-10 17:55:00"), personal.getId());
        ccaPersonal.mostrarF(i -> i.getPersonal().getContacto().equals("654987123"));
        // ccaPersonal.guardar(caPersonalO);

        CMLogRegistros cmLogRegistros = CMLogRegistros.getInstance();
        cmLogRegistros.mostrarF(i -> i.getUsuarioCreador().getUsuarioSistema().equals("funcionario1"));

        CMGPVisitantes cmgpVisitantes = CMGPVisitantes.getInstance();
        PVisitantesO pVisitantesO = new PVisitantesO(Date.valueOf("2024-11-10"), Date.valueOf("2024-11-22"), personal.getUsuarioSistema(), personal.getId());
        cmgpVisitantes.mostrarF(i -> i.getFechaFin().equals(Date.valueOf("2024-11-07")));
        // cmgpVisitantes.guardar(pVisitantesO);

        CMGRPersonal cmgrPersonal = CMGRPersonal.getInstance();
        RPersonalO rPersonalO = new RPersonalO(32, Date.valueOf("2024-11-01"), personal.getUsuarioSistema(), 1, personal.getId());
        cmgrPersonal.mostrarF(i -> i.getRestriccionS().equals("Prohibición acceso: 1 año"));
        // cmgrPersonal.guardar(rPersonalO);

        CMGLCEstado cmglcEstado = CMGLCEstado.getInstance();
        LCEstadoO lcEstadoO = new LCEstadoO(32, Timestamp.valueOf("2024-05-10 12:55:00"), false, "Hola como estas", personal.getUsuarioSistema(), personal.getId());
        cmglcEstado.mostrarF(i -> i.getFecha().equals(Timestamp.valueOf("2024-11-09 17:30:00")));
        // cmglcEstado.guardar(lcEstadoO);

        CMGIPersonal cmgiPersonal = CMGIPersonal.getInstance();
        IPersonalO iPersonalO = new IPersonalO(21, Timestamp.valueOf("2024-05-09 12:55:00"), "Error en la vida", personal.getUsuarioSistema(), 2, personal.getId());
        cmgiPersonal.mostrarF(i -> i.getIncidente().equals("Robo menor"));
        // cmgiPersonal.guardar(iPersonalO);
    }
}