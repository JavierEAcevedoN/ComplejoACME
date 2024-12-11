package Controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import Modelo.*;

public class UserDao extends DBPersonal<Personal>{
    private List<Personal> users = new ArrayList<>();
    
    public void guardar(Personal user) {
        users.add(user);
    }
}