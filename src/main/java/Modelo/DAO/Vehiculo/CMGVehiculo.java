package Modelo.DAO.Vehiculo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

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
    public List<VehiculoM> getLista() {
        if (listaVehiculos.size() < 1) {
            try {
                ResultSet res = conexionBD.createStatement().executeQuery("CALL getvehiculos;");
                while (res.next()) {
                    listaVehiculos.add(
                        new VehiculoM(
                            res.getString("Placa"),
                            new PersonalM(
                                res.getLong("ID"),
                                res.getString("Nombre"),
                                res.getString("Direccion"),
                                res.getString("Contacto"),
                                res.getBoolean("Estado"),
                                res.getString("Usuario_Sistema"),
                                res.getString("Rol")
                            )
                        ) 
                    );
                }
            } catch (SQLException e) {
                System.err.println("Error al recuperar los datos de la tabla vehiculo: " + e.getMessage());
            }
        }
        return listaVehiculos;
    }

    @Override
    public void mostrar() {
        if (listaVehiculos.size() < 1) {
            getLista();
        }
        listaVehiculos.forEach(i -> System.out.println(i));
    }

    public void mostrarF(Predicate<VehiculoM> filtro) {
        if (listaVehiculos.size() < 1) {
            getLista();
        }
        listaVehiculos.stream().filter(filtro).forEach(i -> System.out.println(i));
    }

    @Override
    public void guardar(VehiculoO vehiculo) {
        try {
            PreparedStatement pst = conexionBD.prepareStatement(
                "INSERT INTO vehiculo(Placa,ID_Personal) VALUES(?,?);"
            );
            pst.setString(1, vehiculo.getPlaca());
            pst.setLong( 2, vehiculo.getIdDueño());
            pst.execute();
            reiniciarP();
        } catch (SQLException e) {
            System.err.println("Error al ingresar el dato en la tabla vehiculo: " + e.getMessage());
        }
    }

    public void actualizar(VehiculoO vehiculo) {
        try {
            PreparedStatement pst = conexionBD.prepareStatement(
                "UPDATE vehiculo SET ID_Personal = ? WHERE Placa = ?;"
            );
            pst.setLong(1, vehiculo.getIdDueño());
            pst.setString( 2, vehiculo.getPlaca());
            pst.execute();
            reiniciarP();
        } catch (SQLException e) {
            System.err.println("Error al actualizar el dato en la tabla vehiculo: " + e.getMessage());
        }
    }
}