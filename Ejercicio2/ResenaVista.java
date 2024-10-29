package ejercicio1;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class ResenaVista {
    private Scanner scanner;
    private DateTimeFormatter formatter;

    public ResenaVista(Scanner scanner) {
        this.scanner = scanner;
        this.formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    }

    public String[] solicitarDatosResena() {
        String[] datos = new String[2];
        System.out.print("Calificación (1-5 estrellas): ");
        datos[0] = scanner.nextLine();
        System.out.print("Comentario: ");
        datos[1] = scanner.nextLine();
        return datos;
    }

    public void mostrarResenas(List<Resena> resenas) {
        if (resenas.isEmpty()) {
            System.out.println("No hay reseñas para este producto.");
            return;
        }

        System.out.println("\n=== RESEÑAS DEL PRODUCTO ===");
        for (Resena resena : resenas) {
            System.out.printf("Usuario: %s - Calificación: %d/5 - Fecha: %s%n",
                    resena.getUsuario().getNombreUsuario(),
                    resena.getCalificacion(),
                    resena.getFecha().format(formatter));
            System.out.printf("Comentario: %s%n%n", resena.getComentario());
        }
    }

    public void mostrarPromedio(double promedio) {
        System.out.printf("Calificación promedio: %.1f/5%n", promedio);
    }

	public void mostrarMensaje(String string) {
		// TODO Auto-generated method stub
		
	}

}
