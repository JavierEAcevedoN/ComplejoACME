package Vista.Manager.Tab;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.acme.complejoacme.MainApplication;
import com.acme.complejoacme.Manager.ManagerController;

import Modelo.DAO.IPersonal.CMGIPersonal;
import Modelo.DAO.IPersonal.IPersonalM;
import Modelo.DAO.IPersonal.IPersonalO;
import Modelo.DAO.Incidentes.CMIncidentes;
import Modelo.DataBaseConection;
import Vista.utils.TableViewConfigurator;
import Vista.utils.createLabeledField;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class IncidentesTab implements TabBuilder{
    CMGIPersonal cmgiPersonal = CMGIPersonal.getInstance();
    CMIncidentes cmIncidentes = CMIncidentes.getInstance();
    IPersonalO iPersonalO;
    private Timestamp fecha;
    private String descripcion;
    private int idIncidente;
    private long idPersonal;

    @Override
    public Tab Crear(ManagerController controller) {
        Tab incidentesTab = new Tab();
        incidentesTab.setText("Incidentes");

        
        FlowPane flowPane = new FlowPane();
        flowPane.setAlignment(Pos.CENTER);

        
        VBox mainVBox = new VBox();
        mainVBox.setPrefHeight(540.0);
        mainVBox.setPrefWidth(450.0);
        mainVBox.setSpacing(20.0);
        mainVBox.setAlignment(Pos.CENTER);

        
        HBox firstHBox = new HBox();
        firstHBox.setAlignment(Pos.CENTER);
        firstHBox.setPrefHeight(100.0);
        firstHBox.setPrefWidth(200.0);
        firstHBox.setSpacing(20.0);

        
        ChoiceBox<String> incidentesTipoChoiceBox = new ChoiceBox<>();
        List<String> listIncidentes = cmIncidentes.getLista().stream().map(i -> i.getDescripcion()).collect(Collectors.toList());
        incidentesTipoChoiceBox.getItems().setAll(listIncidentes);
        incidentesTipoChoiceBox.setValue(listIncidentes.get(0));
        VBox vbox1 = createLabeledField.create("Seleccionar Incidente", incidentesTipoChoiceBox, "incidentes_Tipo");
        controller.incidentes_Tipo = incidentesTipoChoiceBox;
        vbox1.setPrefHeight(100.0);
        vbox1.setPrefWidth(201.0);

        incidentesTipoChoiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            controller.incidentes_Tipo.setValue(newValue);
        });

        VBox vbox2 = createLabeledField.create("Identificador del personal Implicado", new TextField(), "incidentes_Id");
        TextField incidentesIdTextField = (TextField) vbox2.getChildren().get(1);
        controller.incidentes_Id = incidentesIdTextField;
        vbox2.setPrefHeight(100.0);
        vbox2.setPrefWidth(176.0);

        incidentesIdTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            controller.incidentes_Id.setText(newValue);
        });


        
        firstHBox.getChildren().addAll(vbox1, vbox2);

        
        HBox secondHBox = new HBox();
        secondHBox.setAlignment(Pos.CENTER);
        secondHBox.setPrefHeight(175.0);
        secondHBox.setPrefWidth(450.0);

        VBox vbox3 = new VBox();
        vbox3.setSpacing(8.0);
        vbox3.setAlignment(Pos.CENTER_LEFT);
        vbox3.setPrefHeight(144.0);
        vbox3.setPrefWidth(450.0);

        Label descripcionLabel = new Label("Descripcion del suceso");
        descripcionLabel.setWrapText(true);

        TextArea textArea = new TextArea();
        textArea.setId("incidentes_Desc");
        controller.incidentes_Desc = textArea;
        textArea.setPrefHeight(101.0);
        textArea.setPrefWidth(450.0);

        textArea.textProperty().addListener((observable, oldValue, newValue) -> {
            controller.incidentes_Desc.setText(newValue);
        });

        vbox3.getChildren().addAll(descripcionLabel, textArea);

        secondHBox.getChildren().add(vbox3);

        controller.setInputsIncidentesTab(controller.getInputsIncidentesTab());
        controller.setInputsConsultarIncidentes(controller.getInputsConsultarIncidentes());

        
        HBox thirdHBox = new HBox();
        thirdHBox.setAlignment(Pos.CENTER);
        thirdHBox.setSpacing(30.0);

        Button buttonConsulta = new Button("Consultar Historial");
        buttonConsulta.setId("incidentes_buttonConsulta");
        buttonConsulta.setOnAction(e -> controller.procedimiento(controller.consultarIncidentes_Inputs,() -> {

            AnchorPane anchorPane = new AnchorPane();
            anchorPane.setPrefSize(553.0, 611.0);
            TableView tableView = new TableView<>();
            tableView.setPrefSize(553.0, 611.0);

            cmgiPersonal.reiniciarP();
            cmgiPersonal.getLista();

            List<IPersonalM> incidentesRelacionados =
                    cmgiPersonal.filtrarPorIdPersonal(Long.valueOf(controller.incidentes_Id.getText()));
            TableViewConfigurator.init(tableView, List.of("id","fecha","descripcion",
                    "incidente"),  incidentesRelacionados);
            anchorPane.getChildren().add(tableView);
            MainApplication.startNormalScene(anchorPane);
        }));

        controller.incidentes_buttonConsulta = buttonConsulta;
        buttonConsulta.setDefaultButton(true);
        buttonConsulta.setMnemonicParsing(false);
        buttonConsulta.setCursor(javafx.scene.Cursor.HAND);

        Button buttonRegistrar = new Button("Registrar Incidente");
        buttonRegistrar.setId("incidentes_buttonRegistrar");
        buttonRegistrar.setOnAction(e -> controller.procedimiento(controller.incidentes_Inputs,() -> {
            fecha = Timestamp.valueOf(LocalDateTime.now());
            descripcion = textArea.getText();
            idPersonal = Long.parseLong(incidentesIdTextField.getText());
            idIncidente = cmIncidentes.getLista().stream().filter(i->i.getDescripcion().equals(incidentesTipoChoiceBox.getValue())).map(i->i.getId())
            .collect(Collectors.toList()).get(0);

            iPersonalO = new IPersonalO(0, fecha, descripcion, DataBaseConection.getCurrentUser(), idIncidente, idPersonal);
            cmgiPersonal.guardar(iPersonalO);
        }));
        controller.incidentes_buttonRegistrar = buttonRegistrar;
        buttonRegistrar.setMnemonicParsing(false);
        buttonRegistrar.setCursor(javafx.scene.Cursor.HAND);

        thirdHBox.getChildren().addAll(buttonConsulta, buttonRegistrar);

        mainVBox.getChildren().addAll(firstHBox, secondHBox, thirdHBox);

        flowPane.getChildren().add(mainVBox);

        incidentesTab.setContent(flowPane);

        return incidentesTab;
    }
}