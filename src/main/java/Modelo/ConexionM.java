package Modelo;

import java.sql.Connection;
import java.util.List;

public abstract class ConexionM {
    protected static Connection conexionBD;

    protected ConexionM() {
        actualizarConexion();
    }

    public static void actualizarConexion() {
        conexionBD = DataBaseConection.getConexionDB();
    }

    public abstract List getLista();
    public abstract void mostrar();
}
