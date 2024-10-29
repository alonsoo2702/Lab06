package actividad3;

import java.time.format.DateTimeFormatter;
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
        System.out.println("2. Mostrar Pedidos Pendientes");
        System.out.println("3. Mostrar Pedidos Completados");
        System.out.println("4. Marcar Pedido como Completado");
        System.out.println("5. Eliminar Pedido");
        System.out.println("6. Ver Historial Completo");
        System.out.println("7. Ver Estadísticas");
        System.out.println("8. Salir");
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

    public void mostrarPedidosConEstado(List<Pedido> pedidos, EstadoPedido estado) {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos " + estado.toString().toLowerCase() + "s.");
        } else {
            System.out.println("Lista de Pedidos " + estado.toString() + "S:");
            for (Pedido pedido : pedidos) {
                System.out.printf("ID: %d - %s (Tipo: %s) - Fecha: %s%n",
                        pedido.getId(),
                        pedido.getNombrePlato(),
                        pedido.getTipo(),
                        pedido.getFechaActualizacion().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
            }
        }
    }

    public void mostrarHistorialCompleto(List<Pedido> historial) {
        if (historial.isEmpty()) {
            System.out.println("El historial está vacío.");
        } else {
            System.out.println("\nHistorial Completo de Pedidos:");
            for (Pedido pedido : historial) {
                System.out.printf("ID: %d - %s (Tipo: %s) - Estado: %s - Última actualización: %s%n",
                        pedido.getId(),
                        pedido.getNombrePlato(),
                        pedido.getTipo(),
                        pedido.getEstado(),
                        pedido.getFechaActualizacion().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
            }
        }
    }

    public void mostrarEstadisticas(int totalPendientes, Map<String, Long> pedidosPorTipo,
                                  int completados, int eliminados) {
        System.out.println("\nEstadísticas de Pedidos:");
        System.out.println("Pedidos pendientes: " + totalPendientes);
        System.out.println("Pedidos completados: " + completados);
        System.out.println("Pedidos eliminados: " + eliminados);
        System.out.println("\nPedidos por tipo:");
        pedidosPorTipo.forEach((tipo, cantidad) ->
                System.out.println(tipo + ": " + cantidad));
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
