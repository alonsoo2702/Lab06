package ejercicio4;

import java.util.ArrayList;
import java.util.List;

public class InventarioModel {
    private List<Item> items;
    
    public InventarioModel() {
        items = new ArrayList<>();
    }
    
    public void agregarItem(Item item) {
        items.add(item);
    }
    
    public void eliminarItem(Item item) {
        items.remove(item);
    }
    
    public List<Item> obtenerItems() {
        return new ArrayList<>(items);
    }
    
    public Item buscarItem(String nombre) {
        return items.stream()
                   .filter(item -> item.getNombre().equalsIgnoreCase(nombre))
                   .findFirst()
                   .orElse(null);
    }
}
