package Modelo;

import java.util.ArrayList;

public class cliente {
    private String nombre;
    private ArrayList<producto> listaProductos;

    public cliente(String nombre, ArrayList<producto> listaProductos) {
        this.nombre = nombre;
        this.listaProductos = listaProductos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public void setProducto(producto p) {
        this.listaProductos.add(p);
    }
}
