/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package G1_Finanzas;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Cuota;


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

    
      public void desplegarCuotas(Connection cn, JTable jtable, boolean pendiente){
        // Crear un modelo de tabla para el JTable
        DefaultTableModel modelo = new DefaultTableModel();
        jtable.setModel(modelo);

        // Agregar columnas al modelo de la tabla
        modelo.addColumn("ID Pago");
        modelo.addColumn("ID Cuota");
        modelo.addColumn("Número de Cuota");
        modelo.addColumn("Monto de Cuota");
        modelo.addColumn("Fecha de Vencimiento");
        modelo.addColumn("Estado Cuota");

        // Consulta SQL para seleccionar los ingresos
        String sql = "";
        if(pendiente){
            sql = "SELECT * FROM CUOTA WHERE ESTADO_CUOTA = 'Pendiente'";    
        }else{
            sql = "SELECT * FROM CUOTA";                
        }

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
      
    public void desplegarCuotasPagoEspecifico(Connection cn, JTable jtable, String idPago, boolean pendiente){

    // Crear un modelo de tabla para el JTable
        DefaultTableModel modelo = new DefaultTableModel();
        jtable.setModel(modelo);

        // Agregar columnas al modelo de la tabla
        modelo.addColumn("ID Pago");
        modelo.addColumn("ID Cuota");
        modelo.addColumn("Número de Cuota");
        modelo.addColumn("Monto de Cuota");
        modelo.addColumn("Fecha de Vencimiento");
        modelo.addColumn("Estado Cuota");

         String sql = "";
        // Consulta SQL para seleccionar los ingresos
        if(pendiente){
             sql = "SELECT * FROM CUOTA WHERE ID_PAGOS = "+idPago+" AND ESTADO_CUOTA = 'Pendiente'";
        }else{
             sql = "SELECT * FROM CUOTA WHERE ID_PAGOS = "+idPago;        
        }        
        
                System.out.println(sql);        

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
    
    // Método para eliminar cuotas por ID de pago
    public void eliminarCuotasPorIdPago(Connection cn, String idPago) {
        // Consulta SQL para eliminar las cuotas con el ID de pago especificado
        String sql = "DELETE FROM CUOTA WHERE ID_PAGOS = ?";
        
        try {
            // Preparar la sentencia SQL
            PreparedStatement pps = cn.prepareStatement(sql);
            // Establecer el parámetro de la consulta con el ID de pago
            pps.setString(1, idPago);
            
            // Ejecutar la sentencia SQL para eliminar las cuotas
            int filasAfectadas = pps.executeUpdate();
            
            // Verificar si se eliminaron cuotas
            if (filasAfectadas > 0) {
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron cuotas con el ID de pago " + idPago);
            }
            
            // Cerrar el PreparedStatement
            pps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocurrió un error al intentar eliminar las cuotas");
        }
    }
    public boolean actualizarEstadoCuotaAPagada(Connection cn, String idCuota) {
        String sql = "UPDATE CUOTA SET ESTADO_CUOTA = ? WHERE ID_CUOTA = ?;";

        try (PreparedStatement pps = cn.prepareStatement(sql)) {
            pps.setString(1, "PAGADO");
            pps.setString(2, idCuota);

            int affectedRows = pps.executeUpdate();

            if (affectedRows > 0) {
                JOptionPane.showMessageDialog(null, "Estado de la cuota actualizado a Pagada.");
                return true; // Retornar true si la actualización fue exitosa
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron cuotas asociadas al pago con el ID especificado.");
                return false; // Retornar false si no se actualizó ningún registro
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al actualizar el estado de la cuota.");
            return false; // Retornar false si ocurrió un error
        }
    }
    
    
     public void desplegarCuotasUsuarioEspecificoPendiente(Connection cn, JTable jtable, String idUsuario){
        // Crear un modelo de tabla para el JTable
        DefaultTableModel modelo = new DefaultTableModel();
        jtable.setModel(modelo);

        // Agregar columnas al modelo de la tabla
        modelo.addColumn("ID Pago");
        modelo.addColumn("ID Cuota");
        modelo.addColumn("Número de Cuota");
        modelo.addColumn("Monto de Cuota");
        modelo.addColumn("Fecha de Vencimiento");
        modelo.addColumn("Estado Cuota");

        // Consulta SQL para seleccionar las cuotas pendientes de un usuario específico
        String sql = "SELECT CUOTA.ID_PAGOS, CUOTA.ID_CUOTA, CUOTA.NUM_CUOTA, CUOTA.MONTO_CUOTA, CUOTA.FECHAV_CUOTA, CUOTA.ESTADO_CUOTA " +
                     "FROM CUOTA " +
                     "INNER JOIN PAGO ON CUOTA.ID_PAGOS = PAGO.ID_PAGOS " +
                     "WHERE PAGO.ID_USUARIO = ? AND CUOTA.ESTADO_CUOTA = 'Pendiente'";

        try{
            PreparedStatement pps = cn.prepareStatement(sql);
            pps.setString(1, idUsuario); // Establecer el ID de usuario como parámetro en la consulta
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
