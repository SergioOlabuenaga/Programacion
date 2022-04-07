package Vista;

import Controlador.Main;

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
    private JMenuItem mSalir;
    private JButton bSalir;


    public Principal() {
        bInsertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.mostrarVentanaInsertar();
            }
        });

        bSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.dispose();
            }
        });
    }

    public void validarNombre(String n) throws Exception{
        if (n.isEmpty())
            throw new Exception("El nombre es un campo obligatorio");
    }

    public JPanel getpPrincipal(){
        return pPrincipal;
    }

}


