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
import javax.swing.table.DefaultTableModel;

public class BusquedaPropiedades {
    
    private static final String URL = "jdbc:mysql://localhost:3306/tu_base_de_datos";
    private static final String USER = "nombreusuario";
    private static final String PASSWORD = "contraseña";

    public static void buscarPorCedula(String numeCedula, JTable tabla) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Cédula");
        model.addColumn("Nombre");
        model.addColumn("Bloque Actual");
        model.addColumn("Edificio Actual");
        model.addColumn("Piso Actual");
        model.addColumn("Departamento Actual");
        model.addColumn("Observación Actual");

        String query = "SELECT cedula, nombre, bloque_actual, edificio_actual, piso_actual, departamento_actual, observacion_actual FROM tu_tabla WHERE cedula = ?";
        try (
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement statement = connection.prepareStatement(query);
        ) {
            statement.setString(1, numeCedula);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String cedula = resultSet.getString("cedula");
                String nombre = resultSet.getString("nombre");
                String bloque = resultSet.getString("bloque_actual");
                String edificio = resultSet.getString("edificio_actual");
                String piso = resultSet.getString("piso_actual");
                String departamento = resultSet.getString("departamento_actual");
                String observacion = resultSet.getString("observacion_actual");
                model.addRow(new Object[]{cedula, nombre, bloque, edificio, piso, departamento, observacion});
            }
            tabla.setModel(model);
        } catch (SQLException e) {
            System.out.println("No vale crack");
            e.printStackTrace();
        }
    }

    
}
