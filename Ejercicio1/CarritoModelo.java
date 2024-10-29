package ejercicio1;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class CarritoModelo {
    private List<Producto> catalogoProductos;
    private List<ItemCarrito> carrito;
    private List<Compra> historialCompras;
    private Map<String, Double> descuentos;

    public CarritoModelo() {
        this.catalogoProductos = new ArrayList<>();
        this.carrito = new ArrayList<>();
        this.historialCompras = new ArrayList<>();
        this.descuentos = new HashMap<>();
        inicializarDescuentos();
    }

    private void inicializarDescuentos() {
        descuentos.put("NUEVO10", 10.0);
        descuentos.put("VERANO20", 20.0);
        descuentos.put("ESPECIAL30", 30.0);
    }

    public void agregarProducto(Producto producto) {
        catalogoProductos.add(producto);
    }

    public void agregarAlCarrito(int idProducto, int cantidad) {
        Producto producto = buscarProductoPorId(idProducto);
        if (producto != null) {
            ItemCarrito item = new ItemCarrito(producto, cantidad);
            carrito.add(item);
        }
    }

    public void eliminarDelCarrito(int idProducto) {
        carrito.removeIf(item -> item.getProducto().getId() == idProducto);
    }

    public Producto buscarProductoPorId(int id) {
        return catalogoProductos.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public double aplicarDescuento(String codigo) {
        return descuentos.getOrDefault(codigo, 0.0);
    }

    public double calcularCostoEnvio(double subtotal) {
        if (subtotal >= 1000) return 0.0; // Envío gratis para compras mayores a 1000
        return 150.0; // Costo fijo de envío
    }

    public Compra realizarCompra() {
        if (carrito.isEmpty()) return null;

        Compra compra = new Compra();
        compra.getItems().addAll(carrito);
        compra.calcularTotales();
        compra.setEstado(EstadoCompra.COMPLETADA);
        historialCompras.add(compra);
        carrito.clear();
        return compra;
    }

    // Getters
    public List<Producto> getCatalogoProductos() { return catalogoProductos; }
    public List<ItemCarrito> getCarrito() { return carrito; }
    public List<Compra> getHistorialCompras() { return historialCompras; }
}
