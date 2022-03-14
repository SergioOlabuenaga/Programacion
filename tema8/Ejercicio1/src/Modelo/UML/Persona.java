package Modelo.UML;

public class Persona {
    private String Nombre;
    private int Edad;
    private String Profesion;
    private String telefono;

    public Persona(String nombre, int edad, String profesion, String telefono) {
        Nombre = nombre;
        Edad = edad;
        Profesion = profesion;
        this.telefono = telefono;
    }

    public Persona() {
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }

    public String getProfesion() {
        return Profesion;
    }

    public void setProfesion(String profesion) {
        Profesion = profesion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
