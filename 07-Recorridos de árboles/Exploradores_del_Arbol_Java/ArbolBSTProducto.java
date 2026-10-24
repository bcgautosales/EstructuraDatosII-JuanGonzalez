import java.util.LinkedList;
import java.util.Queue;

// Árbol binario de búsqueda (BST) para organizar productos por código.
public class ArbolBSTProducto {
    // La raíz es el primer nodo y el punto de entrada al árbol.
    private NodoProducto raiz;

    // Método público para insertar un producto desde Main.
    public void insertar(Producto producto) {
        raiz = insertarRec(raiz, producto);
    }

    // Busca recursivamente el lugar correcto para el producto.
    private NodoProducto insertarRec(NodoProducto nodo, Producto producto) {
        // Si llegamos a un espacio vacío, aquí se crea el nuevo nodo.
        if (nodo == null) {
            return new NodoProducto(producto);
        }

        int nuevo = producto.getCodigo();
        int actual = nodo.getProducto().getCodigo();

        // Los códigos menores se guardan a la izquierda.
        if (nuevo < actual) {
            nodo.setIzquierdo(insertarRec(nodo.getIzquierdo(), producto));
        // Los códigos mayores se guardan a la derecha.
        } else if (nuevo > actual) {
            nodo.setDerecho(insertarRec(nodo.getDerecho(), producto));
        // En este ejemplo no permitimos dos productos con el mismo código.
        } else {
            System.out.println("El código " + nuevo + " ya existe.");
        }

        return nodo; // Devolvemos el nodo para conservar la estructura del árbol.
    }

    // PREORDEN: primero la raíz, luego la izquierda y después la derecha.
    public void preorden() {
        System.out.println("\nPREORDEN:");
        preordenRec(raiz);
        System.out.println();
    }

    private void preordenRec(NodoProducto nodo) {
        // Si el nodo es null, no hay nada que visitar en esa rama.
        if (nodo != null) {
            System.out.print(nodo.getProducto() + "  "); // 1. Visita el nodo actual.
            preordenRec(nodo.getIzquierdo());             // 2. Recorre la izquierda.
            preordenRec(nodo.getDerecho());               // 3. Recorre la derecha.
        }
    }

    // INORDEN: izquierda, raíz y derecha.
    // En un BST, este orden muestra los códigos de menor a mayor.
    public void inorden() {
        System.out.println("\nINORDEN:");
        inordenRec(raiz);
        System.out.println();
    }

    private void inordenRec(NodoProducto nodo) {
        if (nodo != null) {
            inordenRec(nodo.getIzquierdo());              // 1. Visita primero la izquierda.
            System.out.print(nodo.getProducto() + "  "); // 2. Después muestra el actual.
            inordenRec(nodo.getDerecho());                // 3. Por último visita la derecha.
        }
    }

    // POSTORDEN: primero izquierda, luego derecha y al final la raíz.
    public void postorden() {
        System.out.println("\nPOSTORDEN:");
        postordenRec(raiz);
        System.out.println();
    }

    private void postordenRec(NodoProducto nodo) {
        if (nodo != null) {
            postordenRec(nodo.getIzquierdo());             // 1. Recorre la izquierda.
            postordenRec(nodo.getDerecho());               // 2. Recorre la derecha.
            System.out.print(nodo.getProducto() + "  "); // 3. Muestra el actual al final.
        }
    }

    // POR NIVELES: visita primero la raíz y luego cada nivel de izquierda a derecha.
    // Para mantener ese orden se utiliza una cola (primero en entrar, primero en salir).
    public void porNiveles() {
        System.out.println("\nPOR NIVELES:");

        // Caso especial: si no hay raíz, el árbol está vacío.
        if (raiz == null) {
            System.out.println("El árbol está vacío.");
            return;
        }

        Queue<NodoProducto> cola = new LinkedList<>();
        cola.offer(raiz); // Empezamos agregando la raíz a la cola.

        while (!cola.isEmpty()) { // Repetimos mientras queden nodos por visitar.
            NodoProducto actual = cola.poll(); // Sacamos el primer nodo de la cola.
            System.out.print(actual.getProducto() + "  "); // Visitamos ese producto.

            // Agregamos primero el hijo izquierdo, si existe.
            if (actual.getIzquierdo() != null) {
                cola.offer(actual.getIzquierdo());
            }
            // Después agregamos el hijo derecho, si existe.
            if (actual.getDerecho() != null) {
                cola.offer(actual.getDerecho());
            }
        }
        System.out.println();
    }

    // Comprueba que Inorden produzca códigos estrictamente ascendentes.
    public boolean comprobarInorden() {
        // El arreglo guarda el último código visitado y permite actualizarlo
        // dentro de las llamadas recursivas.
        return comprobarOrden(raiz, new int[]{Integer.MIN_VALUE});
    }

    private boolean comprobarOrden(NodoProducto nodo, int[] anterior) {
        // Un espacio vacío no rompe el orden: se considera correcto.
        if (nodo == null) return true;

        // Primero revisamos todos los códigos de la izquierda.
        if (!comprobarOrden(nodo.getIzquierdo(), anterior)) return false;

        int codigoActual = nodo.getProducto().getCodigo();
        // Si el actual no es mayor que el anterior, el orden está mal.
        if (codigoActual <= anterior[0]) return false;

        anterior[0] = codigoActual; // Guardamos el código para compararlo con el siguiente.
        // Finalmente comprobamos la rama derecha.
        return comprobarOrden(nodo.getDerecho(), anterior);
    }
}
