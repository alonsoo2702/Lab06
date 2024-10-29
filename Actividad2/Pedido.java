package actividad2;

public class Pedido {
    private String nombrePlato;
    private String tipo;
    private int id;
    private static int contadorId = 1;

    public Pedido(String nombrePlato, String tipo) {
        this.nombrePlato = nombrePlato;
        this.tipo = tipo;
        this.id = contadorId++;
    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }
}
