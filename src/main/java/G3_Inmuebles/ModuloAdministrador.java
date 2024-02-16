package G3_Inmuebles;

import javax.swing.*;
import java.awt.*;


public class ModuloAdministrador {
    private JPanel panel1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;

    JFrame frame;




    public ModuloAdministrador() {
        this.panel1 = panel1;
        AdministrarCondominio ac = new AdministrarCondominio();
        frame = new JFrame();
        frame.pack();
        frame.setVisible(true);
        button1.addActionListener(e -> {
            ac.crearFrame2();
            });


    }

    public void crearFrame() {
        frame.setContentPane(panel1);
        frame.setPreferredSize(new Dimension(1080, 720));
        frame.pack();
        frame.setVisible(true);
    }




}
