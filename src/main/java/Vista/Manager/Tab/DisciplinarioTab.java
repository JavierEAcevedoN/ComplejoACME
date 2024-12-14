package Vista.Manager.Tab;

import javafx.geometry.Side;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.FlowPane;

public class DisciplinarioTab implements TabBuilder{
    @Override
    public Tab Crear() {
        Tab disciplinarioTab = new Tab();
        disciplinarioTab.setText("Disciplinario");

        // Crear el FlowPane que contiene el TabPane de la pestaña
        FlowPane flowPane = new FlowPane();

        // Crear TabPane interno para la pestaña "Disciplinario"
        TabPane innerTabPane = new TabPane();
        innerTabPane.setSide(Side.RIGHT);
        innerTabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        // Crear los tabs "Incidentes" y "Restricciones"
        Tab incidentesTab = new IncidentesTab().Crear();
        Tab restriccionesTab = new RestriccionesTab().Crear();

        innerTabPane.getTabs().addAll(incidentesTab, restriccionesTab);
        flowPane.getChildren().add(innerTabPane);
        disciplinarioTab.setContent(flowPane);

        return disciplinarioTab;
    }
}
