package Modelo;



import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.time.LocalDate;

public class AcontecimientoDAO {

    private static Acontecimiento acontecimiento;
    private static PreparedStatement sentenciaPre;
    private static String plantilla;
    private static ResultSet resultado;

    public static void alta(Acontecimiento e) throws Exception{
        /* Método que inserta una fila en la tabla de los acontecimientos a partir de un objeto de tipo acontecimiento.
        Este método también se suele llamar save.*/

        plantilla = "INSERT INTO acontecimiento (Nombre, Lugar, Fecha, Hora_Inicio, Hora_Fin, Aforo) VALUES (?,?,?,?,?,?)";
        sentenciaPre = BD.getCon().prepareStatement(plantilla);
        sentenciaPre.setString(1,e.getNombre());
        sentenciaPre.setString(2,e.getLugar());
        sentenciaPre.setDate(3, conversionDate(e.getFecha()));
        sentenciaPre.setTime(4, conversionTime(e.getHoraInicio()));
        sentenciaPre.setTime(5, conversionTime(e.getHoraFin()));
        sentenciaPre.setInt(6,e.getAforo());


        int n = sentenciaPre.executeUpdate();
        System.out.println( n + " filas insertadas");
    }

    private static java.sql.Time conversionTime(java.time.LocalTime hora) {
        return java.sql.Time.valueOf(hora);
    }

    private static java.sql.Date conversionDate(LocalDate fecha) {
        return java.sql.Date.valueOf(fecha);
    }

    public static Acontecimiento consultarEvento(String n) throws Exception{

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

        return acontecimiento;
    }

    public static void crearObjeto() throws Exception{
        acontecimiento = new Acontecimiento();
        acontecimiento.setNombre(resultado.getString("nombre"));
        acontecimiento.setLugar(resultado.getString("lugar"));
        acontecimiento.setFecha(Date.valueOf(resultado.getDate("fecha").toLocalDate()));
        acontecimiento.setHoraInicio(Time.valueOf(resultado.getTime("hora_inicio").toLocalTime()));
        acontecimiento.setHoraFin(Time.valueOf(resultado.getTime("hora_fin").toLocalTime()));
        acontecimiento.setAforo(resultado.getInt("aforo"));
    }

    public static void borrar(Acontecimiento e) throws Exception{

        plantilla = "delete from acontecimiento where nombre = ?";
        sentenciaPre = BD.getCon().prepareStatement(plantilla);
        sentenciaPre.setString(1,e.getNombre());

        int n = sentenciaPre.executeUpdate();
        if(n == 0)
            throw new Exception();

        System.out.println(n + " filas borradas");

    }
}
