package Modelo.DAO.Vehiculo;

public class VehiculoO extends VehiculoM {
    private int idDueño;

    public VehiculoO(String placa, int idDueño) {
        super(placa);
        this.idDueño = idDueño;
    }

    public void setIdDueño(int idDueño) {
        this.idDueño = idDueño;
    }

    public int getIdDueño() {
        return idDueño;
    }
}