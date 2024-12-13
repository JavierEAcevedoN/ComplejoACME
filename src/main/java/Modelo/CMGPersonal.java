package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CMGPersonal extends ConexionMG<Personal> {
    private static CMGPersonal instance;
    private List<Personal> listaPersonal = new ArrayList<>();

    private CMGPersonal() {
        super();
    }

    public static CMGPersonal getInstance() {
        if (instance == null) {
            instance = new CMGPersonal();
        }
        return instance;
    }

    public void actualizar() {
        listaPersonal.clear();
        mostrar();
    }

    @Override
    public void mostrar() {
        if (listaPersonal.size() < 1) {
            listaPersonal.clear();
            try {
                ResultSet res = conexionBD.createStatement().executeQuery("SELECT * FROM Personal;");
                while (res.next()) {
                    listaPersonal.add(
                            new Personal(
                                res.getInt("ID"),
                                res.getString("Nombre"),
                                res.getString("Direccion"),
                                res.getString("Contacto"),
                                res.getBoolean("Estado"),
                                res.getInt("ID_Rol")
                        )
                    );
                }
            } catch (SQLException e) {
                System.err.println("Error al ingresar el dato en la tabla Personal: " + e.getMessage());
            }
        }
        listaPersonal.forEach(i -> System.out
                .println("ID: " + i.getId() + ", Nombre: " + i.getNombre() + ", Direccion: " + i.getDireccion()
                        + ", Contacto: " + i.getContacto() + ", Estado: " + i.isEstado() + ", ID Rol: " + i.getIdRol()));
    }

    @Override
    public void guardar(Personal personal) {
        try {
            PreparedStatement pst = conexionBD.prepareStatement(
                    "INSERT INTO Personal(Nombre,Contacto,Direccion,Estado,ID_Rol) VALUES(?,?,?,?,?);");
            pst.setString(1, personal.getNombre());
            pst.setString(2, personal.getContacto());
            pst.setString( 3, personal.getDireccion());
            pst.setBoolean(4, personal.isEstado());
            pst.setInt(5, personal.getIdRol());
            pst.execute();
        } catch (SQLException e) {
            System.err.println("Error al ingresar el dato en la tabla Personal: " + e.getMessage());
        }
        actualizar();
    };
}