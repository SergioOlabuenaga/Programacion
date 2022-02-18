package Vista;

import javax.swing.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class InicioSesion {
    private JPanel pPrincipal;
    private JTextField tfNIF;
    private JPasswordField passwordField1;
    private JLabel lClave;
    private JLabel lNIF;
    private JButton bNum1;
    private JButton bNum2;
    private JButton bNum3;
    private JButton bNum4;
    private JButton bNum5;
    private JButton bNum6;
    private JButton bNum7;
    private JButton bNum8;
    private JButton bNum9;
    private JButton bNum0;
    private JButton bEntrar;

    public InicioSesion() {
        tfNIF.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                for(int i = 0; i < tfNIF.getText().length(); i++) {
                    if(Character.istfNIF.getText().charAt(i)) {

                    }
                }
            }
        });
    }

    public JPanel getpPrincipal(){
        return pPrincipal;
    }

}
