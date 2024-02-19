package G3_Inmuebles.vistasGrpo3.GestionInmuebles.InterfazInmueble;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CatalogoCondominios extends javax.swing.JPanel {
    private javax.swing.JTable tablaCatalogo;
    private javax.swing.JButton botonAgregar;
    private javax.swing.JButton botonEditar;
    private javax.swing.JButton botonEliminar;

    public CatalogoCondominios() {
        initComponents();
        initBotones();
        initTablaListener();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        // Inicializar la tabla del catálogo de condominios
        tablaCatalogo = new JTable(new DefaultTableModel(
                new Object[][]{},
                new String[]{"ID", "Dimension", "NumHabitaciones", "Servicios", "Normas"}
        ));
        JScrollPane scrollPane = new JScrollPane(tablaCatalogo);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void initBotones() {
        botonAgregar = new JButton("Agregar");
        botonEditar = new JButton("Editar");
        botonEliminar = new JButton("Eliminar");

        botonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirVentanaAgregarCondominio();
            }
        });

        botonEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirVentanaEditarCondominio();
            }
        });

        botonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarCondominioSeleccionado();
            }
        });

        JPanel panelBotones = new JPanel();
        panelBotones.add(botonAgregar);
        panelBotones.add(botonEditar);
        panelBotones.add(botonEliminar);
        add(panelBotones, BorderLayout.SOUTH);
    }

    private void initTablaListener() {
        tablaCatalogo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    JTable target = (JTable) e.getSource();
                    int row = target.getSelectedRow();
                   
                }
            }
        });
    }

    private void abrirVentanaAgregarCondominio() {
        // Crear una nueva instancia de la ventana de agregar condominio
        AgregarCondominioDialog ventanaAgregar = new AgregarCondominioDialog(null, true);
        
        // Hacer visible la ventana de agregar condominio
        ventanaAgregar.setVisible(true);
    }
    
    private void abrirVentanaEditarCondominio(){
    VentanaEditarCondominio ventanaEditar = new VentanaEditarCondominio(tablaCatalogo);
    
    // Cargar los datos de la fila seleccionada en la tabla
    ventanaEditar.cargarDatos();
    
    // Hacer visible la ventana de editar condominio
    ventanaEditar.setVisible(true);
    }
    
    
    private void eliminarCondominioSeleccionado() {
        int filaSeleccionada = tablaCatalogo.getSelectedRow();
        if (filaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) tablaCatalogo.getModel();
            modelo.removeRow(filaSeleccionada);
        } else {
            JOptionPane.showMessageDialog(this, "No se ha seleccionado ninguna fila.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}