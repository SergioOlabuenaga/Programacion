package Modelo.UML;

import java.time.LocalDate;
import java.time.LocalTime;

public class Evento {
    private String Nombre;
    private String Lugar;
    private LocalDate Fecha;
    private LocalTime HoraI;
    private LocalTime HoraF;
    private int Aforo;

    public Evento() {
    }

    public Evento(String nombre, String lugar, LocalDate fecha, LocalTime horaI, LocalTime horaF, int aforo) {
        Nombre = nombre;
        Lugar = lugar;
        Fecha = fecha;
        HoraI = horaI;
        HoraF = horaF;
        Aforo = aforo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getLugar() {
        return Lugar;
    }

    public void setLugar(String lugar) {
        Lugar = lugar;
    }

    public LocalDate getFecha() {
        return Fecha;
    }

    public void setFecha(LocalDate fecha) {
        Fecha = fecha;
    }

    public LocalTime getHoraI() {
        return HoraI;
    }

    public void setHoraI(LocalTime horaI) {
        HoraI = horaI;
    }

    public LocalTime getHoraF() {
        return HoraF;
    }

    public void setHoraF(LocalTime horaF) {
        HoraF = horaF;
    }

    public int getAforo() {
        return Aforo;
    }

    public void setAforo(int aforo) {
        Aforo = aforo;
    }
}
