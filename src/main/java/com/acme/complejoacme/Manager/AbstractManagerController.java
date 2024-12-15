package com.acme.complejoacme.Manager;

import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public abstract class AbstractManagerController{
    // Ventana
    public Text roleDisplay;
    public ImageView logOut;

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
}