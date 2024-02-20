package model;

import java.sql.Date;
import java.sql.Time;

public class Reserva {
    int idReserva;
    String area;
    Date fechaDeReserva;
    Time horaDeReserva;
    int duracion;
    String estadoDeReserva;
    boolean cancelado; 

    public Reserva(int idReserva, String area, Date fechaDeReserva, Time horaDeReserva, int duracion, String estadoDeReserva, boolean cancelado) {
        this.idReserva = idReserva;
        this.area = area;
        this.fechaDeReserva = fechaDeReserva;
        this.horaDeReserva = horaDeReserva;
        this.duracion = duracion;
        this.estadoDeReserva = estadoDeReserva;
        this.cancelado = cancelado;
    }
    
    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Date getFechaDeReserva() {
        return fechaDeReserva;
    }

    public void setFechaDeReserva(Date fechaDeReserva) {
        this.fechaDeReserva = fechaDeReserva;
    }

    public Time getHoraDeReserva() {
        return horaDeReserva;
    }

    public void setHoraDeReserva(Time horaDeReserva) {
        this.horaDeReserva = horaDeReserva;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getEstadoDeReserva() {
        return estadoDeReserva;
    }

    public void setEstadoDeReserva(String estadoDeReserva) {
        this.estadoDeReserva = estadoDeReserva;
    }

    public boolean isCancelado() {
        return cancelado;
    }

    public void setCancelado(boolean cancelado) {
        this.cancelado = cancelado;
    }
}
