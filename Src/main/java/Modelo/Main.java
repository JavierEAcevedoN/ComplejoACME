package Modelo;

public class Main {
    public static void main(String[] args) {
        DataBaseConection.ejecutarConexion();

        CMGPersonal cPersonal = CMGPersonal.getInstance();
        Personal a = new Personal(39,"Hi", "Tremorton", "*number*", true, 3);
        cPersonal.mostrar();
        cPersonal.actualizar(a);
    }
}