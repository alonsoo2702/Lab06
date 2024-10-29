package actividad2;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PedidoVista {
    private Scanner scanner;

    public PedidoVista() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("\nOpciones:");
        System.out.println("1. Agregar Pedido");
        System.out.println("2. Mostrar Pedidos");
        System.out.println("3. Eliminar Pedido");
        System.out.println("4. Actualizar Pedido");
        System.out.println("5. Buscar Pedido");
        System.out.println("6. Ver Estadísticas");
        System.out.println("7. Salir");
    }

    public String solicitarNombrePlato() {
        System.out.print("Introduce el nombre del plato: ");
        return scanner.nextLine();
    }

    public String solicitarTipo() {
        System.out.print("Introduce el tipo de plato (Entrada/Principal/Postre/Bebida): ");
        return scanner.nextLine();
    }

    public int solicitarId() {
        System.out.print("Introduce el ID del pedido: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public String solicitarTerminoBusqueda() {
        System.out.print("Introduce el término de búsqueda: ");
        return scanner.nextLine();
    }

    public void mostrarPedidos(List<Pedido> pedidos) {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos en la lista.");
        } else {
            System.out.println("Lista de Pedidos:");
            for (Pedido pedido : pedidos) {
                System.out.printf("ID: %d - %s (Tipo: %s)%n", 
                    pedido.getId(), 
                    pedido.getNombrePlato(), 
                    pedido.getTipo());
            }
        }
    }

    public void mostrarEstadisticas(int totalPedidos, Map<String, Long> pedidosPorTipo) {
        System.out.println("\nEstadísticas de Pedidos:");
        System.out.println("Total de pedidos: " + totalPedidos);
        System.out.println("\nPedidos por tipo:");
        pedidosPorTipo.forEach((tipo, cantidad) -> 
            System.out.println(tipo + ": " + cantidad)
        );
    }

    public String solicitarOpcion() {
        System.out.print("Selecciona una opción: ");
        return scanner.nextLine();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void cerrarScanner() {
        scanner.close();
    }
}
