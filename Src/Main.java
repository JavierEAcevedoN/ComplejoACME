import Modelo.CMGPersonal;
import Modelo.DataBaseConection;
import Modelo.Personal;

public class Main {
    public static void main(String[] args) {
        DataBaseConection.ejecutarConexion();

        CMGPersonal cPersonal = CMGPersonal.getInstance();
        Personal a = new Personal("b", "b", "b", true, 2);
        cPersonal.mostrar();
        cPersonal.guardar(a);

        cPersonal.mostrar();

        cPersonal.guardar(a);
    }
}