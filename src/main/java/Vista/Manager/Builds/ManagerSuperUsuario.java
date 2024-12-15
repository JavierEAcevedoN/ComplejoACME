package Vista.Manager.Builds;

import Vista.Manager.Tab.CrearUsuarioTab;
import com.acme.complejoacme.Manager.ManagerController;
import javafx.scene.control.Tab;
import java.util.ArrayList;
import java.util.List;

public class ManagerSuperUsuario extends ManagerBuilder {
    public ManagerSuperUsuario(ManagerController controller) {
        super(controller);
    }

    public static ManagerSuperUsuario create(ManagerController controller) {
        return new ManagerSuperUsuario(controller);
    }

    @Override
    protected ArrayList<Tab> getTabs() {
        Tab tab = new CrearUsuarioTab().Crear(controller);

        return new ArrayList<>(List.of(tab));
    }
}