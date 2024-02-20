/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package G1_Finanzas;

import G1_Finanzas.FinanzasAdministrador;
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
import model.TipoPago;

/**
 *
 * @author Mil
 */
public class Metodos_Sql_TipoPago {
    static PreparedStatement pps;
    
    public void desplegarTipoPagos(Connection cn, JTable jtable){
        // Crear un modelo de tabla para el JTable
        DefaultTableModel modelo = new DefaultTableModel();
        jtable.setModel(modelo);

        // Agregar columnas al modelo de la tabla
        modelo.addColumn("ID Tipo de Pago");
        modelo.addColumn("Nombre Tipo de Pago");

        // Consulta SQL para seleccionar los ingresos
        String sql = "SELECT * FROM METODOPAGO";

        try{
            pps = cn.prepareStatement(sql);
            ResultSet rs = pps.executeQuery();

            // Leer los resultados de la consulta y agregarlos al modelo de la tabla
            while(rs.next()){
                Object[] fila = new Object[2]; // Crear un array de objetos para la fila
                fila[0] = rs.getString("ID_METODOPAGO");
                fila[1] = rs.getString("NOMBRE_METODOPAGO");
                
                modelo.addRow(fila); // Agregar la fila al modelo de la tabla
            }
        } catch(SQLException ex){
            //Logger.getLogger(Pago.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Ocurrió un error al recuperar los datos");
        }
    }
    
       public void agregarTipoPago(Connection cn, TipoPago tipopago){
          try{
              //Ejecucion de la sentencia que agrega un nuevo registro
              pps = cn.prepareStatement("INSERT INTO METODOPAGO (NOMBRE_METODOPAGO) VALUES (?)"); 
              //Leer los datos ingresados mediante la interfaz(Nuevo)
              pps.setString(1,tipopago.getNombre_Pago());
              pps.executeUpdate(); //Ejecutar lo configurado
              JOptionPane.showMessageDialog(null,"Datos guardados correctamente");
          }catch(SQLException ex){ //Error si el proceso falla
              //Logger.getLogger(FinanzasAdministrador.class.getName()).log(Level.SEVERE, null, ex);
              JOptionPane.showMessageDialog(null,"Ocurrió un error al ingresar los datos");
          }
      }
       
      
    public void actualizarTipoPago(Connection cn, TipoPago tipopago){
        Integer aux = null;
        try {
            String sql = "UPDATE METODOPAGO SET NOMBRE_METODOPAGO=? WHERE ID_METODOPAGO=?";
            pps = cn.prepareStatement(sql);
            pps.setString(1, tipopago.getNombre_Pago());
            pps.setString(2, tipopago.getId_TipoPago());
            pps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos actualizados correctamente");
        }catch(SQLException ex){
            //Logger.getLogger(BDCliente.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.toString()+"Ocurrió un error al actualizar los datos"); 
        }
    }

    public void eliminarAsiento(Connection cn, TipoPago tipopago){
        String sql = "DELETE FROM METODOPAGO WHERE ID_METODOPAGO=?";
        try {
            pps = cn.prepareStatement(sql);
            pps.setString(1, tipopago.getId_TipoPago());
            pps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos eliminados correctamente");
 
       }catch(SQLException ex){
           JOptionPane.showMessageDialog(null,"Ocurrio un error al eliminar los datos");
       }
    }

}
