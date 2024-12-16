package Modelo.DAO.Personal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import Modelo.ConexionMG;
import Vista.utils.Alerts.AlertaTab;

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

    private void reiniciarP() {
        listaPersonal.clear();
        mostrar();
    }

    @Override
    public List<PersonalM> getLista() {
        if (listaPersonal.size() < 1) {
            try {
                ResultSet res = conexionBD.createStatement().executeQuery("CALL getpersonal;");
                while (res.next()) {
                    listaPersonal.add(
                        new PersonalM(
                            res.getLong("ID"),
                            res.getString("Nombre"),
                            res.getString("Direccion"),
                            res.getString("Contacto"),
                            res.getBoolean("Estado"),
                            res.getString("Usuario_Sistema"),
                            res.getString("Rol")
                        )
                    );
                }
            } catch (SQLException e) {
                System.err.println("Error al recuperar los datos de la tabla personal: " + e.getMessage());
            }
        }
        return listaPersonal;
    }

    @Override
    public void mostrar() {
        if (listaPersonal.size() < 1) {
            getLista();
        }
        listaPersonal.forEach(i -> System.out.println(i));
    }

    public void mostrarF(Predicate<PersonalM> filtro) {
        if (listaPersonal.size() < 1) {
            getLista();
        }
        listaPersonal.stream().filter(filtro).forEach(i -> System.out.println(i));
    }

    @Override
    public void guardar(PersonalO personal) {
        try {
            PreparedStatement pst = conexionBD.prepareStatement(
                "INSERT INTO personal(ID,Nombre,Direccion,Contacto,Estado,Usuario_Sistema,ID_Rol) VALUES(?,?,?,?,?,?,?);"
            );
            pst.setLong(1, personal.getId());
            pst.setString(2, personal.getNombre());
            pst.setString( 3, personal.getDireccion());
            pst.setString(4, personal.getContacto());
            pst.setBoolean(5, personal.isEstado());
            pst.setString(6, personal.getUsuarioSistema());
            pst.setInt(7, personal.getIdRol());
            pst.execute();
            reiniciarP();
        } catch (SQLException e) {
            System.err.println("Error al ingresar el dato en la tabla personal: " + e.getMessage());
            AlertaTab.Error();
        }
    };

    public void actualizar(PersonalO personal) {
        try {
            PreparedStatement pst = conexionBD.prepareStatement(
                "UPDATE personal SET Nombre = ?, Direccion = ?, Contacto = ?, Estado = ?, Usuario_Sistema = ?, ID_Rol = ? WHERE ID = ?;"
            );
            pst.setString(1, personal.getNombre());
            pst.setString( 2, personal.getDireccion());
            pst.setString(3, personal.getContacto());
            pst.setBoolean(4, personal.isEstado());
            pst.setString(5, personal.getUsuarioSistema());
            pst.setInt(6, personal.getIdRol());
            pst.setLong(7, personal.getId());
            pst.execute();
            reiniciarP();
        } catch (SQLException e) {
            System.err.println("Error al actualizar el dato en la tabla personal: " + e.getMessage());
        }
    };
}