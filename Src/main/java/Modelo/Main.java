package Modelo;

public class Main {
    public static void main(String[] args) {
        DataBaseConection.ejecutarConexion();

        CMGPersonal cPersonal = CMGPersonal.getInstance();
        PersonalO a = new PersonalO(39,"Hi", "Tremorton", "*number*", true, 3);
        cPersonal.mostrar();
        cPersonal.actualizar(a);
    }
}