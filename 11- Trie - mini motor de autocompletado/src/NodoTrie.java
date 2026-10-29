import java.util.HashMap;
import java.util.Map;

/**
 * Representa un nodo dentro del Trie.
 *
 * Cada nodo guarda:
 * 1. Sus hijos: un mapa que relaciona un caracter con el siguiente nodo.
 * 2. finPalabra: indica si al llegar a este nodo termina una palabra completa.
 */
public class NodoTrie {

    // Por ejemplo, si el nodo tiene la letra 'c', su mapa puede guardar
    // los nodos que continúan con 'a', 'o', 'h', etc.
    Map<Character, NodoTrie> hijos = new HashMap<>();

    // Es true únicamente cuando aquí termina una palabra insertada.
    boolean finPalabra = false;
}
