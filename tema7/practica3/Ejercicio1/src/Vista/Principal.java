package Vista;

import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principal {
    private JPanel pPrincipal;
    private JButton bEntrar;
    private JButton bImagen;
    private JLabel lEntidad;
    private JPanel pInicio;

    public Principal() {
        bEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.cambio();
            }
        });
    }

    public JPanel getpPrincipal() {
        return pPrincipal;
    }
}
