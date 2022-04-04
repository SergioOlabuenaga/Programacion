package Vista;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class vInsertar extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField tfNombre;
    private JTextField tfLugar;
    private JTextField tfFecha;
    private JTextField tfHoraInicio;
    private JTextField tfAforo;
    private JTextField tfHoraFin;

    public vInsertar() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        try{
            validarNombre();
            validarLugar();
            validarFecha();
            validarHoras();
            validarAforo();
            Main.getDatosEvento(tfNombre.getText(),tfLugar.getText(),Fecha,HoraInicio,HoraFin,aforo);
            dispose();
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }


    }

    private LocalDate Fecha;
    private LocalTime HoraInicio;
    private LocalTime HoraFin;
    private int aforo;

    private void validarNombre() throws Exception {
        if (tfNombre.getText().isEmpty())
            throw new Exception("El nombre del acontecimeinto es un dato obligatorio");
    }

    private void validarLugar()  throws Exception{
        if (tfLugar.getText().isEmpty())
            throw new Exception("El lugar del acontecimeinto es un dato obligatorio");
    }

    private void validarFecha() throws Exception {
        if (tfFecha.getText().isEmpty())
            throw new Exception("La fecha del acontecimeinto es un dato obligatorio");
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Fecha = LocalDate.parse(tfFecha.getText(), formato);
        if (Fecha.compareTo(LocalDate.now())<=0)
            throw new Exception("La fecha introducida no puede ser menor a la fecha de hoy");
    }

    private void validarHoras() throws Exception {
        if (tfHoraInicio.getText().isEmpty())
            throw new Exception("La hora de inicio del acontecimeinto es un dato obligatorio");
        if (tfHoraFin.getText().isEmpty())
            throw new Exception("La hora de fin del acontecimeinto es un dato obligatorio");
        HoraInicio = LocalTime.parse(tfHoraInicio.getText());
        HoraFin = LocalTime.parse(tfHoraFin.getText());
        if (HoraFin.compareTo(HoraInicio)<=0)
            throw new Exception("Hora de fin no puede ser menor o igual a la hora de inicio");
    }

    private void validarAforo() throws Exception {
        if (tfAforo.getText().isEmpty())
            throw new Exception("El aforo del acontecimeinto es un dato obligatorio");
        aforo = Integer.parseInt(tfAforo.getText());
        if (aforo<=0)
            throw new Exception("");

    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        vInsertar dialog = new vInsertar();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
