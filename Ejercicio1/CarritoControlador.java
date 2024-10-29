package ejercicio1;

public class CarritoControlador {
    private CarritoModelo modelo;
    private CarritoVista vista;

    public CarritoControlador(CarritoModelo modelo, CarritoVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void agregarProducto() {
        String nombre = vista.solicitarDatoProducto("Ingrese nombre del producto: ");
        String precioStr = vista.solicitarDatoProducto("Ingrese precio del producto: ");
        String categoria = vista.solicitarDatoProducto("Ingrese categoría del producto: ");

        try {
            double precio = Double.parseDouble(precioStr);
            if (precio <= 0) throw new NumberFormatException();
            
            Producto producto = new Producto(nombre, precio, categoria);
            modelo.agregarProducto(producto);
            vista.mostrarMensaje("Producto agregado correctamente.");
        } catch (NumberFormatException e) {
            vista.mostrarMensaje("Error: El precio debe ser un número válido mayor que cero.");
        }
    }

    public void agregarAlCarrito() {
        try {
            vista.mostrarCatalogo(modelo.getCatalogoProductos());
            int id = Integer.parseInt(vista.solicitarDatoProducto("Ingrese ID del producto: "));
            int cantidad = Integer.parseInt(vista.solicitarDatoProducto("Ingrese cantidad: "));

            if (cantidad <= 0) throw new NumberFormatException();
            
            modelo.agregarAlCarrito(id, cantidad);
            vista.mostrarMensaje("Producto agregado al carrito.");
        } catch (NumberFormatException e) {
            vista.mostrarMensaje("Error: Ingrese valores numéricos válidos.");
        }
    }

    public void eliminarDelCarrito() {
        try {
            vista.mostrarCarrito(modelo.getCarrito());
            int id = Integer.parseInt(vista.solicitarDatoProducto("Ingrese ID del producto a eliminar: "));
            modelo.eliminarDelCarrito(id);
            vista.mostrarMensaje("Producto eliminado del carrito.");
        } catch (NumberFormatException e) {
            vista.mostrarMensaje("Error: Ingrese un ID válido.");
        }
    }

    public void aplicarDescuento() {
        String codigo = vista.solicitarDatoProducto("Ingrese código de descuento: ");
        double descuento = modelo.aplicarDescuento(codigo);
        if (descuento > 0) {
            vista.mostrarMensaje("Descuento del " + descuento + "% aplicado.");
        } else {
            vista.mostrarMensaje("Código de descuento no válido.");
        }
    }

    public void realizarCompra() {
        if (modelo.getCarrito().isEmpty()) {
            vista.mostrarMensaje("El carrito está vacío.");
            return;
        }

        Compra compra = modelo.realizarCompra();
        if (compra != null) {
            vista.mostrarMensaje("¡Compra realizada con éxito!");
            vista.mostrarMensaje(String.format("Total: $%.2f", compra.getTotal()));
        }
    }

    public void iniciar() {
        String opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.solicitarOpcion();
            
            switch (opcion) {
                case "1":
                    agregarProducto();
                    break;
                case "2":
                    vista.mostrarCatalogo(modelo.getCatalogoProductos());
                    break;
                case "3":
                    agregarAlCarrito();
                    break;
                case "4":
                    vista.mostrarCarrito(modelo.getCarrito());
                    break;
                case "5":
                    eliminarDelCarrito();
                    break;
                case "6":
                    aplicarDescuento();
                    break;
                case "7":
                    realizarCompra();
                    break;
                case "8":
                    vista.mostrarHistorial(modelo.getHistorialCompras());
                    break;
                case "9":
                    vista.mostrarMensaje("¡Gracias por su visita!");
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida.");
            }
        } while (!opcion.equals("9"));
        
        vista.cerrarScanner();
    }
}
