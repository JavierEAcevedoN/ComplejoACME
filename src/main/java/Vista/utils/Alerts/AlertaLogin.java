package Vista.utils.Alerts;

import javafx.scene.control.Alert;

public class AlertaLogin{
    static Alert alert = new Alert(Alert.AlertType.NONE);

    public static void Error() {
        alert.setAlertType(Alert.AlertType.ERROR);
        alert.setTitle("Fallo");
        alert.setHeaderText("Conexión fallída");
        alert.setContentText("Intente nuevamente.");
        alert.showAndWait();
    }

    public static void Ad() {
        alert.setAlertType(Alert.AlertType.WARNING);
        alert.setTitle("Advertencia");
        alert.setHeaderText("Campos incompletos");
        alert.setContentText("Ningún campo puede estar vacío.");
        alert.showAndWait();
    }

    public static void Info() {
        alert.setAlertType(Alert.AlertType.INFORMATION);
        alert.setTitle("Enhorabuena");
        alert.setHeaderText("Conexión exítosa");
        alert.showAndWait();
    }
}