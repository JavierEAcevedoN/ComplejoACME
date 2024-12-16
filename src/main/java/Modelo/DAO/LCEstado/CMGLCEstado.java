package Modelo.DAO.LCEstado;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import Modelo.ConexionMG;
import Modelo.DAO.Personal.PersonalM;

public class CMGLCEstado extends ConexionMG<LCEstadoO> {
    private static CMGLCEstado instance;
    private List<LCEstadoM> listaCaPersonal = new ArrayList<>();

    private CMGLCEstado() {
        super();
    }

    public static CMGLCEstado getInstance() {
        if (instance == null) {
            instance = new CMGLCEstado();
        }
        return instance;
    }

    private void reiniciarP() {
        listaCaPersonal.clear();
        mostrar();
    }

    @Override
    public List<LCEstadoM> getLista() {
        if (listaCaPersonal.size() < 1) {
            try {
                ResultSet res = conexionBD.createStatement().executeQuery("CALL getlogcambioestado;");
                while (res.next()) {
                    listaCaPersonal.add(
                        new LCEstadoM(
                            res.getInt("ID"),
                            res.getTimestamp("Fecha"),
                            res.getBoolean("Nuevo_Estado"),
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
                System.err.println("Error al recuperar los datos de la tabla logcambioestado: " + e.getMessage());
            }
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

    public void mostrarF(Predicate<LCEstadoM> filtro) {
        if (listaCaPersonal.size() < 1) {
            getLista();
        }
        listaCaPersonal.stream().filter(filtro).forEach(i -> System.out.println(i));
    }

    @Override
    public void guardar(LCEstadoO lcEstado) {
        try {
            PreparedStatement pst = conexionBD.prepareStatement(
                "INSERT INTO logcambioestado(Fecha,Nuevo_Estado,Descripcion,Usuario_Responsable,ID_Personal) VALUES(?,?,?,?,?);"
            );
            pst.setTimestamp(1, lcEstado.getFecha());
            pst.setBoolean(2, lcEstado.isNuevoEstado());
            pst.setString(3, lcEstado.getDescripcion());
            pst.setString(4, lcEstado.getUsuarioResponsable());
            pst.setLong(5, lcEstado.getIdPersonal());
            pst.execute();
            reiniciarP();
        } catch (SQLException e) {
            System.err.println("Error al ingresar el dato en la tabla logcambioestado: " + e.getMessage());
        }
    };
}