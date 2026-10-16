package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Lógica de negocio del inventario. No depende de ninguna librería gráfica.
 */
public class InventarioModel {

    // Colección dinámica: crece automáticamente, sin límite fijo de 50 productos
    private List<Dispositivo> bodega;

    public InventarioModel() {
        this.bodega = new ArrayList<>();
    }

    public void registrarDispositivo(Dispositivo d) {
        bodega.add(d);
    }

    public double calcularInversionTotal() {
        double total = 0;
        for (Dispositivo d : bodega) {
            total += d.getPrecio();
        }
        return total;
    }

    public List<Dispositivo> getDispositivos() {
        return bodega;
    }
}
