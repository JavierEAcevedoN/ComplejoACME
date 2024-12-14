package Modelo.DAO.LCEstado;

import java.sql.Timestamp;

public class LCEstadoO extends LCEstadoM {
    private String usuarioResponsable;
    private long idPersonal;

    public LCEstadoO(int id, Timestamp fecha, boolean nuevoEstado, String descripcion, String usuarioResponsable,
            long idPersonal) {
        super(id, fecha, nuevoEstado, descripcion);
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
