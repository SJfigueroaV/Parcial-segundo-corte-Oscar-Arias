package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Dispositivo;
import modelo.InventarioModel;
import vista.InventarioView;

/**
 * Orquesta la comunicación entre la Vista y el Modelo.
 */
public class InventarioController implements ActionListener {

    private InventarioModel modelo;
    private InventarioView vista;

    public InventarioController(InventarioModel modelo, InventarioView vista) {
        this.modelo = modelo;
        this.vista = vista;

        // Enlazar el botón "Guardar Dispositivo" al ActionListener
        this.vista.getBtnGuardar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBtnGuardar()) {
            guardarDispositivo();
        }
    }

    private void guardarDispositivo() {
        try {
            // Extraer los textos de la Vista y convertirlos al tipo correcto
            String codigo = vista.getCodigo();
            String nombre = vista.getNombre();
            double precio = Double.parseDouble(vista.getPrecio());

            // Crear el Dispositivo y enviarlo al Modelo
            Dispositivo d = new Dispositivo(codigo, nombre, precio);
            modelo.registrarDispositivo(d);

            vista.limpiarCampos();
            actualizarTabla();
            actualizarInversionTotal();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vista,
                    "El precio debe ser un valor numérico.",
                    "Error de formato", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Sincronización: borra las filas previas y repinta toda la tabla desde el Modelo
    private void actualizarTabla() {
        DefaultTableModel modeloTabla = vista.getModeloTabla();
        modeloTabla.setRowCount(0);
        for (Dispositivo d : modelo.getDispositivos()) {
            modeloTabla.addRow(new Object[]{d.getCodigo(), d.getNombre(), d.getPrecio()});
        }
    }

    private void actualizarInversionTotal() {
        double total = modelo.calcularInversionTotal();
        vista.getLblInversionTotal().setText("Inversión Total: $" + total);
    }
}
