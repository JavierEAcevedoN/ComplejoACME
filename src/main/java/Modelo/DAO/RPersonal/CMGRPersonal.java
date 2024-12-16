package Modelo.DAO.RPersonal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import Modelo.ConexionMG;
import Modelo.DAO.Personal.PersonalM;

public class CMGRPersonal extends ConexionMG<RPersonalO> {
    private static CMGRPersonal instance;
    private List<RPersonalM> listaRPersonal = new ArrayList<>();

    private CMGRPersonal() {
        super();
    }

    public static CMGRPersonal getInstance() {
        if (instance == null) {
            instance = new CMGRPersonal();
        }
        return instance;
    }

    private void reiniciarP() {
        listaRPersonal.clear();
        mostrar();
    }

    @Override
    public List<RPersonalM> getLista() {
        if (listaRPersonal.size() < 1) {
            try {
                ResultSet res = conexionBD.createStatement().executeQuery("CALL getrestriccionespersonal;");
                while (res.next()) {
                    listaRPersonal.add(
                        new RPersonalM(
                            res.getInt("ID"),
                            res.getDate("Fecha"),
                            new PersonalM(
                                res.getLong("ID_UR"),
                                res.getString("UR_N"),
                                res.getString("UR_D"),
                                res.getString("UR_C"),
                                res.getBoolean("UR_E"),
                                res.getString("UR_U"),
                                res.getString("UR_R")
                            ),
                            res.getString("Descripcion"),
                            new PersonalM(
                                res.getLong("ID_P"),
                                res.getString("P_N"),
                                res.getString("P_D"),
                                res.getString("P_C"),
                                res.getBoolean("P_E"),
                                res.getString("P_U"),
                                res.getString("P_R")
                            )
                        )
                    );
                }
            } catch (SQLException e) {
                System.err.println("Error al recuperar los datos de la tabla restriccionespersonal: " + e.getMessage());
            }
        }
        return listaRPersonal;
    }

    @Override
    public void mostrar() {
        if (listaRPersonal.size() < 1) {
            getLista();
        }
        listaRPersonal.forEach(i -> System.out.println(i));
    }

    public void mostrarF(Predicate<RPersonalM> filtro) {
        if (listaRPersonal.size() < 1) {
            getLista();
        }
        listaRPersonal.stream().filter(filtro).forEach(i -> System.out.println(i));
    }

    @Override
    public void guardar(RPersonalO rPersonal) {
        try {
            PreparedStatement pst = conexionBD.prepareStatement(
                "INSERT INTO restriccionespersonal(Fecha,Usuario_Responsable,ID_Restriccion,ID_Personal) VALUES(?,?,?,?);"
            );
            pst.setDate(1, rPersonal.getFecha());
            pst.setString( 2, rPersonal.getUsuarioResponsable());
            pst.setInt(3, rPersonal.getRestriccion());
            pst.setLong(4, rPersonal.getIdPersonal());
            pst.execute();
            reiniciarP();
        } catch (SQLException e) {
            System.err.println("Error al ingresar el dato en la tabla restriccionespersonal: " + e.getMessage());
        }
    };

    public void actualizar(RPersonalO rPersonal) {
        try {
            PreparedStatement pst = conexionBD.prepareStatement(
                "UPDATE restriccionespersonal SET Fecha = ?, Usuario_Responsable = ?, ID_Restriccion = ?, ID_Personal = ? WHERE ID = ?;"
            );
            pst.setDate(1, rPersonal.getFecha());
            pst.setString( 2, rPersonal.getUsuarioResponsable());
            pst.setInt(3, rPersonal.getRestriccion());
            pst.setLong(4, rPersonal.getIdPersonal());
            pst.setInt(5, rPersonal.getId());
            pst.execute();
            reiniciarP();
        } catch (SQLException e) {
            System.err.println("Error al actualizar el dato en la tabla restriccionespersonal: " + e.getMessage());
        }
    };
}