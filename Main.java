import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("==================================================");
        System.out.println("¡BIENVENIDO AL SISTEMA DE CARRITO DE COMPRAS!");
        System.out.println("==================================================");

        // 1. Pedir el nombre del carrito al usuario
        System.out.print("Escribe el nombre o dueño del carrito (ej: Carrito de Carlos): ");
        String nombreCarrito = teclado.nextLine();

        // Instanciamos el carrito genérico con el nombre ingresado
        Carrito<Producto> carrito = new Carrito<>(nombreCarrito);

        int opcion = 0;

        while (opcion != 5) {
            System.out.println("\n--- MENÚ DEL " + carrito.getNombre().toUpperCase() + " ---");
            System.out.println("1. Agregar producto al carrito");
            System.out.println("2. Obtener producto de mayor precio");
            System.out.println("3. Calcular precio total");
            System.out.println("4. Ver lista de productos (Recorrido con Iterador Propio)");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");

            opcion = teclado.nextInt();
            teclado.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("\nEscribe el nombre del producto: ");
                    String nombreProd = teclado.nextLine();
                    System.out.print("Escribe el precio del producto: ");
                    double precioProd = teclado.nextDouble();
                    teclado.nextLine(); // Limpiar buffer

                    // Se pasa solo el nombre y el precio
                    carrito.agregarProducto(new Producto(nombreProd, precioProd));
                    System.out.println("✅ ¡Producto agregado con éxito al carrito!");
                    break;

                case 2:
                    Producto masCaro = carrito.obtenerMayorPrecio();
                    if (masCaro != null) {
                        System.out.println("\n🔥 El producto de mayor precio es: " + masCaro);
                    } else {
                        System.out.println("\n📭 El carrito está vacío.");
                    }
                    break;

                case 3:
                    double total = carrito.calcularTotal();
                    System.out.println("\n💰 El precio total acumulado es: $" + total);
                    break;

                case 4:
                    System.out.println("\n📋 --- PRODUCTOS EN EL CARRITO (RECORRIDO PROPIO) ---");
                    boolean hayElementos = false;
                    
                    // Gracias a que Carrito implementa Iterable y usa CarritoIterator, podemos usar este for-each
                    for (Producto p : carrito) {
                        System.out.println("• " + p);
                        hayElementos = true;
                    }
                    
                    if (!hayElementos) {
                        System.out.println("📭 No hay productos registrados aún.");
                    }
                    break;

                case 5:
                    System.out.println("\n👋 Saliendo del sistema... ¡Gracias por tu compra!");
                    break;

                default:
                    System.out.println("⚠️ Opción no válida. Por favor digita un número del 1 al 5.");
            }
        }

        teclado.close();
    }
}