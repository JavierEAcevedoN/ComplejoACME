package Modelo.DAO.Empresas;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import Modelo.ConexionM;

public class CMEmpresas extends ConexionM{
    private static CMEmpresas instance;
    private List<EmpresasM> listaEmpresas = new ArrayList<>();

    private CMEmpresas() {
        super();
    }

    public static CMEmpresas getInstance() {
        if (instance == null) {
            instance = new CMEmpresas();
        }
        return instance;
    }

    @Override
    public List<EmpresasM> getLista() {
        if (listaEmpresas.size() < 1) {
            try {
                ResultSet res = conexionBD.createStatement().executeQuery("SELECT * FROM empresas;");
                while (res.next()) {
                    listaEmpresas.add(
                        new EmpresasM(
                            res.getInt("ID"),
                            res.getString("Nombre"),
                            res.getString("Contacto")
                        )
                    );
                }
            } catch (SQLException e) {
                System.err.println("Error al recuperar los datos de la tabla empresas: " + e.getMessage());
            }
        }
        return listaEmpresas;
    }

    @Override
    public void mostrar() {
        if (listaEmpresas.size() < 1) {
            getLista();
        }
        listaEmpresas.forEach(i -> System.out.println(i));
    }

    public void mostrarF(Predicate<EmpresasM> filtro) {
        if (listaEmpresas.size() < 1) {
            getLista();
        }
        listaEmpresas.stream().filter(filtro).forEach(i -> System.out.println(i));
    }
}