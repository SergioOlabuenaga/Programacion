package com.company;

import Modelo.cliente;
import Modelo.producto;
import Modelo.proveedor;
import Vista.VentanaPrincipal;

import javax.swing.*;
import java.util.ArrayList;

public class Main {

    private static proveedor[] aProveedores;
    private static producto[] aProductos;
    private static ArrayList<cliente> lClientes;

    private static JFrame v;

    public static void main(String[] args) {
        creardatos();
        mostrarventana();
    }

    private static void creardatos() {
        aProveedores = new proveedor[5];

        aProveedores[0] = new proveedor();
        aProveedores[0].setNombre("Ana");
        aProveedores[1] = new proveedor();
        aProveedores[1].setNombre("Jesus");
        aProveedores[2] = new proveedor();
        aProveedores[2].setNombre("Maria");
        aProveedores[3] = new proveedor();
        aProveedores[3].setNombre("Jon");
        aProveedores[4] = new proveedor();
        aProveedores[4].setNombre("Gorka");

        aProductos = new producto[3];

        aProductos[0] = new producto("produto uno", 5, 10.0);
        aProductos[1] = new producto("produto dos", 5,15.5);
        aProductos[2] = new producto("produto tres", 5, 8.75);

        aProductos[0].setListaProveedores(aProveedores[1]);
        aProductos[0].setListaProveedores(aProveedores[3]);

        aProductos[1].setListaProveedores(aProveedores[4]);

        aProductos[2].setListaProveedores(aProveedores[0]);
        aProductos[2].setListaProveedores(aProveedores[4]);
    }

    private static void mostrarventana() {
        v = new JFrame(" VentanaPrincipal ");
        v.setContentPane(new VentanaPrincipal().getpPrincipal());
        v. setDefaultCloseOperation (JFrame. EXIT_ON_CLOSE );
        v.pack();
        v. setVisible(true);
    }
}
