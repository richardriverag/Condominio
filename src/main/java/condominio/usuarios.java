/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package condominio;

import G1_Finanzas.ConexionGrupo1;
import G2_Usuarios.EditarPerfil;
import G2_Usuarios.EditarPerfilAdministrador;
import G2_Usuarios.RegistroUsuario;
import G2_Usuarios.ResetearContraseña;
import G2_Usuarios.SessionManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author JoisH
 */
public class usuarios extends javax.swing.JFrame {

    public usuarios() {
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        beditarusuario = new javax.swing.JButton();
        bregistrarusuario = new javax.swing.JButton();
        bresetearusuario1 = new javax.swing.JButton();
        badministrarperfiles = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        beditarusuario.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        beditarusuario.setText("Editar Perfil");
        beditarusuario.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 102, 255), null));
        beditarusuario.setName("btnIniciar"); // NOI18N
        beditarusuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                beditarusuarioMouseClicked(evt);
            }
        });
        beditarusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beditarusuarioActionPerformed(evt);
            }
        });

        bregistrarusuario.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        bregistrarusuario.setText("Registrar Usuario");
        bregistrarusuario.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 102, 255), null));
        bregistrarusuario.setName("btnIniciar"); // NOI18N
        bregistrarusuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bregistrarusuarioMouseClicked(evt);
            }
        });
        bregistrarusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bregistrarusuarioActionPerformed(evt);
            }
        });

        bresetearusuario1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        bresetearusuario1.setText("Resetear Contraseña");
        bresetearusuario1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 102, 255), null));
        bresetearusuario1.setName("btnIniciar"); // NOI18N
        bresetearusuario1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bresetearusuario1MouseClicked(evt);
            }
        });
        bresetearusuario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bresetearusuario1ActionPerformed(evt);
            }
        });

        badministrarperfiles.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        badministrarperfiles.setText("Administar Perfiles");
        badministrarperfiles.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 102, 255), null));
        badministrarperfiles.setName("btnIniciar"); // NOI18N
        badministrarperfiles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                badministrarperfilesMouseClicked(evt);
            }
        });
        badministrarperfiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                badministrarperfilesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(badministrarperfiles, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(beditarusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bresetearusuario1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bregistrarusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(161, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(bregistrarusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bresetearusuario1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(beditarusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(badministrarperfiles, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void beditarusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beditarusuarioActionPerformed
        

    }//GEN-LAST:event_beditarusuarioActionPerformed

    private void bregistrarusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bregistrarusuarioActionPerformed
        RegistroUsuario frame = new RegistroUsuario();
        setVisible(false);
    }//GEN-LAST:event_bregistrarusuarioActionPerformed

    private void bregistrarusuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bregistrarusuarioMouseClicked

    }//GEN-LAST:event_bregistrarusuarioMouseClicked

    private void beditarusuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_beditarusuarioMouseClicked
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/condominio", "root", "123456");
            String usuario = SessionManager.getUsuario();
            String selectQuery = "SELECT * FROM Usuario WHERE usuario = ?";
            preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setString(1, usuario);
            resultSet = preparedStatement.executeQuery();
            // Obtener el tipo
            if (resultSet.next()) {
                int tipoUsuario = resultSet.getInt("tipoUsuario");
                // Verificar el usuario
                if (tipoUsuario == 2) {
                    EditarPerfil editarPerfil = new EditarPerfil();
                    editarPerfil.setVisible(true);
                    this.dispose(); // Cerrar el Frame actual si se abre el nuevo Frame
                } else {
                    // Si no es administrador, mostrar un mensaje
                    JOptionPane.showMessageDialog(rootPane, "No eres un usuario");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "El usuario no existe en la base de datos.");
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejar la excepción de manera adecuada, por ejemplo, mostrando un mensaje de error al usuario
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }//GEN-LAST:event_beditarusuarioMouseClicked

    public String getTipoUsuario(String usuario) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    String tipoUsuario = null;

    try {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/condominio", "root", "");
        //lo de abajo lo use porque no me funciono su forma de hacer conexion
//        ConexionGrupo1 cg1 = new ConexionGrupo1();
//        connection = cg1.conectar();
        String selectQuery = "SELECT tipoUsuario FROM Usuario WHERE usuario = ?";
        preparedStatement = connection.prepareStatement(selectQuery);
        preparedStatement.setString(1, usuario);
        resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            // Retrieve the tipoUsuario value
            int tipoUsuarioValue = resultSet.getInt("tipoUsuario");

            // Map the tipoUsuario value to a string (modify as needed)
            tipoUsuario = mapTipoUsuarioToString(tipoUsuarioValue);
        }
    } catch (SQLException ex) {
        Logger.getLogger(EditarPerfilAdministrador.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    return tipoUsuario;
}

private String mapTipoUsuarioToString(int tipoUsuarioValue) {
    // Modify this method to map integer tipoUsuario values to corresponding strings
    // For example, you can use a switch statement or if-else conditions
    switch (tipoUsuarioValue) {
        case 1:
            return "Tipo 1";
        case 2:
            return "Tipo 2";
        // Add more cases as needed
        default:
            return "Unknown Type";
    }
}

    private void bresetearusuario1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bresetearusuario1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bresetearusuario1MouseClicked

    private void bresetearusuario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bresetearusuario1ActionPerformed
        ResetearContraseña frame = new ResetearContraseña();
        setVisible(false);
    }//GEN-LAST:event_bresetearusuario1ActionPerformed

    private void badministrarperfilesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_badministrarperfilesMouseClicked
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/condominio", "root", "123456");
            String usuario = SessionManager.getUsuario();
            String selectQuery = "SELECT * FROM Usuario WHERE usuario = ?";
            preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setString(1, usuario);
            resultSet = preparedStatement.executeQuery();
            // Obtener el tipo de usuario del resultado
            if (resultSet.next()) {
                int tipoUsuario = resultSet.getInt("tipoUsuario");
                // Verificar si el usuario es administrador 
                if (tipoUsuario == 1) {
                    EditarPerfilAdministrador editarPerfilAdministrador = new EditarPerfilAdministrador();
                    editarPerfilAdministrador.setVisible(true);
                    this.dispose(); // Cerrar el Frame actual si se abre el nuevo Frame
                } else {
                    // Si no es administrador, mostrar un mensaje
                    JOptionPane.showMessageDialog(rootPane, "No eres administrador");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "El usuario no existe en la base de datos.");
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejar la excepción de manera adecuada, por ejemplo, mostrando un mensaje de error al usuario
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }


    }//GEN-LAST:event_badministrarperfilesMouseClicked

    private void badministrarperfilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_badministrarperfilesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_badministrarperfilesActionPerformed

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
            java.util.logging.Logger.getLogger(usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new usuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton badministrarperfiles;
    private javax.swing.JButton beditarusuario;
    private javax.swing.JButton bregistrarusuario;
    private javax.swing.JButton bresetearusuario1;
    // End of variables declaration//GEN-END:variables
}
