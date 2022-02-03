package Modelo;

import java.util.ArrayList;

public class Curso {
    private String codigo;
    private String descipcion;

    private ArrayList<Alumno> listaAlumno;

    public Curso(String codigo, String descipcion, ArrayList<Alumno> listaAlumno) {
        this.codigo = codigo;
        this.descipcion = descipcion;
        this.listaAlumno = listaAlumno;
    }

    public Curso(String codigo, String descipcion) {
        this.codigo = codigo;
        this.descipcion = descipcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescipcion() {
        return descipcion;
    }

    public void setDescipcion(String descipcion) {
        this.descipcion = descipcion;
    }

    public ArrayList<Alumno> getListaAersona() {
        return listaAlumno;
    }

    public void setListaAersona(ArrayList<Alumno> listaAlumno) {
        this.listaAlumno = listaAlumno;
    }
}
