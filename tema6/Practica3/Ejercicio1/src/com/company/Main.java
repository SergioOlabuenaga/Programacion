package com.company;

import Modelo.*;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Excepciones.*;

public class Main {

    // "Base de datos"
    private static ArrayList<Veterinario> listaVeterinarios;
    private static ArrayList<Cliente> listaClientes;
    private static ArrayList<Mascota> listaMascotas;

    public static void main(String[] args) {
	    try
        {
            guardarDatos();
        }
        catch(NullPointerException e)
        {
            JOptionPane.showMessageDialog(null,"El programa termina");
        }
        catch(Exception e)
        {
            System.out.println("Problemas: " + e.getClass());
        }

    }

    public static void guardarDatos() throws Exception
    {
        // Solicitar, validar y guardar los datos de los clientes, de las mascotas y de los veterinarios.
        guardarVeterinarios();
        guardarClientes();
        guardarMascotas();

    }

    public static void guardarVeterinarios() throws Exception
    {
        boolean seguir = true;
        listaVeterinarios = new ArrayList<>();
        while(seguir)
        {
            listaVeterinarios.add(new Veterinario(
                    solicitarDato("Nombre","Teclea el nombre del veterinario","^[A-Z][a-z]+([ ][A-Z][a-z]+)*$" ),
                    solicitarDato("Dirección","Teclea la dirección","^C/ [A-Z][a-z]+([ ][A-Z][a-z]+)* [0-9]{1,3} [0-9][a-zA-Z]$" ),
                    solicitarDato("Teléfono","Teclea el teléfono","^[6789][0-9]{8}$") ,
                    solicitarDato("DNI","Teclea el DNI","^[0-9]{8}[A-Za-z]$") ,
                    solicitarDato("Número de la seguridad social" , "Teclea el número de la seguridad social", "^01 [0-9]{8} [0-9]{2}$")));

            int respuesta = JOptionPane.showConfirmDialog(null,"¿Hay más veterinarios?");
            if (respuesta != 0)
                seguir = false;
        }
    }

    public static String solicitarDato(String dato, String mensaje,String exp) throws Exception
    {
        String variable="";
        boolean error = true;
        while(error)
        {
            try
            {
                variable = JOptionPane.showInputDialog(mensaje );
                if (variable.isEmpty())
                    throw new DatoNoValido(dato + " es un campo obligatorio");
                Pattern pat = Pattern.compile(exp);
                Matcher mat = pat.matcher(variable);
                if (!mat.matches())
                    throw new DatoNoValido(dato + " no tiene un formato adecuado");
                error = false;
            }
            catch(DatoNoValido e)
            {
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
        }
        return variable;
    }

    private static void guardarMascotas() {
        boolean seguir = true;
        listaMascotas = new ArrayList<>();
        while(seguir)
        {
            listaMascotas.add(new Perro(
                    solicitarDatoM("Nombre","Teclea el nombre de la mascota","^[A-Z][a-z]+([ ][A-Z][a-z]+)*$" ),
                    solicitarDatoM("Raza","Teclea la raza de la mascota","^[A-Z][a-z]+([ ][A-Z][a-z]+)*$"),
                    LocalDate.parse(solicitarDatoM("fechaNacimiento","Teclea la fecha de nacimiento de la mascota","^([0-2][0-9]|3[0-1])(\\/|-)(0[1-9]|1[0-2])\\2(\\d{4})$")),
                    Float.parseFloat(solicitarDatoM("","","")),
                    solicitarDatoM("Peso", "Teclea el peso de la mascota",""),
                    Float.parseFloat(solicitarDatoM("Longitud", "Teclea la longitud de la mascota", "")),
                    solicitarDatoM("Color", "Teclea el color de pelo de la mascota", "[A-za-z] {8}")));

            listaMascotas.add(new Gato(
                    solicitarDatoM("Nombre","Teclea el nombre de la mascota","^[A-Z][a-z]+([ ][A-Z][a-z]+)*$" ),
                    solicitarDatoM("Raza","Teclea la raza de la mascota","^[A-Z][a-z]+([ ][A-Z][a-z]+)*$"),
                    LocalDate.parse(solicitarDatoM("fechaNacimiento","Teclea la fecha de nacimiento de la mascota","^([0-2][0-9]|3[0-1])(\\/|-)(0[1-9]|1[0-2])\\2(\\d{4})$")),
                    Float.parseFloat(solicitarDatoM("","","")),
                    solicitarDatoM("Peso", "Teclea el peso de la mascota",""),
                    Float.parseFloat(solicitarDatoM("Longitud", "Teclea la longitud de la mascota", "")),
                    solicitarDatoM("Color", "Teclea el color de pelo de la mascota", "[A-za-z] {8}")));
        }

    }

    private static String solicitarDatoM(String dato, String mensaje, String exp) {
        String variable = "";
        boolean error = true;
        while (error) {
            try {
                variable = JOptionPane.showInputDialog(mensaje);
                if (variable.isEmpty())
                    throw new DatoNoValido(dato + " es un campo obligatorio");
                Pattern pat = Pattern.compile(exp);
                Matcher mat = pat.matcher(variable);
                if (!mat.matches())
                    throw new DatoNoValido(dato + " no tiene un formato adecuado");
                error = false;
            } catch (DatoNoValido e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        return variable;
    }

    private static void guardarClientes() {
        boolean seguir = true;
        listaClientes = new ArrayList<>();
        while(seguir)
        {
            listaClientes.add(new Cliente(
                    solicitarDatoC("Nombre","Teclea el nombre del Cliente","^[A-Z][a-z]+([ ][A-Z][a-z]+)*$" ),
                    solicitarDatoC("Dirección","Teclea la dirección","^C/ [A-Z][a-z]+([ ][A-Z][a-z]+)* [0-9]{1,3} [0-9][a-zA-Z]$" ),
                    solicitarDatoC("Teléfono","Teclea el teléfono","^[6789][0-9]{8}$")));
            int respuesta = JOptionPane.showConfirmDialog(null,"¿Hay más veterinarios?");
            if (respuesta != 0)
                seguir = false;
        }
    }

    private static String solicitarDatoC(String dato, String mensaje, String exp) {
        String variable="";
        boolean error = true;
        while(error)
        {
            try
            {
                variable = JOptionPane.showInputDialog(mensaje );
                if (variable.isEmpty())
                    throw new DatoNoValido(dato + " es un campo obligatorio");
                Pattern pat = Pattern.compile(exp);
                Matcher mat = pat.matcher(variable);
                if (!mat.matches())
                    throw new DatoNoValido(dato + " no tiene un formato adecuado");
                error = false;
            }
            catch(DatoNoValido e)
            {
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
        }
        return variable;
    }

    }
