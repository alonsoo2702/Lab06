package actividad3;
import java.time.LocalDateTime;

public class Pedido {
    private String nombrePlato;
    private String tipo;
    private int id;
    private EstadoPedido estado;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
    private static int contadorId = 1;

    public Pedido(String nombrePlato, String tipo) {
        this.nombrePlato = nombrePlato;
        this.tipo = tipo;
        this.id = contadorId++;
        this.estado = EstadoPedido.PENDIENTE;
        this.fechaCreacion = LocalDateTime.now();
        this.fechaActualizacion = LocalDateTime.now();
    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
        this.fechaActualizacion = LocalDateTime.now();
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }
}
