package Vista.Manager.Tab;

import java.sql.Date;

import com.acme.complejoacme.Manager.ManagerController;

import Modelo.DAO.PVisitantes.CMGPVisitantes;
import Modelo.DAO.PVisitantes.PVisitantesO;
import Modelo.DataBaseConection;
import Vista.utils.DatePickerObserver;
import Vista.utils.createLabeledField;
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
    private 
    CMGPVisitantes cmgpVisitantes = CMGPVisitantes.getInstance();
    PVisitantesO pVisitantesO;
    private Date fechaInicio, fechaFin;
    private String usuarioResponsable;
    private long idPersonal;

    @Override
    public Tab Crear(ManagerController controller) {
        Tab permisoTab = new Tab("Permiso Visitante");
        permisoTab.setId("permiso");

        
        FlowPane flowPane = new FlowPane();

        
        VBox mainVBox = new VBox();
        mainVBox.setAlignment(Pos.CENTER);
        mainVBox.setPrefSize(523, 541);

        
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

        
        HBox botonHBox = new HBox();
        botonHBox.setAlignment(Pos.CENTER);
        botonHBox.setPrefSize(200, 100);
        Button guardarButton = new Button("Guardar");
        guardarButton.setId("permiso_Button");
        guardarButton.setOnAction(e -> controller.procedimiento(controller.permisoVisitante_Inputs,() -> {
            fechaInicio = Date.valueOf(permisoFechaInicioPicker.getValue());
            fechaFin = Date.valueOf(permisoFechaFinPicker.getValue());
            usuarioResponsable = DataBaseConection.getCurrentUser();
            idPersonal = Long.parseLong(permisoIdTextField.getText());

            pVisitantesO = new PVisitantesO(fechaInicio, fechaFin, usuarioResponsable, idPersonal);
            cmgpVisitantes.guardar(pVisitantesO);
        }));
        controller.permiso_Button = guardarButton;
        guardarButton.setDefaultButton(true);
        guardarButton.setMnemonicParsing(false);
        guardarButton.setCursor(Cursor.HAND);
        botonHBox.getChildren().add(guardarButton);

        
        mainVBox.getChildren().addAll(identificadorHBox, fechasHBox, botonHBox);

        
        flowPane.getChildren().add(mainVBox);

        
        permisoTab.setContent(flowPane);

        return permisoTab;
    }
}