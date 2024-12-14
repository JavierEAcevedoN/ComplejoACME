package Vista.Manager.Builds;

import Vista.Manager.Tab.CrearUsuarioTab;
import com.acme.complejoacme.Manager.AbstractManagerController;
import javafx.scene.control.Tab;
import java.util.ArrayList;
import java.util.List;

public class ManagerSuperUsuario extends ManagerBuilder {
    public ManagerSuperUsuario(AbstractManagerController controller) {
        super(controller);
    }

    public static ManagerSuperUsuario create(AbstractManagerController controller) {
        return new ManagerSuperUsuario(controller);
    }

    @Override
    protected ArrayList<Tab> getTabs() {
        Tab tab = new CrearUsuarioTab().Crear();

        ArrayList<Tab> tabs = new ArrayList<>(List.of(tab));
        return tabs;
    }
}