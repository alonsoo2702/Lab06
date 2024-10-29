package ejercicio4;

public class Item {
    private String nombre;
    private int cantidad;
    private String tipo;
    private String descripcion;
    private int poder;
    
    public Item(String nombre, int cantidad, String tipo, String descripcion, int poder) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.poder = poder;
    }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    
    public int getPoder() { return poder; }
    public void setPoder(int poder) { this.poder = poder; }
    
    public void usarItem() {
        if (cantidad > 0) {
            cantidad--;
        }
    }
}
