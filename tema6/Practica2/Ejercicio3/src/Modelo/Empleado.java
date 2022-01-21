package Modelo;

public class Empleado extends Persona{
    private int sueldobruto;

    public Empleado(String nombre, String edad, int sueldobruto) {
        super(nombre, edad);
        this.sueldobruto = sueldobruto;
    }

    public int getSueldobruto() {
        return sueldobruto;
    }

    public void setSueldobruto(int sueldobruto) {
        this.sueldobruto = sueldobruto;
    }

    public Empleado(String nombre, String edad) {
        super(nombre, edad);
    }
}
