public class Producto implements Comparable<Producto> {
    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // Permite comparar dos productos según su precio para obtener el mayor
    @Override
    public int compareTo(Producto otro) {
        return Double.compare(this.precio, otro.getPrecio());
    }

    @Override
    public String toString() {
        return nombre + " ($" + precio + ")";
    }
}