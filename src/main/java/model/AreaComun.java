package model;

import G4_Reservas.EstadoArea;
import java.sql.Time;

public class AreaComun {
    String nombreDeArea;
    String estado;
    Time horaInicio;
    Time horaFin;

    public AreaComun(String nombreDeArea, String estado, Time horaInicio, Time horaFin) {
        this.nombreDeArea = nombreDeArea;
        this.estado = estado;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public String getNombreDeArea() {
        return nombreDeArea;
    }

    public void setNombreDeArea(String nombreDeArea) {
        this.nombreDeArea = nombreDeArea;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Time getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Time horaFin) {
        this.horaFin = horaFin;
    }    
}
