package Modelo.DAO.Empresas;

public class EmpresasM {
    private int id;
    private String nombre, contacto;
    
    public EmpresasM(int id, String nombre, String contacto) {
        this.id = id;
        this.nombre = nombre;
        this.contacto = contacto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    @Override
    public String toString() {
        return "ID Empresas: " + id + ", Nombre: " + nombre + ", Contacto: " + contacto;
    }
}
