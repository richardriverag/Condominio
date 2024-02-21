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
import model.Cuota;
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

    public void agregarCuotas(Connection cn, List<Cuota> cuotas, int numCuotas) {      
        try {
            // Obtener el ID de pago más alto
            int maxIdPago = 0;
            PreparedStatement ppsMaxIdPago = cn.prepareStatement("SELECT MAX(ID_PAGOS) AS MAX_ID_PAGO FROM PAGO");
            ResultSet rsMaxIdPago = ppsMaxIdPago.executeQuery();
            if (rsMaxIdPago.next()) {
                maxIdPago = rsMaxIdPago.getInt("MAX_ID_PAGO");
            }
            // Cerrar el ResultSet y el PreparedStatement
            rsMaxIdPago.close();
            ppsMaxIdPago.close();

            // Paso 2: Insertar las cuotas en la tabla CUOTA
            for (int i = 1; i <= numCuotas; i++) {
                PreparedStatement pps = cn.prepareStatement("INSERT INTO CUOTA (ID_PAGOS, NUM_CUOTA, MONTO_CUOTA, FECHAV_CUOTA, ESTADO_CUOTA) VALUES(?,?,?,?,?)");
                pps.setInt(1, maxIdPago); // Utilizar el ID de pago más alto obtenido
                pps.setInt(2, i); 
                pps.setFloat(3, cuotas.get(i - 1).getMonto_Cuota()); 
                pps.setString(4, cuotas.get(i - 1).getFechaV_cuota()); 
                pps.setString(5, "Pendiente");
                pps.executeUpdate();
            }
        } 
        catch (SQLException ex) {
            // Logger.getLogger(BDCliente.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Ocurrió un error al ingresar los datos");
        }
    }

    
      public void desplegarCuotas(Connection cn, JTable jtable){
        // Crear un modelo de tabla para el JTable
        DefaultTableModel modelo = new DefaultTableModel();
        jtable.setModel(modelo);

        // Agregar columnas al modelo de la tabla
        modelo.addColumn("ID pagos");
        modelo.addColumn("ID cuota");
        modelo.addColumn("Número de Cuota");
        modelo.addColumn("Monto de Cuota");
        modelo.addColumn("Fecha de Vencimiento");
        modelo.addColumn("Estado Cuota");

        // Consulta SQL para seleccionar los ingresos
        String sql = "SELECT * FROM CUOTA";

        try{
           PreparedStatement  pps = cn.prepareStatement(sql);
            ResultSet rs = pps.executeQuery();

            // Leer los resultados de la consulta y agregarlos al modelo de la tabla
            while(rs.next()){
                Object[] fila = new Object[6]; // Crear un array de objetos para la fila
                fila[0] = rs.getString("ID_PAGOS");
                fila[1] = rs.getString("ID_CUOTA");
                fila[2] = rs.getString("NUM_CUOTA");
                fila[3] = rs.getString("MONTO_CUOTA");
                fila[4] = rs.getString("FECHAV_CUOTA");
                fila[5] = rs.getString("ESTADO_CUOTA");
                modelo.addRow(fila); // Agregar la fila al modelo de la tabla
            }
        } catch(SQLException ex){
            //Logger.getLogger(Pago.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Ocurrió un error al recuperar los datos");
        }
    }
}
