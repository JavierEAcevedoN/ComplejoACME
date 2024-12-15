package Vista.Manager.Builds;

import Vista.Manager.Tab.*;
import com.acme.complejoacme.Manager.ManagerController;
import javafx.scene.control.Tab;

import java.util.ArrayList;
import java.util.List;

public class ManagerGuarda extends ManagerBuilder{
    public ManagerGuarda(ManagerController controller) {
        super(controller);
    }

    public static ManagerGuarda create(ManagerController controller) {
        return new ManagerGuarda(controller);
    }

    @Override
    protected ArrayList<Tab> getTabs() {
        Tab controlIngreso = new CrearUsuarioTab().Crear(controller);
        Tab controlSalida = new NuevoRegistroTab().Crear(controller);
        Tab disciplinario = new DisciplinarioTab().Crear(controller);

        return new ArrayList<>(List.of(controlIngreso,controlSalida,disciplinario));
    }
}