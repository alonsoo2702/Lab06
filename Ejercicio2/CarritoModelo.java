package ejercicio1;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

public class CarritoModelo {
    private List<Producto> catalogoProductos;
    private List<ItemCarrito> carrito;
    private List<Compra> historialCompras;
    private Map<String, Double> descuentos;
    private UsuarioModelo usuarioModelo;
    private ResenaModelo resenaModelo;
    private double descuentoActual;

    public CarritoModelo(UsuarioModelo usuarioModelo, ResenaModelo resenaModelo) {
        this.catalogoProductos = new ArrayList<>();
        this.carrito = new ArrayList<>();
        this.historialCompras = new ArrayList<>();
        this.descuentos = new HashMap<>();
        this.usuarioModelo = usuarioModelo;
        this.resenaModelo = resenaModelo;
        this.descuentoActual = 0.0;
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
            // Buscar si el producto ya está en el carrito
            ItemCarrito itemExistente = carrito.stream()
                    .filter(item -> item.getProducto().getId() == idProducto)
                    .findFirst()
                    .orElse(null);

            if (itemExistente != null) {
                // Actualizar cantidad si el producto ya está en el carrito
                itemExistente.setCantidad(itemExistente.getCantidad() + cantidad);
            } else {
                // Agregar nuevo item si el producto no está en el carrito
                ItemCarrito item = new ItemCarrito(producto, cantidad);
                carrito.add(item);
            }
        }
    }

    public void eliminarDelCarrito(int idProducto) {
        carrito.removeIf(item -> item.getProducto().getId() == idProducto);
    }

    public void actualizarCantidadCarrito(int idProducto, int nuevaCantidad) {
        carrito.stream()
                .filter(item -> item.getProducto().getId() == idProducto)
                .findFirst()
                .ifPresent(item -> item.setCantidad(nuevaCantidad));
    }

    public Producto buscarProductoPorId(int id) {
        return catalogoProductos.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public double aplicarDescuento(String codigo) {
        descuentoActual = descuentos.getOrDefault(codigo, 0.0);
        return descuentoActual;
    }

    public double calcularCostoEnvio(double subtotal) {
        if (subtotal >= 1000) return 0.0; // Envío gratis para compras mayores a 1000
        return 150.0; // Costo fijo de envío
    }

    public double calcularSubtotalCarrito() {
        return carrito.stream().mapToDouble(ItemCarrito::getSubtotal).sum();
    }

    public Compra realizarCompra() {
        if (carrito.isEmpty()) return null;

        Usuario usuarioActual = usuarioModelo.getUsuarioActual();
        Compra compra = new Compra(usuarioActual);
        compra.getItems().addAll(new ArrayList<>(carrito)); // Copia de items del carrito
        
        // Calcular totales
        compra.calcularTotales();
        
        // Aplicar descuento actual si existe
        if (descuentoActual > 0) {
            double montoDescuento = compra.getSubtotal() * (descuentoActual / 100);
            compra.setDescuento(montoDescuento);
        }
        
        // Calcular y establecer costo de envío
        double costoEnvio = calcularCostoEnvio(compra.getSubtotal());
        compra.setCostoEnvio(costoEnvio);
        
        // Recalcular el total final
        compra.calcularTotales();
        
        // Finalizar compra
        compra.setEstado(EstadoCompra.COMPLETADA);
        historialCompras.add(compra);
        
        // Limpiar carrito y descuento actual
        carrito.clear();
        descuentoActual = 0.0;
        
        return compra;
    }

    public List<Compra> obtenerComprasUsuario(Usuario usuario) {
        if (usuario == null) return new ArrayList<>();
        return historialCompras.stream()
                .filter(compra -> compra.getUsuario() != null && 
                        compra.getUsuario().getId() == usuario.getId())
                .collect(Collectors.toList());
    }

    public List<Producto> obtenerProductosComprados(Usuario usuario) {
        if (usuario == null) return new ArrayList<>();
        return obtenerComprasUsuario(usuario).stream()
                .flatMap(compra -> compra.getItems().stream())
                .map(ItemCarrito::getProducto)
                .distinct()
                .collect(Collectors.toList());
    }

    public boolean puedeResenarProducto(Usuario usuario, int productoId) {
        if (usuario == null) return false;
        return obtenerComprasUsuario(usuario).stream()
                .anyMatch(compra -> 
                    compra.getEstado() == EstadoCompra.COMPLETADA &&
                    compra.getPuedeResenar() &&
                    compra.getItems().stream()
                        .anyMatch(item -> item.getProducto().getId() == productoId)
                );
    }

    public void vaciarCarrito() {
        carrito.clear();
        descuentoActual = 0.0;
    }

    // Getters y setters
    public List<Producto> getCatalogoProductos() {
        return catalogoProductos;
    }

    public List<ItemCarrito> getCarrito() {
        return carrito;
    }

    public List<Compra> getHistorialCompras() {
        return historialCompras;
    }

    public UsuarioModelo getUsuarioModelo() {
        return usuarioModelo;
    }

    public ResenaModelo getResenaModelo() {
        return resenaModelo;
    }

    public double getDescuentoActual() {
        return descuentoActual;
    }

    public Map<String, Double> getDescuentos() {
        return new HashMap<>(descuentos);
    }
}
