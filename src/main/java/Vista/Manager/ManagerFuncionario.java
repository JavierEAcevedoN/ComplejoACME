package Vista.Manager;

import Vista.Manager.Tab.*;
import javafx.scene.control.Tab;

import java.util.ArrayList;
import java.util.List;

public class ManagerFuncionario extends ManagerBuilder{
    @Override
    protected ArrayList<Tab> getTabs() {
        Tab nuevoRegistro = new NuevoRegistroTab().Crear();
        Tab permisoVisitante = new PermisoTab().Crear();
        Tab reportes = new ReportesTab().Crear();

        ArrayList<Tab> tabs = new ArrayList<>(List.of(nuevoRegistro, permisoVisitante,reportes));

        return tabs;
    }
}
