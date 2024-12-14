package Modelo.DAO.CAVehiculo;

import Modelo.DAO.Vehiculo.VehiculoM;
import java.sql.Timestamp;

public class CAVehiculoM {
    protected int id;
    protected Timestamp fechaEntrada, fechaSalida;
    private VehiculoM placa;

    protected CAVehiculoM(int id, Timestamp fechaEntrada, Timestamp fechaSalida) {
        this.id = id;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
    }

    public CAVehiculoM(int id, Timestamp fechaEntrada, Timestamp fechaSalida, VehiculoM placa) {
        this.id = id;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.placa = placa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Timestamp fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Timestamp getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Timestamp fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public VehiculoM getPlaca() {
        return placa;
    }

    public void setPlaca(VehiculoM placa) {
        this.placa = placa;
    }

    @Override
    public String toString() {
        return "ID Acceso vehiculo: " + id + ", Fecha Entrada: " + fechaEntrada + ", Fecha Salida: " + fechaSalida + ", " + placa.toString(); 
    }
}