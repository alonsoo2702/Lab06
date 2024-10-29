package actividad2;
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

    public void actualizarPedido() {
        try {
            int id = vista.solicitarId();
            Pedido pedido = modelo.buscarPedidoPorId(id);
            if (pedido != null) {
                String nuevoNombre = vista.solicitarNombrePlato();
                String nuevoTipo = vista.solicitarTipo();
                if (!nuevoNombre.isEmpty() && !nuevoTipo.isEmpty()) {
                    pedido.setNombrePlato(nuevoNombre);
                    pedido.setTipo(nuevoTipo);
                    vista.mostrarMensaje("Pedido actualizado correctamente.");
                } else {
                    vista.mostrarMensaje("El nombre y tipo no pueden estar vacíos.");
                }
            } else {
                vista.mostrarMensaje("No se encontró el pedido con ID: " + id);
            }
        } catch (NumberFormatException e) {
            vista.mostrarMensaje("ID inválido. Debe ser un número.");
        }
    }

    public void buscarPedidos() {
        String termino = vista.solicitarTerminoBusqueda();
        List<Pedido> resultados = modelo.buscarPedidos(termino);
        vista.mostrarPedidos(resultados);
    }

    public void mostrarEstadisticas() {
        int totalPedidos = modelo.getTotalPedidos();
        Map<String, Long> pedidosPorTipo = modelo.contarPedidosPorTipo();
        vista.mostrarEstadisticas(totalPedidos, pedidosPorTipo);
    }

    public void mostrarPedidos() {
        vista.mostrarPedidos(modelo.getPedidos());
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
                    mostrarPedidos();
                    break;
                case "3":
                    eliminarPedido();
                    break;
                case "4":
                    actualizarPedido();
                    break;
                case "5":
                    buscarPedidos();
                    break;
                case "6":
                    mostrarEstadisticas();
                    break;
                case "7":
                    vista.mostrarMensaje("Saliendo...");
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida. Inténtalo de nuevo.");
            }
        } while (!opcion.equals("7"));
        vista.cerrarScanner();
    }
}
