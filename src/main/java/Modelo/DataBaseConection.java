package Modelo;

import Vista.Login;
import Vista.LoginBuilder;
import Vista.SuperLogin;
import com.acme.complejoacme.LoginController;
import com.acme.complejoacme.SuperLoginController;
import javafx.scene.layout.AnchorPane;

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

    public static boolean conectar(String host, String user, String password ) {
        String db = "ComplejoACME";

        String cadConex = host + db;
        try {
            Connection conexion = DriverManager.getConnection(cadConex, user, password);
            System.out.println("Conexión exitosa.");
            conexionDB = conexion;
            ConexionM.actualizarConexion();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al conectarse con la base de datos: " + e.getMessage());
            return false;
        }
    }

    public static AnchorPane ejecutarConexion() {
        AnchorPane root;
        LoginController loginController = new LoginController();
        SuperLoginController superLoginController = new SuperLoginController();
        if (ruta != null) {
            System.out.println("Ruta de configuración cargada: " + ruta);
            Login login = Login.create(loginController);
            root = login.withLeftPane().withRightPane().build();
            return root;
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
                    Login login = Login.create(loginController);
                    root = login.withLeftPane().withRightPane().build();
                    return root;
                }
            } catch (IOException e) {
                System.err.println("Error al leer el archivo de configuración: " + e.getMessage());
            }
        }
        SuperLogin login = SuperLogin.create(superLoginController);
        root = login.withLeftPane().withRightPane().build();
        return root;
    }

    public static void actualizarConexion() {
        File configuracion = new File("Src\\configuracion.txt");

        System.out.print("Ingresa la IP de la Base de Datos: ");
        String ip = input.next();

        System.out.print("Ingresa el puerto de la Base de Datos: ");
        String puerto = input.next();

        String host = "jdbc:mysql://" + ip + ":" + puerto + "/";

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