package Modelo.Base_datos;

import Modelo.UML.Persona;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class PersonasDAO {

    private Connection con;

    public PersonasDAO(Connection con) {
        this.con = con;
    }

    public void registrarPersona(Persona p) throws Exception
    {
        // Preparar y ejecutar la sentencia sql.

        String plantilla = "INSERT INTO personas VALUES (?,?,?,?);";
        PreparedStatement ps = con.prepareStatement(plantilla);
        ps.setString(1, p.getNombre());
        ps.setInt(2,p.getEdad());
        ps.setString(3, p.getProfesion());
        ps.setString(4,p.getTelefono());
        int n = ps.executeUpdate();
        //ps.close();
        if (n != 1)
            throw new Exception("El número de filas actualizadas no es uno");
    }

    public Persona consultarPersona(String nombre) throws Exception
    {
        Persona persona=null;

        PreparedStatement consulta = con.prepareStatement("SELECT * FROM personas where nombre = ? ");
        consulta.setString(1, nombre);
        ResultSet res = consulta.executeQuery();
        // 0 o 1 fila seleccionada
        if(res.next())
        {
            persona= new Persona();
            persona.setNombre(res.getString("nombre"));
            persona.setEdad(res.getInt("edad"));
            persona.setProfesion(res.getString("profesion"));
            persona.setTelefono(res.getString("telefono"));
        }
        else
            throw new Exception ("Persona no encontrada");


        res.close();
        consulta.close();

        return persona;
    }

    public ArrayList<Persona> listaDePersonas() throws Exception
    {
        ArrayList< Persona> listaPersonas = new ArrayList();

        Statement consulta = con.createStatement();
        ResultSet res = consulta.executeQuery("Select * from personas;");
        // n filas seleccionadas
        while(res.next())
        {
            Persona persona= new Persona();
            persona.setNombre(res.getString("nombre"));
            persona.setEdad(res.getInt("edad"));
            persona.setProfesion(res.getString("profesion"));
            persona.setTelefono(res.getString("telefono"));
            listaPersonas.add(persona);
        }
        res.close();
        consulta.close();

        return listaPersonas;
    }
}
