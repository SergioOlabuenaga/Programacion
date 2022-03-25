package com.company;

import Modelo.BD.BD;
import Modelo.BD.EventosDAO;
import Modelo.UML.Evento;
import Vista.*;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class Main {

    private static JFrame vp;
    private static Evento e;

    private static BD bd;
    private static EventosDAO eDAO;

    public static void main(String[] args) {
	// write your code here
        mostrarVentanaPrincipal();
    }

    public static void mostrarVentanaPrincipal(){
        vp = new JFrame("Principal");
        vp.setContentPane(new Principal().getpPrincipal());
        vp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vp.setExtendedState(JFrame.MAXIMIZED_BOTH);
        vp.pack();
        vp.setVisible(true);
    }

    public static void mostrarVentanaInsertar() {
        vInsertar dialog = new vInsertar();
        dialog.setLocationRelativeTo(null);
        dialog.pack();
        dialog.setVisible(true);
    }


    public static void getDatosEvento(String n, String l, LocalDate f, LocalTime hi, LocalTime hf, int af) throws Exception {

        e = new Evento(n,l,f,hi,hf,af);

        EventosDAO.alta(e);
    }
}
