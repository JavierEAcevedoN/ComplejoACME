package com.acme.complejoacme;

import Modelo.DataBaseConection;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class MainApplication extends Application {
    private static Stage primaryStage;

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        System.out.println("Ejecutando programa...");
        AnchorPane loader = DataBaseConection.ejecutarConexion();
        startScene(loader, stage);
    }

    public static void restartApplication() {
        if (primaryStage != null) {
            primaryStage.close();
        }
        Stage newStage = new Stage();
        System.out.println("Reiniciando programa...");
        AnchorPane loader = DataBaseConection.ejecutarConexion();
        startScene(loader, newStage);
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

    public static void startScene(Parent element, Stage stage) {
        Scene scene = new Scene(element);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void startNormalScene(Parent element) {
        Scene scene = element.getScene();
        Stage stage;

        if (scene == null) {
            stage = new Stage();
        } else {
            stage = (Stage) scene.getWindow();
        }
        stage.setTitle("Consulta");

        stage.setResizable(false);
        stage.setScene(new Scene(element));
        stage.show();
    }

    public static void startNormalScene(Parent element, Stage stage) {
        stage.setTitle("Consulta");
        Scene scene = new Scene(element);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}