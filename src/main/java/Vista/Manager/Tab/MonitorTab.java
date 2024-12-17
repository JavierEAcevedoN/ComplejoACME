package Vista.Manager.Tab;

import java.util.List;

import Vista.utils.MonitorRes;
import com.acme.complejoacme.Manager.ManagerController;

import Modelo.DAO.CAPersonal.CAPersonalM;
import Modelo.DAO.CAPersonal.CCAPersonal;
import Vista.utils.TableViewConfigurator;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.scene.layout.FlowPane;

public class MonitorTab implements TabBuilder{

    @Override
    public Tab Crear(ManagerController controller) {
        
        Tab monitorTab = new Tab();
        monitorTab.setText("Monitor");

        
        FlowPane flowPane = new FlowPane();

        
        TableView tableView = new TableView<>();
        tableView.setId("Monitor");
        controller.Monitor = tableView;
        tableView.setPrefHeight(543.0);
        tableView.setPrefWidth(522.0);

        controller.getTime();

        TableViewConfigurator.actualizarTablaPeriodicamente(tableView, controller.now);

        flowPane.getChildren().add(tableView);

        
        monitorTab.setContent(flowPane);

        return monitorTab;
    }
}