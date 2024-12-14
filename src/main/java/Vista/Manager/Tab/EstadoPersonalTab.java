package Vista.Manager.Tab;

import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class EstadoPersonalTab implements TabBuilder{
    @Override
    public Tab Crear() {
        Tab estadoPersonalTab = new Tab("Estado Personal Autorizado");
        estadoPersonalTab.setId("ReporteEstado");

        // FlowPane que contiene el contenido del Tab
        FlowPane flowPane = new FlowPane();

        VBox body = new VBox();
        body.setAlignment(Pos.TOP_CENTER);
        body.setPrefHeight(541.0);
        body.setPrefWidth(491.0);

        HBox header = new HBox(5);
        header.setAlignment(Pos.CENTER_LEFT);
        header.setPrefHeight(100.0);
        header.setPrefWidth(200.0);

        VBox estado = new VBox(5);
        estado.setAlignment(Pos.CENTER_LEFT);
        estado.setPrefHeight(200.0);
        estado.setPrefWidth(100.0);

        CheckBox activos = new CheckBox("Activos");
        CheckBox inactivos = new CheckBox("Inactivos");

        estado.getChildren().addAll(activos, inactivos);

        FlowPane roles = new FlowPane();
        roles.setAlignment(Pos.CENTER);
        roles.setHgap(8.0);
        roles.setPrefHeight(81.0);
        roles.setPrefWidth(377.0);

        CheckBox supervisores = new CheckBox("Supervisores");
        CheckBox guardas = new CheckBox("Guardas");
        CheckBox funcionarios = new CheckBox("Funcionarios");

        roles.getChildren().addAll(supervisores, guardas, funcionarios);

        header.getChildren().addAll(estado, roles);

        TableView<String> tableView = new TableView<>();
        tableView.setPrefHeight(574.0);
        tableView.setPrefWidth(491.0);

        TableColumn<String, String> column1 = new TableColumn<>("C1");
        column1.setPrefWidth(75.0);

        TableColumn<String, String> column2 = new TableColumn<>("C2");
        column2.setPrefWidth(75.0);

        tableView.getColumns().addAll(column1, column2);

        body.getChildren().addAll(header, tableView);
        flowPane.getChildren().add(body);

        estadoPersonalTab.setContent(flowPane);
        return estadoPersonalTab;
    }
}
