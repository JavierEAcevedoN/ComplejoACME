package Vista.Manager.Tab;

import javafx.geometry.Side;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.FlowPane;

public class ControlSalidasTab implements TabBuilder{
    @Override
    public Tab Crear() {
        Tab controlSalidasTab = new Tab();
        controlSalidasTab.setText("Control Salidas");

        // Crear FlowPane y TabPane dentro de esta pestaña
        FlowPane flowPane = new FlowPane();
        TabPane tabPane = new TabPane();
        tabPane.setSide(Side.RIGHT);
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        // Crear los tabs "Salida Personal" y "Salida Vehicular"
        Tab salidaPersonalTab = new SalidaPersonalTab().Crear();
        Tab salidaVehiculoTab = new SalidaVehiculoTab().Crear();
        tabPane.getTabs().addAll(salidaPersonalTab, salidaVehiculoTab);

        flowPane.getChildren().add(tabPane);
        controlSalidasTab.setContent(flowPane);

        return controlSalidasTab;
    }
}
