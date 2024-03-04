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
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class PestanaCatalogo {
    
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=Condominio;trustServerCertificate=true";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";
  

    //Si se usa
    public static void filtro(String numBloque, String tipo, String servicios, String normas, JTable tablaCatalogo) {
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Num Bloque");
        model.addColumn("Nombre Administrador");
        model.addColumn("Tipo");
        model.addColumn("Servicios");
        model.addColumn("Normas");
        model.addColumn("Estado");

        StringBuilder queryBuilder = new StringBuilder("SELECT ID, numBloque, Nombre_Administrador, Tipo, Servicios, Normas,Estado  FROM \"");
        queryBuilder.append(numBloque); // Aquí usamos el valor de numBloque como el nombre de la tabla 
        queryBuilder.append("\"");

        if (tipo != null && !tipo.equals("Todo")) {
            queryBuilder.append(" WHERE Tipo = ?");
        }
        if (servicios != null && !servicios.equals("Todo")) {
            String[] palabras = servicios.split("\\s*,\\s*");
            if (tipo != null && !tipo.equals("Todo")) {
                queryBuilder.append(" AND (");
            } else {
                queryBuilder.append(" WHERE (");
            }
            for (int i = 0; i < palabras.length; i++) {
                queryBuilder.append("Servicios LIKE ?");
                if (i < palabras.length - 1) {
                    queryBuilder.append(" OR ");
                }
            }
            queryBuilder.append(")");
        }
        if (normas != null && !normas.equals("Todo")) {
            if (tipo != null && !tipo.equals("Todo") || (servicios != null && !servicios.equals("Todo"))) {
                queryBuilder.append(" AND Normas = ?");
            } else {
                queryBuilder.append(" WHERE Normas = ?");
            }
        }
            
        System.out.println(queryBuilder);
        try (
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement statement = connection.prepareStatement(queryBuilder.toString());
        ) {
            
            System.out.println("Coneccion Exitosa");
            int parameterIndex = 1;
            if (tipo != null && !tipo.equals("Todo")) {
                statement.setString(parameterIndex++, tipo);
            }
            if (servicios != null && !servicios.equals("Todo")) {
                String[] palabras = servicios.split("\\s*,\\s*");
                for (String palabra : palabras) {
                    statement.setString(parameterIndex++, "%" + palabra + "%");
                }
            }
            if (normas != null && !normas.equals("Todo")) {
                statement.setString(parameterIndex++, normas);
            }

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {

                String ID = resultSet.getString("ID");
                String NumBloque = resultSet.getString("numBloque");
                String NombreAdministrador = resultSet.getString("Nombre_Administrador");
                String Tipo = resultSet.getString("Tipo");
                String servicioResult = resultSet.getString("Servicios");
                String normasResult = resultSet.getString("Normas");
                String Estado = resultSet.getString("Estado");
                model.addRow(new Object[]{ID, NumBloque, NombreAdministrador, Tipo, servicioResult, normasResult, Estado});
            }
            tablaCatalogo.setModel(model);
        } catch (SQLException e) {
            //e.printStackTrace();
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

    //Si se usa
    public static void agregarCondominio(String nombreBloque, String nombreAdministrador, String numDepGrandes, String numDepMedianos, String numDeppequenos, String numSuit, String servicio, String normas) {
        
        String query = "INSERT INTO CATALOGO_FORMULARIO (num_bloque, nombre_administrador, departamentos_grandes, departamentos_medianos, departamentos_pequenos, suits, servicios, normas) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement statement = connection.prepareStatement(query);
        ) {
            statement.setString(1, nombreBloque);
            statement.setString(2, nombreAdministrador);
            statement.setString(3, numDepGrandes);
            statement.setString(4, numDepMedianos);
            statement.setString(5, numDeppequenos);
            statement.setString(6, numSuit);
            statement.setString(7, servicio);
            statement.setString(8, normas);
            
            // Ejecutar la consulta para insertar la reserva
            statement.executeUpdate();
            System.out.println("Reserva enviada correctamente a la base de datos.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    
    }
    
    //Si se usa

    public static void filtroDepartamento(String numeroBloque, JTable jTable1) {
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Num Bloque");
        model.addColumn("Tipo");
        model.addColumn("Servicios");
        model.addColumn("Normas");

        StringBuilder queryBuilder = new StringBuilder("SELECT ID, numBloque, Tipo, Servicios, Normas  FROM \"");
        queryBuilder.append(numeroBloque); // Aquí usamos el valor de numBloque como el nombre de la tabla
        queryBuilder.append("\"");
        queryBuilder.append(" WHERE Estado = \'No arrendado\'");
        
        System.out.println(queryBuilder);
        
        //System.out.println(queryBuilder);
        
        try (
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement statement = connection.prepareStatement(queryBuilder.toString());
        ) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {

                String ID = resultSet.getString("ID");
                String NumBloque = resultSet.getString("numBloque");
                String Tipo = resultSet.getString("Tipo");
                String servicioResult = resultSet.getString("Servicios");
                String normasResult = resultSet.getString("Normas");
                model.addRow(new Object[]{ID, NumBloque, Tipo, servicioResult, normasResult});
            }
            jTable1.setModel(model);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
        
    }

    
    //Si se usa
    public static void actualizarEstadoDepartamento(String numeroBloque, int idEntero) {
    String query = "UPDATE \"" + numeroBloque + "\" SET Estado = 'Arrendado' WHERE id = ?";
    
    try (
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        PreparedStatement statement = connection.prepareStatement(query);
    ) {
        // Establecer el valor del parámetro para el ID
        statement.setInt(1, idEntero);
        
        // Ejecutar la consulta de actualización
        int filasActualizadas = statement.executeUpdate();
        
        // Verificar si se actualizaron filas
        if (filasActualizadas > 0) {
            System.out.println("Se actualizó el estado del departamento correctamente.");
        } else {
            System.out.println("No se encontró ningún departamento con el ID proporcionado.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
}