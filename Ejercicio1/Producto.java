package ejercicio1;

public class Producto {
    private int id;
    private String nombre;
    private double precio;
    private String categoria;
    private static int contadorId = 1;

    public Producto(String nombre, double precio, String categoria) {
        this.id = contadorId++;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }

    // Getters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public String getCategoria() { return categoria; }
}
