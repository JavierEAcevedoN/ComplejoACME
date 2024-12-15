package Vista.Manager.Tab;

import com.acme.complejoacme.Manager.ManagerController;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.FlowPane;

public class RestriccionesTab implements TabBuilder{
    @Override
    public Tab Crear(ManagerController controller) {
        Tab restriccionesTab = new Tab();
        restriccionesTab.setText("Restricciones");

        FlowPane flowPane = new FlowPane();
        flowPane.setAlignment(Pos.CENTER);

        // Crear el TabPane interno para "Aplicar Restricción" y "Levantar Restricción"
        TabPane tabPane = new TabPane();
        tabPane.setPrefSize(496,533);
        tabPane.setSide(Side.RIGHT);
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        // Crear las pestañas de "Aplicar Restricción" y "Levantar Restricción"
        Tab aplicarRestTab = new AplicarRestriccionTab().Crear(controller);
        Tab levantarRestTab = new LevantarRestriccionTab().Crear(controller);

        tabPane.getTabs().addAll(aplicarRestTab, levantarRestTab);
        flowPane.getChildren().add(tabPane);
        restriccionesTab.setContent(flowPane);

        return restriccionesTab;
    }
}