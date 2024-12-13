package Modelo.DAO.Personal;

public class PersonalO extends PersonalM{
    private int idRol;

    public PersonalO(int id, String nombre, String direccion, String contacto, boolean estado, int idRol) {
        super(id, nombre, direccion, contacto, estado);
        this.idRol = idRol;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }
}