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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PestanaPropiedades {
    
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=Condominio;trustServerCertificate=true";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";
    
    
    //Si se usa
    public static void buscarPorCedula(String numeCedula, JTable tabla) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("CEDULA");
        model.addColumn("NOMBRE");
        model.addColumn("NUM_BLOQUE");
        model.addColumn("TIPO_PISO");
        model.addColumn("NUM_DEPARTAMENTO");

        String query = "SELECT CEDULA, NOMBRE, NUM_BLOQUE, TIPO_PISO, NUM_DEPARTAMENTO FROM GESTION_PROPIEDADES WHERE CEDULA = ?";
        try (
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement statement = connection.prepareStatement(query);
        ) {
            statement.setString(1, numeCedula);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String cedula = resultSet.getString("CEDULA");
                String nombre = resultSet.getString("NOMBRE");
                String Numero_Bloque = resultSet.getString("NUM_BLOQUE");
                String Tipo_Piso = resultSet.getString("TIPO_PISO");
                String Num_Departamento = resultSet.getString("NUM_DEPARTAMENTO");
                model.addRow(new Object[]{cedula, nombre, Numero_Bloque, Tipo_Piso, Num_Departamento});
            }
            tabla.setModel(model);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Si se usa
    public static String[] traerCampos(String numCedula) {
        
        String[] DatosUsuario = null;
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("CEDULA");
        model.addColumn("NOMBRE");
        model.addColumn("NUM_BLOQUE");
        model.addColumn("TIPO_PISO");
        model.addColumn("NUM_DEPARTAMENTO");

        String query = "SELECT CEDULA, NOMBRE, NUM_BLOQUE, TIPO_PISO, NUM_DEPARTAMENTO FROM GESTION_PROPIEDADES WHERE CEDULA = ?";
        try (
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement statement = connection.prepareStatement(query);
        ) {
            statement.setString(1, numCedula);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String nombre = resultSet.getString("NOMBRE");
                String Numero_Bloque = resultSet.getString("NUM_BLOQUE");
                String Tipo_Piso = resultSet.getString("TIPO_PISO");
                String Num_Departamento = resultSet.getString("NUM_DEPARTAMENTO");
                
                DatosUsuario = new String []{nombre,Numero_Bloque,Tipo_Piso,Num_Departamento};
                
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return DatosUsuario;

    
    }

    
}
