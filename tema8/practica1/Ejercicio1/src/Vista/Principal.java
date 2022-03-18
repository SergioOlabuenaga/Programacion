package Vista;

import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principal {
    private JPanel panel1;
    private JTextField tfOpcion;
    private JPanel pPrincipal;


    public Principal() {
        tfOpcion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    validarOpcion();
                    // Enviar al main la opción elegida para que sepa que hacer. Si algo está mal hemos ido a un catch
                    Main.getOpcion(Integer.parseInt(tfOpcion.getText()));
                    tfOpcion.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "La opción es un dato numérico");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }

    public void validarOpcion() throws Exception
    {
        int o = Integer.parseInt(tfOpcion.getText());
        if (o < 1 || o > 4)
            throw new Exception ("Opción no valida (1 - 4)");
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Principal");
        frame.setContentPane(new Principal().pPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel getpPrincipal() {
        return pPrincipal;
    }
}

