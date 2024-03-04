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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JoisH
 */
public class EditarPerfilAdministrador extends javax.swing.JFrame {

    DefaultTableModel model = new DefaultTableModel();
    private String usuarioSeleccionado;

    public EditarPerfilAdministrador() {
        initComponents();
        setLocationRelativeTo(null);

        setVisible(true);
        setResizable(false);//no miximizar

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        // Crear el modelo de la tabla con las columnas necesarias

        model.addColumn("Usuario");
        model.addColumn("Nombre");
        model.addColumn("Apellido");
        model.addColumn("Email");
        // Asignar el modelo a la tabla
        jTable1.setModel(model);

        // Llamar al método para cargar los datos de la base de datos en la tabla
        cargarDatosTabla();
    }

    // Método para cargar los datos de la base de datos en la tabla
    private void cargarDatosTabla() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/condominio", "root", "");
            String selectQuery = "SELECT * FROM usuario";
            preparedStatement = connection.prepareStatement(selectQuery);
            resultSet = preparedStatement.executeQuery();

            model.setRowCount(0);

            // Recorrer el ResultSet y agregar cada fila a la tabla
            while (resultSet.next()) {
                String usuario = resultSet.getString("usuario");
                String nombre = resultSet.getString("nombre");
                String apellido = resultSet.getString("apellido");
                String email = resultSet.getString("email");
                model.addRow(new Object[]{usuario, nombre, apellido, email});
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
        jLabel5 = new javax.swing.JLabel();
        jTFUsuario = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jBEditar = new javax.swing.JButton();
        jBEliminar = new javax.swing.JButton();

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

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Usuario");
        jLabel5.setAutoscrolls(true);
        jLabel5.setDoubleBuffered(true);
        jLabel5.setFocusCycleRoot(true);
        jLabel5.setFocusTraversalPolicyProvider(true);

        jTFUsuario.setBorder(null);
        jTFUsuario.setCaretColor(new java.awt.Color(255, 255, 255));
        jTFUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTFUsuarioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTFUsuarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTFUsuarioMouseExited(evt);
            }
        });
        jTFUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFUsuarioActionPerformed(evt);
            }
        });
        jTFUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTFUsuarioKeyPressed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jBEditar.setText("Editar");
        jBEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBEditarMouseClicked(evt);
            }
        });
        jBEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEditarActionPerformed(evt);
            }
        });

        jBEliminar.setText("Eliminar");
        jBEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBEliminarMouseClicked(evt);
            }
        });
        jBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(224, 224, 224)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTFUsuario)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jTFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(jTFApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTFEmailUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(43, 43, 43))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jBEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTFUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jTFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jTFApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jTFEmailUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBEditar)
                    .addComponent(jBEliminar))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        //Verificar que el usuario ya existe 
    }//GEN-LAST:event_jPanel1MouseClicked
    private boolean usuarioExistente(String usuario) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/condominio", "root", "");
            String selectQuery = "SELECT usuario FROM Usuario WHERE usuario = ?";
            preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setString(1, usuario);
            resultSet = preparedStatement.executeQuery();

            // Si encuentra algún resultado, significa que el usuario ya existe
            return resultSet.next();
        } catch (SQLException ex) {
            Logger.getLogger(EditarPerfilAdministrador.class.getName()).log(Level.SEVERE, null, ex);
            return false; // En caso de error, se considera que el usuario no existe
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
    }
    private void jBEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBEditarMouseClicked

        // Obtener los datos del nuevo usuario desde los campos de texto y el JComboBox
        String nombreUsuario = SessionManager.getUsuario(); // Obtenemos el nombre de usuario que está logueado
        // Obtener datos ingresados por el usuario como usuario, nombre, apellido y email.
        String usuario = jTFUsuario.getText();
        String nombre = jTFNombre.getText();
        String apellido = jTFApellido.getText();
        String email = jTFEmailUsuario.getText();
        //Verificar que no se actualice el usuario que esta logueado
        if (usuarioSeleccionado.equals(nombreUsuario)) {
            JOptionPane.showMessageDialog(rootPane, "No puedes actualizar tus propias credenciales.");
            return;
        }
        //Verificar que el usuario ya existe en la base de datos 
        if (usuarioExistente(usuario)) {
            JOptionPane.showMessageDialog(rootPane, "El usuario ya existe. Por favor, elija otro nombre de usuario.");
            return;
        }
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/condominio", "root", "");
            String selectQuery = "SELECT * FROM Usuario WHERE usuario = ?";
            preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setString(1, nombreUsuario);
            resultSet = preparedStatement.executeQuery();

            // Verificar que los campos no coincidan con la base de datos
            if (resultSet.next()) {
                String nombreDB = resultSet.getString("nombre");
                String apellidoDB = resultSet.getString("apellido");
                String emailDB = resultSet.getString("email");
                if (usuario.equals(usuarioSeleccionado) || usuario.equals(nombreUsuario) || nombre.equals(nombreDB) || apellido.equals(apellidoDB) || email.equals(emailDB)) {
                    JOptionPane.showMessageDialog(rootPane, "Ingrese campos nuevos");
                } else {
                    // Preparar nueva consulta de actualización
                    String updateQuery = "UPDATE Usuario SET usuario = ?, nombre = ?, apellido = ?, email = ? WHERE usuario = ?";
                    preparedStatement = connection.prepareStatement(updateQuery);
                    preparedStatement.setString(1, usuario);
                    preparedStatement.setString(2, nombre);
                    preparedStatement.setString(3, apellido);
                    preparedStatement.setString(4, email);
                    preparedStatement.setString(5, usuarioSeleccionado);
                    int rowsUpdated = preparedStatement.executeUpdate();

                    if (rowsUpdated > 0) {
                        JOptionPane.showMessageDialog(rootPane, "Campos Actualizados correctamente");
                        cargarDatosTabla();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "ERROR");
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

    }//GEN-LAST:event_jBEditarMouseClicked

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

    private void jBEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEditarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBEditarActionPerformed

    private void jTFUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTFUsuarioMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFUsuarioMouseClicked

    private void jTFUsuarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTFUsuarioMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFUsuarioMouseEntered

    private void jTFUsuarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTFUsuarioMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFUsuarioMouseExited

    private void jTFUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFUsuarioActionPerformed

    private void jTFUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFUsuarioKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFUsuarioKeyPressed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow != -1) {
            usuarioSeleccionado = (String) jTable1.getValueAt(selectedRow, 0);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jBEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBEliminarMouseClicked

    }//GEN-LAST:event_jBEliminarMouseClicked

    private void jBEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarActionPerformed
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(rootPane, "Por favor, seleccione una fila para eliminar.");
            return;
        }

        String usuarioAEliminar = (String) jTable1.getValueAt(selectedRow, 0);

        // Verificar si el usuario a eliminar es el mismo que el usuario logueado
        if (usuarioAEliminar.equals(SessionManager.getUsuario())) {
            JOptionPane.showMessageDialog(rootPane, "No puedes eliminar tu propio usuario.");
            return;
        }

        int confirmacion = JOptionPane.showConfirmDialog(rootPane, "¿Está seguro de que desea eliminar este usuario?");
        if (confirmacion == JOptionPane.YES_OPTION) {
            eliminarUsuario(usuarioAEliminar);
        }
    }//GEN-LAST:event_jBEliminarActionPerformed
    private void eliminarUsuario(String usuario) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/condominio", "root", "");
            String deleteQuery = "DELETE FROM Usuario WHERE usuario = ?";
            preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setString(1, usuario);
            int rowsDeleted = preparedStatement.executeUpdate();

            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(rootPane, "Usuario eliminado correctamente.");
                cargarDatosTabla(); // Actualizar la tabla después de eliminar el usuario
            }
        } catch (SQLException ex) {
            Logger.getLogger(EditarPerfilAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
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
    }

    public static void main(String args[]) {
        //Getting started--FlatLaf - Flat Look and Feel

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarPerfilAdministrador().setVisible(true);

            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBEditar;
    private javax.swing.JButton jBEliminar;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFApellido;
    private javax.swing.JTextField jTFEmailUsuario;
    private javax.swing.JTextField jTFNombre;
    private javax.swing.JTextField jTFUsuario;
    public javax.swing.JTable jTable1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
