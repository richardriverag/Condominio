package G3_Inmuebles.vistasGrpo3.GestionInmuebles.InterfazInmueble;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AgregarCondominioDialog extends JDialog {
    
    private JTextField txtID;
    private JTextField txtDimension;
    private JTextField txtNumHabitaciones;
    private JTextField txtServicios;
    private JTextField txtNormas;
    
    private JButton btnGuardar;
    
    private DefaultTableModel tablaModelo;
    
    public AgregarCondominioDialog(JFrame parent, boolean modal, DefaultTableModel tablaModelo) {
        super(parent, modal);
        this.tablaModelo = tablaModelo;
        initComponents();
    }
    
    private void initComponents() {
        setTitle("Agregar Condominio");
        setSize(400, 300);
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Cerrar solo la ventana al cerrarla
        
        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));
        
        JLabel lblID = new JLabel("ID:");
        txtID = new JTextField();
        panel.add(lblID);
        panel.add(txtID);
        
        JLabel lblDimension = new JLabel("Dimensión:");
        txtDimension = new JTextField();
        panel.add(lblDimension);
        panel.add(txtDimension);
        
        JLabel lblNumHabitaciones = new JLabel("Número de Habitaciones:");
        txtNumHabitaciones = new JTextField();
        panel.add(lblNumHabitaciones);
        panel.add(txtNumHabitaciones);
        
        JLabel lblServicios = new JLabel("Servicios:");
        txtServicios = new JTextField();
        panel.add(lblServicios);
        panel.add(txtServicios);
        
        JLabel lblNormas = new JLabel("Normas:");
        txtNormas = new JTextField();
        panel.add(lblNormas);
        panel.add(txtNormas);
        
        btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener((ActionEvent e) -> {
            guardarCondominio();
        });
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
        
        // Llamar al método para guardar en la base de datos
        boolean exito = guardarEnBaseDeDatos(id, dimension, numHabitaciones, servicios, normas);
        
        // Si se guardó correctamente, actualizar la tabla y cerrar la ventana
        if (exito) {
            Object[] rowData = {id, dimension, numHabitaciones, servicios, normas};
            tablaModelo.addRow(rowData);
            dispose();
        }
    }
    
    private boolean guardarEnBaseDeDatos(String id, String dimension, String numHabitaciones, String servicios, String normas) {
        // Aquí iría el código para guardar en la base de datos
        // Por simplicidad, solo imprimiremos los datos en la consola
        System.out.println("ID: " + id);
        System.out.println("Dimensión: " + dimension);
        System.out.println("Número de Habitaciones: " + numHabitaciones);
        System.out.println("Servicios: " + servicios);
        System.out.println("Normas: " + normas);
        
        // Supongamos que la operación fue exitosa
        return true;
    }
}