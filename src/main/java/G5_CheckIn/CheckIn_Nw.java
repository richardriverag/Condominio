/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package G5_CheckIn;

import java.awt.event.KeyEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.Visita;

/**
 *
 * @author Usuario
 */
public class CheckIn_Nw extends javax.swing.JFrame {

    //clases
    model.ParqueaderoVisita pv;
    Visita v;
    G5_GestionDB c = new G5_GestionDB();
    
    //variables globales
    String VehiculoParqueadero = "";
    int parqueaderoID = 0;
    int aux=8;
    String[] arrayInfo = new String[6];
    boolean proveedor = false;
    String estadoParqueadero="";
    
    //tablahistorial
    DefaultTableModel modeloHistorial;
    int idAux;
    int idTablaHistorial=4;
       String[] TitulosHistorial={"TipoUsuario","Nombre","FechaIngreso","HoraIngreso"};
       String nombreTablaHistorial = "SELECT * FROM historialIngresosCondominio_v";
    // tablavisita
    DefaultTableModel modeloVisita;
     int idTablaVisita=5;
       String[] TitulosVisita={"NombreVisita","Fecha","Hora","ResidenteAVisitar","Motivo"};
       String nombreTablaVisita = "select * from VisitasProximas_v";
    /**
     * Creates new form CheckIn
     */
    public CheckIn_Nw() {
        initComponents();
        this.setLocationRelativeTo(this);
        c = new G5_GestionDB();
        pv = new model.ParqueaderoVisita();
        v = new Visita();
      //  jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Update buyer.png")));
        lbResidente1.setVisible(false);
        lbResidente2.setVisible(false);
        lbFecha1.setVisible(false);
        lbFecha2.setVisible(false);
        lbHora1.setVisible(false);
        lbHora2.setVisible(false);
        
        //tablaHistorial
        modeloHistorial = new DefaultTableModel();
        modeloHistorial.addColumn("TipoUsuario");
        modeloHistorial.addColumn("Nombre");
        modeloHistorial.addColumn("Fecha de Ingreso");
        modeloHistorial.addColumn("Hora de Ingreso");
        
        jTableHistorial.setModel(modeloHistorial);
        
        c.cargarTabla(modeloHistorial, jTableHistorial, nombreTablaHistorial, TitulosHistorial, idTablaHistorial);
        
        
        //tablaVisitas
        modeloVisita = new DefaultTableModel();
        modeloVisita.addColumn("Visita");
        modeloVisita.addColumn("Fecha");
        modeloVisita.addColumn("Hora");
        modeloVisita.addColumn("Residente");
        modeloVisita.addColumn("Motivo");
        
        jTableVisitasP.setModel(modeloVisita);
        
        c.cargarTabla(modeloVisita, jTableVisitasP, nombreTablaVisita, TitulosVisita, idTablaVisita);
        
        JTextNombreResidente.setEditable(false);
        JTextNombreResidente2.setEditable(true);
         lbParqueadero.setVisible(false);
        jTabbedPane1.setSelectedIndex(1);
        
    }

