package ejercicio4;
import java.util.List;

public class InventarioView {
    public void mostrarInventario(List<Item> items) {
        System.out.println("\n=== Inventario Actual ===");
        for (Item item : items) {
            mostrarDetallesItem(item);
        }
    }
    
    public void mostrarDetallesItem(Item item) {
        System.out.println("\nDetalles del Item:");
        System.out.println("Nombre: " + item.getNombre());
        System.out.println("Cantidad: " + item.getCantidad());
        System.out.println("Tipo: " + item.getTipo());
        System.out.println("Descripción: " + item.getDescripcion());
    }
    
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
