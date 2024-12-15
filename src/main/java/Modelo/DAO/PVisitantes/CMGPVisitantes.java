package Modelo.DAO.PVisitantes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import Modelo.ConexionMG;
import Modelo.DAO.Personal.PersonalM;

public class CMGPVisitantes extends ConexionMG<PVisitantesO> {
    private static CMGPVisitantes instance;
    private List<PVisitantesM> listaCaPersonal = new ArrayList<>();

    private CMGPVisitantes() {
        super();
    }

    public static CMGPVisitantes getInstance() {
        if (instance == null) {
            instance = new CMGPVisitantes();
        }
        return instance;
    }

    private void reiniciarP() {
        listaCaPersonal.clear();
        mostrar();
    }

    @Override
    public List<PVisitantesM> getLista() {
        try {
            ResultSet res = conexionBD.createStatement().executeQuery("CALL getpermisosvisitantes;");
            while (res.next()) {
                listaCaPersonal.add(
                    new PVisitantesM(
                        res.getInt("ID"),
                        res.getDate("Fecha_Inicio"),
                        res.getDate("Fecha_Fin"),
                        new PersonalM(
                            res.getLong("ID_UR"),
                            res.getString("UR_N"),
                            res.getString("UR_D"),
                            res.getString("UR_C"),
                            res.getBoolean("UR_E"),
                            res.getString("UR_U"),
                            res.getString("UR_R")
                        ),
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
            System.err.println("Error al recuperar los datos de la tabla permisosvisitantes: " + e.getMessage());
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

    public void mostrarF(Predicate<PVisitantesM> filtro) {
        if (listaCaPersonal.size() < 1) {
            getLista();
        }
        listaCaPersonal.stream().filter(filtro).forEach(i -> System.out.println(i));
    }

    @Override
    public void guardar(PVisitantesO pVisitantes) {
        try {
            PreparedStatement pst = conexionBD.prepareStatement(
                "INSERT INTO permisosvisitantes(Fecha_Inicio,Fecha_Fin,Usuario_Responsable,ID_Personal) VALUES(?,?,?,?);"
            );
            pst.setDate(1, pVisitantes.getFechaInicio());
            pst.setDate( 2, pVisitantes.getFechaFin());
            pst.setString(3, pVisitantes.getUsuarioResponsable());
            pst.setLong(4, pVisitantes.getIdPersonal());
            pst.execute();
        } catch (SQLException e) {
            System.err.println("Error al ingresar el dato en la tabla permisosvisitantes: " + e.getMessage());
        }
        reiniciarP();
    };
}