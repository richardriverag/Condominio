/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package G2_Usuarios;

import condominio.usuarios;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author JoisH
 */
public class EditarPerfil extends javax.swing.JFrame {

    public EditarPerfil() {
        initComponents();
        setLocationRelativeTo(null);

        setVisible(true);
        setResizable(false);//no miximizar

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        jToolBar1 = new javax.swing.JToolBar();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTFApellido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTFNombre = new javax.swing.JTextField();
        jTFEmailUsuario = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jToolBar1.setRollover(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Nombre");
        jLabel3.setAutoscrolls(true);
        jLabel3.setDoubleBuffered(true);
        jLabel3.setFocusCycleRoot(true);
        jLabel3.setFocusTraversalPolicyProvider(true);

        jTFApellido.setBorder(null);
        jTFApellido.setCaretColor(new java.awt.Color(255, 255, 255));
        jTFApellido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTFApellidoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTFApellidoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTFApellidoMouseExited(evt);
            }
        });
        jTFApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFApellidoActionPerformed(evt);
            }
        });
        jTFApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTFApellidoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFApellidoKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Apellido");
        jLabel4.setAutoscrolls(true);
        jLabel4.setDoubleBuffered(true);
        jLabel4.setFocusCycleRoot(true);
        jLabel4.setFocusTraversalPolicyProvider(true);

        jTFNombre.setBorder(null);
        jTFNombre.setCaretColor(new java.awt.Color(255, 255, 255));
        jTFNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTFNombreMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTFNombreMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTFNombreMouseExited(evt);
            }
        });
        jTFNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFNombreActionPerformed(evt);
            }
        });
        jTFNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTFNombreKeyPressed(evt);
            }
        });

        jTFEmailUsuario.setBorder(null);
        jTFEmailUsuario.setCaretColor(new java.awt.Color(255, 255, 255));
        jTFEmailUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTFEmailUsuarioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTFEmailUsuarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTFEmailUsuarioMouseExited(evt);
            }
        });
        jTFEmailUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFEmailUsuarioActionPerformed(evt);
            }
        });
        jTFEmailUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTFEmailUsuarioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFEmailUsuarioKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Email");
        jLabel6.setAutoscrolls(true);
        jLabel6.setDoubleBuffered(true);
        jLabel6.setFocusCycleRoot(true);
        jLabel6.setFocusTraversalPolicyProvider(true);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Editar Perfil");

        jButton1.setText("Confirmar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTFNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
                                    .addComponent(jTFEmailUsuario, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jTFApellido))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(224, 224, 224)
                        .addComponent(jLabel1)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFEmailUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(38, 38, 38))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked

    }//GEN-LAST:event_jPanel1MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked

        // Obtener los datos del nuevo usuario desde los campos de texto y el JComboBox
        String nombreUsuario = SessionManager.getUsuario(); // Obtenemos el nombre de usuario que está logueado
        // Nombre, apellido y email que se obtiene del recuadro
        String nombre = jTFNombre.getText();
        String apellido = jTFApellido.getText();
        String email = jTFEmailUsuario.getText();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/condominio", "root", "");
            // Verificar si el usuario ya existe en la base de datos
            String nombreUsuario1 = SessionManager.getUsuario();
            String selectQuery = "SELECT * FROM Usuario WHERE usuario = ?";
            preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setString(1, nombreUsuario1);
            resultSet = preparedStatement.executeQuery();

            // Actualizar los parámetros nombre, apellido y email del usuario
            if (resultSet.next()) {
                // Preparar sentencia para actualizar campos
                String updateQuery = "UPDATE Usuario SET nombre = ?, apellido = ?, email = ? WHERE usuario = ?";
                preparedStatement = connection.prepareStatement(updateQuery);
                preparedStatement.setString(1, nombre);
                preparedStatement.setString(2, apellido);
                preparedStatement.setString(3, email);
                // Obtener el usuario logueado
                String usuarioSessionManager = SessionManager.getUsuario();
                preparedStatement.setString(4, usuarioSessionManager);
                // Ejecutar la consulta de actualización
                int rowsUpdated = preparedStatement.executeUpdate();
                if (rowsUpdated > 0) {
                    JOptionPane.showMessageDialog(rootPane, "Campos Actualizados correctamente");
                    this.dispose();
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "ERROR");
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


    }//GEN-LAST:event_jButton1MouseClicked

    private void jTFEmailUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFEmailUsuarioKeyTyped

    }//GEN-LAST:event_jTFEmailUsuarioKeyTyped

    private void jTFEmailUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFEmailUsuarioKeyPressed

    }//GEN-LAST:event_jTFEmailUsuarioKeyPressed

    private void jTFEmailUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFEmailUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFEmailUsuarioActionPerformed

    private void jTFEmailUsuarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTFEmailUsuarioMouseExited

    }//GEN-LAST:event_jTFEmailUsuarioMouseExited

    private void jTFEmailUsuarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTFEmailUsuarioMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFEmailUsuarioMouseEntered

    private void jTFEmailUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTFEmailUsuarioMouseClicked

    }//GEN-LAST:event_jTFEmailUsuarioMouseClicked

    private void jTFNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFNombreKeyPressed
        jTFNombre.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && c != 'á' && c != 'é' && c != 'í' && c != 'ó' && c != 'ú' && c != 'Á' && c != 'É' && c != 'Í' && c != 'Ó' && c != 'Ú' && c != 'ñ' && c != 'Ñ' && c != ' ') {
                    Toolkit.getDefaultToolkit().beep(); // Emite un sonido de alerta
                    e.consume();
                }
            }
        });
    }//GEN-LAST:event_jTFNombreKeyPressed

    private void jTFNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFNombreActionPerformed

    private void jTFNombreMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTFNombreMouseExited

    }//GEN-LAST:event_jTFNombreMouseExited

    private void jTFNombreMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTFNombreMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFNombreMouseEntered

    private void jTFNombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTFNombreMouseClicked

    }//GEN-LAST:event_jTFNombreMouseClicked

    private void jTFApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFApellidoKeyTyped
        jTFApellido.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && c != 'á' && c != 'é' && c != 'í' && c != 'ó' && c != 'ú' && c != 'Á' && c != 'É' && c != 'Í' && c != 'Ó' && c != 'Ú' && c != 'ñ' && c != 'Ñ' && c != ' ') {
                    Toolkit.getDefaultToolkit().beep(); // Emite un sonido de alerta
                    e.consume();
                }
            }
        });
    }//GEN-LAST:event_jTFApellidoKeyTyped

    private void jTFApellidoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFApellidoKeyPressed
        jTFApellido.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && c != 'á' && c != 'é' && c != 'í' && c != 'ó' && c != 'ú' && c != 'Á' && c != 'É' && c != 'Í' && c != 'Ó' && c != 'Ú' && c != 'ñ' && c != 'Ñ' && c != ' ') {
                    Toolkit.getDefaultToolkit().beep(); // Emite un sonido de alerta
                    e.consume();
                }
            }
        });
    }//GEN-LAST:event_jTFApellidoKeyPressed

    private void jTFApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFApellidoActionPerformed

    private void jTFApellidoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTFApellidoMouseExited
        setCursor(Cursor.getDefaultCursor());

    }//GEN-LAST:event_jTFApellidoMouseExited

    private void jTFApellidoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTFApellidoMouseEntered
        setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
    }//GEN-LAST:event_jTFApellidoMouseEntered

    private void jTFApellidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTFApellidoMouseClicked

    }//GEN-LAST:event_jTFApellidoMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        //Getting started--FlatLaf - Flat Look and Feel

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarPerfil().setVisible(true);

            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTFApellido;
    private javax.swing.JTextField jTFEmailUsuario;
    private javax.swing.JTextField jTFNombre;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
