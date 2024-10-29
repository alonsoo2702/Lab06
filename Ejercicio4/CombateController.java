package ejercicio4;

public class CombateController {
    private CombateModel modelo;
    private CombateView vista;
    
    public CombateController(CombateModel modelo, CombateView vista) {
        this.modelo = modelo;
        this.vista = vista;
    }
    
    public void iniciarCombate() {
        while (!modelo.combateTerminado()) {
            turnoJugador();
            if (!modelo.combateTerminado()) {
                turnoEnemigos();
            }
            vista.mostrarEstadoCombate(modelo.getJugador(), modelo.getEnemigos());
        }
        vista.mostrarResultadoCombate(modelo.getJugador().estaVivo());
    }
    
    private void turnoJugador() {
        Jugador jugador = modelo.getJugador();
        Enemigo enemigoObjetivo = modelo.getEnemigoAleatorio();
        
        if (enemigoObjetivo != null) {
            int dano = jugador.atacar();
            enemigoObjetivo.recibirDano(dano);
            vista.mostrarMensajeCombate(jugador.getNombre() + " ataca a " + 
                enemigoObjetivo.getNombre() + " causando " + dano + " de daño!");
        }
    }
    
    private void turnoEnemigos() {
        for (Enemigo enemigo : modelo.getEnemigos()) {
            if (enemigo.estaVivo()) {
                int dano = enemigo.atacar();
                modelo.getJugador().recibirDano(dano);
                vista.mostrarMensajeCombate(enemigo.getNombre() + " ataca a " + 
                    modelo.getJugador().getNombre() + " causando " + dano + " de daño!");
            }
        }
    }
}
