package Modelo.DAO.LCEstado;

import java.sql.Timestamp;

import Modelo.DAO.Personal.PersonalM;

public class LCEstadoM {
    protected int id;
    protected Timestamp fecha;
    protected boolean nuevoEstado;
    protected String descripcion;
    private PersonalM usuarioResponsable, personal;

    protected LCEstadoM(int id, Timestamp fecha, boolean nuevoEstado, String descripcion) {
        this.id = id;
        this.fecha = fecha;
        this.nuevoEstado = nuevoEstado;
        this.descripcion = descripcion;
    }

    public LCEstadoM(int id, Timestamp fecha, boolean nuevoEstado, String descripcion, PersonalM usuarioResponsable,
            PersonalM personal) {
        this.id = id;
        this.fecha = fecha;
        this.nuevoEstado = nuevoEstado;
        this.descripcion = descripcion;
        this.usuarioResponsable = usuarioResponsable;
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

    public boolean isNuevoEstado() {
        return nuevoEstado;
    }

    public void setNuevoEstado(boolean nuevoEstado) {
        this.nuevoEstado = nuevoEstado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    @Override
    public String toString() {
        return "ID Log Cambio Estado: " + id + ", Fecha: " + fecha + ", Nuevo Estado: " + nuevoEstado
                + ", Descripcion: " + descripcion + ", " + usuarioResponsable.toString() + ", " + personal.toString();
    }
}