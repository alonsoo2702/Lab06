package ejercicio4;
import java.util.List;

public class CombateView {
    public void mostrarEstadoCombate(Jugador jugador, List<Enemigo> enemigos) {
        System.out.println("\n=== Estado del Combate ===");
        System.out.println("Jugador: " + jugador.getNombre());
        System.out.println("Salud: " + jugador.getSalud());
        System.out.println("Nivel: " + jugador.getNivel());
        System.out.println("Arma equipada: " + 
            (jugador.getItemEquipado() != null ? jugador.getItemEquipado().getNombre() : "Ninguna"));
        
        System.out.println("\nEnemigos:");
        for (Enemigo enemigo : enemigos) {
            if (enemigo.estaVivo()) {
                System.out.println("- " + enemigo.getNombre() + " (Salud: " + 
                    enemigo.getSalud() + ", Nivel: " + enemigo.getNivel() + 
                    ", Tipo: " + enemigo.getTipo() + ")");
            }
        }
    }
    
    public void mostrarMensajeCombate(String mensaje) {
        System.out.println("\n" + mensaje);
    }
    
    public void mostrarResultadoCombate(boolean jugadorGano) {
        System.out.println("\n=== Fin del Combate ===");
        if (jugadorGano) {
            System.out.println("¡Victoria! Has derrotado a todos los enemigos.");
        } else {
            System.out.println("Has sido derrotado...");
        }
    }
}
