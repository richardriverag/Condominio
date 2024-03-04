/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package G3_Inmuebles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author joel.piuri
 */
public class PestanaReporte {
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=Condominio;trustServerCertificate=true";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    //Si se usa
    public static void crearReporte(String numCedula, String nombre, String bloqueAnterior, String tipoDepartamentoAnterior, String numDepartamentoAnterior, String bloqueNuevo, String departamentoNuevo, String tipoDepartamentoNuevo, String obsevacion) {
        
        String query = "INSERT INTO TablaObservaciones (Cedula ,Nombre, BloqueAnterior , BloqueActual, NumDepAnterior, NumDepActual, TipoDepartamentoAnterior,TipoDepartamentoActual,Observaciones) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
        
            try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement statement = connection.prepareStatement(query);
            ) {
                
                int numDepAnterior = Integer.parseInt(numDepartamentoAnterior);
                int numDepActual = Integer.parseInt(departamentoNuevo);
                statement.setString(1, numCedula);
                statement.setString(2, nombre);
                statement.setString(3, bloqueAnterior);
                statement.setString(4, bloqueNuevo);
                statement.setInt(5, numDepAnterior);
                statement.setInt(6, numDepActual);
                statement.setString(7, tipoDepartamentoAnterior);
                statement.setString(8, tipoDepartamentoNuevo);
                statement.setString(9, obsevacion);

                // Ejecutar la consulta para insertar la reserva
                statement.executeUpdate();
                System.out.println("Reserva enviada correctamente a la base de datos.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
    
    }

    //Si se usa
    public static void buscarPorCedula(String numeroCedula, JScrollPane jScrollPane13) {
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Cedula");
        model.addColumn("Nombre");
        model.addColumn("BloqueAnterior");
        model.addColumn("BloqueActual");
        model.addColumn("NumDepAnterior");
        model.addColumn("NumDepActual");
        model.addColumn("TipoDepartamentoAnterior");
        model.addColumn("TipoDepartamentoActual");
        model.addColumn("Observaciones");

        String query = "SELECT Cedula ,Nombre, BloqueAnterior , BloqueActual, NumDepAnterior, NumDepActual, TipoDepartamentoAnterior,TipoDepartamentoActual,Observaciones FROM TablaObservaciones WHERE Cedula = ?";
        try (
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement statement = connection.prepareStatement(query);
        ) {
            statement.setString(1, numeroCedula);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String Cedula = resultSet.getString("Cedula");
                String Nombre = resultSet.getString("Nombre");
                String BloqueAnterior = resultSet.getString("BloqueAnterior");
                String BloqueActual = resultSet.getString("BloqueActual");
                String numDepaAnterior = resultSet.getString("NumDepAnterior");
                String numDepaActual = resultSet.getString("NumDepActual");
                String DepaAnterior = resultSet.getString("TipoDepartamentoAnterior");
                String depaActual = resultSet.getString("TipoDepartamentoActual");
                String observacion = resultSet.getString("Observaciones");
                model.addRow(new Object[]{Cedula, Nombre, BloqueAnterior, BloqueActual, numDepaAnterior, numDepaActual, DepaAnterior, depaActual, observacion});
            }
            JTable table = new JTable(model); // Crear una tabla con el modelo de datos
            jScrollPane13.setViewportView(table); // Establecer la tabla dentro del JScrollPane
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
    
    
    }
    
}
