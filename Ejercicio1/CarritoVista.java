package ejercicio1;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class CarritoVista {
    private Scanner scanner;
    private DateTimeFormatter formatter;

    public CarritoVista() {
        this.scanner = new Scanner(System.in);
        this.formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    }

    public void mostrarMenu() {
        System.out.println("\n=== MENÚ CARRITO DE COMPRAS ===");
        System.out.println("1. Agregar Producto al Catálogo");
        System.out.println("2. Ver Catálogo de Productos");
        System.out.println("3. Agregar Producto al Carrito");
        System.out.println("4. Ver Carrito");
        System.out.println("5. Eliminar Producto del Carrito");
        System.out.println("6. Aplicar Descuento");
        System.out.println("7. Realizar Compra");
        System.out.println("8. Ver Historial de Compras");
        System.out.println("9. Salir");
    }

    public String solicitarDatoProducto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public void mostrarCatalogo(List<Producto> productos) {
        if (productos.isEmpty()) {
            System.out.println("El catálogo está vacío.");
            return;
        }
        
        System.out.println("\n=== CATÁLOGO DE PRODUCTOS ===");
        for (Producto producto : productos) {
            System.out.printf("ID: %d - %s ($%.2f) - Categoría: %s%n",
                    producto.getId(),
                    producto.getNombre(),
                    producto.getPrecio(),
                    producto.getCategoria());
        }
    }

    public void mostrarCarrito(List<ItemCarrito> items) {
        if (items.isEmpty()) {
            System.out.println("El carrito está vacío.");
            return;
        }

        System.out.println("\n=== TU CARRITO ===");
        double total = 0;
        for (ItemCarrito item : items) {
            System.out.printf("%s - Cantidad: %d - Subtotal: $%.2f%n",
                    item.getProducto().getNombre(),
                    item.getCantidad(),
                    item.getSubtotal());
            total += item.getSubtotal();
        }
        System.out.printf("Total: $%.2f%n", total);
    }

    public void mostrarHistorial(List<Compra> historial) {
        if (historial.isEmpty()) {
            System.out.println("No hay compras registradas.");
            return;
        }

        System.out.println("\n=== HISTORIAL DE COMPRAS ===");
        for (Compra compra : historial) {
            System.out.printf("\nCompra #%d - Fecha: %s - Estado: %s%n",
                    compra.getId(),
                    compra.getFecha().format(formatter),
                    compra.getEstado());
            System.out.printf("Subtotal: $%.2f - Descuento: $%.2f - Envío: $%.2f - Total: $%.2f%n",
                    compra.getSubtotal(),
                    compra.getDescuento(),
                    compra.getCostoEnvio(),
                    compra.getTotal());
        }
    }

    public String solicitarOpcion() {
        System.out.print("\nSeleccione una opción: ");
        return scanner.nextLine();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void cerrarScanner() {
        scanner.close();
    }
}
