package Modelo.DAO.IPersonal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import Modelo.ConexionMG;
import Modelo.DAO.Personal.PersonalM;

public class CMGIPersonal extends ConexionMG<IPersonalO> {
    private static CMGIPersonal instance;
    private List<IPersonalM> listaCaPersonal = new ArrayList<>();

    private CMGIPersonal() {
        super();
    }

    public static CMGIPersonal getInstance() {
        if (instance == null) {
            instance = new CMGIPersonal();
        }
        return instance;
    }

    private void reiniciarP() {
        listaCaPersonal.clear();
        mostrar();
    }

    @Override
    public List<IPersonalM> getLista() {
        try {
            ResultSet res = conexionBD.createStatement().executeQuery("CALL getincidentespersonal;");
            while (res.next()) {
                listaCaPersonal.add(
                    new IPersonalM(
                        res.getInt("ID"),
                        res.getTimestamp("Fecha"),
                        res.getString("Descripcion"),
                        new PersonalM(
                            res.getLong("ID_UR"),
                            res.getString("UR_N"),
                            res.getString("UR_D"),
                            res.getString("UR_C"),
                            res.getBoolean("UR_E"),
                            res.getString("UR_U"),
                            res.getString("UR_R")
                        ),
                        res.getString("I_D"),
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
            System.err.println("Error al recuperar los datos de la tabla incidentespersonal: " + e.getMessage());
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

    public void mostrarF(Predicate<IPersonalM> filtro) {
        if (listaCaPersonal.size() < 1) {
            getLista();
        }
        listaCaPersonal.stream().filter(filtro).forEach(i -> System.out.println(i));
    }

    @Override
    public void guardar(IPersonalO iPersonal) {
        try {
            PreparedStatement pst = conexionBD.prepareStatement(
                "INSERT INTO incidentespersonal(Fecha,Descripcion,Usuario_Responsable,ID_Incidente,ID_Personal) VALUES(?,?,?,?,?);"
            );
            pst.setTimestamp(1, iPersonal.getFecha());
            pst.setString(2, iPersonal.getDescripcion());
            pst.setString(3, iPersonal.getUsuarioResponsable());
            pst.setInt(4, iPersonal.getIdIncidente());
            pst.setLong(5, iPersonal.getIdPersonal());
            pst.execute();
        } catch (SQLException e) {
            System.err.println("Error al ingresar el dato en la tabla incidentespersonal: " + e.getMessage());
        }
        reiniciarP();
    };

    public void actualizar(IPersonalO iPersonal) {
        try {
            PreparedStatement pst = conexionBD.prepareStatement(
                "UPDATE incidentespersonal SET Fecha = ?, Descripcion = ?, Usuario_Responsable = ?, ID_Incidente = ?, ID_Personal = ? WHERE ID = ?;"
            );
            pst.setTimestamp(1, iPersonal.getFecha());
            pst.setString(2, iPersonal.getDescripcion());
            pst.setString(3, iPersonal.getUsuarioResponsable());
            pst.setInt(4, iPersonal.getIdIncidente());
            pst.setLong(5, iPersonal.getIdPersonal());
            pst.setInt(6, iPersonal.getId());
            pst.execute();
        } catch (SQLException e) {
            System.err.println("Error al actualizar el dato en la tabla incidentespersonal: " + e.getMessage());
        }
        reiniciarP();
    };
}