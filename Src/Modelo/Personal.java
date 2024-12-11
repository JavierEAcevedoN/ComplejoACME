package Modelo;

public class Personal {
    private int id;
    private String nombre, direccion, contacto;
    private boolean estado;
    private int idRol;
    
    public Personal(String nombre, String direccion, String contacto, boolean estado, int idRol) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.contacto = contacto;
        this.estado = estado;
        this.idRol = idRol;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getContacto() {
        return contacto;
    }

    public boolean isEstado() {
        return estado;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }
}