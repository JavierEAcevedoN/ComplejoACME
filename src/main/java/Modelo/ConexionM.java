package Modelo;

import java.sql.Connection;

public abstract class ConexionM {
    protected static Connection conexionBD;

    protected ConexionM() {
        actualizarConexion();
    }

    public static void actualizarConexion() {
        conexionBD = DataBaseConection.getConexionDB();
    }

    public abstract void getLista();
    public abstract void mostrar();
}
