package com.company;

import javax.swing.*;
import Vista.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public static void Comprobacion(){
        Pattern patron = Pattern.compile("ˆ[0-9]{8}[A-Z]{1}$");
        Matcher m = patron.matcher(tfNIF.getText());
        do {
            JOptionPane.showMessageDialog(null, "ocho numeros y una letra mayuscula");
            tfNIF.setText("");
        }
        while(!m.matches());
    }
}
