package Modelo.DAO.CAPersonal;

import java.sql.Timestamp;

public class CAPersonalO extends CAPersonalM{
    private long idPersonal;

    public CAPersonalO(int id, Timestamp fechaEntrada, Timestamp fechaSalida, long idPersonal) {
        super(id, fechaEntrada, fechaSalida);
        this.idPersonal = idPersonal;
    }

    public long getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(long idPersonal) {
        this.idPersonal = idPersonal;
    }
}
