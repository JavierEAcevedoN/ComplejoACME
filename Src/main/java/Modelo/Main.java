package Modelo;

import Modelo.DAO.Vehiculo.CMGVehiculo;
import Modelo.DAO.Vehiculo.VehiculoO;

public class Main {
    public static void main(String[] args) {
        DataBaseConection.ejecutarConexion();

        CMGVehiculo cmgVehiculo = CMGVehiculo.getInstance();
        VehiculoO a = new VehiculoO("SDWEA32123", 16);
        cmgVehiculo.mostrar();
        cmgVehiculo.actualizar(a);
    }
}