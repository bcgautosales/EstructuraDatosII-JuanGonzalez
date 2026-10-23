
/**
 * Representa un nodo del árbol binario de búsqueda del catálogo.
 *
 * Cada nodo almacena un producto y referencias a sus dos posibles
 * hijos: izquierdo y derecho.
 */
public class NodoProducto {

    // Producto almacenado en este nodo.
    private Producto producto;

    // Referencia al hijo izquierdo del nodo.
    // Aquí se ubican los códigos menores que el código actual.
    private NodoProducto izquierdo;

    // Referencia al hijo derecho del nodo.
    // Aquí se ubican los códigos mayores que el código actual.
    private NodoProducto derecho;

    /**
     * Construye un nodo con el producto recibido.
     *
     * Al crear el nodo, sus hijos quedan en null porque todavía
     * no tiene otros nodos conectados.
     *
     * @param producto producto que se almacenará en el nodo
     * @throws IllegalArgumentException si el producto es null
     */
    public NodoProducto(Producto producto) {

        // No permitimos crear un nodo sin un producto válido.
        if (producto == null) {
            throw new IllegalArgumentException(
                    "El producto del nodo no puede ser null."
            );
        }

        this.producto = producto;

        // Inicialmente el nodo no tiene hijos.
        this.izquierdo = null;
        this.derecho = null;
    }

    /**
     * Devuelve el producto almacenado en el nodo.
     *
     * @return producto del nodo
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     * Devuelve el hijo izquierdo.
     *
     * @return nodo hijo izquierdo o null si no existe
     */
    public NodoProducto getIzquierdo() {
        return izquierdo;
    }

    /**
     * Devuelve el hijo derecho.
     *
     * @return nodo hijo derecho o null si no existe
     */
    public NodoProducto getDerecho() {
        return derecho;
    }

    /**
     * Asigna un nodo como hijo izquierdo.
     *
     * @param izquierdo nodo que se conectará a la izquierda
     */
    public void setIzquierdo(NodoProducto izquierdo) {
        this.izquierdo = izquierdo;
    }

    /**
     * Asigna un nodo como hijo derecho.
     *
     * @param derecho nodo que se conectará a la derecha
     */
    public void setDerecho(NodoProducto derecho) {
        this.derecho = derecho;
    }
}
