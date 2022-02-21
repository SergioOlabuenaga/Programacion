package Vista;

import javax.swing.*;
import java.awt.event.*;

public class jdInicio extends JDialog {
    private JPanel contentPane;
    private JButton bNum1;
    private JButton bNum2;
    private JButton bNum3;
    private JButton bNum4;
    private JButton bNum5;
    private JButton bNum6;
    private JButton bNum7;
    private JButton bNum8;
    private JButton bNum9;
    private JPasswordField passwordField1;
    private JLabel lClave;
    private JTextField tfNIF;
    private JLabel lNIF;
    private JButton bEntrar;
    private JButton bNum10;
    private JButton buttonOK;
    private JButton buttonCancel;

    public jdInicio() {
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
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        jdInicio dialog = new jdInicio();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
