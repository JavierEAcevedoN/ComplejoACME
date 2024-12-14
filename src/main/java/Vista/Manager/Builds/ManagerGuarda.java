package Vista.Manager.Builds;

import Vista.Manager.Tab.*;
import com.acme.complejoacme.Manager.AbstractManagerController;
import javafx.scene.control.Tab;

import java.util.ArrayList;
import java.util.List;

public class ManagerGuarda extends ManagerBuilder{
    public ManagerGuarda(AbstractManagerController controller) {
        super(controller);
    }

    public static ManagerGuarda create(AbstractManagerController controller) {
        return new ManagerGuarda(controller);
    }

    @Override
    protected ArrayList<Tab> getTabs() {
        Tab controlIngreso = new CrearUsuarioTab().Crear();
        Tab controlSalida = new NuevoRegistroTab().Crear();
        Tab disciplinario = new DisciplinarioTab().Crear();

        ArrayList<Tab> tabs = new ArrayList<>(List.of(controlIngreso,controlSalida,disciplinario));

        return tabs;
    }
}