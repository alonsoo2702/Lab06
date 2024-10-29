package ejercicio1;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ResenaModelo {
    private List<Resena> resenas;

    public ResenaModelo() {
        this.resenas = new ArrayList<>();
    }

    public void agregarResena(Usuario usuario, Producto producto, int calificacion, String comentario) {
        if (calificacion >= 1 && calificacion <= 5) {
            resenas.add(new Resena(usuario, producto, calificacion, comentario));
        }
    }

    public List<Resena> obtenerResenasPorProducto(int productoId) {
        return resenas.stream()
                .filter(r -> r.getProducto().getId() == productoId)
                .collect(Collectors.toList());
    }

    public double obtenerPromedioCalificacion(int productoId) {
        return resenas.stream()
                .filter(r -> r.getProducto().getId() == productoId)
                .mapToInt(Resena::getCalificacion)
                .average()
                .orElse(0.0);
    }
}
