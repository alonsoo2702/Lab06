package ejercicio1;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

public class Compra {
    private int id;
    private Usuario usuario;
    private List<ItemCarrito> items;
    private LocalDateTime fecha;
    private double subtotal;
    private double descuento;
    private double costoEnvio;
    private double total;
    private EstadoCompra estado;
    private boolean puedeResenar;
    private static int contadorId = 1;

    public Compra(Usuario usuario) {
        this.id = contadorId++;
        this.usuario = usuario;
        this.items = new ArrayList<>();
        this.fecha = LocalDateTime.now();
        this.estado = EstadoCompra.PENDIENTE;
        this.puedeResenar = true;
        this.descuento = 0.0;
        this.costoEnvio = 0.0;
        this.subtotal = 0.0;
        this.total = 0.0;
    }

    public void calcularTotales() {
        this.subtotal = items.stream().mapToDouble(ItemCarrito::getSubtotal).sum();
        this.total = subtotal - descuento + costoEnvio;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<ItemCarrito> getItems() {
        return items;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getCostoEnvio() {
        return costoEnvio;
    }

    public void setCostoEnvio(double costoEnvio) {
        this.costoEnvio = costoEnvio;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public EstadoCompra getEstado() {
        return estado;
    }

    public void setEstado(EstadoCompra estado) {
        this.estado = estado;
    }

    public boolean getPuedeResenar() {
        return puedeResenar;
    }

    public void setPuedeResenar(boolean puedeResenar) {
        this.puedeResenar = puedeResenar;
    }
}
