package Modelo.DAO.PVisitantes;

import java.sql.Date;

import Modelo.DAO.Personal.PersonalM;

public class PVisitantesM {
    private int id;
    protected Date fechaInicio, fechaFin;
    private PersonalM usuarioResponsable, personal;

    protected PVisitantesM(Date fechaInicio, Date fechaFin) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public PVisitantesM(int id, Date fechaInicio, Date fechaFin, PersonalM usuarioResponsable, PersonalM personal) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.usuarioResponsable = usuarioResponsable;
        this.personal = personal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
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
        return "ID Permisos Visitantes: " + id + ", Fecha Inicio: " + fechaInicio + ", Fecha Final: " + fechaFin + ", " + usuarioResponsable.toString() + ", " + personal.toString();
    }
}