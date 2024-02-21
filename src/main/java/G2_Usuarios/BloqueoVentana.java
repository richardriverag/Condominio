/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package G2_Usuarios;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author JoisH
 */
public class BloqueoVentana extends JDialog {

    private int segundosRestantes;
    private Timer timer;

    public BloqueoVentana(JFrame parent) {
        super(parent, "Ha excedido el número de intentos permitidos", true);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setSize(500, 150);
        setResizable(false);
        setLocationRelativeTo(parent);

        segundosRestantes = 60; // 60 segundos (1 minuto)

        JLabel label = new JLabel("Inicio de sesión fallido. Intente nuevamente en " + segundosRestantes + " segundos.", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.PLAIN, 18));
        add(label, BorderLayout.CENTER);

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                segundosRestantes--;
                label.setText("Inicio de sesión fallido. Intente nuevamente en " + segundosRestantes + " segundos.");
                if (segundosRestantes <= 0) {
                    timer.stop();
                    dispose(); // Cierra la ventana de bloqueo
                    // Aquí puedes habilitar los campos de entrada y el botón de inicio de sesión
                    parent.setEnabled(true);
                }
            }
        });
        timer.start();
    }
}