package actividad3;
import java.util.List;
import java.util.Map;

public class PedidoControlador {
    private PedidoModelo modelo;
    private PedidoVista vista;

    public PedidoControlador(PedidoModelo modelo, PedidoVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void agregarPedido() {
        String nombrePlato = vista.solicitarNombrePlato();
        String tipo = vista.solicitarTipo();
        if (!nombrePlato.isEmpty() && !tipo.isEmpty()) {
            modelo.agregarPedido(new Pedido(nombrePlato, tipo));
            vista.mostrarMensaje("Pedido agregado: " + nombrePlato + " (" + tipo + ")");
        } else {
            vista.mostrarMensaje("El nombre del plato y el tipo no pueden estar vacíos.");
        }
    }

    public void marcarPedidoComoCompletado() {
        try {
            int id = vista.solicitarId();
            if (modelo.marcarPedidoComoCompletado(id)) {
                vista.mostrarMensaje("Pedido marcado como completado correctamente.");
            } else {
                vista.mostrarMensaje("No se pudo completar el pedido. Verifica el ID y que el pedido esté pendiente.");
            }
        } catch (NumberFormatException e) {
            vista.mostrarMensaje("ID inválido. Debe ser un número.");
        }
    }

    public void eliminarPedido() {
        try {
            int id = vista.solicitarId();
            if (modelo.eliminarPedido(id)) {
                vista.mostrarMensaje("Pedido eliminado correctamente.");
            } else {
                vista.mostrarMensaje("No se encontró el pedido con ID: " + id);
            }
        } catch (NumberFormatException e) {
            vista.mostrarMensaje("ID inválido. Debe ser un número.");
        }
    }

    public void mostrarPedidosPorEstado(EstadoPedido estado) {
        List<Pedido> pedidos = modelo.getPedidosPorEstado(estado);
        vista.mostrarPedidosConEstado(pedidos, estado);
    }

    public void mostrarHistorialCompleto() {
        List<Pedido> historial = modelo.getHistorialCompleto();
        vista.mostrarHistorialCompleto(historial);
    }

    public void mostrarEstadisticas() {
        int pendientes = modelo.contarPedidosPendientes();
        Map<String, Long> pedidosPorTipo = modelo.contarPedidosPorTipo();
        int completados = modelo.getPedidosPorEstado(EstadoPedido.COMPLETADO).size();
        int eliminados = modelo.getPedidosPorEstado(EstadoPedido.ELIMINADO).size();
        vista.mostrarEstadisticas(pendientes, pedidosPorTipo, completados, eliminados);
    }

    public void iniciar() {
        String opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.solicitarOpcion();
            switch (opcion) {
                case "1":
                    agregarPedido();
                    break;
                case "2":
                    mostrarPedidosPorEstado(EstadoPedido.PENDIENTE);
                    break;
                case "3":
                    mostrarPedidosPorEstado(EstadoPedido.COMPLETADO);
                    break;
                case "4":
                    marcarPedidoComoCompletado();
                    break;
                case "5":
                    eliminarPedido();
                    break;
                case "6":
                    mostrarHistorialCompleto();
                    break;
                case "7":
                    mostrarEstadisticas();
                    break;
                case "8":
                    vista.mostrarMensaje("Saliendo...");
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida. Inténtalo de nuevo.");
            }
        } while (!opcion.equals("8"));
        vista.cerrarScanner();
    }
}
