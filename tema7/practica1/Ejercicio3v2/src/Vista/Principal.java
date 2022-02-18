package Vista;

import javax.swing.*;

public class Principal {
    private JPanel panel1;
    private JButton bComprar;
    private JButton bVenta;
    private JButton bSalir;

    public static void main(String [] args) {
         JFrame frame = new JFrame(" VentanaPrincipal ");
         frame. setContentPane (new Principal);
         frame. setDefaultCloseOperation (JFrame. EXIT_ON_CLOSE );
         frame.pack ();
         frame. setVisible (true);
    }
}

