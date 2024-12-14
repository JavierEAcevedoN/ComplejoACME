package Vista.Manager.Tab;

import javafx.geometry.Side;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.FlowPane;

public class ReportesTab implements TabBuilder{

    @Override
    public Tab Crear() {
        Tab reportesTab = new Tab("Reportes");

        // FlowPane que contiene el TabPane con sus Tab internos
        FlowPane flowPane = new FlowPane();

        TabPane innerTabPane = new TabPane();
        innerTabPane.setSide(Side.RIGHT);
        innerTabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        Tab estadoPersonalTab = new EstadoPersonalTab().Crear();
        Tab personalEmpresasTab = new PersonalEmpresasTab().Crear();
        Tab accesosTab = new AccesosTab().Crear();


        innerTabPane.getTabs().addAll(estadoPersonalTab, personalEmpresasTab,accesosTab);
        flowPane.getChildren().add(innerTabPane);
        reportesTab.setContent(flowPane);

        return reportesTab;
    }
}
