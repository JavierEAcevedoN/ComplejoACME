package Vista.Manager.Tab;

import Vista.utils.Alerts.AlertaTab;
import Vista.utils.DatePickerObserver;
import Vista.utils.createLabeledField;
import com.acme.complejoacme.Manager.ManagerController;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PermisoTab implements TabBuilder{

    @Override
    public Tab Crear(ManagerController controller) {
        Tab permisoTab = new Tab("Permiso Visitante");
        permisoTab.setId("permiso");

        // Crear el FlowPane principal
        FlowPane flowPane = new FlowPane();

        // Crear el VBox principal
        VBox mainVBox = new VBox();
        mainVBox.setAlignment(Pos.CENTER);
        mainVBox.setPrefSize(523, 541);

        // Crear el primer HBox para el identificador
        HBox identificadorHBox = new HBox();
        identificadorHBox.setAlignment(Pos.CENTER);
        identificadorHBox.setPrefSize(200, 100);
        VBox identificadorField = createLabeledField.create("Identificador", new TextField(), "permiso_Id");
        TextField permisoIdTextField = (TextField) identificadorField.getChildren().get(1);
        controller.permiso_Id = permisoIdTextField;

        permisoIdTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            controller.permiso_Id.setText(newValue);
        });

        identificadorHBox.getChildren().add(identificadorField);

        // Crear el segundo HBox para las fechas
        HBox fechasHBox = new HBox();
        fechasHBox.setAlignment(Pos.CENTER);
        fechasHBox.setSpacing(25.0);
        fechasHBox.setPrefSize(200, 100);
        VBox fechaInicioField = createLabeledField.create("Fecha de inicio", new DatePicker(), "permiso_FechaInicio");
        DatePicker permisoFechaInicioPicker = (DatePicker) fechaInicioField.getChildren().get(1);
        controller.permiso_FechaInicio = permisoFechaInicioPicker;

        permisoFechaInicioPicker.valueProperty().addListener((observable, oldValue, newValue) -> {
            controller.permiso_FechaInicio.setValue(newValue);
        });

        VBox fechaFinField = createLabeledField.create("Fecha de fin", new DatePicker(), "permiso_FechaFin");
        DatePicker permisoFechaFinPicker = (DatePicker) fechaFinField.getChildren().get(1);
        controller.permiso_FechaFin = permisoFechaFinPicker;

        permisoFechaFinPicker.valueProperty().addListener((observable, oldValue, newValue) -> {
            controller.permiso_FechaFin.setValue(newValue);
        });
        fechasHBox.getChildren().addAll(fechaInicioField, fechaFinField);

        DatePickerObserver.init(permisoFechaInicioPicker,permisoFechaFinPicker);

        controller.setInputsPermisoTab(controller.getInputsPermisoTab());

        // Crear el tercer HBox para el botón
        HBox botonHBox = new HBox();
        botonHBox.setAlignment(Pos.CENTER);
        botonHBox.setPrefSize(200, 100);
        Button guardarButton = new Button("Guardar");
        guardarButton.setId("permiso_Button");
        guardarButton.setOnAction(e -> controller.procedimiento(controller.permisoVisitante_Inputs,() -> {
            AlertaTab.Test();}));
        controller.permiso_Button = guardarButton;
        guardarButton.setDefaultButton(true);
        guardarButton.setMnemonicParsing(false);
        guardarButton.setCursor(Cursor.HAND);
        botonHBox.getChildren().add(guardarButton);

        // Agregar los HBox al VBox principal
        mainVBox.getChildren().addAll(identificadorHBox, fechasHBox, botonHBox);

        // Agregar el VBox principal al FlowPane
        flowPane.getChildren().add(mainVBox);

        // Configurar el contenido del Tab
        permisoTab.setContent(flowPane);

        return permisoTab;
    }
}