package Modelo;

public class Personal {
    private int ID;
    private String Nombre, Direccion, Contacto;
    private int ID_Rol;

    public Personal(int iD, String nombre, String direccion, String contacto, int iD_Rol) {
        ID = iD;
        Nombre = nombre;
        Direccion = direccion;
        Contacto = contacto;
        ID_Rol = iD_Rol;
    }

    public int getID() {
        return ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getContacto() {
        return Contacto;
    }

    public void setContacto(String contacto) {
        Contacto = contacto;
    }

    public int getID_Rol() {
        return ID_Rol;
    }

    public void setID_Rol(int iD_Rol) {
        ID_Rol = iD_Rol;
    }
}