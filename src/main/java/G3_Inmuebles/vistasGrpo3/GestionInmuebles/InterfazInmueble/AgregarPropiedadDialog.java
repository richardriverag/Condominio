/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package G3_Inmuebles.vistasGrpo3.GestionInmuebles.InterfazInmueble;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class AgregarPropiedadDialog extends JDialog {
    
    private JTextField txtCedula;
    private JTextField txtNombre;
    private JTextField txtBloque;
    private JTextField txtEdificio;
    private JTextField txtPiso;
    private JTextField txtDepartamento;
    private JTextField txtObservaciones;
    
    private JButton btnGuardar;
    
    private DefaultTableModel tablaModelo;
    
    public AgregarPropiedadDialog(JFrame parent, boolean modal, DefaultTableModel tablaModelo) {
        super(parent, modal);
        this.tablaModelo = tablaModelo;
        initComponents();
    }
    
    private void initComponents() {
        setTitle("Agregar Propiedad");
        setSize(400, 350);
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Cerrar solo la ventana al cerrarla
        
        JPanel panel = new JPanel(new GridLayout(8, 2, 10, 10));
        
        JLabel lblCedula = new JLabel("Cédula:");
        txtCedula = new JTextField();
        panel.add(lblCedula);
        panel.add(txtCedula);
        
        JLabel lblNombre = new JLabel("Nombre:");
        txtNombre = new JTextField();
        panel.add(lblNombre);
        panel.add(txtNombre);
        
        JLabel lblBloque = new JLabel("Bloque:");
        txtBloque = new JTextField();
        panel.add(lblBloque);
        panel.add(txtBloque);
        
        JLabel lblEdificio = new JLabel("Edificio:");
        txtEdificio = new JTextField();
        panel.add(lblEdificio);
        panel.add(txtEdificio);
        
        JLabel lblPiso = new JLabel("Piso:");
        txtPiso = new JTextField();
        panel.add(lblPiso);
        panel.add(txtPiso);
        
        JLabel lblDepartamento = new JLabel("Departamento:");
        txtDepartamento = new JTextField();
        panel.add(lblDepartamento);
        panel.add(txtDepartamento);
        
        JLabel lblObservaciones = new JLabel("Observaciones:");
        txtObservaciones = new JTextField();
        panel.add(lblObservaciones);
        panel.add(txtObservaciones);
        
        btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener((ActionEvent e) -> {
            guardarPropiedad();
        });
        panel.add(btnGuardar);
        
        getContentPane().add(panel, BorderLayout.CENTER);
    }
    
    private void guardarPropiedad() {
        // Obtener los valores de los campos
        String cedula = txtCedula.getText();
        String nombre = txtNombre.getText();
        String bloque = txtBloque.getText();
        String edificio = txtEdificio.getText();
        String piso = txtPiso.getText();
        String departamento = txtDepartamento.getText();
        String observaciones = txtObservaciones.getText();
        
        // Llamar al método para guardar en la base de datos
        boolean exito = guardarEnBaseDeDatos(cedula, nombre, bloque, edificio, piso, departamento, observaciones);
        
        // Si se guardó correctamente, actualizar la tabla y cerrar la ventana
        if (exito) {
            Object[] rowData = {cedula, nombre, bloque, edificio, piso, departamento, observaciones};
            tablaModelo.addRow(rowData);
            dispose();
        }
    }
    
    private boolean guardarEnBaseDeDatos(String cedula, String nombre, String bloque, String edificio, String piso, String departamento, String observaciones) {
        // Aquí iría el código para guardar en la base de datos
        System.out.println("Cédula: " + cedula);
        System.out.println("Nombre: " + nombre);
        System.out.println("Bloque: " + bloque);
        System.out.println("Edificio: " + edificio);
        System.out.println("Piso: " + piso);
        System.out.println("Departamento: " + departamento);
        System.out.println("Observaciones: " + observaciones);
        
        // Supongamos que la operación fue exitosa
        return true;
    }
}