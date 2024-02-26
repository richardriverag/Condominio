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
import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class PestanaCatalogo {
    
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=Condominio;trustServerCertificate=true";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";
  

    public static void filtro(String dimension, String numeroHabitaciones, String servicio, String normas, JTable tablaCatalogo) {
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Tipo");
        model.addColumn("Estado");
        model.addColumn("Dimension");
        model.addColumn("numero_Habitaciones");
        model.addColumn("Servicios");
        model.addColumn("Normas");
        
        StringBuilder queryBuilder = new StringBuilder("SELECT ID, Tipo, Estado, Dimension, Num_Habitaciones, Servicios, Normas FROM CATALOGO_CONDOMINIOS WHERE 1=1");

        if (dimension != null && !dimension.equals("Todo")) {
            queryBuilder.append(" AND Dimension = ?");
        }
        if (numeroHabitaciones != null && !numeroHabitaciones.equals("Todo")) {
            queryBuilder.append(" AND Num_Habitaciones = ?");
        }
        if (servicio != null && !servicio.equals("Todo")) {
        String[] palabras = servicio.split("\\s*,\\s*"); // Divide la cadena en palabras separadas por comas y espacios
        queryBuilder.append(" AND (");
        for (int i = 0; i < palabras.length; i++) {
            queryBuilder.append("Servicios LIKE ?");
            if (i < palabras.length - 1) {
                queryBuilder.append(" OR ");
            }
        }
        queryBuilder.append(")");
    }
        if (normas != null && !normas.equals("Todo")) {
            queryBuilder.append(" AND Normas = ?");
        }
        
        System.out.println(queryBuilder);
        
        try (
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        PreparedStatement statement = connection.prepareStatement(queryBuilder.toString());
    ) {
        int parameterIndex = 1;
        if (dimension != null && !dimension.equals("Todo")) {
            statement.setString(parameterIndex++, dimension);
        }
        if (numeroHabitaciones != null && !numeroHabitaciones.equals("Todo")) {
            statement.setString(parameterIndex++, numeroHabitaciones);
        }
        if (servicio != null && !servicio.equals("Todo")) {
            String[] palabras = servicio.split("\\s*,\\s*"); // Divide la cadena en palabras separadas por comas y espacios
            for (String palabra : palabras) {
                statement.setString(parameterIndex++, "%" + palabra + "%"); // Agrega % alrededor de la palabra para buscar coincidencias parciales
            }
        }
        if (normas != null && !normas.equals("Todo")) {
            statement.setString(parameterIndex++, normas);
        }

        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            
            String ID = resultSet.getString("ID");
            String Tipo = resultSet.getString("Tipo");
            String Estado = resultSet.getString("Estado");
            String dimensionResult = resultSet.getString("Dimension");
            String numeroHabitacionesResult = resultSet.getString("Num_Habitaciones");
            String servicioResult = resultSet.getString("Servicios");
            String normasResult = resultSet.getString("Normas");
            model.addRow(new Object[]{ID, Tipo, Estado, dimensionResult, numeroHabitacionesResult, servicioResult, normasResult});
        }
        tablaCatalogo.setModel(model);
    } catch (SQLException e) {
        e.printStackTrace();
    }

        }

    public static void agregarReguistroCondominio(String Tipo, String Arrendado, String Dimension, String numHabitaciones, String Servicios, String Normas) {
        String query = "INSERT INTO CATALOGO_CONDOMINIOS (Tipo, Estado, Dimension, Num_Habitaciones, Servicios, Normas) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement statement = connection.prepareStatement(query);
        ) {
            statement.setString(1, Tipo);
            statement.setString(2, Arrendado);
            statement.setString(3, Dimension);
            statement.setString(4, numHabitaciones);
            statement.setString(5, Servicios);
            statement.setString(6, Normas);
            
            // Ejecutar la consulta para insertar la reserva
            statement.executeUpdate();
            System.out.println("Reserva enviada correctamente a la base de datos.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}