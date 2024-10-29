package ejercicio1;

public class Main {
    public static void main(String[] args) {
        // Inicializar modelos
        UsuarioModelo usuarioModelo = new UsuarioModelo();
        ResenaModelo resenaModelo = new ResenaModelo();
        CarritoModelo carritoModelo = new CarritoModelo(usuarioModelo, resenaModelo);

        // Inicializar vistas
        CarritoVista carritoVista = new CarritoVista();
        UsuarioVista usuarioVista = new UsuarioVista(carritoVista.getScanner());
        ResenaVista resenaVista = new ResenaVista(carritoVista.getScanner());

        // Inicializar controladores
        UsuarioControlador usuarioControlador = new UsuarioControlador(usuarioModelo, usuarioVista);
        ResenaControlador resenaControlador = new ResenaControlador(resenaModelo, resenaVista, usuarioModelo);
        CarritoControlador carritoControlador = new CarritoControlador(carritoModelo, carritoVista);

        // Proceso de autenticación
        if (usuarioControlador.procesarAutenticacion()) {
            carritoControlador.iniciar();
        }
        
        carritoVista.cerrarScanner();
    }
}
