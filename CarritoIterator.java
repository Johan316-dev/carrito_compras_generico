import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class CarritoIterator<T> implements Iterator<T> {
    private List<T> productos;
    private int posicion;

    public CarritoIterator(List<T> productos) {
        this.productos = productos;
        this.posicion = 0;
    }

    @Override
    public boolean hasNext() {
        return posicion < productos.size();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No hay más elementos en el carrito");
        }
        return productos.get(posicion++);
    }
}