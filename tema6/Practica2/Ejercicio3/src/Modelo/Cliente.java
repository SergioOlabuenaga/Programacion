package Modelo;

public class Cliente extends Persona{
    private String telefono;

    public Cliente(String nombre, String edad, String telefono) {
        super(nombre, edad);
        this.telefono = telefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Cliente(String nombre, String edad) {
        super(nombre, edad);
    }
}
