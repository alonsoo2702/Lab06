package ejercicio4;
import java.util.List;

public class InventarioController {
    private InventarioModel modelo;
    private InventarioView vista;
    
    public InventarioController(InventarioModel modelo, InventarioView vista) {
        this.modelo = modelo;
        this.vista = vista;
    }
    
    public void agregarItem(String nombre, int cantidad, String tipo, String descripcion) {
        Item item = new Item(nombre, cantidad, tipo, descripcion, cantidad);
        modelo.agregarItem(item);
        vista.mostrarMensaje("Item agregado exitosamente: " + nombre);
    }
    
    public void eliminarItem(String nombre) {
        Item item = modelo.buscarItem(nombre);
        if (item != null) {
            modelo.eliminarItem(item);
            vista.mostrarMensaje("Item eliminado exitosamente: " + nombre);
        } else {
            vista.mostrarMensaje("Item no encontrado: " + nombre);
        }
    }
    
    public void verInventario() {
        List<Item> items = modelo.obtenerItems();
        vista.mostrarInventario(items);
    }
    
    public void mostrarDetalles(String nombre) {
        Item item = modelo.buscarItem(nombre);
        if (item != null) {
            vista.mostrarDetallesItem(item);
        } else {
            vista.mostrarMensaje("Item no encontrado: " + nombre);
        }
    }
    
    public void buscarItem(String nombre) {
        Item item = modelo.buscarItem(nombre);
        if (item != null) {
            vista.mostrarDetallesItem(item);
        } else {
            vista.mostrarMensaje("Item no encontrado: " + nombre);
        }
    }
}
