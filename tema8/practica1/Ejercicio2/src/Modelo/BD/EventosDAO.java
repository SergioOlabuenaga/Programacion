package Modelo.BD;


import Modelo.UML.Evento;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

public class EventosDAO {

    private static Evento evento;
    private static PreparedStatement sentenciaPre;
    private static String plantilla;
    private static ResultSet resultado;

    public static void alta(Evento e) throws Exception
    {
        /* Método que inserta una fila en la tabla de los acontecimientos a partir de un objeto de tipo acontecimiento.
        Este método también se suele llamar save.*/


        BD.abrirBD();


        plantilla = "INSERT INTO acontecimiento (Nombre, Lugar, Fecha, Hora_Inicio, Hora_Fin, Aforo) VALUES (?,?,?,?,?,?)";
        sentenciaPre = BD.getCon().prepareStatement(plantilla);
        sentenciaPre.setString(1,e.getNombre());
        sentenciaPre.setString(2,e.getLugar());
        sentenciaPre.setDate(3, conversionDate(e.getFecha()));
        sentenciaPre.setTime(4, conversionTime(e.getHoraI()));
        sentenciaPre.setTime(5, conversionTime(e.getHoraF()));
        sentenciaPre.setInt(6,e.getAforo());


        int n = sentenciaPre.executeUpdate();
        System.out.println( n + " filas insertadas");


        BD.cerrarBD();
    }

    private static java.sql.Time conversionTime(java.time.LocalTime hora) {
        return java.sql.Time.valueOf(hora);
    }

    private static java.sql.Date conversionDate(LocalDate fecha) {
        return java.sql.Date.valueOf(fecha);
    }

    public static Evento consultarEvento(String n) throws Exception{
        BD.abrirBD();

        plantilla = "select * from acontecimiento where nombre = ?";
        sentenciaPre = BD.getCon().prepareStatement(plantilla);
        sentenciaPre.setString(1,n);

        resultado = sentenciaPre.executeQuery();
        if (resultado.next())
        {
            crearObjeto();
        }
        else
            throw new Exception("No hay eventos con ese nombre");

        BD.cerrarBD();

        return evento;
    }

    public static void crearObjeto() throws Exception
    {
        evento = new Evento();
        evento.setNombre(resultado.getString("nombre"));
        evento.setLugar(resultado.getString("lugar"));
        evento.setFecha(resultado.getDate("fecha").toLocalDate());
        evento.setHoraI(resultado.getTime("hora_inicio").toLocalTime());
        evento.setHoraF(resultado.getTime("hora_fin").toLocalTime());
        evento.setAforo(resultado.getInt("aforo"));
    }

    public static void borrar(Evento e) throws Exception{

        BD.abrirBD();

        plantilla = "delete from acontecimiento where nombre = ?";
        sentenciaPre = BD.getCon().prepareStatement(plantilla);
        sentenciaPre.setString(1,e.getNombre());

        int n = sentenciaPre.executeUpdate();
        if(n == 0)
            throw new Exception();

        System.out.println(n + " filas borradas");

        BD.cerrarBD();

    }
}
