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
    private static AcontecimientoEntity a;

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

        a = new AcontecimientoEntity(n,l, Date.valueOf(f), Time.valueOf(hi),Time.valueOf(hf),af);

        AcontecimientoDAO.alta(a);
    }

    public static String cancelarEvento(String nombre) throws Exception{

        a = AcontecimientoDAO.consultarEvento(nombre);
        if (a != null)
        return a.toString();

        throw new Exception("No hay ningun evento con ese nombre");
    }

    public static void borrarEvento() throws Exception{

        AcontecimientoDAO.borrar();

    }


    public static void dispose() {
        vp.dispose();
    }
}
