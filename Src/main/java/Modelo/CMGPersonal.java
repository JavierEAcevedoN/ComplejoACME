package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CMGPersonal extends ConexionMG<PersonalO> {
    private static CMGPersonal instance;
    private List<PersonalM> listaPersonal = new ArrayList<>();

    private CMGPersonal() {
        super();
    }

    public static CMGPersonal getInstance() {
        if (instance == null) {
            instance = new CMGPersonal();
        }
        return instance;
    }

    public void reiniciarP() {
        listaPersonal.clear();
        mostrar();
    }

    @Override
    public void mostrar() {
        if (listaPersonal.size() < 1) {
            listaPersonal.clear();
            try {
                ResultSet res = conexionBD.createStatement().executeQuery("CALL getpersonal;");
                while (res.next()) {
                    listaPersonal.add(
                            new PersonalM(
                                res.getInt("ID"),
                                res.getString("Nombre"),
                                res.getString("Direccion"),
                                res.getString("Contacto"),
                                res.getBoolean("Estado"),
                                res.getString("Rol")
                        )
                    );
                }
            } catch (SQLException e) {
                System.err.println("Error al ingresar el dato en la tabla Personal: " + e.getMessage());
            }
        }
        listaPersonal.forEach(i -> System.out
                .println("ID: " + i.getId() + ", Nombre: " + i.getNombre() + ", Direccion: " + i.getDireccion()
                        + ", Contacto: " + i.getContacto() + ", Estado: " + i.isEstado() + ", Rol: " + i.getRol()));
    }

    @Override
    public void guardar(PersonalO personal) {
        try {
            PreparedStatement pst = conexionBD.prepareStatement(
                "INSERT INTO personal(Nombre,Direccion,Contacto,Estado,ID_Rol) VALUES(?,?,?,?,?);"
            );
            pst.setString(1, personal.getNombre());
            pst.setString( 2, personal.getDireccion());
            pst.setString(3, personal.getContacto());
            pst.setBoolean(4, personal.isEstado());
            pst.setInt(5, personal.getIdRol());
            pst.execute();
        } catch (SQLException e) {
            System.err.println("Error al ingresar el dato en la tabla Personal: " + e.getMessage());
        }
        reiniciarP();
    };

    public void actualizar(PersonalO personal) {
        try {
            PreparedStatement pst = conexionBD.prepareStatement(
                "UPDATE personal SET Nombre = ?, Direccion = ?, Contacto = ?, Estado = ?, ID_Rol = ? WHERE ID = ?;"
            );
            pst.setString(1, personal.getNombre());
            pst.setString( 2, personal.getDireccion());
            pst.setString(3, personal.getContacto());
            pst.setBoolean(4, personal.isEstado());
            pst.setInt(5, personal.getIdRol());
            pst.setInt(6, personal.getId());
            pst.execute();
        } catch (SQLException e) {
            System.err.println("Error al ingresar el dato en la tabla Personal: " + e.getMessage());
        }
        reiniciarP();
    };
}