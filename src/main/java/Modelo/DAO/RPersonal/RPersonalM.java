package Modelo.DAO.RPersonal;

import java.sql.Date;

import Modelo.DAO.Personal.PersonalM;

public class RPersonalM {
    protected int id;
    protected Date fecha;
    private PersonalM usuarioResponsable, personal;
    private String restriccionS;

    protected RPersonalM(int id, Date fecha) {
        this.id = id;
        this.fecha = fecha;
    }

    public RPersonalM(int id, Date fecha, PersonalM usuarioResponsable, String restriccionS, PersonalM personal) {
        this.id = id;
        this.fecha = fecha;
        this.usuarioResponsable = usuarioResponsable;
        this.restriccionS = restriccionS;
        this.personal = personal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public PersonalM getResponsable() {
        return usuarioResponsable;
    }

    public void setResponsable(PersonalM usuarioResponsable) {
        this.usuarioResponsable = usuarioResponsable;
    }

    public PersonalM getPersonal() {
        return personal;
    }

    public void setPersonal(PersonalM personal) {
        this.personal = personal;
    }

    public String getRestriccionS() {
        return restriccionS;
    }

    public void setRestriccionS(String restriccionS) {
        this.restriccionS = restriccionS;
    }

    @Override
    public String toString() {
        return "ID Restriccion Personal: " + id + ", Fecha" + fecha + ", " + usuarioResponsable.toString() + ", Restriccion: " + restriccionS + ", " + personal.toString();
    }
}