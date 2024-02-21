/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package G3_Inmuebles.vistasGrpo3.GestionInmuebles.InterfazInmueble;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

public class EditarCondominioDialog extends JDialog {

    private JTextField txtID;
    private JTextField txtDimension;
    private JTextField txtNumHabitaciones;
    private JTextField txtServicios;
    private JTextField txtNormas;
    private JButton btnGuardar;
    private JTable tabla;

    public EditarCondominioDialog(JFrame parent, boolean modal, String id, 
            String dimension, String numHabitaciones, 
            String servicios, String normas, JTable tabla) {
        super(parent, modal);
        initComponents();
        // Cargar los datos del condominio en los campos de edición
        txtID.setText(id);
        txtDimension.setText(dimension);
        txtNumHabitaciones.setText(numHabitaciones);
        txtServicios.setText(servicios);
        txtNormas.setText(normas);
        btnGuardar.addActionListener((ActionEvent e) -> {
            guardarCondominio();
        });
        this.tabla = tabla;
    }

    private void initComponents() {
setTitle("Editar Condominio");
        setSize(400, 300);
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Cerrar solo la ventana al cerrarla

        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));

        // Crear los campos de texto y agregarlos al panel
        txtID = new JTextField();
        txtDimension = new JTextField();
        txtNumHabitaciones = new JTextField();
        txtServicios = new JTextField();
        txtNormas = new JTextField();
        
        // Agregar etiquetas y campos de texto al panel
        panel.add(new JLabel("ID:"));
        panel.add(txtID);
        panel.add(new JLabel("Dimensión:"));
        panel.add(txtDimension);
        panel.add(new JLabel("Número de Habitaciones:"));
        panel.add(txtNumHabitaciones);
        panel.add(new JLabel("Servicios:"));
        panel.add(txtServicios);
        panel.add(new JLabel("Normas:"));
        panel.add(txtNormas);

        btnGuardar = new JButton("Guardar");
        panel.add(btnGuardar);

        getContentPane().add(panel, BorderLayout.CENTER);
    }

    private void guardarCondominio() {
        // Obtener los valores de los campos
        String id = txtID.getText();
        String dimension = txtDimension.getText();
        String numHabitaciones = txtNumHabitaciones.getText();
        String servicios = txtServicios.getText();
        String normas = txtNormas.getText();

        // Aquí puedes realizar la lógica para guardar los cambios en la base de datos
        

        // Cerrar el diálogo
           int filaSeleccionada = tabla.getSelectedRow();
        if (filaSeleccionada != -1) {
        tabla.getModel().setValueAt(id, filaSeleccionada, 0);
        tabla.getModel().setValueAt(dimension, filaSeleccionada, 1);
        tabla.getModel().setValueAt(numHabitaciones, filaSeleccionada, 2);
        tabla.getModel().setValueAt(servicios, filaSeleccionada, 3);
        tabla.getModel().setValueAt(normas, filaSeleccionada, 4);

        // Notificar a la tabla que los datos han cambiado
        ((DefaultTableModel) tabla.getModel()).fireTableDataChanged();
    }

    // Cerrar el diálogo
        dispose();
    }
}
