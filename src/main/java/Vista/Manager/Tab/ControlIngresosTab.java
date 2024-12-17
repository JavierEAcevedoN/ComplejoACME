package Vista.Manager.Tab;


import com.acme.complejoacme.Manager.ManagerController;

import javafx.geometry.Side;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.FlowPane;

public class ControlIngresosTab implements TabBuilder{

    @Override
    public Tab Crear(ManagerController controller) {
        Tab controlIngresosTab = new Tab();
        controlIngresosTab.setText("Control Ingresos");

        
        FlowPane flowPane = new FlowPane();
        TabPane tabPane = new TabPane();
        tabPane.setPrefSize(525,536);
        tabPane.setSide(Side.RIGHT);
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        
        Tab accesoPersonalTab = new AccesoPersonalTab().Crear(controller);
        Tab accesoVehiculoTab = new AccesoVehiculoTab().Crear(controller);
        tabPane.getTabs().addAll(accesoPersonalTab, accesoVehiculoTab);

        flowPane.getChildren().add(tabPane);
        controlIngresosTab.setContent(flowPane);

        return controlIngresosTab;
    }
}