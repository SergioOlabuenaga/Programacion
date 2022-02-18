package Modelo;

import java.util.ArrayList;

public class Cuenta {
    private String numero;

    private ArrayList<Movimiento>listaMovimientos;

    public Cuenta(String numero, ArrayList<Movimiento> listaMovimientos) {
        this.numero = numero;
        this.listaMovimientos = listaMovimientos;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public ArrayList<Movimiento> getListaMovimientos() {
        return listaMovimientos;
    }

    public void setListaMovimientos(ArrayList<Movimiento> listaMovimientos) {
        this.listaMovimientos = listaMovimientos;
    }
}
