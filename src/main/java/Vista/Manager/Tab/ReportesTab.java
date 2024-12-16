package Vista.Manager.Tab;

import com.acme.complejoacme.Manager.ManagerController;
import javafx.geometry.Side;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.FlowPane;

public class ReportesTab implements TabBuilder{

    @Override
    public Tab Crear(ManagerController controller) {
        Tab reportesTab = new Tab("Reportes");

        // FlowPane que contiene el TabPane con sus Tab internos
        FlowPane flowPane = new FlowPane();

        TabPane innerTabPane = new TabPane();
        innerTabPane.setPrefSize(525,536);
        innerTabPane.setSide(Side.RIGHT);
        innerTabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        Tab estadoPersonalTab = new EstadoPersonalTab().Crear(controller);
        Tab personalEmpresasTab = new PersonalEmpresasTab().Crear(controller);
        Tab accesosTab = new AccesosTab().Crear(controller);

        innerTabPane.getTabs().addAll(estadoPersonalTab, personalEmpresasTab,accesosTab);
        flowPane.getChildren().add(innerTabPane);
        reportesTab.setContent(flowPane);

        return reportesTab;
    }
}