package Vista.Manager.Tab;

import com.acme.complejoacme.Manager.ManagerController;
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
        innerTabPane.getTabs().addAll(
                new RegistrarPersonalTab().Crear(controller),
                new RegistrarVehiculoTab().Crear(controller)
        );

        mainContent.getChildren().add(innerTabPane);
        nuevoRegistroTab.setContent(mainContent);

        return nuevoRegistroTab;
    }
}