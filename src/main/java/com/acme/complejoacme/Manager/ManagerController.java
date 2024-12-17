package com.acme.complejoacme.Manager;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.stream.Collectors;

import com.acme.complejoacme.MainApplication;

import Modelo.DAO.Personal.CMGPersonal;
import Modelo.DAO.Personal.PersonalM;
import Vista.utils.Alerts.AlertaTab;
import Vista.utils.TableViewConfigurator;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Control;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ManagerController {

    public Timestamp now;


    
    public VBox logOut;

    

    public ChoiceBox crearUsuario_Empresa;
    public ChoiceBox crearUsuario_Rol;
    public TextField crearUsuario_Usuario;
    public PasswordField crearUsuario_Pass;
    public Button crearUsuario_button;

    
    public TextField crearPersonal_Id;
    public TextField crearPersonal_Nombre;
    public TextField crearPersonal_Dir;
    public TextField crearPersonal_Cont;
    public TextField crearPersonal_Usuario;
    public ChoiceBox crearPersonal_Rol;
    public Button crearPersonal_button;

    

    public TextField crearVehiculo_Id;
    public TextField crearVehiculo_Placa;
    public Button crearVehiculo_button;

    

    public TextField permiso_Id;
    public DatePicker permiso_FechaInicio;
    public DatePicker permiso_FechaFin;
    public Button permiso_Button;

    
    public TextField accesoPersonal_Id;
    public Button accesoPersonal_button;


    
    public TextField accesoVehiculo_Placa;
    public Button accesoVehiculo_button;

    
    public TextField salidaPersonal_Id;
    public Button salidaPersonal_button;

    
    public TextField salidaVehiculo_Placa;
    public Button salidaVehiculo_button;

    
    public ChoiceBox incidentes_Tipo;
    public TextField incidentes_Id;
    public TextArea incidentes_Desc;
    public Button incidentes_buttonConsulta;
    public Button incidentes_buttonRegistrar;

    
    public ChoiceBox aplicarRest_Tipo;
    public TextField aplicarRest_Id;
    public Button aplicarRest_buttonConsulta;
    public Button aplicarRest_buttonRestringir;

    
    public TextField levantarRest_Id;
    public TextArea levantarRest_Desc;
    public Button levantarRest_button;

    
    public CheckBox ReporteEstado_Activos;
    public CheckBox ReporteEstado_Inactivos;
    public CheckBox ReporteEstado_Superv;
    public CheckBox ReporteEstado_Guardas;
    public CheckBox ReporteEstado_Funcion;
    public TableView ReporteEstado_Tabla;

    
    public ChoiceBox ReportePersonal_Empresa;
    public TableView ReportePersonal_Tabla;

    
    public DatePicker ReporteAccesos_Inicio;
    public DatePicker ReporteAccesos_Fin;
    public TableView ReporteAccesos_Tabla;

    

    public TableView Monitor;
    private ScheduledExecutorService executorService;


    public Control[] crearUsuario_Inputs;
    public Control[] registrarPersonal_Inputs;
    public Control[] registrarVehiculo_Inputs;
    public Control[] permisoVisitante_Inputs;
    public Control[] accesoPersonal_Inputs;
    public Control[] accesoVehicular_Inputs;
    public Control[] salidaPersonal_Inputs;
    public Control[] salidaVehicular_Inputs;
    public Control[] incidentes_Inputs;
    public Control[] consultarIncidentes_Inputs;
    public Control[] aplicarRestriccion_Inputs;
    public Control[] consultarRestriccion_Inputs;
    public Control[] levantarRestriccion_Inputs;
    public Control[] estadoPersonal_Inputs;
    public Control[] personalEmpresa_Inputs;
    public Control[] accesos_Inputs;




    public Control[] getInputsCrearUsuarioTab() {
        return new Control[]{crearUsuario_Empresa, crearUsuario_Rol, crearUsuario_Usuario, crearUsuario_Pass};
    }

    public void setInputsCrearUsuarioTab(Control[] inputs) {
        this.crearUsuario_Inputs = inputs;
    }

    public Control[] getInputsRegistrarPersonalTab() {
        return new Control[]{crearPersonal_Id,crearPersonal_Nombre,crearPersonal_Dir,crearPersonal_Cont,crearPersonal_Usuario,crearPersonal_Rol};
    }

    public void setInputsRegistrarPersonalTab(Control[] inputs) {
        this.registrarPersonal_Inputs = inputs;
    }

    public Control[] getInputsRegistrarVehiculoTab() {
        return new Control[]{crearVehiculo_Id,crearVehiculo_Placa};
    }

    public void setInputsRegistrarVehiculoTab(Control[] inputs) {
        this.registrarVehiculo_Inputs = inputs;
    }

    public Control[] getInputsPermisoTab() {
        return new Control[]{permiso_Id,permiso_FechaInicio,permiso_FechaFin};
    }

    public void setInputsPermisoTab(Control[] inputs) {
        this.permisoVisitante_Inputs = inputs;
    }

    public Control[] getInputsAccesoPersonalTab() {
        return new Control[]{accesoPersonal_Id};
    }

    public void setInputsAccesoPersonalTab(Control[] inputs) {
        this.accesoPersonal_Inputs = inputs;
    }

    public Control[] getInputsAccesoVehiculoTab() {
        return new Control[]{accesoVehiculo_Placa};
    }

    public void setInputsAccesoVehiculoTab(Control[] inputs) {
        this.accesoVehicular_Inputs = inputs;
    }

    public Control[] getInputsSalidaPersonalTab() {
        return new Control[]{salidaPersonal_Id};
    }

    public void setInputsSalidaPersonalTab(Control[] inputs) {
        this.salidaPersonal_Inputs = inputs;
    }

    public Control[] getInputsSalidaVehiculoTab() {
        return new Control[]{salidaVehiculo_Placa};
    }

    public void setInputsSalidaVehiculoTab(Control[] inputs) {
        this.salidaVehicular_Inputs = inputs;
    }

    public Control[] getInputsIncidentesTab() {
        return new Control[]{incidentes_Tipo,incidentes_Id,incidentes_Desc};
    }

    public void setInputsIncidentesTab(Control[] inputs) {
        this.incidentes_Inputs = inputs;
    }

    public Control[] getInputsConsultarIncidentes() {
        return new Control[]{incidentes_Id};
    }

    public void setInputsConsultarIncidentes(Control[] inputs) {
        this.consultarIncidentes_Inputs = inputs;
    }

    public Control[] getInputsAplicarRestriccionTab() {
        return new Control[]{aplicarRest_Tipo,aplicarRest_Id};
    }

    public void setInputsAplicarRestriccionTab(Control[] inputs) {
        this.aplicarRestriccion_Inputs = inputs;
    }

    public Control[] getInputsConsultarRestricciones() {
        return new Control[]{aplicarRest_Id};
    }

    public void setInputsConsultarRestricciones(Control[] inputs) {
        this.consultarRestriccion_Inputs = inputs;
    }

    public Control[] getInputsLevantarRestriccionTab() {
        return new Control[]{levantarRest_Id,levantarRest_Desc};
    }

    public void setInputsLevantarRestriccionTab(Control[] inputs) {
        this.levantarRestriccion_Inputs = inputs;
    }

    public Control[] getInputsEstadoPersonalTab() {
        return new Control[]{ReporteEstado_Activos,ReporteEstado_Inactivos,ReporteEstado_Superv,ReporteEstado_Guardas,ReporteEstado_Funcion};
    }

    public void setInputsEstadoPersonalTab(Control[] inputs) {
        this.estadoPersonal_Inputs = inputs;
    }

    public Control[] getInputsPersonalEmpresasTab() {
        return new Control[]{ReportePersonal_Empresa,ReportePersonal_Tabla};
    }

    public void setInputsPersonalEmpresasTab(Control[] inputs) {
        this.personalEmpresa_Inputs = inputs;
    }

    public Control[] getInputsAccesosTab() {
        return new Control[]{ReporteAccesos_Inicio,ReporteAccesos_Fin};
    }

    public void setInputsAccesosTab(Control[] inputs) {
        this.accesos_Inputs = inputs;
    }

    protected boolean validarInputs(Control[] inputs) {
        boolean Ok = true;
        for (Control input : inputs) {

            if (input instanceof TextInputControl) {
                if (((TextInputControl) input).getText() == null || ((TextInputControl) input).getText().trim().isEmpty()) {
                    Ok = false;
                    break;
                }
            } else if (input instanceof ChoiceBox) {
                if (((ChoiceBox<?>) input).getSelectionModel().getSelectedItem() == null) {
                    Ok = false;
                    break;
                }
            } else if (input instanceof DatePicker) {
                if (((DatePicker) input).getValue() == null) {
                    Ok = false;
                    break;
                }
            }
        }
        return Ok;
    }

    private boolean respuestaValidacion(boolean Ok) {
        if (Ok) {
            return true;
        }
        AlertaTab.Incompletos();
        return false;
    };

    public void procedimiento(Control[] inputs,Runnable callback) {
        if (!respuestaValidacion(validarInputs(inputs))) return;
        callback.run();
    }

    public void procedimientoCheckBox(Control[] inputs, TableView<PersonalM> tableView) {
        List<PersonalM> base = CMGPersonal.getInstance().getLista();
        final CheckBox activo = (CheckBox) inputs[0];
        final CheckBox inactivo = (CheckBox) inputs[1];
        final CheckBox supervisor = (CheckBox) inputs[2];
        final CheckBox guarda = (CheckBox) inputs[3];
        final CheckBox funcionario = (CheckBox) inputs[4];
        List<PersonalM> personal = new ArrayList<>();
        if (activo.isSelected()) {
            personal.addAll(base.stream().filter(i->i.getEstado() == true).collect(Collectors.toList()));
        }
        if (inactivo.isSelected()) {
            personal.addAll(base.stream().filter(i->i.getEstado() == false).collect(Collectors.toList()));
        }
        List<PersonalM> resultado = new ArrayList<>();
        if (supervisor.isSelected() || guarda.isSelected() || funcionario.isSelected()) {
            if (supervisor.isSelected()) {
                resultado.addAll(personal.stream().filter(i->i.getRol().equals("Supervisor")).collect(Collectors.toList()));
            }
            if (guarda.isSelected()) {
                resultado.addAll(personal.stream().filter(i->i.getRol().equals("Guarda")).collect(Collectors.toList()));
            }
            if (funcionario.isSelected()) {
                resultado.addAll(personal.stream().filter(i->i.getRol().equals("Funcionario")).collect(Collectors.toList()));
            }
        } else {
            resultado = personal;
        }
        TableViewConfigurator.init(tableView, List.of("id_Personal","nombre","direccion","contacto","estado", "usuarioSistema","rol"), resultado );
    }

    public void getTime() {
        
        LocalDateTime localDateTime = LocalDateTime.now();

        
        Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());

        
        now = new Timestamp(date.getTime());
    }
    public void exit() {
        Stage scene = (Stage) logOut.getScene().getWindow();
        scene.close();
        MainApplication.restartApplication();
    }
}