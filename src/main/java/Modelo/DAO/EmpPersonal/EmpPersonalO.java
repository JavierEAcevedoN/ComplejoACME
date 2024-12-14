package Modelo.DAO.EmpPersonal;

public class EmpPersonalO extends EmpPersonalM{
    private int idEmpresa;
    private long idPersonal;

    public EmpPersonalO(int id, int idEmpresa, long idPersonal) {
        super(id);
        this.idEmpresa = idEmpresa;
        this.idPersonal = idPersonal;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public long getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(long idPersonal) {
        this.idPersonal = idPersonal;
    }
}
