package Modelo;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Entity
public class Acontecimiento {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Nombre")
    private String nombre;
    @Basic
    @Column(name = "Lugar")
    private String lugar;
    @Basic
    @Column(name = "Fecha")
    private Date fecha;
    @Basic
    @Column(name = "Hora_Inicio")
    private Time horaInicio;
    @Basic
    @Column(name = "Hora_Fin")
    private Time horaFin;
    @Basic
    @Column(name = "Aforo")
    private int aforo;

    public Acontecimiento() {
    }

    public Acontecimiento(String nombre, String lugar, LocalDate fecha, LocalTime horaI, LocalTime horaF, int aforo) {
        this.nombre = nombre;
        this.lugar = lugar;
        this.fecha = Date.valueOf(fecha);
        this.horaInicio = Time.valueOf(horaI);
        this.horaFin = Time.valueOf(horaF);
        this.aforo = aforo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Time horaFin) {
        this.horaFin = horaFin;
    }

    public int getAforo() {
        return aforo;
    }

    public void setAforo(int aforo) {
        this.aforo = aforo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Acontecimiento that = (Acontecimiento) o;
        return aforo == that.aforo && Objects.equals(nombre, that.nombre) && Objects.equals(lugar, that.lugar) && Objects.equals(fecha, that.fecha) && Objects.equals(horaInicio, that.horaInicio) && Objects.equals(horaFin, that.horaFin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, lugar, fecha, horaInicio, horaFin, aforo);
    }
}
