package com.acme.complejoacme;

import Modelo.DataBaseConection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        System.out.println("Ejecutando programa...");
//        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("creatorRole.fxml"));
//        Scene scene = new Scene(fxmlLoader.load());
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
    }
}