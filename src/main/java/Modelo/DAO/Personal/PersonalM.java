package Modelo.DAO.Personal;

public class PersonalM implements Comparable<PersonalM> {
    protected long id_Personal;
    protected String nombre, direccion, contacto, usuarioSistema;
    protected boolean estado;
    private String rol;

    @Override
    public int compareTo(PersonalM other) {
        return Long.compare(this.id_Personal, other.id_Personal);
    }

    protected PersonalM(long id_Personal, String nombre, String direccion, String contacto, boolean estado, String usuarioSistema) {
        this.id_Personal = id_Personal;
        this.nombre = nombre;
        this.direccion = direccion;
        this.contacto = contacto;
        this.estado = estado;
        this.usuarioSistema = usuarioSistema;
    }

    public PersonalM(long id_Personal, String nombre, String direccion, String contacto, boolean estado, String usuarioSistema , String rol) {
        this.id_Personal = id_Personal;
        this.nombre = nombre;
        this.direccion = direccion;
        this.contacto = contacto;
        this.estado = estado;
        this.usuarioSistema = usuarioSistema;
        this.rol = rol;
    }

    public long getId_Personal() {
        return id_Personal;
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

    public boolean getEstado() {
        return estado;
    }

    public String getUsuarioSistema() {
        return usuarioSistema;
    }

    public String getRol() {
        return rol;
    }

    public void setId_Personal(long id_Personal) {
        this.id_Personal = id_Personal;
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

    public void setUsuarioSistema(String usuarioSistema) {
        this.usuarioSistema = usuarioSistema;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "ID Personal: " + id_Personal + ", Nombre: " + nombre + ", Direccion: " + direccion
                        + ", Contacto: " + contacto + ", Estado: " + estado + ", Usuario Sistema: " + usuarioSistema + ", Rol: " + rol;
    }
}