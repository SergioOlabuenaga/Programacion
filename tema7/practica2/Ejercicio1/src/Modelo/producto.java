package Modelo;

import java.util.ArrayList;

public class producto {
    private String nombre;
    private int unidades;
    private double precioUnitario;

    private ArrayList<proveedor> listaProveedores;

    public ArrayList<proveedor> getListaProveedores() {
        return listaProveedores;
    }

    public void setListaProveedores(proveedor p) {
        this.listaProveedores.add(p);
    }

    public producto(String nombre, int unidades, double precioUnitario) {
        this.nombre = nombre;
        this.unidades = unidades;
        this.precioUnitario = precioUnitario;
        listaProveedores = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
}
