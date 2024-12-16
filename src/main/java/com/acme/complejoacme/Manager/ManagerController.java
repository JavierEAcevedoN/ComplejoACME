package com.acme.complejoacme.Manager;

import Vista.utils.Alerts.AlertaTab;
import com.acme.complejoacme.MainApplication;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ManagerController {
    // Ventana
    public VBox logOut;

    // Crear Usuario

    public ChoiceBox crearUsuario_Empresa;
    public ChoiceBox crearUsuario_Rol;
    public TextField crearUsuario_Usuario;
    public PasswordField crearUsuario_Pass;
    public Button crearUsuario_button;

    // Registar Personal
    public TextField crearPersonal_Id;
    public TextField crearPersonal_Nombre;
    public TextField crearPersonal_Dir;
    public TextField crearPersonal_Cont;
    public TextField crearPersonal_Usuario;
    public ChoiceBox crearPersonal_Rol;
    public Button crearPersonal_button;

    // Registar Vehiculo

    public TextField crearVehiculo_Id;
    public TextField crearVehiculo_Placa;
    public Button crearVehiculo_button;

    // Permiso Visitante

    public TextField permiso_Id;
    public DatePicker permiso_FechaInicio;
    public DatePicker permiso_FechaFin;
    public Button permiso_Button;

    // Acceso Personal
    public TextField accesoPersonal_Id;
    public Button accesoPersonal_button;


    // Acceso Vehicular
    public TextField accesoVehiculo_Placa;
    public Button accesoVehiculo_button;

    // Salida Personal
    public TextField salidaPersonal_Id;
    public Button salidaPersonal_button;

    // Salida Vehicular
    public TextField salidaVehiculo_Placa;
    public Button salidaVehiculo_button;

    // Incidentes
    public ChoiceBox incidentes_Tipo;
    public TextField incidentes_Id;
    public TextArea incidentes_Desc;
    public Button incidentes_buttonConsulta;
    public Button incidentes_buttonRegistrar;

    // Aplicar Restriccion
    public ChoiceBox aplicarRest_Tipo;
    public TextField aplicarRest_Id;
    public Button aplicarRest_buttonConsulta;
    public Button aplicarRest_buttonRestringir;

    // Levantar Restriccion
    public TextField levantarRest_Id;
    public TextArea levantarRest_Desc;
    public Button levantarRest_button;

    // Estado Personal
    public CheckBox ReporteEstado_Activos;
    public CheckBox ReporteEstado_Inactivos;
    public CheckBox ReporteEstado_Superv;
    public CheckBox ReporteEstado_Guardas;
    public CheckBox ReporteEstado_Funcion;
    public TableView ReporteEstado_Tabla;

    // Personal Empresa
    public ChoiceBox ReportePersonal_Empresa;
    public TableView ReportePersonal_Tabla;

    // Accesos
    public DatePicker ReporteAccesos_Inicio;
    public DatePicker ReporteAccesos_Fin;
    public TableView ReporteAccesos_Tabla;

    // Monitor
    public TableView Monitor;


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
            AlertaTab.Exito();
            return true;
        }
        AlertaTab.Incompletos();
        return false;
    };

    public void procedimiento(Control[] inputs,Runnable callback) {
        if (!respuestaValidacion(validarInputs(inputs))) return;
        callback.run();
    }

    public void exit() {
        Stage scene = (Stage) logOut.getScene().getWindow();
        scene.close();
        MainApplication.restartApplication();
    }
}