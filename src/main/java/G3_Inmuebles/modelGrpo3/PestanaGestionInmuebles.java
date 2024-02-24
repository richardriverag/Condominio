/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template


 */
package G3_Inmuebles.modelGrpo3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author joel.piuri
 */
public class PestanaGestionInmuebles {
    
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=Condominio;trustServerCertificate=true";
    private static final String USER = "sa";
    private static final String PASSWORD = "P@ssw0rd";

    public static String BuscarPorCedula(String numeCedula) {
        String query = "SELECT * FROM CLIENTE WHERE CI = ?";
        try (
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement statement = connection.prepareStatement(query);
        ) {
            statement.setString(1, numeCedula);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                // Si se encuentra un cliente con la cédula especificada
                String nombre = resultSet.getString("nombre");
                System.out.println("Cliente encontrado: " + nombre);
                return nombre;
            } else {
                // Si no se encuentra ningún cliente con la cédula especificada
                System.out.println("Cliente no encontrado");
                return "No existe cliente";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "No existe cliente";
        }
        //return null;
    }

    public static void TraertablaReserva(String numeCedula, JTable tablaGestionReserva1) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("CI");
        model.addColumn("Nombre");
        model.addColumn("Fecha");
        model.addColumn("Unidad");
        model.addColumn("Observaciones");

        String query = "SELECT CI, NOMBRE, FECHA_RESERVA_INMUEBLE, UNIDAD_RESERVADA, OBSERVACION FROM CLIENTE WHERE CI = ?";
        try (
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement statement = connection.prepareStatement(query);
        ) {
            statement.setString(1, numeCedula);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String Cedula = resultSet.getString("CI");
                String Nombre = resultSet.getString("NOMBRE");
                String Fecha = resultSet.getString("FECHA_RESERVA_INMUEBLE");
                String Unidad = resultSet.getString("UNIDAD_RESERVADA");
                String Observaciones = resultSet.getString("OBSERVACION");
                model.addRow(new Object[]{Cedula, Nombre, Fecha,Unidad,Observaciones});
                tablaGestionReserva1.setModel(model);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            
            for (int i = 0; i < 20; i++) {
               model.addRow(new Object[]{"null", "null", "null","null","null"});
            
            tablaGestionReserva1.setModel(model); 
            }
            
        }

        
        
    }

    public static void EnviarReserva(String numeCedula, String nombreUsuario, String fecha, String unidad, String observaciones) {
        String query = "INSERT INTO CLIENTE (CI, NOMBRE, FECHA_RESERVA_INMUEBLE, UNIDAD_RESERVADA, OBSERVACION) VALUES (?, ?, ?, ?, ?)";
        try (
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement statement = connection.prepareStatement(query);
        ) {
            statement.setString(1, numeCedula);
            statement.setString(2, nombreUsuario);
            statement.setString(3, fecha);
            statement.setString(4, unidad);
            statement.setString(5, observaciones);
            
            // Ejecutar la consulta para insertar la reserva
            statement.executeUpdate();
            System.out.println("Reserva enviada correctamente a la base de datos.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   

    
    
    
    
}
