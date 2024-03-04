package model;

import java.sql.Date;
import java.sql.Time;

public class Reserva {
    int idReserva;
    String area;
    int usuarioReserva;
    Date fechaDeReserva;
    Time horaDeReserva;
    int duracion;
    String estadoDeReserva;

    public Reserva(int idReserva, String area, int usuarioReserva, Date fechaDeReserva, Time horaDeReserva, int duracion, String estadoDeReserva) {
        this.idReserva = idReserva;
        this.area = area;
        this.usuarioReserva = usuarioReserva;
        this.fechaDeReserva = fechaDeReserva;
        this.horaDeReserva = horaDeReserva;
        this.duracion = duracion;
        this.estadoDeReserva = estadoDeReserva;
    }
    
    public Reserva(String area, int usuarioReserva, Date fechaDeReserva, Time horaDeReserva, int duracion, String estadoDeReserva) {
        this.area = area;
        this.usuarioReserva = usuarioReserva;
        this.fechaDeReserva = fechaDeReserva;
        this.horaDeReserva = horaDeReserva;
        this.duracion = duracion;
        this.estadoDeReserva = estadoDeReserva;
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

    public int getUsuarioReserva() {
        return usuarioReserva;
    }

    public void setUsuarioReserva(int usuarioReserva) {
        this.usuarioReserva = usuarioReserva;
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
}
