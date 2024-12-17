package Vista.Manager.Tab;

import com.acme.complejoacme.Manager.ManagerController;

import javafx.geometry.Side;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.FlowPane;

public class ControlSalidasTab implements TabBuilder{
    @Override
    public Tab Crear(ManagerController controller) {
        Tab controlSalidasTab = new Tab();
        controlSalidasTab.setText("Control Salidas");

        
        FlowPane flowPane = new FlowPane();
        TabPane tabPane = new TabPane();
        tabPane.setPrefSize(525,536);
        tabPane.setSide(Side.RIGHT);
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        
        Tab salidaPersonalTab = new SalidaPersonalTab().Crear(controller);
        Tab salidaVehiculoTab = new SalidaVehiculoTab().Crear(controller);
        tabPane.getTabs().addAll(salidaPersonalTab, salidaVehiculoTab);

        flowPane.getChildren().add(tabPane);
        controlSalidasTab.setContent(flowPane);

        return controlSalidasTab;
    }
}