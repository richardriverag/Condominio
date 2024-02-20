/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package G4_Reservas;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import model.AreaComun;
import model.Reserva;

/**
 *
 * @author ASUS
 */
public class ReservasDB {
    public ArrayList<AreaComun> verAreasComunes(){
        ArrayList<AreaComun> areas = new ArrayList<>();
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/condominio","root","");
            PreparedStatement sql = con.prepareStatement("SELECT NOMBRE_AREA, ESTADO_AREA, HORA_INICIO, HORA_FIN FROM AREACOMUN");
            ResultSet res = sql.executeQuery();
            
            while(res.next()){
                String nombreDeArea = res.getString("NOMBRE_AREA");
                String estado = res.getString("ESTADO_AREA");
                Time horaInicio = res.getTime("HORA_INICIO");
                Time horaFin = res.getTime("HORA_FIN");

                AreaComun areaComun = new AreaComun(nombreDeArea, estado, horaInicio, horaFin);
                areas.add(areaComun);
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        return areas;
    }
    
    public ArrayList<Reserva> verReservas(){
        ArrayList<Reserva> reservas = new ArrayList<>();
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/condominio","root","");
            PreparedStatement sql = con.prepareStatement("SELECT * FROM RESERVA");
            ResultSet res = sql.executeQuery();
            
            while(res.next()){
                int idReserva = res.getInt("ID_RESERVA");
                String areaReservada = res.getString("AREA_RESERVADA");
                Date fechaDeReserva = res.getDate("FECHA_RESERVA");
                Time horaDeReserva = res.getTime("HORA_RESERVA");
                int duracion = res.getInt("DURACION");
                String estadoDeReserva = res.getString("ESTADO_RESERVA");
                boolean cancelado = res.getBoolean("CANCELADO");

                Reserva reserva = new Reserva(idReserva, areaReservada, fechaDeReserva, horaDeReserva, duracion, estadoDeReserva, cancelado);
                reservas.add(reserva);
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        return reservas;
    }
    
    public void reservar(Reserva reserva){
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/condominio","root","");
            String sql = "INSERT INTO RESERVA(AREA_RESERVADA, FECHA_RESERVA, HORA_RESERVA, DURACION, ESTADO_RESERVA, CANCELADO) "
                    + "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,reserva.getArea());
            ps.setDate(2,reserva.getFechaDeReserva());
            ps.setTime(3,reserva.getHoraDeReserva());
            ps.setInt(4,reserva.getDuracion());
            ps.setString(5,reserva.getEstadoDeReserva());
            ps.setBoolean(6,reserva.isCancelado());
            
            int filasAgregadas = ps.executeUpdate();
            if(filasAgregadas > 0) {
                System.out.println("Reserva agregada.");
            } else{
                System.err.println("Reserva NO agregada");
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
