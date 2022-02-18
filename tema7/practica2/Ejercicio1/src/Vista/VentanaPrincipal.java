package Vista;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal {
    private JPanel pPrincipal;
    private JTextField tfProducto;
    private JTextField tfUnidades;
    private JRadioButton rbCompra;
    private JRadioButton rbVenta;
    private JLabel lAlmacen;
    private JTextField tfPrecioCompra;
    private JTextField tfImporteCompra;
    private JComboBox cbProveedor;
    private JTextField tfPrecioVenta;
    private JTextField tfCliente;
    private JCheckBox ckVolumen;
    private JCheckBox ckProntoPago;
    private JTextField tfVenta;
    private JButton bAceptar;
    private JButton bCancelar;
    private JLabel lProducto;
    private JLabel lUnidades;
    private JLabel lPrecioC;
    private JLabel lProveedor;
    private JLabel lCompra;
    private JLabel lPrecioV;
    private JLabel lCliente;
    private JLabel lVenta;
    private JPanel pCompra;
    private JPanel pVenta;
    private JPanel pOperacion;


    public JPanel getpPrincipal() {
        return pPrincipal;
    }
}
