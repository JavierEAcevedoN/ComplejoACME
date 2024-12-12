package Controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Modelo.ConexionMG;
import Modelo.NotificarP;
import Modelo.Personal;

public class CPersonal extends ConexionMG<Personal> implements NotificarP{
    private static CPersonal instance;
    private List<Personal> listaPersonal = new ArrayList<>();

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
    public void actualizar() {
        listaPersonal.clear();
        mostrar();
    }

    @Override
    public void mostrar() {
        if (listaPersonal.size() < 1) {
            listaPersonal.clear();
            try {
                ResultSet res = conexionBD.createStatement().executeQuery("SELECT * FROM personal;");
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
                    "INSERT INTO personal(Nombre,Contacto,Direccion,Estado,ID_Rol) VALUES(?,?,?,?,?);");
            pst.setString(1, personal.getNombre());
            pst.setString(2, personal.getContacto());
            pst.setString(3, personal.getDireccion());
            pst.setBoolean(4, personal.isEstado());
            pst.setInt(5, personal.getIdRol());
            pst.execute();
        } catch (SQLException e) {
            System.err.println("Error al ingresar el dato en la tabla Personal: " + e.getMessage());
        }
        actualizar();
    };
}