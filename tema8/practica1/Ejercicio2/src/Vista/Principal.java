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
        bCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    String nombre = JOptionPane.showInputDialog(null, "Teclea el nombre del evento que quieres cancelar");
                    validarNombre(nombre);
                    String datos = Main.cancelarEvento(nombre);
                    int respuesta = JOptionPane.showConfirmDialog(null, "¿Estas seguro de borrar de forma definitiva el evento " + datos);
                    if (respuesta == 0) {
                        Main.borrarEvento();
                        JOptionPane.showMessageDialog(null, "Evento cancelado");
                    }
                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
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


