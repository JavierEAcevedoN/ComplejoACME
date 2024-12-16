package Vista.Manager.Builds;

import Vista.Manager.Tab.*;
import com.acme.complejoacme.Manager.ManagerController;
import javafx.scene.control.Tab;

import java.util.ArrayList;
import java.util.List;

public class ManagerTesting extends ManagerBuilder{
    public ManagerTesting(ManagerController controller) {
        super(controller);
    }

    public static ManagerTesting create(ManagerController controller) {
        return new ManagerTesting(controller);
    }

    @Override
    protected ArrayList<Tab> getTabs() {
        Tab crearUsuarios = new CrearUsuarioTab().Crear(controller);
        Tab nuevoRegistro = new NuevoRegistroTab().Crear(controller);
        Tab permisoVisitante = new PermisoTab().Crear(controller);
        Tab controlIngreso = new CrearUsuarioTab().Crear(controller);
        Tab controlSalida = new NuevoRegistroTab().Crear(controller);
        Tab disciplinario = new DisciplinarioTab().Crear(controller);
        Tab reportes = new ReportesTab().Crear(controller);
        Tab monitor = new MonitorTab().Crear(controller);

        return new ArrayList<>(List.of(crearUsuarios,nuevoRegistro,permisoVisitante,controlIngreso,controlSalida, disciplinario,reportes,monitor));
    }
}