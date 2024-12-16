package Modelo.DAO.EmpPersonal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import Modelo.ConexionMG;
import Modelo.DAO.Empresas.EmpresasM;
import Modelo.DAO.Personal.PersonalM;
import Vista.utils.Alerts.AlertaTab;

public class CMGEPersonal extends ConexionMG<EmpPersonalO> {
    private static CMGEPersonal instance;
    private List<EmpPersonalM> listaEmpPersonal= new ArrayList<>();

    private CMGEPersonal() {
        super();
    }

    public static CMGEPersonal getInstance() {
        if (instance == null) {
            instance = new CMGEPersonal();
        }
        return instance;
    }

    private void reiniciarP() {
        listaEmpPersonal.clear();
        mostrar();
    }

    @Override
    public List<EmpPersonalM> getLista() {
        if (listaEmpPersonal.size() < 1) {
            try {
                ResultSet res = conexionBD.createStatement().executeQuery("CALL getempresapersonal;");
                while (res.next()) {
                    listaEmpPersonal.add(
                        new EmpPersonalM(
                            new EmpresasM(
                                res.getInt("ID_E"),
                                res.getString("N_E"),
                                res.getString("E_C")
                            ),
                            res.getInt("ID_EP"),
                            new PersonalM(
                                res.getLong("ID_P"),
                                res.getString("N_P"),
                                res.getString("Direccion"),
                                res.getString("P_C"),
                                res.getBoolean("Estado"),
                                res.getString("Usuario_Sistema"),
                                res.getString("Rol")
                            )
                        )
                    );
                }
            } catch (SQLException e) {
                System.err.println("Error al recuperar los datos de la tabla empresaspersonal: " + e.getMessage());
            }
        }
        return listaEmpPersonal;
    }

    @Override
    public void mostrar() {
        if (listaEmpPersonal.size() < 1) {
            getLista();
        }
        listaEmpPersonal.forEach(i -> System.out.println(i));
    }

    public void mostrarF(Predicate<EmpPersonalM> filtro) {
        if (listaEmpPersonal.size() < 1) {
            getLista();
        }
        listaEmpPersonal.stream().filter(filtro).forEach(i -> System.out.println(i));
    }

    @Override
    public void guardar(EmpPersonalO empPersonal) {
        try {
            PreparedStatement pst = conexionBD.prepareStatement(
                "INSERT INTO empresaspersonal(ID_Empresa,ID_Personal) VALUES(?,?);"
            );
            pst.setInt(1, empPersonal.getIdEmpresa());
            pst.setLong( 2, empPersonal.getIdPersonal());
            pst.execute();
            AlertaTab.Exito();
            reiniciarP();
        } catch (SQLException e) {
            System.err.println("Error al ingresar el dato en la tabla empresaspersonal: " + e.getMessage());
            AlertaTab.Error();
        }
    };

    public void actualizar(EmpPersonalO empPersonal) {
        try {
            PreparedStatement pst = conexionBD.prepareStatement(
                "UPDATE empresaspersonal SET ID_Empresa = ?, ID_Personal = ? WHERE ID = ?;"
            );
            pst.setInt(1, empPersonal.getIdEmpresa());
            pst.setLong( 2, empPersonal.getIdPersonal());
            pst.setInt(3, empPersonal.getId());
            pst.execute();
            reiniciarP();
        } catch (SQLException e) {
            System.err.println("Error al actualizar el dato en la tabla empresaspersonal: " + e.getMessage());
        }
    };
}