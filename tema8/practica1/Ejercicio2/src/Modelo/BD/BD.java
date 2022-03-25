package Modelo.BD;

import java.sql.Connection;
import java.sql.DriverManager;

public class BD {
    private static Connection con;

    public static void abrirBD() throws Exception
    {
        // setCon también es un buen nombre para este método
        // En el constructor como en el ejercicio anterior
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/"+"acontecimiento";
        con = DriverManager.getConnection(url,"root","usbw");
    }

    public static void cerrarBD() throws Exception
    {
        con.close();
    }

    public static Connection getCon()
    {
        return con;
    }
}
