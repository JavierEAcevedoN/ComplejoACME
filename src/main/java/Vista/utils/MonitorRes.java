package Vista.utils;

import java.sql.Timestamp;

public class MonitorRes {
    
    protected int id;
    protected Timestamp fechaEntrada;
    protected Timestamp fechaSalida;

    
    protected long id_Personal;
    protected String nombre;
    protected String direccion;
    protected String contacto;
    protected boolean estado;
    protected String usuarioSistema;
    protected String rol;

    
    public MonitorRes(int id, Timestamp fechaEntrada, Timestamp fechaSalida, long id_Personal, String nombre,
                      String direccion, String contacto, boolean estado, String usuarioSistema, String rol) {
        
        this.id = id;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;

        
        this.id_Personal = id_Personal;
        this.nombre = nombre;
        this.direccion = direccion;
        this.contacto = contacto;
        this.estado = estado;
        this.usuarioSistema = usuarioSistema;
        this.rol = rol;
    }

    
    
    public int getId() {
        return id;
    }

    public Timestamp getFechaEntrada() {
        return fechaEntrada;
    }

    public Timestamp getFechaSalida() {
        return fechaSalida;
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

    public boolean isEstado() {
        return estado;
    }

    public String getUsuarioSistema() {
        return usuarioSistema;
    }

    public String getRol() {
        return rol;
    }

    
    public void setId(int id) {
        this.id = id;
    }

    public void setFechaEntrada(Timestamp fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public void setFechaSalida(Timestamp fechaSalida) {
        this.fechaSalida = fechaSalida;
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
        return "ID: " + id + ", Fecha Entrada: " + fechaEntrada + ", Fecha Salida: " + fechaSalida +
                ", ID Personal: " + id_Personal + ", Nombre: " + nombre + ", Direccion: " + direccion +
                ", Contacto: " + contacto + ", Estado: " + estado + ", Usuario Sistema: " + usuarioSistema +
                ", Rol: " + rol;
    }
}
