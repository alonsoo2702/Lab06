package ejercicio4;

public class Enemigo {
    private String nombre;
    private int salud;
    private int nivel;
    private String tipo;
    private int poderBase;
    
    public Enemigo(String nombre, int salud, int nivel, String tipo, int poderBase) {
        this.nombre = nombre;
        this.salud = salud;
        this.nivel = nivel;
        this.tipo = tipo;
        this.poderBase = poderBase;
    }
    
    public String getNombre() { return nombre; }
    public int getSalud() { return salud; }
    public int getNivel() { return nivel; }
    public String getTipo() { return tipo; }
    
    public int atacar() {
        return poderBase + (nivel * 2);
    }
    
    public void recibirDano(int dano) {
        salud = Math.max(0, salud - dano);
    }
    
    public boolean estaVivo() {
        return salud > 0;
    }
}
