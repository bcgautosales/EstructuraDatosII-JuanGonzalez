// Un nodo es una posición del árbol que guarda un producto y conecta con sus hijos.
public class NodoProducto {
    private Producto producto;          // Información guardada en este nodo.
    private NodoProducto izquierdo;      // Hijo con código menor.
    private NodoProducto derecho;        // Hijo con código mayor.

    // Al crear un nodo, le asignamos el producto que va a guardar.
    public NodoProducto(Producto producto) {
        this.producto = producto;
    }

    // Métodos get: sirven para consultar el producto y sus hijos.
    public Producto getProducto() { return producto; }
    public NodoProducto getIzquierdo() { return izquierdo; }
    public NodoProducto getDerecho() { return derecho; }

    // Métodos set: sirven para conectar un hijo a la izquierda o a la derecha.
    public void setIzquierdo(NodoProducto izquierdo) { this.izquierdo = izquierdo; }
    public void setDerecho(NodoProducto derecho) { this.derecho = derecho; }
}
