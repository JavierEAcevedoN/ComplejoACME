package Vista.Manager.Tab;

import com.acme.complejoacme.Manager.ManagerController;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AccesosTab implements TabBuilder{

    @Override
    public Tab Crear(ManagerController controller) {
        // Crear el Tab "ReporteAccesos"
        Tab reporteAccesosTab = new Tab();
        reporteAccesosTab.setText("Accesos");

        // Crear el contenedor principal (FlowPane)
        FlowPane flowPane = new FlowPane();

        // Crear el VBox principal
        VBox mainVBox = new VBox();
        mainVBox.setAlignment(Pos.TOP_CENTER);
        mainVBox.setPrefHeight(541.0);
        mainVBox.setPrefWidth(491.0);

        // Crear el HBox para los DatePickers
        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);
        hbox.setPrefHeight(100.0);
        hbox.setPrefWidth(200.0);
        hbox.setSpacing(5.0);

        // Crear el VBox para el DatePicker "Fecha de inicio"
        VBox inicioVBox = new VBox();
        inicioVBox.setAlignment(Pos.CENTER);
        inicioVBox.setSpacing(8.0);

        Label inicioLabel = new Label("Fecha de inicio");
        DatePicker inicioDatePicker = new DatePicker();
        inicioDatePicker.setId("ReporteAccesos_Inicio");

        controller.ReporteAccesos_Inicio = inicioDatePicker;

        inicioDatePicker.valueProperty().addListener((observable, oldValue, newValue) -> {
            controller.ReporteAccesos_Inicio.setValue(newValue);
        });
        inicioVBox.getChildren().addAll(inicioLabel, inicioDatePicker);

        // Crear el VBox para el DatePicker "Fecha de fin"
        VBox finVBox = new VBox();
        finVBox.setAlignment(Pos.CENTER);
        finVBox.setSpacing(8.0);

        Label finLabel = new Label("Fecha de fin");
        DatePicker finDatePicker = new DatePicker();
        finDatePicker.setId("ReporteAccesos_Fin");

        controller.ReporteAccesos_Fin = finDatePicker;

        finDatePicker.valueProperty().addListener((observable, oldValue, newValue) -> {
            controller.ReporteAccesos_Fin.setValue(newValue);
        });
        finVBox.getChildren().addAll(finLabel, finDatePicker);

        // Añadir los VBoxes al HBox
        hbox.getChildren().addAll(inicioVBox, finVBox);

        controller.setInputsAccesosTab(controller.getInputsAccesosTab());


        // Crear la TableView para mostrar los datos
        TableView<String> tableView = new TableView<>();
        tableView.setId("ReporteAccesos_Tabla");
        controller.ReporteAccesos_Tabla = tableView;
        tableView.setPrefHeight(574.0);
        tableView.setPrefWidth(491.0);

        // Crear las columnas de la tabla
        TableColumn<String, String> column1 = new TableColumn<>("C1");
        column1.setPrefWidth(75.0);
        TableColumn<String, String> column2 = new TableColumn<>("C2");
        column2.setPrefWidth(75.0);
        tableView.getColumns().addAll(column1, column2);

        // Añadir el HBox y la TableView al VBox principal
        mainVBox.getChildren().addAll(hbox, tableView);

        // Añadir el VBox principal al FlowPane
        flowPane.getChildren().add(mainVBox);

        // Asignar el FlowPane al contenido del Tab
        reporteAccesosTab.setContent(flowPane);

        return reporteAccesosTab;
    }
}