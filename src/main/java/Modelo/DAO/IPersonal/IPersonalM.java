package Modelo.DAO.IPersonal;

import java.sql.Timestamp;

import Modelo.DAO.Personal.PersonalM;

public class IPersonalM {
    protected int id;
    protected Timestamp fecha;
    protected String descripcion;
    private PersonalM usuarioResponsable, personal;
    private String incidente;

    protected IPersonalM(int id, Timestamp fecha, String descripcion) {
        this.id = id;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    public IPersonalM(int id, Timestamp fecha, String descripcion, PersonalM usuarioResponsable,
            String incidente, PersonalM personal) {
        this.id = id;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.usuarioResponsable = usuarioResponsable;
        this.incidente = incidente;
        this.personal = personal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public PersonalM getUsuarioResponsable() {
        return usuarioResponsable;
    }

    public void setUsuarioResponsable(PersonalM usuarioResponsable) {
        this.usuarioResponsable = usuarioResponsable;
    }

    public String getIncidente() {
        return incidente;
    }

    public void setIncidente(String incidente) {
        this.incidente = incidente;
    }

    public PersonalM getPersonal() {
        return personal;
    }

    public void setPersonal(PersonalM personal) {
        this.personal = personal;
    }

    @Override
    public String toString() {
        return "ID Log Incidente Personal: "+ id + ", Fecha: " + fecha + ", Descripcion: " + descripcion + ", " + usuarioResponsable.toString() + ", Incidente: " + incidente + ", " + personal.toString();
    }
}