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
    
    private static final String URL = "jdbc:mysql://localhost:3306/tu_base_de_datos";
    private static final String USER = "nombreusuario";
    private static final String PASSWORD = "contraseña";

    public static String BuscarPorCedula(String numeCedula) {
        String query = "SELECT * FROM clientes WHERE cedula = ?";
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

        String query = "SELECT CI, Nombre, Fecha, Unidad, Observaciones FROM TablaReservas WHERE cedula_cliente = ?";
        try (
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement statement = connection.prepareStatement(query);
        ) {
            statement.setString(1, numeCedula);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String Cedula = resultSet.getString("Cedula");
                String Nombre = resultSet.getString("Nombre");
                String Fecha = resultSet.getString("Fecha");
                String Unidad = resultSet.getString("Unidad");
                String Observaciones = resultSet.getString("Observaciones");
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

   

    
    
    
    
}
