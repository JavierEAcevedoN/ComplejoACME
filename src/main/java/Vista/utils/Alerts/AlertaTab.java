package Vista.utils.Alerts;

import javafx.scene.control.Alert;

public class AlertaTab {
    static Alert alert = new Alert(Alert.AlertType.NONE);

    public static void Error() {
        alert.setAlertType(Alert.AlertType.ERROR);
        alert.setTitle("Fallo");
        alert.setHeaderText("Error inesperado");
        alert.setContentText("Intente nuevamente.");
        alert.showAndWait();
    }

    public static void Incompletos() {
        alert.setAlertType(Alert.AlertType.ERROR);
        alert.setTitle("Campo Vacío");
        alert.setHeaderText("Ningún campo puede estar vacío.");
        alert.showAndWait();
    }

    public static void Exito() {
        alert.setAlertType(Alert.AlertType.INFORMATION);
        alert.setTitle("Procedimiento Realizado");
        alert.setHeaderText("Hecho!");
        alert.showAndWait();
    }

    public static void Test() {
        alert.setAlertType(Alert.AlertType.WARNING);
        alert.setHeaderText("AQUI YA VA UNA FUNCION");
        alert.setContentText("En consola más intrucciones");

        alert.showAndWait();
    }
}