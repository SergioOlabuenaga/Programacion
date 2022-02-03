package Modelo;

public class Producto {
    private String Nombre;
    private int unidades;
    private double precio;

    public Producto(String nombre, int unidades, double precio) {
        Nombre = nombre;
        this.unidades = unidades;
        this.precio = precio;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
