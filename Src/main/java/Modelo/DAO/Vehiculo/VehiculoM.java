package Modelo.DAO.Vehiculo;

import Modelo.DAO.Personal.PersonalM;

public class VehiculoM {
    protected String placa;
    private PersonalM dueño;

    protected VehiculoM(String placa) {
        this.placa = placa;
    }

    public VehiculoM(String placa, PersonalM dueño) {
        this.placa = placa;
        this.dueño = dueño;
    }

    public String getPlaca() {
        return placa;
    }

    public PersonalM getDueño() {
        return dueño;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setDueño(PersonalM dueño) {
        this.dueño = dueño;
    }

    @Override
    public String toString() {
        return "Placa: " + placa + ", " + dueño.toString();
    }
}