    public CheckIn_Nw(String parqueadero,String[] a,String estado) {
       initComponents();
        this.setLocationRelativeTo(this);
        c = new G5_GestionDB();
        pv = new model.ParqueaderoVisita();
        v = new Visita();
        estadoParqueadero = estado;
        jTabbedPane1.setSelectedIndex(2);
      //  jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Update buyer.png")));
        lbResidente1.setVisible(false);
        lbResidente2.setVisible(false);
        lbFecha1.setVisible(false);
        lbFecha2.setVisible(false);
        lbHora1.setVisible(false);
        lbHora2.setVisible(false);
        
        JTextNombreResidente.setEditable(false);
        JTextNombreResidente2.setEditable(true);
      
        JTextNombreVistante.setText(a[0]);
        jTextDep2.setText(a[1]);
        JTextNombreResidente2.setText(a[2]);
        JTextMotivoVisita.setText(a[3]);
        JCBVehiculo.setSelectedIndex(0);
        JTextFecha2.setText(a[4]);
        JTextHora2.setText(a[5]);
        parqueaderoID = Integer.parseInt(parqueadero);
        lbParqueadero.setText("Parqueadero #"+parqueadero+" asignado");
        
        //tablaHistorial
        modeloHistorial = new DefaultTableModel();
        modeloHistorial.addColumn("TipoUsuario");
        modeloHistorial.addColumn("Nombre");
        modeloHistorial.addColumn("Fecha de Ingreso");
        modeloHistorial.addColumn("Hora de Ingreso");
        
        jTableHistorial.setModel(modeloHistorial);
        
        c.cargarTabla(modeloHistorial, jTableHistorial, nombreTablaHistorial, TitulosHistorial, idTablaHistorial);
        
        
        //tablaVisitas
        modeloVisita = new DefaultTableModel();
        modeloVisita.addColumn("Visita");
        modeloVisita.addColumn("Fecha");
        modeloVisita.addColumn("Hora");
        modeloVisita.addColumn("Residente");
        modeloVisita.addColumn("Motivo");
        
        jTableVisitasP.setModel(modeloVisita);
        
        c.cargarTabla(modeloVisita, jTableVisitasP, nombreTablaVisita, TitulosVisita, idTablaVisita);
         lbParqueadero.setVisible(true);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTXMensajeAlerta = new javax.swing.JTextArea();
        btnNotificar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnRegistrarIngreso = new javax.swing.JButton();
        JTextFecha1 = new javax.swing.JTextField();
        JTextNombreResidente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnActualResidente = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        JTextHora1 = new javax.swing.JTextField();
        lbFecha1 = new javax.swing.JLabel();
        lbHora1 = new javax.swing.JLabel();
        lbResidente1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextDep1 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        labelfecha = new javax.swing.JLabel();
        JTextFecha2 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        JTextNombreVistante = new javax.swing.JTextField();
        btnRegistrarNotificar = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        JTextNombreResidente2 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTextMotivoVisita = new javax.swing.JTextArea();
        lbParqueadero = new javax.swing.JLabel();
        JCBVehiculo = new javax.swing.JComboBox<>();
        JTextHora2 = new javax.swing.JTextField();
        btnActualResidente1 = new javax.swing.JButton();
        lbFecha2 = new javax.swing.JLabel();
        lbHora2 = new javax.swing.JLabel();
        lbResidente2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextDep2 = new javax.swing.JTextField();
        jcheckProveedor = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableHistorial = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableVisitasP = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();

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
        jScrollPane4.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 0, 0));
        jLabel22.setText("ENVIAR ALERTA ");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setText("Mensaje:");

        jTXMensajeAlerta.setColumns(20);
        jTXMensajeAlerta.setRows(5);
        jScrollPane3.setViewportView(jTXMensajeAlerta);

        btnNotificar.setText("Notificar a todos los residentes");
        btnNotificar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 51, 0), 1, true));
        btnNotificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNotificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addComponent(btnNotificar, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(jLabel22)))
                .addContainerGap(135, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addComponent(btnNotificar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(98, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("ALERTAS", jPanel2);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setText("Ingreso de residente");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Hora: ");

        btnRegistrarIngreso.setText("Registrar Ingreso");
        btnRegistrarIngreso.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 255), 1, true));
        btnRegistrarIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarIngresoActionPerformed(evt);
            }
        });

        JTextFecha1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTextFecha1KeyReleased(evt);
            }
        });

        JTextNombreResidente.setBackground(new java.awt.Color(204, 204, 204));
        JTextNombreResidente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTextNombreResidenteKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Fecha:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Nombre y Apellido del residente:");

        btnActualResidente.setText("Fecha y Hora Actual");
        btnActualResidente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualResidenteActionPerformed(evt);
            }
        });

        jLabel3.setText("-");

        JTextHora1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTextHora1ActionPerformed(evt);
            }
        });
        JTextHora1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTextHora1KeyReleased(evt);
            }
        });

        lbFecha1.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        lbFecha1.setForeground(new java.awt.Color(255, 0, 0));
        lbFecha1.setText("*Ingrese una fecha correcta");

        lbHora1.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        lbHora1.setForeground(new java.awt.Color(255, 0, 0));
        lbHora1.setText("*Ingrese una hora correcta");

        lbResidente1.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        lbResidente1.setForeground(new java.awt.Color(255, 0, 0));
        lbResidente1.setText("* No existe el residente");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Numero de Departamento:");

        jTextDep1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextDep1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextDep1KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(233, 233, 233)
                        .addComponent(btnRegistrarIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextDep1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(186, 186, 186)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lbFecha1)
                                        .addComponent(lbHora1)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(19, 19, 19)
                                                .addComponent(btnActualResidente))
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(JTextHora1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(JTextFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lbResidente1))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(62, 62, 62)
                                    .addComponent(JTextNombreResidente, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(222, 222, 222)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 3, Short.MAX_VALUE)
                        .addComponent(jTextDep1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(lbResidente1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTextNombreResidente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnActualResidente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(JTextFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbFecha1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(JTextHora1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addComponent(lbHora1)
                        .addGap(39, 39, 39)
                        .addComponent(btnRegistrarIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))))
        );

        jTabbedPane1.addTab("Residente", jPanel1);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel14.setText("Ingreso de visitante");

        labelfecha.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelfecha.setText("Fecha:");

        JTextFecha2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTextFecha2KeyReleased(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Hora: ");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Nombre y Apellido del visitante:");

        JTextNombreVistante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTextNombreVistanteKeyReleased(evt);
            }
        });

        btnRegistrarNotificar.setText("Registrar y Notificar");
        btnRegistrarNotificar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 255), 1, true));
        btnRegistrarNotificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarNotificarActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Nombre y Apellido del residente:");

        JTextNombreResidente2.setBackground(new java.awt.Color(204, 204, 204));
        JTextNombreResidente2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTextNombreResidente2KeyReleased(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setText("Vehiculo:");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("Motivo de la visita:");

        JTextMotivoVisita.setColumns(20);
        JTextMotivoVisita.setRows(5);
        jScrollPane1.setViewportView(JTextMotivoVisita);

        lbParqueadero.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbParqueadero.setText("Parqueadero Asignado");

        JCBVehiculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));
        JCBVehiculo.setSelectedIndex(-1);
        JCBVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCBVehiculoActionPerformed(evt);
            }
        });

        JTextHora2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTextHora2KeyReleased(evt);
            }
        });

        btnActualResidente1.setText("Fecha y Hora Actual");
        btnActualResidente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualResidente1ActionPerformed(evt);
            }
        });

        lbFecha2.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        lbFecha2.setForeground(new java.awt.Color(255, 0, 0));
        lbFecha2.setText("*Ingrese una fecha correcta");

        lbHora2.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        lbHora2.setForeground(new java.awt.Color(255, 0, 0));
        lbHora2.setText("*Ingrese una hora correcta");

        lbResidente2.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        lbResidente2.setForeground(new java.awt.Color(255, 0, 0));
        lbResidente2.setText("* No existe el residente");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Numero de Departamento:");

        jTextDep2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextDep2KeyReleased(evt);
            }
        });

        jcheckProveedor.setText("Proveedor");
        jcheckProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcheckProveedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(JTextNombreVistante, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jcheckProveedor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel14))
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(169, 169, 169)
                                .addComponent(btnRegistrarNotificar, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(JTextNombreResidente2, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbResidente2))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JCBVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbParqueadero))
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextDep2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(lbHora2)
                                .addGap(27, 27, 27))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(lbFecha2)
                                .addGap(18, 18, 18))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnActualResidente1)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(labelfecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JTextFecha2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JTextHora2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 36, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jcheckProveedor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JTextNombreVistante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelfecha)
                        .addComponent(JTextFecha2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel16))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lbFecha2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JTextHora2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbHora2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnActualResidente1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextDep2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(lbResidente2))
                        .addGap(3, 3, 3)
                        .addComponent(JTextNombreResidente2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(JCBVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbParqueadero))
                        .addGap(26, 26, 26)))
                .addComponent(btnRegistrarNotificar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        jTabbedPane1.addTab("Visitante", jPanel3);

        jTableHistorial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Tipo", "FechaIngreso", "HoraIngreso", "Id_Usuario"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableHistorial);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel13.setText("HISTÓRICO DE INGRESOS AL CONDOMINIO");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel13))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addGap(45, 45, 45)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Historial", jPanel4);

        jTableVisitasP.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(jTableVisitasP);

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel15.setText("Agendaciones de Visitantes");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel15)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Visitantes Agendados", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
     public void validadorNumero (java.awt.event.KeyEvent evt){
         char variable = evt.getKeyChar();
        if (Character.isLetter(variable)){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingrese solo numeros ","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void validadorLetras (java.awt.event.KeyEvent evt){
         char variable = evt.getKeyChar();
        if (Character.isDigit(variable)){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingrese solo letras ","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void btnRegistrarIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarIngresoActionPerformed
        String numDep = jTextDep1.getText();
        String idUsuario = "";
        aux++;
        // System.out.println(c.validarUsuario(numDep));
        if (c.validarUsuario(numDep)) {
            //obtengo nombre por el numdep despues de consultar si esta en bd
            idUsuario = c.getUsuario(numDep);
            //System.out.println(idUsuario);
            JTextNombreResidente.setText(c.obtenerNombreUsuario(numDep));
            //  System.out.println(c.obtenerNombreUsuario(numDep));

        }
        if (numDep.equals("") || JTextFecha1.getText().equals("") || JTextFecha1.equals("")) {
            JOptionPane.showMessageDialog(null, "No se puede dejar campos vacios, por favor ingrese los datos");
        } else {
            String fecha = JTextFecha1.getText();
            String hora = JTextHora1.getText();

            String query = "INSERT INTO IngresoResidente (id_usuario, fecha, hora) VALUES ('" + idUsuario + "','" + fecha + "', '" + hora + "')";
            try {
                System.out.println(query);
                c.ejecutar(query);
                c.cargarTabla(modeloHistorial, jTableHistorial, nombreTablaHistorial, TitulosHistorial, idTablaHistorial);
                JOptionPane.showMessageDialog(null, "Ingresado correctamente");
                jTextDep1.setText("");
                JTextNombreResidente.setText("");
                JTextFecha1.setText("");
                JTextHora1.setText("");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
                JTextNombreResidente.setText("");
                JTextFecha1.setText("");
                JTextHora1.setText("");
            }
        }
    }//GEN-LAST:event_btnRegistrarIngresoActionPerformed

    private void btnRegistrarNotificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarNotificarActionPerformed
       String nombre = JTextNombreVistante.getText();
      String numDep = jTextDep2.getText();
        String idUsuario = "";

        // System.out.println(c.validarUsuario(numDep));
        if (c.validarUsuario(numDep)) {
            //obtengo nombre por el numdep despues de consultar si esta en bd
            idUsuario = c.getUsuario(numDep);
            //System.out.println(idUsuario);
            JTextNombreResidente.setText(c.obtenerNombreUsuario(numDep));
            //  System.out.println(c.obtenerNombreUsuario(numDep));

        }
      String motivo = JTextMotivoVisita.getText(); 
      String fecha = JTextFecha2.getText();
      String hora = JTextHora2.getText();
      
      // String query = "INSERT INTO Visitante (idVisitante, id_usuario, nombreVisitante, motivoVisita, fecha, hora, vehiculo, tipoUsuario) VALUES ('"+auxS+"', '"+idUsuario+"', '"+nombre+"', '"+motivo+"', '"+fecha+"', '"+hora+"', '"+VehiculoParqueadero+"', 'Visitante')";    
      if (proveedor){
          nombre = "Proveedor";
           v.registrarProveedor(nombre, motivo, fecha, hora, VehiculoParqueadero);
           
           JOptionPane.showMessageDialog(null, "Ingresado correctamente");
      }else{
           v.registrarVisita(idUsuario, nombre, motivo, fecha, hora, VehiculoParqueadero);
           JOptionPane.showMessageDialog(null, "Ingresado correctamente");
      }
      
      if (VehiculoParqueadero.equals("Si")){
          pv.cambiarEstadoParqueadero(parqueaderoID, estadoParqueadero);
      }
      
      //notificarPersonal(); GRUPO COMUNICACION GR6
	
    }//GEN-LAST:event_btnRegistrarNotificarActionPerformed

    private void btnNotificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNotificarActionPerformed
        String mensaje = jTXMensajeAlerta.getText();
        //Enviar mensajes a Residentes () GRUPO COMUNICACION GR6
    }//GEN-LAST:event_btnNotificarActionPerformed

    private void JCBVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCBVehiculoActionPerformed
       switch (JCBVehiculo.getSelectedIndex()) {
            case 0 :
                lbParqueadero.setVisible(true);
                VehiculoParqueadero = "Si";
                arrayInfo[0] =  JTextNombreVistante.getText();
                arrayInfo[1] = jTextDep2.getText();
                arrayInfo[2] = JTextNombreResidente2.getText();
                arrayInfo[3] =  JTextMotivoVisita.getText();
                arrayInfo[4] = JTextFecha2.getText();
                arrayInfo[5] = JTextHora2.getText();

                Parqueaderovisita pvv = new Parqueaderovisita(arrayInfo);
                pvv.setVisible(true);
                this.setVisible(false);

                //this.setVisible(false);
            break;
            case 1 :
                VehiculoParqueadero = "No";
                lbParqueadero.setVisible(false);
            break;
        }
    }//GEN-LAST:event_JCBVehiculoActionPerformed

    private void btnActualResidenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualResidenteActionPerformed
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
         String fecha = fechaHoraActual.format(formatoFecha);
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");
        String hora = fechaHoraActual.format(formatoHora);
        
        JTextFecha1.setText(fecha);
        JTextHora1.setText(hora);
    }//GEN-LAST:event_btnActualResidenteActionPerformed

    private void btnActualResidente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualResidente1ActionPerformed
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
         String fecha = fechaHoraActual.format(formatoFecha);
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");
        String hora = fechaHoraActual.format(formatoHora);
        
        JTextFecha2.setText(fecha);
        JTextHora2.setText(hora);
    }//GEN-LAST:event_btnActualResidente1ActionPerformed

    private void JTextFecha1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTextFecha1KeyReleased
        validadorNumero(evt);
        String texto = JTextFecha1.getText();

        String texAux = "";

        String regexDia = "^(0?[1-9]|[12][0-9]|3[01])$";
        String regexMes = "^(0?[1-9]|1[0-2])$";
        String regexAnio = "^\\d{0,4}$";

        switch (texto.length()) {
            case 4 : {
                Pattern patternAnio = Pattern.compile(regexAnio);
                Matcher matcherAnio = patternAnio.matcher(texto);
                if (matcherAnio.matches()) {
                    JTextFecha1.setText(texto + "-");
                    lbFecha1.setVisible(false);
                    leer(JTextFecha1, evt);

                } else {
                    lbFecha1.setVisible(true);
                }
            }
            case 7:{
                texAux = texto.substring(texto.length() - 2);
                Pattern patternMes = Pattern.compile(regexMes);
                Matcher matcherMes = patternMes.matcher(texAux);
                if (matcherMes.matches()) {
                    JTextFecha1.setText(texto + "-");
                    lbFecha1.setVisible(false);
                    leer(JTextFecha1, evt);
                } else {
                    lbFecha1.setVisible(true);
                }
            }
            case 10:{
               texAux = texto.substring(texto.length() - 2);
                Pattern patternDia = Pattern.compile(regexDia);
                Matcher matcherDia = patternDia.matcher(texAux);
                if (matcherDia.matches()) {
                     lbFecha1.setVisible(false);
                    JTextFecha1.setEditable(false);
                    leer(JTextFecha1, evt);
                } else {
                    lbFecha1.setVisible(true);
                }
            }
            case 11 :{
                JTextFecha1.setEditable(false);
                leer(JTextFecha1, evt);
            }
            default :
                lbFecha1.setVisible(true);
        }
    }//GEN-LAST:event_JTextFecha1KeyReleased
    public void leer(JTextField j, KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            j.setEditable(true);
        }
    }
    private void JTextHora1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTextHora1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTextHora1ActionPerformed

    private void JTextHora1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTextHora1KeyReleased
        validadorNumero(evt);
        String texto = JTextHora1.getText();

        String texAux = "";

        String regexHora = "^(?:[01][0-9]|2[0-3])$";
        String regexMin = "^([0-5][0-9])$";

        switch (texto.length()) {
            case 2 : {
                Pattern patternHora = Pattern.compile(regexHora);
                Matcher matcherHora = patternHora.matcher(texto);
                if (matcherHora.matches()) {
                    JTextHora1.setText(texto + ":");
                    lbFecha1.setVisible(false);
                    leer(JTextHora1, evt);
                } else {
                    lbHora1.setVisible(true);
                }
            }
            case 5 : {
                texAux = texto.substring(texto.length() - 2);
                Pattern patternMin = Pattern.compile(regexMin);
                Matcher matcherMin = patternMin.matcher(texAux);
                if (matcherMin.matches()) {
                    lbHora1.setVisible(false);
                    leer(JTextHora1, evt);
                } else {
                    lbHora1.setVisible(true);
                }
            }
            case 6 : {
                JTextHora1.setEditable(false);
                leer(JTextHora1, evt);
            }
            default:
                lbHora1.setVisible(true);
        }
    }//GEN-LAST:event_JTextHora1KeyReleased

    private void JTextHora2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTextHora2KeyReleased
        validadorNumero(evt);
        String texto = JTextHora2.getText();

        String texAux = "";

        String regexHora = "^(?:[01][0-9]|2[0-3])$";
        String regexMin = "^([0-5][0-9])$";

        switch (texto.length()) {
            case 2 : {
                Pattern patternHora = Pattern.compile(regexHora);
                Matcher matcherHora = patternHora.matcher(texto);
                if (matcherHora.matches()) {
                    JTextHora2.setText(texto + ":");
                    lbFecha2.setVisible(false);
                    leer(JTextHora2, evt);
                } else {
                    lbHora2.setVisible(true);
                }
            }
            case 5 : {
                texAux = texto.substring(texto.length() - 2);
                Pattern patternMin = Pattern.compile(regexMin);
                Matcher matcherMin = patternMin.matcher(texAux);
                if (matcherMin.matches()) {
                    lbHora2.setVisible(false);
                    leer(JTextHora2, evt);
                } else {
                    lbHora2.setVisible(true);
                }
            }
            case 6 : {
                JTextHora2.setEditable(false);
                leer(JTextHora2, evt);
            }
            default :
                lbHora2.setVisible(true);
        }
    }//GEN-LAST:event_JTextHora2KeyReleased

    private void JTextFecha2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTextFecha2KeyReleased
         validadorNumero(evt);
        String texto = JTextFecha2.getText();

        String texAux = "";

        String regexDia = "^(0?[1-9]|[12][0-9]|3[01])$";
        String regexMes = "^(0?[1-9]|1[0-2])$";
        String regexAnio = "^\\d{0,4}$";

        switch (texto.length()) {
            case 4 :{
                Pattern patternAnio = Pattern.compile(regexAnio);
                Matcher matcherAnio = patternAnio.matcher(texto);
                if (matcherAnio.matches()) {
                    JTextFecha2.setText(texto + "-");
                    lbFecha2.setVisible(false);
                    leer(JTextFecha2, evt);

                } else {
                    lbFecha2.setVisible(true);
                }
            }
            case 7: {
                texAux = texto.substring(texto.length() - 2);
                Pattern patternMes = Pattern.compile(regexMes);
                Matcher matcherMes = patternMes.matcher(texAux);
                if (matcherMes.matches()) {
                    JTextFecha2.setText(texto + "-");
                    lbFecha2.setVisible(false);
                    leer(JTextFecha2, evt);
                } else {
                    lbFecha2.setVisible(true);
                }
            }
            case 10 : {
               texAux = texto.substring(texto.length() - 2);
                Pattern patternDia = Pattern.compile(regexDia);
                Matcher matcherDia = patternDia.matcher(texAux);
                if (matcherDia.matches()) {
                     lbFecha2.setVisible(false);
                    JTextFecha2.setEditable(false);
                    leer(JTextFecha2, evt);
                } else {
                    lbFecha2.setVisible(true);
                }
            }
            case 11 :{
                JTextFecha2.setEditable(false);
                leer(JTextFecha2, evt);
            }
            default:
                lbFecha2.setVisible(true);
        }
    }//GEN-LAST:event_JTextFecha2KeyReleased

    private void JTextNombreResidenteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTextNombreResidenteKeyReleased
       
    }//GEN-LAST:event_JTextNombreResidenteKeyReleased

    private void JTextNombreVistanteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTextNombreVistanteKeyReleased
         validadorLetras(evt);
    }//GEN-LAST:event_JTextNombreVistanteKeyReleased

    private void JTextNombreResidente2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTextNombreResidente2KeyReleased
         validadorLetras(evt); 
    }//GEN-LAST:event_JTextNombreResidente2KeyReleased

    private void jTextDep1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextDep1KeyReleased
         String numdep = jTextDep1.getText();
        
        JTextNombreResidente.setText(c.obtenerNombreUsuario(numdep));
        
        String nombre = JTextNombreResidente.getText();
        if(nombre.equals("error")||nombre.equals("")){
            lbResidente1.setVisible(true);
        }else{
             lbResidente1.setVisible(false);
        }
    }//GEN-LAST:event_jTextDep1KeyReleased

    private void jTextDep2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextDep2KeyReleased
        String numdep = jTextDep2.getText();
        
        JTextNombreResidente2.setText(c.obtenerNombreUsuario(numdep));
        
        String nombre = JTextNombreResidente2.getText();
        if(nombre.equals("error")||nombre.equals("")){
            lbResidente2.setVisible(true);
        }else{
             lbResidente2.setVisible(false);
        }
    }//GEN-LAST:event_jTextDep2KeyReleased

    private void jTextDep1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextDep1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextDep1KeyTyped

    private void jcheckProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcheckProveedorActionPerformed

        if (jcheckProveedor.isSelected()) {
            proveedor = true;
            JTextNombreVistante.setEditable(false);
            jTextDep2.setEditable(false);
        }else{
            proveedor = false;
            JTextNombreVistante.setEditable(true);
            jTextDep2.setEditable(true);
        }
    }//GEN-LAST:event_jcheckProveedorActionPerformed

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
            java.util.logging.Logger.getLogger(CheckIn_Nw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CheckIn_Nw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CheckIn_Nw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CheckIn_Nw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CheckIn_Nw().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JCBVehiculo;
    private javax.swing.JTextField JTextFecha1;
    private javax.swing.JTextField JTextFecha2;
    private javax.swing.JTextField JTextHora1;
    private javax.swing.JTextField JTextHora2;
    private javax.swing.JTextArea JTextMotivoVisita;
    private javax.swing.JTextField JTextNombreResidente;
    private javax.swing.JTextField JTextNombreResidente2;
    private javax.swing.JTextField JTextNombreVistante;
    private javax.swing.JButton btnActualResidente;
    private javax.swing.JButton btnActualResidente1;
    private javax.swing.JButton btnNotificar;
    private javax.swing.JButton btnRegistrarIngreso;
    private javax.swing.JButton btnRegistrarNotificar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea jTXMensajeAlerta;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableHistorial;
    private javax.swing.JTable jTableVisitasP;
    private javax.swing.JTextField jTextDep1;
    private javax.swing.JTextField jTextDep2;
    private javax.swing.JCheckBox jcheckProveedor;
    private javax.swing.JLabel labelfecha;
    private javax.swing.JLabel lbFecha1;
    private javax.swing.JLabel lbFecha2;
    private javax.swing.JLabel lbHora1;
    private javax.swing.JLabel lbHora2;
    private javax.swing.JLabel lbParqueadero;
    private javax.swing.JLabel lbResidente1;
    private javax.swing.JLabel lbResidente2;
    // End of variables declaration//GEN-END:variables
}
