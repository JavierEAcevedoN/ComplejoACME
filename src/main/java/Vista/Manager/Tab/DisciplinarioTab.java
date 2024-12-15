package Vista.Manager.Tab;

import Modelo.DataBaseConection;
import com.acme.complejoacme.Manager.ManagerController;
import javafx.geometry.Side;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.FlowPane;

public class DisciplinarioTab implements TabBuilder{
    @Override
    public Tab Crear(ManagerController controller) {
        Tab disciplinarioTab = new Tab();
        disciplinarioTab.setText("Disciplinario");

        // Crear el FlowPane que contiene el TabPane de la pestaña
        FlowPane flowPane = new FlowPane();

        // Crear TabPane interno para la pestaña "Disciplinario"
        TabPane innerTabPane = new TabPane();
        innerTabPane.setPrefSize(525,536);
        innerTabPane.setSide(Side.RIGHT);
        innerTabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        // Crear los tabs "Incidentes" y "Restricciones"
        Tab incidentesTab = new IncidentesTab().Crear(controller);
        Tab restriccionesTab = new RestriccionesTab().Crear(controller);

        if (DataBaseConection.getCurrentRole().equals("GUARDA")) {
            innerTabPane.getTabs().add(incidentesTab);
        } else {
            innerTabPane.getTabs().addAll(incidentesTab, restriccionesTab);
        }

        flowPane.getChildren().add(innerTabPane);
        disciplinarioTab.setContent(flowPane);

        return disciplinarioTab;
    }
}