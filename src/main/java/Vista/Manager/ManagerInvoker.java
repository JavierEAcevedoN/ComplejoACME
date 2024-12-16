package Vista.Manager;

import Vista.Manager.Builds.*;
import com.acme.complejoacme.MainController;
import javafx.scene.layout.FlowPane;

public class ManagerInvoker {
    private static FlowPane manager;

    private static void ManagerSuperusuario() {
        ManagerSuperUsuario manager = ManagerSuperUsuario.create(MainController.Manager);
        ManagerInvoker.manager = manager.build();
    }

    private static void ManagerSupervisor() {
        ManagerSupervisor manager = ManagerSupervisor.create(MainController.Manager);
        ManagerInvoker.manager = manager.build();
    }

    private static void ManagerFuncionario() {
        ManagerFuncionario manager = ManagerFuncionario.create(MainController.Manager);
        ManagerInvoker.manager = manager.build();
    }

    private static void ManagerGuarda() {
        ManagerGuarda manager = ManagerGuarda.create(MainController.Manager);
        ManagerInvoker.manager = manager.build();
    }

    private static void ManagerTesting() {
        ManagerTesting manager = ManagerTesting.create(MainController.Manager);
        ManagerInvoker.manager = manager.build();
    }

    public static FlowPane getManager(String role) {
        if (role.contains("SUPERUSUARIO")) {
            ManagerSuperusuario();
        } else if (role.contains("SUPERVISOR")) {
            ManagerSupervisor();
        }else if (role.contains("FUNCIONARIO")) {
            ManagerFuncionario();
        }else if (role.contains("GUARDA")) {
            ManagerGuarda();
        } else {
            ManagerTesting();
        }
        return manager;
    }
}