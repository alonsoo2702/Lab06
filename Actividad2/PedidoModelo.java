package actividad2;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PedidoModelo {
    private List<Pedido> pedidos;

    public PedidoModelo() {
        pedidos = new ArrayList<>();
    }

    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public boolean eliminarPedido(int id) {
        return pedidos.removeIf(p -> p.getId() == id);
    }

    public Pedido buscarPedidoPorId(int id) {
        return pedidos.stream()
                     .filter(p -> p.getId() == id)
                     .findFirst()
                     .orElse(null);
    }

    public List<Pedido> buscarPedidos(String termino) {
        return pedidos.stream()
                     .filter(p -> p.getNombrePlato().toLowerCase().contains(termino.toLowerCase()) ||
                                p.getTipo().toLowerCase().contains(termino.toLowerCase()))
                     .collect(Collectors.toList());
    }

    public Map<String, Long> contarPedidosPorTipo() {
        return pedidos.stream()
                     .collect(Collectors.groupingBy(
                         Pedido::getTipo,
                         Collectors.counting()
                     ));
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public int getTotalPedidos() {
        return pedidos.size();
    }
}
