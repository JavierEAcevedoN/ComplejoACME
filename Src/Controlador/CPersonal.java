package Controlador;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Modelo.*;

public class CPersonal extends Conexion<Personal> {
    private static CPersonal instance;

    private CPersonal() {
        super();
    }

    public static CPersonal getInstance() {
        if (instance == null) {
            instance = new CPersonal();
        }
        return instance;
    }

    @Override
    public void guardar(Personal personal) {
        try {
            PreparedStatement pst = conexionBD.prepareStatement("INSERT INTO personal(Nombre,Contacto,Direccion,Estado,ID_Rol) VALUES(?,?,?,?,?);");
            pst.setString(1, personal.getNombre());
            pst.setString(2, personal.getContacto());
            pst.setString(3, personal.getDireccion());
            pst.setBoolean(4, personal.isEstado());
            pst.setInt(5, personal.getIdRol());
            pst.execute();
        } catch (SQLException e) {
            System.err.println("Error al ingresar el dato en la tabla Personal: " + e.getMessage());
        }
    };
}