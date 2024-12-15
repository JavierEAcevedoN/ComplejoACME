package Vista.Manager.Builds;

import Vista.Manager.Tab.*;
import com.acme.complejoacme.Manager.ManagerController;
import javafx.scene.control.Tab;

import java.util.ArrayList;
import java.util.List;

public class ManagerFuncionario extends ManagerBuilder{
    public ManagerFuncionario(ManagerController controller) {
        super(controller);
    }

    public static ManagerFuncionario create(ManagerController controller) {
        return new ManagerFuncionario(controller);
    }

    @Override
    protected ArrayList<Tab> getTabs() {
        Tab nuevoRegistro = new NuevoRegistroTab().Crear(controller);
        Tab permisoVisitante = new PermisoTab().Crear(controller);
        Tab monitor = new MonitorTab().Crear(controller);

        return new ArrayList<>(List.of(nuevoRegistro, permisoVisitante,monitor));
    }
}