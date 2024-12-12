package Modelo;

import java.sql.Connection;

public abstract class Conexion<T> {
    protected static Connection conexionBD;

    protected Conexion() {
        actualizarConexion();
    }

    public static void actualizarConexion() {
        conexionBD = DataBaseConection.getConexionDB();
    }

    public abstract void guardar(T t);
}