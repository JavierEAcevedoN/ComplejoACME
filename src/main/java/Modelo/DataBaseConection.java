package Modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DataBaseConection {
    private static String ruta;
    private static Connection conexionDB;

    static Scanner input = new Scanner(System.in);
    
    public static Connection getConexionDB() {
        return conexionDB;
    }

    public static String getRuta() {
        return ruta;
    }

    private static void conectar(String host) {
        String db = "ComplejoACME";

        String cadConex = host + db;

        System.out.print("Ingresa el usuario: ");
        String user = input.next();

        input.nextLine();
        System.out.print("Ingresa la contraseña: ");
        String password = input.nextLine();

        try {
            Connection conexion = DriverManager.getConnection(cadConex, user, password);
            System.out.println("Conexión exitosa.");
            conexionDB = conexion;
            ConexionM.actualizarConexion();
            return;
        } catch (SQLException e) {
            System.err.println("Error al conectarse con la base de datos: " + e.getMessage());
        }
    }

    public static void ejecutarConexion() {
        if (ruta != null) {
            System.out.println("Ruta de configuración cargada: " + ruta);
            // vista de inicio de sesion normal
            // este metodo se ejecuta con el boton de la vista
            conectar(ruta);
            return;
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
                    // vista de inicio de sesion normal
                    // este metodo se ejecuta con el boton de la vista
                    conectar(ruta);
                    return;
                }
            } catch (IOException e) {
                System.err.println("Error al leer el archivo de configuración: " + e.getMessage());
            }
        }
        // vista de inicio de sesion superusuario
        // este metodo se ejecuta con el boton de la vista
        actualizarConexion();
    }

    public static void actualizarConexion() {
        File configuracion = new File("Src\\configuracion.txt");

        System.out.print("Ingresa la IP de la Base de Datos: ");
        String ip = input.next();

        System.out.print("Ingresa el puerto de la Base de Datos: ");
        String puerto = input.next();

        String host = "jdbc:mysql://" + ip + ":" + puerto + "/";
        conectar(host);
        
        if (conexionDB == null) {
            return;
        }

        try (ResultSet resultado = conexionDB.createStatement().executeQuery("SELECT CURRENT_ROLE();")) {
            resultado.next();
            if (resultado.getString(1).contains("SUPERUSUARIO")) {
                ruta = host;

                try (PrintWriter pw = new PrintWriter(new FileWriter(configuracion))) {
                    pw.println(ruta);
                } catch (IOException e) {
                    System.out.println("Error en la escritura");
                }
            } else {
                System.out.println("No es un superusuario valido");
            }
        } catch (SQLException e) {
            System.err.println("Error al conectarse con la base de datos: " + e.getMessage());
        }
    }
}