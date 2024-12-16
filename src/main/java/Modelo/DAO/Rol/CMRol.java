package Modelo.DAO.Rol;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import Modelo.ConexionM;

public class CMRol extends ConexionM{
    private static CMRol instance;
    private List<RolM> listaRol = new ArrayList<>();

    private CMRol() {
        super();
    }

    public static CMRol getInstance() {
        if (instance == null) {
            instance = new CMRol();
        }
        return instance;
    }

    @Override
    public List<RolM> getLista() {
        if (listaRol.size() < 1) {
            try {
                ResultSet res = conexionBD.createStatement().executeQuery("SELECT * FROM rol;");
                while (res.next()) {
                    listaRol.add(
                        new RolM(
                            res.getInt("ID"),
                            res.getString("Rol")
                        )
                    );
                }
            } catch (SQLException e) {
                System.err.println("Error al recuperar los datos de la tabla rol: " + e.getMessage());
            }
        }
        return listaRol;
    }

    @Override
    public void mostrar() {
        if (listaRol.size() < 1) {
            getLista();
        }
        listaRol.forEach(i -> System.out.println(i));
    }

    public void mostrarF(Predicate<RolM> filtro) {
        if (listaRol.size() < 1) {
            getLista();
        }
        listaRol.stream().filter(filtro).forEach(i -> System.out.println(i));
    }
}