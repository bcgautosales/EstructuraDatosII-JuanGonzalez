
/**
 * Almacena el resultado de una búsqueda realizada en el árbol BST.
 *
 * Guarda el producto encontrado, la cantidad de comparaciones
 * efectuadas y el camino recorrido durante la búsqueda.
 */
public class ResultadoBusqueda {

    // Producto encontrado. Será null si el código no existe.
    private final Producto producto;

    // Número de nodos comparados durante la búsqueda.
    private final int comparaciones;

    // Secuencia de códigos visitados, en orden.
    private final String camino;

    /**
     * Construye un resultado de búsqueda.
     *
     * @param producto producto encontrado o null si no existe
     * @param comparaciones cantidad de comparaciones realizadas
     * @param camino recorrido de la búsqueda en el árbol
     */
    public ResultadoBusqueda(
            Producto producto,
            int comparaciones,
            String camino) {

        // No puede haber una cantidad negativa de comparaciones.
        if (comparaciones < 0) {
            throw new IllegalArgumentException(
                    "Las comparaciones no pueden ser negativas."
            );
        }

        // El camino no debe ser null.
        if (camino == null) {
            throw new IllegalArgumentException(
                    "El camino de búsqueda no puede ser null."
            );
        }

        this.producto = producto;
        this.comparaciones = comparaciones;
        this.camino = camino;
    }

    /**
     * Indica si la búsqueda encontró el producto solicitado.
     *
     * @return true si existe un producto; false en caso contrario
     */
    public boolean encontrado() {
        return producto != null;
    }

    /**
     * Devuelve el producto encontrado.
     *
     * @return producto encontrado o null si no existe
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     * Devuelve el número de comparaciones realizadas.
     *
     * @return cantidad de comparaciones
     */
    public int getComparaciones() {
        return comparaciones;
    }

    /**
     * Devuelve el recorrido efectuado durante la búsqueda.
     *
     * @return camino seguido por el algoritmo
     */
    public String getCamino() {
        return camino;
    }
}
