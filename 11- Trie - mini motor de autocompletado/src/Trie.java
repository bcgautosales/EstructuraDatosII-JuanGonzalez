import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Trie para insertar palabras, buscarlas y sugerir palabras por prefijo.
 *
 * Las palabras se guardan en minúsculas para que "Casa" y "casa"
 * se traten de la misma manera.
 */
public class Trie {

    // La raíz no representa una letra; es el punto inicial del árbol.
    private final NodoTrie raiz = new NodoTrie();

    /**
     * Inserta una palabra caracter por caracter.
     */
    public void insertar(String palabra) {
        if (palabra == null || palabra.trim().isEmpty()) {
            return; // No insertamos palabras vacías.
        }

        String palabraNormalizada = palabra.trim().toLowerCase();
        NodoTrie actual = raiz;

        // Recorremos cada caracter de la palabra.
        for (char caracter : palabraNormalizada.toCharArray()) {
            // Si no existe un camino para este caracter, se crea un nodo.
            actual.hijos.putIfAbsent(caracter, new NodoTrie());

            // Avanzamos al nodo correspondiente al caracter.
            actual = actual.hijos.get(caracter);
        }

        // Marcamos que aquí termina una palabra completa.
        actual.finPalabra = true;
    }

    /**
     * Devuelve true si la palabra completa existe en el Trie.
     * No basta con que exista su prefijo: también debe ser fin de palabra.
     */
    public boolean buscar(String palabra) {
        if (palabra == null || palabra.trim().isEmpty()) {
            return false;
        }

        NodoTrie nodo = buscarNodo(palabra.trim().toLowerCase());
        return nodo != null && nodo.finPalabra;
    }

    /**
     * Devuelve true si alguna palabra almacenada empieza con el prefijo.
     * Un prefijo puede existir aunque no sea una palabra completa.
     */
    public boolean empiezaCon(String prefijo) {
        if (prefijo == null) {
            return false;
        }

        // El prefijo vacío corresponde a la raíz.
        return buscarNodo(prefijo.trim().toLowerCase()) != null;
    }

    /**
     * Sugiere hasta maxResultados palabras que comiencen por el prefijo.
     */
    public List<String> sugerir(String prefijo, int maxResultados) {
        List<String> sugerencias = new ArrayList<>();

        if (prefijo == null || maxResultados <= 0) {
            return sugerencias;
        }

        String prefijoNormalizado = prefijo.trim().toLowerCase();
        NodoTrie nodoPrefijo = buscarNodo(prefijoNormalizado);

        // Si el prefijo no está en el árbol, no hay sugerencias.
        if (nodoPrefijo == null) {
            return sugerencias;
        }

        // Buscamos palabras completas descendiendo desde el nodo del prefijo.
        recolectarPalabras(nodoPrefijo, prefijoNormalizado,
                          sugerencias, maxResultados);

        // Ordenamos alfabéticamente para que la salida sea fácil de leer.
        Collections.sort(sugerencias);
        // El recorrido se detiene al alcanzar el límite solicitado.
        if (sugerencias.size() > maxResultados) {
            return new ArrayList<>(sugerencias.subList(0, maxResultados));
        }
        return sugerencias;
    }

    /**
     * Versión cómoda: sugiere como máximo cinco palabras.
     */
    public List<String> sugerir(String prefijo) {
        return sugerir(prefijo, 5);
    }

    /**
     * Recorre el Trie y reúne las palabras que terminan en los nodos visitados.
     */
    private void recolectarPalabras(NodoTrie nodo, String palabraActual,
                                   List<String> resultado, int limite) {
        if (resultado.size() >= limite) {
            return;
        }

        // Si este nodo marca el final de una palabra, la guardamos.
        if (nodo.finPalabra) {
            resultado.add(palabraActual);
            if (resultado.size() >= limite) {
                return;
            }
        }

        // Recorremos los hijos en orden alfabético para resultados previsibles.
        List<Character> caracteres = new ArrayList<>(nodo.hijos.keySet());
        Collections.sort(caracteres);

        for (char caracter : caracteres) {
            if (resultado.size() >= limite) {
                return;
            }

            recolectarPalabras(nodo.hijos.get(caracter),
                              palabraActual + caracter, resultado, limite);
        }
    }

    /**
     * Busca el nodo al que se llega después de recorrer una cadena.
     * Devuelve null si algún caracter no existe.
     */
    private NodoTrie buscarNodo(String cadena) {
        NodoTrie actual = raiz;

        for (char caracter : cadena.toCharArray()) {
            actual = actual.hijos.get(caracter);

            if (actual == null) {
                return null;
            }
        }

        return actual;
    }
}
