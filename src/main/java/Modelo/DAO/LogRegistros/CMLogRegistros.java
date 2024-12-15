package Modelo.DAO.LogRegistros;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import Modelo.ConexionM;
import Modelo.DAO.Personal.PersonalM;

public class CMLogRegistros extends ConexionM{
    private static CMLogRegistros instance;
    private List<LogRegistrosM> listaLogRegistros = new ArrayList<>();

    private CMLogRegistros() {
        super();
    }

    public static CMLogRegistros getInstance() {
        if (instance == null) {
            instance = new CMLogRegistros();
        }
        return instance;
    }

    @Override
    public List<LogRegistrosM> getLista() {
        try {
            ResultSet res = conexionBD.createStatement().executeQuery("call getlogregistros;");
            while (res.next()) {
                listaLogRegistros.add(
                    new LogRegistrosM(
                        res.getInt("ID"),
                        res.getTimestamp("Fecha"),
                        new PersonalM(
                            res.getLong("ID_UC"),
                            res.getString("UC_N"),
                            res.getString("UC_D"),
                            res.getString("UC_C"),
                            res.getBoolean("UC_E"),
                            res.getString("UC_U"),
                            res.getString("UC_R")
                        ),
                        new PersonalM(
                            res.getLong("ID_PC"),
                            res.getString("PC_N"),
                            res.getString("PC_D"),
                            res.getString("PC_C"),
                            res.getBoolean("PC_E"),
                            res.getString("PC_U"),
                            res.getString("PC_R")
                        )
                    )
                );
            }
        } catch (SQLException e) {
            System.err.println("Error al recuperar los datos de la tabla logregistros: " + e.getMessage());
        }
        return listaLogRegistros;
    }

    @Override
    public void mostrar() {
        if (listaLogRegistros.size() < 1) {
            getLista();
        }
        listaLogRegistros.forEach(i -> System.out.println(i));
    }

    public void mostrarF(Predicate<LogRegistrosM> filtro) {
        if (listaLogRegistros.size() < 1) {
            getLista();
        }
        listaLogRegistros.stream().filter(filtro).forEach(i -> System.out.println(i));
    }
}