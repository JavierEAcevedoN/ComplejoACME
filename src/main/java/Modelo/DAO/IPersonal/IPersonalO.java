package Modelo.DAO.IPersonal;

import java.sql.Timestamp;

public class IPersonalO extends IPersonalM {
    private String Responsable;
    private int idIncidente;
    private long idPersonal;
    
    public IPersonalO(int id, Timestamp fecha, String descripcion, String Responsable,
            int idIncidente, long idPersonal) {
        super(id, fecha, descripcion);
        this.Responsable = Responsable;
        this.idIncidente = idIncidente;
        this.idPersonal = idPersonal;
    }

    public String getusuarioResponsable() {
        return Responsable;
    }

    public void setResponsable(String responsable) {
        this.Responsable = responsable;
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