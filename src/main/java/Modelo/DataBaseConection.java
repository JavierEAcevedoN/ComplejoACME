package Modelo;

import Vista.Login;
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

public class DataBaseConection {
    private static String ruta;
    private static Connection conexionDB;
    
    public static Connection getConexionDB() {
        return conexionDB;
    }

    public static String getRuta() {
        return ruta;
    }

    public static boolean conectar(String host, String user, String password) {
        String db = "complejoacme";

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

        File configuracion = new File("src\\configuracion.txt");
        if (configuracion.isFile() && configuracion.exists()) {
            try (BufferedReader buffer = new BufferedReader(new FileReader(configuracion))) {
                StringBuilder contenido = new StringBuilder();
                String linea;
                while ((linea = buffer.readLine()) != null) {
                    contenido.append(linea);
                }
                if (contenido.isEmpty()) {
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
        } else {
            System.out.println("El archivo de configuración no existe.");
        }
        SuperLogin login = SuperLogin.create(superLoginController);
        root = login.withLeftPane().withRightPane().build();
        return root;
    }

    public static boolean actualizarConexion(String host, String user, String password) {
        File configuracion = new File("src\\configuracion.txt");

        if (!conectar(host, user, password)) {
            return false;
        }

        try (ResultSet resultado = conexionDB.createStatement().executeQuery("SELECT CURRENT_ROLE();")) {
            resultado.next();
            if (resultado.getString(1).contains("SUPERUSUARIO")) {
                ruta = host;

                try (PrintWriter pw = new PrintWriter(new FileWriter(configuracion))) {
                    pw.println(ruta);
                    return true;
                } catch (IOException e) {
                    System.out.println("Error en la escritura");
                    return false;
                }
            } else {
                System.out.println("No es un superusuario valido");
                return false;
            }
        } catch (SQLException e) {
            System.err.println("Error al conectarse con la base de datos: " + e.getMessage());
            return false;
        }
    }
}