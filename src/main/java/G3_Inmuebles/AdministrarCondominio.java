package G3_Inmuebles;

import javax.swing.*;
import java.awt.*;

public class AdministrarCondominio {
    private JPanel panel1;
    private JTable table1;
    private JButton button5;
    private JButton button6;
    private JButton button1;

    JFrame frame;

    public AdministrarCondominio() {
        this.panel1 = panel1;
        frame = new JFrame();
        frame.pack();
        frame.setVisible(true);
    }

    public void crearFrame2() {
        frame.setContentPane(panel1);
        frame.setPreferredSize(new Dimension(1080, 720));
        frame.pack();
        frame.setVisible(true);
    }



}
