/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package G5_CheckIn;

import condominio.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class ParqueaderoVisita extends javax.swing.JFrame {
 //conexion
    Conexion con = new Conexion();
    Connection cn = con.getCon();
   String[] informacion = new String[6];
    //varaibles globales
    int parqueadero = 0;
     
    //tablas 
    DefaultTableModel modelo;
    String estado;
    int idTabla=2;
    String[] Titulos={"Numero Parqueadero","Estado"};
    String nombreTabla = "Select * from  ParqueaderoVisita";
    //  ORDER BY [Fecha de Ingreso] DESC, [Hora de Ingreso] DESC

    public ParqueaderoVisita() {
        initComponents();
        modelo = new DefaultTableModel();
        modelo.addColumn("Numero Parqueadero");
        modelo.addColumn("Estado"); 
        JTableParqueadero.setModel(modelo);
        
        cargarTabla(modelo, JTableParqueadero, nombreTabla, Titulos, idTabla);
    }

 
    /**
     * Creates new form ParqueaderoVisita
     */
    
     public ParqueaderoVisita(String[] info) {
        initComponents();
        this.setLocationRelativeTo(this);
        informacion = info;
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        JTableParqueadero = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JTableParqueadero.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Numero Parqueadero", "Estado"
            }
        ));
        JTableParqueadero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableParqueaderoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTableParqueadero);

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel14.setText("Parqueadero Visitas");

        jLabel19.setText("Selecciona el parqueadero:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel14))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addGap(4, 4, 4)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        estado = "Ocupado";
       // String sql = "Update ParqueaderoVisita SET estado = '"+estado+"' WHERE idParqueadero ="+parqueadero;
       // ejecutar(sql);
        
        CheckIn_Nw ck = new CheckIn_Nw(String.valueOf(parqueadero),informacion);
        //jframe.setVisible(true);
        ck.setVisible(true);
        //Co
        this.setVisible(false);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void JTableParqueaderoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableParqueaderoMouseClicked
        int fila = JTableParqueadero.getSelectedRow();  
        if (fila == -1) 
        {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado la fila");
        }else{
            parqueadero = Integer.parseInt((String) JTableParqueadero.getValueAt(fila,0).toString());
        }
    }//GEN-LAST:event_JTableParqueaderoMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ParqueaderoVisita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ParqueaderoVisita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ParqueaderoVisita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ParqueaderoVisita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ParqueaderoVisita().setVisible(true);
            }
        });
    }

        public void ejecutar (String mysql){
        try 
        { 
            //Conectamos a la base de datos y le pasamos la sentencia mysql 
            PreparedStatement pps = cn.prepareStatement(mysql);
            //se ejecuta todo lo anterior en mysql.
            pps.executeUpdate(); 
        } 
        catch (Exception e) 
        {
            System.out.println("error");  
        }  
    }
      
    public void cargarTabla(DefaultTableModel tblAux, JTable tblTablaCine,String nombreTabla,String[] Titulos,int id){
       tblAux.setRowCount(0);
        try {
        PreparedStatement pps = cn.prepareStatement(nombreTabla);    
        ResultSet rs = pps.executeQuery();
            tblAux = (DefaultTableModel) tblTablaCine.getModel();
            Object[] variableTabla = new Object[id];
            while (rs.next()){
                try{
                    for(int i=0;i<id;i++){
                       variableTabla[i]=rs.getObject(Titulos[i]);
                    }
                }catch(SQLException ex){
                        System.out.println("error Cargar Tabla");  
                }
                tblAux.addRow(variableTabla);
            }
            tblTablaCine.setModel(tblAux);
        } catch (Exception ex) {
            System.out.println("error2");      
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTableParqueadero;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
