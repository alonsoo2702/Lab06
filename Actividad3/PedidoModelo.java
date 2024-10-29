package actividad3;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PedidoModelo {
    private List<Pedido> pedidosActivos;
    private List<Pedido> historialPedidos;

    public PedidoModelo() {
        pedidosActivos = new ArrayList<>();
        historialPedidos = new ArrayList<>();
    }

    public void agregarPedido(Pedido pedido) {
        pedidosActivos.add(pedido);
    }

    public boolean marcarPedidoComoCompletado(int id) {
        Pedido pedido = buscarPedidoPorId(id);
        if (pedido != null && pedido.getEstado() == EstadoPedido.PENDIENTE) {
            pedido.setEstado(EstadoPedido.COMPLETADO);
            historialPedidos.add(pedido);
            pedidosActivos.remove(pedido);
            return true;
        }
        return false;
    }

    public Pedido buscarPedidoPorId(int id) {
        return pedidosActivos.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public boolean eliminarPedido(int id) {
        Pedido pedido = buscarPedidoPorId(id);
        if (pedido != null) {
            pedido.setEstado(EstadoPedido.ELIMINADO);
            historialPedidos.add(pedido);
            return pedidosActivos.remove(pedido);
        }
        return false;
    }

    public List<Pedido> getPedidosPorEstado(EstadoPedido estado) {
        if (estado == EstadoPedido.PENDIENTE) {
            return pedidosActivos.stream()
                    .filter(p -> p.getEstado() == EstadoPedido.PENDIENTE)
                    .collect(Collectors.toList());
        } else {
            return historialPedidos.stream()
                    .filter(p -> p.getEstado() == estado)
                    .collect(Collectors.toList());
        }
    }

    public int contarPedidosPendientes() {
        return (int) pedidosActivos.stream()
                .filter(p -> p.getEstado() == EstadoPedido.PENDIENTE)
                .count();
    }

    public Map<String, Long> contarPedidosPorTipo() {
        return pedidosActivos.stream()
                .collect(Collectors.groupingBy(
                        Pedido::getTipo,
                        Collectors.counting()
                ));
    }

    public List<Pedido> getHistorialCompleto() {
        return historialPedidos;
    }

    public List<Pedido> getPedidosActivos() {
        return pedidosActivos;
    }
}
