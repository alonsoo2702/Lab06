package ejercicio3;

public class Main {
    public static void main(String[] args) {
        // Crear las instancias del patrón MVC
        InventarioModel modelo = new InventarioModel();
        InventarioView vista = new InventarioView();
        InventarioController controlador = new InventarioController(modelo, vista);
        
        // Ejemplo de uso del sistema
        controlador.agregarItem("Espada", 5, "Arma", "Espada de acero");
        controlador.agregarItem("Poción de Vida", 10, "Poción", "Restaura 50 HP");
        
        // Ver todo el inventario
        controlador.verInventario();
        
        // Buscar un item específico
        controlador.buscarItem("Espada");
        
        // Eliminar un item
        controlador.eliminarItem("Poción de Vida");
        
        // Ver inventario actualizado
        controlador.verInventario();
    }
}
