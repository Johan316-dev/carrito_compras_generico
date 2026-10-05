import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CarritoCompras<T extends Producto> implements Iterable<T> {

    private String nombre;
    private List<Producto> productos;

    public CarritoCompras(String nombre) {
        this.nombre = nombre;
        this.productos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarProducto(Producto producto) {
        this.productos.add(producto);
    }

    public Producto obtenerMayorPrecio() {
        if (productos.isEmpty()) {
            return null;
        }
        Producto mayor = productos.get(0);
        for (Producto p : productos) {
            if (p.getPrecio() > mayor.getPrecio()) {
                mayor = p;
            }
        }
        return mayor;
    }

    public double calcularPrecioTotal() {
        double total = 0.0;
        for (Producto p : productos) {
            total += p.getPrecio();
        }
        return total;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Iterator<T> iterator() {
        return (Iterator<T>) new CarritoIterator<>(productos);
    }
}