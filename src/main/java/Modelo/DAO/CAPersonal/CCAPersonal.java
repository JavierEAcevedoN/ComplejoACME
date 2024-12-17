package Modelo.DAO.CAPersonal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import Modelo.ConexionMG;
import Modelo.DAO.Personal.PersonalM;
import Vista.utils.Alerts.AlertaTab;
import Vista.utils.DateUtils;
import Vista.utils.MonitorRes;
import javafx.scene.control.DatePicker;

public class CCAPersonal extends ConexionMG<CAPersonalO> {
    private static CCAPersonal instance;
    private List<CAPersonalM> listaCaPersonal = new ArrayList<>();

    private CCAPersonal() {
        super();
    }

    public static CCAPersonal getInstance() {
        if (instance == null) {
            instance = new CCAPersonal();
        }
        return instance;
    }

    public void reiniciarP() {
        listaCaPersonal.clear();
    }

    @Override
    public List<CAPersonalM> getLista() {
        if (listaCaPersonal.size() < 1) {
            try {
                ResultSet res = conexionBD.createStatement().executeQuery("CALL getcapersonal;");
                while (res.next()) {
                    listaCaPersonal.add(
                        new CAPersonalM(
                            res.getInt("ID_CAP"),
                            res.getTimestamp("Fecha_Entrada"),
                            res.getTimestamp("Fecha_Salida"),
                            new PersonalM(
                                res.getLong("ID_P"),
                                res.getString("Nombre"),
                                res.getString("Direccion"),
                                res.getString("Contacto"),
                                res.getBoolean("Estado"),
                                res.getString("Usuario_Sistema"),
                                res.getString("Rol")
                            )
                        )
                    );
                }
            } catch (SQLException e) {
                System.err.println("Error al recuperar los datos de la tabla controlaccesospersonal: " + e.getMessage());
            }
        }
        return listaCaPersonal;
    }

    public List<MonitorRes> obtenerMonitorRes() {
        List<MonitorRes> listaMonitorRes = new ArrayList<>();

        
        List<CAPersonalM> lista = getLista();

        
        for (CAPersonalM capersonal : lista) {
            PersonalM personal = capersonal.getPersonal();
            MonitorRes monitorRes = new MonitorRes(
                    capersonal.getId(),
                    capersonal.getFechaEntrada(),
                    capersonal.getFechaSalida(),
                    personal.getId_Personal(),
                    personal.getNombre(),
                    personal.getDireccion(),
                    personal.getContacto(),
                    personal.getEstado(),
                    personal.getUsuarioSistema(),
                    personal.getRol()
            );
            listaMonitorRes.add(monitorRes);
        }

        return listaMonitorRes;
    }

    public List<PersonalM> obtenerPersonalPorRangoFechas(DatePicker fechaInicio, DatePicker fechaFin) {
        List<CAPersonalM> lista = getLista();
        Timestamp inicio = DateUtils.convertDatePickerToTimestamp(fechaInicio);
        Timestamp fin = DateUtils.convertDatePickerToTimestamp(fechaFin);

        return lista.stream()
                .filter(persona ->
                        (persona.getFechaEntrada().after(inicio) || persona.getFechaEntrada().equals(inicio)) &&
                                (persona.getFechaSalida().before(fin) || persona.getFechaSalida().equals(fin))
                )
                .map(CAPersonalM::getPersonal)
                .collect(Collectors.toList());
    }


    @Override
    public void mostrar() {
        if (listaCaPersonal.size() < 1) {
            getLista();
        }
        listaCaPersonal.forEach(i -> System.out.println(i));
    }

    public void mostrarF(Predicate<CAPersonalM> filtro) {
        if (listaCaPersonal.size() < 1) {
            getLista();
        }
        listaCaPersonal.stream().filter(filtro).forEach(i -> System.out.println(i));
    }

    @Override
    public void guardar(CAPersonalO caPersonal) {
        try {
            PreparedStatement pst = conexionBD.prepareStatement(
                "INSERT INTO controlaccesospersonal(Fecha_Entrada,Fecha_Salida,ID_Personal) VALUES(?,?,?);"
            );
            pst.setTimestamp(1, caPersonal.getFechaEntrada());
            pst.setTimestamp( 2, caPersonal.getFechaSalida());
            pst.setLong(3, caPersonal.getIdPersonal());
            pst.execute();
            AlertaTab.Exito();
        } catch (SQLException e) {
            System.err.println("Error al ingresar el dato en la tabla controlaccesospersonal: " + e.getMessage());
            AlertaTab.Error();
        }
        reiniciarP();
    };

    public void actualizar(CAPersonalO caPersonal) {
        try {
            PreparedStatement pst = conexionBD.prepareStatement(
                "UPDATE controlaccesospersonal SET Fecha_Salida = ? WHERE ID_Personal = ?;"
            );
            pst.setTimestamp( 1, caPersonal.getFechaSalida());
            pst.setLong(2, caPersonal.getIdPersonal());
            pst.execute();
            AlertaTab.Exito();
        } catch (SQLException e) {
            System.err.println("Error al actualizar el dato en la tabla controlaccesospersonal: " + e.getMessage());
            AlertaTab.Error();
        }
        reiniciarP();
    };
}