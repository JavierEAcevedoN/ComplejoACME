package Modelo.DAO.CAPersonal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import Modelo.ConexionMG;
import Modelo.DAO.Personal.PersonalM;

public class CCAPersonal extends ConexionMG<CAPersonalO> {
    private static CCAPersonal instance;
    private List<CAPersonalM> listaCaPersonal = new ArrayList<>();

    private CCAPersonal() {
        super();
    }

    public static CCAPersonal getInstance() {
        if (instance == null) {
            instance = new CCAPersonal();
        }
        return instance;
    }

    private void reiniciarP() {
        listaCaPersonal.clear();
        mostrar();
    }

    @Override
    public List<CAPersonalM> getLista() {
        try {
            ResultSet res = conexionBD.createStatement().executeQuery("CALL getcapersonal;");
            while (res.next()) {
                listaCaPersonal.add(
                    new CAPersonalM(
                        res.getInt("ID_CAP"),
                        res.getTimestamp("Fecha_Entrada"),
                        res.getTimestamp("Fecha_Salida"),
                        new PersonalM(
                            res.getLong("ID_P"),
                            res.getString("Nombre"),
                            res.getString("Direccion"),
                            res.getString("Contacto"),
                            res.getBoolean("Estado"),
                            res.getString("Usuario_Sistema"),
                            res.getString("Rol")
                        )
                    )
                );
            }
        } catch (SQLException e) {
            System.err.println("Error al recuperar los datos de la tabla controlaccesospersonal: " + e.getMessage());
        }
        return listaCaPersonal;
    }

    @Override
    public void mostrar() {
        if (listaCaPersonal.size() < 1) {
            getLista();
        }
        listaCaPersonal.forEach(i -> System.out.println(i));
    }

    public void mostrarF(Predicate<CAPersonalM> filtro) {
        if (listaCaPersonal.size() < 1) {
            getLista();
        }
        listaCaPersonal.stream().filter(filtro).forEach(i -> System.out.println(i));
    }

    @Override
    public void guardar(CAPersonalO caPersonal) {
        try {
            PreparedStatement pst = conexionBD.prepareStatement(
                "INSERT INTO controlaccesospersonal(Fecha_Entrada,Fecha_Salida,ID_Personal) VALUES(?,?,?);"
            );
            pst.setTimestamp(1, caPersonal.getFechaEntrada());
            pst.setTimestamp( 2, caPersonal.getFechaSalida());
            pst.setLong(3, caPersonal.getIdPersonal());
            pst.execute();
        } catch (SQLException e) {
            System.err.println("Error al ingresar el dato en la tabla controlaccesospersonal: " + e.getMessage());
        }
        reiniciarP();
    };

    public void actualizar(CAPersonalO caPersonal) {
        try {
            PreparedStatement pst = conexionBD.prepareStatement(
                "UPDATE controlaccesospersonal SET Fecha_Entrada = ?, Fecha_Salida = ?, ID_Personal = ? WHERE ID = ?;"
            );
            pst.setTimestamp(1, caPersonal.getFechaEntrada());
            pst.setTimestamp( 2, caPersonal.getFechaSalida());
            pst.setLong(3, caPersonal.getIdPersonal());
            pst.setInt(4, caPersonal.getId());
            pst.execute();
        } catch (SQLException e) {
            System.err.println("Error al actualizar el dato en la tabla controlaccesospersonal: " + e.getMessage());
        }
        reiniciarP();
    };
}