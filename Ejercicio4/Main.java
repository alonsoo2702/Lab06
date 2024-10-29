package ejercicio4;

public class Main {
    public static void main(String[] args) {
        // Crear jugador
        Jugador jugador = new Jugador("Héroe", 100, 5);
        
        // Crear y equipar items
        Item espada = new Item("Espada de Fuego", 1, "Arma", "Una poderosa espada", 15);
        Item pocion = new Item("Poción de Vida", 3, "Poción", "Restaura 30 de salud", 30);
        
        jugador.getInventario().agregarItem(espada);
        jugador.getInventario().agregarItem(pocion);
        jugador.equiparItem(espada);
        
        // Crear modelo de combate
        CombateModel modeloCombate = new CombateModel(jugador);
        
        // Agregar enemigos
        modeloCombate.agregarEnemigo(new Enemigo("Goblin", 50, 3, "Bestia", 8));
        modeloCombate.agregarEnemigo(new Enemigo("Orco", 80, 4, "Bestia", 12));
        
        // Crear vista y controlador de combate
        CombateView vistaCombate = new CombateView();
        CombateController controladorCombate = new CombateController(modeloCombate, vistaCombate);
        
        // Iniciar combate
        controladorCombate.iniciarCombate();
    }
}
