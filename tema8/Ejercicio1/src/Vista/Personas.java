package Vista;

import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Personas extends JDialog {
    private JPanel contentPane;
    private JButton bSalir;
    private JButton bSiguiente;
    private JButton bAnterior;
    private JButton bAceptar;
    private JTextField tfNombre;
    private JTextField tfEdad;
    private JTextField tfProfesion;
    private JTextField tfTelefono;
    private JPanel BG2;
    private JPanel BG1;
    private JPanel pPrincipal;

    private int opcion;

    public Personas(int o) {
        opcion = o;
        if (opcion != 3) {
            visualizarBG1(false);
            visualizarBG2(true);
        }
        else
        {
            visualizarBG1(true);
            visualizarBG2(false);

        }

        bSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    Main.getSiguiente();
                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });

        bAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (opcion == 1) {
                        // alta de persona
                        if (validarDatos())
                            Main.getDatos(tfNombre.getText(), tfEdad.getText(), tfProfesion.getText(), tfTelefono.getText());
                    }
                    else
                        Main.volverMenu();

                }
                catch(Exception ex)
                {
                    if (opcion == 1)
                        JOptionPane.showMessageDialog(null, "Problemas insertando \n" + ex.getMessage());
                    else
                        JOptionPane.showMessageDialog(null, "Problemas consultado los datos de una persona \n" + ex.getMessage());
                }
            }
        });
        bAnterior.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    Main.getAnterior();
                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
        bSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.volverMenu();
            }
        });
        tfNombre.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                if (opcion == 2)
                {
                    try {
                        validarNombre();
                        Main.getNombre(tfNombre.getText());
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }
            }
        });
    }

    public boolean validarDatos()
    {
        try
        {
            validarNombre(); // saco esta validación para reutilizarla en el caso de consulta

            if (tfEdad.getText().isEmpty())
                throw new Exception(" La edad es un dato obligatorio");
            if (tfProfesion.getText().isEmpty())
                throw new Exception(" La profesión es un dato obligatorio");
            if (tfTelefono.getText().isEmpty())
                throw new Exception(" El teléfono es un dato obligatorio");

            Pattern patron = Pattern.compile("^[0-9]{1,3}$");
            Matcher mat = patron.matcher(tfEdad.getText());
            if (!mat.matches())
                throw new Exception(" La edad no tiene un formato adecuado");

            patron = Pattern.compile("^[A-Z][a-z ]*$");
            mat = patron.matcher(tfProfesion.getText());
            if (!mat.matches())
                throw new Exception(" La profesión no tiene un formato adecuado");

            patron = Pattern.compile("^[6789][0-9]{8}$");
            mat = patron.matcher(tfTelefono.getText());
            if (!mat.matches())
                throw new Exception(" El teléfono no tiene un formato adecuado");

            return true;
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Problemas validando \n"+ e.getMessage());
            return false;
        }
    }

    public void validarNombre() throws Exception{
        if (tfNombre.getText().isEmpty())
            throw new Exception(" El nombre es un dato obligatorio");
        Pattern patron = Pattern.compile("^[A-Z][a-z ]{2,}([A-Z][a-z ]{2,})*$");
        Matcher mat = patron.matcher(tfNombre.getText());
        if (!mat.matches())
            throw new Exception(" El nombre no tiene un formato adecuado");
    }

    public JPanel getpPrincipal() {
        return pPrincipal;
    }

    public void setDatosPersona(Integer e,String p,String t)
    {
        tfEdad.setText(e.toString());
        tfProfesion.setText(p);
        tfTelefono.setText(t);
        // Deshabilitar para que no modifique??
        bAceptar.requestFocus();

    }

    public void setDatosPersona(String n,Integer e,String p,String t)
    {
        tfNombre.setText(n);
        tfEdad.setText(e.toString());
        tfProfesion.setText(p);
        tfTelefono.setText(t);
        // Deshabilitar para que no modifique??
        bSiguiente.requestFocus();
    }

    public void visualizarBG1(boolean b)
    {
        BG1.setVisible(b);
    }

    public void visualizarBG2(boolean b)
    {
        BG2.setVisible(b);
    }
}
