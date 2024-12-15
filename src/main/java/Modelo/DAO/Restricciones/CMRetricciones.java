package Modelo.DAO.Restricciones;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import Modelo.ConexionM;

public class CMRetricciones extends ConexionM {
    private static CMRetricciones instance;
    private List<RetriccionesM> listaRestricciones = new ArrayList<>();

    private CMRetricciones() {
        super();
    }

    public static CMRetricciones getInstance() {
        if (instance == null) {
            instance = new CMRetricciones();
        }
        return instance;
    }

    @Override
    public List<RetriccionesM> getLista() {
        try {
            ResultSet res = conexionBD.createStatement().executeQuery("SELECT * FROM restricciones;");
            while (res.next()) {
                listaRestricciones.add(
                    new RetriccionesM(
                        res.getInt("ID"),
                        res.getString("Descripcion")
                    )
                );
            }
        } catch (SQLException e) {
            System.err.println("Error al recuperar los datos de la tabla restricciones: " + e.getMessage());
        }
        return listaRestricciones;
    }

    @Override
    public void mostrar() {
        if (listaRestricciones.size() < 1) {
            getLista();
        }
        listaRestricciones.forEach(i -> System.out.println(i));
    }

    public void mostrarF(Predicate<RetriccionesM> filtro) {
        if (listaRestricciones.size() < 1) {
            getLista();
        }
        listaRestricciones.stream().filter(filtro).forEach(i -> System.out.println(i));
    }
}