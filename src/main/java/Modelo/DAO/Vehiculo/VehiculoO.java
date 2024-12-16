package Modelo.DAO.Vehiculo;

public class VehiculoO extends VehiculoM {
    private long idDueño;

    public VehiculoO(String placa, long idDueño) {
        super(placa);
        this.idDueño = idDueño;
    }

    public void setIdDueño(long idDueño) {
        this.idDueño = idDueño;
    }

    public long getIdDueño() {
        return idDueño;
    }
}