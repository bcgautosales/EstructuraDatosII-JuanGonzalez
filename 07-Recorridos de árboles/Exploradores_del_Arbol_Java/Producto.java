// Esta clase representa un producto de la tienda.
public class Producto {
    private int codigo;       // Identificador que se usa para ordenar el árbol.
    private String nombre;    // Nombre que se muestra en pantalla.
    private double precio;    // Precio del producto.

    // El constructor recibe los datos cuando creamos un producto con new Producto(...).
    public Producto(int codigo, String nombre, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    // Estos métodos permiten consultar los datos privados del producto.
    public int getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }

    // Define cómo se verá el producto cuando se imprima en la consola.
    @Override
    public String toString() {
        return codigo + " - " + nombre + " ($" + precio + ")";
    }
}
