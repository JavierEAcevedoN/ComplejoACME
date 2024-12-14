package Vista.Manager.Builds;

import Vista.Manager.Tab.*;
import com.acme.complejoacme.Manager.AbstractManagerController;
import javafx.scene.control.Tab;

import java.util.ArrayList;
import java.util.List;

public class ManagerFuncionario extends ManagerBuilder{
    public ManagerFuncionario(AbstractManagerController controller) {
        super(controller);
    }

    public static ManagerFuncionario create(AbstractManagerController controller) {
        return new ManagerFuncionario(controller);
    }

    @Override
    protected ArrayList<Tab> getTabs() {
        Tab nuevoRegistro = new NuevoRegistroTab().Crear();
        Tab permisoVisitante = new PermisoTab().Crear();
        Tab reportes = new ReportesTab().Crear();

        ArrayList<Tab> tabs = new ArrayList<>(List.of(nuevoRegistro, permisoVisitante,reportes));

        return tabs;
    }
}