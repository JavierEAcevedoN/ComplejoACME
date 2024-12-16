package Vista.Manager.Tab;

import com.acme.complejoacme.Manager.ManagerController;

import Modelo.DataBaseConection;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class NuevoRegistroTab implements TabBuilder {
    @Override
    public Tab Crear(ManagerController controller) {
        Tab nuevoRegistroTab = new Tab("Nuevo Registro");

        FlowPane mainContent = new FlowPane();
        mainContent.setAlignment(Pos.CENTER);
        mainContent.setHgap(20.0);
        mainContent.setPrefWrapLength(10.0);

        TabPane innerTabPane = new TabPane();
        innerTabPane.setPrefSize(525,536);
        innerTabPane.setSide(Side.RIGHT);
        innerTabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        // Usar clases creadoras para agregar los tabs internos
        innerTabPane.getTabs().add(new RegistrarPersonalTab().Crear(controller));
        if (!DataBaseConection.getCurrentRole().contains("SUPERUSUARIO")) {
            innerTabPane.getTabs().add(new RegistrarVehiculoTab().Crear(controller));
        }

        mainContent.getChildren().add(innerTabPane);
        nuevoRegistroTab.setContent(mainContent);

        return nuevoRegistroTab;
    }
}