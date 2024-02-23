
package G1_Finanzas;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class Metodos_Sql_Pago {
  public void desplegarIngresosEgresos(Connection cn, JTable jtable, boolean Ingreso, boolean Egreso){
        // Crear un modelo de tabla para el JTable
        DefaultTableModel modelo = new DefaultTableModel();
        jtable.setModel(modelo);

        // Agregar columnas al modelo de la tabla
        modelo.addColumn("ID Pagos");
        modelo.addColumn("ID Usuario");
        modelo.addColumn("Fecha de Pago");
        modelo.addColumn("ID Metodo Pago");
        modelo.addColumn("Monto de Pago");
        modelo.addColumn("Tipo de Pago");
        modelo.addColumn("Fecha de Vencimiento");
        modelo.addColumn("Estado de Pago");
        modelo.addColumn("Descripción");

        String tipo_Pago = "";
        String tipo_Pago2 = "";
        String sql="";
        if (Ingreso && !Egreso) {
            tipo_Pago = "INGRESO ORDINARIO";
            tipo_Pago2 = "INGRESO EXTRAORDINARIO";
             sql = "SELECT ID_PAGOS, ID_USUARIO, FECHA_PAGO, ID_METODOPAGO, MONTO_PAGO, TIPO_PAGO, FECHAVENCIMIENTO_PAGO, ESTADO_PAGO, DESCRIPCION FROM PAGO WHERE TIPO_PAGO = \""+tipo_Pago+"\" OR TIPO_PAGO= \""+tipo_Pago2+"\";";
        } else if (Egreso && !Ingreso) {
            tipo_Pago = "EGRESO ORDINARIO";
            // Consulta SQL para seleccionar los ingresos
        sql = "SELECT ID_PAGOS, ID_USUARIO, FECHA_PAGO, ID_METODOPAGO, MONTO_PAGO, TIPO_PAGO, FECHAVENCIMIENTO_PAGO, ESTADO_PAGO, DESCRIPCION FROM PAGO WHERE TIPO_PAGO = \""+tipo_Pago+"\";";

        }
        
        try{
            PreparedStatement pps = cn.prepareStatement(sql);
            ResultSet rs = pps.executeQuery();

            // Leer los resultados de la consulta y agregarlos al modelo de la tabla
            while(rs.next()){
                Object[] fila = new Object[9]; // Crear un array de objetos para la fila
                fila[0] = rs.getString("ID_PAGOS");
                fila[1] = rs.getString("ID_USUARIO");
                fila[2] = rs.getDate("FECHA_PAGO");
                fila[3] = rs.getString("ID_METODOPAGO");
                fila[4] = rs.getFloat("MONTO_PAGO");
                fila[5] = rs.getString("TIPO_PAGO");
                fila[6] = rs.getDate("FECHAVENCIMIENTO_PAGO");
                fila[7] = rs.getString("ESTADO_PAGO");
                fila[8] = rs.getString("DESCRIPCION");

                modelo.addRow(fila); // Agregar la fila al modelo de la tabla
            }
        } catch(SQLException ex){
            Logger.getLogger(Pago.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Ocurrió un error al recuperar los datos");
        }
    }
  
    public void desplegarSaldoPendienteDeUsuario(Connection cn, String idUsuario, JTable tabla) throws SQLException {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID Usuario");
        modelo.addColumn("ID Pagos");
        modelo.addColumn("Saldo Pendiente");

        try {
            String sql = "SELECT P.ID_USUARIO, P.ID_PAGOS, P.MONTO_PAGO - COALESCE(SUM(C.MONTO_CUOTA), 0) AS SALDO_PENDIENTE "
                    + "FROM PAGO P "
                    + "LEFT JOIN CUOTA C ON C.ID_PAGOS = P.ID_PAGOS AND C.ESTADO_CUOTA = 'Pagado' "
                    + "WHERE P.ID_USUARIO = ?  and  p.estado_Pago = 'VIGENTE'"
                    + "GROUP BY P.ID_USUARIO, P.ID_PAGOS, P.MONTO_PAGO";

            PreparedStatement statement = cn.prepareStatement(sql);
            statement.setString(1, idUsuario);
            ResultSet resultSet = statement.executeQuery();

            Object[] fila = new Object[3];
            while (resultSet.next()) {
                fila[0] = resultSet.getString("ID_USUARIO");
                fila[1] = resultSet.getString("ID_PAGOS");
                fila[2] = resultSet.getDouble("SALDO_PENDIENTE");
                modelo.addRow(fila);
            }
            tabla.setModel(modelo);
        } catch (SQLException e) {
            System.err.print(e);
        }
    }
    
        public void desplegarInformacionPagosYCuotas(Connection cn, JTable tabla) throws SQLException {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID Usuario");
        modelo.addColumn("ID Pago");
        modelo.addColumn("Total cuotas pagadas");
        modelo.addColumn("Suma monto cuota");
        modelo.addColumn("Saldo pendiente");
        modelo.addColumn("Valor inicial");

        try {
            String sql = "SELECT P.ID_USUARIO, P.ID_PAGOS, MIN(C.FECHAV_CUOTA) AS FECHA_PRIMERA_CUOTA, "
                + "COUNT(C.ID_CUOTA) AS TOTAL_CUOTAS_PAGADAS, SUM(C.MONTO_CUOTA) AS SUMA_MONTO_CUOTA, "
                + "P.MONTO_PAGO - COALESCE(SUM(C.MONTO_CUOTA), 0) AS SALDO_PENDIENTE, P.MONTO_PAGO "
                + "FROM PAGO P LEFT JOIN CUOTA C ON C.ID_PAGOS = P.ID_PAGOS AND C.ESTADO_CUOTA = 'PAGADO' "
                + "WHERE C.ID_CUOTA IS NOT NULL "
                + "GROUP BY P.ID_USUARIO, P.ID_PAGOS, P.MONTO_PAGO "
                + "ORDER BY P.ID_USUARIO, P.ID_PAGOS";

            PreparedStatement statement = cn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            Object[] fila = new Object[6];
            while (resultSet.next()) {
                fila[0] = resultSet.getString("ID_USUARIO");
                fila[1] = resultSet.getString("ID_PAGOS");
                fila[2] = resultSet.getString("TOTAL_CUOTAS_PAGADAS");
                fila[3] = resultSet.getDouble("SUMA_MONTO_CUOTA");
                fila[4] = resultSet.getDouble("SALDO_PENDIENTE");
                fila[5] = resultSet.getDouble("MONTO_PAGO");
                modelo.addRow(fila);
            }
            tabla.setModel(modelo);
        } catch (SQLException e) {
            System.err.print(e);
        }
    }
    
    
    public boolean anularPago(Connection cn, String idPago) {
        String sql = "UPDATE PAGO SET ESTADO_PAGO = ? WHERE ID_PAGOS = ?;";
        
        try (PreparedStatement pps = cn.prepareStatement(sql)) {
            pps.setString(1, "ANULADO");
            pps.setString(2, idPago);
            
            int affectedRows = pps.executeUpdate();
            
            if (affectedRows > 0) {
                JOptionPane.showMessageDialog(null, "Pago Anulado.");
                return true; // Retornar true si la actualización fue exitosa
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el pago con el ID especificado.");
                return false; // Retornar false si no se actualizó ningún registro
            }
        } catch (SQLException ex) {
            Logger.getLogger(Metodos_Sql_Pago.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Ocurrió un error al actualizar el estado del pago.");
            return false; // Retornar false si ocurrió un error
        }
    }

    public void insertarPagoIngresoEgreso(Connection cn, Pago pago, String tipo,  boolean Ingreso, boolean Egreso){
        
        String tipo_Pago = "";
        String insertSql="";
        if (Ingreso && !Egreso) {
            tipo_Pago = tipo;
        } else if (Egreso && !Ingreso) {
            tipo_Pago = "EGRESO ORDINARIO";
        }
            
        try {
            
            insertSql = "INSERT INTO PAGO (ID_METODOPAGO, ID_USUARIO, FECHA_PAGO, MONTO_PAGO, TIPO_PAGO, FECHAVENCIMIENTO_PAGO, ESTADO_PAGO, DESCRIPCION) " +
             "VALUES ((SELECT ID_METODOPAGO FROM METODOPAGO WHERE NOMBRE_METODOPAGO = ?), ?, ?, ?, ?, ?, ?, ?)";

 
            PreparedStatement insertStatement = cn.prepareStatement(insertSql);
            insertStatement.setString(1, pago.getId_MetodoPago());
            insertStatement.setString(2, pago.getId_Usuario());
            insertStatement.setString(3, pago.getFecha_Pago());
            insertStatement.setFloat(4, pago.getMonto_Pago());
            insertStatement.setString(5, tipo_Pago);
            insertStatement.setString(6, pago.getFechaVencimiento_Pago());
            insertStatement.setString(7, "VIGENTE");
            insertStatement.setString(8, pago.getDescripcion());
            

            insertStatement.executeUpdate();
            insertStatement.close();
            JOptionPane.showMessageDialog(null, "Registro insertado correctamente en la tabla de pagos.");
            
 
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Ocurrió un error al insertar el registro en la tabla de pagos.");
            JOptionPane.showMessageDialog(null, ex);
            ex.printStackTrace();
        } 
    }
    
    public void desplegarIngresosEgresosCondominio(Connection cn, JTable jtable, boolean Ingreso, boolean Egreso, String idCondominio) {
        // Crear un modelo de tabla para el JTable
        DefaultTableModel modelo = new DefaultTableModel();
        jtable.setModel(modelo);

        // Agregar columnas al modelo de la tabla
        modelo.addColumn("ID Pagos");
        modelo.addColumn("ID Usuario");
        modelo.addColumn("Fecha de Pago");
        modelo.addColumn("ID Metodo Pago");
        modelo.addColumn("Monto de Pago");
        modelo.addColumn("Tipo de Pago");
        modelo.addColumn("Fecha de Vencimiento");
        modelo.addColumn("Estado de Pago");
        modelo.addColumn("Descripción");

        String tipo_Pago = "";
        String tipo_Pago2 = "";
        String sql = "";
        if (Ingreso && !Egreso) {
            tipo_Pago = "INGRESO ORDINARIO";
            tipo_Pago2 = "INGRESO EXTRAORDINARIO";
            sql = "SELECT P.ID_PAGOS, P.ID_USUARIO, P.FECHA_PAGO, P.ID_METODOPAGO, P.MONTO_PAGO, P.TIPO_PAGO, P.FECHAVENCIMIENTO_PAGO, P.ESTADO_PAGO, P.DESCRIPCION FROM PAGO P JOIN USUARIO U ON P.ID_USUARIO = U.ID_USUARIO JOIN DEPARTAMENTO_F D ON P.ID_USUARIO = D.ID_USUARIO WHERE (P.TIPO_PAGO = \"" + tipo_Pago + "\" OR P.TIPO_PAGO = \"" + tipo_Pago2 + "\")AND D.ID_CONDOMINIO_F = \"" + idCondominio + "\";";
        } else if (Egreso && !Ingreso) {
            tipo_Pago = "EGRESO ORDINARIO";
            // Consulta SQL para seleccionar los ingresos
            sql = "SELECT P.ID_PAGOS, P.ID_USUARIO, P.FECHA_PAGO, P.ID_METODOPAGO, P.MONTO_PAGO, P.TIPO_PAGO, P.FECHAVENCIMIENTO_PAGO, P.ESTADO_PAGO, P.DESCRIPCION FROM PAGO P JOIN USUARIO U ON P.ID_USUARIO = U.ID_USUARIO JOIN DEPARTAMENTO_F D ON P.ID_USUARIO = D.ID_USUARIO WHERE P.TIPO_PAGO = \"" + tipo_Pago + "\" AND D.ID_CONDOMINIO_F = \"" + idCondominio + "\";";

        }

        try {
            PreparedStatement pps = cn.prepareStatement(sql);
            ResultSet rs = pps.executeQuery();

            // Leer los resultados de la consulta y agregarlos al modelo de la tabla
            while (rs.next()) {
                Object[] fila = new Object[9]; // Crear un array de objetos para la fila
                fila[0] = rs.getString("ID_PAGOS");
                fila[1] = rs.getString("ID_USUARIO");
                fila[2] = rs.getDate("FECHA_PAGO");
                fila[3] = rs.getString("ID_METODOPAGO");
                fila[4] = rs.getFloat("MONTO_PAGO");
                fila[5] = rs.getString("TIPO_PAGO");
                fila[6] = rs.getDate("FECHAVENCIMIENTO_PAGO");
                fila[7] = rs.getString("ESTADO_PAGO");
                fila[8] = rs.getString("DESCRIPCION");

                modelo.addRow(fila); // Agregar la fila al modelo de la tabla
            }
        } catch (SQLException ex) {
            Logger.getLogger(Pago.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Ocurrió un error al recuperar los datos");
        }
    }
    
    public void desplegarIngresosEgresosDepartamento(Connection cn, JTable jtable, boolean Ingreso, boolean Egreso, String idDepartamento) {
        // Crear un modelo de tabla para el JTable
        DefaultTableModel modelo = new DefaultTableModel();
        jtable.setModel(modelo);

        // Agregar columnas al modelo de la tabla
        modelo.addColumn("ID Pagos");
        modelo.addColumn("ID Usuario");
        modelo.addColumn("Fecha de Pago");
        modelo.addColumn("ID Metodo Pago");
        modelo.addColumn("Monto de Pago");
        modelo.addColumn("Tipo de Pago");
        modelo.addColumn("Fecha de Vencimiento");
        modelo.addColumn("Estado de Pago");
        modelo.addColumn("Descripción");

        String tipo_Pago = "";
        String tipo_Pago2 = "";
        String sql = "";
        if (Ingreso && !Egreso) {
            tipo_Pago = "INGRESO ORDINARIO";
            tipo_Pago2 = "INGRESO EXTRAORDINARIO";
            sql = "SELECT "
                    + "    P.ID_PAGOS, "
                    + "    P.ID_USUARIO, "
                    + "    P.FECHA_PAGO, "
                    + "    P.ID_METODOPAGO, "
                    + "    P.MONTO_PAGO, "
                    + "    P.TIPO_PAGO, "
                    + "    P.FECHAVENCIMIENTO_PAGO, "
                    + "    P.ESTADO_PAGO, "
                    + "    P.DESCRIPCION "
                    + "FROM "
                    + "    PAGO P"
                    + " JOIN "
                    + "    DEPARTAMENTO_F D ON P.ID_USUARIO = D.ID_USUARIO"
                    + " WHERE  "
                    + "    (P.TIPO_PAGO = \"" + tipo_Pago + "\" OR P.TIPO_PAGO = \"" + tipo_Pago2 + "\")AND D.ID_CONDOMINIO_F = \"" + idDepartamento + "\";";
        } else if (Egreso && !Ingreso) {
            tipo_Pago = "EGRESO ORDINARIO";
            // Consulta SQL para seleccionar los ingresos
            sql = "SELECT "
                    + "    P.ID_PAGOS, "
                    + "    P.ID_USUARIO, "
                    + "    P.FECHA_PAGO, "
                    + "    P.ID_METODOPAGO, "
                    + "    P.MONTO_PAGO, "
                    + "    P.TIPO_PAGO, "
                    + "    P.FECHAVENCIMIENTO_PAGO, "
                    + "    P.ESTADO_PAGO, "
                    + "    P.DESCRIPCION "
                    + "FROM "
                    + "    PAGO P"
                    + "JOIN "
                    + "    DEPARTAMENTO_F D ON P.ID_USUARIO = D.ID_USUARIO"
                    + " WHERE P.TIPO_PAGO = \"" + tipo_Pago + "\" AND D.ID_CONDOMINIO_F = \"" + idDepartamento + "\";";

        }

        try {
            PreparedStatement pps = cn.prepareStatement(sql);
            ResultSet rs = pps.executeQuery();

            // Leer los resultados de la consulta y agregarlos al modelo de la tabla
            while (rs.next()) {
                Object[] fila = new Object[9]; // Crear un array de objetos para la fila
                fila[0] = rs.getString("ID_PAGOS");
                fila[1] = rs.getString("ID_USUARIO");
                fila[2] = rs.getDate("FECHA_PAGO");
                fila[3] = rs.getString("ID_METODOPAGO");
                fila[4] = rs.getFloat("MONTO_PAGO");
                fila[5] = rs.getString("TIPO_PAGO");
                fila[6] = rs.getDate("FECHAVENCIMIENTO_PAGO");
                fila[7] = rs.getString("ESTADO_PAGO");
                fila[8] = rs.getString("DESCRIPCION");

                modelo.addRow(fila); // Agregar la fila al modelo de la tabla
            }
        } catch (SQLException ex) {
            Logger.getLogger(Pago.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Ocurrió un error al recuperar los datos");
        }
    }
    
      public void desplegarIngresosExtraordinarios(Connection cn, JTable jtable){
        // Crear un modelo de tabla para el JTable
        DefaultTableModel modelo = new DefaultTableModel();
        jtable.setModel(modelo);

        // Agregar columnas al modelo de la tabla
        modelo.addColumn("ID Pagos");
        modelo.addColumn("ID Usuario");
        modelo.addColumn("Fecha de Pago");
        modelo.addColumn("ID Metodo Pago");
        modelo.addColumn("Monto de Pago");
        modelo.addColumn("Tipo de Pago");
        modelo.addColumn("Fecha de Vencimiento");
        modelo.addColumn("Estado de Pago");
        modelo.addColumn("Descripción");

        String sql = "SELECT ID_PAGOS, ID_USUARIO, FECHA_PAGO, ID_METODOPAGO, MONTO_PAGO, TIPO_PAGO, FECHAVENCIMIENTO_PAGO, ESTADO_PAGO, DESCRIPCION FROM PAGO WHERE TIPO_PAGO = INGRESO EXTRAORDINARIO";
        
        try{
            PreparedStatement pps = cn.prepareStatement(sql);
            ResultSet rs = pps.executeQuery();

            // Leer los resultados de la consulta y agregarlos al modelo de la tabla
            while(rs.next()){
                Object[] fila = new Object[9]; // Crear un array de objetos para la fila
                fila[0] = rs.getString("ID_PAGOS");
                fila[1] = rs.getString("ID_USUARIO");
                fila[2] = rs.getDate("FECHA_PAGO");
                fila[3] = rs.getString("ID_METODOPAGO");
                fila[4] = rs.getFloat("MONTO_PAGO");
                fila[5] = rs.getString("TIPO_PAGO");
                fila[6] = rs.getDate("FECHAVENCIMIENTO_PAGO");
                fila[7] = rs.getString("ESTADO_PAGO");
                fila[8] = rs.getString("DESCRIPCION");

                modelo.addRow(fila); // Agregar la fila al modelo de la tabla
            }
        } catch(SQLException ex){
            Logger.getLogger(Pago.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Ocurrió un error al recuperar los datos");
        }
    }
}