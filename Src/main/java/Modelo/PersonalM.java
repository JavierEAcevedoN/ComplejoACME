package Modelo;

public class PersonalM {
    protected int id;
    protected String nombre, direccion, contacto;
    protected boolean estado;
    private String rol;

    protected PersonalM(int id, String nombre, String direccion, String contacto, boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.contacto = contacto;
        this.estado = estado;
    }

    public PersonalM(int id, String nombre, String direccion, String contacto, boolean estado, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.contacto = contacto;
        this.estado = estado;
        this.rol = rol;
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

    public String getRol() {
        return rol;
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
}