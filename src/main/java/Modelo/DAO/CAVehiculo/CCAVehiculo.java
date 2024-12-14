package Modelo.DAO.CAVehiculo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Modelo.ConexionMG;
import Modelo.DAO.Personal.PersonalM;
import Modelo.DAO.Vehiculo.VehiculoM;

public class CCAVehiculo extends ConexionMG<CAVehiculoO> {
    private static CCAVehiculo instance;
    private List<CAVehiculoM> listaCaVehiculos = new ArrayList<>();

    private CCAVehiculo() {
        super();
    }

    public static CCAVehiculo getInstance() {
        if (instance == null) {
            instance = new CCAVehiculo();
        }
        return instance;
    }

    private void reiniciarP() {
        listaCaVehiculos.clear();
        mostrar();
    }

    @Override
    public void mostrar() {
        if (listaCaVehiculos.size() < 1) {
            try {
                ResultSet res = conexionBD.createStatement().executeQuery("CALL getcavehiculo;");
                while (res.next()) {
                    listaCaVehiculos.add(
                        new CAVehiculoM(
                            res.getInt("ID_CAV"),
                            res.getTimestamp("Fecha_Entrada"),
                            res.getTimestamp("Fecha_Salida"),
                            new VehiculoM(
                                res.getString("Placa"),
                                new PersonalM(
                                    res.getLong("ID_P"),
                                    res.getString("Nombre"),
                                    res.getString("Direccion"),
                                    res.getString("Contacto"),
                                    res.getBoolean("Estado"),
                                    res.getString("Usuario_Sistema"),
                                    res.getString("Rol")
                                )
                            )
                        )
                    );
                }
            } catch (SQLException e) {
                System.err.println("Error al recuparar los datos de la tabla controlaccesosvehicular: " + e.getMessage());
            }
        }
        listaCaVehiculos.forEach(i -> System.out.println(i));
    }

    @Override
    public void guardar(CAVehiculoO CAVehiculo) {
        try {
            PreparedStatement pst = conexionBD.prepareStatement(
                "INSERT INTO controlaccesosvehicular(Fecha_Entrada,Fecha_Salida,Placa) VALUES(?,?,?);"
            );
            pst.setTimestamp(1, CAVehiculo.getFechaEntrada());
            pst.setTimestamp( 2, CAVehiculo.getFechaSalida());
            pst.setString(3, CAVehiculo.getsPlaca());
            pst.execute();
        } catch (SQLException e) {
            System.err.println("Error al ingresar el dato en la tabla controlaccesosvehicular: " + e.getMessage());
        }
        reiniciarP();
    };

    public void actualizar(CAVehiculoO CAVehiculo) {
        try {
            PreparedStatement pst = conexionBD.prepareStatement(
                "UPDATE controlaccesosvehicular SET Fecha_Entrada = ?, Fecha_Salida = ?, Placa = ? WHERE ID = ?;"
            );
            pst.setTimestamp(1, CAVehiculo.getFechaEntrada());
            pst.setTimestamp( 2, CAVehiculo.getFechaSalida());
            pst.setString(3, CAVehiculo.getsPlaca());
            pst.setInt(4, CAVehiculo.getId());
            pst.execute();
        } catch (SQLException e) {
            System.err.println("Error al actualizar el dato en la tabla controlaccesosvehicular: " + e.getMessage());
        }
        reiniciarP();
    };
}