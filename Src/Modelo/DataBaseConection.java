package Modelo;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class DataBaseConection {
    private static String ruta;
    static Scanner input = new Scanner(System.in);
    
    public static Connection conectar(String host) {
        String db = "complejoacme";

        String cadConex = host + db;

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

    public static void ejecutarConexion() {
        if (ruta != null) {
            System.out.println("Ruta de configuración cargada: " + ruta);
            conectar(ruta);
        }

        File configuracion = new File("Src\\configuracion.txt");
        if (configuracion.isFile() && configuracion.exists()) {
            try (BufferedReader buffer = new BufferedReader(new FileReader(configuracion))) {
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
        
        actualizarConexion();
    }

    public static void actualizarConexion() {
        File configuracion = new File("Src\\configuracion.txt");

        System.out.print("Ingresa la IP de la Base de Datos: ");
        String ip = input.next();

        System.out.print("Ingresa el puerto de la Base de Datos: ");
        String puerto = input.next();

        String host = "jdbc:mysql://" + ip + ":" + puerto + "/";
        Connection connection = conectar(host);
        
        if (connection == null) {
            return;
        }

        try (ResultSet resultado = connection.createStatement().executeQuery("SELECT CURRENT_ROLE();")) {
            resultado.next();
            if (resultado.getString(1).contains("SUPERUSUARIO")) {
                ruta = host;
                System.out.println("Ruta de configuración cargada: " + ruta);

                try (PrintWriter pw = new PrintWriter(new FileWriter(configuracion))) {
                    pw.println(ruta);
                } catch (IOException e) {
                    System.out.println("Error en la escritura");
                }
            };
        } catch (SQLException e) {
            System.err.println("Error al conectarse con la base de datos: " + e.getMessage());
        }
    }
}

class a {
    public static void main(String[] args) {
        DataBaseConection.ejecutarConexion();
        DataBaseConection.ejecutarConexion();
        DataBaseConection.actualizarConexion();
    }
}