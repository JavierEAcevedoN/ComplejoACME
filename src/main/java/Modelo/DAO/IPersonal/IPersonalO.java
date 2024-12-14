package Modelo.DAO.IPersonal;

import java.sql.Timestamp;

public class IPersonalO extends IPersonalM {
    private String usuarioResponsable;
    private int idIncidente;
    private long idPersonal;
    
    public IPersonalO(int id, Timestamp fecha, String descripcion, String usuarioResponsable,
            int idIncidente, long idPersonal) {
        super(id, fecha, descripcion);
        this.usuarioResponsable = usuarioResponsable;
        this.idIncidente = idIncidente;
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

    public int getIdIncidente() {
        return idIncidente;
    }

    public void setIdIncidente(int idIncidente) {
        this.idIncidente = idIncidente;
    }
}