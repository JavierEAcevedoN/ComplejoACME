package Vista.Manager.Builds;

import Vista.Manager.Tab.*;
import com.acme.complejoacme.Manager.AbstractManagerController;
import javafx.scene.control.Tab;
import java.util.ArrayList;
import java.util.List;

public class ManagerSupervisor extends ManagerBuilder{
    public ManagerSupervisor(AbstractManagerController controller) {
        super(controller);
    }

    public static ManagerSupervisor create(AbstractManagerController controller) {
        return new ManagerSupervisor(controller);
    }

    @Override
    protected ArrayList<Tab> getTabs() {
        Tab crearUsuarios = new CrearUsuarioTab().Crear();
        Tab nuevoRegistro = new NuevoRegistroTab().Crear();
        Tab disciplinario = new DisciplinarioTab().Crear();
        Tab reportes = new ReportesTab().Crear();
        Tab monitor = new MonitorTab().Crear();

        ArrayList<Tab> tabs = new ArrayList<>(List.of(crearUsuarios,nuevoRegistro,disciplinario,reportes,monitor));

        return tabs;
    }
}