package com.company;

import Modelo.Base_datos.*;
import Modelo.UML.*;
import Vista.*;

import javax.swing.*;
import java.util.ArrayList;

public class Main {

    private static int opcion;

    private static JFrame vm;
    private static Personas vp;

    private static BD bd;
    private static PersonasDAO pdao;

    private static ArrayList<Persona> listaPersonas;
    private static int pos;

    public static void main(String[] args) {
	// write your code here
        try {
            // Conexión a la base de datos
            bd = new BD();
            pdao = new PersonasDAO(bd.getConnection());

            crearVentanaMenu();

        }
        catch(Exception e)
        {
            System.out.println(e.getClass());
        }
    }

    public static void volverMenu()
    {
        vp.dispose();
        vm.setVisible(true);
    }

    public static void crearVentanaMenu()
    {
        vm = new JFrame("Principal");
        vm.setContentPane(new Principal().getpPrincipal());
        vm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //vm.setLocationRelativeTo(null);
        vm.pack();
        vm.setVisible(true);
    }
    public static void getOpcion(int op) throws Exception{
        opcion = op;

        switch(opcion)
        {
            case 1: case 2:
            crearPersonas();
            break;
            case 3:
                listaPersonas = pdao.listaDePersonas();
                if (listaPersonas.size() > 0) {    // Paso ya los datos de la primera persona.
                    crearPersonas();
                    pos = 0;
                    vp.setDatosPersona(listaPersonas.get(pos).getNombre(), listaPersonas.get(pos).getEdad(), listaPersonas.get(pos).getProfesion(), listaPersonas.get(pos).getTelefono());
                }
                else
                    throw new Exception("No hay personas");
                break;
            case 4:
                bd.desconectar();
                System.exit(0);
        }
    }

    private static void crearPersonas() {
        vp = new Personas(opcion);
        vp.setContentPane(new Personas(opcion).getpPrincipal());
        vp.pack();
        vp.setVisible(true);
    }

    public static void getSiguiente() throws Exception
    {
        if (pos != listaPersonas.size() - 1) {
            pos++;
            vp.setDatosPersona(listaPersonas.get(pos).getNombre(), listaPersonas.get(pos).getEdad(), listaPersonas.get(pos).getProfesion(), listaPersonas.get(pos).getTelefono());
        }
        else
            throw new Exception("No hay siguiente");
    }

    public static void getAnterior() throws Exception
    {
        if (pos != 0) {
            pos--;
            vp.setDatosPersona(listaPersonas.get(pos).getNombre(), listaPersonas.get(pos).getEdad(), listaPersonas.get(pos).getProfesion(), listaPersonas.get(pos).getTelefono());
        }
        else
            throw new Exception("No hay anteror");
    }

    public static void getDatos(String n,String e,String p, String t) throws Exception
    {
        // Tras recibir los datos validados de la ventana. Primero se crea el objeto y luego se manda a la bd
        Persona persona=new Persona(n,Integer.parseInt(e),p,t);
        pdao.registrarPersona(persona);
        volverMenu();

    }

    public static void getNombre(String n) throws Exception
    {
        Persona p = pdao.consultarPersona(n);
        // tras la consulta paso los datos a la ventana para que los muestre.
        vp.setDatosPersona(p.getEdad(),p.getProfesion(),p.getTelefono());
    }
}
