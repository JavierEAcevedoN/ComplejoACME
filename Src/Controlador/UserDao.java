package Controlador;

import java.util.ArrayList;
import java.util.List;

import Modelo.*;

public class UserDao implements Database<Personal>{
    private List<Personal> users = new ArrayList<>();
    
    public void guardar(Personal personal) {
        users.add(personal);
    }
}