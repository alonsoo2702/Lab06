package ejercicio1;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioModelo {
    private List<Usuario> usuarios;
    private Usuario usuarioActual;

    public UsuarioModelo() {
        this.usuarios = new ArrayList<>();
        this.usuarioActual = null;
    }

    public boolean registrarUsuario(String nombreUsuario, String contrasena, String email) {
        if (usuarios.stream().anyMatch(u -> u.getNombreUsuario().equals(nombreUsuario))) {
            return false;
        }
        usuarios.add(new Usuario(nombreUsuario, contrasena, email));
        return true;
    }

    public boolean iniciarSesion(String nombreUsuario, String contrasena) {
        Optional<Usuario> usuario = usuarios.stream()
                .filter(u -> u.getNombreUsuario().equals(nombreUsuario) && 
                           u.getContrasena().equals(contrasena))
                .findFirst();
        
        if (usuario.isPresent()) {
            usuarioActual = usuario.get();
            return true;
        }
        return false;
    }

    public void cerrarSesion() {
        usuarioActual = null;
    }

    public Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public boolean estaAutenticado() {
        return usuarioActual != null;
    }
}
