package G3_Inmuebles.vistasGrpo3.GestionInmuebles.InterfazInmueble;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class VentanaEditarCondominio extends javax.swing.JFrame {
    // Define los componentes necesarios para la ventana de edición
    private javax.swing.JTextField textFieldID;
    private javax.swing.JTextField textFieldDimension;
    private javax.swing.JTextField textFieldNumHabitaciones;
    private javax.swing.JTextField textFieldServicios;
    private javax.swing.JTextField textFieldNormas;
    private javax.swing.JButton botonGuardar;
    private JTable tablaCatalogo;

    public VentanaEditarCondominio(JTable tablaCatalogo) {
        this.tablaCatalogo = tablaCatalogo;
        initComponents();
        cargarDatos(); // Cargar los datos de la fila seleccionada en la tabla
    }

    private void initComponents() {
        // Define la estructura de la ventana de edición
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        textFieldID = new javax.swing.JTextField();
        textFieldDimension = new javax.swing.JTextField();
        textFieldNumHabitaciones = new javax.swing.JTextField();
        textFieldServicios = new javax.swing.JTextField();
        textFieldNormas = new javax.swing.JTextField();
        botonGuardar = new javax.swing.JButton();
    }
    protected void cargarDatos() {
    // Obtener el índice de la fila seleccionada en la tabla
    int filaSeleccionada = tablaCatalogo.getSelectedRow();

    // Verificar si se ha seleccionado una fila válida
    if (filaSeleccionada != -1) {
        // Obtener el modelo de la tabla
        DefaultTableModel modelo = (DefaultTableModel) tablaCatalogo.getModel();

        // Obtener los datos de la fila seleccionada
        String id = modelo.getValueAt(filaSeleccionada, 0).toString();
        String dimension = modelo.getValueAt(filaSeleccionada, 1).toString();
        String numHabitaciones = modelo.getValueAt(filaSeleccionada, 2).toString();
        String servicios = modelo.getValueAt(filaSeleccionada, 3).toString();
        String normas = modelo.getValueAt(filaSeleccionada, 4).toString();

        // Establecer los datos en los campos de texto de la ventana de edición
        textFieldID.setText(id);
        textFieldDimension.setText(dimension);
        textFieldNumHabitaciones.setText(numHabitaciones);
        textFieldServicios.setText(servicios);
        textFieldNormas.setText(normas);
    } else {
        // Si no se ha seleccionado ninguna fila, mostrar un mensaje de error
        JOptionPane.showMessageDialog(this, "No se ha seleccionado ninguna fila.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    public String[] getDatosEditados() {
        String[] datosEditados = new String[5];
        datosEditados[0] = textFieldID.getText();
        datosEditados[1] = textFieldDimension.getText();
        datosEditados[2] = textFieldNumHabitaciones.getText();
        datosEditados[3] = textFieldServicios.getText();
        datosEditados[4] = textFieldNormas.getText();
        return datosEditados;
    }

    // Método para asignar los datos a los campos de edición
    public void setDatosEdicion(String[] datos) {
        textFieldID.setText(datos[0]);
        textFieldDimension.setText(datos[1]);
        textFieldNumHabitaciones.setText(datos[2]);
        textFieldServicios.setText(datos[3]);
        textFieldNormas.setText(datos[4]);
    }
}