package Modelo.DAO.EmpPersonal;

import Modelo.DAO.Empresas.EmpresasM;
import Modelo.DAO.Personal.PersonalM;

public class EmpPersonalM {
    protected int id;
    private PersonalM persona;
    private EmpresasM empresa;

    protected EmpPersonalM(int id) {
        this.id = id;
    }

    public EmpPersonalM(EmpresasM empresa, int id,  PersonalM persona) {
        this.empresa = empresa;
        this.id = id;
        this.persona = persona;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PersonalM getPersonalM() {
        return persona;
    }

    public void setPersonalM(PersonalM persona) {
        this.persona = persona;
    }

    public EmpresasM getEmpresasM() {
        return empresa;
    }

    public void setEmpresasM(EmpresasM empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return empresa.toString() + ", ID Empresa Personal: " + id + ", " + persona.toString();
    }
}