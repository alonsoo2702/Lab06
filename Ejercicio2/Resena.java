package ejercicio1;
import java.time.LocalDateTime;

public class Resena {
    private int id;
    private Usuario usuario;
    private Producto producto;
    private int calificacion; // 1-5 estrellas
    private String comentario;
    private LocalDateTime fecha;
    private static int contadorId = 1;

    public Resena(Usuario usuario, Producto producto, int calificacion, String comentario) {
        this.id = contadorId++;
        this.usuario = usuario;
        this.producto = producto;
        this.calificacion = calificacion;
        this.comentario = comentario;
        this.fecha = LocalDateTime.now();
    }

    // Getters
    public int getId() { return id; }
    public Usuario getUsuario() { return usuario; }
    public Producto getProducto() { return producto; }
    public int getCalificacion() { return calificacion; }
    public String getComentario() { return comentario; }
    public LocalDateTime getFecha() { return fecha; }
}
