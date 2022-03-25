package Vista;

import com.company.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principal {
    private JPanel pPrincipal;
    private JMenu mAcontecimientos;
    private JMenuItem mInsertar;
    private JButton bInsertar;
    private JButton bCancelar;
    private JMenuItem mCancelar;
    private JMenuItem mModificar;
    private JButton bModificar;
    private JMenuItem mSalir;
    private JButton bSalir;


    public Principal() {
        bInsertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.mostrarVentanaInsertar();
            }
        });
    }

    public JPanel getpPrincipal(){
        return pPrincipal;
    }

}


