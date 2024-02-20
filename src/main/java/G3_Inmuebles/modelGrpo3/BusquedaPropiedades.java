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
    private static final String URL = "jdbc:mysql://localhost:3306/base_de_datos";
    private static final String USER = "nombreusuario";
    private static final String PASSWORD = "contraseña";

    public static void buscarPorCedula(String numeCedula, JTable tablaPropiedades) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Cédula");
        model.addColumn("Nombre");
        model.addColumn("Bloque");
        model.addColumn("Edificio");
        model.addColumn("Piso");
        model.addColumn("Departamento");
        model.addColumn("Observaciones");

        String query = "SELECT * FROM propiedades WHERE cedula = ?";
        try (
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement statement = connection.prepareStatement(query);
        ) {
            statement.setString(1, numeCedula);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String cedula = resultSet.getString("cedula");
                String nombre = resultSet.getString("nombre");
                String bloque = resultSet.getString("bloque");
                String edificio = resultSet.getString("edificio");
                String piso = resultSet.getString("piso");
                String departamento = resultSet.getString("departamento");
                String observaciones = resultSet.getString("observaciones");
                model.addRow(new Object[]{cedula, nombre, bloque, edificio, piso, departamento, observaciones});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Asignar el modelo a la tabla
        tablaPropiedades.setModel(model);
    }
}
