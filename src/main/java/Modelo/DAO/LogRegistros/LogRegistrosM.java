package Modelo.DAO.LogRegistros;

import java.sql.Timestamp;

import Modelo.DAO.Personal.PersonalM;

public class LogRegistrosM {
    private int id;
    private Timestamp fecha;
    private PersonalM usuarioCreador, personalCreado;

    public LogRegistrosM(int id, Timestamp fecha, PersonalM usuarioCreador, PersonalM personalCreado) {
        this.id = id;
        this.fecha = fecha;
        this.usuarioCreador = usuarioCreador;
        this.personalCreado = personalCreado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public PersonalM getUsuarioCreador() {
        return usuarioCreador;
    }

    public void setUsuarioCreador(PersonalM usuarioCreador) {
        this.usuarioCreador = usuarioCreador;
    }

    public PersonalM getPersonalCreado() {
        return personalCreado;
    }

    public void setPersonalCreado(PersonalM personalCreado) {
        this.personalCreado = personalCreado;
    }

    @Override
    public String toString() {
        return "ID Log Registros: " + id + ", Fecha: " + fecha + ", " + usuarioCreador.toString() + ", " + personalCreado.toString();
    }
}