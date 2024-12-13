package Modelo.DAO.Vehiculo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Modelo.ConexionMG;
import Modelo.DAO.Personal.PersonalM;

public class CMGVehiculo extends ConexionMG<VehiculoO>{
    private static CMGVehiculo instance;
    private List<VehiculoM> listaVehiculos = new ArrayList<>();

    private CMGVehiculo() {
        super();
    }

    public static CMGVehiculo getInstance() {
        if (instance == null) {
            instance = new CMGVehiculo();
        }
        return instance;
    }
    
    private void reiniciarP() {
        listaVehiculos.clear();
        mostrar();
    }

    @Override
    public void mostrar() {
        if (listaVehiculos.size() < 1) {
            try {
                ResultSet res = conexionBD.createStatement().executeQuery("CALL getvehiculos;");
                while (res.next()) {
                    listaVehiculos.add(
                        new VehiculoM(
                            res.getString("Placa"),
                            new PersonalM(
                                res.getInt("ID"),
                                res.getString("Nombre"),
                                res.getString("Direccion"),
                                res.getString("Contacto"),
                                res.getBoolean("Estado"),
                                res.getString("Rol")
                            )
                        ) 
                    );
                }
            } catch (SQLException e) {
                System.err.println("Error al recuperar los datos de la tabla vehiculo: " + e.getMessage());
            }
        }
        listaVehiculos.forEach(i -> System.out.println(i));
    }

    @Override
    public void guardar(VehiculoO vehiculo) {
        try {
            PreparedStatement pst = conexionBD.prepareStatement(
                "INSERT INTO vehiculo(Placa,ID_Personal) VALUES(?,?);"
            );
            pst.setString(1, vehiculo.getPlaca());
            pst.setInt( 2, vehiculo.getIdDueño());
            pst.execute();
        } catch (SQLException e) {
            System.err.println("Error al ingresar el dato en la tabla vehiculo: " + e.getMessage());
        }
        reiniciarP();
    }

    public void actualizar(VehiculoO vehiculo) {
        try {
            PreparedStatement pst = conexionBD.prepareStatement(
                "UPDATE vehiculo SET ID_Personal = ? WHERE Placa = ?;"
            );
            pst.setInt(1, vehiculo.getIdDueño());
            pst.setString( 2, vehiculo.getPlaca());
            pst.execute();
        } catch (SQLException e) {
            System.err.println("Error al actualizar el dato en la tabla vehiculo: " + e.getMessage());
        }
        reiniciarP();
    }
}