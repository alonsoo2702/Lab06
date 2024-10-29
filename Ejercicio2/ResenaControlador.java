package ejercicio1;

import java.util.List;

public class ResenaControlador {
    private ResenaModelo modelo;
    private ResenaVista vista;
    private UsuarioModelo usuarioModelo;

    public ResenaControlador(ResenaModelo modelo, ResenaVista vista, UsuarioModelo usuarioModelo) {
        this.modelo = modelo;
        this.vista = vista;
        this.usuarioModelo = usuarioModelo;
    }

    public void agregarResena(Producto producto) {
        if (!usuarioModelo.estaAutenticado()) {
            vista.mostrarMensaje("Debe iniciar sesión para dejar una reseña.");
            return;
        }

        try {
            String[] datos = vista.solicitarDatosResena();
            int calificacion = Integer.parseInt(datos[0]);
            
            if (calificacion < 1 || calificacion > 5) {
                vista.mostrarMensaje("Error: La calificación debe estar entre 1 y 5.");
                return;
            }

            modelo.agregarResena(usuarioModelo.getUsuarioActual(), producto, calificacion, datos[1]);
            vista.mostrarMensaje("Reseña agregada exitosamente.");
        } catch (NumberFormatException e) {
            vista.mostrarMensaje("Error: La calificación debe ser un número válido.");
        }
    }

    public void mostrarResenasProducto(int productoId) {
        List<Resena> resenas = modelo.obtenerResenasPorProducto(productoId);
        vista.mostrarResenas(resenas);
        vista.mostrarPromedio(modelo.obtenerPromedioCalificacion(productoId));
    }
}
