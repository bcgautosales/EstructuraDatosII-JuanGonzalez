import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Representa un nodo de un arbol general de videojuegos.
 *
 * @param <T> tipo de dato almacenado en el nodo.
 */
public class NodoGeneral<T> {

    private final T dato;
    private final List<NodoGeneral<T>> hijos;

    public NodoGeneral(T dato) {
        this.dato = dato;
        this.hijos = new ArrayList<>();
    }

    public T getDato() {
        return dato;
    }

    public void agregarHijo(NodoGeneral<T> hijo) {
        if (hijo == null) {
            throw new IllegalArgumentException(
                    "El hijo no puede ser null."
            );
        }

        // CAMBIO: se explica la relacion padre-hijo.
        // El nodo actual sera el padre del nodo agregado.
        // El nodo agregado sera hijo del nodo actual.
        hijos.add(hijo);
    }

    public List<NodoGeneral<T>> getHijos() {
        return Collections.unmodifiableList(hijos);
    }

    public boolean esHoja() {
        // CAMBIO: una hoja es un nodo sin hijos.
        // Ejemplo: un proyecto de videojuego sin subproyectos.
        return hijos.isEmpty();
    }

    public int grado() {
        // CAMBIO: el grado es la cantidad de hijos directos.
        return hijos.size();
    }

    @Override
    public String toString() {
        return String.valueOf(dato);
    }

    /*
     * CAMBIO: conceptos de parentesco en un arbol.
     *
     * PADRE:
     * Nodo que tiene uno o varios hijos directos.
     *
     * HIJO:
     * Nodo que depende directamente de otro nodo.
     *
     * HERMANOS:
     * Nodos que comparten el mismo padre.
     *
     * PRIMOS:
     * En el uso familiar del termino, son hijos de hermanos.
     * En un arbol, serian nodos cuyos padres son hermanos.
     *
     * RAIZ:
     * Nodo principal del arbol; no tiene padre dentro del arbol.
     *
     * HOJA:
     * Nodo que no tiene hijos.
     *
     * IMPORTANTE:
     * Esta clase almacena los hijos, pero no guarda una referencia
     * directa al padre ni calcula hermanos o primos.
     */
}