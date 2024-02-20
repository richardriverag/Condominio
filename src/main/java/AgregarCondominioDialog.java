import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgregarCondominioDialog extends JDialog {
    private JTextField idField;
    private JTextField dimensionField;
    private JTextField numHabitacionesField;
    private JTextField serviciosField;
    private JTextField normasField;
    private JButton agregarButton;

    public AgregarCondominioDialog(JFrame parent, boolean modal) {
        super(parent, "Agregar Condominio", true);
        initComponents();
    }

    private void initComponents() {
        // Configuración de la ventana emergente
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Creación de campos de entrada de texto
        idField = new JTextField();
        dimensionField = new JTextField();
        numHabitacionesField = new JTextField();
        serviciosField = new JTextField();
        normasField = new JTextField();

        // Creación del botón para agregar
        agregarButton = new JButton("Agregar");
        agregarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                agregarCondominio();
            }
        });

        // Configuración del diseño de la ventana
        JPanel panelCampos = new JPanel(new GridLayout(5, 2));
        panelCampos.add(new JLabel("ID:"));
        panelCampos.add(idField);
        panelCampos.add(new JLabel("Dimensión:"));
        panelCampos.add(dimensionField);
        panelCampos.add(new JLabel("NumHabitaciones:"));
        panelCampos.add(numHabitacionesField);
        panelCampos.add(new JLabel("Servicios:"));
        panelCampos.add(serviciosField);
        panelCampos.add(new JLabel("Normas:"));
        panelCampos.add(normasField);

        JPanel panelBoton = new JPanel();
        panelBoton.add(agregarButton);

        add(panelCampos, BorderLayout.CENTER);
        add(panelBoton, BorderLayout.SOUTH);

        pack(); // Ajusta automáticamente el tamaño de la ventana
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
    }

    private void agregarCondominio() {
        // Aquí puedes implementar la lógica para agregar el condominio a la base de datos
        // Puedes obtener los valores de los campos de texto con idField.getText(), dimensionField.getText(), etc.
        // Una vez agregado, puedes cerrar la ventana con dispose()
        dispose();
    }
}