package Modelo.DAO.CAPersonal;

import Modelo.DAO.Personal.PersonalM;
import java.sql.Timestamp;

public class CAPersonalM {
    protected int id;
    protected Timestamp fechaEntrada, fechaSalida;
    private PersonalM personal;

    protected CAPersonalM(int id, Timestamp fechaEntrada, Timestamp fechaSalida) {
        this.id = id;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
    }

    public CAPersonalM(int id, Timestamp fechaEntrada, Timestamp fechaSalida, PersonalM personal) {
        this.id = id;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.personal = personal;
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

    public PersonalM getPersonal() {
        return personal;
    }

    public void setPersonal(PersonalM personal) {
        this.personal = personal;
    }

    @Override
    public String toString() {
        return "ID Acceso personal: " + id + ", Fecha Entrada: " + fechaEntrada + ", Fecha Salida: " + fechaSalida
                + ", " + personal.toString();
    }
}