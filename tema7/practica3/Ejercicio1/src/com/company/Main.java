package com.company;

import javax.swing.*;
import Vista.*;

public class Main {

    private static JFrame v;
    private static JFrame c;
    private static JFrame a;

    public static void main(String[] args) {
	// write your code here
        mostrarventana();
    }

    private static void mostrarventana() {
        v = new JFrame(" Principal ");
        v.setContentPane(new Principal().getpPrincipal());
        v. setDefaultCloseOperation (JFrame. EXIT_ON_CLOSE );
        v.pack();
        v. setVisible(true);
    }

    public static void cambio() {
        v.setVisible(false);
        c = new JFrame(" Principal ");
        c.setContentPane(new InicioSesion().getpPrincipal());
        c. setDefaultCloseOperation (JFrame. EXIT_ON_CLOSE );
        c.pack();
        c.setVisible(true);
    }

    public static void login() {
        c.setVisible(false);

        a.setVisible(true);
    }
}
