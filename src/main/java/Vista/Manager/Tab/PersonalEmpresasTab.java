package Vista.Manager.Tab;

import java.util.List;
import java.util.stream.Collectors;

import com.acme.complejoacme.Manager.ManagerController;

import Modelo.DAO.EmpPersonal.CMGEPersonal;
import Modelo.DAO.Empresas.CMEmpresas;
import Modelo.DAO.Personal.CMGPersonal;
import Modelo.DAO.Personal.PersonalM;
import Vista.utils.TableViewConfigurator;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PersonalEmpresasTab implements TabBuilder {
    private String empresa;
    private CMEmpresas cmEmpresas = CMEmpresas.getInstance();
    private CMGEPersonal cmgePersonal = CMGEPersonal.getInstance();

    CMGPersonal cmgPersonal = CMGPersonal.getInstance();

    @Override
    public Tab Crear(ManagerController controller) {
        
        Tab reportePersonalTab = new Tab();
        reportePersonalTab.setText("Personal Empresas");

        
        FlowPane flowPane = new FlowPane();

        
        VBox mainVBox = new VBox();
        mainVBox.setAlignment(Pos.TOP_CENTER);
        mainVBox.setPrefHeight(541.0);
        mainVBox.setPrefWidth(491.0);

        
        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER_LEFT);
        hbox.setPrefHeight(100.0);
        hbox.setPrefWidth(200.0);
        hbox.setSpacing(5.0);

        
        VBox labelVBox = new VBox();
        labelVBox.setAlignment(Pos.CENTER);
        labelVBox.setPrefHeight(200.0);
        labelVBox.setPrefWidth(100.0);
        labelVBox.setSpacing(5.0);

        Label empresaLabel = new Label("Empresa");
        labelVBox.getChildren().add(empresaLabel);

        
        FlowPane flowPaneChoiceBox = new FlowPane();
        flowPaneChoiceBox.setAlignment(Pos.CENTER);
        flowPaneChoiceBox.setColumnHalignment(HPos.CENTER);
        flowPaneChoiceBox.setHgap(8.0);
        flowPaneChoiceBox.setPrefHeight(81.0);
        flowPaneChoiceBox.setPrefWidth(377.0);
        flowPaneChoiceBox.setRowValignment(VPos.BASELINE);
        flowPaneChoiceBox.setVgap(8.0);

        ChoiceBox<String> empresaChoiceBox = new ChoiceBox<>();
        List<String> listEmpresas = cmEmpresas.getLista().stream().map(i -> i.getNombre()).collect(Collectors.toList());
        empresaChoiceBox.getItems().setAll(listEmpresas);
        empresaChoiceBox.setValue(listEmpresas.get(0));
        empresaChoiceBox.setId("ReportePersonal_Empresa");

        controller.ReportePersonal_Empresa = empresaChoiceBox;

        empresaChoiceBox.setPrefHeight(24.0);
        empresaChoiceBox.setPrefWidth(331.0);
        flowPaneChoiceBox.getChildren().add(empresaChoiceBox);

        
        hbox.getChildren().addAll(labelVBox, flowPaneChoiceBox);

        controller.setInputsPersonalEmpresasTab(controller.getInputsPersonalEmpresasTab());

        
        TableView<PersonalM> tableView = new TableView<>();
        tableView.setId("ReportePersonal_Tabla");
        controller.ReportePersonal_Tabla = tableView;
        tableView.setPrefHeight(574.0);
        tableView.setPrefWidth(491.0);

        empresaChoiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            empresa = empresaChoiceBox.getValue();
            List<PersonalM> personal = cmgePersonal.getLista().stream()
                    .filter(i -> i.getEmpresasM().getNombre().equals(empresa)).map(i -> i.getPersonalM())
                    .collect(Collectors.toList());
            controller.ReportePersonal_Empresa.getSelectionModel().select(newValue);
            TableViewConfigurator.init(tableView, List.of("id_Personal","nombre","direccion","contacto","estado",
                    "usuarioSistema","rol"),  personal);
        });

        
        mainVBox.getChildren().addAll(hbox, tableView);

        
        flowPane.getChildren().add(mainVBox);

        
        reportePersonalTab.setContent(flowPane);

        return reportePersonalTab;
    }
}