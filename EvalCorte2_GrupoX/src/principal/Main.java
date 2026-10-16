package principal;

import controlador.InventarioController;
import javax.swing.SwingUtilities;
import modelo.InventarioModel;
import vista.InventarioView;

/**
 * Punto de entrada: arma el MVC y muestra la ventana.
 */
public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            InventarioModel modelo = new InventarioModel();
            InventarioView vista = new InventarioView();
            new InventarioController(modelo, vista);
            vista.setVisible(true);
        });
    }
}
