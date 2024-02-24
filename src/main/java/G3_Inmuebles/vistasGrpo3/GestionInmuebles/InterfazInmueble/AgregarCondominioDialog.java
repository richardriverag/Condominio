package G3_Inmuebles.vistasGrpo3.GestionInmuebles.InterfazInmueble;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AgregarCondominioDialog extends JDialog {
    
    private JTextField txtID;
    private JTextField txtDimension;
    private JTextField txtNumHabitaciones;
    private JTextField txtServicios;
    private JTextField txtNormas;
    
    private JButton btnGuardar;
    
    private DefaultTableModel tablaModelo;
    
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=Condominio;trustServerCertificate=true";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";
    
    
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
        String dimension = txtDimension.getText();
        String numHabitaciones = txtNumHabitaciones.getText();
        String servicios = txtServicios.getText();
        String normas = txtNormas.getText();
        
        // Llamar al método para guardar en la base de datos
        boolean exito = guardarEnBaseDeDatos(dimension, numHabitaciones, servicios, normas);
        
        // Si se guardó correctamente, actualizar la tabla y cerrar la ventana
        if (exito) {
            Object[] rowData = {dimension, numHabitaciones, servicios, normas};
            tablaModelo.addRow(rowData);
            dispose();
        }
    }
    
private boolean guardarEnBaseDeDatos(String dimension, String numHabitaciones, String servicios, String normas) {
    String query = "INSERT INTO CATALOGO_CONDOMINIOS (Dimension, Num_Habitaciones, Servicios, Normas) VALUES (?, ?, ?, ?)";
    try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
         PreparedStatement statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
        statement.setString(1, dimension);
        statement.setString(2, numHabitaciones);
        statement.setString(3, servicios);
        statement.setString(4, normas);

        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    // Obtener el ID generado automáticamente
                    int generatedId = generatedKeys.getInt(1);
                    System.out.println("ID generado para el nuevo condominio: " + generatedId);
                    // Agregar una nueva fila a la tabla de Java con el ID generado
                    Object[] rowData = {generatedId, dimension, numHabitaciones, servicios, normas};
                    tablaModelo.addRow(rowData);
                    return true;
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}
}