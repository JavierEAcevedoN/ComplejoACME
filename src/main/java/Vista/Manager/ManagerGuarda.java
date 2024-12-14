package Vista.Manager;

import Vista.Manager.Tab.*;
import javafx.scene.control.Tab;

import java.util.ArrayList;
import java.util.List;

public class ManagerGuarda extends ManagerBuilder{
    @Override
    protected ArrayList<Tab> getTabs() {
        Tab controlIngreso = new CrearUsuarioTab().Crear();
        Tab controlSalida = new NuevoRegistroTab().Crear();
        Tab disciplinario = new DisciplinarioTab().Crear();

        ArrayList<Tab> tabs = new ArrayList<>(List.of(controlIngreso,controlSalida,disciplinario));

        return tabs;
    }
}
