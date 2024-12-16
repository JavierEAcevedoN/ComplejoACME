package com.acme.complejoacme;

import com.acme.complejoacme.Login.AbstractLoginController;
import com.acme.complejoacme.Login.LoginController;
import com.acme.complejoacme.Login.SuperLoginController;
import com.acme.complejoacme.Manager.*;

public class MainController {
    // Logins
    public static AbstractLoginController Login = new LoginController();
    public static AbstractLoginController Superlogin = new SuperLoginController();

    // Manager
    public static ManagerController Manager = new ManagerController();
}