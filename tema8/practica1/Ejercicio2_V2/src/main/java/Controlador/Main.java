package Controlador;

import Modelo.Acontecimiento;
import Modelo.AcontecimientoDAO;
import Vista.*;

import javax.persistence.*;
import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class Main {

    private static JFrame vp;
    private static Acontecimiento e;

    public static void main(String[] args) {
	// write your code here
        EntityManagerFactory emf = Persistence . createEntityManagerFactory ("default");
        EntityManager em = emf. createEntityManager ();
        EntityTransaction transaction = em. getTransaction ();
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

        e = new Acontecimiento(n,l,f,hi,hf,af);

        AcontecimientoDAO.alta(e);
    }

    public static String cancelarEvento(String nombre) throws Exception{

        e = AcontecimientoDAO.consultarEvento(nombre);
        return e.toString();
    }

    public static void borrarEvento() throws Exception{

        AcontecimientoDAO.borrar(e);

    }

    public static void dispose() {
        vp.dispose();
    }
}
