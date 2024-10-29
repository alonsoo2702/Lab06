package ejercicio1;

public class UsuarioControlador {
    private UsuarioModelo modelo;
    private UsuarioVista vista;

    public UsuarioControlador(UsuarioModelo modelo, UsuarioVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public boolean procesarAutenticacion() {
        String opcion;
        do {
            vista.mostrarMenuUsuario();
            opcion = vista.solicitarDatosLogin()[0];

            switch (opcion) {
                case "1":
                    registrarUsuario();
                    break;
                case "2":
                    if (iniciarSesion()) {
                        return true;
                    }
                    break;
                case "3":
                    return true;
                case "4":
                    return false;
                default:
                    vista.mostrarMensaje("Opción no válida.");
            }
        } while (!opcion.equals("4"));
        return false;
    }

    private void registrarUsuario() {
        String[] datos = vista.solicitarDatosRegistro();
        if (modelo.registrarUsuario(datos[0], datos[1], datos[2])) {
            vista.mostrarMensaje("Usuario registrado exitosamente.");
        } else {
            vista.mostrarMensaje("Error: El nombre de usuario ya existe.");
        }
    }

    private boolean iniciarSesion() {
        String[] datos = vista.solicitarDatosLogin();
        if (modelo.iniciarSesion(datos[0], datos[1])) {
            vista.mostrarMensaje("Sesión iniciada correctamente.");
            return true;
        } else {
            vista.mostrarMensaje("Error: Credenciales incorrectas.");
            return false;
        }
    }
}
