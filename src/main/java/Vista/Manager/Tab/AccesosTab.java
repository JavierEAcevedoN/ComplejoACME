package Vista.Manager.Tab;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.acme.complejoacme.Manager.ManagerController;

import Modelo.DAO.CAPersonal.CCAPersonal;
import Modelo.DAO.Personal.PersonalM;
import Vista.utils.DatePickerObserver;
import Vista.utils.TableViewConfigurator;
import javafx.geometry.Pos;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AccesosTab implements TabBuilder{
    CCAPersonal ccaPersonal = CCAPersonal.getInstance();
    @Override
    public Tab Crear(ManagerController controller) {
        
        Tab reporteAccesosTab = new Tab();
        reporteAccesosTab.setText("Accesos");

        
        FlowPane flowPane = new FlowPane();

        
        VBox mainVBox = new VBox();
        mainVBox.setAlignment(Pos.TOP_CENTER);
        mainVBox.setPrefHeight(541.0);
        mainVBox.setPrefWidth(491.0);

        
        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);
        hbox.setPrefHeight(100.0);
        hbox.setPrefWidth(200.0);
        hbox.setSpacing(5.0);

        
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

        
        hbox.getChildren().addAll(inicioVBox, finVBox);

        controller.setInputsAccesosTab(controller.getInputsAccesosTab());

        
        TableView tableView = new TableView<>();
        tableView.setId("ReporteAccesos_Tabla");
        controller.ReporteAccesos_Tabla = tableView;
        tableView.setPrefHeight(574.0);
        tableView.setPrefWidth(491.0);

        DatePickerObserver.init(inicioDatePicker,finDatePicker, () -> {controller.procedimiento(controller.accesos_Inputs,() -> {
            List<PersonalM> list = ccaPersonal.obtenerPersonalPorRangoFechas(controller.ReporteAccesos_Inicio,
                    controller.ReporteAccesos_Fin);
            Set<PersonalM> set = new TreeSet<>(list);
            List<PersonalM> res = new ArrayList<>(set);
            TableViewConfigurator.init(tableView, List.of("id_Personal","nombre","direccion","contacto","estado", "usuarioSistema","rol"),  res);
        });});

        
        mainVBox.getChildren().addAll(hbox, tableView);

        
        flowPane.getChildren().add(mainVBox);

        
        reporteAccesosTab.setContent(flowPane);

        return reporteAccesosTab;
    }
}