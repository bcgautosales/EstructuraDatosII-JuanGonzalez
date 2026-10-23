
/**
 * Representa un producto que puede almacenarse en el catálogo.
 *
 * Cada producto tiene un código único de identificación,
 * un nombre, una categoría y un precio.
 */
public class Producto {

    // Código numérico que identifica al producto en el catálogo.
    private final int codigo;

    // Nombre comercial del producto.
    private final String nombre;

    // Categoría a la que pertenece, por ejemplo, Periféricos.
    private final String categoria;

    // Precio del producto expresado como número decimal.
    private final double precio;

    /**
     * Crea un producto con sus datos principales.
     *
     * @param codigo identificador numérico del producto
     * @param nombre nombre del producto
     * @param categoria categoría del producto
     * @param precio precio del producto
     * @throws IllegalArgumentException si los datos no son válidos
     */
    public Producto(int codigo, String nombre,
                    String categoria, double precio) {

        // Comprobamos que el código sea positivo.
        if (codigo <= 0) {
            throw new IllegalArgumentException(
                    "El código debe ser mayor que cero."
            );
        }

        // Validamos que el nombre tenga contenido.
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException(
                    "El nombre no puede estar vacío."
            );
        }

        // Validamos que la categoría tenga contenido.
        if (categoria == null || categoria.isBlank()) {
            throw new IllegalArgumentException(
                    "La categoría no puede estar vacía."
            );
        }

        // Evitamos precios negativos, infinitos o no numéricos.
        if (!Double.isFinite(precio) || precio < 0) {
            throw new IllegalArgumentException(
                    "El precio debe ser un número válido y no negativo."
            );
        }

        // Guardamos los datos recibidos en los atributos.
        this.codigo = codigo;
        this.nombre = nombre.trim();
        this.categoria = categoria.trim();
        this.precio = precio;
    }

    /**
     * Devuelve el código identificador.
     *
     * @return código del producto
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Devuelve el nombre del producto.
     *
     * @return nombre del producto
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve la categoría del producto.
     *
     * @return categoría del producto
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Devuelve el precio del producto.
     *
     * @return precio del producto
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Convierte los datos del producto en un texto legible.
     *
     * Este método se utiliza cuando imprimimos un producto
     * mediante System.out.println().
     *
     * @return información del producto en una sola línea
     */
    @Override
    public String toString() {
        return codigo + " - " + nombre + " - " + categoria
                + " - $" + String.format(java.util.Locale.US, "%.2f", precio);
    }
}
