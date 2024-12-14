package Modelo.DAO.PVisitantes;

import java.sql.Date;

public class PVisitantesO extends PVisitantesM{
    private String usuarioResponsable;
    private long idPersonal;

    public PVisitantesO(Date fechaInicio, Date fechaFin, String usuarioResponsable, long idPersonal) {
        super(fechaInicio, fechaFin);
        this.usuarioResponsable = usuarioResponsable;
        this.idPersonal = idPersonal;
    }

    public String getUsuarioResponsable() {
        return usuarioResponsable;
    }

    public void setUsuarioResponsable(String usuarioResponsable) {
        this.usuarioResponsable = usuarioResponsable;
    }

    public long getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(long idPersonal) {
        this.idPersonal = idPersonal;
    }
}