package Modelo.Base_datos;

import java.sql.*;

public class BD {
    private String url = "jdbc:mysql://localhost:3306/t8e1";
    private String user = "root";
    private String passwd = "usbw";

    private Connection connection;

    public BD() throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        connection = DriverManager.getConnection(url, user, passwd);

        if (connection == null) {
            throw new Exception("Problemas con la conexión");
        }
    }

    public Connection getConnection(){
        return connection;
    }

    public void desconectar() throws Exception{
        connection.close();
    }
}
