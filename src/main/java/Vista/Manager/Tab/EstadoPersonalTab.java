package Vista.Manager.Tab;

import Modelo.DAO.Personal.PersonalM;
import com.acme.complejoacme.Manager.ManagerController;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.Arrays;

public class EstadoPersonalTab implements TabBuilder{
    @Override
    public Tab Crear(ManagerController controller) {
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
        controller.ReporteEstado_Activos = activos;
        activos.setSelected(true);

        activos.selectedProperty().addListener((observable, oldValue, newValue) -> {
            controller.ReporteEstado_Activos.setSelected(newValue);
        });

        CheckBox inactivos = new CheckBox("Inactivos");
        controller.ReporteEstado_Inactivos = inactivos;
        inactivos.setSelected(false);

        inactivos.selectedProperty().addListener((observable, oldValue, newValue) -> {
            controller.ReporteEstado_Inactivos.setSelected(newValue);
        });

        estado.getChildren().addAll(activos, inactivos);

        FlowPane roles = new FlowPane();
        roles.setAlignment(Pos.CENTER);
        roles.setHgap(8.0);
        roles.setPrefHeight(81.0);
        roles.setPrefWidth(377.0);

        CheckBox supervisores = new CheckBox("Supervisores");
        controller.ReporteEstado_Superv = supervisores;

        supervisores.selectedProperty().addListener((observable, oldValue, newValue) -> {
            controller.ReporteEstado_Superv.setSelected(newValue);
        });

        CheckBox guardas = new CheckBox("Guardas");
        controller.ReporteEstado_Guardas = guardas;

        guardas.selectedProperty().addListener((observable, oldValue, newValue) -> {
            controller.ReporteEstado_Guardas.setSelected(newValue);
        });

        CheckBox funcionarios = new CheckBox("Funcionarios");
        controller.ReporteEstado_Funcion = funcionarios;

        funcionarios.selectedProperty().addListener((observable, oldValue, newValue) -> {
            controller.ReporteEstado_Funcion.setSelected(newValue);
        });

        roles.getChildren().addAll(supervisores, guardas, funcionarios);

        header.getChildren().addAll(estado, roles);

        controller.setInputsEstadoPersonalTab(controller.getInputsEstadoPersonalTab());


        TableView<PersonalM> tableView = new TableView<>();
        controller.ReporteEstado_Tabla = tableView;
        tableView.setPrefHeight(574.0);
        tableView.setPrefWidth(491.0);

        Arrays.asList(activos,inactivos,funcionarios,supervisores,guardas).forEach(checkBox -> {
            checkBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
                controller.procedimientoCheckBox(controller.getInputsEstadoPersonalTab(), tableView);
            });
        });

        body.getChildren().addAll(header, tableView);
        flowPane.getChildren().add(body);

        estadoPersonalTab.setContent(flowPane);
        return estadoPersonalTab;
    }
}