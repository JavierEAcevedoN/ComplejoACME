package Modelo.DAO.RPersonal;

import java.sql.Date;

public class RPersonalO extends RPersonalM {
    private String usuarioResponsable;
    private int restriccion;
    private long idPersonal;

    public RPersonalO(int id, Date fecha, String usuarioResponsable, int restriccion, long idPersonal) {
        super(id, fecha);
        this.usuarioResponsable = usuarioResponsable;
        this.restriccion = restriccion;
        this.idPersonal = idPersonal;
    }

    public String getUsuarioResponsable() {
        return usuarioResponsable;
    }

    public void setUsuarioResponsable(String usuarioResponsable) {
        this.usuarioResponsable = usuarioResponsable;
    }

    public int getRestriccion() {
        return restriccion;
    }

    public void setRestriccion(int restriccion) {
        this.restriccion = restriccion;
    }

    public long getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(long idPersonal) {
        this.idPersonal = idPersonal;
    }
}
