package Vista.Manager.Tab;

import Modelo.DAO.IPersonal.IPersonalM;
import Modelo.DAO.RPersonal.CMGRPersonal;
import Modelo.DAO.RPersonal.RPersonalM;
import Vista.utils.Alerts.AlertaTab;
import Vista.utils.TableViewConfigurator;
import Vista.utils.createLabeledField;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.acme.complejoacme.MainApplication;
import com.acme.complejoacme.Manager.ManagerController;

import Modelo.DataBaseConection;
import Modelo.DAO.LCEstado.CMGLCEstado;
import Modelo.DAO.LCEstado.LCEstadoO;
import Modelo.DAO.Personal.CMGPersonal;
import Modelo.DAO.Personal.PersonalO;
import Modelo.DAO.RPersonal.CMGRPersonal;
import Modelo.DAO.RPersonal.RPersonalO;
import Modelo.DAO.Restricciones.CMRetricciones;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.List;

public class AplicarRestriccionTab implements TabBuilder{
    private CMRetricciones cmRetricciones = CMRetricciones.getInstance();
    private CMGRPersonal cmgrPersonal = CMGRPersonal.getInstance();
    private RPersonalO rPersonalO;
    private Date fecha;
    private String usuarioResponsable;
    private int restriccion;
    private long idPersonal;
    private CMGLCEstado cmglcEstado = CMGLCEstado.getInstance();
    private LCEstadoO lcEstadoO;
    private CMGPersonal cmgPersonal = CMGPersonal.getInstance();
    private PersonalO personalO;

    @Override
    public Tab Crear(ManagerController controller) {
        Tab aplicarRestTab = new Tab();
        aplicarRestTab.setText("Aplicar Restriccion");

        
        FlowPane flowPane = new FlowPane();
        flowPane.setAlignment(Pos.CENTER);

        
        VBox mainVBox = new VBox();
        mainVBox.setPrefHeight(540.0);
        mainVBox.setPrefWidth(257.0);
        mainVBox.setSpacing(20.0);
        mainVBox.setAlignment(Pos.CENTER);

        
        ChoiceBox<String> aplicarRestTipoChoiceBox = new ChoiceBox<>();
        List<String> listIncidentes = cmRetricciones.getLista().stream().map(i -> i.getDescripcion()).collect(Collectors.toList());
        aplicarRestTipoChoiceBox.getItems().setAll(listIncidentes);
        aplicarRestTipoChoiceBox.setValue(listIncidentes.get(0));
        VBox vbox1 = createLabeledField.create("Seleccionar Restriccion", aplicarRestTipoChoiceBox, "aplicarRest_Tipo");
        vbox1.setPrefHeight(100.0);
        vbox1.setPrefWidth(327.0);

        controller.aplicarRest_Tipo = aplicarRestTipoChoiceBox;

        aplicarRestTipoChoiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            controller.aplicarRest_Tipo.setValue(newValue);
        });

        VBox vbox2 = createLabeledField.create("Identificador del personal a Restringir", new TextField(), "aplicarRest_Id");
        vbox2.setPrefHeight(100.0);
        vbox2.setPrefWidth(176.0);

        TextField aplicarRestIdTextField = (TextField) vbox2.getChildren().get(1);

        controller.aplicarRest_Id = aplicarRestIdTextField;

        aplicarRestIdTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            controller.aplicarRest_Id.setText(newValue);
        });


        controller.setInputsAplicarRestriccionTab(controller.getInputsAplicarRestriccionTab());
        controller.setInputsConsultarRestricciones(controller.getInputsConsultarRestricciones());

        
        HBox hboxButtons = new HBox();
        hboxButtons.setAlignment(Pos.CENTER);
        hboxButtons.setSpacing(30.0);

        Button buttonConsulta = new Button("Consultar Historial");
        buttonConsulta.setId("aplicarRest_buttonConsulta");
        buttonConsulta.setOnAction(e -> controller.procedimiento(controller.consultarRestriccion_Inputs,() -> {
            AnchorPane anchorPane = new AnchorPane();
            anchorPane.setPrefSize(553.0, 611.0);
            TableView tableView = new TableView<>();
            tableView.setPrefSize(553.0, 611.0);

            cmgrPersonal.reiniciarP();
            cmgrPersonal.getLista();

            List<RPersonalM> incidentesRelacionados =
                    cmgrPersonal.filtrarPorIdPersonal(Long.valueOf(controller.aplicarRest_Id.getText()));
            TableViewConfigurator.init(tableView, List.of("id","fecha",
                    "restriccionS"),  incidentesRelacionados);
            anchorPane.getChildren().add(tableView);
            MainApplication.startNormalScene(anchorPane);
        }));
        controller.aplicarRest_buttonConsulta = buttonConsulta;
        buttonConsulta.setDefaultButton(true);
        buttonConsulta.setMnemonicParsing(false);
        buttonConsulta.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        buttonConsulta.setWrapText(true);
        buttonConsulta.setCursor(javafx.scene.Cursor.HAND);

        Button buttonRestringir = new Button("Aplicar Restriccion");
        buttonRestringir.setId("aplicarRest_buttonRestringir");
        buttonRestringir.setOnAction(e -> controller.procedimiento(controller.aplicarRestriccion_Inputs,() -> {
            fecha = Date.valueOf(LocalDate.now());
            usuarioResponsable = DataBaseConection.getCurrentUser();
            restriccion = cmRetricciones.getLista().stream().filter(i->i.getDescripcion().equals(aplicarRestTipoChoiceBox.getValue())).map(i->i.getId())
            .collect(Collectors.toList()).get(0);
            idPersonal = Long.parseLong(aplicarRestIdTextField.getText());

            personalO = new PersonalO(idPersonal, usuarioResponsable, usuarioResponsable, usuarioResponsable, false, usuarioResponsable, restriccion);
            cmgPersonal.actualizarE(personalO);

            rPersonalO = new RPersonalO(0, fecha, usuarioResponsable, restriccion, idPersonal);
            cmgrPersonal.guardar(rPersonalO);

            lcEstadoO = new LCEstadoO(0, Timestamp.valueOf(LocalDateTime.now()), false, "Se aplico una restriccion", usuarioResponsable, idPersonal);
            cmglcEstado.guardar(lcEstadoO);
        }));
        controller.aplicarRest_buttonRestringir = buttonRestringir;
        buttonRestringir.setMnemonicParsing(false);
        buttonRestringir.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        buttonRestringir.setWrapText(true);
        buttonRestringir.setCursor(javafx.scene.Cursor.HAND);

        hboxButtons.getChildren().addAll(buttonConsulta, buttonRestringir);

        
        mainVBox.getChildren().addAll(vbox1, vbox2, hboxButtons);

        
        flowPane.getChildren().add(mainVBox);

        
        aplicarRestTab.setContent(flowPane);

        return aplicarRestTab;
    }
}