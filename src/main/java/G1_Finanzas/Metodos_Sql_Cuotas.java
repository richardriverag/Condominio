/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package G1_Finanzas;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Pago;


/**
 *
 * @author eddya
 */
public class Metodos_Sql_Cuotas {
    public void desplegarCuotasPendientesDeUsuario(Connection cn, String idUsuario, JTable tabla) throws SQLException {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Número de Cuota");
        modelo.addColumn("Monto de Cuota");
        modelo.addColumn("Fecha de Vencimiento");

        try {
            String sql = "SELECT c.NUM_CUOTA, c.MONTO_CUOTA, c.FECHAV_CUOTA "
                    + "FROM CUOTA c "
                    + "INNER JOIN PAGO p ON c.ID_PAGOS = p.ID_PAGOS "
                    + "WHERE p.ID_USUARIO = \""+idUsuario+"\" AND c.ESTADO_CUOTA = 'Pendiente'";
            PreparedStatement statement = cn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            
            Object[] fila = new Object[3];
            while (resultSet.next()) {
                fila[0] = resultSet.getString("NUM_CUOTA");
                fila[1] = resultSet.getDouble("MONTO_CUOTA");
                fila[2] = resultSet.getDate("FECHAV_CUOTA");
                modelo.addRow(fila);
            }
            tabla.setModel(modelo);
        } catch (SQLException e) {
            System.err.print(e);
        }
    }
    
     public void desplegarCuotasPagadasDeUsuario(Connection cn, String idUsuario, JTable tabla) throws SQLException {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Número de Cuota");
        modelo.addColumn("Monto de Cuota");
        modelo.addColumn("Fecha de Vencimiento");

        try {
            String sql = "SELECT c.NUM_CUOTA, c.MONTO_CUOTA, c.FECHAV_CUOTA "
                    + "FROM CUOTA c "
                    + "INNER JOIN PAGO p ON c.ID_PAGOS = p.ID_PAGOS "
                    + "WHERE p.ID_USUARIO = \""+idUsuario+"\" AND c.ESTADO_CUOTA = 'Pagado'";
            PreparedStatement statement = cn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            
            Object[] fila = new Object[3];
            while (resultSet.next()) {
                fila[0] = resultSet.getString("NUM_CUOTA");
                fila[1] = resultSet.getDouble("MONTO_CUOTA");
                fila[2] = resultSet.getDate("FECHAV_CUOTA");
                modelo.addRow(fila);
            }
            tabla.setModel(modelo);
        } catch (SQLException e) {
            System.err.print(e);
        }
    }

}
