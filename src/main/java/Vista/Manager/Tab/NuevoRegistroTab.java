package Vista.Manager.Tab;

import Vista.utils.createLabeledField;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class NuevoRegistroTab implements TabBuilder {
    @Override
    public Tab Crear() {
        Tab nuevoRegistroTab = new Tab("Nuevo Registro");

        FlowPane mainContent = new FlowPane();
        mainContent.setAlignment(Pos.CENTER);
        mainContent.setHgap(20.0);
        mainContent.setPrefWrapLength(10.0);

        TabPane innerTabPane = new TabPane();
        innerTabPane.setPrefSize(522.0, 541.0);
        innerTabPane.setSide(Side.RIGHT);
        innerTabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        // Usar clases creadoras para agregar los tabs internos
        innerTabPane.getTabs().addAll(
                new RegistrarPersonalTab().Crear(),
                new RegistrarVehiculoTab().Crear()
        );

        mainContent.getChildren().add(innerTabPane);
        nuevoRegistroTab.setContent(mainContent);

        return nuevoRegistroTab;
    }
}

