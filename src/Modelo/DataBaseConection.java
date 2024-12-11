package Modelo;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataBaseConection {
    private static String ruta;

    public static Connection conectar(String host) {
        String db = "complejoacme";

        String cadConex = host + db;

        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Ingresa el usuario: ");
            String user = input.next();

            System.out.print("Ingresa la contraseña: ");
            String password = input.next();

            try {
                Connection conexion = DriverManager.getConnection(cadConex, user, password);
                System.out.println("Conexión exitosa.");
                return conexion;
            } catch (SQLException e) {
                System.err.println("Error al conectarse con la base de datos: " + e.getMessage());
                return null;
            }
        }
    }

    public static void ejecutarConexion() {
        if (ruta != null) {
            conectar(ruta);
        }
        File conexion = new File("Src\\conexion.txt");
        if (conexion.isFile() && conexion.exists()) {
            try (BufferedReader buffer = new BufferedReader(new FileReader(conexion))) {
                StringBuilder contenido = new StringBuilder();
                String linea;
                while ((linea = buffer.readLine()) != null) {
                    contenido.append(linea);
                }
                if (contenido.length() == 0) {
                    System.out.println("El archivo de configuración está vacío.");
                } else {
                    ruta = contenido.toString();
                    System.out.println("Ruta de configuración cargada: " + ruta);
                    return;
                }
            } catch (IOException e) {
                System.err.println("Error al leer el archivo de configuración: " + e.getMessage());
            }
        }
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Ingresa la IP de la Base de Datos: ");
            String ip = input.next();

            System.out.print("Ingresa el puerto de la Base de Datos: ");
            String puerto = input.next();

            String host = "jdbc:mysql://" + ip + ":" + puerto + "/";
            Connection connection = conectar(host);
            
            try (ResultSet resultado = connection.createStatement().executeQuery("SELECT CURRENT_ROLE();")) {
                resultado.next();
                if (resultado.getString(1).contains("SUPERUSUARIO")) {
                    ruta = host;
                };
            } catch (SQLException e) {
                System.err.println("Error al conectarse con la base de datos: " + e.getMessage());
            }
        }
    }
}

class a {
    public static void main(String[] args) {
        DataBaseConection.ejecutarConexion();
    }
}