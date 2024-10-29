package ejercicio4;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CombateModel {
    private Jugador jugador;
    private List<Enemigo> enemigos;
    private Random random;
    
    public CombateModel(Jugador jugador) {
        this.jugador = jugador;
        this.enemigos = new ArrayList<>();
        this.random = new Random();
    }
    
    public void agregarEnemigo(Enemigo enemigo) {
        enemigos.add(enemigo);
    }
    
    public List<Enemigo> getEnemigos() {
        return enemigos;
    }
    
    public Jugador getJugador() {
        return jugador;
    }
    
    public Enemigo getEnemigoAleatorio() {
        List<Enemigo> enemigosVivos = enemigos.stream()
            .filter(Enemigo::estaVivo)
            .toList();
        if (!enemigosVivos.isEmpty()) {
            return enemigosVivos.get(random.nextInt(enemigosVivos.size()));
        }
        return null;
    }
    
    public boolean combateTerminado() {
        return !jugador.estaVivo() || enemigos.stream().noneMatch(Enemigo::estaVivo);
    }
}
