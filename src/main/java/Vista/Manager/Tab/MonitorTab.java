package Vista.Manager.Tab;

import com.acme.complejoacme.Manager.ManagerController;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.FlowPane;

public class MonitorTab implements TabBuilder{

    @Override
    public Tab Crear(ManagerController controller) {
        // Crear el Tab "Monitor"
        Tab monitorTab = new Tab();
        monitorTab.setText("Monitor");

        // Crear el contenedor FlowPane
        FlowPane flowPane = new FlowPane();

        // Crear la TableView
        TableView<String> tableView = new TableView<>();
        tableView.setId("Monitor");
        controller.Monitor = tableView;
        tableView.setPrefHeight(543.0);
        tableView.setPrefWidth(522.0);

        // Crear las columnas de la tabla
        TableColumn<String, String> column1 = new TableColumn<>("C1");
        column1.setPrefWidth(75.0);
        TableColumn<String, String> column2 = new TableColumn<>("C2");
        column2.setPrefWidth(75.0);

        // Añadir las columnas a la TableView
        tableView.getColumns().addAll(column1, column2);

        // Añadir la TableView al FlowPane
        flowPane.getChildren().add(tableView);

        // Asignar el FlowPane al contenido del Tab
        monitorTab.setContent(flowPane);

        return monitorTab;
    }
}