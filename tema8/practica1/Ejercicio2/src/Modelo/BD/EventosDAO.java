package Modelo.BD;


import Modelo.UML.Evento;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;

public class EventosDAO {

    private static Evento evento;
    private static PreparedStatement sentenciaPre;
    private static String plantilla;
    private static ResultSet resultado;

    public static void alta(Evento e) throws Exception
    {
        /* Método que inserta una fila en la tabla de los acontecimientos a partir de un objeto de tipo acontecimiento.
        Este método también se suele llamar save.*/

        // Abrir la conexión
        BD.abrirBD();

        // Preparar la sentencia que se quiere ejecutar
        plantilla = "INSERT INTO acontecimientos (nombre, lugar, fecha,hora_i, hora_f, aforo) VALUES (?,?,?,?,?,?)";
        sentenciaPre = BD.getCon().prepareStatement(plantilla);
        sentenciaPre.setString(1,e.getNombre());
        sentenciaPre.setString(2,e.getLugar());
        sentenciaPre.setDate(3, conversionDate(e.getFecha()));
        sentenciaPre.setTime(4, conversionTime(e.getHoraI()));
        sentenciaPre.setTime(5, conversionTime(e.getHoraF()));
        sentenciaPre.setInt(6,e.getAforo());

        // Ejecutar sentencia
        int n = sentenciaPre.executeUpdate();
        System.out.println( n + "filas insertadas");

        // Cerrar la conexión
        BD.cerrarBD();
    }

    private static java.sql.Time conversionTime(java.time.LocalTime hora) {
        return java.sql.Time.valueOf(hora);
    }

    private static java.sql.Date conversionDate(LocalDate fecha) {
        return java.sql.Date.valueOf(fecha);
    }
}
