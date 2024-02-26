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
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

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
        model.addColumn("Tipo");
        model.addColumn("Estado");
        model.addColumn("Fecha_Inicio");
        model.addColumn("Fecha_Fin");
        model.addColumn("Observaciones");

        String query = "SELECT CI, Nombre, Tipo, Estado, Fecha_Inicio,Fecha_Fin,Observaciones FROM CLIENTE WHERE CI = ?";
        try (
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement statement = connection.prepareStatement(query);
        ) {
            statement.setString(1, numeCedula);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String Cedula = resultSet.getString("CI");
                String Nombre = resultSet.getString("NOMBRE");
                String Tipo = resultSet.getString("Tipo");
                String Estado = resultSet.getString("Estado");
                String Fecha_Inicio = resultSet.getString("Fecha_Inicio");
                String Fecha_Fin = resultSet.getString("Fecha_Fin");
                String Observaciones = resultSet.getString("Observaciones");
                model.addRow(new Object[]{Cedula, Nombre, Tipo,Estado,Fecha_Inicio,Fecha_Fin,Observaciones});
                tablaGestionReserva1.setModel(model);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            
            for (int i = 0; i < 20; i++) {
               model.addRow(new Object[]{"null", "null", "null","null","null","null","null"});
            
            tablaGestionReserva1.setModel(model); 
            }
            
        }

        
        
    }

    public static void EnviarReserva(String numeCedula, String nombreUsuario, String tipo, String fecha_inicio, String fecha_fin, String Observaciones) {
        String query = "INSERT INTO CLIENTE (CI, NOMBRE, Tipo, Estado, Fecha_Inicio, Fecha_Fin, Observaciones) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        String Estado = "Reservado";
        try (
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement statement = connection.prepareStatement(query);
        ) {
            statement.setString(1, numeCedula);
            statement.setString(2, nombreUsuario);
            statement.setString(3, tipo);
            statement.setString(4, Estado);
            statement.setString(5, fecha_inicio);
            statement.setString(6, fecha_fin);
            statement.setString(7, Observaciones);
            
            // Ejecutar la consulta para insertar la reserva
            statement.executeUpdate();
            System.out.println("Reserva enviada correctamente a la base de datos.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void buscarTodasReservas(String estadoReserva, JTable tablaVisualizacionUsuarioGestionUnidades1) {
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Cedula");
        model.addColumn("Nombre");
        model.addColumn("Tipo");
        model.addColumn("Estado");
        model.addColumn("Fecha_Inicio");
        model.addColumn("Fecha_Fin");

        String query = "SELECT Cedula, Nombre, Tipo, Estado, Fecha_Inicio, Fecha_Fin FROM RESERVA WHERE Estado = ?";
        try (
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement statement = connection.prepareStatement(query);
        ) {
            statement.setString(1, estadoReserva);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String Cedula = resultSet.getString("Cedula");
                String Nombre = resultSet.getString("Nombre");
                String Tipo = resultSet.getString("Tipo");
                String Estado = resultSet.getString("Estado");
                String Fecha_Inicio = resultSet.getString("Fecha_Inicio");
                String Fecha_Fin = resultSet.getString("Fecha_Fin");
                model.addRow(new Object[]{Cedula, Nombre, Tipo,Estado,Fecha_Inicio,Fecha_Fin});
                tablaVisualizacionUsuarioGestionUnidades1.setModel(model);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            
            for (int i = 0; i < 20; i++) {
               model.addRow(new Object[]{"null", "null", "null","null","null","null"});
            
            tablaVisualizacionUsuarioGestionUnidades1.setModel(model); 
            }
            
        }
        
    
    }

    public static void AcualizarGeneral(String numeCedula, String nombreUsuario, String Unidad, String Fecha_inicio, String Fecha_fin) {
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Cedula");
        model.addColumn("Nombre");
        model.addColumn("Tipo");
        model.addColumn("Estado");
        model.addColumn("Fecha_Inicio");
        model.addColumn("Fecha_Fin");
        
        
        String query = "INSERT INTO RESERVA(Cedula, Nombre, Tipo, Estado, Fecha_Inicio, Fecha_Fin)\n" +
                        "VALUES\n" +
                        "('1234567890', 'Juan Pérez', 'Apartamento', 'Reservado', '2024-02-12', '2024-02-15'),";
        
        
    }

    public static void TraertablaReservaEstado(String estado, JTable tablaVisualizacionUsuarioGestionUnidades1) {
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("CI");
        model.addColumn("Nombre");
        model.addColumn("Tipo");
        model.addColumn("Estado");
        model.addColumn("Fecha_Inicio");
        model.addColumn("Fecha_Fin");
        model.addColumn("Observaciones");
        
        if(estado == "Todos los inmuebles"){
            
            

            String query = "SELECT ID, CI, Nombre, Tipo, Estado, Fecha_Inicio, Fecha_Fin, Observaciones FROM CLIENTE";
            try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement statement = connection.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery();
            ) {
                while (resultSet.next()) {
                    String ID = resultSet.getString("ID");
                    String Cedula = resultSet.getString("CI");
                    String Nombre = resultSet.getString("NOMBRE");
                    String Tipo = resultSet.getString("Tipo");
                    String Estado = resultSet.getString("Estado");
                    String Fecha_Inicio = resultSet.getString("Fecha_Inicio");
                    String Fecha_Fin = resultSet.getString("Fecha_Fin");
                    String Observaciones = resultSet.getString("Observaciones");
                    model.addRow(new Object[]{ID, Cedula, Nombre, Tipo, Estado, Fecha_Inicio, Fecha_Fin, Observaciones});
                }
                tablaVisualizacionUsuarioGestionUnidades1.setModel(model);
            } catch (SQLException e) {
                e.printStackTrace();
                // Aquí puedes manejar el error si ocurre
                for (int i = 0; i < 20; i++) {
                    model.addRow(new Object[]{"null", "null", "null", "null", "null", "null", "null", "null"});
                }
                tablaVisualizacionUsuarioGestionUnidades1.setModel(model);
            }
            
        }else{
   
        String query = "SELECT ID, CI, Nombre, Tipo, Estado, Fecha_Inicio,Fecha_Fin,Observaciones FROM CLIENTE WHERE Estado = ?";
        try (
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement statement = connection.prepareStatement(query);
        ) {
            statement.setString(1, estado);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String ID = resultSet.getString("ID");
                String Cedula = resultSet.getString("CI");
                String Nombre = resultSet.getString("NOMBRE");
                String Tipo = resultSet.getString("Tipo");
                String Estado = resultSet.getString("Estado");
                String Fecha_Inicio = resultSet.getString("Fecha_Inicio");
                String Fecha_Fin = resultSet.getString("Fecha_Fin");
                String Observaciones = resultSet.getString("Observaciones");
                model.addRow(new Object[]{ID, Cedula, Nombre, Tipo,Estado,Fecha_Inicio,Fecha_Fin,Observaciones});
                tablaVisualizacionUsuarioGestionUnidades1.setModel(model);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            
            for (int i = 0; i < 20; i++) {
               model.addRow(new Object[]{"null", "null", "null","null","null","null","null","null"});
            
            tablaVisualizacionUsuarioGestionUnidades1.setModel(model); 
            }
            
        }
        }
        
        
    }

    public static void eliminarRegistro(DefaultTableModel modeloTabla, int id) {
        String sql = "DELETE FROM CLIENTE WHERE ID = ?";
        
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                modeloTabla.removeRow(obtenerIndice(modeloTabla, id));
                System.out.println("Registro eliminado correctamente.");
            } else {
                System.out.println("No se encontró ningún registro con el ID proporcionado.");
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar el registro: " + e.getMessage());
        }
    }

    private static int obtenerIndice(DefaultTableModel modeloTabla, int id) {
        for (int i = 0; i < modeloTabla.getRowCount(); i++) {
            if (Integer.parseInt(modeloTabla.getValueAt(i, 0).toString()) == id) {
                return i;
            }
        }
        return -1;
    }

   

    
    
    
    
}
