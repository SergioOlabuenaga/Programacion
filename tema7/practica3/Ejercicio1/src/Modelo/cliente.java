package Modelo;

import java.util.ArrayList;

public class cliente {
    private String DNI;
    private String nombre;
    private String apellido;
    private String clave;

    private ArrayList<Cuenta>listaCuentas;

    public cliente(String DNI, String nombre, String apellido, String clave) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellido = apellido;
        this.clave = clave;
    }

    public cliente(String DNI, String nombre, String apellido, String clave, ArrayList<Cuenta> listaCuentas) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellido = apellido;
        this.clave = clave;
        this.listaCuentas = listaCuentas;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public ArrayList<Cuenta> getListaCuentas() {
        return listaCuentas;
    }

    public void setListaCuentas(ArrayList<Cuenta> listaCuentas) {
        this.listaCuentas = listaCuentas;
    }
}
