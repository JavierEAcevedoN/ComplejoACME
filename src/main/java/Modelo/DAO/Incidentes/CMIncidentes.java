package Modelo.DAO.Incidentes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import Modelo.ConexionM;

public class CMIncidentes extends ConexionM{
    private static CMIncidentes instance;
    private List<IncidentesM> listaIncidentes = new ArrayList<>();

    private CMIncidentes() {
        super();
    }

    public static CMIncidentes getInstance() {
        if (instance == null) {
            instance = new CMIncidentes();
        }
        return instance;
    }

    @Override
    public List<IncidentesM> getLista() {
        if (listaIncidentes.size() < 1) {
            try {
                ResultSet res = conexionBD.createStatement().executeQuery("SELECT * FROM incidentes;");
                while (res.next()) {
                    listaIncidentes.add(
                        new IncidentesM(
                            res.getInt("ID"),
                            res.getString("Descripcion")
                        )
                    );
                }
            } catch (SQLException e) {
                System.err.println("Error al recuperar los datos de la tabla incidentes: " + e.getMessage());
            }
        }
        return listaIncidentes;
    }

    @Override
    public void mostrar() {
        if (listaIncidentes.size() < 1) {
            getLista();
        }
        listaIncidentes.forEach(i -> System.out.println(i));
    }

    public void mostrarF(Predicate<IncidentesM> filtro) {
        if (listaIncidentes.size() < 1) {
            getLista();
        }
        listaIncidentes.stream().filter(filtro).forEach(i -> System.out.println(i));
    }
}