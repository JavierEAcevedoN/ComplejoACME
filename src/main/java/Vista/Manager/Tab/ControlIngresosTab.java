package Vista.Manager.Tab;


import javafx.geometry.Side;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.FlowPane;

public class ControlIngresosTab implements TabBuilder{

    @Override
    public Tab Crear() {
        Tab controlIngresosTab = new Tab();
        controlIngresosTab.setText("Control Ingresos");

        // Crear FlowPane y TabPane dentro de esta pestaña
        FlowPane flowPane = new FlowPane();
        TabPane tabPane = new TabPane();
        tabPane.setSide(Side.RIGHT);
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        // Crear los tabs "Acceso Personal" y "Acceso Vehicular"
        Tab accesoPersonalTab = new AccesoPersonalTab().Crear();
        Tab accesoVehiculoTab = new AccesoVehiculoTab().Crear();
        tabPane.getTabs().addAll(accesoPersonalTab, accesoVehiculoTab);

        flowPane.getChildren().add(tabPane);
        controlIngresosTab.setContent(flowPane);

        return controlIngresosTab;
    }
}
