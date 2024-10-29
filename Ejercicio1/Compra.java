package ejercicio1;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

public class Compra {
    private int id;
    private List<ItemCarrito> items;
    private LocalDateTime fecha;
    private double subtotal;
    private double descuento;
    private double costoEnvio;
    private double total;
    private EstadoCompra estado;
    private static int contadorId = 1;

    public Compra() {
        this.id = contadorId++;
        this.items = new ArrayList<>();
        this.fecha = LocalDateTime.now();
        this.estado = EstadoCompra.PENDIENTE;
    }

    public void calcularTotales() {
        this.subtotal = items.stream().mapToDouble(ItemCarrito::getSubtotal).sum();
        this.total = subtotal - descuento + costoEnvio;
    }

    // Getters y setters
    public int getId() { return id; }
    public List<ItemCarrito> getItems() { return items; }
    public LocalDateTime getFecha() { return fecha; }
    public double getSubtotal() { return subtotal; }
    public double getDescuento() { return descuento; }
    public void setDescuento(double descuento) { this.descuento = descuento; }
    public double getCostoEnvio() { return costoEnvio; }
    public void setCostoEnvio(double costoEnvio) { this.costoEnvio = costoEnvio; }
    public double getTotal() { return total; }
    public EstadoCompra getEstado() { return estado; }
    public void setEstado(EstadoCompra estado) { this.estado = estado; }
}
