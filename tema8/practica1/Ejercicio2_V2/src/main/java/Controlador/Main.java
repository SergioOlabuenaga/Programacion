package Controlador;

import Modelo.AcontecimientoEntity;
import Modelo.AcontecimientoDAO;
import Vista.*;

import javax.swing.*;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class Main {

    private static JFrame vp;
<<<<<<< HEAD
    private static AcontecimientoEntity a;
=======
    private static Acontecimiento a;
>>>>>>> main

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

<<<<<<< HEAD
        a = new AcontecimientoEntity(n,l, Date.valueOf(f), Time.valueOf(hi),Time.valueOf(hf),af);
=======
        a = new Acontecimiento(n,l, Date.valueOf(f), Time.valueOf(hi),Time.valueOf(hf),af);
>>>>>>> main

        AcontecimientoDAO.alta(a);
    }


    public static void dispose() {
        vp.dispose();
    }
}
