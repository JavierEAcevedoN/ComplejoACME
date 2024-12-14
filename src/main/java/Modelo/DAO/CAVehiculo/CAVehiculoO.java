package Modelo.DAO.CAVehiculo;

import java.sql.Timestamp;

public class CAVehiculoO extends CAVehiculoM{
    private String sPlaca;

    public CAVehiculoO(int id, Timestamp fechaEntrada, Timestamp fechaSalida, String sPlaca) {
        super(id, fechaEntrada, fechaSalida);
        this.sPlaca = sPlaca;
    }

    public void setsPlaca(String sPlaca) {
        this.sPlaca = sPlaca;
    }

    public String getsPlaca() {
        return sPlaca;
    }
}
