package Modelo.DAO.Restricciones;

public class RetriccionesM {
    private int id;
    private String descripcion;

    public RetriccionesM(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "id Restriccion: " + id + ", Descripcion: " + descripcion;
    }
}