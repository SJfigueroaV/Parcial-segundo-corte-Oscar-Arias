package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * Interfaz gráfica del gestor de dispositivos. Solo muestra y captura datos,
 * no contiene lógica de negocio.
 */
public class InventarioView extends JFrame {

    private JTextField txtCodigo;
    private JTextField txtNombre;
    private JTextField txtPrecio;
    private JButton btnGuardar;

    private JTable tabla;
    private DefaultTableModel modeloTabla;

    private JLabel lblInversionTotal;

    public InventarioView() {
        setTitle("TechStore - Gestor de Dispositivos");
        setSize(650, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel Superior (Ingreso)
        JPanel panelSuperior = new JPanel(new FlowLayout());
        txtCodigo = new JTextField(8);
        txtNombre = new JTextField(12);
        txtPrecio = new JTextField(8);
        btnGuardar = new JButton("Guardar Dispositivo");

        panelSuperior.add(new JLabel("Código:"));
        panelSuperior.add(txtCodigo);
        panelSuperior.add(new JLabel("Nombre:"));
        panelSuperior.add(txtNombre);
        panelSuperior.add(new JLabel("Precio:"));
        panelSuperior.add(txtPrecio);
        panelSuperior.add(btnGuardar);

        // Panel Central (Tabla)
        modeloTabla = new DefaultTableModel(new Object[]{"Código", "Nombre", "Precio"}, 0);
        tabla = new JTable(modeloTabla);
        JScrollPane scroll = new JScrollPane(tabla);

        // Panel Inferior (Métricas)
        JPanel panelInferior = new JPanel(new FlowLayout());
        lblInversionTotal = new JLabel("Inversión Total: $0.0");
        panelInferior.add(lblInversionTotal);

        add(panelSuperior, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);
    }

    // Getters para que el Controlador lea lo que escribe el usuario
    public String getCodigo() {
        return txtCodigo.getText();
    }

    public String getNombre() {
        return txtNombre.getText();
    }

    public String getPrecio() {
        return txtPrecio.getText();
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }

    public JLabel getLblInversionTotal() {
        return lblInversionTotal;
    }

    public void limpiarCampos() {
        txtCodigo.setText("");
        txtNombre.setText("");
        txtPrecio.setText("");
    }
}
