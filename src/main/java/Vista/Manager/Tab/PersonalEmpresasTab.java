package Vista.Manager.Tab;

import Modelo.DAO.Personal.CMGPersonal;
import Modelo.DAO.Personal.PersonalM;
import Vista.utils.TableViewConfigurator;
import com.acme.complejoacme.Manager.ManagerController;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.List;

public class PersonalEmpresasTab implements TabBuilder {
    CMGPersonal cmgPersonal = CMGPersonal.getInstance();
    @Override
    public Tab Crear(ManagerController controller) {
        // Crear el Tab "ReportePersonal"
        Tab reportePersonalTab = new Tab();
        reportePersonalTab.setText("Personal Empresas");

        // Crear el contenedor principal (FlowPane)
        FlowPane flowPane = new FlowPane();

        // Crear el VBox principal
        VBox mainVBox = new VBox();
        mainVBox.setAlignment(Pos.TOP_CENTER);
        mainVBox.setPrefHeight(541.0);
        mainVBox.setPrefWidth(491.0);

        // Crear el HBox para la selección de empresa
        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER_LEFT);
        hbox.setPrefHeight(100.0);
        hbox.setPrefWidth(200.0);
        hbox.setSpacing(5.0);

        // Crear el VBox para el label "Empresa"
        VBox labelVBox = new VBox();
        labelVBox.setAlignment(Pos.CENTER);
        labelVBox.setPrefHeight(200.0);
        labelVBox.setPrefWidth(100.0);
        labelVBox.setSpacing(5.0);

        Label empresaLabel = new Label("Empresa");
        labelVBox.getChildren().add(empresaLabel);

        // Crear el FlowPane para el ChoiceBox de empresa
        FlowPane flowPaneChoiceBox = new FlowPane();
        flowPaneChoiceBox.setAlignment(Pos.CENTER);
        flowPaneChoiceBox.setColumnHalignment(HPos.CENTER);
        flowPaneChoiceBox.setHgap(8.0);
        flowPaneChoiceBox.setPrefHeight(81.0);
        flowPaneChoiceBox.setPrefWidth(377.0);
        flowPaneChoiceBox.setRowValignment(VPos.BASELINE);
        flowPaneChoiceBox.setVgap(8.0);

        ChoiceBox<String> empresaChoiceBox = new ChoiceBox<>();
        empresaChoiceBox.setId("ReportePersonal_Empresa");

        controller.ReportePersonal_Empresa = empresaChoiceBox;

        empresaChoiceBox.setPrefHeight(24.0);
        empresaChoiceBox.setPrefWidth(331.0);
        flowPaneChoiceBox.getChildren().add(empresaChoiceBox);

        // Añadir VBox y FlowPane al HBox
        hbox.getChildren().addAll(labelVBox, flowPaneChoiceBox);

        controller.setInputsPersonalEmpresasTab(controller.getInputsPersonalEmpresasTab());

        // Crear la TableView para mostrar los datos
        TableView<PersonalM> tableView = new TableView<>();
        tableView.setId("ReportePersonal_Tabla");
        controller.ReportePersonal_Tabla = tableView;
        tableView.setPrefHeight(574.0);
        tableView.setPrefWidth(491.0);

        empresaChoiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

            //TODO
            controller.ReportePersonal_Empresa.getSelectionModel().select(newValue);
            TableViewConfigurator.initAccesos(tableView, List.of("id","nombre","direccion","contacto","estado", "usuarioSistema","rol"),  cmgPersonal.getLista());
        });

        // Añadir el HBox y la TableView al VBox principal
        mainVBox.getChildren().addAll(hbox, tableView);

        // Añadir el VBox principal al FlowPane
        flowPane.getChildren().add(mainVBox);

        // Asignar el FlowPane al contenido del Tab
        reportePersonalTab.setContent(flowPane);

        return reportePersonalTab;
    }
}