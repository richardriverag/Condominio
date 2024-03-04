/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package G4_Reservas;

import condominio.Conexion;
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
public class ControladorReserva {

    public ArrayList<AreaComun> verAreasComunes() {
        ArrayList<AreaComun> areas = new ArrayList<>();
        try {
            Connection con = Conexion.getCon();
            PreparedStatement sql = con.prepareStatement("SELECT NOMBRE_AREA, ESTADO_AREA, HORA_INICIO, HORA_FIN FROM AREACOMUN");
            ResultSet res = sql.executeQuery();

            while (res.next()) {
                String nombreDeArea = res.getString("NOMBRE_AREA");
                String estado = res.getString("ESTADO_AREA");
                Time horaInicio = res.getTime("HORA_INICIO");
                Time horaFin = res.getTime("HORA_FIN");

                AreaComun areaComun = new AreaComun(nombreDeArea, estado, horaInicio, horaFin);
                areas.add(areaComun);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return areas;
    }

    public ArrayList<Reserva> verReservasPendientes() {
        ArrayList<Reserva> reservas = new ArrayList<>();
        String query = "SELECT ID_RESERVA, AREA_RESERVADA, USUARIO_RESERVA, FECHA_RESERVA, HORA_RESERVA, DURACION, ESTADO_RESERVA\n"
                + "FROM RESERVA\n"
                + "WHERE ESTADO_RESERVA = 'Pendiente';";
        try {
            Connection con = Conexion.getCon();
            PreparedStatement sql = con.prepareStatement(query);
            ResultSet res = sql.executeQuery();

            while (res.next()) {
                int idReserva = res.getInt("ID_RESERVA");
                String areaReservada = res.getString("AREA_RESERVADA");
                int usuarioReserva = res.getInt("USUARIO_RESERVA");
                Date fechaDeReserva = res.getDate("FECHA_RESERVA");
                Time horaDeReserva = res.getTime("HORA_RESERVA");
                int duracion = res.getInt("DURACION");
                String estadoDeReserva = res.getString("ESTADO_RESERVA");                

                Reserva reserva = new Reserva(idReserva, areaReservada, usuarioReserva, fechaDeReserva, horaDeReserva, duracion, estadoDeReserva);
                reservas.add(reserva);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return reservas;
    }

    public void reservar(Reserva reserva) {
        try {
            Connection con = Conexion.getCon();
            String sql = "INSERT INTO RESERVA(AREA_RESERVADA, USUARIO_RESERVA, FECHA_RESERVA, HORA_RESERVA, DURACION, ESTADO_RESERVA) "
                    + "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, reserva.getArea());
            ps.setString(2, reserva.getArea());
            ps.setDate(3, reserva.getFechaDeReserva());
            ps.setTime(4, reserva.getHoraDeReserva());
            ps.setInt(5, reserva.getDuracion());
            ps.setString(6, reserva.getEstadoDeReserva());

            int filasAgregadas = ps.executeUpdate();
            if (filasAgregadas > 0) {
                System.out.println("Reserva agregada.");
            } else {
                System.err.println("Reserva NO agregada");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public ArrayList<Reserva> verHistoricoDeReservas() {
        ArrayList<Reserva> reservas = new ArrayList<>();
        String query = "SELECT AREA_RESERVADA, USUARIO_RESERVA, FECHA_RESERVA, HORA_RESERVA, DURACION, ESTADO_RESERVA, CANCELADO\n"
                + "FROM RESERVA;";
        try {
            Connection con = Conexion.getCon();
            PreparedStatement sql = con.prepareStatement("SELECT * FROM RESERVA");
            ResultSet res = sql.executeQuery();

            while (res.next()) {
                int idReserva = res.getInt("ID_RESERVA");
                String areaReservada = res.getString("AREA_RESERVADA");
                int usuarioReserva = res.getInt("USUARIO_RESERVA");
                Date fechaDeReserva = res.getDate("FECHA_RESERVA");
                Time horaDeReserva = res.getTime("HORA_RESERVA");
                int duracion = res.getInt("DURACION");
                String estadoDeReserva = res.getString("ESTADO_RESERVA");

                Reserva reserva = new Reserva(areaReservada, usuarioReserva, fechaDeReserva, horaDeReserva, duracion, estadoDeReserva);
                reservas.add(reserva);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return reservas;
    }
    
    public int obtenerIdUsuario(String usuario){
        int idUsuario = 0;
        String query = "SELECT id_usuario FROM Usuario WHERE usuario = "+ usuario;
        try {
            Connection con = Conexion.getCon();
            PreparedStatement sql = con.prepareStatement(query);
            ResultSet res = sql.executeQuery();

            idUsuario = res.getInt("id_usuario");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return idUsuario;
    }
}
