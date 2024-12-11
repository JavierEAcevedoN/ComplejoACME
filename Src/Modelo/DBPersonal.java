package Modelo;

public abstract class DBPersonal implements Database<Personal>{
    

    @Override
    public abstract void guardar(Personal personal);
}