package Vista.Manager;

import Vista.Manager.Tab.CrearUsuarioTab;
import javafx.scene.control.Tab;
import java.util.ArrayList;
import java.util.List;

public class ManagerSuperUsuario extends ManagerBuilder {
    @Override
    protected ArrayList<Tab> getTabs() {
        Tab tab = new CrearUsuarioTab().Crear();

        ArrayList<Tab> tabs = new ArrayList<>(List.of(tab));
        return tabs;
    }
}
