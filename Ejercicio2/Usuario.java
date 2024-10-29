package ejercicio1;

public class Usuario {
    private int id;
    private String nombreUsuario;
    private String contrasena;
    private String email;
    private static int contadorId = 1;

    public Usuario(String nombreUsuario, String contrasena, String email) {
        this.id = contadorId++;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.email = email;
    }

    // Getters y setters
    public int getId() { return id; }
    public String getNombreUsuario() { return nombreUsuario; }
    public String getContrasena() { return contrasena; }
    public String getEmail() { return email; }
}
