import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Carrito<T extends Producto> implements Iterable<T> {
    private String nombre;
    private List<T> productos;

    public Carrito(String nombre) {
        this.nombre = nombre;
        this.productos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void agregarProducto(T producto) {
        productos.add(producto);
    }

    public void eliminarProducto(T producto) {
        productos.remove(producto);
    }

    public double calcularTotal() {
        double total = 0;
        for (T producto : productos) {
            total += producto.getPrecio();
        }
        return total;
    }

    public T obtenerMayorPrecio() {
        if (productos.isEmpty()) {
            return null;
        }
        T mayor = productos.get(0);
        for (T p : productos) {
            if (p.compareTo(mayor) > 0) {
                mayor = p;
            }
        }
        return mayor;
    }

    public List<T> getProductos() {
        return productos;
    }

    @Override
    public Iterator<T> iterator() {
        return new CarritoIterator<>(productos);
    }
}