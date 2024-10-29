package ejercicio4;

public class Jugador {
    private String nombre;
    private int salud;
    private int nivel;
    private InventarioModel inventario;
    private Item itemEquipado;
    
    public Jugador(String nombre, int salud, int nivel) {
        this.nombre = nombre;
        this.salud = salud;
        this.nivel = nivel;
        this.inventario = new InventarioModel();
    }
    
    public String getNombre() { return nombre; }
    public int getSalud() { return salud; }
    public int getNivel() { return nivel; }
    public Item getItemEquipado() { return itemEquipado; }
    
    public void equiparItem(Item item) {
        this.itemEquipado = item;
    }
    
    public int atacar() {
        if (itemEquipado != null && itemEquipado.getTipo().equals("Arma")) {
            return itemEquipado.getPoder() + (nivel * 2);
        }
        return nivel * 2; // Ataque base sin arma
    }
    
    public void usarObjeto(Item item) {
        if (item.getTipo().equals("Poción")) {
            salud += item.getPoder();
            item.usarItem();
        }
    }
    
    public void recibirDano(int dano) {
        salud = Math.max(0, salud - dano);
    }
    
    public boolean estaVivo() {
        return salud > 0;
    }
}
