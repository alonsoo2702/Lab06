package ejercicio1;
import java.util.Scanner;

public class UsuarioVista {
    private Scanner scanner;

    public UsuarioVista(Scanner scanner) {
        this.scanner = scanner;
    }

    public UsuarioVista(Object cerrarScanner) {
		// TODO Auto-generated constructor stub
	}

	public void mostrarMenuUsuario() {
        System.out.println("\n=== MENÚ DE USUARIO ===");
        System.out.println("1. Registrarse");
        System.out.println("2. Iniciar Sesión");
        System.out.println("3. Continuar como invitado");
        System.out.println("4. Salir");
    }

    public String[] solicitarDatosRegistro() {
        String[] datos = new String[3];
        System.out.print("Ingrese nombre de usuario: ");
        datos[0] = scanner.nextLine();
        System.out.print("Ingrese contraseña: ");
        datos[1] = scanner.nextLine();
        System.out.print("Ingrese email: ");
        datos[2] = scanner.nextLine();
        return datos;
    }

    public String[] solicitarDatosLogin() {
        String[] datos = new String[2];
        System.out.print("Ingrese nombre de usuario: ");
        datos[0] = scanner.nextLine();
        System.out.print("Ingrese contraseña: ");
        datos[1] = scanner.nextLine();
        return datos;
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
