package Modelo;

public class Alumno {
    private String DNI;
    private String Nombre;
    private String Apellidos;

    private Curso curso;

    public Alumno(String DNI, String nombre, String apellidos, Curso curso) {
        this.DNI = DNI;
        Nombre = nombre;
        Apellidos = apellidos;
        this.curso = curso;
    }

    public Alumno(String DNI, String nombre, String apellidos) {
        this.DNI = DNI;
        Nombre = nombre;
        Apellidos = apellidos;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
